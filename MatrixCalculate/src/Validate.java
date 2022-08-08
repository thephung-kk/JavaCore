
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

    static int[][] checkInputMatrix(int n) {
        System.out.print("Enter Row Matrix: ");
        int row = checkInputInt();
        System.out.print("Enter Colum Matrix: ");
        int col = checkInputInt();
        int[][] matrix = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print("Enter Matrix" + n + " [" + i + "]" + "[" + j + "]:");
                matrix[i][j] = checkInputInt();
            }
        }
        return matrix;
    }

    private static int checkInputInt() {
        //loop until user input correct
        while (true) {
            try {
                int n = Integer.parseInt(sc.nextLine());
                if (n < 0) {
                    System.err.println("Please enter positive integer number:");
                    System.out.println("Enter again");
                }
                return n;
            } catch (NumberFormatException ex) {
                System.err.println("Please enter an integer number:");
                System.out.println("Enter again");
            }
        }
    }

}
