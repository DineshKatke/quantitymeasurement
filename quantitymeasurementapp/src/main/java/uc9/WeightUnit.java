package uc9;

public enum WeightUnit {
    MILLIGRAM(0.001),
    GRAM(1.0),
    KILOGRAM(1000.0),
    POUND(453.592),
    TONNE(1_000_000.0);

    private final double conversionFactor;

    WeightUnit(double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    public double getConversionFactor() {
        return conversionFactor;
    }

    public double converToBaseUnit(double value){
        double convertedValue = Math.round((value * this.getConversionFactor()) * Math.pow(10,2)) / Math.pow(10,2);
        return Math.round((convertedValue / WeightUnit.GRAM.getConversionFactor()) * Math.pow(10,2)) / Math.pow(10,2);
    }

    public double convertFromBaseUnit(double value){
        double convertedVale = (value * (WeightUnit.GRAM.conversionFactor / this.conversionFactor));
        return Math.round(convertedVale * Math.pow(10,2)) / Math.pow(10,2);
    }
}
