package controlTownPack;

import townInfoPackega.TownT;

import java.util.ArrayList;

public class ControllerTownS {

    private ArrayList<TownT> allTown;

    public ControllerTownS() {
        allTown = new ArrayList<>();
    }

    public boolean addPosition(TownT town){
        if(allTown.contains(town)){
            return false;
        }
        allTown.add(town);
        return true;
    }

    public ArrayList<TownT> getAllList(){

        return new ArrayList(allTown);
    }


}
