package HomeWork.ADS._Codeforces._1;

import java.util.Arrays;
import java.util.Scanner;

public class taskС {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int l = sc.nextInt();
        int [] ar = new int[n];
        double max;

        for(int i = 0; i < n; i++){
            ar[i] = sc.nextInt();
        }

        Arrays.sort(ar);

        max = Math.max(ar[0], (l - ar[ar.length - 1]));

        for(int i = 0; i < n-1; i++){
            if(max < ((ar[i+1] - ar[i]) / 2.0)){
                max = (ar[i+1] - ar[i]) / 2.0;
            }
        }
        System.out.print(max);
    }
}
//0 3 5 7 9 14 15