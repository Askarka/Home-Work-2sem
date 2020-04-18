package HomeWork.ADS._Codeforces._1;

import java.util.Arrays;
import java.util.Scanner;

public class taskB {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];

        for(int i = 0;i < n; i++){
            array[i] = sc.nextInt();
        }

        Arrays.sort(array);

        //Последовательная структура готова

        int m = sc.nextInt();
        int x,l,r,c;

        for(int i = 0; i < m; i++){

            x = sc.nextInt();
            l = 0;
            r = n - 1;
            c = (l + r) / 2;

            if(array[r] <= x){
                System.out.print(n + "\n");
            }else{
                if(x < array[l]){
                    System.out.print(0 + "\n");
                }else{
                    while(l < r){

                        if(x >= array[c] && x < array[c+1]){
                            break;
                        }

                        if(x < array[c]){
                            r = c - 1;
                        }else{
                            l = c + 1;
                        }

                        c = (l + r) / 2;
                    }
                    System.out.print(c+1 + "\n");
                }
            }
        }
    }
}
