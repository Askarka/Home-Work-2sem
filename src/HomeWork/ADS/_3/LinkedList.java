package HomeWork.ADS._3;

import sun.awt.geom.AreaOp;

import java.sql.SQLOutput;
import java.util.Objects;
//TODO добавить везде NoSuchElemExep...  другие исключения
public class LinkedList<T> {
    private Node<T> head;

    private class Node<T> {
        private T value;
        private Node next;

        public Node(T value, Node next) {
            this.value = value;
            this.next = next;
        }

        public T getValue() {
            return value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    public LinkedList(Node<T> head) {
        this.head = head;
    }

    public void add(T o){
        if(o == null){
            throw new NullPointerException("It's not allowed to add null!");
        }

        if(head.getNext() != null){
            Node buf = this.head;

            while(buf.getNext() != null){
                buf = buf.getNext();
            }
            buf.setNext(new Node(o, null));
        }else{
            head.setNext(new Node(o, null));
        }
    }

    public void addLast(T o){
        add(o);
    }

    public void addFirst(T o){
        if(o == null){
            throw new NullPointerException("It's not allowed to add null!");
        }

        this.head = new Node<T> (o , this.head);
    }

    public void addAfter(T o, int ind) throws IndexOutOfBoundsException{
        if(o == null){
            throw new NullPointerException("It's not allowed to add null!");
        }

        Node<T> buf = this.head;

        for(int i=0; i < ind; i++){
            if(buf.getNext() != null){
                buf = buf.getNext();
            }else{
                throw new IndexOutOfBoundsException();
            }
        }
        buf.setNext(new Node(o , buf.getNext()));
    }

    public int size(){
        if(head.getNext() != null){
            Node<T> buf = this.head;
            int i = 1;

            while(buf.getNext() != null){
                buf = buf.getNext();
                i++;
            }
            return i;
        }
        return 0;
    }

    public T get(int ind){
        try{
            Node<T> buf = this.head;

            for( int i = 0; i < ind; i++){
                buf = buf.getNext();
            }
            if(buf.getValue() == null){
                throw new NullPointerException("There is no element with this index!");
            }
            return buf.getValue();

        }catch (IndexOutOfBoundsException e){
            System.err.println("There is no element with this index!");
        }
        return null;
    }

    public void remove(T o){
        try{
            Node<T> buf = this.head;

            while(!buf.getNext().getValue().equals(o)){
                buf = buf.getNext();
            }
            buf.setNext(buf.getNext().getNext());
        }catch (NoSuchMethodError | NullPointerException e){ //вроде NoSuchMethodError и не нужен, но точно ли?
            System.err.println("There is no this element saved!");
        }
    }

    public void remove(int ind){
        try{
            Node<T> buf = this.head;

            for( int i = 0; i < ind-1; i++){
                buf = buf.getNext();
            }
            buf.setNext(buf.getNext().getNext());
        }catch (NullPointerException e){
            System.err.println("There is no this element saved!");
        }
    }

    public LinkedList<T> merge(LinkedList<T> o){
        Node<T> f = new Node<T>(this.get(1), this.head.getNext());
        LinkedList<T> result = new LinkedList<>(f);

        Node<T> buf = this.head;

        while(buf.getNext() == null){
            result.add(buf.value);
            buf = buf.getNext();
        }

        buf = o.head;

        while(buf.getNext() == null){
            result.add(buf.value);
            buf = buf.getNext();
        }

        return result;
    }

    public int indexOf(T o){
        try{
            Node<T> buf = this.head;
            int i = 0;
            while(!buf.getValue().equals(o)){
                buf = buf.getNext();
                i++;
            }
            return i;
        }catch (NullPointerException e){
            System.err.println("There is no this element saved!");
        }
        return -1;
    }

    @Override
    public int hashCode() {
        int hash = 19;
        Node<T> buf = this.head;
        int i = 1;

        while(buf.getNext() != null){
            buf = buf.getNext();
            hash += buf.getValue().hashCode();
            hash *= ++i;
        }
        return hash;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LinkedList<?> that = (LinkedList<?>) o;
        if(!Objects.equals(head, that.head)){
            return false;
        }
        Node<T> buf1 = this.head;
        Node<T> buf2 =((LinkedList) o).head;

        while(buf1.getNext() != null){
            if(((buf1.getNext() != null) && (buf2.getNext() == null)) || (buf2.getNext() != null) && (buf1.getNext() == null)){
                return false;
            }
            buf1 = buf1.getNext();
            buf2 = buf2.getNext();
            if(!buf1.getValue().equals(buf2.getValue())){
                return false;
            }
        }
        return true;
    }
}
//    public void addFirst(T o){
//        Node<T> n = new Node<>(o , head);
//        head = n;
//    }
//

