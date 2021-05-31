package runThreadPack;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class RequesHandler {

    public String result(String req) throws IOException {

        StringBuilder result = new StringBuilder();
        String kilometrs = "";

        HttpClient httpClient = HttpClients.createMinimal();
        HttpGet httpGet;
        HttpResponse httpResponse;

        httpGet = new HttpGet(req);
        httpResponse = httpClient.execute(httpGet);
        String body = EntityUtils.toString(httpResponse.getEntity());

        String[] parLev1 = body.split("км");
        char[] xxx = parLev1[0].toCharArray();

        for (int i = xxx.length - 1; i > 0; i--) {
            if (xxx[i] == '\"') {
                break;
            }
            result.append(xxx[i]);
        }

        kilometrs = result.reverse().toString();

        if (kilometrs.length() > 20) {
            return "ERROR";
        }

        return kilometrs;

    }
}
