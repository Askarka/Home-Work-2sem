package HomeWork.ADS._2DONE;
//Написать реализацию прерывающейся сортировки пузырьком.
public class InterruptableBubbleSort<T> {

    public static void Sort(MultiSet o){
        while(!InterruptableBubbleSort.checkSorted(o)){
            for(int i = 0; i < o.getsize() - 1; i++){
                if(o.getArrayOfNumEl(i) > o.getArrayOfNumEl(i+1)){
                    o.swap(i , i+1);
                }
                if(InterruptableBubbleSort.checkSorted(o)){
                    return;
                }
            }
        }
    }

    public static boolean checkSorted(MultiSet o){
        for(int i = 0; i < o.getsize() - 1; i++){
            if(o.getArrayOfNumEl(i) < o.getArrayOfNumEl(i+1)){
                return false;
            }
        }
        return true;
    }
}
