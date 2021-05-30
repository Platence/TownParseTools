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
}
