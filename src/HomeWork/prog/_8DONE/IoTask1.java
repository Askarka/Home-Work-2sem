package HomeWork.prog._8DONE;

import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class IoTask1 {

    //программа создаёт файл на рабочем столе
    //протестировано на win 10 и mac os, работает только на win 10
    //если здесь остался этот текст, то решить проблему с работой на mac os не удалось

    public static void main(String[] args) {
        File file = new File(FileSystemView.getFileSystemView().getHomeDirectory() + "/TestFileFor8hw");

        try {
            if(!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (PrintWriter pw = new PrintWriter(new FileWriter(file, true))){

            pw.println(Integer.MAX_VALUE);
            pw.println(Integer.MIN_VALUE);

            pw.println("И");

        } catch (IOException e) {
            e.printStackTrace();
        }




//        file.delete();
    }
}
