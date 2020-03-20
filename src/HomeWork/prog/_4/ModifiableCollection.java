package HomeWork.prog._4;

import HomeWork.prog._3DONE.UniversalEndlessArrayIterator;

import java.util.AbstractCollection;
import java.util.Iterator;

public class ModifiableCollection<T> extends AbstractCollection<T> {
    private T[] array;
    private int size;

    public ModifiableCollection() {
    }

    public ModifiableCollection(ModifiableCollection<? extends T> c) {

        int i = 0;
        this.array = (T[]) new Object[c.size];
        Iterator<T> it = (Iterator<T>) c.iterator();
        while(it.hasNext()) {
            array[i] = it.next();
            i++;
        }
        this.size = c.size();
    }

    @Override
    public Iterator<T> iterator()  {
        return new UniversalEndlessArrayIterator<T>(array);
    }

    @Override
    public int size() {
        return this.size;
    }
}
