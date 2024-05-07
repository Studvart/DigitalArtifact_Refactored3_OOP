package DigitalArtifact_Refactored3_OOP.Testing;

public class ConsoleColours {
    // Define ANSI escape codes for colors
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";

    // Print message in red color
    public static void printRed(String message) {
        System.out.println(RED + message + RESET);
    }

    // Print message in green color
    public static void printGreen(String message) {
        System.out.println(GREEN + message + RESET);
    }

    // Print message in green color
    public static void printCyan(String message) {
        System.out.println(CYAN + message + RESET);
    }

    // Print message in green color
    public static void printYellow(String message) {
        System.out.println(YELLOW + message + RESET);
    }

    // Print message in green color
    public static void printPurple(String message) {
        System.out.println(PURPLE + message + RESET);
    }
}

