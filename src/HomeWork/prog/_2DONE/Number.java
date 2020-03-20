package HomeWork.prog._2DONE;

import HomeWork.prog._1DONE.Complex;

public interface Number<T>  {
    public T sum(T o1, T o2);

    default public T dif(T o1, T o2) {
        return null;
    }

    default public T mul(T o1, T o2) { return null; }

    default public T div(T o1, T o2) {
        return null;
    }

    int compare(Complex o1, Complex o2);
}