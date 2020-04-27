package HomeWork.prog._7DONE;


import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class StreamTask2 {
    public static void main(String[] args) {

        Set<String> set = new HashSet<>();
        Random rnd = new Random();
        String symbols = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

        StringBuilder appender = new StringBuilder();
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < rnd.nextInt(15) + 5; j++){
                appender.append(symbols.charAt(rnd.nextInt(52)));
            }
            set.add(appender.toString());
            appender = new StringBuilder();
        }

        set.parallelStream().forEach(System.out::println);
        System.out.println("^ before filter");


        String vowels = "AEIOUYaeiouy";
        int mainCounter;

        mainCounter = (int) set.parallelStream().filter(i -> {
            int counterOfVowel = 0;

            for(int j = 0; j < i.length(); j++){
                if(vowels.contains((String.valueOf(i.charAt(j))))){
                    counterOfVowel++;
                }
            }
            return counterOfVowel > 3;
        }).count();

        System.out.println(mainCounter);


    }
}
