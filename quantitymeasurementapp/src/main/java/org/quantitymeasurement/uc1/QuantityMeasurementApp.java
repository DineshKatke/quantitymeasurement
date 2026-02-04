package org.quantitymeasurement.uc1;

public class QuantityMeasurementApp {


    public static class Feet{
        private final double value;

        public Feet(double value) {
            this.value = value;
        }


        @Override
        public boolean equals(Object o) {
            if (o == null || this.getClass() != o.getClass()) return false;
            Feet feet = (Feet) o;
            return Double.compare(this.value, feet.value) == 0;
        }

    }
}
