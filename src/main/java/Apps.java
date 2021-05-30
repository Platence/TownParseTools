import controlTownPack.CreateTownAndPerson;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import readIO.CretatePost;
import runThreadPack.TownSearchEngine;
import townInfoPackega.Person;
import townInfoPackega.TownT;

import java.io.IOException;
import java.util.ArrayList;

public class Apps {




    public static void main(String[] args) throws IOException, InterruptedException {

        ArrayList<TownT> list = new CreateTownAndPerson()
                .createTowns()
                .getAllList();

        ArrayList<Person> listPerson = new CreateTownAndPerson()
                .createPerson()
                .getAllList();



        for(Person person : listPerson){
            TownSearchEngine townSearchEngine = new TownSearchEngine(person,new ArrayList<TownT>(list));
            townSearchEngine.start();
        }

    }
}
