
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

    private final static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice = chooseFunction(1, 4);
        while (true) {
            switch (choice) {
                case 1:
                    int[][] matrix1 = Validate.checkInputMatrix(1);
                    int[][] matrix2 = Validate.checkInputMatrix(2);
                    Manager.additionMatrix(matrix1, matrix2);
                    break;
                case 2:
                    int[][] matrix3 = Validate.checkInputMatrix(1);
                    int[][] matrix4 = Validate.checkInputMatrix(2);
                    Manager.subtractionMatrix(matrix3, matrix4);
                    break;
                case 3:
                    int[][] matrix5 = Validate.checkInputMatrix(1);
                    int[][] matrix6 = Validate.checkInputMatrix(2);
                    Manager.multiplicationMatrix(matrix5, matrix6);
                    break;
                case 4:
                    return;
            }
        }
    }

    private static int chooseFunction(int min, int max) {
        System.out.println("========Calculator program==========");
        System.out.println("1. Addition Matrix");
        System.out.println("2. Subtraction Matrix");
        System.out.println("3. Multiplication Matrix");
        System.out.println("4. Quit");
        System.out.print("Enter your choice: ");
        //loop until user input correct
        while (true) {
            try {
                int result = Integer.parseInt(sc.nextLine().trim());
                if (result < min || result > max) {
                    System.err.println("Please input integer number in rage [" + min + ", " + max + "]");
                } else {
                    switch (result) {
                        case 1:
                            System.out.println("--------Addition-------");
                            return result;

                        case 2:
                            System.out.println("--------Subtraction--------");
                            return result;

                        case 3:
                            System.out.println("--------MultiPlication----------");
                            return result;
                        case 4:
                            System.out.println("---------Exit----------");
                            return result;
                    }

                }
            } catch (NumberFormatException e) {
                System.err.println("Please enter an integer number: ");
                System.out.print("Enter again: ");
            }
        }
    }

}
