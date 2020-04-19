package HomeWork.prog._5DONE;

import HomeWork.prog._3DONE.UniversalEndlessArrayIterator;
import java.util.*;

/**
 * My Study practice of creating NavigableSet
 * @author Askar Shaikhutdinov 11-903 group
 * @param <T> is type of elements stored in this set
 */

public class NavigableSet<T> extends AbstractCollection<T> implements java.util.NavigableSet<T> {

    private T[] array;
    private int size;
    private int order = 1;
    private Comparator<? super T> comparator;


    //    /**
//     * <p>Constructor with comparator and num, that define direction</p>
//     * @param comparator Comparator, that compare elements
//     * @param direct 1, with direct order, -1 with reverse order
//     */


    /**
     *<p>Constructor with all NavigableSet's parameters</p>
     * @param array array which store elements
     * @param size the num of elements
     * @param order an order of elements in this set if this value positive it's ascending, if negative it's descending
     * @param comparator Comparator, which compare elements
     */
    public NavigableSet(T[] array, int size, int order, Comparator<? super T> comparator) {
        this.array = array;
        this.size = size;
        this.order = order;
        this.comparator = comparator;
    }

    /**
     * <p>Constructor with Comparator and order of elements</p>
     * @param comparator Comparator, which compare elements
     * @param order an order of elements in this set if this value positive it's ascending, if negative it's descending
     */
    public NavigableSet(Comparator<? super T> comparator, int order) {
        this.comparator = comparator;
        this.order = order;
    }


    /**
     *<p>Returns the greatest element in this set strictly less than the given element, or null if there is no such element.</p>
     * @param t - the value to match
     * @return the greatest element less than e, or null if there is no such element
     */
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

    /**
     * <p>Returns the greatest element in this set less than or equal to the given element, or null if there is no such element.</p>
     * @param t- the value to match
     * @return the greatest element less than or equal to e, or null if there is no such element
     */
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

    /**
     * <p>Returns the least element in this set greater than or equal to the given element, or null if there is no such element.</p>
     * @param t - the value to match
     * @return the least element greater than or equal to e, or null if there is no such element
     */
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

    /**
     * <p>Returns the least element in this set strictly greater than the given element, or null if there is no such element.</p>
     * @param t - the value to match
     * @return the least element greater than e, or null if there is no such element
     */
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

    /**
     * <p>Retrieves and removes the first (lowest) element, or returns null if this set is empty.</p>
     *
     * @return the first element, or null if this set is empty
     */
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

    /**
     * <p>Retrieves and removes the last (highest) element, or returns null if this set is empty.</p>
     * @return the last element, or null if this set is empty
     */
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

    /**
     * <p>Returns an iterator over the elements in this set, in ascending order.</p>
     * @return an iterator over the elements in this set, in ascending order
     */
    @Override
    public Iterator<T> iterator() {
        return new UniversalEndlessArrayIterator<>(array);
    }

    /**
     * <p>Returns a reverse order view of the elements contained in this set. The descending set is backed by this set,
     * so changes to the set are reflected in the descending set, and vice-versa. If either set is modified while an
     * iteration over either set is in progress (except through the iterator's own remove operation), the results of
     * the iteration are undefined.
     * The returned set has an ordering equivalent to Collections.reverseOrder(comparator()). The expression
     * s.descendingSet().descendingSet() returns a view of s essentially equivalent to s.</p>
     * @return a reverse order view of this set
     */
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

    /**
     * <p>Returns an iterator over the elements in this set, in descending order. Equivalent in effect to
     * descendingSet().iterator().</p>
     * @return an iterator over the elements in this set, in descending order
     */
    @Override
    public Iterator<T> descendingIterator() {
        return new UniversalEndlessArrayReverseIterator<>(array, array.length);
    }

