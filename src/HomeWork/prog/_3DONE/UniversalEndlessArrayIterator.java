package HomeWork.prog._3DONE;

import java.util.Iterator;

public class UniversalEndlessArrayIterator<T> implements Iterator<T> {
    private T[] data;
    private int cursor;

    public UniversalEndlessArrayIterator(T[] data) {
        this.data = data;
        this.cursor = 0;
    }

    @Override
    public boolean hasNext() {
        return cursor < this.data.length && data[cursor] != null;
    }

    @Override
    public T next() {
        return data[cursor++];
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
