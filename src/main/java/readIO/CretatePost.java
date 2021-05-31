package readIO;

import townInfoPackega.Person;
import townInfoPackega.TownT;
import writeIO.TempBase;

public class CretatePost {

    private static volatile String defoltReqhttp = "https://www.google.com/maps/dir/";


    public static String getpostFromTown(Person o1, TownT o2, TempBase temp){

        StringBuilder sb = new StringBuilder();
        sb.append(TempBase.getWordAlready(temp));

        if(sb.toString().equals("NON")){
            sb.setLength(0);
        }

        if(sb.toString().contains("ready")){
            return "already=" + temp.getKm();
        }

        String s6 = extendedWords(o2.getTown(),o2);

        if(s6.contains("/")){
            s6 = "";
            System.out.println(o2.getStreet());
        }

        sb.append(defoltReqhttp);
        sb.append(o1.getDefoltcity());
        sb.append("/");
        sb.append(o2.getArea()+ "+");
        sb.append(o2.getTown()+"+");
        if(!o2.getTown().contains("п.") && !o2.getTown().contains("рп.")){
            sb.append(s6.replace(",",""));
        }

        return sb.toString().replace(" ","+");
    }

    public static String extendedWords(String town,TownT o2){

        /**
         * Исключения
         */

        switch (town){
            case "г.Белев" :           return " ";
            case "д.Большая Еловая" :  return " ";
            case "го.Брянск" :         return " ";
            case "сп.Шаталовское" :    return " ";
            case "с.Воскресенское" :   return " ";
            case "г.Десногорск" :      return " ";
            case "с.Ижевское" :        return " ";
            case "г.Киреевск" :        return " ";
            case "г.Скопин" :          return " ";
            case "г.Малоярославец" :   return " ";
            case "сп.Федоровское" :    return " ";
            case "г.Новомичуринск" :   return " ";
            case "с.Захарово" :        return " ";
            case "г.Богородицк" :      return " ";
            case "г.Рязань" :          return " ";
            case "с.Архангельское" :   return " ";
            case "с.Кудиново" :        return " ";
            case "г.Рыбное" :        return " ";
            case "д.Фролово" :        return " ";
            case "г.Калуга" :        return " ";

            default: return o2.getStreet();
        }
    }
}
