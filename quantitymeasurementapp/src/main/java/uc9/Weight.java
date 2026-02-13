package uc9;

public class Weight {

    private double value;
    private WeightUnit unit;

    public Weight(double value, WeightUnit unit) {
        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public WeightUnit getUnit() {
        return unit;
    }

    public double convertToBaseUnit(double value){
            return this.unit.converToBaseUnit(value);
    }

    public double convertTo(WeightUnit targetUnit){
        double baseUnitValue = this.unit.converToBaseUnit(this.value);
        return targetUnit.convertFromBaseUnit(baseUnitValue);
    }

    public Weight add(Weight thatWeight){
        if(thatWeight == null)
            throw new IllegalArgumentException();

        double converted = thatWeight.convertTo(this.unit);
        double addition = Double.sum(this.value,converted);
        return new Weight(addition,this.unit);

    }

    public Weight add(Weight weight, WeightUnit targetUnit){
        Weight addition = this.add(weight);
        double convertedUnit = addition.convertTo(targetUnit);
        return new Weight(convertedUnit,targetUnit);

    }

    private boolean compare(Weight weight){
        return (Double.compare(this.unit.converToBaseUnit(this.value),weight.unit.converToBaseUnit(weight.value))==0);
    }

    public boolean equals(Object o){
        if( o== null || this.getClass() != o.getClass())
            return false;
        Weight weight = (Weight) o;
        if((Double.compare(this.value,weight.value)==0)
                        && this.unit.equals(weight.unit))
            return true;
        return false;
    }

    @Override
    public String toString() {
        return "Weight{" +
                "value=" + value +
                ", unit=" + unit +
                '}';
    }
}
