package HomeWork.prog._7;


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
        int mainCounter = 0;

        mainCounter = (int) set.parallelStream().filter(i -> {
            int counterOfVowel = 0;

            for(int j = 0; j < i.length(); j++){
                if(vowels.contains((String.valueOf(i.charAt(j))))){
                    counterOfVowel++;
                }
            }
            if(counterOfVowel > 3){
                return true;
            }
            return false;
        }).count();

        System.out.println(mainCounter);


    }
}
