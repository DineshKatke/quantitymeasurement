package org.quantitymeasurement.uc8;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import static org.quantitymeasurement.uc8.QuantityMeasurementApp.demonstrateLengthAddition;


public class QuantityMeasurementAppTest {

    @Mock
    QuantityMeasurementApp quantityMeasurementApp;

    @Mock
    Length length;

    @Test
    public  void testFeetEquality(){
        Length length1 = new Length(1.0, LengthUnit.FEET);
        Length length2 = new Length(1.0, LengthUnit.FEET);
        assertTrue(length1.equals(length2));
    }

    @Test
    public  void testFeetInchesComparison(){
        Length length1 = new Length(1.0, LengthUnit.FEET);
        Length length2 = new Length(12.0, LengthUnit.INCHES);
        assertTrue(length1.equals(length2));
    }

    @Test
    public  void testFeetInequality(){
        Length length1 = new Length(1.0, LengthUnit.FEET);
        Length length2 = new Length(12.0, LengthUnit.FEET);
        assertFalse(length1.equals(length2));
    }

    @Test
    public  void testInchesInequality(){
        Length length1 = new Length(1.0, LengthUnit.INCHES);
        Length length2 = new Length(12.0, LengthUnit.INCHES);
        assertFalse(length1.equals(length2));
    }

    @Test
    public  void testCroesUNitInequality(){
        Length length1 = new Length(1.0, LengthUnit.FEET);
        Length length2 = new Length(15.0, LengthUnit.INCHES);
        assertFalse(length1.equals(length2));
    }

    @Test
    public  void testMultipleFeetComparison(){
        Length length1 = new Length(15.0, LengthUnit.FEET);
        Length length2 = new Length(15.0, LengthUnit.FEET);
        assertTrue(length1.equals(length2));
    }

    @Test
    public  void yardEquals36Inches(){
        Length length1 = new Length(1.0, LengthUnit.YARDS);
        Length length2 = new Length(36.0, LengthUnit.INCHES);
        assertTrue(length1.equals(length2));
    }

    @Test
    public  void centimeterEquals39Point3701Inches(){
        Length length1 = new Length(1.0, LengthUnit.CENTIMETERS);
        Length length2 = new Length(0.393701, LengthUnit.INCHES);
        assertTrue(length1.equals(length2));
    }

    @Test
    public  void threeFeetEqualOneYard(){
        Length length1 = new Length(1.0, LengthUnit.CENTIMETERS);
        Length length2 = new Length(0.393701, LengthUnit.INCHES);
        assertTrue(length1.equals(length2));
    }

    @Test
    public  void thirtyPointFort48CmEqualOneFoot(){
        Length length1 = new Length(30.48, LengthUnit.CENTIMETERS);
        Length length2 = new Length(1.0, LengthUnit.FEET);
        assertTrue(length1.equals(length2));
    }

    @Test
    public  void YardNotEqualToInches(){
        Length length1 = new Length(1.0, LengthUnit.YARDS);
        Length length2 = new Length(1.0, LengthUnit.INCHES);
        assertFalse(length1.equals(length2));
    }

    @Test
    public  void referenceEqualitySameObject(){
        Length length1 = new Length(1.0, LengthUnit.YARDS);
        assertTrue(length1 == length1);
        assertTrue(length1.equals(length1) );
    }

    @Test
    public  void equalReturnsFalseForNull(){
        Length length1 = new Length(1.0, LengthUnit.YARDS);
        Length length2 = null;
        assertFalse(length1.equals(length2) );
    }

    @Test
    public  void reflexiveSymmetricAndTransitiveProperty(){
        Length length1 = new Length(30.48, LengthUnit.CENTIMETERS);
        Length length2 = new Length(1.0, LengthUnit.FEET);
        Length length3 = new Length(12.0, LengthUnit.INCHES);
        assertTrue(length1.equals(length2) );
        assertTrue(length2.equals(length3) );
        assertTrue(length1.equals(length3) );
    }

