package HomeWork.prog._2DONE;

import HomeWork.prog._1DONE.Student;

import java.util.Comparator;

public class NameStudentComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return o1.getName().compareTo((o2.getName()));
    }
}
