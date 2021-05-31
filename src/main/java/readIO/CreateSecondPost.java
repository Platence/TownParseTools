package readIO;

public class CreateSecondPost {


    public static String gerExtendRequest(StringBuilder sb,int index){

        /**
         * Убираем по 1 символу с конца, пока запрос не будет валидным
         */

        String mas [] = sb.toString().split("\\*");

        return mas[1].substring(0,index);

    }

    public static String getPersonFromErrorMessage(StringBuilder sb){
        //Возвращает сотрудника
        String mas [] = sb.toString().split("\\*");
        return mas[0];
    }
}
