package runThreadPack.infoPack;

import interfaces.PathsAndCellAdress;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;
import runThreadPack.EngineEx;
import writeIO.WriteFile;

import java.io.IOException;

public class InernS {

    public boolean stopReq(String request, EngineEx ex){
        /*
        После 10 попытки запроса
        Сохраним ошибку, и перейдем к следующему запросу
        */

        if(ex.getCountREQ()> PathsAndCellAdress.MAX_TRY_REQ){
            new PackInfo(ex.getPerson(),ex).takeError1(request);
            return true;
        }
        return false;
    }

    public String [] gerRespMassive(EngineEx ex, HttpClient httpClient,String request){

        HttpGet httpGet;
        HttpResponse httpResponse = null;
        httpGet = new HttpGet(request);

        try {
            httpResponse = httpClient.execute(httpGet);
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        String body = null;

        try {
            body = EntityUtils.toString(httpResponse.getEntity());
            new WriteFile().saveRequest(request+ "  : " + ex.getPerson().getName());
            // LOG REQ!
            String[] parLev1 = body.split(PathsAndCellAdress.DEF_KEY_KEY);
            return parLev1;
        }
        catch (NullPointerException | IOException e){
            e.printStackTrace();
        }

        return new String [] {"ERROR"};
    }

}
