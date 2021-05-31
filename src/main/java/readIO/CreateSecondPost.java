package readIO;
import java.util.Map;

public class CreateSecondPost {

    public String gerExtendRequest(StringBuilder sb,int index){

        /**
         * Убираем по 1 символу с конца, пока запрос не будет валидным
         */

        String mas [] = sb.toString().split("\\*");
        String resulutReturn = mas[1].substring(0,mas[1].length()-index);
        System.out.println("Попытка содзать запрос для строки");
        System.out.println(resulutReturn);
        System.out.println("---------------");
        return resulutReturn;

    }

    public String getPersonFromErrorMessage(StringBuilder sb){
        //Возвращает сотрудника
        String mas [] = sb.toString().split("\\*");
        return mas[0];
    }

    public String getAdressstatic(StringBuilder sb){
        //Возвращает сотрудника
        String mas [] = sb.toString().split("\\*");
        String mas2 [] = mas[1].split("/");
        return mas2[mas2.length-1].replace("+"," ");
    }

}
