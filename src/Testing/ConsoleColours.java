package DigitalArtifact_Refactored3_OOP.Testing;

public class ConsoleColours {
    // Define ANSI escape codes for colors
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";

    // Print message in red color
    public static void printRed(String message) {
        System.out.println(RED + message + RESET);
    }

    // Print message in green color
    public static void printGreen(String message) {
        System.out.println(GREEN + message + RESET);
    }
}

