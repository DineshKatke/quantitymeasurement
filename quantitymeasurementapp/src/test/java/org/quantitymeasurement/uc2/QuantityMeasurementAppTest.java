package org.quantitymeasurement.uc2;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;


import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class QuantityMeasurementAppTest {

    @Mock
    org.quantitymeasurement.QuantityMeasurementApp.Feet quantityMeasurementApp;

    @Test
    public void testFeetEqualitySameValue(){
        QuantityMeasurementApp.Feet feet1 = new QuantityMeasurementApp.Feet(10);
        org.quantitymeasurement.QuantityMeasurementApp.Feet feet2 = new org.quantitymeasurement.QuantityMeasurementApp.Feet(10);

        assertTrue(feet1.equals(feet2));
    }

    @Test
    public void testFeetEqualityDiffrentValue(){
        QuantityMeasurementApp.Feet feet1 = new QuantityMeasurementApp.Feet(10);
        QuantityMeasurementApp.Feet feet2 = new QuantityMeasurementApp.Feet(11.11);

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
    public void testInchesEqualitySameValue(){
        QuantityMeasurementApp.Inches inches1 = new QuantityMeasurementApp.Inches(10);
        QuantityMeasurementApp.Inches inches2 = new QuantityMeasurementApp.Inches(10);
        assertTrue((inches1.equals(inches2)));
    }

    @Test
    public void testInchesEqualityDiffrentValue(){
        QuantityMeasurementApp.Inches inches1 = new QuantityMeasurementApp.Inches(10);
        QuantityMeasurementApp.Inches inches2 = new QuantityMeasurementApp.Inches(11.11);
        assertFalse((inches1.equals(inches2)));
    }

    @Test
    public void testInchesEqualityNullComparison(){
        QuantityMeasurementApp.Inches inches1 = new QuantityMeasurementApp.Inches(10);
        QuantityMeasurementApp.Inches inches2 = null;
        assertFalse((inches1.equals(inches2)));
    }

    @Test
    public void testInchesEqualityDiffrentClass(){
        QuantityMeasurementApp.Inches inches1 = new QuantityMeasurementApp.Inches(10);
        String testString = "Test";
        assertFalse((inches1.equals(testString)));
    }

    @Test
    public void testInchesEqualitySameReference(){
        QuantityMeasurementApp.Inches inches1 = new QuantityMeasurementApp.Inches(10);

        assertTrue((inches1.equals(inches1)));
    }
}
