package SemesterWork.ADS.CircleList;

import com.sun.tools.corba.se.idl.PragmaEntry;
import com.sun.xml.internal.ws.wsdl.writer.document.Part;
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

         public Participant(String name, boolean gender) {
             this.name = name;
             this.gender = gender;
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
    public CircleList(String filename) {

        try {
            File input = new File(filename);
            Scanner scanner = new Scanner(input);

            String buff = scanner.next();

            if(buff.equals("male") || buff.equals("female")){

                this.head = new Participant(buff.equals("male"), scanner.next(), null);
                Participant buf = this.head;
                this.size = 1;

                while (scanner.hasNext()){
                    buf.setNext(new Participant(scanner.next().equals("male"), scanner.next(), null));
                    buf = buf.getNext();
                    this.size++;
                }
                this.tail = buf;
                this.tail.setNext(this.head);
            }else{

                this.head = new Participant(buff, scanner.next(), null);
                Participant buf = this.head;
                this.size = 1;

                while (scanner.hasNext()){
                    buf.setNext(new Participant(scanner.next(), scanner.next(),null));
                    buf = buf.getNext();
                    this.size++;
                }
                this.tail = buf;
                this.tail.setNext(this.head);
            }

            scanner.close();
        }catch (FileNotFoundException e){
        System.out.println("Exeption!");
        }
    }

    public CircleList(Participant head) {
        this.head = head;
        this.tail = head;
        this.size = 1;
    }

    public CircleList() {
    }

    //    Methods
    public void show(){
        Participant buff = this.head;

        int spaceNum = buff.name.length();

        for(int i = 0; i < size-1; i++){
            if(buff.next.name.length() > buff.name.length()){
                spaceNum = buff.next.name.length();
            }
            buff = buff.next;
        }
        spaceNum+=4;

        String format = "%-" + spaceNum + "s";

        buff = this.head;

        for(int i = 0; i < size; i++){
            System.out.printf(i+1 + ". " + format, buff.name + " ");
            System.out.println((buff.gender ? "male" : "female"));
            buff = buff.next;
        }
    }

    public void insert1(String name, String gender){ //TODO мб делитнуть, чек следующий метод

        Participant buff = new Participant(name, gender, this.head);

        if(this.head == null){
            this.head = buff;
        }

        if(this.tail == null){
            this.tail = buff;
        }

        this.tail.next = buff;
        this.tail = buff;
        size++;
    }

    public void insert2(Participant p){ //вроде такой требовалось по тз
        Participant buff = new Participant(p);

        if(this.head == null){
            this.head = buff;
        }

        if(this.tail == null){
            this.tail = buff;
        }

        this.tail.next = buff;
        this.tail = buff;
        buff.next = this.head;
        size++;
    }

    public void delete(String name){

        Participant buff = head;
        int c =0;

        while(!name.equals(buff.next.name)){
            if (c == this.size()) {
                throw new NoSuchElementException();
            }
            c++;
            buff = buff.getNext();
        }

        buff.setNext(buff.next.next);
        size--;
    }

    public int size(){
        return  size;
    }

    public CircleList[] gender(){
        CircleList m = new CircleList();
        CircleList f = new CircleList();

        Participant buff = this.head;

        for(int i = 0; i < this.size; i++){
            if(buff.gender){
                m.insert1(buff.name, "male");
            }else{
                f.insert1(buff.name, "female");
            }
            buff = buff.next;
        }

        CircleList[] result = new CircleList[2];
        result[0] = m;
        result[1] = f;
        return result;
    }


//    public CircleList[] gender(){
//        CircleList[] a = new CircleList[2];
//        int maleCounter = 0;
//        int femaleCounter = 0;
//        Participant buff = head;// НУЖНЫ ДВЕ ПУСТЫЕ ГОЛОВЫ, тк мы не знаем, кто в начале нашего кольцевого листа
//
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

    public Participant lastK(int k){
        boolean[] arr = new boolean[size];
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

    public Participant lastA(int k){
        int resNum;
        int res = 0;

            for (int i=1; i<= size; ++i) {
                res = (res + k) % i;
            }
            resNum = res + 1;

        Participant buff = this.head;
        for(int i = 0; i < resNum; i++){
            buff = buff.next;
        }
        return buff;
    }

    public static void main(String[] args) throws FileNotFoundException {


        CircleList a = new CircleList("test1.txt"); //Для проверки конструктора
        a.show();

        System.out.println();

        CircleList b = new CircleList("test2.txt"); //Для проверки конструктора
        b.show();


        System.out.println();

        CircleList[] mas = b.gender();

        mas[0].show();
        System.out.println();
        mas[1].show();

//        TODO доделать тесты всего оставшегося
        //сделаны тесты : конструктора, show, insert (both), genderA.
        //TODO Карим, можешь, пожалуйста, написать, что осталось протестироватьё
        //TODO осталось сделать тесты:
    }
}
