package HomeWork.prog._1DONE;

import java.util.Objects;

public class Student implements Comparable<Student> {
    private int course;
    private int group;
    private String name;
    private String gender;

    public Student(int course, int group, String name, String gender) {
        this.course = course;
        this.group = group;
        this.name = name;
        this.gender = gender;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return course == student.course &&
                group == student.group &&
                Objects.equals(name, student.name) &&
                Objects.equals(gender, student.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(course, group, name, gender);
    }

    @Override
    public String toString() {
        return "Student{" +
                "course=" + course +
                ", group=" + group +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public int compareTo(Student o) {
        if(this.course == o.course && this.group == o.group && this.name.equals(o.name) && this.gender.equals(o.gender)) {
            return 0;
        }else {
            if (this.course == o.course){
                if (this.group == o.group){
                    if(this.name.equals(o.name)){
                        return this.gender.compareTo(o.gender);
                    }else{
                        return  this.name.compareTo(o.name);
                    }
                }else {
                    return this.group - o.group;
                }
            }else {
                return this.course - o.course;
            }
        }
    }
}