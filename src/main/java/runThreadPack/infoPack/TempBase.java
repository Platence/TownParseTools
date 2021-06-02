package runThreadPack.infoPack;

import interfaces.PathsAndCellAdress;

import java.util.ArrayList;
import java.util.Objects;

public class TempBase {

    /**
     * Некоторые сотрудники живут в одном и том же городе, поэтому для них сразу вернем результат
     * Ключевое слово - already=километры
     */

    private static final String keyWord = "already";
    private static final String keyWordEXT = "NON";

    private String defoltCity;
    private String moveToCity;
    private String km = "-9999";          // Километры

    private static volatile ArrayList<TempBase> list = new ArrayList<>();
    // Danger!

    public TempBase(String defoltCity, String moveToCity) {
        this.defoltCity = defoltCity;
        this.moveToCity = moveToCity;
    }

    public static String getWordAlready(TempBase t){

        if(t.getMoveToCity().contains(t.getDefoltCity())){
            t.setKm(PathsAndCellAdress.DEF_KM_TOWN_OWN);
            list.add(t);
            return keyWord+ "="+t.getKm();
            // Если сотрудник проживает в городе назначения
            // То он проедет в среднем 20 км (результат *2)
        }

        for(TempBase temp : new ArrayList<TempBase>(list)){
            if (temp.getDefoltCity().equals(t.getDefoltCity())){
                if(temp.getMoveToCity().equals(t.getMoveToCity())){
                    if(temp.getKm().equals("-9999")){break;}
                    t.setKm(temp.getKm());
                    return keyWord + "=" + t.getKm();
                }
            }
        }
        list.add(t);
        return keyWordEXT;
    }

    public String getDefoltCity() {
        return defoltCity;
    }

    public String getMoveToCity() {
        return moveToCity;
    }

    public String getKm() {
        return km;
    }

    public void setKm(String km) {
        this.km = km;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TempBase tempBase = (TempBase) o;
        return Objects.equals(defoltCity, tempBase.defoltCity) &&
                Objects.equals(moveToCity, tempBase.moveToCity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(defoltCity, moveToCity);
    }
}
