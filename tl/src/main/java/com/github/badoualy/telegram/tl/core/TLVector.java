package com.github.badoualy.telegram.tl.core;

import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.*;

import static com.github.badoualy.telegram.tl.StreamUtils.*;

/**
 * Basic vector type in TL language
 * For working with primitive internal types you might instantiate class TLIntVector, TLStringVector, TLLongVector for
 * vector of integer, strings or long.
 *
 * @param <T> type of elements in vector
 * @author Korshakov Stepan <me@ex3ndr.com>
 */
public class TLVector<T> extends TLObject implements List<T> {

    public static final int CLASS_ID = 0x1cb5c415;

    private Class destClass = TLObject.class;
    private ArrayList<T> items = new ArrayList<T>();

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public Class getDestClass() {
        return destClass;
    }

    public void setDestClass(Class destClass) {
        if (destClass == null) {
            throw new RuntimeException("DestClass could not be null");
        } else if (destClass != Integer.class && destClass != Long.class && destClass != String.class && !TLObject.class.isAssignableFrom(destClass)) {
            throw new RuntimeException("Unsupported DestClass");
        }
        this.destClass = destClass;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeInt(items.size(), stream);
        if (destClass == Integer.class) {
            for (T i : items) {
                writeInt((Integer) i, stream);
            }
        } else if (destClass == Long.class) {
            for (T i : items) {
                writeLong((Long) i, stream);
            }
        } else if (destClass == String.class) {
            for (T i : items) {
                writeTLString((String) i, stream);
            }
        } else {
            for (T i : items) {
                writeTLObject((TLObject) i, stream);
            }
        }
    }

    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        if (destClass == null) {
            throw new IOException("DestClass not set");
        }
        int count = readInt(stream);
        for (int i = 0; i < count; i++) {
            if (destClass == Integer.class) {
                items.add((T) (Integer) readInt(stream));
            } else if (destClass == Long.class) {
                items.add((T) (Long) readLong(stream));
            } else if (destClass == String.class) {
                items.add((T) readTLString(stream));
            } else {
                items.add((T) context.deserializeMessage(stream));
            }
        }
    }

    // List implementations

    @Override
    public int size() {
        return items.size();
    }

    @Override
    public boolean isEmpty() {
        return items.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return items.contains(o);
    }

    @Override
    public Iterator<T> iterator() {
        return items.iterator();
    }

    @Override
    public Object[] toArray() {
        return items.toArray();
    }

    @Override
    public <T1> T1[] toArray(T1[] t1s) {
        return items.toArray(t1s);
    }

    @Override
    public boolean add(T t) {
        return items.add(t);
    }

    @Override
    public boolean remove(Object o) {
        return items.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> objects) {
        return items.containsAll(objects);
    }

    @Override
    public boolean addAll(Collection<? extends T> ts) {
        return items.addAll(ts);
    }

    @Override
    public boolean addAll(int i, Collection<? extends T> ts) {
        return items.addAll(i, ts);
    }

    @Override
    public boolean removeAll(Collection<?> objects) {
        return items.removeAll(objects);
    }

    @Override
    public boolean retainAll(Collection<?> objects) {
        return items.retainAll(objects);
    }

    @Override
    public void clear() {
        items.clear();
    }

    @Override
    public T get(int i) {
        return items.get(i);
    }

    @Override
    public T set(int i, T t) {
        return items.set(i, t);
    }

    @Override
    public void add(int i, T t) {
        items.add(i, t);
    }

    @Override
    public T remove(int i) {
        return items.remove(i);
    }

    @Override
    public int indexOf(Object o) {
        return items.indexOf(o);
    }

    @Override
    public int lastIndexOf(Object o) {
        return items.lastIndexOf(o);
    }

    @Override
    public ListIterator<T> listIterator() {
        return items.listIterator();
    }

    @Override
    public ListIterator<T> listIterator(int i) {
        return items.listIterator(i);
    }

    @Override
    public List<T> subList(int i, int i2) {
        return items.subList(i, i2);
    }

    @Override
    public String toString() {
        return "vector#1cb5c415";
    }
}
