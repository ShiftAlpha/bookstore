package com.bookstore.util;

import java.util.Random;

public class ISBNGenerator {

    public static String generateISBN() {
        Random random = new Random();
        int[] digits = new int[9];

        // Generate first 12 digits randomly
        for (int i = 0; i < 9; i++) {
            digits[i] = random.nextInt(10);
        }

        // Calculate check digit
        int checkDigit = calculateCheckDigit(digits);

        // Construct ISBN-13
        StringBuilder isbn = new StringBuilder("978");
        for (int digit : digits) {
            isbn.append(digit);
        }
        isbn.append(checkDigit);
        return isbn.toString();
    }

    private static int calculateCheckDigit(int[] digits) {
        int sum = 0;
        for (int i = 0; i < digits.length; i++) {
            sum += (i % 2 == 0) ? digits[i] : digits[i] * 3;
        }
        int remainder = sum % 10;
        return (remainder == 0) ? 0 : 10 - remainder;
    }
}
