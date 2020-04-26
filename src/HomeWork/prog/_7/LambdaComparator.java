package HomeWork.prog._7;

import HomeWork.prog._1DONE.Pare;

import java.util.Arrays;
import java.util.List;

public class LambdaComparator {
    public static void main(String[] args) {
        List<Pare<String, Integer>> pares = Arrays.asList(
                new Pare<>("123qwe", 40),
                new Pare<>("24qwerty", 55),
                new Pare<>("421wer", 31));

        System.out.println("Before sort:");
        for (Pare<String, Integer> pare : pares) {
            System.out.println(pare);
        }

        pares.sort((o1, o2) -> {
            if (o1.getValue2().equals(o2.getValue2()))
                return o1.getValue1().compareTo(o2.getValue1());
            else return o1.getValue2() - o2.getValue2();
        });

        System.out.println("\nAfter sort:");
        for (Pare<String, Integer> pare : pares) {
            System.out.println(pare);
        }
    }
}