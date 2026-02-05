package uc6;

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

    public Length add(Length length2){
        if(length2 == null)
            throw new IllegalArgumentException();

        Length convertedLength = length2.convertTo(this.unit);
            double sum = Math.round(Double.sum(this.value,convertedLength.value)* Math.pow(10,3))/Math.pow(10,3);
            return new Length(sum,this.unit);
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
        System.out.println(length1.add(length2));

        Length length3 = new Length(1,LengthUnit.YARDS);
        Length length4 = new Length(3,LengthUnit.FEET);
        System.out.println(length3.add(length4));

        Length length5 = new Length(36,LengthUnit.INCHES);
        Length length6 = new Length(1,LengthUnit.YARDS);
        System.out.println(length5.add(length6));

        Length length7 = new Length(2.54,LengthUnit.CENTIMETERS);
        Length length8 = new Length(1,LengthUnit.INCHES);
        System.out.println(length7.add(length8));

        Length length9 = new Length(5,LengthUnit.FEET);
        Length length10 = new Length(-2.0,LengthUnit.FEET);
        System.out.println(length9.add(length10));
    }
}
