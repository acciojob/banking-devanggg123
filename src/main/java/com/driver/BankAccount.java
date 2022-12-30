package com.driver;

public class BankAccount {

    private String name;
    private double balance;
    private double minBalance;




    public String generateAccountNumber(int digits, int sum) throws Exception{
        //Each digit of an account number can lie between 0 and 9 (both inclusive)
        //Generate account number having given number of 'digits' such that the sum of digits is equal to 'sum'
        //If it is not possible, throw "Account Number can not be generated" exception
        int s=0;
        for(int i=digits;i>0;i=i/10){
            int rem=i%10;
            s +=rem;
        }
        if(s!=sum){
            throw new ArithmeticException("Account Number can not be generated");
        }

        return null;
    }

    public void deposit(double amount) {
        //add amount to balance
        balance +=amount;

    }

    public void withdraw(double amount) throws Exception {
        // Remember to throw "Insufficient Balance" exception, if the remaining amount would be less than minimum balance

        if(amount>this.balance){
            throw new ArithmeticException("Insufficient Balance");
        }
        else{
            balance =balance-amount;
        }
    }

}