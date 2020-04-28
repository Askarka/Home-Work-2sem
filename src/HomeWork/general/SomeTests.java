package HomeWork.general;

import javax.swing.filechooser.FileSystemView;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SomeTests {
    public static void main(String[] args) {

        Path path = Paths.get(String.valueOf(FileSystemView.getFileSystemView().getHomeDirectory()));

        File file = new File(FileSystemView.getFileSystemView().getHomeDirectory() + "/TestFile");
        try {
            if(!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(file.getAbsolutePath());

        try (PrintWriter pw = new PrintWriter(new FileWriter(file, true));){
            pw.print("\n");
            pw.println("Sto delaen ia");
            pw.println("Иа уточка");



        } catch (IOException e) {
            e.printStackTrace();
        }


        System.out.println(FileSystemView.getFileSystemView().getHomeDirectory());


//        file.delete();




    }
}
