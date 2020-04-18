package HomeWork.prog._5;

import HomeWork.prog._3DONE.UniversalEndlessArrayIterator;

import java.util.*;

public class NavigableSet<T> extends AbstractCollection<T> implements java.util.NavigableSet<T> {

    private T[] array;
    private int size;
    private int order = 1;
    private Comparator<? super T> comparator;

    public NavigableSet(T[] array, int size, int order, Comparator<? super T> comparator) {
        this.array = array;
        this.size = size;
        this.order = order;
        this.comparator = comparator;
    }

    public NavigableSet(Comparator<? super T> comparator, int order) {
        this.comparator = comparator;
        this.order = order;
    }


    @Override
    public T lower(T t) {
        try{
            int k = -1;
            for(int i = 0; i < size; i++){
                if(t.equals(array[i])){
                    k = i;
                    break;
                }
            }
            if(k == -1){
                return null;
            }else{
                if(order == 1){
                    if(k == 0){
                        return null;
                    }else{
                        return  array[k-1];
                    }
                }else{
                    if(k == size - 1){
                        return null;
                    }else{
                        return array[k+1];
                    }
                }
            }
        }catch(ClassCastException | NullPointerException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public T floor(T t) {
            try{
                int k = -1;
                for(int i = 0; i < size; i++){
                    if(t.equals(array[i])){
                        k = i;
                        break;
                    }
                }
                if(k == -1){
                    return null;
                }else{
                    if(order == 1){
                        if(k == 0){
                            return array[k];
                        }else{
                            return  array[k-1];
                        }
                    }else{
                        if(k == size - 1){
                            return array[size];
                        }else{
                            return array[k+1];
                        }
                    }
                }
            }catch(ClassCastException | NullPointerException e){
                e.printStackTrace();
            }
            return null;
    }

    @Override
    public T ceiling(T t) {
        try{
            int k = -1;
            for(int i = 0; i < size; i++){
                if(t.equals(array[i])){
                    k = i;
                    break;
                }
            }
            if(k == -1){
                return null;
            }else{
                if(order == 1){
                    if(k == size - 1){
                        return array[k];
                    }else{
                        return  array[k+1];
                    }
                }else{
                    if(k == 0){
                        return array[k];
                    }else{
                        return array[k-1];
                    }
                }
            }
        }catch(ClassCastException | NullPointerException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public T higher(T t) {
        try{
            int k = -1;
            for(int i = 0; i < size; i++){
                if(t.equals(array[i])){
                    k = i;
                    break;
                }
            }
            if(k == -1){
                return null;
            }else{
                if(order == 1){
                    if(k == size - 1){
                        return null;
                    }else{
                        return  array[k+1];
                    }
                }else{
                    if(k == 0){
                        return null;
                    }else{
                        return array[k-1];
                    }
                }
            }
        }catch(ClassCastException | NullPointerException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public T pollFirst() {
        if(size == 0){
            return null;
        }else{
            T k = array[order == 1 ? 0 : size - 1];
            if (size - 1 >= 0) System.arraycopy(array, 1, array, 0, size - 1);
            return k;
        }
    }

    @Override
    public T pollLast() {
        if(size == 0){
            return null;
        }else{
            T k = array[order == 1 ? size - 1 : 0];
            array[size - 1] = null;
            size--;
            return k;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new UniversalEndlessArrayIterator<T>(array);
    }

    @Override
    public java.util.NavigableSet<T> descendingSet() {
        NavigableSet<T> reverseSet = new NavigableSet<>(comparator, order * -1);
        T buff;
        T[] rar = Arrays.copyOf(array, size);
        for(int i = 0; i < size; i++){
            buff = rar[i];
            rar[i] = rar[size - 1 - i];
            rar[size - 1 - i] = buff;
        }
        reverseSet.array = rar;
        reverseSet.size = size;
        return reverseSet;
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
    public int size() {
        return size;
    }
}
