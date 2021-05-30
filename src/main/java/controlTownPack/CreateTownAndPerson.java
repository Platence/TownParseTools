package controlTownPack;

import townInfoPackega.Person;
import townInfoPackega.TownT;

public class CreateTownAndPerson {

    public ControllerTownS createTowns(){
        ControllerTownS controllerTownS = new ControllerTownS();
        generateTown(controllerTownS);
        return controllerTownS;
    }

    private void generateTown(ControllerTownS o){
        TownT town1 = new TownT("Тульская обл","Ленинский р-он","Ленина 20","Тула");
        TownT town2 = new TownT("Вороонежская обл","Ленинский р-он","Ленина 20","Тула");
        o.addPosition(town1);
        o.addPosition(town2);

        // Заменить
    }

    public ControllerPersonClass createPerson(){
        ControllerPersonClass controllerPersonClass = new ControllerPersonClass();
        generatePerson(controllerPersonClass);
        return controllerPersonClass;
    }

    private void generatePerson(ControllerPersonClass o){
        Person person1 = new Person("Вася","Тула");
        o.addPosition(person1);
    }

}
