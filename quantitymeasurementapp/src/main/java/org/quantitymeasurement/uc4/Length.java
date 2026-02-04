package org.quantitymeasurement.uc4;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Length {

    private double value;
    private LengthUnit unit;

    public Length(double value, LengthUnit unit){
            this.value = value;
            this.unit = unit;
    }

    public enum LengthUnit{
        FEET(12.0),
        INCHEES(1.0),
        YARDS(36.0),
        CENTIMETERS(0.393701);

        private final double conversionFactor;

        LengthUnit(double conversionFactor) {
            this.conversionFactor = conversionFactor;
        }

        public double getConversionFactor(){
            return conversionFactor;
        }
    }

    private double convertToBaseUnit(){
        return Math.round((this.value * this.unit.getConversionFactor())*100.00) / 100.00 ;
    }

    public boolean equals(Object o){
            if(o == null || this.getClass() != o.getClass())
                return false;
            Length length = (Length) o;
            return Double.compare(this.convertToBaseUnit(),length.convertToBaseUnit()) == 0;
    }

    public static void main(String[] args){
        Length length1 = new Length(1.0, LengthUnit.FEET);
        Length length2 = new Length(12.0, LengthUnit.INCHEES);
        System.out.println("Are lenghts equal ? "+ length1.equals(length2));

        Length length3 = new Length(1.0, LengthUnit.YARDS);
        Length length4 = new Length(36.0, LengthUnit.INCHEES);
        System.out.println("Are lenghts equal ? "+ length3.equals(length4));

        Length length5 = new Length(100.0, LengthUnit.CENTIMETERS);
        Length length6 = new Length(39.3701, LengthUnit.INCHEES);
        System.out.println("Are lenghts equal ? "+ length5.equals(length6));
    }
}
