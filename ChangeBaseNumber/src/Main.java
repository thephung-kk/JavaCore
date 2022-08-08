
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
public class Main {

    /**
     * @param args the command line arguments
     */
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        //loop until user want to exit
        while (true) {
            // Let's user choose function
            int choice = chooseFunction(1, 4);
            switch (choice) {
                case 1: //Convert From Binary.
                    String binary = Validate.checkInputBinary();
                    Manager.convertFromBinary(binary);
                    break;
                case 2: //Convert From Decimal.
                    String decimal = Validate.checkInputDecimal();
                    Manager.convertFromDecimal(decimal);
                    break;
                case 3: //Convert From Hexa.
                    String hexa = Validate.checkInputHexaDecimal();
                    Manager.convertFromHexa(hexa);
                    break;
                case 4: //Exit
                    return;
            }
        }
    }

    private static int chooseFunction(int min, int max) {
        System.out.println("1. Convert From Binary.");
        System.out.println("2. Convert From Decimal.");
        System.out.println("3. Convert From Hexa.");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
        //loop until user input correct
        while (true) {
            try {
                int result = Integer.parseInt(sc.nextLine().trim());
                if (result < min || result > max) {
                    System.err.println("Please input integer number in rage [" + min + ", " + max + "]");
                } else {
                    return result;
                }
            } catch (NumberFormatException e) {
                System.err.println("Please enter an integer number: ");
                System.out.print("Enter again: ");
            }
        }
    }

}
