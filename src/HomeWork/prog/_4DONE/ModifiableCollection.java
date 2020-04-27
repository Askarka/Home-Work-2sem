package HomeWork.prog._4DONE;

import HomeWork.prog._3DONE.UniversalEndlessArrayIterator;

import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

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

    @Override
    public String toString() {
        return "ModifiableCollection{" +
                "array=" + Arrays.toString(array) +
                ", size=" + size +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ModifiableCollection<?> that = (ModifiableCollection<?>) o;
        return size == that.size &&
                Arrays.equals(array, that.array);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(size);
        result = 31 * result + Arrays.hashCode(array);
        return result;
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