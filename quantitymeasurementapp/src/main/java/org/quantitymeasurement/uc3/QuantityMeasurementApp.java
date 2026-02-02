package org.quantitymeasurement.uc3;


public class QuantityMeasurementApp {


    public static class Feet{
        private final double value;

        public Feet(double value) {
            this.value = value;
        }


        @Override
        public boolean equals(Object o) {
            if (o == null || this.getClass() != o.getClass())
                return false;
            Feet feet = (Feet) o;
            return Double.compare(this.value, feet.value) == 0;
        }

    }

    public static class Inches{
        private final double value;

        public Inches(double value) {
            this.value = value;
        }

        @Override
        public  boolean equals(Object o){
            if(o==null || this.getClass()!= o.getClass())
                return false;
            Inches inches = (Inches) o;
            return Double.compare(this.value,inches.value) == 0;
        }
    }

    public static void demonstrateFeetEquality(){
        Feet feet1 = new Feet(10);
        Feet feet2 = new Feet(10);
        System.out.println("Equality check for Feet "+feet1.equals(feet2));
    }

    public static void demonstrateInchesEquality(){
        Inches inches1 = new Inches(10);
        Inches inches2 = new Inches(10.11);
        System.out.println("Equality check for Inches "+inches1.equals(inches2));
    }

    public static void demonstrateFeetInchesComparison() {
        Length length1 = new Length(1.0, Length.LengthUnit.FEET);
        Length length2 = new Length(12.0, Length.LengthUnit.INCHEES);
        System.out.println("Are lenghts equal ? "+ length1.equals(length2));
    }

    public static void main(String[] args){
        demonstrateFeetEquality();
        demonstrateInchesEquality();
        demonstrateFeetInchesComparison();
    }

}
