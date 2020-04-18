package HomeWork.ADS._Codeforces._1;

import java.util.Scanner;

public class wrongtaskA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] kv = new int[2][n];
        int sizeOfUn = 0;
        int buff1;
        int buff2;

        for(int i = 0; i < n; i++){
            buff1 = sc.nextInt();
            buff2 = containsNum(buff1, kv, n);
            if(buff2 > 0){
                kv[1][buff2]++;
            }else{
                kv[0][sizeOfUn] = buff1;
                kv[1][sizeOfUn] = 1;
                sizeOfUn++;
            }
        }

        // Структура готова


        StringBuilder res = new StringBuilder();

        int m = sc.nextInt();
        buff2 = 0;

        for(int i = 0; i < m; i++){
            buff1 = sc.nextInt();
            for(int j = 1; j < buff1; j++){
                if(containsNum(j, kv, n) >= 0){
                    buff2 = buff2 + kv[1][containsNum(j, kv, n)];
                }
            }
            res.append(buff2).append(" ");
            buff2 = 0;
        }

        System.out.print(res);

        System.out.println();
        for(int i = 0; i < n; i++){
            System.out.print(kv[0][i] +" ");
        }
        System.out.println();
        for(int i = 0; i < n; i++){
            System.out.print(kv[1][i] +" ");
        }
    }
    public static int containsNum(int x, int[][] array, int n){
        int i = 0;
        while(i < n && array[0][i] != 0){
            if(array[0][i] == x){
                return i;
            }
            i++;
        }
        return -1;
    }
}