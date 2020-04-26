package HomeWork.prog._7;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class StreamTask2 {
    public static void main(String[] args) {

        Set<String> set = new HashSet<>();
        Random rnd = new Random();

        for(int i = 0; i < 10; i++){
          set.add(Integer.toString(rnd.));
        }

        String symbols = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";




        int mainCounter = 0;
        int counterOfVowel = 0;

        set.parallelStream().forEach(System.out::println);
        System.out.println("^ before filter");

        set


    }
}
