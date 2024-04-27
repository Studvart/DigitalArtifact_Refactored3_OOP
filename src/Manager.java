package DigitalArtifact_Refactored3_OOP;

// Required packages to be present to run functions in this class.
import java.util.InputMismatchException;
import java.util.Scanner;

public class Manager {
    // Required Class variable
    Scanner scanner = new Scanner(System.in);
    Product product = new Product();
    Customer cust = new Customer();
    Tier tier = new Tier();
    Satisfaction satisfaction = new Satisfaction();

    public void processManager() {
        System.out.println("Hello and welcome to the programme.");

        // Collect basic details
        cust = customerRetrieveMenu();

        // Offer interaction with polymorphic options B/S/G
        tier.accessRewards(cust);

        // Customer satisfaction survey
        satisfaction.satisfactionSurvey();
        satisfaction.returnScores();

        // Testing Completed -> see "Testing" folder in src
        // Includes 1 example of bug detected and demonstrated fix.

        // Close the scanner to free up resources.
        scanner.close();
        // End Process
        terminateProgramme();
    }

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
            customerMenu:
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

                    // defined outcomes
                    if (option.equals(openNewPolicy)) {
                        // Send to new policy creation in Customer.
                        c = createNewCustomer();
                        tier = c.getTier();
                        break customerMenu;
                    } else if (option.equals(viewExistingPolicy)) {
                        // Send to retrieve policy  in Customer.
                        c = retreiveExistingCustomer();
                        break customerMenu;
                    } else if (option.equals(exitProgramme)) {
                        // End Programme
                        terminateProgramme();
                    } else {// Not sure why this is never triggered.
                        System.out.printf("%s is not a valid selection.", option);
                    }
                } catch (InputMismatchException e) {
                    System.err.println("Please enter a valid integer for your selection.\n");
                    scanner.nextLine();
                }
            }

            // While controls customer input to accepted menu inputs only.
            String input = "";
            // Declare a name for the following statement so that the break function, actions in the correct place.
            benefitConsole:
            while (!(input.equals(proceedBenefits) || input.equals(changePolicy) || input.equals(exitProgramme))) {
                System.out.println("""
                        Would you like to:
                        Navigate using the following character options:
                        Option (P): Proceed to the benefits of this policy
                        Option (C): Change the policy you are reviewing
                        Option (E): Exit the programme
                        """);
                input = scanner.nextLine().toLowerCase();

                // defined outcomes
                if (input.equals(exitProgramme)) {
                    terminateProgramme();
                } else if (input.equals(proceedBenefits)) {
                    return c;
                } else if (input.equals(changePolicy)) { // start this process again from the start.
                    break benefitConsole;
                }
            }
        }
    }

    // Repeatable class to terminate the programme when required.
    private void terminateProgramme() {
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

    private Customer retreiveExistingCustomer() {
        // Instantiate and return customer record based on retrieved details. Existing customer journey.
        Customer foundCustomer = null;
        Tier t = null;

        // for loop ensures customer doest proceed with invaild input. Ensures a defined number of attempts.
        for (int i = 3; i > 0; i--) {
            try {
                System.out.println("Please enter the policy number to review:");
                int policyNumber = scanner.nextInt();
                scanner.nextLine();

                // Product class contains a method to skip the following messages and provide additional context.
                product.checkPolicyNumber(policyNumber);

                // Returns the uploaded details as a customer object.
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
                    // If entered value is in the correct range but equivalent file isn't located.
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
}

