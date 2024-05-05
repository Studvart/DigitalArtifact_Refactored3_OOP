package DigitalArtifact_Refactored3_OOP.ExtendedTier;

import DigitalArtifact_Refactored3_OOP.CoreDetails.Customer;

public class Tier_Gold extends Tier_Silver {
    @Override
    public void accessRewards(Customer _customer) {
        super.accessRewards(_customer);
        super.accessRewardsBenefitOutput(benefitOption);
    }

    // On the advice of Jimmy - This method was made public for the purpose of testing. This should be protected.
    public String accessRewardsBenefitOutput(int _benefitOption) {
        switch (_benefitOption) {
            case 4:
                return ("""
                        Our Team will be in contact within 1 hour.
                        Essential home care instructions have been emailed to you,
                        to help safeguard your home until we get in touch.
                                                
                        """);
        }
        return null;
    }
}
