package HomeWork.prog._5DONE;

import java.util.Iterator;

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
    public void remove() {
        int i = cursor;
        while(this.hasNext()){
            this.data[i] = this.data[i+1];
            i++;
        }
        this.data[i] = null;
    }
}

