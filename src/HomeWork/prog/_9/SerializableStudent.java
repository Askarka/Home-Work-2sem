package HomeWork.prog._9;

import java.util.Date;
import java.io.Serializable;
import java.util.Objects;

public class SerializableStudent implements Serializable {
    private String name;
    private String gender;
    private Date birthday;
    private int group;
    private byte course;

    public SerializableStudent(String name, String gender, Date birthday, int group, byte course) {
        this.name = name;
        this.gender = gender;
        this.birthday = birthday;
        this.group = group;
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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public byte getCourse() {
        return course;
    }

    public void setCourse(byte course) {
        this.course = course;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SerializableStudent that = (SerializableStudent) o;
        return group == that.group &&
                course == that.course &&
                Objects.equals(name, that.name) &&
                Objects.equals(gender, that.gender) &&
                Objects.equals(birthday, that.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, gender, birthday, group, course);
    }

    @Override
    public String toString() {
        return "SerializableStudent{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", birthday=" + birthday +
                ", group=" + group +
                ", course=" + course +
                '}';
    }
}
