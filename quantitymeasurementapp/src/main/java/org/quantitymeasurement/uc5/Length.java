package org.quantitymeasurement.uc5;

public class Length {

    private double value;
    private LengthUnit unit;

    public Length(double value, LengthUnit unit){
            this.value = value;
            this.unit = unit;
    }

    public enum LengthUnit{
        FEET(12.0),
        INCHES(1.0),
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
        return Math.round((this.value * this.unit.conversionFactor)*100.00) / 100.00 ;
    }

    public Length convertTo(LengthUnit lengthUnit)  {
        if(lengthUnit == null)
            throw new IllegalArgumentException();

        double value = (this.convertToBaseUnit() / lengthUnit.conversionFactor);
        Length out = new Length(value,lengthUnit);
        return out;
    }

    @Override
    public boolean equals(Object o){
            if(o == null || this.getClass() != o.getClass())
                return false;
            Length length = (Length) o;
            return Double.compare(this.convertToBaseUnit(),length.convertToBaseUnit()) == 0;
    }

    @Override
    public String toString() {
        return "Length{" +
                "value=" + value +
                ", unit=" + unit +
                '}';
    }

    public static void main(String[] args){
        Length length1 = new Length(1.0, LengthUnit.FEET);
        Length length2 = new Length(12.0, LengthUnit.INCHES);
        System.out.println("Are lenghts equal ? "+ length1.equals(length2));

        Length length3 = new Length(1.0, LengthUnit.YARDS);
        Length length4 = new Length(36.0, LengthUnit.INCHES);
        System.out.println("Are lenghts equal ? "+ length3.equals(length4));

        Length length5 = new Length(100.0, LengthUnit.CENTIMETERS);
        Length length6 = new Length(39.3701, LengthUnit.INCHES);
        System.out.println("Are lenghts equal ? "+ length5.equals(length6));
    }
}
