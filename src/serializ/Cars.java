package serializ;

import java.io.*;

import java.math.BigDecimal;

public class Cars implements Serializable {
    private String brand;
    private BigDecimal price;

    public Cars(String brand, BigDecimal price){
        this.brand = brand;
        this.price = price;
    }

    public  void serializeCar(Cars car){
        try{
            FileOutputStream fileOut = new FileOutputStream("myCars.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);

            out.writeObject(car);
            out.close();
            fileOut.close();


        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public  Cars deSerializeCar(){
        try {
            FileInputStream fileIn = new FileInputStream("myCars.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
             Cars newCar = (Cars)in.readObject();

             fileIn.close();
             in.close();
             return newCar;
        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

    public boolean equals(Object other ){
        if(!this.brand.equals(((Cars) other).brand) || !this.price.equals(((Cars)other).price)){
            return false;
        }
        return true;

    }
}
