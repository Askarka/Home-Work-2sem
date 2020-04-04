package SemesterWork.ADS.CircleList;

import java.io.FileNotFoundException;
import java.io.*;
import java.util.concurrent.TimeUnit;

public class Tester {

    public static String[] specialStringArrayGenerator(int size){
        String[] str = new String[size];
        char[] s = new char[10];

        for(int i = 0; i < size; i++){
            for(int j =0; j<10; j++){
                s[j] = (char) ((int) (97 + Math.random()*25 ));
            }

            s[0] = Character.toUpperCase(s[0]);

            str[i] = (Math.random() > 0.5) ? new String(s) + " male" : new String(s) + " female";
        }

        return str;
    }

    public static void newData(String[] array) throws IOException {
        int n = array.length;
        String fileName = n + ".txt";

        FileWriter fw = new FileWriter( fileName);
        for(int  i = 0; i<n; i++){
            fw.write(array[i] + "\n");
        }
        fw.close();
    }

    public static void main(String[] args) throws IOException {

        // Todo show 100 500 1000
        // TODO insert()
        // ToDo delete()
        // Todo sort 100 500 1000 разные сорты протестить


        FileWriter fw = new FileWriter("results.txt");
        long t0, t1, average = 0, usedBytes;
        CircleList a;

//        usedBytes = (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory());
//
//        a = new CircleList("1000.txt");
//
//        usedBytes = (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) - usedBytes;
//        fw.write( usedBytes/1024 + " kb" + "\n" + "\n");

        // Constructors
        for(int i = 0; i < 100; i++){

            t0 = System.nanoTime();
            a = new CircleList();
            t1 = System.nanoTime();
            average+=(t1 - t0)/1000/100;

        }

        fw.write( "Empty constructor take in average: "+ average + " microseconds"+  "\n" + "\n");
        average=0;

        for(int i = 0; i < 100; i++){

            t0 = System.nanoTime();
            a = new CircleList("100.txt");
            t1 = System.nanoTime();
            average+=(t1 - t0)/1000/100;

        }
        fw.write( "Constructor for 100 elements take in average: "+ average + " microseconds"+  "\n" + "\n");
        average=0;

        for(int i = 0; i < 100; i++){

            t0 = System.nanoTime();
            a = new CircleList("500.txt");
            t1 = System.nanoTime();
            average+=(t1 - t0)/1000/100;

        }
        fw.write( "Constructor for 500 elements take in average: "+ average + " microseconds"+  "\n" + "\n");
        average=0;

        for(int i = 0; i < 100; i++){

            t0 = System.nanoTime();
            a = new CircleList("1000.txt");
            t1 = System.nanoTime();
            average+=(t1 - t0)/1000/100;

        }
        fw.write( "Constructor for 1000 elements take: "+ average + " microseconds" + "\n" + "\n");
        average=0;

        // last() methods
        a = new CircleList("100.txt");
        for(int i = 0; i < 100; i++){

            t0 = System.nanoTime();
            a.last(25);
            t1 = System.nanoTime();
            average+=(t1 - t0)/100;

        }
        fw.write( "last() for 100 elements take in average: "+ average + " nanoseconds" + "\n" + "\n");
        average=0;

        a = new CircleList("500.txt");
        for(int i = 0; i < 100; i++){

            t0 = System.nanoTime();
            a.last(125);
            t1 = System.nanoTime();
            average+=(t1 - t0)/100;

        }
        fw.write( "last() for 500 elements take in average: "+ average + " nanoseconds"+  "\n" + "\n");
        average=0;

        a = new CircleList("1000.txt");
        for(int i = 0; i < 100; i++){

            t0 = System.nanoTime();
            a.last(250);
            t1 = System.nanoTime();
            average+=(t1 - t0)/100;

        }
        fw.write( "last() for 1000 elements take in average: "+ average + " nanoseconds"+ "\n" + "\n");
        average=0;

//        // insert() and delete()
//        a = new CircleList("100.txt");
//        long t2, t3, average1 = 0, average2 = 0;
//        String name, gender;
//
//        for(int i = 0; i < 100; i++){
//            name = i+1+". Participant";
//            gender = (Math.random() > 0.5) ? "male" : "female";
//
//            t0 = System.nanoTime();
//            a.insert(name,gender);
//            t1 = System.nanoTime();
//            average1+=(t1 - t0)/100;
//            System.out.println("SUCK MY DICK!!!");
//            a.show();
//
//            t2 = System.nanoTime();
//            a.delete(name);
//            t3 = System.nanoTime();
//            average2+=(t1 - t0)/100;
//        }
//
//        fw.write( "insert() take in average: "+ average1 + " nanoseconds"+  "\n" + "\n");
//        fw.write( "delete() take in average: "+ average2 + " nanoseconds"+  "\n" + "\n");

//        CircleList b,c,d;
//        b = new CircleList("100.txt");
//        c = new CircleList("500.txt");
//        d = new CircleList("1000.txt");
//        long t2, t3,t4,t5, average1 = 0, average2 = 0, average3 = 0;
//
//        for(int i = 0; i < 100; i++){
//            t0 = System.nanoTime();
//            b.show();
//            t1 = System.nanoTime();
//            average1+=(t1 - t0)/100;
//
//            t2 = System.nanoTime();
//            c.show();
//            t3 = System.nanoTime();
//            average2+=(t3 - t2)/100;
//
//            t4 = System.nanoTime();
//            d.show();
//            t5 = System.nanoTime();
//            average3+=(t5 - t4)/100;
//        }
//
//        fw.write( "show() for 100 take in average: "+ average1/ 1000 + " microseconds"+  "\n" + "\n");
//        fw.write( "show() for 500 take in average: "+ average2/ 1000 + " microseconds"+  "\n" + "\n");
//        fw.write( "show() for 1000 take in average: "+ average3 / 1000  + " microseconds"+  "\n" + "\n");

        fw.close();

        //GENERATOR
        //Tester.newData(Tester.specialStringArrayGenerator(1000));

    }
}
