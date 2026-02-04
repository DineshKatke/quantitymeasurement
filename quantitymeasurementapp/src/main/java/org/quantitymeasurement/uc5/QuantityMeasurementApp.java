package org.quantitymeasurement.uc5;




public class QuantityMeasurementApp {

    public static boolean demonstrateLengthEquality(Length length1, Length length2){
            return length1.equals(length2);
    }

    public static Length demonstrateLenghtConversion(double value, Length.LengthUnit fromUnit,
                                                   Length.LengthUnit toUnit){
        Length length = new Length(value,fromUnit);
        Length outLenght = length.convertTo(toUnit);
        System.out.println("Convert( "+value + " , " + fromUnit +  " , " + toUnit +") Output "+ length.convertTo(toUnit));
        return outLenght;
    }

    public static void demonstrateLenghtComparison(double value1, Length.LengthUnit lengthUnit1,
                                                   double value2, Length.LengthUnit lengthUnit2){
                Length length1 = new Length(value1,lengthUnit1);
                Length length2 =new Length(value2, lengthUnit2);
                System.out.println("Are lenghts equal ? "+ length1.equals(length2));
    }

    public static void main(String[] args){

        demonstrateLenghtComparison(1.0, Length.LengthUnit.FEET,
                                            12.0, Length.LengthUnit.INCHES);

        demonstrateLenghtComparison(1.0, Length.LengthUnit.YARDS,
                36.0, Length.LengthUnit.INCHES);

        demonstrateLenghtComparison(3.0, Length.LengthUnit.FEET,
                1.0, Length.LengthUnit.YARDS);

        demonstrateLenghtComparison(30.48, Length.LengthUnit.CENTIMETERS,
                1.0, Length.LengthUnit.FEET);

        demonstrateLenghtConversion(1.0, Length.LengthUnit.FEET, Length.LengthUnit.INCHES);
        demonstrateLenghtConversion(3.0, Length.LengthUnit.YARDS, Length.LengthUnit.FEET);
        demonstrateLenghtConversion(36.0, Length.LengthUnit.INCHES, Length.LengthUnit.YARDS);
        demonstrateLenghtConversion(1.0, Length.LengthUnit.CENTIMETERS, Length.LengthUnit.INCHES);
        demonstrateLenghtConversion(0.0, Length.LengthUnit.FEET, Length.LengthUnit.INCHES);
    }

}
