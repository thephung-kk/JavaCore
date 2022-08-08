
import java.math.BigInteger;
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
public class Manager {

    private static Scanner sc = new Scanner(System.in);

    static void convertFromBinary(String binary) {
        int choice = chooseFunction("binary", "decimal", "hexa");
        switch (choice) {
            case 1: //binary to decimal
                System.out.println("(Binary) " + binary + " = (Decimal) " + convertBinaryToDecimal(binary));
                break;
            case 2: //binary to hexa
                System.out.println("(Binary) " + binary + " = (Hexa) " + convertBinaryToHexa(binary));
                break;
        }
    }

    static void convertFromDecimal(String decimal) {
        int choice = chooseFunction("decimal", "binary", "hexa");
        switch (choice) {
            case 1: //decimal to binary
                System.out.println("(Decimal)" + decimal + " = (Binary) " + convertDecimalToBinary(decimal));
                break;
            case 2: //decimal to hexa
                System.out.println("(Decimal)" + decimal + " = (Hexa) " + convertDecimalToHexa(decimal));
                break;
        }
    }

    static void convertFromHexa(String hexa) {
        int choice = chooseFunction("hexa", "binary", "decimal");
        switch (choice) {
            case 1: //hexa to binary 
                System.out.println("(Hexa)" + hexa + " = (Binary)" + convertHexaToBinary(hexa));
                break;
            case 2: //hexa to decimal
                System.out.println("(Hexa)" + hexa + " = (Decimal)" + connvertHexaToDecimal(hexa));
                break;
        }
    }

    public static int chooseFunction(String from, String toCase1, String toCase2) {
        System.out.println("1. Convert from " + from + " to " + toCase1);
        System.out.println("2. Convert from " + from + " to " + toCase2);
        System.out.print("Enter your choice: ");
        //loop until user input correct
        while (true) {
            try {
                int choice = Integer.parseInt(sc.nextLine().trim());
                if (choice < 1 || choice > 2) {
                    System.err.println("Please choose '1' or '2'");
                    System.out.print("Enter again: ");
                } else {
                    return choice;
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter an integer number: ");
                System.out.print("Enter again: ");
            }
        }
    }

    static String convertBinaryToDecimal(String binary) {
        BigInteger two = new BigInteger(2 + "");
        BigInteger decimal = new BigInteger(0 + "");
        for (int i = 0; i < binary.length(); i++) {
            char cVal = binary.charAt(i);
            BigInteger cValue = new BigInteger(cVal + "");
            decimal = decimal.multiply(two).add(cValue); // char at 'i' multiply with 2 'length - i - 1' times
        }
        return decimal.toString();
    }

    private static String convertBinaryToHexa(String binary) {
        String decimal = convertBinaryToDecimal(binary);
        String hexa = convertDecimalToHexa(decimal);
        return hexa;
    }

    private static String convertDecimalToBinary(String decimal) {
        BigInteger decimalNumber = new BigInteger(decimal);
        BigInteger zero = new BigInteger(0 + "");
        BigInteger two = new BigInteger(2 + "");
        String binary = "";
        while (decimalNumber.compareTo(zero) == 1) { // loop until quotient is zero
            binary = decimalNumber.mod(two).toString() + binary; //new residual is first char of result
            decimalNumber = decimalNumber.divide(two); // continue loop with new quotient 
        }
        return binary;
    }

    private static String convertDecimalToHexa(String decimal) {
        BigInteger decimalNumber = new BigInteger(decimal);
        BigInteger zero = new BigInteger(0 + "");
        BigInteger hex = new BigInteger(16 + "");
        String hexa = "";
        char hexchars[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        while (decimalNumber.compareTo(zero) == 1) { // loop until quotient is zero
            hexa = hexchars[Integer.parseInt(decimalNumber.mod(hex).toString())] + hexa; //new residual is first char of result
            decimalNumber = decimalNumber.divide(hex); // continue loop with new quotient 
        }
        return hexa;
    }

    private static String convertHexaToBinary(String hexa) {
        String decimal = connvertHexaToDecimal(hexa);
        String binary = convertDecimalToBinary(decimal);
        return binary;
    }

    private static String connvertHexaToDecimal(String hexa) {
        String hexchars = "0123456789ABCDEF";
        hexa = hexa.toUpperCase();
        BigInteger hex = new BigInteger(16 + "");
        BigInteger decimal = new BigInteger(0 + "");
        for (int i = 0; i < hexa.length(); i++) {
            char c = hexa.charAt(i);
            int cVal = hexchars.indexOf(c); // A → F same with 10 → 15
            BigInteger cValue = new BigInteger(cVal + "");
            decimal = decimal.multiply(hex).add(cValue); // char at 'i' multiply with 16 'length - i - 1' times
        }
        return decimal.toString();

    }
}
