package runThreadPack;

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

        for(StringBuilder sb : this.getList()){

        }

    }


    public ArrayList<StringBuilder> getList() {
        return list;
    }

    public void setList(ArrayList<StringBuilder> list) {
        this.list = list;
    }
}
