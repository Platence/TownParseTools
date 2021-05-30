import controlTownPack.CreateTownAndPerson;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import readIO.CretatePost;
import townInfoPackega.Person;
import townInfoPackega.TownT;

import java.io.IOException;
import java.util.ArrayList;

public class Apps {

    public static void main(String[] args) throws IOException {


        ArrayList<TownT> list = new CreateTownAndPerson()
                .createTowns()
                .getAllList();

        ArrayList<Person> listPerson = new CreateTownAndPerson()
                .createPerson()
                .getAllList();

        HttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet;
        HttpResponse httpResponse;

        for(Person person : listPerson){
            for(TownT town : list){
                httpGet = new HttpGet(CretatePost.getpostFromTown(person,town));
                //httpPost.setHeader("qwe", CretatePost.getpostFromTown(person,town));
                httpResponse = httpClient.execute(httpGet);
                String body = EntityUtils.toString(httpResponse.getEntity());
                String[] level1 = body.split("Куда");
                for(String x : level1){
                    if(x.contains("Маршрут")){
                        String[] level2 = x.split("\\) Маршрут");
                        for(String x2 : level2){
                            if(x2.contains("<span")){
                                String [] level3 = x2.split("\\(");
                                for(String x3 : level3){
                                    System.out.println(x3);
                                    System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXX");
                                }
                            }

                        }
                    }

                }
                break;
            }
        }

    }
}
