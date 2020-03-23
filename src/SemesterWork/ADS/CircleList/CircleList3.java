package SemesterWork.ADS.CircleList;

import java.util.NoSuchElementException;

public class CircleList3 {
//
//    Эта структура данных нужна для экономии места
//    Т.е. можно перезаписывать старые ненужные элементы
//    (Вся идея кольцевых структур в экономии памяти)

    //ToDo разобраться с модификаторами доступа
    //ToDO file reader
    //ToDo show()
    // TODo sort()

    private class Participant{
        public String name;
        public char gender;
        public Participant prev;
        public Participant next;

        public Participant(String name, char gender, Participant prev, Participant next) {
            this.name = name;
            this.gender = gender;
            this.prev = prev;
            this.next = next;
        }

        public Participant(Participant otherP){
            this.name = otherP.name;
            this.gender = otherP.gender;
            this.prev = otherP.prev;
            this.next = otherP.next;
        }

        // equals ЕГО СТОИТ ДЕЛАТЬ ТОЛЬКО ЕСЛИ МЫ В СОРТЕ И ДЕЛИТЕ ХОТИМ СРАВНИВАТЬ НЕ СТРИНГИ А ПРОСТО У БУФЕРА ВЫЗЫВАТЬ EQUALS
        public String getName(){
            return this.name;
        }
        public char getGender(){
            return gender;
        }

        public Participant getPrev() {
            return prev;
        }

        public void setPrev(Participant prev) {
            this.prev = prev;
        }

        public void setNext(Participant next){
            this.next = next;
        }
        public Participant getNext(){
            return this.next;
        }
    }

    // Fields
    private Participant head;
    private int size;

    //Constructors
    public CircleList3(String headName, char gender){
        this.head = new Participant(headName, gender, null, null);
    }
//  public CircleList(Что-то с файлами и считыванием){}

    private void calculateSize(){
        Participant buff = head;
        int size = 1;
        while(!buff.getNext().equals(this.head)){
            size++;
        }
    }

    //Methods
    public void insert(String name, char gender){
        Participant buff = new Participant(name, gender, this.head.getPrev(),this.head);
        head.getPrev().setNext(buff);
        head.setPrev(buff);
        size++;
    }


    //throws NoSuckelement exception
    public void delete(String name, String gender){
        Participant buff = head;
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
        return  size;
    }

    public CircleList3[] gender(){
//        TODO тестить, возможно не работает
        CircleList3[] a = new CircleList3[2];
        int maleCounter = 0;
        int femaleCounter = 0;
        Participant buff = head;
        // НУЖНЫ ДВЕ ПУСТЫЕ ГОЛОВЫ, тк мы не знаем, кто в начале нашего кольцевого листа
        a[0].head = new Participant("a",'a',null,null);
        a[1].head = new Participant("a",'a',null,null);

        for(int i = 1; i <= this.size; i++){
            if (buff.getGender() == 'F') {
                a[0].insert(buff.name,buff.gender);
            } else{
                a[1].insert(buff.name,buff.gender);
            }

            buff = buff.getNext();
        }

        // КАК ДУМАЕШЬ, СРАБОТАЕТ ЛИ ЭТО? Тип нужно две болванки в начале убрать, тк они пустые и не важны для наших двух списков
        a[0].head = a[0].head.getNext();
        a[1].head = a[1].head.getNext();

        return a;

    }

    public Participant last(int k){
        boolean[] arr = new boolean[size];
//Todo попробовать переписать
        for(int j = 0; j < arr.length; j++){
            arr[j] = true;
        }

        int j = 0;
        int trueCounter = 0;
        int c = 0;

        while (true) {
            int buffer = j;

            if (j+1 == arr.length){
                j = 0;
            } else { j++; }

            while(! arr[j]){
                c++;
                j++;
                if (j == arr.length){
                    j = 0;
                }
                if(c == arr.length-1) {
                    Participant buff = head;
                    for(int i = 0; i<buffer; i++){
                        buff = buff.getNext();
                    }
                    return buff;
                }

            }

            trueCounter++;
            if(trueCounter == k){
                arr[j] = false;
                trueCounter = 0;
            }

            c = 0;
        }

    }
//TODO Show
//TODO Sort
//TODO конструктор
}
