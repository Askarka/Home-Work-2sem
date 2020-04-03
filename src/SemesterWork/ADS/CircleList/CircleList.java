package SemesterWork.ADS.CircleList;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CircleList {

//    Эта структура данных нужна для экономии места
//    Т.е. можно перезаписывать старые ненужные элементы
//    Вся идея кольцевых структур в экономии памяти

    // TODo sort()

     private class Participant implements Comparable<Participant>{
        private String name;
        private boolean gender;
        private Participant next;

        public Participant(String name, String gen, Participant next) {    // T = O(1)    M = O(1)
            this.name = name;
            this.gender = gen.equals("male");
            this.next = next;
        }

        public Participant(boolean gen, String name, Participant next) {    // T = O(1)    M = O(1)
            this.name = name;
            this.gender = gen;
            this.next = next;
        }

        public Participant(String name, boolean gender) {    // T = O(1)    M = O(1)
            this.name = name;
            this.gender = gender;
        }

        public Participant(Participant otherP){    // T = O(1)    M = O(1)
            this.name = otherP.name;
            this.gender = otherP.gender;
            this.next = otherP.next;
        }

        public String getName(){    // T = O(1)    M = O(1)
            return this.name;
        }
        public boolean getGender(){    // T = O(1)    M = O(1)
            return this.gender;
        }
        public void setNext(Participant next){    // T = O(1)    M = O(1)
            this.next = next;
        }
        public Participant getNext(){    // T = O(1)    M = O(1)
            return this.next;
        }

        @Override
        public int compareTo(Participant otherP){    // T = O(1)    M = O(1)

            if (this.getName().equals(otherP.getName())) {
                if(this.getGender() == otherP.getGender()){
                    return 0;
                } else if(this.getGender() == false) {
                    return -1;
                } else {
                    return 1;
                }
            }

            return this.getName().compareTo(otherP.getName());
        }
    }

    // Fields
     private Participant head;
     private Participant tail;
     private int size;

    //Constructors
    public CircleList(String filename) {    // T = O(n)    M = O(n)
        
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
            }
            this.tail.setNext(this.head);

            scanner.close();
        }catch (FileNotFoundException e){
            e.getMessage();
        }
    }

    public CircleList(Participant head) {    // T = O(1)    M = O(1)
        this.head = head;
        this.tail = head;
        this.size = 1;
    }

    public CircleList() {    // T = O(1)    M = O(1)
    }

    //    Methods
    public void show(){     // T = O(n)    M = O(1) 
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
    
   
    public void insert(String name, String gender){    // T = O(1)    M = O(1)

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

    public void insertForParticipant(Participant p){    // T = O(1)    M = O(1)
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

    public void delete(String name){    // T = O(n+1) (???)    M = O(1)
        
        Participant buff = head;
        int c = 0;

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
    
    public void swap(Participant  p1, Participant p2){    // T = O(1)    M = O(1)
        if ( p1==p2 || p1 == null || p2 == null ){
            throw new IllegalArgumentException();
        }

        Participant buff = new Participant(p1);
        p1.name = p2.name;
        p1.gender = p2.gender;
        p2.name = buff.name;
        p2.gender = buff.gender;

    }
    
    public void sort(String name){}
    
    //ToDo чтобы принимал имя, а потом сдвигал бошку до этого имени
    public CircleList sortWithAddArray(CircleList data){
        int length = data.size();
        String[] dataString = new String[length];
        Participant buff = data.head;

        for(int  i = 0; i< length; i++){
            dataString[i] = buff.getName() + ((buff.gender) ? " male" : " female");
            buff = buff.getNext();
        }

        Arrays.sort(dataString);

        String[] partcipantBuff = new String[2];
        CircleList newData = new CircleList();

        for(int i = 0; i < length; i++){
            partcipantBuff = dataString[i].split(" ");
            newData.insert(partcipantBuff[0], partcipantBuff[1]);
        }
        return newData;
    }

    public Participant last(int k){    // T = O(n)    M = O(1)
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
    
    public CircleList[] gender(){    // T = O(n)    M = O(n)
        CircleList m = new CircleList();
        CircleList f = new CircleList();

        Participant buff = this.head;

        for(int i = 0; i < this.size; i++){
            if(buff.gender){
                m.insert(buff.name, "male");
            }else{
                f.insert(buff.name, "female");
            }
            buff = buff.next;
        }

        CircleList[] result = new CircleList[2];
        result[0] = m;
        result[1] = f;
        return result;
    }

    public int size(){    // T = O(1)    M = O(1)
        return  size;
    }

    public static void main(String[] args) {


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
