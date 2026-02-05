package org.quantitymeasurement.uc6;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import uc6.Length;
import uc6.QuantityMeasurementApp;

import static org.junit.jupiter.api.Assertions.*;
import static uc6.QuantityMeasurementApp.demonstrateLengthAddition;


public class QuantityMeasurementAppTest {

    @Mock
    QuantityMeasurementApp quantityMeasurementApp;

    @Mock
    Length length;

    @Test
    public  void testFeetEquality(){
        Length length1 = new Length(1.0, Length.LengthUnit.FEET);
        Length length2 = new Length(1.0, Length.LengthUnit.FEET);
        assertTrue(length1.equals(length2));
    }

    @Test
    public  void testFeetInchesComparison(){
        Length length1 = new Length(1.0, Length.LengthUnit.FEET);
        Length length2 = new Length(12.0, Length.LengthUnit.INCHES);
        assertTrue(length1.equals(length2));
    }

    @Test
    public  void testFeetInequality(){
        Length length1 = new Length(1.0, Length.LengthUnit.FEET);
        Length length2 = new Length(12.0, Length.LengthUnit.FEET);
        assertFalse(length1.equals(length2));
    }

    @Test
    public  void testInchesInequality(){
        Length length1 = new Length(1.0, Length.LengthUnit.INCHES);
        Length length2 = new Length(12.0, Length.LengthUnit.INCHES);
        assertFalse(length1.equals(length2));
    }

    @Test
    public  void testCroesUNitInequality(){
        Length length1 = new Length(1.0, Length.LengthUnit.FEET);
        Length length2 = new Length(15.0, Length.LengthUnit.INCHES);
        assertFalse(length1.equals(length2));
    }

    @Test
    public  void testMultipleFeetComparison(){
        Length length1 = new Length(15.0, Length.LengthUnit.FEET);
        Length length2 = new Length(15.0, Length.LengthUnit.FEET);
        assertTrue(length1.equals(length2));
    }

    @Test
    public  void yardEquals36Inches(){
        Length length1 = new Length(1.0, Length.LengthUnit.YARDS);
        Length length2 = new Length(36.0, Length.LengthUnit.INCHES);
        assertTrue(length1.equals(length2));
    }

    @Test
    public  void centimeterEquals39Point3701Inches(){
        Length length1 = new Length(1.0, Length.LengthUnit.CENTIMETERS);
        Length length2 = new Length(0.393701, Length.LengthUnit.INCHES);
        assertTrue(length1.equals(length2));
    }

    @Test
    public  void threeFeetEqualOneYard(){
        Length length1 = new Length(1.0, Length.LengthUnit.CENTIMETERS);
        Length length2 = new Length(0.393701, Length.LengthUnit.INCHES);
        assertTrue(length1.equals(length2));
    }

    @Test
    public  void thirtyPointFort48CmEqualOneFoot(){
        Length length1 = new Length(30.48, Length.LengthUnit.CENTIMETERS);
        Length length2 = new Length(1.0, Length.LengthUnit.FEET);
        assertTrue(length1.equals(length2));
    }

    @Test
    public  void YardNotEqualToInches(){
        Length length1 = new Length(1.0, Length.LengthUnit.YARDS);
        Length length2 = new Length(1.0, Length.LengthUnit.INCHES);
        assertFalse(length1.equals(length2));
    }

    @Test
    public  void referenceEqualitySameObject(){
        Length length1 = new Length(1.0, Length.LengthUnit.YARDS);
        assertTrue(length1 == length1);
        assertTrue(length1.equals(length1) );
    }

    @Test
    public  void equalReturnsFalseForNull(){
        Length length1 = new Length(1.0, Length.LengthUnit.YARDS);
        Length length2 = null;
        assertFalse(length1.equals(length2) );
    }

    @Test
    public  void reflexiveSymmetricAndTransitiveProperty(){
        Length length1 = new Length(30.48, Length.LengthUnit.CENTIMETERS);
        Length length2 = new Length(1.0, Length.LengthUnit.FEET);
        Length length3 = new Length(12.0, Length.LengthUnit.INCHES);
        assertTrue(length1.equals(length2) );
        assertTrue(length2.equals(length3) );
        assertTrue(length1.equals(length3) );
    }

    @Test
    public  void diffrentValuesSameUnitNotEqual(){
        Length length1 = new Length(1.0, Length.LengthUnit.FEET);
        Length length2 = new Length(12.0, Length.LengthUnit.FEET);
        assertFalse(length1.equals(length2) );
    }

    @Test
    public  void crossUnitEqualityDemonstratedMethod(){
        Length length1 = new Length(3.0, Length.LengthUnit.FEET);
        Length length2 = new Length(1.0, Length.LengthUnit.YARDS);
        assertTrue(length1.equals(length2));

    }

    @Test
    public void converFeetToInches(){
        Length lengthInInches = QuantityMeasurementApp.demonstrateLenghtConversion(
                3.0,    Length.LengthUnit.FEET,Length.LengthUnit.INCHES
        );

        Length expectedLength = new Length(36,Length.LengthUnit.INCHES);
        assertTrue(QuantityMeasurementApp.demonstrateLengthEquality(lengthInInches,expectedLength));
    }

