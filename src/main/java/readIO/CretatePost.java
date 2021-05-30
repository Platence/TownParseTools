package readIO;

import townInfoPackega.Person;
import townInfoPackega.TownT;

public class CretatePost {


    public static String getpostFromTown(Person o1, TownT o2){

        String s1 = "https://www.google.com/search?client=opera&q=";
        String s2 = o1.getDefoltcity();
        String s3 = "-";
        String s4 = o2.getArea();
        String s5 = o2.getTown();
        String s6 = o2.getStreet();


        return "https://www.google.com/search?client=opera&q=" +
                "Воронеж+" +
                "-" +
                "+москва%2C" +
                "улленина20"+
                "+расстояние&sourceid=opera&ie=UTF-8&oe=UTF-8";
    }
}