    @Test
    public  void diffrentValuesSameUnitNotEqual(){
        Length length1 = new Length(1.0, LengthUnit.FEET);
        Length length2 = new Length(12.0, LengthUnit.FEET);
        assertFalse(length1.equals(length2) );
    }

    @Test
    public  void crossUnitEqualityDemonstratedMethod(){
        Length length1 = new Length(3.0, LengthUnit.FEET);
        Length length2 = new Length(1.0, LengthUnit.YARDS);
        assertTrue(length1.equals(length2));

    }

    @Test
    public void converFeetToInches(){
        Length lengthInInches = QuantityMeasurementApp.demonstrateLenghtConversion(
                3.0,    LengthUnit.FEET,LengthUnit.INCHES
        );

        Length expectedLength = new Length(36,LengthUnit.INCHES);
        assertTrue(QuantityMeasurementApp.demonstrateLengthEquality(lengthInInches,expectedLength));
    }

    @Test
    public void convertYardsToInchesUsingOverloadedMethod(){
        Length lengthInYards = new Length(2.0, LengthUnit.YARDS);
        Length lengthInInches = QuantityMeasurementApp.demonstrateLenghtConversion(2.0, LengthUnit.YARDS,
                LengthUnit.INCHES);
        Length expectedlength  = new Length(72.0, LengthUnit.INCHES);
        assertTrue(QuantityMeasurementApp.demonstrateLengthEquality(lengthInInches,expectedlength));;
    }

    @Test
    public void testAdditionSameUnits(){
        Length length1 = new Length(1, LengthUnit.FEET);
        Length length2 = new Length(2, LengthUnit.FEET);
        Length addLength = demonstrateLengthAddition(length1,length2);        ;
        assertEquals(3,addLength.getValue());

    }

    @Test
    public void testAdditionSameUnitsInchPlusInch(){
        Length length1 = new Length(6, LengthUnit.INCHES);
        Length length2 = new Length(6, LengthUnit.INCHES);
        Length addLength = demonstrateLengthAddition(length1,length2);
        assertEquals(12,addLength.getValue());

    }

    @Test
    public void testAdditionCrossUnitFeetPlusInches(){
        Length length1 = new Length(1, LengthUnit.FEET);
        Length length2 = new Length(12, LengthUnit.INCHES);
        Length addLength = demonstrateLengthAddition(length1,length2);
        assertEquals(2,addLength.getValue());
        assertEquals(LengthUnit.FEET,addLength.getUnit());
    }

    @Test
    public void testAdditionCrossUnitInchesPlusFeet(){
        Length length1 = new Length(12, LengthUnit.INCHES);
        Length length2 = new Length(1, LengthUnit.FEET);
        Length addLength = demonstrateLengthAddition(length1,length2);
        assertEquals(24,addLength.getValue());
        assertEquals(LengthUnit.INCHES,addLength.getUnit());
    }

    @Test
    public void testAdditionCrossUnitYardPlusFeet(){
        Length length1 = new Length(1, LengthUnit.YARDS);
        Length length2 = new Length(3, LengthUnit.FEET);
        Length addLength = demonstrateLengthAddition(length1,length2);
        assertEquals(2,addLength.getValue());
        assertEquals(LengthUnit.YARDS,addLength.getUnit());
    }

    @Test
    public void testAdditionCrossUnitCentimeterPlusInch(){
        Length length1 = new Length(2.54, LengthUnit.CENTIMETERS);
        Length length2 = new Length(1.0, LengthUnit.INCHES);
        Length addLength = demonstrateLengthAddition(length1,length2);
        assertEquals(5.07,addLength.getValue());
        assertEquals(LengthUnit.CENTIMETERS,addLength.getUnit());
    }

    @Test
    public void testAdditionCommutativity(){
        Length length1 = new Length(1, LengthUnit.FEET);
        Length length2 = new Length(12, LengthUnit.INCHES);
        Length addLength1 = demonstrateLengthAddition(length1,length2);
        Length addLength2 = demonstrateLengthAddition(length2,length1);

        assertEquals(2,addLength1.getValue());
        assertEquals(LengthUnit.FEET,addLength1.getUnit());

        assertEquals(24,addLength2.getValue());
        assertEquals(LengthUnit.INCHES,addLength2.getUnit());
    }

