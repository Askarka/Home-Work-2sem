package HomeWork.prog._5;

import HomeWork.prog._3DONE.UniversalEndlessArrayIterator;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;


public class NavigableSet<T> extends AbstractCollection<T> implements java.util.NavigableSet<T> {

    private T[] array;
    private int size;
    private int order = 1;
    private Comparator<? super T> comparator;


    @Override
    public T lower(T t) {
        int ind = -1;

        for(int i = 0; i < array.length; i++){
            if(t.equals(array[i])){
                ind = i;
                return array[i-1];
            }
        }

        if(ind == -1) return null;
        return array[ind - 1];
    }

    @Override
    public T floor(T t) {
        T x = null;

        boolean flag = true;
        for(int i = 0; i < size && flag; i++){
            if(order * comparator.compare(t, array[i]) > 0){
                flag = false;
            }
            else {
                x = array[i];
            }
        }
        return x;
    }

    @Override
    public T ceiling(T t) {
        T x = null;
        boolean flag = true;
        for(int i = size - 1; i >= 0 && flag; i--){
            if(order * comparator.compare(t, array[i]) < 0){
                flag = false;
            }
            else {
                x = array[i];
            }
        }
        return x;
    }

    @Override
    public T higher(T t) {
        int ind = -1;

        for(int i = 0; i < array.length; i++){
            if(t.equals(array[i])){
                ind = i;
                return array[i-1];
            }
        }

        if(ind == size - 1 || ind == -1) return null;
        return array[ind + 1];
    }

    @Override
    public T pollFirst() {
        if(size == 0) return null;
        T x = array[0];

        for(int i = 0; i < size-1; i++){
            array[i] = array[i+1];
        }

        size--;
        return x;
    }

    @Override
    public T pollLast() {
        if(size == 0) return null;
        T x = array[size - 1];
        array[size - 1] = null;
        size--;
        return x;
    }

    @Override
    public Iterator<T> iterator() {
        return new UniversalEndlessArrayIterator<T>(array);
    }
//TODO Реализовать NavigableSet (все оставшиеся методы, которые есть в API)
//TODO Залить это на GitHub в отдельный репозиторий.
//TODO Написать javadoc, документацию.
    @Override
    public java.util.NavigableSet<T> descendingSet() {
        return null;
    }

    @Override
    public Iterator<T> descendingIterator() {
        return null;
    }

    @Override
    public java.util.NavigableSet<T> subSet(T fromElement, boolean fromInclusive, T toElement, boolean toInclusive) {
        return null;
    }

    @Override
    public java.util.NavigableSet<T> headSet(T toElement, boolean inclusive) {
        return null;
    }

    @Override
    public java.util.NavigableSet<T> tailSet(T fromElement, boolean inclusive) {
        return null;
    }

    @Override
    public Comparator<? super T> comparator() {
        return null;
    }

    @Override
    public SortedSet<T> subSet(T fromElement, T toElement) {
        return null;
    }

    @Override
    public SortedSet<T> headSet(T toElement) {
        return null;
    }

    @Override
    public SortedSet<T> tailSet(T fromElement) {
        return null;
    }

    @Override
    public T first() {
        return null;
    }

    @Override
    public T last() {
        return null;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int size() {
        return this.size;
    }
}
