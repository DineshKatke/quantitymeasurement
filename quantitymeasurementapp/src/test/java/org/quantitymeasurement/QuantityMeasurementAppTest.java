package org.quantitymeasurement;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.quantitymeasurement.uc3.Length;
import org.quantitymeasurement.uc3.QuantityMeasurementApp;

import static org.junit.jupiter.api.Assertions.*;
import static org.quantitymeasurement.uc3.QuantityMeasurementApp.*;


public class QuantityMeasurementAppTest {

@Mock
QuantityMeasurementApp.Feet quantityMeasurementApp;

@Test
    public void testFeetEqualitySameValue(){
            QuantityMeasurementApp.Feet feet1 = new QuantityMeasurementApp.Feet(10);
            QuantityMeasurementApp.Feet feet2 = new QuantityMeasurementApp.Feet(10);
            assertTrue(feet1.equals(feet2));
    }

    @Test
    public void testFeetEqualityDiffrentValue(){
        QuantityMeasurementApp.Feet feet1 = new QuantityMeasurementApp.Feet(10);
        QuantityMeasurementApp.Feet feet2 = new QuantityMeasurementApp.Feet(11.11);
        demonstrateFeetEquality();
        assertFalse(feet1.equals(feet2));
    }

    @Test
    public void testFeetEqualityNullComparison(){
        QuantityMeasurementApp.Feet feet1 = new QuantityMeasurementApp.Feet(10);
        QuantityMeasurementApp.Feet feet2 = null;

        assertFalse(feet1.equals(feet2));
    }

    @Test
    public void testFeetEqualityDiffrentClass(){
        QuantityMeasurementApp.Feet feet1 = new QuantityMeasurementApp.Feet(10);
        String test = "test";

        assertFalse((feet1.equals(test)));
    }


    @Test
    public void testFeetEqualitySameReference(){
        QuantityMeasurementApp.Feet feet1 = new QuantityMeasurementApp.Feet(10);

        assertTrue((feet1.equals(feet1)));
    }

    @Test
    public void testFeetEquality(){
        Length feet1 = new Length(1.0, Length.LengthUnit.FEET);
        Length feet2 = new Length(1.0, Length.LengthUnit.FEET);
        assertTrue(feet1.equals(feet2));
    }


    @Test
    public void testInchesEquality(){
        Length inches1 = new Length(1.0, Length.LengthUnit.INCHES);
        Length inches2 = new Length(1.0, Length.LengthUnit.INCHES);
        demonstrateInchesEquality();
        assertTrue(inches1.equals(inches2));
    }

    @Test
    public void testFeetInchesEquality(){
        Length feet = new Length(1.0, Length.LengthUnit.FEET);
        Length inches = new Length(12.0, Length.LengthUnit.INCHES);
        assertTrue(feet.equals(inches));
    }

    @Test
    public void testInchesToFeetEquality(){
        Length feet = new Length(1.0, Length.LengthUnit.FEET);
        Length inches = new Length(12.0, Length.LengthUnit.INCHES);
        assertTrue(inches.equals(feet));
    }

    @Test
    public void testFeetToFeetDiffrentValue(){
        Length feet1 = new Length(1.0, Length.LengthUnit.FEET);
        Length feet2 = new Length(12.0, Length.LengthUnit.FEET);
        assertFalse(feet1.equals(feet2));
    }

    @Test
    public void testInchToInchDiffrentValue(){
        Length inch1 = new Length(1.0, Length.LengthUnit.INCHES);
        Length inch2 = new Length(12.0, Length.LengthUnit.INCHES);
        demonstrateFeetInchesComparison();
        assertFalse(inch1.equals(inch2));
    }

    @Test
    public void testEqualityInvalidUnit(){
        Length inch1 = new Length(1.0, Length.LengthUnit.INCHES);
        Length inch2 = new Length(12.0, null);
        assertThrows(IllegalArgumentException.class, ()->inch1.equals(inch2));

    }

    @Test
    public void testEqualityNullUnit(){
        Length inch1 = new Length(1.0, null);
        Length inch2 = new Length(12.0, null);
        assertThrows(IllegalArgumentException.class, ()->inch1.equals(inch2));

    }

    @Test
    public void testEqualitySameReference(){
        Length inch1 = new Length(1.0, Length.LengthUnit.INCHES);

        assertTrue(inch1.equals(inch1));

    }

    @Test
    public void testEqualityDiffrentClass(){
        Length inch1 = new Length(1.0, Length.LengthUnit.INCHES);
        String test = "test";
        assertFalse(inch1.equals(test));

    }

    @Test
    public void testEqualityQuantityMeasurementDiffrentClass(){
        QuantityMeasurementApp.Inches inch1 = new QuantityMeasurementApp.Inches(1.0);
        String test = "test";
        assertFalse(inch1.equals(test));

    }


    @Test
    public void testEqualityNullComparison(){
        Length inch1 = new Length(1.0, Length.LengthUnit.INCHES);
        Length inch2 = new Length(3.0, Length.LengthUnit.INCHES);
        assertFalse(inch1.equals(inch2));

    }

}
