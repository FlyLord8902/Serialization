package serializ;

import java.math.BigDecimal;

public class Driver {
    public static void main(String[]args){
        Cars car1 = new Cars("Lamborghini",new BigDecimal(417826));
        try {
            Cars.serializeCar(car1);
            System.out.println("Car has been serialized...");
            Cars car2 = Cars.deSerializeCar();
            System.out.println("Car has been de-serialized from file...");
            System.out.println();

            if(car2.equals(car1)){
                System.out.println("Car has been successfully de-serialized and are equal");
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
