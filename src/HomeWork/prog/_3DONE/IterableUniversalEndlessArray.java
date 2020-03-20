package HomeWork.prog._3DONE;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

public class IterableUniversalEndlessArray<T> implements Iterable<T> {
    private static final int addSize = 10;
    private T[] array;
    private int size;
    private int capacity;

    public IterableUniversalEndlessArray(int size){
        this.array = (T[]) new Object[size];
        this.size = 0;
    }

    public IterableUniversalEndlessArray(T[] array){
        this.array = array;
        this.array = copy();
    }

    public T[] copy() {
        T[] newObj = (T[]) new Object[this.capacity];
        for (int i = 0; i < this.capacity; i++) {
            newObj[i] = array[i];
        }
        return newObj;
    }

    public T[] copyWithNewCap(int cap) {
        T[] newObj = (T[]) new Object[cap];
        for (int i = 0; i < this.size; i++) {
            newObj[i] = array[i];
        }
        return newObj;
    }

    public void checkCap(){
        if(size == capacity){
            this.array = copyWithNewCap(this.capacity+addSize);
            capacity += addSize;
        }
    }

    public void add(T n){
        checkCap();
        array[size] = n;
        size++;
    }

    public void swap(int i1, int i2){
        T buffer = this.array[i1];
        this.array[i1] = this.array[i2];
        this.array[i2] = buffer;
    }

    public T getLast(){
        T g = array[size-1];
        array[size-1] = null;
        size--;
        return g;
    }

    public T getByInd(int ind){
        T g = array[ind];
        this.remove(size-1);
        return g;
    }
    public T peekLast(){
        return array[size-1];
    }

    public T peekByInd(int ind){
        return array[ind];
    }

    public void remove(int n){
        if(n < size){
            for(int i = n; i < this.size; i++){
                array[i] = array[i+1];
            }
            this.size--;
        }

    }

    public int indexOf(T x){
        for(int i = 0; i < this.size; i++){
            if(array[i].equals(x)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IterableUniversalEndlessArray<?> that = (IterableUniversalEndlessArray<?>) o;  //Спросить у АА, не сравнение ли это классов T?
        return size == that.size &&
                capacity == that.capacity &&
                Arrays.equals(array, that.array);
    }

    @Override
    public String toString() {
        return "UniversalEndlessArray{" +
                "array=" + Arrays.toString(array) +
                ", size=" + size +
                ", capacity=" + capacity +
                '}';
    }

    public String showElements(){
        return Arrays.toString(array);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(size, capacity);
        result = 31 * result + Arrays.hashCode(array);
        return result;
    }

    //TODO (доп.) методы: запись содержимого в файл, взятие содержимого из файла

    public int getSize(){
        return this.size;
    }

    public int getCapacity(){
        return capacity;
    }

    public int getAddSize(){
        return addSize;
    }

    @Override
    public Iterator<T> iterator() {
        return new UniversalEndlessArrayIterator<>(array);
    }
}
