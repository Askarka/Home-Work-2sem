package HomeWork.ADS._1DONE;

import java.util.Arrays;

public class Stack<T> {
    private T[] array;
    private int size;
    private int capacity;
    private int ind;

    public Stack(int capacity){
        this.array =(T[]) new Object[capacity];
        this.capacity = capacity;
        this.size = 0;
    }

    @Override
    public int hashCode() {
        int result = 0;
//        for(int i = 0; i < size; i++){
//            result += ;
//        }
        result += 47*this.size;
        result += 1337*this.capacity;
        result += 228*this.ind;
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stack<?> stack = (Stack<?>) o;
        return size == stack.size &&
                capacity == stack.capacity &&
                ind == stack.ind &&
                Arrays.equals(array, stack.array);
    }

    public void add(T e){
        this.checkCap(this);
        this.size++;
        this.array[size-1] = e;
    }

    public T pop(){
        T z = this.array[size-1];
        this.array[size-1] = null;
        this.size--;
        return z;
    }

    public T peek(){
        return this.array[size-1];
    }

    public int size(){
        return size;
    }

    public void showAll(){
        for (int i = 0; i < size; i++){
            System.out.println(this.array[size-i-1]);
        }
    }

    public void checkCap(Stack st){
        if(this.size == this.capacity){
            T[] two = (T[]) new Object[this.size+10];
            for(int i = 0; i < size; i++){
                two[i] = this.array[i];
            }
            this.array = two;
            this.capacity += 10;
        }
    }

//    public static void main(String[] args) {
//        Stack st1 = new Stack(100);
//        st1.add(123);
//        st1.add(228);
//        st1.add(1337);
//        System.out.println(st1.pop());
//        System.out.println(st1.size());
//        st1.showAll();
//    }
}
