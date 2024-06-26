package DigitalArtifact_Refactored3_OOP.Digital_Artifact_Run;

// Required packages to be present to run functions in this class.

import DigitalArtifact_Refactored3_OOP.CoreDetails.Customer;
import DigitalArtifact_Refactored3_OOP.CoreDetails.Product;
import DigitalArtifact_Refactored3_OOP.CoreDetails.Satisfaction;
import DigitalArtifact_Refactored3_OOP.CoreDetails.Tier;
import DigitalArtifact_Refactored3_OOP.Storage.ReadFile;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Manager {
    // Required Class variable
    Scanner scanner = new Scanner(System.in);
    Product product = new DigitalArtifact_Refactored3_OOP.CoreDetails.Product();
    Customer cust = new DigitalArtifact_Refactored3_OOP.CoreDetails.Customer();
    Tier tier = new DigitalArtifact_Refactored3_OOP.CoreDetails.Tier();
    Satisfaction satisfaction = new DigitalArtifact_Refactored3_OOP.CoreDetails.Satisfaction();

    public void processManager() {
        System.out.println("Hello and welcome to the programme.");

        // Collect basic details
        cust = customerRetrieveMenu();

        // Offer interaction with polymorphic options B/S/G
        tier.accessRewards(cust);

        // Customer satisfaction survey and results replay.
        satisfaction.satisfactionActivity();

        // Testing Completed -> see "Testing" folder in src
        // Includes 1 example of bug detected and demonstrated fix.

        // Close the scanner to free up resources.
        scanner.close();
        // End Process
        terminateProgramme();
    }

    // On the advice of Jimmy - This method was made public for the purpose of testing. It should be private.
    public Customer customerRetrieveMenu() {
        Customer c = null;
        // Declared reused values to change in all referenced places simultaneously.
        String openNewPolicy = "o";
        String viewExistingPolicy = "v";
        String exitProgramme = "e";
        String proceedBenefits = "p";
        String changePolicy = "c";

        while (true) {
            // while controls customer input to accepted menu inputs only.
            String option = "";
            // Declare a name for the following statement so that the break function, actions in the correct place.
            while (!(option.equals(openNewPolicy) || option.equals(viewExistingPolicy) || option.equals(exitProgramme))) {
                System.out.println("""
                        \nNavigate using the following character options:
                        Option (O): Open a new policy
                        Option (V): View an existing policy
                        Option (E): Exit the programme
                        """);
                /* .toLowerCase() ensures user input is reduced to lower case to ensure string is evaluated on the correct ANSI value.
                try catch ensures valid inputs only are accepted*/
                try {
                    option = scanner.nextLine().toLowerCase();
                } catch (InputMismatchException e) {
                    System.err.println("Please enter a valid character for your selection.\n");
                    scanner.nextLine();
                }

                // defined outcomes
                if (option.equals(openNewPolicy)) {
                    // Send to new policy creation in Customer.
                    c = createNewCustomer();
                    tier = c.getTier();
                    break;
                } else if (option.equals(viewExistingPolicy)) {
                    // Send to retrieve policy in Customer.
                    c = retreiveExistingCustomer();
                    break;
                } else if (option.equals(exitProgramme)) {
                    // End Programme
                    terminateProgramme();
                } else {// Not sure why this is never triggered.
                    System.out.printf("%s is not a valid selection.", option);
                }
            }

            // While controls customer input to accepted menu inputs only.
            String input = "";
            // Declare a name for the following statement so that the break function, actions in the correct place.
            while (!(input.equals(proceedBenefits) || input.equals(changePolicy) || input.equals(exitProgramme))) {
                System.out.printf("""
                        Would you like to:
                        Navigate using the following character options:
                        Option (%s): Proceed to the benefits of this policy
                        Option (%s): Change the policy you are reviewing
                        Option (%s): Exit the programme
                        """, proceedBenefits.toUpperCase(), changePolicy.toUpperCase(), exitProgramme.toUpperCase());
                input = scanner.nextLine().toLowerCase();

                // defined outcomes
                if (input.equals(exitProgramme)) {
                    terminateProgramme();
                } else if (input.equals(proceedBenefits)) {
                    return c;
                } else if (input.equals(changePolicy)) { // start this process again from the start.
                    break;
                }
                System.out.printf("""
                        %s is not a valid selection.
                                                
                        """, input);
            }
        }
    }

    // Repeatable class to terminate the programme when required.
    public void terminateProgramme() {
        // End Programme immediately.
        System.out.println("Thank you for interacting with SAG Bank Insurance Services Limited.");
        System.exit(1);
    }

    private Customer createNewCustomer() {
        // Instantiate and return customer record based on user input details. New customer journey.
        Customer customer = new Customer();
        customer.createPolicyRecord();
        return customer;
    }

    // On the advice of Jimmy - This method was made public for the purpose of testing. It should be private.
    public Customer retreiveExistingCustomer() {
        // Instantiate and return customer record based on retrieved details. Existing customer journey.
        Customer foundCustomer = null;
        int maxAttempts = 3;

        // For loop ensures customer doest proceed with invaild input. Ensures a defined number of attempts.
        for (int i = maxAttempts; i > 0; i--) {
            try {

                // Take Policy number from customer
                int policyNumber = capturePolicyNumber();
                // Product class contains a method to skip the following messages and provide additional context.
                product.checkPolicyNumber(policyNumber);

                // Returns the uploaded details as a customer object if found.
                foundCustomer = ReadFile.accessPolicyData(policyNumber);

                if ((foundCustomer != null)) {
                    // Retrieved value "tierSelected" is a String value and not a Tier object
                    // Interact with the customer record to get the tierSelected String
                    String _tierSelected = foundCustomer.getTierSelected();
                    // Pass to generic Tier class to instantiate the correct Tier object based on String value.
                    tier = tier.returnTierFromTierSelected(_tierSelected);
                    // Print retrieved values to console.
                    foundCustomer.customerInformation();
                    return foundCustomer;
                } else {
                    // If entered value is in the correct range but the equivalent file isn't located.
                    throw new InvalidPolicyNumberException("Account was not found", policyNumber);
                }

            } catch (InputMismatchException e) {
                System.err.println("Please enter a valid integer for the policy number.");
                scanner.nextLine();
            } catch (InvalidPolicyNumberException e) {
                System.err.println(e.getMessage());
            }
            // Iterates on each for loop and shows the remaining number of opportunities before the journey ends.
            System.out.printf("You have %d attempt(s) remaining.", (i - 1));
        }
        System.out.println("The programme will now exit");
        terminateProgramme();
        // Never expected to reach this return. Required for method validity.
        return foundCustomer;
    }

    // On the advice of Jimmy - This method was made public for the purpose of testing. It should be private.
    public int capturePolicyNumber() {
        System.out.println("Please enter the policy number to review:");
        int _policyNumber = scanner.nextInt();
        scanner.nextLine();
        return _policyNumber;
    }
}

