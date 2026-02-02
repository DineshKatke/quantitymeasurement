package org.quantitymeasurement;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.quantitymeasurement.uc4.Length;
import org.quantitymeasurement.uc4.QuantityMeasurementApp;

import static org.junit.jupiter.api.Assertions.*;


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
        Length length2 = new Length(12.0, Length.LengthUnit.INCHEES);
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
        Length length1 = new Length(1.0, Length.LengthUnit.INCHEES);
        Length length2 = new Length(12.0, Length.LengthUnit.INCHEES);
        assertFalse(length1.equals(length2));
    }

    @Test
    public  void testCroesUNitInequality(){
        Length length1 = new Length(1.0, Length.LengthUnit.FEET);
        Length length2 = new Length(15.0, Length.LengthUnit.INCHEES);
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
        Length length2 = new Length(36.0, Length.LengthUnit.INCHEES);
        assertTrue(length1.equals(length2));
    }

    @Test
    public  void centimeterEquals39Point3701Inches(){
        Length length1 = new Length(1.0, Length.LengthUnit.CENTIMETERS);
        Length length2 = new Length(0.393701, Length.LengthUnit.INCHEES);
        assertTrue(length1.equals(length2));
    }

    @Test
    public  void threeFeetEqualOneYard(){
        Length length1 = new Length(1.0, Length.LengthUnit.CENTIMETERS);
        Length length2 = new Length(0.393701, Length.LengthUnit.INCHEES);
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
        Length length2 = new Length(1.0, Length.LengthUnit.INCHEES);
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
        Length length3 = new Length(12.0, Length.LengthUnit.INCHEES);
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
}
