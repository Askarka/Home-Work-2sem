package HomeWork.general;

import java.util.Arrays;

public class EndlessArray {
    private static final int addSize = 2;
    private int[] array;
    private int size;

    public EndlessArray(int size) {
        this.array = new int[size];
        this.size = 0;
    }

    public EndlessArray(int[] array) {
        this.array = array;
        size = array.length;
        this.array = copy(size + 1);
    }

    public EndlessArray() {
        this(addSize);
    }

    public int add(int n) {
        array[size] = n;
        size++;
        checkSize();
        return size - 1;
    }

    public void remove(int n) {
        validateIndex(n);
        for (int i = n + 1; i < size; i++) {
            array[i - 1] = array[i];
        }
        size--;
    }

    public int indexOf(int n) {
        for (int i = 0; i < size; i++) {
            if (array[i] == n)
                return i;
        }
        return -1;
    }

    public int get(int n) {
        validateIndex(n);
        return array[n];
    }

    public int getSize() {
        return size;
    }

    private void checkSize() {
        if (size == array.length) {
            array = copy(size * 2);
        }
        if (size == array.length / 4) {
            array = copy(array.length / 2);
        }
    }

    private int[] copy(int newSize) {
        int[] newArray = new int[newSize];
        for (int i = 0; i < size; i++) {
            newArray[i] = array[i];
        }
        return newArray;
    }

    private void validateIndex(int i) {
        if (i > size - 1 || i < 0) throw new ArrayIndexOutOfBoundsException();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EndlessArray that = (EndlessArray) o;

        if (size != that.size) return false;
        return Arrays.equals(array, that.array);
    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(array);
        result = 31 * result + size;
        return result;
    }

    @Override
    public String toString() {
        String strArray = "";
        for (int i = 0; i < size; i++) {
            strArray += (Integer.toString(array[i]) + ", ");
        }
        return ("EndlessArray{" + "array=[" + strArray + "], size=" + size + "}");
    }
}
