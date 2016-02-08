package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.core.TLBool;
import com.github.badoualy.telegram.tl.core.TLBytes;
import com.github.badoualy.telegram.tl.core.TLIntVector;
import com.github.badoualy.telegram.tl.core.TLLongVector;
import com.github.badoualy.telegram.tl.core.TLObject;
import com.github.badoualy.telegram.tl.core.TLStringVector;
import com.github.badoualy.telegram.tl.core.TLVector;

import org.apache.commons.lang3.RandomStringUtils;
import org.reflections.Reflections;
import org.reflections.util.ClasspathHelper;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

public class TestUtils {

    private static final String BASE_PACKAGE = "com.github.badoualy.telegram.tl.api";
    public static List<Class<? extends TLObject>> constructorList;
    public static Random random;
    public static Reflections reflections;

    public static void init() {
        random = new PositiveRandom(System.currentTimeMillis());

        System.out.println("Looking for tl api classes in package " + BASE_PACKAGE);
        ArrayList<URL> urls = new ArrayList<>();
        urls.addAll(ClasspathHelper.forPackage(BASE_PACKAGE));
        urls.addAll(ClasspathHelper.forPackage(BASE_PACKAGE + ".account"));
        urls.addAll(ClasspathHelper.forPackage(BASE_PACKAGE + ".auth"));
        urls.addAll(ClasspathHelper.forPackage(BASE_PACKAGE + ".channels"));
        urls.addAll(ClasspathHelper.forPackage(BASE_PACKAGE + ".contacts"));
        urls.addAll(ClasspathHelper.forPackage(BASE_PACKAGE + ".help"));
        urls.addAll(ClasspathHelper.forPackage(BASE_PACKAGE + ".messages"));
        urls.addAll(ClasspathHelper.forPackage(BASE_PACKAGE + ".photos"));
        urls.addAll(ClasspathHelper.forPackage(BASE_PACKAGE + ".request"));
        urls.addAll(ClasspathHelper.forPackage(BASE_PACKAGE + ".storage"));
        urls.addAll(ClasspathHelper.forPackage(BASE_PACKAGE + ".updates"));
        urls.addAll(ClasspathHelper.forPackage(BASE_PACKAGE + ".upload"));
        reflections = new Reflections(urls);

        Set<Class<? extends TLObject>> classList = reflections.getSubTypesOf(TLObject.class);
        System.out.println("Found " + classList.size() + " classes");
        constructorList = classList.stream()
                                   .filter(clazz -> (clazz.getModifiers() & Modifier.ABSTRACT) == 0)
                                   .filter(clazz -> !clazz.getPackage().getName().equalsIgnoreCase("com.github.badoualy.telegram.tl.core"))
                                   .filter(clazz -> !clazz.getSimpleName().equalsIgnoreCase("TLRequestInvokeAfterMsg"))
                                   .filter(clazz -> !clazz.getSimpleName().equalsIgnoreCase("TLRequestInvokeAfterMsgs"))
                                   .filter(clazz -> !clazz.getSimpleName().equalsIgnoreCase("TLRequestInitConnection"))
                                   .filter(clazz -> !clazz.getSimpleName().equalsIgnoreCase("TLRequestInvokeWithoutUpdates"))
                                   .filter(clazz -> !clazz.getSimpleName().equalsIgnoreCase("TLRequestInvokeWithLayer"))
                                   .sorted((o1, o2) -> o1.getSimpleName().compareTo(o2.getSimpleName()))
                                   .collect(Collectors.toList());
        System.out.println("Found " + constructorList.size() + " non abstract classes");
    }

    public static TLObject getRandomTLObject(Class<? extends TLObject> clazz) throws Exception {
        if (clazz == TLBool.FALSE.getClass()) return TLBool.FALSE;
        if (clazz == TLBool.TRUE.getClass()) return TLBool.TRUE;

        TLObject object = newInstanceOf(clazz);

        // Get class + superclass fields
        List<Field> fields = new ArrayList<>();
        Collections.addAll(fields, clazz.getDeclaredFields());
        if (clazz.getSuperclass() != TLObject.class)
            Collections.addAll(fields, clazz.getSuperclass().getDeclaredFields());

        fields.stream()
              .filter(field -> !field.getName().equalsIgnoreCase("flags"))
              .filter(field -> ((field.getModifiers() & Modifier.STATIC) == 0))
              .forEach(field -> {
                  field.setAccessible(true);
                  try {
                      field.set(object, getRandom(field.getType(), field));
                  } catch (Exception e) {
                      throw new RuntimeException(e);
                  }
              });

        return object;
    }

