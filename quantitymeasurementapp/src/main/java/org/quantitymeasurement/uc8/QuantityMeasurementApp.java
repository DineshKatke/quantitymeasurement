package org.quantitymeasurement.uc8;

import uc9.Weight;
import uc9.WeightUnit;

public class QuantityMeasurementApp {

    public static Weight demonstrateWeightaddition(Weight weight1,Weight weight2, WeightUnit targetUnit) {
        return weight1.add(weight2,WeightUnit.GRAM);
    }

    public static boolean demonstrateWeightEquality(Weight weight1,Weight weight2, WeightUnit targetUnit) {
        return weight1.equals(weight2);
    }

    public static boolean demonstrateLengthEquality(Length length1, Length length2){
        return length1.equals(length2);
    }

    public static Length demonstrateLenghtConversion(double value, LengthUnit fromUnit,
                                                     LengthUnit toUnit){
        Length length = new Length(value,fromUnit);
        Length outLenght = length.convertTo(toUnit);
        System.out.println("Convert( "+value + " , " + fromUnit +  " , " + toUnit +") Output "+ length.convertTo(toUnit));
        return outLenght;
    }

    public static void demonstrateLenghtComparison(double value1, LengthUnit lengthUnit1,
                                                   double value2, LengthUnit lengthUnit2){
        Length length1 = new Length(value1,lengthUnit1);
        Length length2 =new Length(value2, lengthUnit2);
        System.out.println("Are lenghts equal ? "+ length1.equals(length2));
    }

    public static Length demonstrateLengthAddition(Length length1,Length length2){
        Length addition = length1.add(length2);
        System.out.println("Addition is "+addition);
        return addition;
    }

    public static Length demonstrateLengthAddition(Length length1, Length length2, LengthUnit targetUnit){
        Length addition = length1.add(length2,targetUnit);
        System.out.println("Addition is "+addition);
        return addition;
    }

    public static void main(String[] args) {
        Length length5 = new Length(36, LengthUnit.INCHES);
        Length length6 = new Length(1, LengthUnit.YARDS);
        demonstrateLengthAddition(length5,length6);

        Length length7 = new Length(2.54, LengthUnit.CENTIMETERS);
        Length length8 = new Length(1, LengthUnit.INCHES);
        demonstrateLengthAddition(length7,length8);

        Length length9 = new Length(5, LengthUnit.FEET);
        Length length10 = new Length(-2.0, LengthUnit.FEET);
        demonstrateLengthAddition(length9,length10);
    }
}
