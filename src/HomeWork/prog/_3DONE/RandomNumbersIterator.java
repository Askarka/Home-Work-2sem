package HomeWork.prog._3DONE;

import java.util.Iterator;
import java.util.Random;

public class RandomNumbersIterator<Integer> implements Iterator<java.lang.Integer> {
    private static final Random random = new Random();

    public RandomNumbersIterator() {
    }

    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public java.lang.Integer next() {
        return random.nextInt();
    }

//    public static void main(String[] args) {
//        RandomNumbersIterator a = new RandomNumbersIterator();
//        while(true){
//            System.out.println(a.next());
//        }
//    }
}