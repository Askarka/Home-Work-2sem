package HomeWork.prog._1DONE;

public class Pare<T1, T2> {
    private final T1 obj1;
    private final T2 obj2;

    public Pare(T1 obj1, T2 obj2){
        this.obj1 = obj1;
        this.obj2 = obj2;

    }
    public Pare(T1 obj1) {
        this.obj1 = obj1;
        this.obj2 = null;
    }

    public T1 getValue1() {
        return obj1;
    }

    public Class getType1(){
        return this.obj1.getClass();
    }

    public T2 getValue2() {
        return obj2;
    }

    public Class getType2(){
        return this.obj2.getClass();
    }

    public Pare<T2,T1> swap() {
        Pare obj = new Pare<T2, T1> (this.obj2 , this.obj1);
        return obj;
    }
}
