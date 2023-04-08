import java.util.*;
import Vehicle.*;

public class Main {
    public static void main(String[] args) {
        Aerial a1 = new Aerial("Matos",2135,20,500,89563132,1,"mini");
        Land l1 = new Land("Jeep",12566,5,1232,456587,4,1);
        System.out.println(l1.getDistance());
        Marine m1 = new Marine("Sfina",12356,800,120,45656,1,"Africa");
        m1.set_fuel_consumption(12358);
        System.out.println("fuel " + m1.get_fuel_consumption());

    }
}