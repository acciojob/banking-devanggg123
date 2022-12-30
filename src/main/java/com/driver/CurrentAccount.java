package com.driver;

import java.util.Arrays;

public class CurrentAccount extends BankAccount{


    String tradeLicenseId; //consists of Uppercase English characters only


    public CurrentAccount(String name, double balance, double minBalance, String tradeLicenseId) throws Exception {
        // minimum balance is 5000 by default. If balance is less than 5000, throw "Insufficient Balance" exception
        super(name, balance, minBalance);
        this.tradeLicenseId = tradeLicenseId;
        if(balance<5000){
           throw new ArithmeticException("Insufficient Balance");
       }

    }

    public void validateLicenseId() throws Exception {
        // A trade license Id is said to be valid if no two consecutive characters are same
        // If the license Id is valid, do nothing
        // If the characters of the license Id can be rearranged to create any valid license Id
        // If it is not possible, throw "Valid License can not be generated" Exception
        int n=tradeLicenseId.length();

        int[] str = new int[26];
        int hf=0;
        for(char a: tradeLicenseId.toCharArray()){
            if(hf<++str[a-'a']) hf=str[a-'a'];
        }
        if(hf*2-1>n) throw new ArithmeticException("Valid License can not be generated");
        char[] res=new char[n];
        int odd=0, even=1;
        for(int i=0;i<26;i++){
            while(str[i]>0 && str[i]<n/2+1 && even<n){
                res[even]= (char)(i+'a');
                even+=2;
                str[i]--;
            }
            while(str[i]>0){
                res[odd]=(char)(i+'a');
                odd+=2;
                str[i]--;
            }
        }
        tradeLicenseId= Arrays.toString(res);

    }

}
