package DigitalArtifact_Refactored3_OOP.Testing;

import DigitalArtifact_Refactored3_OOP.CoreDetails.Customer;
import DigitalArtifact_Refactored3_OOP.CoreDetails.Product;
import DigitalArtifact_Refactored3_OOP.CoreDetails.Satisfaction;
import DigitalArtifact_Refactored3_OOP.CoreDetails.Tier;
import DigitalArtifact_Refactored3_OOP.Digital_Artifact_Run.InvalidPolicyNumberException;
import DigitalArtifact_Refactored3_OOP.Digital_Artifact_Run.Manager;
import DigitalArtifact_Refactored3_OOP.ExtendedTier.Tier_Bronze;
import DigitalArtifact_Refactored3_OOP.ExtendedTier.Tier_Gold;
import DigitalArtifact_Refactored3_OOP.ExtendedTier.Tier_Silver;
import DigitalArtifact_Refactored3_OOP.Storage.ReadFile;
import DigitalArtifact_Refactored3_OOP.Storage.WriteFile;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;


public class TestingClass {
    public static Scanner scanner = new Scanner(System.in);
    static Manager manager = new Manager();
    static Product product = new Product();
    static Customer customer = new Customer();
    static Tier tier = new Tier();
    static Satisfaction satisfaction = new Satisfaction();
    static String _tierBronzeSelected = "Bronze";
    static String _tierSilverSelected = "Silver";
    static String _tierGoldSelected = "Gold";
    int testMaxPolNum = 2000000000;
    int testMinPolNum = testMaxPolNum - (testMaxPolNum * 2);

    public static void main(String[] args) {
        ConsoleColours.printCyan("Does the Tier selection menu produce the correct result?");
        checkTierAssigned();
        ConsoleColours.printCyan("Does the Benefit selection menu produce the correct result?");
        checkBenefits();
        ConsoleColours.printCyan("Do the survey results get returned in the correct order?");
        testReturnScores();
        ConsoleColours.printCyan("Does the survey validation accept only correct inputs?");
        testValidateSurveyInput();
        ConsoleColours.printCyan("Does the correct text display when for an option when input on the benefit menu (Bronze)?");
        testRewardsBenefitOutputOnBronze();
        ConsoleColours.printCyan("Does the correct text display when for an option when input on the benefit menu (Silver)?");
        testRewardsBenefitOutputOnSilver();
        ConsoleColours.printCyan("Does the correct text display when for an option when input on the benefit menu (Gold)?");
        testRewardsBenefitOutputOnGold();
        ConsoleColours.printCyan("Does writing store the correct details?");
        testNewCustomerCommit();
        ConsoleColours.printCyan("When inputting a valid policy number, are the correct details returned?");
        testVs422618();
        ConsoleColours.printCyan("When inputting an invalid policy number, are these cases correctly identified?");
        testInvalidPolNumHandling();
        ConsoleColours.printCyan("When inputting determined inputs, will the menu proceed as required?");
        testCustomerRetrieveMenu();
        //Cant get to work
        //System.out.println("When inputting an invalid policy number, are these cases correctly identified?");
        //testRetreiveExistingCustomer();
        ConsoleColours.printCyan("When inputting determined inputs, will the Tier menu proceed as required and return a match to option 2?");
        testOptionMenu();
        ConsoleColours.printCyan("Does the tier selected returns correctly?");
        testTierSelection();
        ConsoleColours.printCyan("Does the tier assigned returns correctly?");
        testTierAssigned();
        ConsoleColours.printCyan("Does the policy number input get returned?");
        testCapturePolicyNumber();
        ConsoleColours.printCyan("No More Tests, Does Programme Terminate?");
        testTerminate();
    }

    private static void provideInput(String data) {
        // Mock user String input for testing
        InputStream stdin = System.in;
        System.setIn(new ByteArrayInputStream(data.getBytes()));
    }

    private static void provideInputInt(int... data) {
        // Mock user int input for testing
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        for (int value : data) {
            printStream.println(value);
        }
        System.setIn(new ByteArrayInputStream(outputStream.toByteArray()));
    }

    private static void restoreInput() {
        // Restore standard input
        System.setIn(System.in);
    }

    private static void restoreOutput() {
        // Restore standard output
        System.setOut(System.out);
    }

    public static void checkTierAssigned() {
        // Proves the user input corresponds to the expected assigned Tier.
        int _tierAssignedUserInput = 2;
        String _output = tier.tierAssigned(_tierAssignedUserInput);
        if (_output.equals(_tierSilverSelected)) {
            ConsoleColours.printGreen("Test Passed");
        } else {
            ConsoleColours.printRed("Test Failed");
        }
    }

    public static void checkBenefits() {
        // Proves that the user will be able to select the correct number of options based on assigned Tier.
        customer.setTierSelected(_tierGoldSelected);
        Tier _tierGold = new Tier_Gold();
        tier.set_tier(_tierGold);
        int _optionsAvailable = tier.accessRewardsSelectionMenu(customer);
        if (_optionsAvailable == 4) {
            ConsoleColours.printGreen("Test Passed");
        } else {
            ConsoleColours.printRed("Test Failed");
        }
    }

