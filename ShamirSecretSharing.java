package com.shamirsecretsharing;

import java.util.Random;

public class ShamirSecretSharing {

    public static void main(String[] args) {
        // Example usage
        String secret = "Hello, World!";
        int threshold = 3;
        int numShares = 5;

        InputData inputData = new InputData(secret, threshold, numShares);

        // Generate random coefficients for the polynomial
        int[] coefficients = generateCoefficients(inputData.getThreshold(), inputData.getNumShares());

        // Create the root object
        Root root = new Root(coefficients);

        // Generate shares
        int[] shares = generateShares(coefficients, inputData.getSecret(), inputData.getNumShares());

        // Create the keys object
        Keys keys = new Keys(shares);

        // Print the shares
        System.out.println("Shares:");
        for (int i = 0; i < keys.getShares().length; i++) {
            System.out.println("Share " + (i + 1) + ": " + keys.getShares()[i]);
        }
    }

    private static int[] generateCoefficients(int threshold, int numShares) {
        Random random = new Random();
        int[] coefficients = new int[threshold];
        for (int i = 0; i < threshold; i++) {
            coefficients[i] = random.nextInt(100);
        }
        return coefficients;
    }

    private static int[] generateShares(int[] coefficients, String secret, int numShares) {
        int[] shares = new int[numShares];
        for (int i = 0; i < numShares; i++) {
            int share = 0;
            for (int j = 0; j < coefficients.length; j++) {
                share += coefficients[j] * (int) Math.pow(i + 1, j);
            }
            shares[i] = share;
        }
        return shares;
    }
}
