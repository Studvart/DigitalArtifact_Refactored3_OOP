package DigitalArtifact_Refactored3_OOP.CoreDetails;

// Required packages to be present to run functions in this class.

import DigitalArtifact_Refactored3_OOP.Storage.WriteFile;

import java.util.Scanner;

public class Customer {
    // Required Class variable or Class creation variable
    Product product = new Product();
    Tier tier;
    Scanner scanner = new Scanner(System.in);
    // Need to be global to be accessed in repeatable functions
    private int policyNumber;
    private String firstName;
    private String surname;
    private String tierSelected;

    // Default Run - Create a non-existent customer
    public Customer() {
    }

    // Retrieve existing customer
    public Customer(int polNum, String fName, String lName, String TSelect) {
        policyNumber = polNum;
        firstName = fName;
        surname = lName;
        tierSelected = TSelect;
    }

    public Tier getTier() {
        return tier;
    }

    public int getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(int policyNumber) {
        this.policyNumber = policyNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getTierSelected() {
        return tierSelected;
    }

    public void setTierSelected(String tierSelected) {
        this.tierSelected = tierSelected;
    }

    public void createPolicyRecord() {
        // Process to capture new customer details
        System.out.println("Before we start, lets collect some data about you.");

        captureFirstname();
        captureSurname();
        captureTier();
        assignPolicyNumber();

        // Creates a customer object with user defined characteristics.
        WriteFile.writeCustomerFile(this);
        // Prints recorded details to console
        replaySuccessfulRecordDetails();
    }

    public void customerInformation() {
        // Prints Summary of read/keyed values.
        System.out.printf("""
                Policy Number: %s
                First Name: %s
                Surname: %s
                Tier: %s
                                
                """, policyNumber, firstName, surname, tierSelected);
    }

    private void captureFirstname() {
        System.out.println("What is your first name?");
        firstName = scanner.next();
    }

    private void captureSurname() {
        System.out.println("What is your surname?");
        surname = scanner.next();
    }

    private void captureTier() {
        tier = new Tier();
        tierSelected = tier.tierSelection();
        tier = tier.get_tier();
    }

    private void assignPolicyNumber() {
        //Force policy number between parameter defined numbers held in the appropriate Class for this model.
        while (!(policyNumber > product.getPolicyNumberMin() && policyNumber < product.getPolicyNumberMax())) {
            policyNumber = (int) ((Math.random() * (product.getPolicyNumberMax() - product.getPolicyNumberMin())) + product.getPolicyNumberMin());
        }
    }

    private void replaySuccessfulRecordDetails() {
        // Prints recorded details to console
        System.out.printf("""
                Policy has been created successfully.
                Associated to customer: %s %s.
                Your reference number is %d.
                You have selected tier: %s
                                
                """, firstName, surname, policyNumber, tierSelected);
    }

}