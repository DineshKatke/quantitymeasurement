package org.quantitymeasurement.uc5;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.quantitymeasurement.uc5.QuantityMeasurementApp.demonstrateLenghtComparison;
import static org.quantitymeasurement.uc5.QuantityMeasurementApp.demonstrateLengthEquality;


public class QuantityMeasurementAppTest {

    @Mock
    QuantityMeasurementApp quantityMeasurementApp;

    @Mock
    Length length;

    @Test
    public  void testFeetEquality(){
        Length length1 = new Length(1.0, Length.LengthUnit.FEET);
        Length length2 = new Length(1.0, Length.LengthUnit.FEET);

        assertTrue(demonstrateLengthEquality(length1,
                length2));
    }

    @Test
    public  void testFeetInchesComparison(){
        Length length1 = new Length(1.0, Length.LengthUnit.FEET);
        Length length2 = new Length(12.0, Length.LengthUnit.INCHES);
        assertTrue(demonstrateLengthEquality(length1,length2));
    }

    @Test
    public  void testFeetInequality(){
        Length length1 = new Length(1.0, Length.LengthUnit.FEET);
        Length length2 = new Length(12.0, Length.LengthUnit.FEET);
        assertFalse(demonstrateLengthEquality(length1,length2));
    }

    @Test
    public  void testInchesInequality(){
        Length length1 = new Length(1.0, Length.LengthUnit.INCHES);
        Length length2 = new Length(12.0, Length.LengthUnit.INCHES);
        assertFalse(demonstrateLengthEquality(length1,length2));
    }

    @Test
    public  void testCroesUNitInequality(){
        Length length1 = new Length(1.0, Length.LengthUnit.FEET);
        Length length2 = new Length(15.0, Length.LengthUnit.INCHES);
        assertFalse(demonstrateLengthEquality(length1,length2));
    }

    @Test
    public  void testMultipleFeetComparison(){
        Length length1 = new Length(15.0, Length.LengthUnit.FEET);
        Length length2 = new Length(15.0, Length.LengthUnit.FEET);
        assertTrue(demonstrateLengthEquality(length1,length2));
    }

    @Test
    public  void yardEquals36Inches(){
        Length length1 = new Length(1.0, Length.LengthUnit.YARDS);
        Length length2 = new Length(36.0, Length.LengthUnit.INCHES);
        assertTrue(demonstrateLengthEquality(length1,length2));
    }

    @Test
    public  void centimeterEquals39Point3701Inches(){
        Length length1 = new Length(1.0, Length.LengthUnit.CENTIMETERS);
        Length length2 = new Length(0.393701, Length.LengthUnit.INCHES);
        assertTrue(demonstrateLengthEquality(length1,length2));
    }

    @Test
    public  void threeFeetEqualOneYard(){
        Length length1 = new Length(1.0, Length.LengthUnit.CENTIMETERS);
        Length length2 = new Length(0.393701, Length.LengthUnit.INCHES);
        assertTrue(demonstrateLengthEquality(length1,length2));
    }

    @Test
    public  void thirtyPointFort48CmEqualOneFoot(){
        Length length1 = new Length(30.48, Length.LengthUnit.CENTIMETERS);
        Length length2 = new Length(1.0, Length.LengthUnit.FEET);
        assertTrue(demonstrateLengthEquality(length1,length2));
    }

    @Test
    public  void YardNotEqualToInches(){
        Length length1 = new Length(1.0, Length.LengthUnit.YARDS);
        Length length2 = new Length(1.0, Length.LengthUnit.INCHES);
        assertFalse(demonstrateLengthEquality(length1,length2));
    }

    @Test
    public  void referenceEqualitySameObject(){
        Length length1 = new Length(1.0, Length.LengthUnit.YARDS);
        assertTrue(length1 == length1);
        assertTrue(demonstrateLengthEquality(length1,length1) );
    }

    @Test
    public  void equalReturnsFalseForNull(){
        Length length1 = new Length(1.0, Length.LengthUnit.YARDS);
        Length length2 = null;
        assertFalse(demonstrateLengthEquality(length1,length2) );
    }

    @Test
    public  void reflexiveSymmetricAndTransitiveProperty(){
        Length length1 = new Length(30.48, Length.LengthUnit.CENTIMETERS);
        Length length2 = new Length(1.0, Length.LengthUnit.FEET);
        Length length3 = new Length(12.0, Length.LengthUnit.INCHES);
        assertTrue(demonstrateLengthEquality(length1,length2) );
        assertTrue(demonstrateLengthEquality(length2,length3) );
        assertTrue(demonstrateLengthEquality(length1,length3) );
    }

    @Test
    public  void diffrentValuesSameUnitNotEqual(){
        Length length1 = new Length(1.0, Length.LengthUnit.FEET);
        Length length2 = new Length(12.0, Length.LengthUnit.FEET);
        assertFalse(demonstrateLengthEquality(length1,length2) );
    }

    @Test
    public  void crossUnitEqualityDemonstratedMethod(){
        Length length1 = new Length(3.0, Length.LengthUnit.FEET);
        Length length2 = new Length(1.0, Length.LengthUnit.YARDS);
        assertTrue(demonstrateLengthEquality(length1,length2));

    }

    @Test
    public void converFeetToInches(){
        Length lengthInInches = QuantityMeasurementApp.demonstrateLenghtConversion(
                3.0,    Length.LengthUnit.FEET,Length.LengthUnit.INCHES
        );

        Length expectedLength = new Length(36,Length.LengthUnit.INCHES);
        assertTrue(demonstrateLengthEquality(lengthInInches,expectedLength));
    }

    @Test
    public void convertYardsToInchesUsingOverloadedMethod(){
        Length lengthInYards = new Length(2.0, Length.LengthUnit.YARDS);
        Length lengthInInches = QuantityMeasurementApp.demonstrateLenghtConversion(2.0, Length.LengthUnit.YARDS,
                Length.LengthUnit.INCHES);
        Length expectedlength  = new Length(72.0, Length.LengthUnit.INCHES);
        assertTrue(demonstrateLengthEquality(lengthInInches,expectedlength));;
    }
}
