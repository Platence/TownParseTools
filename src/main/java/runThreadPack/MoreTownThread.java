package runThreadPack;

import readIO.CreateSecondPost;
import writeIO.WriteFile;

import java.io.IOException;
import java.util.ArrayList;

public class MoreTownThread extends Thread{



    /**
     * Класс дополнительных запросов, возникших в следствии
     * ERROR при обычном запросе.
     * Цель убирать из запроса по одному символу, пока не останется
     * Валидный запрос
     */


    private ArrayList<StringBuilder> list;

    public MoreTownThread(ArrayList<StringBuilder> list) {
        this.list = list;
        // Danger
    }

    public void run(){

        int size = this.getList().size();

        for(StringBuilder sb : this.getList()){
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("Осталось обработать : " + size);
            size--;


            int index = 0; // Удаление символов с конца

            while (true){
                // DANGER!!!!!!!!!!!!!!!!!!!!!
                String result = "ERROR";
                // Or Return kilometrs

                try {
                    result = new RequesHandler().result(
                             new CreateSecondPost().gerExtendRequest(sb,index));
                }

                catch (IOException e) {
                    //e.printStackTrace();
                    System.out.println("Ошибка запроса ! ");
                }

                if (result.equals("ERROR")){
                    index++;
                }

                else {
                    WriteFile ff = new WriteFile();
                    String rr = new CreateSecondPost().getAdressstatic(sb);
                    rr+="*";
                    rr+= new CreateSecondPost().getPersonFromErrorMessage(sb);
                    rr+="*";
                    rr+=result;
                    rr+=System.lineSeparator(); // Deprecated 7 lvl +
                    ff.saveAfterError(rr);
                    break;
                }
            }

        }

    }


    public ArrayList<StringBuilder> getList() {
        return list;
    }


}
