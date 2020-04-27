package HomeWork.prog._7DONE;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class StreamTask1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] array1 = new int[n];
        int[] array2 = new int[m];

        Random rnd = new Random();

        for(int i = 0; i < n; i++){
            array1[i] = rnd.nextInt();
        }
        for(int i = 0; i < m; i++){
            array2[i] = rnd.nextInt();
        }

        int maxOfArray2 = Arrays.stream(array2).max().getAsInt();

        Arrays.stream(array1).filter(i -> i > maxOfArray2).forEach(System.out::println);
    }
}