    @Test
    public void testAdditionWithZero(){
        Length length1 = new Length(5.0, LengthUnit.FEET);
        Length length2 = new Length(0.0, LengthUnit.INCHES);
        Length addLength = demonstrateLengthAddition(length1,length2);
        assertEquals(5.00,addLength.getValue());
        assertEquals(LengthUnit.FEET,addLength.getUnit());
    }

    @Test
    public void testAdditionNegativeValues(){
        Length length1 = new Length(5.0, LengthUnit.FEET);
        Length length2 = new Length(-2.0, LengthUnit.FEET);
        Length addLength = demonstrateLengthAddition(length1,length2);
        assertEquals(3.0,addLength.getValue());
        assertEquals(LengthUnit.FEET,addLength.getUnit());
    }

    @Test
    public void testAdditionNullSecondOperand(){
        Length length1 = new Length(1.0, LengthUnit.FEET);
        Length length2 = null;
        assertThrows(IllegalArgumentException.class,()->demonstrateLengthAddition(length1,length2));
    }

    @Test
    public void testAdditionLargeValues(){
        Length length1 = new Length(1e6, LengthUnit.FEET);
        Length length2 = new Length(1e6, LengthUnit.FEET);
        Length addLength = demonstrateLengthAddition(length1,length2);
        assertEquals(2e6,addLength.getValue());
        assertEquals(LengthUnit.FEET,addLength.getUnit());
    }

    @Test
    public void testAdditionSmallValues(){
        Length length1 = new Length(0.001, LengthUnit.FEET);
        Length length2 = new Length(0.002, LengthUnit.FEET);
        Length addLength = demonstrateLengthAddition(length1,length2);
        assertEquals(0.003,addLength.getValue());
        assertEquals(LengthUnit.FEET,addLength.getUnit());
    }

    @Test
    public void testAdditionExpliciteTargetUnitFeet(){
        Length length1 = new Length(1.0, LengthUnit.FEET);
        Length length2 = new Length(12.0, LengthUnit.INCHES);
        Length addLength = demonstrateLengthAddition(length1,length2,LengthUnit.FEET);
        assertEquals(2.0,addLength.getValue());
        assertEquals(LengthUnit.FEET,addLength.getUnit());
    }

    @Test
    public void testAdditionExpliciteTargetUnitInches(){
        Length length1 = new Length(1.0, LengthUnit.FEET);
        Length length2 = new Length(12.0, LengthUnit.INCHES);
        Length addLength = demonstrateLengthAddition(length1,length2, LengthUnit.INCHES);
        assertEquals(24.0,addLength.getValue());
        assertEquals(LengthUnit.INCHES,addLength.getUnit());
    }

    @Test
    public void testAdditionExpliciteTargetUnitYards(){
        Length length1 = new Length(1.0, LengthUnit.FEET);
        Length length2 = new Length(12.0, LengthUnit.INCHES);
        Length addLength = demonstrateLengthAddition(length1,length2, LengthUnit.YARDS);
        assertEquals(0.667,addLength.getValue());
        assertEquals(LengthUnit.YARDS,addLength.getUnit());
    }

    @Test
    public void testAdditionExpliciteTargetUnitCentimeters(){
        Length length1 = new Length(1.0, LengthUnit.INCHES);
        Length length2 = new Length(1.0, LengthUnit.INCHES);
        Length addLength = demonstrateLengthAddition(length1,length2, LengthUnit.CENTIMETERS);
        assertEquals(5.06,addLength.getValue());
        assertEquals(LengthUnit.CENTIMETERS,addLength.getUnit());
    }

    @Test
    public void testAdditionExpliciteTargetUnitSameAsFirstOperand(){
        Length length1 = new Length(2.0, LengthUnit.YARDS);
        Length length2 = new Length(3.0, LengthUnit.FEET);
        Length addLength = demonstrateLengthAddition(length1,length2, LengthUnit.YARDS);
        assertEquals(3.0,addLength.getValue());
        assertEquals(LengthUnit.YARDS,addLength.getUnit());
    }

