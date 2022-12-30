package com.driver;

public class SavingsAccount extends BankAccount{
    double rate;
    double maxWithdrawalLimit;
    double am;
    double bal;
    public SavingsAccount(String name, double balance, double minBalance, double rate, double maxWithdrawalLimit) {
        super(name, balance, minBalance);
        this.rate = rate;
        this.maxWithdrawalLimit = maxWithdrawalLimit;
        this.bal=balance;
    }


    public void withdraw(double amount) throws Exception {
        // Might throw the following errors:
        // 1. "Maximum Withdraw Limit Exceed" : If the amount exceeds maximum withdrawal limit
        // 2. "Insufficient Balance" : If the amount exceeds balance
        if(amount>maxWithdrawalLimit)
            throw new ArithmeticException("Maximum Withdraw Limit Exceed");
        if(this.bal<amount)
            throw new ArithmeticException("Insufficient Balance");
    }

    public double getSimpleInterest(int years){
        // Return the final amount considering that bank gives simple interest on current amount
     double fmaount=0;
     double i=(this.bal*this.rate*years)/100;
     fmaount=i+this.bal;
     return fmaount;
    }

    public double getCompoundInterest(int times, int years){
        // Return the final amount considering that bank gives compound interest on current amount given times per year
       double principle=0;
       double fm=0;


         double i=principle * (Math.pow((1 + rate / 100), times*years)) - principle;
         fm=fm+i;
         return fm;
    }

}
