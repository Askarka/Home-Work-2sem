package HomeWork.ADS._Codeforces._1;

import java.util.Arrays;
import java.util.Scanner;

public class taskE {
    static class Pair implements Comparable<Pair>{
        double r;
        int k;

        public Pair() {
        }

        @Override
        public int compareTo(Pair o) {
            System.out.println(this.r - o.r);
            if (Math.abs(this.r - o.r) <= 0.000001) {
                return 0;
            }else{
                if(this.r - o.r > 0){
                    return 1;
                }
                return -1;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s = 1000000 - sc.nextInt();
        Pair[] v = new Pair[n];
        for(int i = 0; i < n; i++){
            v[i] = new Pair();
            v[i].r = Math.sqrt(Math.pow(sc.nextInt(),2) + Math.pow(sc.nextInt(),2));
            v[i].k = sc.nextInt();
        }
        Arrays.sort(v);

        for(int i = 1; i < n; i++){
            v[i].k +=v[i-1].k;
        }

        int l = 0;
        int r = n - 1;
        int c = (l + r) / 2;
        if(s <= v[l].k){
            System.out.println(v[0].r);
        }else{
            if(s > v[r].k){
                System.out.println("-1");
            }else{
                while(l < r){
                    if(s > v[c-1].k && s <= v[c].k){
                        break;
                    }
                    if(s > v[c].k){
                        l = c + 1;
                    }else{
                        r = c - 1;
                    }
                    c = (l + r) / 2;
                }
                System.out.println(v[c].r);
            }
        }
    }
}
// 1 ю3ю 6
// 1 2 3 /4/ 5 6 7