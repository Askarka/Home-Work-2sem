package HomeWork.prog._9;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;

public class AnatoliksExampleMain {
    public static void write(Collection<AnatoliksStudent> collection, String path){
        try(FileOutputStream wr = new FileOutputStream(new File(path))){
            for(AnatoliksStudent s : collection){
                char[] name = s.getName().toCharArray();
                wr.write(name.length);
                for(char c : name){
                    wr.write(c >> 8);
                    wr.write(c);
                }
                wr.write(s.getGender() == AnatoliksStudent.Gender.MALE ? 0 : 1);
                wr.write(s.getBirthDay());
                wr.write(s.getBirthMonth());
                wr.write(s.getBirthYear() >> 8);
                wr.write(s.getBirthYear());
                char[] group = s.getGroup().toCharArray();
                wr.write(group.length);
                for(char c : group){
                    wr.write(c >> 8);
                    wr.write(c);
                }
            }
            wr.flush();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public static ArrayList<AnatoliksStudent> read(String path){
        ArrayList<AnatoliksStudent> list = new ArrayList<>();
        try(FileInputStream in = new FileInputStream(new File(path))){
            int b;
            while ((b = in.read()) != -1){
                byte[] name = new byte[b * 2];
                for(int i = 0; i < b * 2; i++){
                    name[i] = (byte)in.read();
                }
                StringBuilder studentName = new StringBuilder();
                ByteBuffer buffer = ByteBuffer.wrap(name);
                while (buffer.hasRemaining()){
                    studentName.append(buffer.getChar());
                }
                AnatoliksStudent.Gender gender = in.read() == 0 ? AnatoliksStudent.Gender.MALE : AnatoliksStudent.Gender.FEMALE;
                byte birthDay = (byte)in.read();
                byte birthMonth = (byte)in.read();
                short birthYear = (short)((in.read() << 8) + in.read());
                char[] group = new char[in.read()];
                for(int i = 0; i < group.length; i++){
                    group[i] |= in.read() << 8;
                    group[i] |= in.read();
                }
                String studentGroup = new String(group);
                list.add(new AnatoliksStudent(studentName.toString(), gender, birthDay, birthMonth, birthYear, studentGroup));
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return list;
    }

    public static void main(String[] args) {
        ArrayList<AnatoliksStudent> list = new ArrayList<>();
        list.add(new AnatoliksStudent("Aaaa", AnatoliksStudent.Gender.MALE, 1, 1, 2001, "901"));
        list.add(new AnatoliksStudent("Bbbbb", AnatoliksStudent.Gender.FEMALE, 3, 12, 999, "902"));
        list.add(new AnatoliksStudent("Ccccccccc", AnatoliksStudent.Gender.MALE, 1, 1, 2001, "11-901"));
        list.add(new AnatoliksStudent("Ddd", AnatoliksStudent.Gender.FEMALE, 1, 1, 2010, "12-13-901"));
        write(list, "test.txt");
        list = read("test.txt");
        for(AnatoliksStudent s : list) {
            System.out.println(s);
        }
    }
}