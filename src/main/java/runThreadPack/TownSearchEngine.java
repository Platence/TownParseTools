package runThreadPack;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import readIO.CretatePost;
import townInfoPackega.Person;
import townInfoPackega.TownT;
import writeIO.TempBase;
import writeIO.WriteFile;

import java.util.ArrayList;

public class TownSearchEngine extends Thread{

    private Person person;
    private ArrayList<TownT> listTown;

    public TownSearchEngine(Person person, ArrayList<TownT> listTown) {
        this.person = person;
        this.listTown = listTown;
    }

    /**
     * Класс подразумевает обработку до 1000 запросов в отдельном потоке
     * для каждой персоны
     * Ожидается проверка на существующий запрос в стороннем статик классе
     * В таком случае расстояние присвоится сразу же
     */

    @Override
    public void run(){

        try {

            HttpClient httpClient = HttpClients.createMinimal();
            HttpGet httpGet;
            HttpResponse httpResponse;
            int count = 0;
            StringBuilder result = new StringBuilder();



            for (TownT town : this.getListTown()) {

                    result.setLength(0);String kilometrs = "";

                    TempBase temp = new TempBase(this.person.getDefoltcity(),town.getArea()+town.getTown()+town.getStreet());
                    String request = CretatePost.getpostFromTown(person, town,temp);

                    if( ! request.contains("ready") ) {
                        try {
                            httpGet = new HttpGet(request);
                            httpResponse = httpClient.execute(httpGet);
                            String body = EntityUtils.toString(httpResponse.getEntity());


                            String[] parLev1 = body.split("км");

                            if (parLev1[0].contains("Включите JavaScript")) {
                                System.out.println("Ошибка, Текст запроса : ");
                                System.out.println(request);
                                WriteFile ff = new WriteFile();
                                try {
                                    ff.saveError(this.person.getName() + "*" + request + System.lineSeparator());
                                } catch (Exception e) {
                                    System.out.println("Ошибка сохранения");
                                }
                                continue;
                            }

                            char[] xxx = parLev1[0].toCharArray();

                            for (int i = xxx.length - 1; i > 0; i--) {
                                if (xxx[i] == '\"') {
                                    break;
                                }
                                result.append(xxx[i]);
                            }

                            kilometrs = result.reverse().toString();

                            if (kilometrs.length() > 20) {
                                kilometrs = "-99999";
                            }
                            temp.setKm(kilometrs);
                            count++;
                            System.out.println("Нить " + person.getName() + " Запрос № " + count);
                        }
                        catch (Exception e){
                            System.out.println("Ошибка запроса для " + request);
                            WriteFile ff = new WriteFile();
                            try {
                                ff.saveError(this.person.getName() + "*" + request + System.lineSeparator());
                            }
                            catch (Exception e1) {
                                System.out.println("Ошибка сохранения");
                            }
                            continue;
                        }
                    }

                    if(request.contains("ready")){
                        kilometrs = temp.getKm();
                        System.out.println("Для сотрудника : " + this.person.getName());
                        System.out.println("Место назначения : " + town.getTown() + " " + town.getStreet());
                        System.out.println("Уже расчитано расстояние : " + temp.getKm());
                    }

                    WriteFile ff = new WriteFile();
                    StringBuilder sb = new StringBuilder();
                    sb.append(town.getArea());
                    sb.append(town.getTown());
                    sb.append(town.getStreet());
                    sb.append("*");
                    sb.append(this.person.getName());
                    sb.append("*");
                    sb.append(kilometrs);
                    sb.append(System.lineSeparator());

                    ff.saveFile(this.person, sb.toString());

                    sb.setLength(0);

                try {
                    Thread.currentThread().sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public ArrayList<TownT> getListTown() {
        return listTown;
    }

    public void setListTown(ArrayList<TownT> listTown) {
        this.listTown = listTown;
    }
}
