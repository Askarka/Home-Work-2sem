package HomeWork.prog._7DONE;

import java.util.HashMap;
import java.util.Random;
import java.util.stream.Collectors;

public class StreamTask3 {
    public static void main(String[] args) {
        Random rnd = new Random();
        HashMap<Integer, Integer> dictionary = new HashMap<>();
        for (int i = 1; i < rnd.nextInt(50)+1; i++) {
            dictionary.put(i, (rnd.nextInt(50)+1));
        }
        System.out.println("Concatenated keys:");
        System.out.println(dictionary.keySet().stream().map(x -> x + " ").collect(Collectors.joining()));
        System.out.println("Concatenated values (bonus):");
        System.out.println(dictionary.values().stream().map(x -> x + " ").collect(Collectors.joining()));
    }
}