    @Test
    public void convertYardsToInchesUsingOverloadedMethod(){
        Length lengthInYards = new Length(2.0, Length.LengthUnit.YARDS);
        Length lengthInInches = QuantityMeasurementApp.demonstrateLenghtConversion(2.0, Length.LengthUnit.YARDS,
                Length.LengthUnit.INCHES);
        Length expectedlength  = new Length(72.0, Length.LengthUnit.INCHES);
        assertTrue(QuantityMeasurementApp.demonstrateLengthEquality(lengthInInches,expectedlength));;
    }

    @Test
    public void testAdditionSameUnits(){
        Length length1 = new Length(1, Length.LengthUnit.FEET);
        Length length2 = new Length(2, Length.LengthUnit.FEET);
        Length addLength = demonstrateLengthAddition(length1,length2);        ;
        assertEquals(3,addLength.getValue());

    }

    @Test
    public void testAdditionSameUnitsInchPlusInch(){
        Length length1 = new Length(6, Length.LengthUnit.INCHES);
        Length length2 = new Length(6, Length.LengthUnit.INCHES);
        Length addLength = demonstrateLengthAddition(length1,length2);
        assertEquals(12,addLength.getValue());

    }

    @Test
    public void testAdditionCrossUnitFeetPlusInches(){
        Length length1 = new Length(1, Length.LengthUnit.FEET);
        Length length2 = new Length(12, Length.LengthUnit.INCHES);
        Length addLength = demonstrateLengthAddition(length1,length2);
        assertEquals(2,addLength.getValue());
        assertEquals(Length.LengthUnit.FEET,addLength.getUnit());
    }

    @Test
    public void testAdditionCrossUnitInchesPlusFeet(){
        Length length1 = new Length(12, Length.LengthUnit.INCHES);
        Length length2 = new Length(1, Length.LengthUnit.FEET);
        Length addLength = demonstrateLengthAddition(length1,length2);
        assertEquals(24,addLength.getValue());
        assertEquals(Length.LengthUnit.INCHES,addLength.getUnit());
    }

    @Test
    public void testAdditionCrossUnitYardPlusFeet(){
        Length length1 = new Length(1, Length.LengthUnit.YARDS);
        Length length2 = new Length(3, Length.LengthUnit.FEET);
        Length addLength = demonstrateLengthAddition(length1,length2);
        assertEquals(2,addLength.getValue());
        assertEquals(Length.LengthUnit.YARDS,addLength.getUnit());
    }

    @Test
    public void testAdditionCrossUnitCentimeterPlusInch(){
        Length length1 = new Length(2.54, Length.LengthUnit.CENTIMETERS);
        Length length2 = new Length(1.0, Length.LengthUnit.INCHES);
        Length addLength = demonstrateLengthAddition(length1,length2);
        assertEquals(5.08,addLength.getValue());
        assertEquals(Length.LengthUnit.CENTIMETERS,addLength.getUnit());
    }

    @Test
    public void testAdditionCommutativity(){
        Length length1 = new Length(1, Length.LengthUnit.FEET);
        Length length2 = new Length(12, Length.LengthUnit.INCHES);
        Length addLength1 = demonstrateLengthAddition(length1,length2);
        Length addLength2 = demonstrateLengthAddition(length2,length1);

        assertEquals(2,addLength1.getValue());
        assertEquals(Length.LengthUnit.FEET,addLength1.getUnit());

        assertEquals(24,addLength2.getValue());
        assertEquals(Length.LengthUnit.INCHES,addLength2.getUnit());
    }

    @Test
    public void testAdditionWithZero(){
        Length length1 = new Length(5.0, Length.LengthUnit.FEET);
        Length length2 = new Length(0.0, Length.LengthUnit.INCHES);
        Length addLength = demonstrateLengthAddition(length1,length2);
        assertEquals(5.00,addLength.getValue());
        assertEquals(Length.LengthUnit.FEET,addLength.getUnit());
    }

    @Test
    public void testAdditionNegativeValues(){
        Length length1 = new Length(5.0, Length.LengthUnit.FEET);
        Length length2 = new Length(-2.0, Length.LengthUnit.FEET);
        Length addLength = demonstrateLengthAddition(length1,length2);
        assertEquals(3.0,addLength.getValue());
        assertEquals(Length.LengthUnit.FEET,addLength.getUnit());
    }

    @Test
    public void testAdditionNullSecondOperand(){
        Length length1 = new Length(1.0, Length.LengthUnit.FEET);
        Length length2 = null;
        assertThrows(IllegalArgumentException.class,()->demonstrateLengthAddition(length1,length2));
    }

    @Test
    public void testAdditionLargeValues(){
        Length length1 = new Length(1e6, Length.LengthUnit.FEET);
        Length length2 = new Length(1e6, Length.LengthUnit.FEET);
        Length addLength = demonstrateLengthAddition(length1,length2);
        assertEquals(2e6,addLength.getValue());
        assertEquals(Length.LengthUnit.FEET,addLength.getUnit());
    }

    @Test
    public void testAdditionSmallValues(){
        Length length1 = new Length(0.001, Length.LengthUnit.FEET);
        Length length2 = new Length(0.002, Length.LengthUnit.FEET);
        Length addLength = demonstrateLengthAddition(length1,length2);
        assertEquals(0.003,addLength.getValue());
        assertEquals(Length.LengthUnit.FEET,addLength.getUnit());
    }
}
