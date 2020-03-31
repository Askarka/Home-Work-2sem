package SemesterWork.ADS.CircleList;

import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;

public class Tester {
    public static void main(String[] args) throws FileNotFoundException {
        CircleList a = new CircleList();

        long t0 = System.nanoTime();
        for(int i =0; i < 10; i++){
            a.insert(i+". Participant",  (int) Math.random() + "");
        }
        long t1 = System.nanoTime();

        float millis = TimeUnit.NANOSECONDS.toMillis(t1-t0);
        System.out.println(t1 - t0 + " ns");
        //System.out.println(String.format("it took: %d ms", millis));

    }
}
