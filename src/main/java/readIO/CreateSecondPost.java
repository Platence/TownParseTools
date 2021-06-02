package readIO;
import runThreadPack.EngineEx;


public class CreateSecondPost {

    public String deleteOneChar(String sb,EngineEx ex){

        try {
            System.out.println("Попытка убрать символ : запрос для строки " + sb);
            System.out.println("Сотрудник : " + ex.getPerson().getName());
            ex.setCountREQ(ex.getCountREQ() + 1);

            String[] mas = sb.split("/");
            int index = mas.length-1;
            // индекс последнего слова

            String resulutReturn = mas[index].substring(0,mas[index].length() - 2);
            // Получим последнее слово
            // без одного символа с конца

            StringBuilder sbb = new StringBuilder();
            // Сборка в запрос обратно

            for(int i = 0 ; i < mas.length-1; i ++){
                sbb.append(mas[i]);
                sbb.append("/");
            }

            sbb.append(resulutReturn);

            System.out.println("WORK! " + sbb.toString());
            System.out.println("+++++++++++++++++++++++");
            return sbb.toString();
        }

        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Ошибка 565GGE");
            e.printStackTrace();
        }

        return sb;

    }

}
