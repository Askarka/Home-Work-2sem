package HomeWork.prog._2DONE;

import HomeWork.prog._1DONE.Student;
import HomeWork.prog._1DONE.UniversalEndlessArray;

public class StudentsListBubbleSorter {

    public static void courseBubbleSort(UniversalEndlessArray<Student> st){
        for(int i = st.getSize()-1; i >-1; i--){
            for (int j = 0; j < i; j++){
                if (st.peekByInd(j).compareTo(st.peekByInd(j+1)) > 0){
                    st.swap(j, j+1);
                }
            }
        }
    }

//    public static void main(String[] args) {
//        UniversalEndlessArray<Student> a = new UniversalEndlessArray<Student>(10);
//        for(int i = 0; i < 10; i++){
//            a.add(new Student(i % 3, 900 + (i % 4), "Ivanich" + i*4));
//        }
//        System.out.println(a.showElements());
//        courseBubbleSort(a);
//        System.out.println(a.showElements());
//
//    }
}
