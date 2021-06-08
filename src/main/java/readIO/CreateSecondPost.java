package readIO;
import runThreadPack.EngineEx;


public class CreateSecondPost {

    /**
     * В случае ошибки запроса (Включите JavaScript)
     * Вернуть запрос без 1 символа с конца строки
     * @param sb
     * @param ex
     * @return
     */

    public String deleteOneChar(String sb,EngineEx ex){

        try {
            System.out.println("Попытка убрать символ : запрос для строки " + sb);
            System.out.println("Сотрудник : " + ex.getPerson().getName());
            ex.setCountREQ(ex.getCountREQ() + 1);

            String result = sb.substring(0,sb.length()-1);
            System.out.println("Возвращен результат :");
            System.out.println(result);
            return result;
        }
        catch (Exception e){
            e.printStackTrace();
            return "ERROR!";
        }

    }

}
