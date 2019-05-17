/*  Alex Moore
    CPSC 2150 Lab 1
    Create a MatrixApp
*/

import java.util.Scanner;

    /**
     * Created by alex9 on 1/22/2018.
     */
    public class MatrixApp {
        public static void main (String [] args) {
            int x;      //x and y elements to hold row and column values
            int y;

            //read in the size of the rows and column, between 1-10
            System.out.println("How many rows should your matrix have?");
            Scanner scanner = new Scanner( System.in );
            x = scanner.nextInt();
            while (x < 1 || x > 10) {
                System.out.println("Enter a number between 1 and 10");
                x = scanner.nextInt();
            }
            System.out.println("How many columns should your matrix have?");
            y = scanner.nextInt();
            while (y < 1 || y > 10) {
                System.out.println("Enter a number between 1 and 10");
                y = scanner.nextInt();
            }

            //Create a matrix to hold the values
            int[][] matrix = new int[x][y];

            //read in the users data for the matrix
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    System.out.println("What number should go in Row: " + i + "Col: " + j);
                    matrix[i][j] = scanner.nextInt();
                }
            }

            //print out the matrix
            System.out.println("Your matrix is: ");
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    System.out.print("| ");
                    System.out.print(matrix[i][j]);
                    System.out.print("| ");
                }
                System.out.print("\n");
            }

            //create and print out a transpose of the matrix
            int[][] trans = transpose(matrix, x, y);
            System.out.println("The transpose matrix is: ");
            for (int i = 0; i < y; i++) {
                for (int j = 0; j < x; j++) {
                    System.out.print("| ");
                    System.out.print(trans[i][j]);
                    System.out.print("| ");
                }
                System.out.print("\n");
            }

            //sum each row and then multiply together to get total row product
            //and print the value
            int product = rowproduct(matrix, x, y);
            System.out.println("The product sum is:");
            System.out.println(product);

            //find and print the avg size of numbers in the matrix
            double average = average(matrix, x, y);
            System.out.println("The average is:");
            System.out.println(average);

            //calculate and print the sum of each row in the matrix
            int[] rowsum = sumrow(matrix, x, y);
            System.out.println("The sums of each Row are:");
            for (int i = 0; i < x; i++) {
                System.out.print("| " + rowsum[i]);
            }
            System.out.println("|");

            //calculate the sum of each column in the matrix
            int[] colsum = sumcolumn(matrix, x, y);
            System.out.println("The sums of each Column are:");
            for (int i = 0; i < y; i++) {
                System.out.print("| " + colsum[i]);
            }
            System.out.println("|");
        }
        private static int[][] transpose(int[][] matrix, int x, int y) {
            int[][] newmatrix = new int[y][x];
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    newmatrix[j][i] = matrix[i][j];
                }
            }
            return newmatrix;
        }
        private static int rowproduct(int[][] matrix, int x, int y) {
            int product = 1;
            int row = 0;
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    row += matrix[i][j];
                }
                product = product * row;
                row = 0;
            }
            return product;
        }
        private static double average(int[][] matrix, int x, int y){
            double avg = 0;
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    avg += matrix[i][j];
                }
            }
            avg = avg / (x*y);
            return avg;
        }
        private static int[] sumcolumn(int[][] matrix, int x, int y){
            int[] sc = new int[y];
            for (int j = 0; j < y; j++) {
                for (int i = 0; i < x; i++) {
                    sc[j] += matrix[i][j];
                }
            }
            return sc;
        }

        private static int[] sumrow(int[][] matrix, int x, int y){
            int[] sr = new int[x];
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    sr[i] += matrix[i][j];
                }
            }
            return sr;
        }
    }
