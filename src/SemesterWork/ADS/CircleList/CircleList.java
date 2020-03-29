package SemesterWork.ADS.CircleList;

import sun.awt.geom.AreaOp;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLOutput;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CircleList {
//    Эта структура данных нужна для экономии места
//    Т.е. можно перезаписывать старые ненужные элементы
//    (Вся идея кольцевых структур в экономии памяти)

    //ToDo разобраться с модификаторами доступа (Карим)
    //ToDo show()
    // TODo sort()

     private class Participant{
        private String name;
        private boolean gender;
        private Participant next;

        public Participant(String name, String gen, Participant next) {
            this.name = name;
            this.gender = gen.equals("male");
            this.next = next;//Todo разузнать, не нарушает ли это принципа SingleResponsibilities? (+относится ли это к бизнес-логике)
        }

         public Participant(boolean gen, String name, Participant next) {
             this.name = name;
             this.gender = gen;
             this.next = next;
         }

        public Participant(Participant otherP){
            this.name = otherP.name;
            this.gender = otherP.gender;
            this.next = otherP.next;
        }

        // equals ЕГО СТОИТ ДЕЛАТЬ ТОЛЬКО ЕСЛИ МЫ В СОРТЕ И ДЕЛИТЕ ХОТИМ СРАВНИВАТЬ НЕ СТРИНГИ А ПРОСТО У БУФЕРА ВЫЗЫВАТЬ EQUALS
        public String getName(){
            return this.name;
        }
        public boolean getGender(){
            return this.gender;
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
     private Participant tail;
    private int size;

    //Constructors
//Вроде готово
//   Todo протестировать на show и на двух файлах, которые залиты в этот пакет
//    Todo добавить считывание с файла по относительному пути
    public CircleList(String filename) {

        try {
            File input = new File(filename);
            Scanner scanner = new Scanner(input);

//TODo вынести scanner.next() в отдельную переменную, так как каждый раз при сравнении на equals мы теряем элемент
            if(scanner.next().equals("male") || scanner.next().equals("female")){

                this.head = new Participant(scanner.next().equals("male"), scanner.next(), null);
                Participant buf = this.head;
                this.size = 1;

                while (scanner.hasNext()){
                    buf.setNext(new Participant(scanner.next().equals("male"), scanner.next(), null));
                    buf = buf.getNext();
                    this.size++;
                }
                buf.setNext(this.head);
                this.tail = buf;
            }else{

                this.head = new Participant(scanner.next(), scanner.next(), null);
                Participant buf = this.head;
                this.size = 1;

                while (scanner.hasNext()){
                    buf.setNext(new Participant(scanner.next(), scanner.next(),null));
                    buf = buf.getNext();
                    this.size++;
                }
                buf.setNext(this.head);
                this.tail = buf;
            }

            scanner.close();
        }catch (FileNotFoundException e){
        System.out.println("Exeption!");
        }
    }

    private void calculateSize(){ //Мб делитнуть
        Participant buff = head;
        int size = 1;
        while(!buff.getNext().equals(this.head)){
            size++;
        }
    }

//    Methods
    public void insert(String name, String gender){
        Participant buff = new Participant(name, gender, this.head);
        this.tail = buff;
        size++;
    }


    //throws NoSuckelement exception
//    public void delete(String name){//TOdo поправить
//        Participant buff = head;
//        int c =0;
//        while(! (name.equals(buff.name) && gender.equals(buff.gender))){
//            buff = buff.getNext();
//            c++;
//            if (c == this.size()) {
//                throw new NoSuchElementException();
//            }
//        }
//        buff.getPrev().setNext(buff.getNext());
//        buff.getNext().setPrev(buff.getPrev());
//        size--;
//    }

    public int size(){
        return  size;
    }

//    public CircleList[] gender(){
//       //Todo поправить, чтобы работало   +
////        TODO тестить, возможно не работает
//        CircleList[] a = new CircleList[2];
//        int maleCounter = 0;
//        int femaleCounter = 0;
//        Participant buff = head;
//        // НУЖНЫ ДВЕ ПУСТЫЕ ГОЛОВЫ, тк мы не знаем, кто в начале нашего кольцевого листа
//        a[0].head = new Participant("a",'a',null,null);
//        a[1].head = new Participant("a",'a',null,null);
//
//        for(int i = 1; i <= this.size; i++){
//            if (buff.getGender() == 'F') {
//                a[0].insert(buff.name,buff.gender);
//            } else{
//                a[1].insert(buff.name,buff.gender);
//            }
//
//            buff = buff.getNext();
//        }
//
//        // КАК ДУМАЕШЬ, СРАБОТАЕТ ЛИ ЭТО? Тип нужно две болванки в начале убрать, тк они пустые и не важны для наших двух списков
//        a[0].head = a[0].head.getNext();
//        a[1].head = a[1].head.getNext();
//
//        return a;
//
//    }

    public Participant last(int k){
        boolean[] arr = new boolean[size];
//Todo написать свою реализацию
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

    public static void main(String[] args) {


//        CircleList a = new CircleList("test1.txt");  Это для проверки работы конструктора
    }
}
