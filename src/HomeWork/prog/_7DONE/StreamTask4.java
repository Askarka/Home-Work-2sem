package HomeWork.prog._7DONE;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class StreamTask4 {
    public static void main(String[] args) {

        Set<String> set = new HashSet<>();
        Random rnd = new Random();
        String symbols = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

        StringBuilder appender = new StringBuilder();
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < rnd.nextInt(15); j++){
                appender.append(symbols.charAt(rnd.nextInt(52)));
            }
            set.add(appender.toString());
            appender = new StringBuilder();
        }

        set.parallelStream().forEach(System.out::println);
        System.out.println("^ before filter");

        int mainCounter = set.parallelStream().filter(i -> {
            return i.length() > 5;
        }).mapToInt(String::length).sum();

        System.out.println(mainCounter);


    }
}
