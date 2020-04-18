package HomeWork.ADS._Codeforces._1;

import java.util.Scanner;

public class taskD {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] ar = new int[n];

        ar[0] = sc.nextInt() * sc.nextInt();
        for(int i = 1; i < n; i++){
            ar[i] = sc.nextInt() * sc.nextInt() + ar[i-1];
        }

        //последовательная структура готова

        int l, r, c, x;

        for(int i = 0; i < m; i++){
            x = sc.nextInt();
            l = 0;
            r = n - 1;
            c = (l + r) / 2;
            if(x <= ar[l]){
                System.out.print("1 \n");
            }else{
                if(x > ar[r-1]){
                    System.out.print(n + "\n");
                }else{
                    while(l < r){
                        if( x <= ar[c] && x > ar[c-1]){
                            break;
                        }
                        if( x > ar[c]){
                            l = c + 1;
                        }else{
                            r = c - 1;
                        }
                        c = (l + r) / 2;
                    }
                    System.out.print(c+1 + "\n");
                }
            }
        }
    }
}
