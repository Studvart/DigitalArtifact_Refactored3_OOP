package DigitalArtifact_Refactored3_OOP.Testing;

import DigitalArtifact_Refactored3_OOP.CoreDetails.Customer;
import DigitalArtifact_Refactored3_OOP.CoreDetails.Product;
import DigitalArtifact_Refactored3_OOP.CoreDetails.Satisfaction;
import DigitalArtifact_Refactored3_OOP.CoreDetails.Tier;
import DigitalArtifact_Refactored3_OOP.Digital_Artifact_Run.Manager;
import DigitalArtifact_Refactored3_OOP.ExtendedTier.Tier_Bronze;
import DigitalArtifact_Refactored3_OOP.ExtendedTier.Tier_Gold;
import DigitalArtifact_Refactored3_OOP.Storage.ReadFile;


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

    /*public TestingClass() {
    }

    public TestingClass(Customer _customer, Tier _tier, Satisfaction _satisfaction) {
        customer = _customer;
        tier = _tier;
        satisfaction = _satisfaction;
    }*/

    public static void main(String[] args) {
        /*
        Tier _tierBronze = new Tier_Bronze();
        Tier _tierSilver = new Tier_Silver();
        Tier _tierGold = new Tier_Gold();
        */

        System.out.println("Does the Tier selection menu produce the correct result?");
        checkTierAssigned();
        System.out.println("Does the Benefit selection menu produce the correct result?");
        checkBenefits();
        System.out.println("Does the correct text display when for an option when input on the benefit menu?");
        checkRewardsBenefitOutputOnBronze();
        System.out.println("When inputting a valid policy number, are the correct details returned?");
        testingVs422618();


        /*
        customer.setFirstName(_firstname);
        customer.setSurname(_surname);
        customer.setPolicyNumber(_policyNumber);
        customer.setTierSelected(_tierSilverSelected);
        tier.set_tier(_tierBronze);
        */
    }

    public static void checkTierAssigned() {
        // Proved the user input corresponds to the expected assigned Tier.
        int _tierAssignedUserInput = 2;
        String _output = tier.tierAssigned(_tierAssignedUserInput);
        if (_output.equals("Silver")) {
            System.out.println("Test Passed");
        } else {
            System.out.println("Test Failed");
        }
    }

    public static void checkBenefits() {
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

    public static void testingVs422618() {
        // Tests ReadFile Class
        Customer _customer = ReadFile.accessPolicyData(422618);
        if (_customer.getFirstName().equals("Possidon") && _customer.getSurname().equals("Zeus") && _customer.getTierSelected().equals("Gold")) {
            System.out.println("Test Passed - Details Matched Policy 422618");
        } else {
            System.out.println("Test Failed - Details didn't Match Policy 422618");
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
    }

    public void testingOne() throws InvalidPolicyNumberException {
        int[] testPolNum = {-5, 32475, 111111, 1234569};

        for (int j = 0; j <= 4; j++) {
            product.checkPolicyNumber(testPolNum[j]);
        }
    }

    private void testOutcomePolicyInt() throws InvalidPolicyNumberException {
        int _genNum = getRandomIntBetween(testMinPolNum, testMaxPolNum);
        product.checkPolicyNumber(_genNum);
        System.out.println(_genNum);
    }
    */
}
