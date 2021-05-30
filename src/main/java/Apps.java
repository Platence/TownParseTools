import controlTownPack.CreateTownAndPerson;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
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
        HttpPost httpPost;
        HttpResponse httpResponse;

        for(Person person : listPerson){
            for(TownT town : list){
                httpPost = new HttpPost("https://www.google.com");
                httpPost.setHeader("none", CretatePost.getpostFromTown(person,town));
                httpResponse = httpClient.execute(httpPost);
                String body = EntityUtils.toString(httpResponse.getEntity());
                System.out.println(body);
                break;
            }
        }


    }
}
