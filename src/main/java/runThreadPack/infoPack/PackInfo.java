package runThreadPack.infoPack;

import runThreadPack.EngineEx;
import townInfoPackega.Person;
import townInfoPackega.TownT;
import writeIO.WriteFile;

import java.io.IOException;

public class PackInfo {

    private Person person;
    private EngineEx ex;

    public PackInfo(Person person, EngineEx ex) {
        this.person = person;
        this.ex = ex;
    }

    public void takeError1(String request){
        System.out.println("Ошибка, Текст запроса : ");
        System.out.println("После " + this.getEx().getCountREQ() + " попыток");
        System.out.println(request);
        WriteFile ff = new WriteFile();
        try {
            ff.saveError(this.person.getName() + "*" + request + System.lineSeparator());
        }

        catch (Exception e) {
            System.out.println("Ошибка сохранения");
        }
    }

    public void parseMeta(String [] parLev1, StringBuilder result){

        char[] xxx = parLev1[0].toCharArray();

        for (int i = xxx.length - 1; i > 0; i--) {
            if (xxx[i] == '\"') {
                break;
            }
            result.append(xxx[i]);
        }
    }

    public void saveV(TownT town, String kilometrs){

        WriteFile ff = new WriteFile();
        StringBuilder sb = new StringBuilder();
        sb.append(town.getArea());
        sb.append(town.getTown());
        sb.append(town.getStreet());
        sb.append("*");
        sb.append(this.getPerson().getName());
        sb.append("*");
        sb.append(kilometrs);
        sb.append(System.lineSeparator());

        try {ff.saveFile(this.getPerson(), sb.toString());}
        catch (IOException e) { e.printStackTrace();}
        System.out.println("<><><><><><><><<>");
        System.out.println("WAS ADDED : ");
        System.out.println(sb.toString());
        System.out.println();
    }

    public void printInfo(TownT town, TempBase temp){
        System.out.println("Для сотрудника : " + this.person.getName());
        System.out.println("Место назначения : " + town.getTown() + " " + town.getStreet());
        System.out.println("Уже расчитано расстояние : " + temp.getKm());
        System.out.println();
        System.out.println("<-------------->");
    }

    public Person getPerson() {
        return person;
    }

    public EngineEx getEx() {
        return ex;
    }
}
