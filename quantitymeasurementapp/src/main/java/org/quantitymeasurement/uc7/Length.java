package org.quantitymeasurement.uc7;

import java.util.Arrays;

public class Length {
    private double value;
    private LengthUnit unit;

    public Length(double value, LengthUnit unit){
        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public LengthUnit getUnit() {
        return unit;
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
        return Math.round((this.value * this.unit.conversionFactor)* Math.pow(10,3)) / Math.pow(10,3) ;
    }

    public Length convertTo(LengthUnit lengthUnit)  {
        if(lengthUnit == null)
            throw new IllegalArgumentException();

        double value = Math.round((this.convertToBaseUnit() / lengthUnit.conversionFactor) * Math.pow(10,3)) / Math.pow(10,3);
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

    public Length add(Length length2){
        if(length2 == null)
            throw new IllegalArgumentException();

        Length convertedLength = length2.convertTo(this.unit);
            double sum = Math.round(Double.sum(this.value,convertedLength.value)* Math.pow(10,3))/Math.pow(10,3);
            return new Length(sum,this.unit);
    }

    public boolean containsUnit(LengthUnit targetUnit){
        return Arrays.stream(LengthUnit.values()).anyMatch(l->l.equals(targetUnit));
    }

    public Length add(Length length,LengthUnit targetUnit){
            if (this==null)  throw new IllegalArgumentException();
            if(!containsUnit(targetUnit)) throw new IllegalArgumentException();

            Length additionLength =  add(length);
            Length targetConvertedLength =  additionLength.convertTo(targetUnit);
            return targetConvertedLength;
    }

    @Override
    public String toString() {
        return "Length{" +
                "value=" + value +
                ", unit=" + unit +
                '}';
    }

    public static void main(String[] args) {

        Length length1 = new Length(1,LengthUnit.FEET);
        Length length2 = new Length(12,LengthUnit.INCHES);
        System.out.println(length1.add(length2,LengthUnit.FEET  ));

        Length length9 = new Length(5.0,LengthUnit.FEET);
        Length length10 = new Length(-2.0,LengthUnit.FEET);
        System.out.println(length9.add(length10,LengthUnit.INCHES));
    }
}
