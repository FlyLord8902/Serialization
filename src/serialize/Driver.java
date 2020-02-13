package serialize;

import java.math.BigDecimal;
import java.util.Scanner;

public class Driver {
    public static void main(String[]args){
        Car car1 = new Car("Lamborghini",new BigDecimal(417826));
        Car car2 =  null;
        Car car3 = null;
        try {
            Scanner input = new Scanner(System.in);
            System.out.print("Enter file name to serialize car: ");
            String fileName = input.next();
            Car.serializeCarCSV(car1,fileName);
            Serialize.binarySer(car1, "myCars.ser");
            System.out.println("Car has been serialized...");
            System.out.println("Do you want to de-serialize to a new car Y/N");
            String answer = input.next();
            if(answer.equalsIgnoreCase("y")){
                System.out.print("Please Enter the file you want to de-serialize from: ");
                String dFileName = input.next();

                // Car 2 and 3 are the same, one was de-serialized through reading file and the other with binary.
                //car2 = Car.deSerializeCarCSV(dFileName);
                car3 = (Car)Serialize.binaryDeSer("myCars.ser");

                if(car1.equals(car3)){
                    System.out.println("Car has been successfully de-serialized and are equal.");
                }else {
                    System.out.println("These cars are not the same. Or the object is not a car");
                }
            }else if(answer.equalsIgnoreCase("n")){
                System.out.println();
            }


        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
