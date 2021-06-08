package readIO;

import interfaces.PathsAndCellAdress;
import townInfoPackega.Person;
import townInfoPackega.TownT;
import runThreadPack.infoPack.TempBase;

public class CretatePost {

    /*
       if(s6.contains("/")
       Слэш является точкой назначения, поэтому этот символ после dir/
       может использоваться только 1 раз
     */
    private static final String defoltReqhttp = "https://www.google.com/maps/dir/";

    public String getpostFromTown(Person o1, TownT o2, TempBase temp){

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
           // System.out.println(o2.getStreet());
        }

        new CretatePost().apeendDafault(sb,o1,o2);
        return sb.toString().replace(" ","+");
    }

    private void apeendDafault(StringBuilder sb,Person o1,TownT o2){
        sb.append(defoltReqhttp);
        sb.append(o1.getDefoltcity());
        sb.append("/");
        sb.append(o2.getIndex()).append("+");
        sb.append(o2.getArea()).append("+");
        sb.append(o2.getTown()).append("+");
    }

}
