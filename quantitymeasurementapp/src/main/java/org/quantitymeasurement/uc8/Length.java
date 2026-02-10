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


//    private double convertToBaseUnit(){
//        return Math.round((this.value * this.unit.conversionFactor)* Math.pow(10,3)) / Math.pow(10,3) ;
//    }

//    public Length convertTo(LengthUnit lengthUnit)  {
//        if(lengthUnit == null)
//            throw new IllegalArgumentException();
//
//        double value = Math.round(( LengthUnit.convertToBaseUnit(this.value) / lengthUnit.conversionFactor) * Math.pow(10,3)) / Math.pow(10,3);
//        Length out = new Length(value,lengthUnit);
//        return out;
//    }

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

        double convertedvalue = length2.unit.convertToBaseUnit(length2.value);
            double sum = Math.round(Double.sum(this.value,convertedvalue)* Math.pow(10,3))/Math.pow(10,3);
            return new Length(sum,this.unit);
    }

    public boolean containsUnit(LengthUnit targetUnit){
        return Arrays.stream(LengthUnit.values()).anyMatch(l->l.equals(targetUnit));
    }
//
//    public Length add(Length length,LengthUnit targetUnit){
//            if (this==null)  throw new IllegalArgumentException();
//            if(!containsUnit(targetUnit)) throw new IllegalArgumentException();
//
//            Length additionLength =  add(length);
//            Length targetConvertedLength =  additionLength.convertTo(targetUnit);
//            return targetConvertedLength;
//    }

    @Override
    public String toString() {
        return "Length{" +
                "value=" + value +
                ", unit=" + unit +
                '}';
    }

    public static void main(String[] args) {

        Length length1 = new Length(1,LengthUnit.FEET);
        Length length2 = new Length(48,LengthUnit.INCHES);
        System.out.println(length1.add(length2));

        Length length3 = new Length(2,LengthUnit.YARDS);
        double val =  length3.unit.convertToBaseUnit(length3.value);
//        System.out.println(val);
//        System.out.println(length3.unit.convertFrombaseUnit(val));
        Length length9 = new Length(36.0,LengthUnit.INCHES);
        Length length10 = new Length(1.0,LengthUnit.YARDS);
        System.out.println(length10.unit.convertFrombaseUnit(length10.value));
    }
}
