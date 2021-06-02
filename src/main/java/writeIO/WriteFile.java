package writeIO;

import interfaces.PathsAndCellAdress;
import townInfoPackega.Person;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFile {

    public void saveFile(Person person,String result) throws IOException {

        File f = new File(PathsAndCellAdress.pathSaves +person.getName()+".txt");
        if(!f.exists()){
            try {
                f.createNewFile();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }

        FileWriter fw = new FileWriter(f,true);
        fw.write(result);

        fw.close();
    }

    public void saveError(String result) throws IOException {

        File f = new File(PathsAndCellAdress.pathSaves+"ERRORS"+".txt");
        if(!f.exists()){
            try {
                f.createNewFile();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }

        FileWriter fw = new FileWriter(f,true);
        fw.write(result);

        fw.close();
    }


}