    // Test method for returnScores() in Satisfaction class
    public static void testReturnScores() {
        /* ByteArrayOutputStream is used to capture the output normally printed to the console (System.out).
           The redirected output can be compared to the expected output programmatically.
           This allows the automation of the testing process without relying on manual observation.*/

        // Create a sample survey array
        int[] surveyArray = new int[]{1, 2, 3, 4, 5};

        // Create an instance of the Satisfaction class
        Satisfaction satisfaction = new Satisfaction();

        // Call the returnScores method and capture the output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        PrintStream originalOut = System.out;
        System.setOut(printStream);

        satisfaction.returnScores(surveyArray);

        // Reset System.out
        System.setOut(originalOut);

        // Get the actual output
        String actualOutput = outputStream.toString();

        // Define the expected output
        String expectedOutput = """
                You scored us:
                Ease: 1
                Speed: 2
                Clarity: 3
                Claims: 4
                Recommendation: 5
                Average Score: 3.00
                """;

        /* Assert is a feature of the Java language that allows specification of
        conditions that are expected to return true, during program execution.*/
        // Compare actual and expected output
        // assert condition : errorMessage;
        assert actualOutput.equals(expectedOutput) : "Test failed";
        ConsoleColours.printGreen("Test passed");
    }

    public static void testValidateSurveyInput() {
        // Simulates user inputs
        provideInput("v\n999999\n\np\n-1\n3");
        Satisfaction satisfaction = new Satisfaction();
        // Call the method being tested
        int returnedInt = satisfaction.validateSurveyInput();
        // Verify that the method returns null after three attempts
        if (returnedInt == 3) {
            ConsoleColours.printGreen("Test Passed");
        } else {
            ConsoleColours.printRed("Test Failed");
        }
    }

    public static void testRewardsBenefitOutputOnBronze() {
        // Proves the correct message is displayed when the corresponding option is selected.
        Tier tier = new Tier();
        int _optionsSelected = 2;
        Tier _tierBronze = new Tier_Bronze();
        tier.set_tier(_tierBronze);
        String _output = tier.accessRewardsBenefitOutput(_optionsSelected);
        if (_output.equals("""
                We are sorry to hear your possessions have been lost.
                We have forwarded a link via email.
                Please start uploading any evidence or police reports to help us handle your claim.
                                
                """)) {
            ConsoleColours.printGreen("Test Passed");
        } else {
            ConsoleColours.printRed("Test Failed");
        }
    }

    public static void testRewardsBenefitOutputOnSilver() {
        // Proves the correct message is displayed when the corresponding option is selected.
        Tier_Silver tierSil = new Tier_Silver();
        int _optionsSelected = 3;
        String _output = tierSil.accessRewardsBenefitOutput(_optionsSelected);
        if (_output.equals("""
                Our Legal team will be in touch within 1 working day.
                We will assign your case to a relevantly skilled team.
                Please have as much documentation to hand to support the discussion.
                                        
                """)) {
            ConsoleColours.printGreen("Test Passed");
        } else {
            ConsoleColours.printRed("Test Failed");
        }
    }

    public static void testRewardsBenefitOutputOnGold() {
        // Proves the correct message is displayed when the corresponding option is selected.
        Tier_Gold tierGold = new Tier_Gold();
        int _optionsSelected = 4;
        String _output = tierGold.accessRewardsBenefitOutput(_optionsSelected);
        if (_output.equals("""
                Our Team will be in contact within 1 hour.
                Essential home care instructions have been emailed to you,
                to help safeguard your home until we get in touch.
                                        
                """)) {
            ConsoleColours.printGreen("Test Passed");
        } else {
            ConsoleColours.printRed("Test Failed");
        }
    }

    public static void testNewCustomerCommit() {
        // Proves the WriteFile Class stores the correct details.
        Customer cust = new Customer();
        String _fN = "Frank";
        String _sN = "Herbert";
        int _pN = 999999;
        cust.setFirstName(_fN);
        cust.setSurname(_sN);
        cust.setPolicyNumber(_pN);
        cust.setTierSelected(_tierSilverSelected);
        WriteFile.writeCustomerFile(cust);

        Customer _customer = ReadFile.accessPolicyData(_pN);
        if (_customer.getFirstName().equals(_fN) && _customer.getSurname().equals(_sN) && _customer.getTierSelected().equals(_tierSilverSelected)) {
            ConsoleColours.printGreen("Test Passed - Details Matched Policy 999999");
        } else {
            ConsoleColours.printRed("Test Failed - Details didn't Match Policy 999999");
        }
    }

    public static void testVs422618() {
        // Proves the ReadFile Class returns the correct results from a stored record.
        Customer _customer = ReadFile.accessPolicyData(422618);
        if (_customer.getFirstName().equals("Possidon") && _customer.getSurname().equals("Zeus") && _customer.getTierSelected().equals("Gold")) {
            ConsoleColours.printGreen("Test Passed - Details Matched Policy 422618");
        } else {
            ConsoleColours.printRed("Test Failed - Details didn't Match Policy 422618");
        }
    }

