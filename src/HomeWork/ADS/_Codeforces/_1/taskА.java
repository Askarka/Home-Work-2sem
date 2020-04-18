package HomeWork.ADS._Codeforces._1;

import java.util.Arrays;
import java.util.Scanner;

public class taskА {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];

        for(int i = 0; i < n; i++){
            array[i] = sc.nextInt();
        }

        Arrays.sort(array);

// Последовательная структура готова

        int m = sc.nextInt();
        int x;
        int flag1;
        int flag2;
        int cursor;


        for(int i = 0; i < m; i++){

            x = sc.nextInt();
            flag1 = 0;
            flag2 = n-1;
            cursor = (flag1 + flag2) / 2;

            if(array[flag2] < x){
                System.out.println(n + " ");
            }else{
                while(flag1 <= flag2){
                    if(array[cursor] < x && array[cursor +1] >= x){
                        break;
                    }

                    if(array[cursor] >= x){
                        flag2 = cursor - 1;
                    }else{
                        flag1 = cursor + 1;
                    }

                    cursor = (flag1 +flag2) / 2;
                }
                if(flag1 > flag2){
                    cursor = -1;
                }
                System.out.print(cursor + 1);
                System.out.print(" ");
            }
        }
    }
}
/*
10
7 4 1 3 9 2 4 5 9 8
4
6 1 9 4

 */