    @SuppressWarnings("unchecked")
    public static <T extends TLObject> T newInstanceOf(Class<T> clazz) throws Exception {
        for (Constructor<?> c : clazz.getConstructors()) {
            if (c.getParameterCount() == 0) {
                c.setAccessible(true);
                return (T) c.newInstance();
            }
        }

        throw new RuntimeException("No constructor found for type " + clazz.getSimpleName());
    }

    @SuppressWarnings("unchecked")
    public static TLVector getRandomTLVector(Class<?> clazz) throws Exception {
        TLVector obj;
        if (is(clazz, Integer.class)) obj = new TLIntVector();
        else if (is(clazz, Long.class)) obj = new TLLongVector();
        else if (is(clazz, String.class)) obj = new TLStringVector();
        else obj = new TLVector(clazz);

        int size = random.nextInt(10) + 2;
        for (int i = 0; i < size; i++)
            obj.add(getRandom(clazz, null));

        return obj;
    }

    @SuppressWarnings("unchecked")
    public static <T> T getRandom(Class<T> type, Field field) throws Exception {
        // Base types
        if (is(type, int.class, Integer.class))
            return (T) Integer.valueOf(random.nextInt());
        if (is(type, long.class, Long.class))
            return (T) Long.valueOf(random.nextLong());
        if (is(type, float.class, Float.class))
            return (T) Float.valueOf(random.nextFloat());
        if (is(type, double.class, Double.class))
            return (T) Double.valueOf(random.nextDouble());
        if (is(type, boolean.class, Boolean.class))
            return (T) Boolean.valueOf(random.nextBoolean());
        if (is(type, String.class))
            return (T) RandomStringUtils.random(random.nextInt(25) + 5, true, true);
        if (is(type, TLBytes.class)) {
            byte[] bytes = new byte[random.nextInt(256)];
            random.nextBytes(bytes);
            return (T) new TLBytes(bytes);
        }

        // Vector
        if (is(type, TLIntVector.class))
            return (T) getRandomTLVector(Integer.class);
        if (is(type, TLLongVector.class))
            return (T) getRandomTLVector(Long.class);
        if (is(type, TLStringVector.class))
            return (T) getRandomTLVector(String.class);
        if (is(type, TLVector.class)) {
            ParameterizedType genericType = (ParameterizedType) field.getGenericType();
            Type vectorType = ((WildcardType) genericType.getActualTypeArguments()[0]).getUpperBounds()[0];
            return (T) getRandomTLVector((Class<?>) vectorType);
        }

        if (TLObject.class.isAssignableFrom(type)) {
            if ((type.getModifiers() & Modifier.ABSTRACT) != 0) {
                // Abstract, not a real constructor, get a random one
                Set<Class<? extends T>> subtypes = reflections.getSubTypesOf(type);
                int randomIndex = random.nextInt(subtypes.size());
                return (T) getRandomTLObject((Class<? extends TLObject>) subtypes.toArray()[randomIndex]);
            }

            return (T) getRandomTLObject((Class<? extends TLObject>) type);
        }

        throw new RuntimeException("Unsupported type " + type.getName());
    }

    public static boolean is(Class<?> type, Class<?>... types) {
        for (Class<?> clazz : types) {
            if (type == clazz)
                return true;
        }

        return false;
    }

    private static class PositiveRandom extends Random {

        public PositiveRandom(long seed) {
            super(seed);
        }

        @Override
        public int nextInt() {
            return super.next(Integer.MAX_VALUE - 1);
        }

        @Override
        public long nextLong() {
            return super.next(Integer.MAX_VALUE - 1);
        }

        @Override
        public double nextDouble() {
            return Double.longBitsToDouble(nextLong());
        }

        @Override
        public float nextFloat() {
            return (float) nextDouble();
        }
    }
}
