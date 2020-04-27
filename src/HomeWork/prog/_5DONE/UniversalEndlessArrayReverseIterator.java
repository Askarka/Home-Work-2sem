package HomeWork.prog._5DONE;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

public class UniversalEndlessArrayReverseIterator<T> implements Iterator<T> {

    private T[] data;
    private int cursor;

    public UniversalEndlessArrayReverseIterator(T[] data, int cursor) {
        this.data = data;
        this.cursor = data.length;
    }


    @Override
    public boolean hasNext() {
        return cursor > 0 && data[cursor] != null;
    }

    @Override
    public T next() {
        return data[cursor--];
    }

    @Override
    public String toString() {
        return "UniversalEndlessArrayReverseIterator{" +
                "data=" + Arrays.toString(data) +
                ", cursor=" + cursor +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UniversalEndlessArrayReverseIterator<?> that = (UniversalEndlessArrayReverseIterator<?>) o;
        return cursor == that.cursor &&
                Arrays.equals(data, that.data);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(cursor);
        result = 31 * result + Arrays.hashCode(data);
        return result;
    }

    @Override
    public void remove() {
        int i = cursor;
        while(this.hasNext()){
            this.data[i] = this.data[i+1];
            i++;
        }
        this.data[i] = null;
    }
}

