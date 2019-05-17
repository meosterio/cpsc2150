package cpsc2150.labs.lab2;

/**
 * Created by kplis on 1/23/2018.
 */

/**
 *  @invariants 0 <= creditScore <= 850 and
 *  monthlyDebtPayments >= 0 and
 *  income >= 0
 */
public class Customer {
    private String name;

    private double monthlyDebtPayments;
    private double income;
    private int creditScore;
    private Mortgage loan;
    /**
     * @param debt the monthlyDebtPayments and
     * @param inc the customer income and
     * @param score the customer creditScore and
     * @param n the customer name
     * @requires debt >= 0 and
     * inc >= 0 and
     * 0 <= score <= 850
     * @ensures monthlyDebtPayments = debt and
     * income = inc and
     * creditScore = score and
     * name = n
     */
    Customer( double debt, double inc, int score, String n)
    {

        /*
        Set the monthly debt payments, income, credit score and name
        Credit scores range from 0 - 850
         */
        monthlyDebtPayments = debt;
        income = inc;
        creditScore = score;
        name = n;

    }
    /**
     * @param downPayment the amount needed to pay down and
     * @param years the number of years for the loan
     * @param houseCost the total price of the house
     * @return if the loan is approved or denied
     * @requires downPayment >= 0 and
     *  houseCost >= 0 and
     *  years == 15 || 20 || 25 || 30
     * @ensures the correct value is returned for loan approval
     */
    public boolean applyForLoan(double downPayment, double houseCost, int years)
    {
        //Take the parameters and apply for a loan. Save the loan details as the customers current loan
        // Return whether or not the loan was approved
        loan = new Mortgage(houseCost, downPayment, years, this);

        return loan.loanApproved();
    }

    /**
     * @return interest rate of the loan
     * @requires rate has value
     * @ensures getRate = interestRate
     */
    public double getRate()
    {
        //return the interest rate on the current loan
        return loan.getRate();
    }

    /**
     * @return the amount of the monthly payment on the loan
     * @requires monthlyPay has value
     * @ensures getMonthlyPay = payment
     */
    public double getMonthlyPay()
    {
        //return the monthly payment on the current loan
        return loan.getPayment();
    }

    /**
     * @return the amount of the monthly debt payments as a double
     * @requires monthly debt payments has a value
     * @ensures getMonthlyDebtPayments = monthlyDebtPayments
     */
    public double getMonthlyDebtPayments()
    {
        //return the customers monthly debt payments
        return monthlyDebtPayments;
    }

    /**
     * @return the customers income as a double
     * @requires income has a value
     * @ensures getIncome = income
     */
    public double getIncome()
    {
        //return the customers income
        return income;
    }

    /**
     * @return the customers credit score as an int
     * @requires credit score has a value
     * @ensures getCreditScore = creditScore
     */
    public int getCreditScore()
    {
        //return the customers credit score
        return creditScore;
    }

    /**
     * @return the custom string created
     * @requires the constructor has already been called
     * @ensures the correct string is returned
     */
    @Override
    public String toString()
    {
        String str = "";
        str += "Name: " + name + "\n";
        str += "Income: $" + income + "\n";
        str += "Credit Score: " + creditScore + "\n";
        str += "Monthly Debt: $" + monthlyDebtPayments + "\n";
        str += "Mortgage info: \n";
        if( loan != null) {
            str += loan.toString();
        }
        return str;
    }
}
