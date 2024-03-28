package com.TradeFinance.accountservice.util;

import java.util.Random;

public class AccountGenerator {

    public static String generateAccountNumber() {
        Random random = new Random();
        // Generate a random number between 0 and 999999999999 (13 digits)
        long randomNumber = random.nextLong() % 1000000000000L;
        if (randomNumber < 0) {
            // Ensure the number is positive
            randomNumber *= -1;
        }
        // Concatenate "777" with the random number
        return "777" + String.format("%010d", randomNumber);
    }
    public static int generateCifId() {
        Random random = new Random();
        // Generate a random number between 0 and 999999 (6 digits)
        int randomNumber = random.nextInt(1000000);
        // Concatenate "54" with the random number
        return Integer.parseInt("54" + String.format("%06d", randomNumber));
    }


    public static void main(String[] args) {
        // Example usage
        String accountNumber = generateAccountNumber();
        int cifId = generateCifId();
        System.out.println("Generated Account Number: " + accountNumber);
        System.out.println("Generated CIFID: " + cifId);
    }

}
