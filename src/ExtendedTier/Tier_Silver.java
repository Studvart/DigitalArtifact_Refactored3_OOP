package DigitalArtifact_Refactored3_OOP.ExtendedTier;

import DigitalArtifact_Refactored3_OOP.CoreDetails.Customer;

public class Tier_Silver extends Tier_Bronze {
    @Override
    public void accessRewards(Customer _customer) {
        super.accessRewards(_customer);
        super.accessRewardsBenefitOutput(benefitOption);
    }

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
