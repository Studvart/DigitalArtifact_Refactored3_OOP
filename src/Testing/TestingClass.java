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


public class TestingClass {
    static Manager manager = new Manager();
    static Product product = new Product();
    static Customer customer = new Customer();
    static Tier tier = new Tier();
    static Satisfaction satisfaction = new Satisfaction();

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
        String _firstname = "Fridge";
        String _surname = "Magnet";
        int _policyNumber = 654321;
        String _tierBronzeSelected = "Bronze";
        String _tierSilverSelected = "Silver";
        String _tierGoldSelected = "Gold";

        Tier _tierBronze = new Tier_Bronze();
        Tier _tierSilver = new Tier_Silver();
        Tier _tierGold = new Tier_Gold();

        checkTierAssigned();


        /*
        customer.setFirstName(_firstname);
        customer.setSurname(_surname);
        customer.setPolicyNumber(_policyNumber);
        customer.setTierSelected(_tierSilverSelected);
        tier.set_tier(_tierBronze);
        */
    }

    public static void checkTierAssigned() {
        int _tierAssignedInput = 2;
        String _ouput = tier.tierAssigned(_tierAssignedInput);
        if (_ouput.equals("Silver")) {
            System.out.println("Test Passed");
        } else {
            System.out.println("Test Failed");
        }
    }

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

    public void testingVs422618() {
        // Tests ReadFile Class
        if (customer.getFirstName().equals("Possidon")
            && customer.getSurname().equals("Zeus")
            && tier.get_tierSelected().equals("Gold")
            && customer.getPolicyNumber() == 422618) {
            System.out.println("Test Passed - Details Macthed Policy 422618");
        } else {
            System.out.println("Test Failed - Details didnt Macth Policy 422618");
        }
    }

    private void testOutcomePolicyInt() throws InvalidPolicyNumberException {
        int _genNum = getRandomIntBetween(testMinPolNum, testMaxPolNum);
        product.checkPolicyNumber(_genNum);
        System.out.println(_genNum);
    }

    private void testChars() {
        char ch = 'l';
        String string = "Hello World";
        int testing = StringUtils.timesCharOccurs(ch, string);
        System.out.println(testing);

        String string2 = "abcdefghijklmnopqrstuvwxyz";
        String testing2 = StringUtils.frequencyReport(string);
        System.out.println(testing2);
    }
}
