package SemesterWork.ADS.CircleList;

import java.util.NoSuchElementException;

public class CircleList1<T> {
//
//    Эта структура данных нужна для экономии места
//    Т.е. можно перезаписывать старые ненужные элементы
//    (Вся идея кольцевых структур в экономии памяти)

    private class Participant<T>{
        public String name;
        public String gender;
        public Participant<T> prev;
        public Participant<T> next;

        public Participant(String name, String gender, Participant<T> prev, Participant<T> next) {
            this.name = name;
            this.gender = gender;
            this.prev = prev;
            this.next = next;
        }


        public Participant(Participant<T> otherP){
            // ДОПИСАТЬ

        }

        // equals ЕГО СТОИТ ДЕЛАТЬ ТОЛЬКО ЕСЛИ МЫ В СОРТЕ И ДЕЛИТЕ ХОТИМ СРАВНИВАТЬ НЕ СТРИНГИ А ПРОСТО У БУФЕРА ВЫЗЫВАТЬ EQUALS
        public String getName(){
            return this.name;
        }
        public String getGender(){
            return gender;
        }

        public Participant<T> getPrev() {
            return prev;
        }

        public void setPrev(Participant<T> prev) {
            this.prev = prev;
        }

        public void setNext(Participant<T> next){
            this.next = next;
        }
        public Participant<T> getNext(){
            return this.next;
        }
    }

    // Fields
    private Participant<T> head;
    private int size;

    //Constructors
    public CircleList1(String headName, String gender){
        this.head = new Participant<>(headName, gender, null, null);
    }
//  public CircleList(Что-то с файлами и считыванием){}

    //Methods
    public void insert(String name, String gender){
        Participant<T> buff = new Participant<>(name, gender, this.head.getPrev(),this.head);
        head.getPrev().setNext(buff);
        head.setPrev(buff);
        size++;
    }


    //throws NoSuckelement exception
    public void delete(String name, String gender){
        Participant<T> buff = head;
        int c =0;
        while(! (name.equals(buff.name) && gender.equals(buff.gender))){
            buff = buff.getNext();
            c++;
            if (c == this.size()) {
                throw new NoSuchElementException();
            }
        }
        buff.getPrev().setNext(buff.getNext());
        buff.getNext().setPrev(buff.getPrev());
        size--;
    }

    public int size(){
        Participant<T> buff = head;
        int c = 1;
        while(!buff.getNext().equals(this.head)){
            c++;
        }
        return  c;
    }

    public CircleList1[] gender(){
        CircleList1[] a = new CircleList1[2];
        return null;

    }

    public Participant<T> last(int k){
        return null;
    }

}
