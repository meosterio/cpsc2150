package cpsc2150.labs.lab2;

import java.util.Scanner;

/**
 * Created by kplis on 1/23/2018.
 */
public class MortgageApp {
    /**
     * @param args the number of arguments passed in
     * @requires Customer class exists
     * @ensures a new customer is created and
     * a loan is applied for and
     * their information is printed
     *
     */
    public static void main(String [] args)
    {
        double debt;
        double inc;
        int score;
        double downPayment;
        double houseCost;
        int years;
        final String name;

        Scanner scanner = new Scanner( System.in );
        System.out.print("Enter the customer debt: ");
        debt = scanner.nextDouble();
        while (debt < 0) {
            System.out.print("Invalid Input. Enter the customer debt: ");
            debt = scanner.nextInt();
        }
        System.out.print("Enter the customer income: ");
        inc = scanner.nextDouble();
        while (inc < 0) {
            System.out.print("Invalid Input. Enter the customer income: ");
            inc = scanner.nextInt();
        }
        System.out.print("Enter the customer credit score: ");
        score = scanner.nextInt();
        final int maxCredit = 850;
        while (score < 0 || score > maxCredit) {
            System.out.print("Invalid Input. Enter the customer credit score: ");
            score = scanner.nextInt();
        }
        System.out.print("Enter the customer's name: ");
        name = scanner.next();

        System.out.print("Enter the house cost: ");
        houseCost = scanner.nextDouble();
        while (houseCost < 0) {
            System.out.print("Invalid Input. Enter the house cost: ");
            houseCost = scanner.nextInt();
        }
        System.out.print("Enter the customer's down payment: ");
        downPayment = scanner.nextDouble();
        while (downPayment < 0 || downPayment > houseCost) {
            System.out.print("Invalid Input. Enter the customer down payment: ");
            downPayment = scanner.nextInt();
        }
        System.out.print("Enter the number of years for the loan: ");
        years = scanner.nextInt();
        while ((years != 15) && (years != 20) && (years != 25) && (years != 30)) {
            System.out.print("Invalid Input. Enter the number of years: (15, 20, 25, or 30) ");
            years = scanner.nextInt();
        }



        Customer cust = new Customer(debt, inc, score, name);
        cust.applyForLoan(downPayment, houseCost, years);
        System.out.println(cust.toString());


    }
}
