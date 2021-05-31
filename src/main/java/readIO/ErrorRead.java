package readIO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class ErrorRead {

    private static final String path = "D:\\metaVALUE\\ERRORS.txt";

    public ArrayList<StringBuilder> getList() throws FileNotFoundException {

        final ArrayList<StringBuilder> list = new ArrayList<>();

        Scanner sc = new Scanner(new File(path));

        while (sc.hasNext()){
            StringBuilder temp = new StringBuilder();
            temp.append(sc.nextLine());
            list.add(temp);
        }

        sc.close();
        return list;
    }
}
