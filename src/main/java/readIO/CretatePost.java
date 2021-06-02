package readIO;

import interfaces.PathsAndCellAdress;
import townInfoPackega.Person;
import townInfoPackega.TownT;
import runThreadPack.infoPack.TempBase;

public class CretatePost {

    private static volatile String defoltReqhttp = "https://www.google.com/maps/dir/";

    public static String getpostFromTown(Person o1, TownT o2, TempBase temp){

        StringBuilder sb = new StringBuilder();
        sb.append(TempBase.getWordAlready(temp));

        if(sb.toString().equals("NON")){
            sb.setLength(0);
        }

        if(sb.toString().contains(PathsAndCellAdress.DEF_KEY_READY)){
            return "already=" + temp.getKm();
        }

        String s6 = o2.getTown();

        if(s6.contains("/")){
            s6 = "";
            System.out.println(o2.getStreet());
        }

        sb.append(defoltReqhttp);
        sb.append(o1.getDefoltcity());
        sb.append("/");
        sb.append(o2.getArea()).append("+");
        sb.append(o2.getTown()).append("+");
        if(!o2.getTown().contains("п.") && !o2.getTown().contains("рп.")){
            sb.append(s6.replace(",",""));
        }

        return sb.toString().replace(" ","+");
    }

}
