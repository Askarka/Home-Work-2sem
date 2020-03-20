package HomeWork.ADS._1DONE;

public class Queye<T1> {
    private T1[] array;
    private int size;
    private int capacity;
    private int ind;

    public Queye(int capacity){
        this.array =(T1[]) new Object[capacity];
        this.capacity = capacity;
        this.size = 0;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public void add(T1 e){
        this.size++;
        this.array[size-1] = e;
        this.checkCap(this);
    }

    public T1 pop(){
        T1 z = this.array[0];
        for(int i = 0; i < this.size-1; i++){
            this.array[i] = this.array[i+1];
        }
        this.size--;
        return z;
    }

    public T1 peek(){
        return this.array[0];
    }

    public int getSize(){
        return size;
    }

    public void showAll(){
        for (int i = 0; i < size; i++) {
            System.out.println(this.array[i]);
        }
    }

    public void checkCap(Queye st){
        if(this.size == this.capacity){
            T1[] two = (T1[]) new Object[this.size+10];
            for(int i = 0; i < size; i++){
                two[i] = this.array[i];
            }
            this.array = two;
            this.capacity += 10;
        }
    }

}
