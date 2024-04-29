package DigitalArtifact_Refactored3_OOP.ExtendedTier;

import DigitalArtifact_Refactored3_OOP.CoreDetails.Customer;

public class Tier_Gold extends Tier_Silver {
    @Override
    public void accessRewards(Customer _customer) {
        super.accessRewards(_customer);

        switch (benefitOption) {
            case 4:
                System.out.println("""
                        Our Team will be in contact within 1 hour.
                        Essential home care instructions have been emailed to you,
                        to help safeguard your home until we get in touch.
                        """);
                break;
        }
    }
}
