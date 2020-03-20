package HomeWork.ADS._3;

import java.util.NoSuchElementException;
import java.util.Objects;

public class KarimLinkedList<T> {

    //ToDo почитать про асимптотическую сложность

    private class Node<T>{
        public T value;
        public Node<T> next;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }

        // equals
        public T getValue(){
            return value;
        }
        public void setReference(Node<T> next){
            this.next = next;
        }
        public Node<T> getReference(){
            return this.next;
        }
    }

    // Fields
    private Node<T> head;

    // Constructors
    public KarimLinkedList(T headElement){
        this.head = new Node<>(headElement, null);
    }
    public KarimLinkedList(KarimLinkedList<T> data){
        this.head = data.head;
    }

    //Methods
    public T getFirst(){
        if(head != null){
            return head.getValue();
        }
        return null;
    }

    public void addLast(T element){
        Node<T> buff = head;
        while(!buff.getReference().equals(null)){
            buff = buff.getReference();
        }
        buff.setReference(new Node<>(element, null));
    }

    public void addFirst(T element){    //Можно ли здесь убрать?
        Node<T> buff = head;
        this.head = new Node<>(element, null);
        Node <T> newElement = buff;
        this.head.setReference(newElement);
    }

    public int indexOf(T element){
        int i = 0;
        Node<T> buff = head;
        while(element != buff.getValue()){
            i++;
            buff = buff.getReference();
        }
        return i;
    }

    public int size(){
        int i=0;
        Node<T> buff = head;
        while(!buff.getReference().equals(null)){
            i++;
            buff = buff.getReference();
        }
        return i+1;
    }

    public void addAfter(int index, T element){
        if(index<0){
            throw new IndexOutOfBoundsException("Index must be natural.");
        }
        Node<T> buff = head;
        int i =0;
        while (i != index){
            i++;
            buff = buff.getReference();
            if (buff == null){
                throw new IndexOutOfBoundsException("LinkedList's size is only " + i);
            }
        }
        Node<T> newElement = new Node<>(element, buff.getReference());
        buff.setReference(newElement);

    }

    public void merge(KarimLinkedList<T> data){    //Нужно ли делать новый линкед лист, когда мерджим???
        Node<T> buff = head;
        while(!buff.getReference().equals(null)){
            buff = buff.getReference();
        }
        buff.setReference(data.head);
    }

    // Тут надо исключения
    public void removeByIndex(int index){
        if(index<0){
            throw new IndexOutOfBoundsException("Index must be natural.");
        }
        Node<T> buff = head;
        int i = -1;
        while (i+1 != index){
            i++;
            buff = buff.getReference();
            if (buff == null){
                throw new IndexOutOfBoundsException("LinkedList's size is only " + i);
            }
        }
        Node<T> buff2 = buff.getReference();
        buff.setReference(buff2.getReference());
    }

    public void removeByValue(T element){
        int i = -1;
        Node<T> buff = head;
        while(i+1 != this.indexOf(element)) {
            i++;
            buff = buff.getReference();
            if (buff == null){
                throw new NoSuchElementException();
            }
        }
        Node<T> buff2 = buff.getReference();
        buff.setReference(buff2.getReference());
    }

    public T get(int index){
        if(index<0){
            throw new IndexOutOfBoundsException("Index must be natural.");
        }
        Node<T> buff = head;
        int i =0;
        while (i != index){
            i++;
            buff = buff.getReference();
            if (buff == null){
                throw new IndexOutOfBoundsException("LinkedList's size is only " + i);
            }
        }
        return buff.getValue();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof KarimLinkedList)) return false;
        KarimLinkedList<T> that = (KarimLinkedList<T>) o;
        if(this.size() != that.size()) return false;

        Node<T> buff1 = this.head;
        Node<T> buff2 = that.head;
        for (int i =0; i<that.size();i++) {
            if (buff1.getValue() != buff2.getValue()) return false;
            buff1 = buff1.getReference();
            buff2 = buff2.getReference();
        }

        return true;

    }

    @Override
    public int hashCode() {    // ???
        return Objects.hash(head);
    }

    //Testing
    public static void main(String[] args) {
        KarimLinkedList a = new KarimLinkedList(10);
        a.addFirst(1);
        a.addFirst(51984);
        System.out.println(a.head.value + "\n");
        a.removeByIndex(1);
        System.out.println(a.get(2));
    }

}
