package org.quantitymeasurement.uc3;

public class Length {

    private double value;
    private LengthUnit unit;

    public Length(double value,LengthUnit unit){
            this.value = value;
            this.unit = unit;
    }

    public enum LengthUnit{
        FEET(12.0),
        INCHEES(1.0);

        private final double conversionFactor;

        LengthUnit(double conversionFactor) {
            this.conversionFactor = conversionFactor;
        }

        public double getConversionFactor(){
            return conversionFactor;
        }
    }

    private double convertToBaseUnit(){
        if (this.unit == LengthUnit.FEET){
            return this.value * LengthUnit.FEET.conversionFactor;
        }
        return this.value * LengthUnit.INCHEES.conversionFactor;
    }

    public boolean equals(Object o){
            if(o == null || this.getClass() != o.getClass())
                return false;
            Length length = (Length) o;
            return Double.compare(this.convertToBaseUnit(),length.convertToBaseUnit()) == 0;
    }

    public static void main(String[] args){
        Length length1 = new Length(1.0,LengthUnit.FEET);
        Length length2 = new Length(12.0,LengthUnit.INCHEES);
        System.out.println("Are lenghts equal ? "+ length1.equals(length2));
    }
}
