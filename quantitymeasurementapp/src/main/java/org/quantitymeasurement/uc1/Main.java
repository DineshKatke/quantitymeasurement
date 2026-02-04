package org.quantitymeasurement.uc1;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

        QuantityMeasurementApp.Feet feet1 = new QuantityMeasurementApp.Feet(10);
        QuantityMeasurementApp.Feet feet2 = new QuantityMeasurementApp.Feet(10.00);

        System.out.println(feet1.equals(feet2));

//        }
    }
}