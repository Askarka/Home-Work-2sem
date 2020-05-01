package HomeWork.prog._8DONE;

import javax.swing.filechooser.FileSystemView;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class IoTask2 {

    //программа не работает без файла, который создаётся предыдущей программой
    //может стоило сделать методы в одном классе, которые выполняют тз, и вызывать их поочерёдно

    public static void main(String[] args) {
        Path path = Paths.get(FileSystemView.getFileSystemView().getHomeDirectory() + "/TestFileFor8hw");
        File file = new File(String.valueOf(path));
        try(BufferedReader bufred = new BufferedReader(new FileReader(String.valueOf(path)))){
            System.out.println(bufred.readLine());
            System.out.println(bufred.readLine());
            System.out.println(bufred.readLine());

        }catch (IOException e){
            e.printStackTrace();
        }







    }
}
