package HomeWork.ADS._2DONE;

public class Set<T> {
    private T[] array;
    private int size;
    private int capacity;

    public Set(int capacity){
        this.array =(T[]) new Object[capacity];
        this.capacity = capacity;
        this.size = 0;
    }

    public Set() {
        new Set(0);
    }

    public void add(T e){
        if(!this.has(e)){
            this.checkCap(this);
            this.size++;
            this.array[size-1] = e;
        }
    }

    public void checkCap(Set st){
        if(this.size == this.capacity){
            T[] two = (T[]) new Object[this.size+10];
            for(int i = 0; i < size; i++){
                two[i] = this.array[i];
            }
            this.array = two;
            this.capacity += 10;
        }
    }

    public boolean has(T o){
        for(int i = 0; i < size; i++){
            if(this.array[i].equals(o)){
                return true;
            }
        }
        return false;
    }

    public void remove(T o){
        for(int i = 0; i < size; i++){
            if(this.array[i].equals(o)){
                this.array[i] = null;
            for(int j = i; j < size - 1; j++){
                this.array[i] = this.array[i+1];
            }
            return;
            }
        }
    }

    public int size(){
        return size;
    }

    public void showAll(){
        for (int i = 0; i < size; i++){
            System.out.println(this.array[size-i-1]);
        }
    }
    
    public Set merge(Set o){
        Set both = new Set(this.capacity + o.capacity);

        for(int i = 0; i < this.size; i++){
            both.add(this.array[i]);
        }

        for(int i = 0; i < o.size; i++){
            if(!this.has((T) o.array[i])){
                both.add(o.array[i]);
            }
        }
        return both;
    }

    public boolean contains(Set o){
        int n = 0;
        if(this.size < o.size){
            return false;
        }
        for(int i = 0; i < o.size; i++){
            if(this.has((T) o.array[i])) {
                n++;
            }
        }
        if(n == o.size){
            return true;
        }
        return false;
    }
}