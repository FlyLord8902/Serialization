package serialize;

import java.math.BigDecimal;
import java.util.Scanner;

public class Driver {

    public static void main(String[]args){
        Car car1 = new Car("Lamborghini",new BigDecimal(417826));
        Car car2;

        try {
            String fileName, answer, dFileName;
            Scanner input = new Scanner(System.in);
            System.out.println("Do you want to serialize object to binary or csv. (b/c)");
            String decision = input.next();

            if(decision.equalsIgnoreCase("c")){
                System.out.print("Enter file name to serialize car: ");
                 fileName = input.next();
                Car.serializeCarCSV(car1,fileName);
                System.out.println("Car has been serialized to CSV file.");
                System.out.println("Do you want to de-serialize to a new car Y/N");
                 answer = input.next();

                if(answer.equalsIgnoreCase("y")){
                    System.out.print("Please Enter the file you want to de-serialize from: ");
                     dFileName = input.next();
                    car2 = Car.deSerializeCarCSV(dFileName);

                    if(car1.equals(car2)){
                        System.out.println("Car has been successfully de-serialized and are equal.");
                    }else {
                        System.out.println("These cars are not the same. Or the object is not a car");
                    }
                }else if(answer.equalsIgnoreCase("n")){
                    System.out.println();
                }
            }else if(decision.equalsIgnoreCase("b")){
                System.out.print("Enter file name to serialize car: ");
                     fileName = input.next();
                    Serialize.binarySer(car1, fileName);
                System.out.println("Car has been serialized to Binary file.");
                System.out.println("Do you want to de-serialize to a new car Y/N");
                answer = input.next();

                if(answer.equalsIgnoreCase("y")){
                    System.out.print("Please Enter the file you want to de-serialize from: ");
                    dFileName = input.next();
                    car2 = (Car)Serialize.binaryDeSer(dFileName);

                    if(car1.equals(car2)){
                        System.out.println("Car has been successfully de-serialized and are equal.");
                    }else {
                        System.out.println("These cars are not the same. Or the object is not a car");
                    }
                }else if(answer.equalsIgnoreCase("n")){
                    System.out.println();
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
