package uc9;

import org.quantitymeasurement.uc8.Length;
import org.quantitymeasurement.uc8.LengthUnit;

public class QuantityMeasurementApp {


    public static void main(String[] args) {
        Weight weight1 = new Weight(500.0,WeightUnit.GRAM);
        Weight weight2 = new Weight(0.5,WeightUnit.KILOGRAM);

//        Weight weight3 = new Weight(0.0,WeightUnit.KILOGRAM);
//        System.out.println(weight3.convertTo(WeightUnit.KILOGRAM));
        System.out.println(weight1.equals(weight2));
        System.out.println(weight1.add(weight2,WeightUnit.GRAM));

    }
}
