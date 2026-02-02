package org.quantitymeasurement.uc4;




public class QuantityMeasurementApp {

    public static void demonstrateLenghtComparison(double value1, Length.LengthUnit lengthUnit1,
                                                   double value2, Length.LengthUnit lengthUnit2){
                Length length1 = new Length(value1,lengthUnit1);
                Length length2 =new Length(value2, lengthUnit2);
                System.out.println("Are lenghts equal ? "+ length1.equals(length2));
    }

    public static void main(String[] args){

        demonstrateLenghtComparison(1.0, Length.LengthUnit.FEET,
                                            12.0,Length.LengthUnit.INCHEES);

        demonstrateLenghtComparison(1.0, Length.LengthUnit.YARDS,
                36.0,Length.LengthUnit.INCHEES);

        demonstrateLenghtComparison(3.0, Length.LengthUnit.FEET,
                1.0,Length.LengthUnit.YARDS);

        demonstrateLenghtComparison(30.48, Length.LengthUnit.CENTIMETERS,
                1.0,Length.LengthUnit.FEET);
    }

}
