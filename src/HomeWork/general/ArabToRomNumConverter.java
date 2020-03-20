package HomeWork.general;

public class ArabToRomNumConverter {
    public static String convert(int x){
        String[] ch = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] n = {   1000,  900, 500,  400, 100,  90,  50,   40,  10,   9,    5,    4,    1};
        String res = "";
        for(int i = 0; i < 13; i++){
            while (x >= n[i]){
                res = res + ch[i];
                x -= n[i];
            }
        }
        return res;
    }
}