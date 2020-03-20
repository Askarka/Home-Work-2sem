package HomeWork.prog._3DONE;

import java.util.Iterator;

public class FunnyIterator<T> implements Iterator<T> {
    private T[] data;
    private int cursor;
    private boolean side = false;

    public FunnyIterator(T[] data) {
        this.data = data;
        this.cursor = 0;
    }

    @Override
    public boolean hasNext() {
        if(!side){
            return data.length/2 < cursor+1 && data[cursor] != null;
        }else{
            return  data[data.length-cursor] != null;
        }

        //        return cursor < this.data.length && data[cursor] != null;
    }
    @Override
    public T next() {
        if(!side){
            T el = data[cursor];
            this.side = true;
            cursor = data.length - 1 - cursor;
            return el;
        }else{
            T el =data[cursor];
            this.side = false;
            cursor = data.length - cursor;
            return el;
        }
    }
}
