package DigitalArtifact_Refactored3_OOP.Testing;

import DigitalArtifact_Refactored3_OOP.CoreDetails.Customer;
import DigitalArtifact_Refactored3_OOP.CoreDetails.Product;
import DigitalArtifact_Refactored3_OOP.CoreDetails.Satisfaction;
import DigitalArtifact_Refactored3_OOP.CoreDetails.Tier;
import DigitalArtifact_Refactored3_OOP.Digital_Artifact_Run.InvalidPolicyNumberException;
import DigitalArtifact_Refactored3_OOP.Digital_Artifact_Run.Manager;
import DigitalArtifact_Refactored3_OOP.ExtendedTier.Tier_Bronze;
import DigitalArtifact_Refactored3_OOP.ExtendedTier.Tier_Gold;
import DigitalArtifact_Refactored3_OOP.Storage.ReadFile;
import DigitalArtifact_Refactored3_OOP.Storage.WriteFile;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


public class TestingClass {
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
        System.out.println("Does the Tier selection menu produce the correct result?");
        checkTierAssigned();
        System.out.println("Does the Benefit selection menu produce the correct result?");
        checkBenefits();
        System.out.println("Does the correct text display when for an option when input on the benefit menu?");
        checkRewardsBenefitOutputOnBronze();
        System.out.println("Does writing store the correct details?");
        testingNewCustomerCommit();
        System.out.println("When inputting a valid policy number, are the correct details returned?");
        testingVs422618();
        System.out.println("When inputting an invalid policy number, are these cases correctly identified?");
        testingInvalidPolNumHandling();
        System.out.println("Demonstrates that the survey results are returned in teh correct order.");
        checkSurveyArrayScoresReturned();
        System.out.println("No More Tests");

        /*
        Tier _tierBronze = new Tier_Bronze();
        Tier _tierSilver = new Tier_Silver();
        Tier _tierGold = new Tier_Gold();

        customer.setFirstName(_firstname);
        customer.setSurname(_surname);
        customer.setPolicyNumber(_policyNumber);
        customer.setTierSelected(_tierSilverSelected);
        tier.set_tier(_tierBronze);
        */
    }

    public static void checkTierAssigned() {
        // Proves the user input corresponds to the expected assigned Tier.
        int _tierAssignedUserInput = 2;
        String _output = tier.tierAssigned(_tierAssignedUserInput);
        if (_output.equals(_tierSilverSelected)) {
            System.out.println("Test Passed");
        } else {
            System.out.println("Test Failed");
        }
    }

    public static void checkBenefits() {
        // Proves that the user will be able to select the correct number of options based on assigned Tier.
        customer.setTierSelected(_tierGoldSelected);
        Tier _tierGold = new Tier_Gold();
        tier.set_tier(_tierGold);
        int _optionsAvailable = tier.accessRewardsSelectionMenu(customer);
        if (_optionsAvailable == 4) {
            System.out.println("Test Passed");
        } else {
            System.out.println("Test Failed");
        }
    }

    public static void checkRewardsBenefitOutputOnBronze() {
        // Proves the correct message is displayed when the corresponding option is selected.
        int _optionsSelected = 2;
        Tier _tierBronze = new Tier_Bronze();
        tier.set_tier(_tierBronze);
        String _output = tier.accessRewardsBenefitOutput(_optionsSelected);
        if (_output.equals("""
                We are sorry to hear your possessions have been lost.
                We have forwarded a link via email.
                Please start uploading any evidence or police reports to help us handle your claim.
                                
                """)) {
            System.out.println("Test Passed");
        } else {
            System.out.println("Test Failed");
        }
    }

    public static void testingNewCustomerCommit() {
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
            System.out.println("Test Passed - Details Matched Policy 999999");
        } else {
            System.out.println("Test Failed - Details didn't Match Policy 999999");
        }
    }

    public static void testingVs422618() {
        // Proves the ReadFile Class returns the correct results from a stored record.
        Customer _customer = ReadFile.accessPolicyData(422618);
        if (_customer.getFirstName().equals("Possidon") && _customer.getSurname().equals("Zeus") && _customer.getTierSelected().equals("Gold")) {
            System.out.println("Test Passed - Details Matched Policy 422618");
        } else {
            System.out.println("Test Failed - Details didn't Match Policy 422618");
        }
    }

    public static void testingInvalidPolNumHandling() {
        // Proves that the error handling correctly identifies incompatible values.
        int[] testPolNum = {-5, 32475, 1234569, 111111};
        int _invalidCount = 0;
        int _attemptsCount = 0;

        for (int j = 0; j < 4; j++) {
            try {
                product.checkPolicyNumber(testPolNum[j]);
            } catch (InvalidPolicyNumberException e) {
                _invalidCount = _invalidCount + 1;
            }
            _attemptsCount = _attemptsCount + 1;
        }
        System.out.printf("""
                Count of invalid policy numbers presented %d.
                Count of policy numbers presented %d.
                """, _invalidCount, _attemptsCount);
        if (_attemptsCount == 4 && _invalidCount == 3) {
            System.out.println("Test Passed");
        } else {
            System.out.println("Test Failed");
        }
    }

    public static void checkSurveyArrayScoresReturned() {
        /* ByteArrayOutputStream is used to capture the output normally printed to the console (System.out).
           The redirected output can be compared to the expected output programmatically.
           This allows the automation of the testing process without relying on manual observation.*/
        int[] surveyArray = new int[]{1, 2, 3, 4, 5};

        // Redirect System.out to ByteArrayOutputStream to capture the output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        // Call the method
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

        // Compare actual and expected output
        if (actualOutput.equals(expectedOutput)) {
            System.out.println("Test Passed");
        } else {
            System.out.println("Test Failed");
        }
    }
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

