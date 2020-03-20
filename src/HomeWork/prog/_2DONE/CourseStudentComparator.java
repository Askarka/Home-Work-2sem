package HomeWork.prog._2DONE;

import HomeWork.prog._1DONE.Student;

import java.util.Comparator;

public class CourseStudentComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) /*throws NullPointerException, ClassCastException*/ {
        return o1.getCourse()-o2.getCourse();
    }
}
