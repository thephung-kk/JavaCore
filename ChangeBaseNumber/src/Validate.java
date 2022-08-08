
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author theph
 */
public class Validate {

    private final static Scanner sc = new Scanner(System.in);
    private static String BINARY_VALID = "[0-1]*";
    private static String DECIMAL_VALID = "[0-9]*";
    private static String HEXA_VALID = "[0-9A-Fa-f]*";

    static String checkInputBinary() {
        System.out.print("Enter binary number: ");
        String binary;
        //loop until user input correct
        while (true) {
            binary = sc.nextLine().trim();
            if (binary.matches(BINARY_VALID)) {
                return binary;
            }
            System.err.println("Must be enter 0 or 1");
            System.out.print("Enter again: ");
        }
    }

    static String checkInputDecimal() {
        System.out.print("Enter decimal number: ");
        String decimal;
        //loop until user input correct
        while (true) {
            decimal = sc.nextLine().trim();
            if (decimal.matches(DECIMAL_VALID)) {
                return decimal;
            }
            System.err.println("Must be enter char 0 → 9");
            System.out.print("Enter again: ");
        }
    }

    static String checkInputHexaDecimal() {
        System.out.print("Enter number hexadecimal: ");
        String hexa;
        //loop until user input correct
        while (true) {
            hexa = sc.nextLine().trim();
            if (hexa.matches(HEXA_VALID)) {
                return hexa;
            }
            System.err.println("Must be enter char 0 → 9 and A → F (a → f)");
            System.out.print("Enter again: ");
        }
    }

}
