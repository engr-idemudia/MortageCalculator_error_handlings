package dev.idemudia;

import java.sql.SQLOutput;
import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;
        int principal = 0;
        float monthlyInterest = 0;
        int numberOfPayments = 0;

        Scanner scanner = new Scanner(System.in);

        // data validation
        while (true){
        System.out.print("Principal: ");
        principal = scanner.nextInt();
        if (principal >= 1000 && principal <= 1_000_000)
            break;
            System.out.println("Enter a valid value between 1000 and 1000000");
        }

        // data validation
        while (true){
        System.out.print("Annual Interest rate: ");
        float annualInterestRate = scanner.nextFloat();
        if (annualInterestRate >= 1.0 && annualInterestRate <= 30.9){
            monthlyInterest = annualInterestRate/PERCENT/MONTHS_IN_YEAR;
            break;
            }
            System.out.println("Enter a value between 1 and 30");
        }

        // data validation
        while (true){
        System.out.print("Period(Years): ");
        byte years = scanner.nextByte();
        if (years >= 1 && years <= 30){
            numberOfPayments = years * MONTHS_IN_YEAR;
            break;
            }
            System.out.println("Enter valid years of payment between 1 and 30");
        }

        //formulae
        double mortage = principal * (monthlyInterest * Math.pow( 1 + monthlyInterest, numberOfPayments))
                /(Math.pow( 1+monthlyInterest,numberOfPayments) -1);

        String mortageFormatted = NumberFormat.getCurrencyInstance().format(mortage);
        System.out.println("mortage: " + mortageFormatted);
    }
}

