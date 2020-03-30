package HomeWork.prog._4;

import HomeWork.prog._3DONE.UniversalEndlessArrayIterator;

import java.util.AbstractCollection;
import java.util.Iterator;

public class ModifiableCollection<T> extends AbstractCollection<T> {
    private T[] array;
    private int size;

    public ModifiableCollection() {
    }

    public ModifiableCollection(ModifiableCollection<? extends T> c) {
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
    public Iterator<T> iterator() {
        return new UniversalEndlessArrayIterator<T>(array);
    }

    @Override
    public int size() {
        return this.size;
    }

    public boolean equals(ModifiableCollection<T> o) {
        if(this.size != o.size){
            return false;
        }

        int n = 0;
        for(int i = 0; i < this.size; i++){
            for(int j = 0; j < this.size; j++){
                if(this.array[i] == o.array[j]){
                  n++;
                }
            }
        }

        if(this.size == n){
            return true;
        }else{
            return false;
        }
    }

    public boolean add(T o){
        try{
            array[size++] = o;
            return true;
        }catch (IndexOutOfBoundsException a){
            return false;
        }
    }

}