package DigitalArtifact_Refactored3_OOP.Testing;

import DigitalArtifact_Refactored3_OOP.CoreDetails.Customer;
import DigitalArtifact_Refactored3_OOP.CoreDetails.Product;
import DigitalArtifact_Refactored3_OOP.CoreDetails.Satisfaction;
import DigitalArtifact_Refactored3_OOP.CoreDetails.Tier;
import DigitalArtifact_Refactored3_OOP.Digital_Artifact_Run.InvalidPolicyNumberException;

public class TestingClass {
    static Product product = new Product();
    static Customer cust = new Customer();
    static Tier tier = new Tier();
    static Satisfaction satisfaction = new Satisfaction();

    static int testMaxPolNum = 2000000000;
    static int testMinPolNum = testMaxPolNum - (testMaxPolNum * 2);

    public static void main(String[] args) {

    }

    public static double getRandomDoubleBetween(int min, int max) {
        double truncated;
        double generate = ((Math.random() * (max - min)) + min);
        if (generate >= 0) {
            truncated = Math.floor(generate * 100) / 100;
        } else {
            truncated = Math.ceil(generate * 100) / 100;
        }
        return truncated;

    }

    public static int getRandomIntBetween(int min, int max) {
        double generate = ((Math.random() * (max - min)) + min);
        return (int) generate;
    }

    public static int getRandomPolicyInt_Between(int min, int max) {
        double generate = ((Math.random() * (max - min)) + min);
        return (int) generate;
    }

    public static void testing(String[] args) {

        System.out.println(TestingClass.getRandomDoubleBetween(testMinPolNum, testMaxPolNum));
        System.out.println(TestingClass.getRandomIntBetween(testMinPolNum, testMaxPolNum));
    }

    private static void testOutcomePolicyInt() throws InvalidPolicyNumberException {
        int _genNum = getRandomIntBetween(testMinPolNum, testMaxPolNum);
        product.checkPolicyNumber(_genNum);
        System.out.println(_genNum);
    }

    private static void testChars() {
        char ch = 'l';
        String string = "Hello World";
        int testing = StringUtils.timesCharOccurs(ch, string);
        System.out.println(testing);

        String string2 = "abcdefghijklmnopqrstuvwxyz";
        String testing2 = StringUtils.frequencyReport(string);
        System.out.println(testing2);
    }
}
