package HomeWork.prog._1DONE;

public class Student implements Comparable<Student> {
    private int course;
    private int group;
    private String name;

    public Student(int course, int group, String name) {
        this.course = course;
        this.group = group;
        this.name = name;
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

    @Override
    public String toString() {
        return course + " 11-" + group + " " + name + "\n";
    }

    @Override
    public int compareTo(Student o) {
        if(this.course == o.course && this.group == o.group && this.name.equals(o.name)) {
            return 0;
        }else {
            if (this.course == o.course){
                if (this.group == o.group){
                    return  this.name.compareTo(o.name);
                }else {
                    return this.group - o.group;
                }
            }else {
                return this.course - o.course;
            }
        }
    }
}