    public static void testInvalidPolNumHandling() {
        // Proves that the error handling correctly identifies incompatible values.
        int[] testPolNum = {-5, 32475, 1234569, 111111};
        int _invalidCount = 0;
        int _validCount = 0; // Initialize valid count
        int _attemptsCount = 0;

        for (int j = 0; j < 4; j++) {
            // Uses ++ on values to increment counts - replacing x = x + 1
            try {
                product.checkPolicyNumber(testPolNum[j]);
                // If no exception is thrown, policy number is valid
                _validCount++;
            } catch (InvalidPolicyNumberException e) {
                _invalidCount++;
            }
            _attemptsCount++;
        }
        System.out.printf("""
                Count of invalid policy numbers presented: %d.
                Count of valid policy numbers presented: %d.
                Count of policy numbers presented: %d.
                """, _invalidCount, _validCount, _attemptsCount);
        if (_attemptsCount == 4 && _invalidCount == 3 && _validCount == 1) {
            ConsoleColours.printGreen("Test Passed");
        } else {
            ConsoleColours.printRed("Test Failed");
        }
    }

    public static void testCustomerRetrieveMenu() {
        // Simulates user inputs
        provideInput("v\n999999\n\np\n");
        Manager manager = new Manager();
        Customer retrievedCustomer = manager.customerRetrieveMenu();
        // Add assertions to verify the behavior of the method
        Customer expectedCustomer = ReadFile.accessPolicyData(999999);
        assert retrievedCustomer.equals(expectedCustomer) : "Test failed";
        ConsoleColours.printGreen("Test passed");
        restoreInput();
    }

    public static void testCapturePolicyNumber() {
        // Simulates user inputs
        provideInput("999999\n");
        Manager manager = new Manager();
        int retrievedCustomerPolicyNumber = manager.capturePolicyNumber();
        // Add assertions to verify the behavior of the method
        assert retrievedCustomerPolicyNumber == 999999 : "Test failed";
        ConsoleColours.printGreen("Test passed");
        restoreInput();
    }

    public static void testRetreiveExistingCustomer() {
        // Simulates user inputs
        provideInput("Q\nfrg\n!!dd\n");
        // Call the method being tested
        Customer retrievedCustomer = manager.retreiveExistingCustomer();
        // Verify that the method returns null after three attempts
        if (retrievedCustomer == null) {
            ConsoleColours.printGreen("Test Passed: Method returned null after three attempts.");
        } else {
            ConsoleColours.printRed("Test Failed: Method did not return null after three attempts.");
        }
        restoreInput();
    }

    public static void testOptionMenu() {
        // Simulates user inputs
        provideInput("Q\nf\n!\n44\n2");
        Tier tier = new Tier();
        // Call the method being tested
        int returnedInt = tier.optionMenu();
        // Verify that the method returns null after three attempts
        if (returnedInt == 2) {
            ConsoleColours.printGreen("Test Passed");
        } else {
            ConsoleColours.printRed("Test Failed");
        }
        restoreInput();
        // Errors for this print at the end of the console, cant work out why or how to suppress.
    }

    public static void testTierSelection() {
        // Simulates user inputs
        provideInput("3\n");
        Tier tier = new Tier();
        // Call the method being tested
        String _tierSelect = tier.tierSelection();
        // Verify that the method returns null after three attempts
        if (_tierSelect.equals("Gold")) {
            ConsoleColours.printGreen("Test Passed");
        } else {
            ConsoleColours.printRed("Test Failed");
        }
        restoreInput();
    }

    public static void testTierAssigned() {
        // Simulates user inputs
        int _option = 1;
        Tier tier = new Tier();
        // Call the method being tested
        String _tierSelect = tier.tierAssigned(_option);
        // Verify that the method returns null after three attempts
        if (_tierSelect.equals("Bronze")) {
            ConsoleColours.printGreen("Test Passed");
        } else {
            ConsoleColours.printRed("Test Failed");
        }
        restoreInput();
    }

    public static void testTerminate() {
        // Redirect System.out to capture the output
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        // Call the method being tested
        Manager manager = new Manager();
        manager.terminateProgramme();
        // Verify the printed message
        String expectedMessage = "Thank you for interacting with SAG Bank Insurance Services Limited.";
        String actualMessage = outputStreamCaptor.toString();
        if (expectedMessage.equals(actualMessage)) {
            ConsoleColours.printGreen("Test Passed");
        } else {
            ConsoleColours.printRed("Test Failed");
        }
        // Restore original state
        System.setOut(System.out);
    }



    /*
    public double getRandomDoubleBetween(int min, int max) {
        double truncated;
        double generate = ((Math.random() * (max - min)) + min);
        if (generate >= 0) {
            truncated = Math.floor(generate * 100) / 100;
        } else {
            truncated = Math.ceil(generate * 100) / 100;
        }
        return truncated;
    }

    public int getRandomIntBetween(int min, int max) {
        double generate = ((Math.random() * (max - min)) + min);
        return (int) generate;
    }

    public int getRandomPolicyInt_Between(int min, int max) {
        double generate = ((Math.random() * (max - min)) + min);
        return (int) generate;
    }*/
}

