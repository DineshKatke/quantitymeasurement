package org.quantitymeasurement;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.quantitymeasurement.uc3.QuantityMeasurementApp;

import static org.junit.jupiter.api.Assertions.*;


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
}
