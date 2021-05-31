import controlTownPack.CreateTownAndPerson;
import readIO.ErrorRead;
import runThreadPack.MoreTownThread;
import runThreadPack.TownSearchEngine;
import townInfoPackega.Person;
import townInfoPackega.TownT;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Apps {




    public static void main(String[] args) throws IOException, InterruptedException {

      // startFirstHalf();

        startSecondHalf();
    }

    public static void startFirstHalf(){
        ArrayList<TownT> list = new CreateTownAndPerson()
                .createTowns()
                .getAllList();

        ArrayList<Person> listPerson = new CreateTownAndPerson()
                .createPerson()
                .getAllList();



        for(Person person : listPerson){
            TownSearchEngine townSearchEngine = new TownSearchEngine(person,new ArrayList<TownT>(list));
            townSearchEngine.start();
            try {
                Thread.sleep(330);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public static void startSecondHalf(){
        System.out.println("Открытие процедуры чтения ошибочных запросов");
        ArrayList<StringBuilder> list = null;
        try {
            list = new ErrorRead().getList();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Ошибка, файл не найден");
        }
        MoreTownThread moreTownThread = new MoreTownThread(list);
        moreTownThread.start();
        System.out.println("Работа программы завершена");
    }
}
