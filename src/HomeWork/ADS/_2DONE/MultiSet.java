package HomeWork.ADS._2DONE;
// TODO Написать реализацию оптимального MultiSet (хранить в двух массивах: значения и количество повторений).

import java.util.NoSuchElementException;

public class MultiSet<T> {
    private T[] arrayOfObj;
    private int[] arrayOfNum;
    private int sizeOfUnObj;
    private int capacity;
    private float LoadFactor;

    private float ResizeFactor;

    public MultiSet(int capacity) {
        this.arrayOfObj = (T[]) new Object[capacity];
        this.arrayOfNum = new int[capacity];
        this.capacity = capacity;
        this.sizeOfUnObj = 0;
        this.LoadFactor =  0.75f;
        this.ResizeFactor = 1.5f;
    }

    public void add(T e){
        if(this.has(e) !=0){
            this.checkCap(this);
            for(int i = 0; i < sizeOfUnObj; i++){
                if(this.arrayOfObj[i].equals(e)){
                    arrayOfNum[i]++;
                }
            }
        }else{
            this.sizeOfUnObj++;
            arrayOfNum[sizeOfUnObj]++;
            arrayOfObj[sizeOfUnObj] = e;

//            int i = 0; //TODO understand why did I do this
//            while(arrayOfNum[i] != 0){
//                i++;
//            }
//            arrayOfNum[i]++;
//            arrayOfObj[i] = e;
//            this.sizeOfUnObj++;
        }
    }

    public void checkCap(MultiSet st){
        if(this.sizeOfUnObj >= this.capacity * this.LoadFactor){
            T[] twoObj = (T[]) new Object[(int) (this.sizeOfUnObj * this.ResizeFactor)];
            int[] twoNum = new int[(int) (this.sizeOfUnObj * this.ResizeFactor)];
            for(int i = 0; i < sizeOfUnObj; i++){
                twoObj[i] = this.arrayOfObj[i];
                twoNum[i] = this.arrayOfNum[i];
            }
            this.arrayOfObj = twoObj;
            this.arrayOfNum = twoNum;
            this.capacity *= ResizeFactor;
        }
    }

    public int has(T o){ //Или лучше сделать 2 разных метода? (1 - boolean, 2 - int)
        for(int i = 0; i < sizeOfUnObj; i++){
            if(this.arrayOfObj[i].equals(o)){
                return arrayOfNum[i];
            }
        }
        return 0;
    }

    public void removeAllThisElem(T o) {
        try{
            for(int i = 0; i < sizeOfUnObj; i++){
                if(this.arrayOfObj[i].equals(o)){
                    for(int j = i; j < sizeOfUnObj - 1; j++){
                        this.arrayOfNum[i] = this.arrayOfNum[i+1];
                        this.arrayOfObj[i] = this.arrayOfObj[i+1];
                    }
                    return;
                }
            }
        }catch (NoSuchElementException e){
            System.err.println("Multiset don't have this object. Exception was processed. Program continues.");
        }
    }

    public void remove(T o) {
        remove(o, 1);
    }

    public void remove(T o, int n) {
        if(this.has(o) == 0){
            throw new NoSuchElementException("There is no such element in the set");
        }

//        if(n <= sizeOfUnObj){
//            throw new IndexOutOfBoundsException("Index must be natural.");
//        }

        for(int i = 0; i < sizeOfUnObj; i++){
            if(this.arrayOfObj[i].equals(o)){
                if(arrayOfNum[i] < n){
                    throw new NoSuchElementException("There are fewer items than you need to remove.");
                }else{
                    if(arrayOfNum[i] == n){
                        removeAllThisElem(o);
                    }else{
                        arrayOfNum[i] -= n;
                    }
                }
            }
        }
    }

    public void showAll(){
        for (int i = 0; i < sizeOfUnObj; i++){
            System.out.print(this.arrayOfNum[i] + " x " + this.arrayOfObj[i]);
        }
    }

    public MultiSet<T> merge(MultiSet<T> o){
        MultiSet<T> both = new MultiSet<>(this.capacity+ o.capacity);

        for(int i = 0; i < this.sizeOfUnObj; i++){
            for(int j = 0; i < this.arrayOfNum[i]; j++){
                both.add(this.arrayOfObj[i]);
            }
        }

        for(int i = 0; i < o.sizeOfUnObj; i++){
            for(int j =0; i < o.arrayOfNum[i]; j++){
                both.add(o.arrayOfObj[i]);
            }
        }

        return both;
    }

    public boolean contains(MultiSet o){
        int n = 0;
        if(this.sizeOfUnObj < o.sizeOfUnObj){
            return false;
        }
        for(int i = 0; i < o.sizeOfUnObj; i++){
            if(this.has(this.arrayOfObj[i]) < o.has(o.arrayOfObj[i])) {
                return false;
            }
        }
        return true;
    }

    public void swap(int i1, int i2){
        T bufferObj;
        int bufferNum;

        bufferNum = arrayOfNum[i1];
        arrayOfNum[i1] = arrayOfNum[i2];
        arrayOfNum[i2] = bufferNum;

        bufferObj = arrayOfObj[i1];
        arrayOfObj[i1] = arrayOfObj[i2];
        arrayOfObj[i2] = bufferObj;
    }

    public T getArrayOfObjEl(int i) {
        return arrayOfObj[i];
    }

    public int getArrayOfNumEl(int i) {
        return arrayOfNum[i];
    }

    public int getsize(){
        return sizeOfUnObj;
    }

}
