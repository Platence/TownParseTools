package controlTownPack;

import townInfoPackega.Person;

import java.util.ArrayList;

public class ControllerPersonClass {

    private ArrayList<Person> listPerson;

    public ControllerPersonClass(){
        listPerson = new ArrayList<>();
    }

    public boolean addPosition(Person person){
        if(listPerson.contains(person)){
            return false;
        }
        listPerson.add(person);
        return true;
    }

    public ArrayList<Person> getAllList(){
        return new ArrayList<>(listPerson);
    }

}
