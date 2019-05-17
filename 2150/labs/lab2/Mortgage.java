package cpsc2150.labs.lab2;


/**
 * Created by kplis on 1/23/2018.
 */

/**
 * @invariants houseCost >= 0 and
 *  houseCost >= downPayment >= 0 and
 *  years = 15, 20, 25, or 30
 *  2.5% <= interestRate <= 14%
 */
public class Mortgage {



    private double houseCost;
    private double downPayment;
    private double percentDown;
    private int years;
    private double interestRate;
    private double payment;
    private Customer customer;

    /**
     *
     * @param cost the houseCost and
     * @param dp the downPayment and
     * @param y the years
     * @param cust the customer
     * @requires cost >= 0 and
     * dp >= 0
     * y == 15 || 20 || 25 || 30
     * @ensures houseCost = cost and
     * downPayment = dp and
     * years = y and
     * cust = customer
     * calcRate is called
     * calcPayment is called
     * percentDown = the percent down
     */
    Mortgage(double cost, double dp, int y, Customer cust)
    {
        customer = cust;
        houseCost = cost;
        downPayment = dp;
        years = y;
        percentDown = (dp/cost);
        calcRate();
        interestRate = getRate();
        calcPayment();
        payment = getPayment();

        /*
        Sets the house cost, down payment, years and customer. Calculates the percent down, rate, and payment
         */
    }
    /**
     * @requires constructor has been called
     * @ensures interestRate is correct value
     */
    private void calcRate()
    {
        /*
        Calculates the interest rate to use.
        The rate starts at the base rate of 2.5%
        If the loan is for 30 years, add the normal addition of 1%
        If the loan is for for less than 30 years, add the good addition of .5%
        The loan must be for 15, 20, 25 or 30 years

        Add the rate for the credit score based on the following table
        Credit rating | Credit score | add to rate
        Bad           | 0 - 500      | 10%
        Fair          | 500 - 599    | 5%
        Good          | 600 - 699    | 1%
        Great         | 700 - 749    | .5%
        Excellent     | 750 - 850    | 0%

        If the down payment is less than 20% of the price of the house, add .5%
         */
        interestRate = .025;
        if (years == 30) {
            interestRate += .01;
        }
        else {
            interestRate += .005;
        }
        if (customer.getCreditScore() >= 0 && customer.getCreditScore() < 500) {
            interestRate += .1;
        }
        if (customer.getCreditScore() >= 500 && customer.getCreditScore() <= 599 ) {
            interestRate += .05;
        }
        if (customer.getCreditScore() >= 600 && customer.getCreditScore() <= 699) {
            interestRate += .01;
        }
        if (customer.getCreditScore() >= 700 && customer.getCreditScore() <= 749) {
            interestRate += .005;
        }
        if (percentDown < .2) {
            interestRate += .005;
        }
    }

    /**
     * @requires constuctor has been called
     * @ensures payment = the monthly payment
     */
    private void calcPayment()
    {
        /*
        Calculate the monthly payment
        terms:
        r - monthly rate - the interest rate divided by 12
        p - principal balance - the cost of the house minus the down payment
        n - number of payments - the total number of monthly payments

        monthly payment is (rp)/(1-(1+r)^-n)
         */
        final int months = 12;
        final double r = interestRate/12;
        final double p = houseCost - downPayment;
        final int n = years * months;
        payment = (r * p) / (1 - (Math.pow((1 + r),(-n))));

    }
    /**
     * @return whether or not the loan is approved
     * @requires constuctor has been called
     * @ensures the correct value is returned for loan approval
     */
    public boolean loanApproved()
    {
        /*
        If the interest rate is too high (10% or higher) the loan is denied
        If the down payment is less than 3.5% of the price of the house then the loan is denied

        If the Debt to income ratio is above 40% the loan is denied
        The debt to income ratio is the total monthly debt payments (including the mortgage payment) / monthly income
        payment on the house and mortgage together
        Otherwise the loan is approved
        */
        final double tooHigh = .1;
        final double downPayTooLow = .035 * houseCost;
        final double fortypercent = .4;
        if (interestRate >= tooHigh) return false;
        if (downPayment < downPayTooLow) return false;
        if (((customer.getMonthlyDebtPayments() + payment) / (customer.getIncome()/12)) > fortypercent) return false;

        return true;
    }
    /**
     * @return the monthly payment for the loan
     * @requires calcPayment has been called
     * @ensures getPayment = payment
     */
    public double getPayment()
    {
        //return the monthly payment on the loan
        return payment;
    }
    /**
     * @return the interest rate for the loan
     * @requires calcRate has been called
     * @ensures getRate = interestRate
     */
    public double getRate()
    {
        //return the interest rate on the loan
        return interestRate;
    }
    /**
     * @return the custom string created
     * @requires the constuctor has already been called
     * @ensures the correct string is returned
     *
     */
    @Override
    public String toString()
    {
        //this function is provided
        //DO you need contracts for this?
        String str = "";
        if(loanApproved())
        {
            str += "Principal Amount: $" + (houseCost - downPayment) + "\n";
            str += "Interest Rate: " + (interestRate * 100) + "%\n";
            str += "Term: " + years + " years\n";
            str += "Monthly Payment: $" + payment + "\n";
        }
        else
        {
            str += "Loan was not approved";
        }
        return str;
    }

}
