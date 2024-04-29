package DigitalArtifact_Refactored3_OOP.Digital_Artifact;

// Required packages to be present to run functions in this class.
import java.util.InputMismatchException;
import java.util.Scanner;

public class Tier {
    // Declared absolute values
    private final String _lowestTier = "Bronze";
    private final String _middleTier = "Silver";
    private final String _highestTier = "Gold";
    // Needs to be global for inheritance.
    protected int benefitOption;
    // Required Class variable
    Scanner scanner = new Scanner(System.in);
    Tier _tier;
    // Need to be global to be accessed in repeatable function
    private String _tierSelected;

    // Default Run - Create a non-existent customer
    public Tier() {
    }

    //Provides access to private variable outside of Class
    public Tier get_tier() {
        return _tier;
    }

    protected String tierSelection() {
        System.out.println("Here are our tiered options:");
        printBenefits();
        _tierSelected = null;

        // Do loop works as a constraint to limit acceptable values.
        int _option = 0;
        // Declare a name for the following statement so that the break function, actions in the correct place.
        tierMenu:
        do {
            System.out.printf("""
                    Which tier would you like?
                    1. %s, 2. %s, 3. %s
                    Input the corresponding integer.
                    """, _lowestTier, _middleTier, _highestTier);
            try {
                _option = scanner.nextInt();
                // Inverted if following testing to enable a message to display for failed values.
                if ((_option > 0 && _option < 4)) {
                    break tierMenu;
                }
                System.out.printf("""
                        %d is not a valid input.
                        Please select a valid integer from on screen.
                        """, _option);
                _option = 0;
            } catch (InputMismatchException e) {
                System.err.println("Please enter a valid integer for your selection.\n");
                scanner.nextLine();
                _option = 0;
            }
        } while ((_option == 0));

        /* Switch to optimise subsequent if, else if...., else statement.
        Initialises the correct Tier from selection, sets Tier and tierSelected globally and returns String tierSelected*/
        switch (_option) {
            case 1:
                _tier = new Tier_Bronze();
                _tierSelected = _lowestTier;
                return _tierSelected;
            case 2:
                _tier = new Tier_Silver();
                _tierSelected = _middleTier;
                return _tierSelected;
            case 3:
                _tier = new Tier_Gold();
                _tierSelected = _highestTier;
                return _tierSelected;
        }
        // This result is not expected to ever be reached. But return required to make statement valid.
        return _tierSelected;
    }

    //Product benefits as 4 statements.
    protected void tierBenefits() {
        // Summary of core benefits.
        System.out.println("""
                All policies cover:
                Buildings for: fire, flood and storm damage
                Contents for : the same as buildings + theft and freezer food losses.
                ----------------------------------------------------------------------
                """);
    }

    protected void tierBenefitsBronze() {
        // Summary of benefits for Bronze_Tier
        System.out.printf("""
                %s provides:
                No additional benefits
                ---------------------------------------
                """, _lowestTier);
    }

    protected void tierBenefitsSilver() {
        // Summary of benefits for Sliver_Tier
        System.out.printf("""
                %s provides:
                %s benefits and
                Legal Expenses up to £50k.
                ---------------------------------------
                """, _middleTier, _lowestTier);
    }

    protected void tierBenefitsGold() {
        // Summary of benefits for Gold_Tier
        System.out.printf("""
                %s provides:
                %s + %s benefits and
                Home Emergencies up to £1k per claim.
                ---------------------------------------
                """, _highestTier, _lowestTier, _middleTier);
    }

    protected void printBenefits() {
        // Singular statement to collate all benefits in one call.
        tierBenefits();
        tierBenefitsBronze();
        tierBenefitsSilver();
        tierBenefitsGold();
    }

    protected void accessRewards(Customer customer) {
        // Call to process which begins inheritance journey.
        // Declare a name for the following statement so that the break function, actions in the correct place.
        accessMenu:
        do {
            System.out.println("""
                    Which benefit would you like to access?
                    Navigate using the following integer options:
                    Option (1): Make a buildings claim
                    Option (2): Make a contents claim
                    """);
            // Offer additional options dependent on tierSelected. 2x if as both may be required.
            if (customer.getTierSelected().equals(_middleTier) || customer.getTierSelected().equals(_highestTier)) {
                System.out.println("Option (3): Make a Legal claim");
                if (customer.getTierSelected().equals(_highestTier)) {
                    System.out.println("Option (4): Make a Home Emergency claim");
                }
            }
            try {
                benefitOption = scanner.nextInt();
                scanner.nextLine();
                if (benefitOption > 0 && benefitOption <= availableBenefitOptions(customer)) {
                    break accessMenu;
                }
                System.out.printf("%d is not a valid option, please select an option from the menu.\n", benefitOption);
            } catch (InputMismatchException e) {
                System.err.println("Please enter a valid integer for your selection.\n");
                scanner.nextLine();
            }

        } while (!(benefitOption > 0 && benefitOption <= availableBenefitOptions(customer)));

        // Functionality extended by inherited classes.
        switch (benefitOption) {
            case 1:
                System.out.println("""
                        We are sorry to hear your property is damaged.
                        We have forwarded a link via email.
                        Please start uploading evidence and adding detail to help us handle your claim.
                        """);
                break;
            case 2:
                System.out.println("""
                        We are sorry to hear your possessions have been lost.
                        We have forwarded a link via email.
                        Please start uploading any evidence or police reports to help us handle your claim.
                        """);
                break;
        }
    }

    private int availableBenefitOptions(Customer customer) {
        /* Passes the Customer object to retrieve the applicable Sting for tierSelected and compare to options avialble.
        Returns int to constrain the int selections applicable to menu based on Tier*/
        int minOptions = 2; // Minimum options available to all customers.
        int optionsAvailable = minOptions; // Whilst this appears redundant, seemed prudent to ensure min options available

        if (customer.getTierSelected().equals(_lowestTier)) {
            optionsAvailable = 2;
        } else if (customer.getTierSelected().equals(_middleTier)) {
            optionsAvailable = 3;
        } else if (customer.getTierSelected().equals(_highestTier)) {
            optionsAvailable = 4;
        }
        return optionsAvailable;
    }

    public Tier returnTierFromTierSelected(String _inputTierSelected) {
        /* ReadFile returns a String tierSelected.
        This method gets passed tierSelected and initialises the relevant Tier. */
        switch (_inputTierSelected) {
            case _lowestTier -> {
                _tierSelected = _lowestTier;
                _tier = new Tier_Bronze();
                _tierSelected = _lowestTier;
            }
            case _middleTier -> {
                _tierSelected = _middleTier;
                _tier = new Tier_Silver();
                _tier._tierSelected = _middleTier;
            }
            case _highestTier -> {
                _tierSelected = _highestTier;
                _tier = new Tier_Gold();
                _tier._tierSelected = _highestTier;
            }
        }
        return _tier;
    }
}


