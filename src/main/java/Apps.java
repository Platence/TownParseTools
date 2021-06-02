import controlTownPack.CreateTownAndPerson;
import runThreadPack.TownSearchEngine;
import townInfoPackega.Person;
import townInfoPackega.TownT;

import java.util.ArrayList;

public class Apps {

    public static void main(String[] args){

       startFirstHalf();
       /*
        В процессе выполнения запросов
        Возвращались ошибки
        Они заносятся в отдельный файл
       */
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

}