    @Test
    public void testAdditionExpliciteTargetUnitSameAsSecondOperand(){
        Length length1 = new Length(2.0, LengthUnit.YARDS);
        Length length2 = new Length(3.0, LengthUnit.FEET);
        Length addLength = demonstrateLengthAddition(length1,length2, LengthUnit.FEET);
        assertEquals(9.0,addLength.getValue());
        assertEquals(LengthUnit.FEET,addLength.getUnit());
    }

    @Test
    public void testAdditionExpliciteTargetUnitCommutativity(){
        Length length1 = new Length(1.0, LengthUnit.FEET);
        Length length2 = new Length(12.0, LengthUnit.INCHES);
        Length addLength1 = demonstrateLengthAddition(length1,length2, LengthUnit.YARDS);
        Length addLength2 = demonstrateLengthAddition(length2,length1, LengthUnit.YARDS);
        assertEquals(addLength1.getValue(),addLength2.getValue());
        assertEquals(addLength1.getUnit(),addLength2.getUnit());
    }

    @Test
    public void testAdditionExpliciteTargetUnitWithZero(){
        Length length1 = new Length(5.0, LengthUnit.FEET);
        Length length2 = new Length(0.0, LengthUnit.INCHES);
        Length addLength = demonstrateLengthAddition(length1,length2, LengthUnit.YARDS);
        assertEquals(1.667,addLength.getValue());
        assertEquals(LengthUnit.YARDS,addLength.getUnit());
    }

    @Test
    public void testAdditionExpliciteTargetUnitLargeToSmallScale(){
        Length length1 = new Length(1000.0, LengthUnit.FEET);
        Length length2 = new Length(500.0, LengthUnit.FEET);
        Length addLength = demonstrateLengthAddition(length1,length2, LengthUnit.INCHES);
        assertEquals(18000.00,addLength.getValue());
        assertEquals(LengthUnit.INCHES,addLength.getUnit());
    }

    @Test
    public void testAdditionExpliciteTargetUnitSmallToLargeScale(){
        Length length1 = new Length(12.00, LengthUnit.INCHES);
        Length length2 = new Length(12.00, LengthUnit.INCHES);
        Length addLength = demonstrateLengthAddition(length1,length2, LengthUnit.YARDS);
        assertEquals(0.667,addLength.getValue());
        assertEquals(LengthUnit.YARDS,addLength.getUnit());
    }

    @Test
    public void testAdditionExpliciteTargetUnitAllUnitCombinations(){
        Length length1 = new Length(12.00, LengthUnit.INCHES);
        Length length2 = new Length(12.00, LengthUnit.INCHES);
        Length addLength1 = demonstrateLengthAddition(length1,length2, LengthUnit.YARDS);
        Length addLength2 = demonstrateLengthAddition(length1,length2, LengthUnit.INCHES);
        Length addLength3 = demonstrateLengthAddition(length1,length2, LengthUnit.CENTIMETERS);
        Length addLength4 = demonstrateLengthAddition(length1,length2, LengthUnit.FEET);
        assertEquals(0.667,addLength1.getValue());
        assertEquals(LengthUnit.YARDS,addLength1.getUnit());
        assertEquals(24.0,addLength2.getValue());
        assertEquals(LengthUnit.INCHES,addLength2.getUnit());
        assertEquals(60.96,addLength3.getValue());
        assertEquals(LengthUnit.CENTIMETERS,addLength3.getUnit());
        assertEquals(2.0,addLength4.getValue());
        assertEquals(LengthUnit.FEET,addLength4.getUnit());
    }

    @Test
    public void testAdditionExpliciteTargetUnitPrecisionTolerance(){
        Length length1 = new Length(12.00, LengthUnit.INCHES);
        Length length2 = new Length(12.00, LengthUnit.INCHES);
        Length addLength = demonstrateLengthAddition(length1,length2, LengthUnit.CENTIMETERS);
        assertNotEquals(60.00,addLength.getValue());
        assertEquals(LengthUnit.CENTIMETERS,addLength.getUnit());
    }
}
