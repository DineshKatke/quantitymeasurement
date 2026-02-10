package org.quantitymeasurement.uc8;

public enum LengthUnit {

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


    double convertToBaseUnit(double value){
        double val = Math.round((value * this.conversionFactor)* Math.pow(10,3)) / Math.pow(10,3) ;
        return  Math.round(( val / LengthUnit.FEET.conversionFactor) * Math.pow(10,3)) / Math.pow(10,3);
    }

    public double convertFrombaseUnit(double value){
        double val = Math.round((value * this.conversionFactor)* Math.pow(10,3)) / Math.pow(10,3) ;
        return  Math.round(( val / this.conversionFactor) * Math.pow(10,3)) / Math.pow(10,3);
//        return Math.round((this.conversionFactor * value) * Math.pow(10,3)) / Math.pow(10,3);
    }

//    public Length convertTo(LengthUnit lengthUnit)  {
//        if(lengthUnit == null)
//            throw new IllegalArgumentException();
//
//        double value = Math.round(( convertToBaseUnit(this.value) / lengthUnit.conversionFactor) * Math.pow(10,3)) / Math.pow(10,3);
//        Length out = new Length(value,lengthUnit);
//        return out;
//    }
}
