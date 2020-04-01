package SemesterWork.ADS.CircleList;

import java.io.FileNotFoundException;
import java.io.*;
import java.util.concurrent.TimeUnit;

public class Tester {

    private static String[] specialStringArrayGenerator(int size){
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
//        CircleList a = new CircleList();
//
//        long t0 = System.nanoTime();
//        for(int i =0; i < 1000; i++){
//            a.insert(i+". Participant",  (int) (Math.random()+1) + "");
//        }
//        long t1 = System.nanoTime();
//        System.out.println((t1 - t0)/1000 + " microseconds");
//        System.out.println();
//
//        t0 = System.nanoTime();
//        System.out.println(a.last(15));
//        t1 = System.nanoTime();
//        System.out.println((t1 - t0)/1000 + " microseconds");
//        System.out.println();

        // это байты, я чекнул
        System.out.println((int) (Runtime.getRuntime().maxMemory()/ Math.pow(2,20)) + " mb"); // количество свободной памяти, доступной JVM
        System.out.println((int) (Runtime.getRuntime().totalMemory()/ Math.pow(2,20)) + " mb");  // количество памяти, которое юзает JVM

        //GENERATOR
        //Tester.newData(Tester.specialStringArrayGenerator(1000));



//        FileReader fr = new FileReader( "sample2.txt" );
//        fr.close();


    }
}
