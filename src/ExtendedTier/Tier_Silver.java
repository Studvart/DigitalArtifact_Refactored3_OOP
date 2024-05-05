package DigitalArtifact_Refactored3_OOP.ExtendedTier;

import DigitalArtifact_Refactored3_OOP.CoreDetails.Customer;

// this should be
public class Tier_Silver extends Tier_Bronze {
    @Override
    public void accessRewards(Customer _customer) {
        super.accessRewards(_customer);
        super.accessRewardsBenefitOutput(benefitOption);
    }

    // On the advice of Jimmy - This method was made public for the purpose of testing. This should be protected.
    public String accessRewardsBenefitOutput(int _benefitOption) {
        switch (_benefitOption) {
            case 3:
                return ("""
                        Our Legal team will be in touch within 1 working day.
                        We will assign your case to a relevantly skilled team.
                        Please have as much documentation to hand to support the discussion.
                                                
                        """);
        }

        return null;
    }
}
