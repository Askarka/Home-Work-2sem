package HomeWork.prog._4DONE;

import HomeWork.prog._3DONE.UniversalEndlessArrayIterator;

import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

public class UnmodifiableCollection<T> extends AbstractCollection<T> {
    private T[] array;
    private int size;

    public UnmodifiableCollection() {
    }

    public UnmodifiableCollection(UnmodifiableCollection<? extends T> c) {

        int i = 0;
        this.array = (T[]) new Object[c.size];
        Iterator<T> it = (Iterator<T>) c.iterator();
        while(it.hasNext()) {
            array[i] = it.next();
            i++;
        }
        this.size = c.size();
    }

    @Override
    public String toString() {
        return "UnmodifiableCollection{" +
                "array=" + Arrays.toString(array) +
                ", size=" + size +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UnmodifiableCollection<?> that = (UnmodifiableCollection<?>) o;
        return size == that.size &&
                Arrays.equals(array, that.array);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(size);
        result = 31 * result + Arrays.hashCode(array);
        return result;
    }

    @Override
    public Iterator<T> iterator()  {
        return new UniversalEndlessArrayIterator<T>(array);
    }

    @Override
    public int size() {
        return this.size;
    }
}
