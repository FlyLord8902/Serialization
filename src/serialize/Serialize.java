package serialize;

import java.io.File;

import java.math.BigDecimal;
import java.util.Scanner;

public class Serialize {

    public static Car deSerCar(String fileName){
        Car newCar = null;

        try {
            File fileIn = new File(fileName);
            Scanner in = new Scanner(fileIn);
            in.next();
            in.next();
            while (in.hasNext()){
                newCar = new Car(in.next().replace(",", ""), new BigDecimal(in.next()));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return newCar;
    }
}
