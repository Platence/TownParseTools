package writeIO;

import townInfoPackega.Person;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFile {

    private static final String pathEx = "D:\\metaVALUE\\";


    public void saveFile(Person person,String result) throws IOException {

        File f = new File(pathEx+person.getName()+".txt");

        if(!f.exists()){
            try {
                f.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        FileWriter fw = new FileWriter(f,true);
        fw.write(result);

        fw.close();
    }

    public void saveError(String result) throws IOException {
        File f = new File(pathEx+"ERRORS"+".txt");

        if(!f.exists()){
            try {
                f.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        FileWriter fw = new FileWriter(f,true);
        fw.write(result);

        fw.close();
    }

    public void saveAfterError(String result){
        System.out.println("Получен файл на сохранение : ");
        System.out.println(result);
        System.out.println("<><><><><><><>");
        File f = new File(pathEx+"EXTENDINFO"+".txt");
        if(!f.exists()){
            try {
                f.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        FileWriter fw = null;
        try {
            fw = new FileWriter(f,true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            fw.write(result);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
