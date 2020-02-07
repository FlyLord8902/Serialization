package serialize;

import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;

public class Car {
    private String brand;
    private BigDecimal price;


    public Car(String brand, BigDecimal price){
        this.brand = brand;
        this.price = price;
    }

    public void setBrand(String newBrand){
        this.brand = newBrand;
    }

    public String getBrand(){
        return this.brand;
    }

    public void setPrice(BigDecimal newPrice){
        this.price = newPrice;
    }

    public BigDecimal getPrice(){
        return this.price;
    }

    public static void serializeCar(Car car, String fileName){
        try{
            File fileOut = new File(fileName);
            PrintWriter  out = new PrintWriter(fileOut);
             ArrayList<String[]> carList = new ArrayList<>();
             carList.add(new String[]{"Brand", "Price"});
             carList.add(new String[]{car.brand, car.price+""});
            for (String[] strings : carList) {
                out.println(Arrays.deepToString(strings).replace("[","").replace("]", ""));
            }


            out.close();


        }catch (Exception e){
            e.printStackTrace();
        }
    }



    public boolean equals(Object other ){
        boolean isCar = false;
        if(other.getClass().equals(Car.class)){
            isCar = true;
        }

        return isCar && ((Car) other).getBrand().equals(this.getBrand()) && ((Car) other).getPrice().equals(this.getPrice());

    }
}
