package HomeWork.prog._4;

import HomeWork.prog._3DONE.UniversalEndlessArrayIterator;

import java.util.AbstractCollection;
import java.util.Iterator;

public class UnmodifiableCollection<T> extends AbstractCollection<T> {
    private T[] array;
    private int size;

    public UnmodifiableCollection() {
    }

    public UnmodifiableCollection(UnmodifiableCollection<? extends T> c) {

        int i = 0;
        this.array = (T[]) new Object[c.size];
        Iterator<T> it = (Iterator<T>) c.iterator();
        while(it.hasNext()) {
            array[i] = it.next();
            i++;
        }
        this.size = c.size();
    }
    //TODO «Деструктивные» методы, содержащиеся в этом интерфейсе, то есть методы, которые изменяют коллекцию, с которой они работают,
// указываются для выброса исключения UnsupportedOperationException, если эта коллекция не поддерживает операцию.
// В этом случае эти методы могут, но не обязаны, генерировать исключение UnsupportedOperationException,
// если вызов не окажет влияния на коллекцию. Например, вызов addAll(Collection)метода для неизменяемой коллекции может,
// но не обязательно, вызывать исключение, если добавляемая коллекция пуста.
    @Override
    public Iterator<T> iterator()  {
        return new UniversalEndlessArrayIterator<T>(array);
    }

    @Override
    public int size() {
        return this.size;
    }
}
