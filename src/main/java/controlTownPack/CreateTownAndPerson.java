package controlTownPack;

import interfaces.PathsAndCellAdress;
import readIO.ReadXlsx;

import java.io.IOException;

public class CreateTownAndPerson {

    public ControllerTownS createTowns(){
        ControllerTownS controllerTownS = new ControllerTownS();
        generateTown(controllerTownS);
        return controllerTownS;
    }

    private void generateTown(ControllerTownS o){
        ReadXlsx readXlsx = new ReadXlsx();
        try {
            readXlsx.openBook(PathsAndCellAdress.path,o);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public ControllerPersonClass createPerson(){
        ControllerPersonClass controllerPersonClass = new ControllerPersonClass();
        generatePerson(controllerPersonClass);
        return controllerPersonClass;
    }

    private void generatePerson(ControllerPersonClass o){

        ReadXlsx readXlsx = new ReadXlsx();
        try {
            readXlsx.openBook(PathsAndCellAdress.path,o);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