    /**
     * <p>Returns a view of the portion of this set whose elements range from fromElement to toElement. If fromElement
     * and toElement are equal, the returned set is empty unless
     * fromInclusive and toInclusive are both true. The returned set is backed by this set,
     * so changes in the returned set are reflected in this set, and vice-versa.
     * The returned set supports all optional set operations that this set supports.</p>
     * @param fromElement beginning point of NavigableSet
     * @param fromInclusive condition of considering beginning point
     * @param toElement ending point of NavigableSet
     * @param toInclusive condition of considering ending point
     * @return a view of the portion of this set whose elements range from fromElement, inclusive, to toElement, exclusive
     */
    @Override
    public java.util.NavigableSet<T> subSet(T fromElement, boolean fromInclusive, T toElement, boolean toInclusive) {
        int l = -1, r = -1;
        for(int i = 0; i < size; i++){
            if(fromElement == array[i]){
                l = i;
            }
            if(toElement == array[i]){
                r = i;
            }
        }
        if(r == -1 || l == -1){
            throw new IllegalArgumentException();
        }else{
            if((l == r) && fromInclusive && toInclusive) {
                NavigableSet<T> res = null;
                try {
                    res = new NavigableSet<>((T[]) new Object[]{array[l]}, 1, this.order, this.comparator);
                } catch (ClassCastException e) {
                    e.printStackTrace();
                }
                return Objects.requireNonNull(res);
            }else{
                if(l == r){
                    NavigableSet<T> res = null;
                    try {
                        res = new NavigableSet<>((T[]) new Object[]{array[0]}, 0, this.order, this.comparator);
                    } catch (ClassCastException e) {
                        e.printStackTrace();
                    }
                    return Objects.requireNonNull(res);
                }else{
                    NavigableSet<T> res = null;
                    try {
                        if(!fromInclusive){
                            l++;
                        }
                        if(!toInclusive){
                            r--;
                        }
                        res = new NavigableSet<>((T[]) new Object[]{array[r - l + 1]}, r - l + 1, this.order, this.comparator);
                        System.arraycopy(array, l, res.array, 0, r + 1);
                    } catch (ClassCastException e) {
                        e.printStackTrace();
                    }
                    return Objects.requireNonNull(res);
                }
            }
        }
    }

    /**
     * <p>Returns a view of the portion of this set whose elements
     * are less than (or equal to, if inclusive is true) toElement. The returned set is backed
     * by this set, so changes in the returned set are reflected in this set, and vice-versa.
     * The returned set supports all optional set operations that this set supports.</p>
     * @param toElement high endpoint of the returned set
     * @param inclusive - true if the high endpoint is to be included in the returned view
     * @return a view of the portion of this set whose elements are less than (or equal to, if inclusive is true) toElement
     */
    @Override
    public java.util.NavigableSet<T> headSet(T toElement, boolean inclusive) {
        return subSet(first(), true, toElement, inclusive);
    }

    /**
     * <p>Returns a view of the portion of this set whose elements are greater than (or equal to, if inclusive is true)
     * fromElement. The returned set is backed by
     * this set, so changes in the returned set are reflected in this set, and vice-versa.
     * The returned set supports all optional set operations that this set supports.</p>
     * @param fromElement  - low endpoint of the returned set
     * @param inclusive - true if the low endpoint is to be included in the returned view
     * @return a view of the portion of this set whose elements are greater than or equal to fromElement
     */
    @Override
    public java.util.NavigableSet<T> tailSet(T fromElement, boolean inclusive) {
        return subSet(fromElement, inclusive, last(), true);
    }

    /**
     *
     * @return Comparator
     */
    @Override
    public Comparator<? super T> comparator() {
        return comparator;
    }

    /**
     * <p>Returns a view of the portion of this set whose elements range from fromElement, inclusive, to toElement,
     * exclusive. (If fromElement and toElement are equal, the returned set is empty.)
     * The returned set is backed by this set, so changes in the returned set are reflected in this set, and vice-versa.
     * The returned set supports all optional set operations that this set supports.</p>
     * @param fromElement - low endpoint (inclusive) of the returned set
     * @param toElement - high endpoint (exclusive) of the returned set
     * @return a view of the portion of this set whose elements range from fromElement, inclusive, to toElement, exclusive
     */
    @Override
    public SortedSet<T> subSet(T fromElement, T toElement) {
        return subSet(fromElement, true, toElement, false);
    }

    /**
     * <p>Returns a view of the portion of this set whose elements are strictly less than toElement. The returned set
     * is backed by this set, so changes in the returned set are reflected in this set, and vice-versa.
     * The returned set supports all optional set operations that this set supports.</p>
     * @param toElement  - high endpoint (exclusive) of the returned set
     * @return a view of the portion of this set whose elements are strictly less than toElement
     */
    @Override
    public SortedSet<T> headSet(T toElement) {
        return headSet(toElement, false);
    }

    /**
     * <p>Returns a view of the portion of this set whose elements are greater than or equal to fromElement.
     * The returned set is backed by this set,
     * so changes in the returned set are reflected in this set, and vice-versa.
     * The returned set supports all optional set operations that this set supports.</p>
     * @param fromElement - low endpoint (inclusive) of the returned set
     * @return a view of the portion of this set whose elements are greater than or equal to fromElement
     */
    @Override
    public SortedSet<T> tailSet(T fromElement) {
        return tailSet(fromElement, true);
    }

    /**
     * <p>Returns the first (lowest) element currently in this set.</p>
     * @return the first (lowest) element currently in this set
     */
    @Override
    public T first() {
        return array[0];
    }

    /**<P>Returns the last (highest) element currently in this set.
     </P>
     * @return the last (highest) element currently in this set.
     */
    @Override
    public T last() {
        return array[size - 1];
    }

    /**
     * @return the num of elements
     */
    @Override
    public int size() {
        return size;
    }
}
