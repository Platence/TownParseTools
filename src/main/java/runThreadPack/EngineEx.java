package runThreadPack;

import interfaces.PathsAndCellAdress;
import org.apache.http.client.HttpClient;
import readIO.CreateSecondPost;
import readIO.CretatePost;
import runThreadPack.infoPack.InernS;
import runThreadPack.infoPack.PackInfo;
import runThreadPack.infoPack.TempBase;
import townInfoPackega.Person;
import townInfoPackega.TownT;

public class EngineEx {

    private Person person;
    private int countREQ = 0;

    // Кол-во запросов, при превышениии которого
    // Запрос будет записан как ошибка

    public EngineEx(Person person) {
        this.person = person;
    }

    public void getReqqAll(HttpClient httpClient,StringBuilder result, TownT town) {

        TempBase temp = new TempBase(this.getPerson().getDefoltcity(),town.getTown() + town.getStreet());
        String request = CretatePost.getpostFromTown(this.getPerson(), town, temp);

        while (true) {
            result.setLength(0);String kmkm = "";

            if(new InernS().stopReq(request,this)){
                break;
            }

            if(!request.contains(PathsAndCellAdress.DEF_KEY_READY)) {
                try {
                    String[] parLev1 = new InernS().gerRespMassive(this,httpClient,request);

                    if (parLev1[0].contains(PathsAndCellAdress.DEF_KEY_ERROR)) {
                        request = new CreateSecondPost().deleteOneChar(request,this);
                        //DANGER!
                        continue;
                    }

                    new PackInfo(getPerson(),this).parseMeta(parLev1, result);
                    kmkm = result.reverse().toString();
                    if (kmkm.length() > PathsAndCellAdress.MAX_LENGTH_MES) {
                        kmkm = PathsAndCellAdress.defaultKM;
                        // Error - write in file how -99999
                    }
                    temp.setKm(kmkm);
                }
                catch (Exception e) {
                    request = new CreateSecondPost().deleteOneChar(request,this);
                    continue;
                }
            }
            // ------------------------------------------- //
            // СОЗДАНИЕ ЗАПРОСОВ ДО ПОЛУЧЕНИЯ СЛОВА ready  //
            // ------------------------------------------- //

            if (request.contains(PathsAndCellAdress.DEF_KEY_READY)) {
                kmkm = temp.getKm();
                new PackInfo(getPerson(),this).printInfo(town, temp);
            }
            new PackInfo(getPerson(),this).saveV(town, kmkm);
            // Save Information
            break;
        }
    }

    public int getCountREQ() {
        return countREQ;
    }

    public void setCountREQ(int countREQ) {
        this.countREQ = countREQ;
    }

    public Person getPerson() {
        return person;
    }
}
