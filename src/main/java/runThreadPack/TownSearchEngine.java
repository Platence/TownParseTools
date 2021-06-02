package runThreadPack;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClients;
import townInfoPackega.Person;
import townInfoPackega.TownT;

import java.util.ArrayList;
import java.util.Collections;

public class TownSearchEngine extends Thread{

    /**
     * Класс подразумевает обработку до 1000+ запросов в отдельном потоке
     * для каждой персоны
     * Ожидается проверка на существующий запрос (город проживания) в стороннем классе
     * В таком случае расстояние присвоится сразу же
     */

    private Person person;
    private ArrayList<TownT> listTown;

    public TownSearchEngine(Person person, ArrayList<TownT> listTown) {
        this.person = person;
        this.listTown = listTown;
    }

    @Override
    public void run(){
        try {
            HttpClient httpClient = HttpClients.createMinimal();
            StringBuilder result = new StringBuilder();
            // Возвращаемый лист - шафл. Чтобы запросы не обрабатывались по порядку.
            // И уже проверенные города, не проверялись в одну и ту же еденицу времени
            for (TownT town : this.getListTown()) {
                 new EngineEx(this.getPerson()).getReqqAll(httpClient,result,town);
               }
            }

        catch (Exception e){
            e.printStackTrace();
        }

    }


    public ArrayList<TownT> getListTown() {
        Collections.shuffle(listTown);
        return listTown;
    }


    public Person getPerson() {
        return person;
    }
}
