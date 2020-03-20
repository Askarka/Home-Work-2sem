package HomeWork.prog._1DONE;

import HomeWork.prog._2DONE.Number;

public class Complex implements Number<Complex>, Comparable<Complex> {

    private Double re;
    private Double im;

    public Complex(Double re, Double im){
        this.re = re;
        this.im = im;
    }
    @Override
    public Complex sum(Complex o1, Complex o2) {
        Complex result = new Complex(o1.re + o2.re, o1.im + o2.im);
        return result;
    }

    @Override
    public int compare(Complex o1, Complex o2) {
        if ((o1.re * o1.re + o1.im * o1.im) > (o2.re * o2.re + o2.im * o2.im)) {
            return 1;
        } else {
            if ((o1.re * o1.re + o1.im * o1.im) == (o2.re * o2.re + o2.im * o2.im)) {
                return 0;
            } else return -1;
        }
    }

    @Override
    public int compareTo(Complex o) {
        if ((this.re * this.re + this.im * this.im) > (o.re * o.re + o.im * o.im)) {
            return 1;
        } else {
            if ((this.re * this.re + this.im * this.im) == (o.re * o.re + o.im * o.im)) {
                return 0;
            } else return -1;
        }

    }
}
/*
public class Complex {

    private float[] number; //это массив в которм будут храниться части комплексных чисел
    float a;
    float b;

    public Complex(float a, float b){
        number = new float[2];
        number[0] = a;
        number[1] = b;
    }

    public float[] getNumber(){ //смотри это мой геттер, а теперь смотрим на строчку 18
        return number;
    }

    public void sum (Complex secondNumber){
        float[] result; //этот массив будет хранить результаты операций
        result = new float [2];
        float [] second = secondNumber.getNumber(); //тут точно вернется то, что мне надо? или вернется тупо значение моего текущего обекта?

        result [0] = number[0] + second[0];
        result [1] = number[1] + second[1];
    }

    public static void main(String[] args) {
        Complex complex = new Complex(5, 8); //ступор. откуда взять второй объект? создать??
    float[] n = getNumber();
    }
}
 */