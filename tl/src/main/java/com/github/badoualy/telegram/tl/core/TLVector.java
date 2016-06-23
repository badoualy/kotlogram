package com.github.badoualy.telegram.tl.core;

import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32;

/**
 * Basic vector type in TL language
 * For working with primitive internal types you might instantiate class TLIntVector, TLStringVector, TLLongVector for
 * vector of integer, strings or long.
 *
 * @param <T> type of elements in vector
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
@SuppressWarnings("NullableProblems")
public class TLVector<T> extends TLObject implements List<T> {

    public static final transient TLVector EMPTY_ARRAY = new TLVector();

    public static final int CONSTRUCTOR_ID = 0x1cb5c415;

    protected final Class itemClazz;
    protected final ArrayList<T> items = new ArrayList<>();

    public TLVector() {
        itemClazz = TLObject.class;
    }

    public TLVector(Class<T> destClass) {
        if (destClass != null) {
            if (destClass != Integer.class && destClass != Long.class && destClass != String.class
                    && !TLObject.class.isAssignableFrom(destClass)) {
                throw new RuntimeException("Unsupported vector type: " + destClass.getSimpleName());
            }
            itemClazz = destClass;
        } else
            itemClazz = TLObject.class;
    }

    @Override
    public String toString() {
        return "vector#1cb5c415";
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    @Override
    public final void serializeBody(OutputStream stream) throws IOException {
        writeInt(items.size(), stream);
        for (T i : items)
            serializeItem(i, stream);
    }

    protected void serializeItem(T item, OutputStream stream) throws IOException {
        writeTLObject((TLObject) item, stream);
    }

    @SuppressWarnings("unchecked")
    @Override
    public final void deserializeBody(InputStream stream, TLContext context) throws IOException {
        int count = readInt(stream);
        for (int i = 0; i < count; i++)
            items.add(deserializeItem(stream, context));
    }

    @SuppressWarnings("unchecked")
    protected T deserializeItem(InputStream stream, TLContext context) throws IOException {
        return (T) context.deserializeMessage(stream);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID + SIZE_INT32; // Size
        for (T item : items)
            size += ((TLObject) item).computeSerializedSize();
        return size;
    }

    ////////////////////////////////////////////////////////////
    ///////////////////////// DELEGATE /////////////////////////
    ////////////////////////////////////////////////////////////
    public void trimToSize() {
        items.trimToSize();
    }

    public void ensureCapacity(int minCapacity) {
        items.ensureCapacity(minCapacity);
    }

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
    public int indexOf(Object o) {
        return items.indexOf(o);
    }

    @Override
    public int lastIndexOf(Object o) {
        return items.lastIndexOf(o);
    }

    @SuppressWarnings("CloneDoesntCallSuperClone")
    @Override
    public Object clone() {
        TLVector<T> vector = new TLVector<>();
        vector.addAll(new ArrayList<>(items));
        return vector;
    }

    @Override
    public Object[] toArray() {
        return items.toArray();
    }

    @SuppressWarnings("SuspiciousToArrayCall")
    @Override
    public <T1> T1[] toArray(T1[] a) {
        return items.toArray(a);
    }

    @Override
    public T get(int index) {
        return items.get(index);
    }

    @Override
    public T set(int index, T element) {
        return items.set(index, element);
    }

    @Override
    public boolean add(T t) {
        return items.add(t);
    }

    @Override
    public void add(int index, T element) {
        items.add(index, element);
    }

    @Override
    public T remove(int index) {
        return items.remove(index);
    }

    @Override
    public boolean remove(Object o) {
        return items.remove(o);
    }

    @Override
    public void clear() {
        items.clear();
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return items.addAll(c);
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        return items.addAll(index, c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return items.removeAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return items.retainAll(c);
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return items.listIterator(index);
    }

    @Override
    public ListIterator<T> listIterator() {
        return items.listIterator();
    }

    @Override
    public Iterator<T> iterator() {
        return items.iterator();
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return items.subList(fromIndex, toIndex);
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        items.forEach(action);
    }

    @Override
    public Spliterator<T> spliterator() {
        return items.spliterator();
    }

    @Override
    public boolean removeIf(Predicate<? super T> filter) {
        return items.removeIf(filter);
    }

    @Override
    public void replaceAll(UnaryOperator<T> operator) {
        items.replaceAll(operator);
    }

    @Override
    public void sort(Comparator<? super T> c) {
        items.sort(c);
    }

    @Override
    public int hashCode() {
        return items.hashCode();
    }

    @Override
    public Stream<T> stream() {
        return items.stream();
    }

    @Override
    public Stream<T> parallelStream() {
        return items.parallelStream();
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return items.containsAll(c);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof TLVector))
            return false;
        if (this == obj)
            return true;

        TLVector o = (TLVector) obj;
        return size() == o.size()
                || items.equals(o.items);
    }
}
