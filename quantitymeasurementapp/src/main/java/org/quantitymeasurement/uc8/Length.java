package org.quantitymeasurement.uc8;

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


    private double convertToBaseUnit(){
        return this.unit.convertFrombaseUnit(this.value);
    }

    public Length convertTo(LengthUnit lengthUnit)  {
        if(lengthUnit == null)
            throw new IllegalArgumentException();

        double val =  this.unit.convertToBaseUnit(this.value);
        double convertedValue = lengthUnit.convertFrombaseUnit(val);
        Length out = new Length(convertedValue,lengthUnit);
        return out;
    }

    @Override
    public boolean equals(Object o){
        if(o == null || this.getClass() != o.getClass())
            return false;
        Length length = (Length) o;
        return Double.compare(this.getUnit().convertToBaseUnit(this.value),length.getUnit().convertToBaseUnit(length.value)) == 0;
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
        Length length2 = new Length(1,LengthUnit.YARDS);

        System.out.println("Test ConvertTo "+length1.convertTo(length2.unit));
//        System.out.println("Test ConvertTo "+length2.getUnit().convertFrombaseUnit(length1.unit));

        Length length9 = new Length(24.0,LengthUnit.INCHES);
        double val =  length9.unit.convertToBaseUnit(length9.value);
//        System.out.println(val);
//        System.out.println(LengthUnit.FEET.convertFrombaseUnit(val));
        System.out.println(length1.add(length2));
    }
}
