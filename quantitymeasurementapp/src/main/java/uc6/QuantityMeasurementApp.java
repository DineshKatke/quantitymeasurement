package uc6;

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

    public static Length demonstrateLengthAddition(Length length1,Length length2){
        Length addition = length1.add(length2);
        System.out.println("Addition is "+addition);
        return addition;
    }

    public static void main(String[] args) {
        Length length5 = new Length(36, Length.LengthUnit.INCHES);
        Length length6 = new Length(1, Length.LengthUnit.YARDS);
        demonstrateLengthAddition(length5,length6);

        Length length7 = new Length(2.54, Length.LengthUnit.CENTIMETERS);
        Length length8 = new Length(1, Length.LengthUnit.INCHES);
        demonstrateLengthAddition(length7,length8);

        Length length9 = new Length(5, Length.LengthUnit.FEET);
        Length length10 = new Length(-2.0, Length.LengthUnit.FEET);
        demonstrateLengthAddition(length9,length10);
    }
}
