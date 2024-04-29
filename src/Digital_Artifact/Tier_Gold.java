package DigitalArtifact_Refactored3_OOP.Digital_Artifact;

public class Tier_Gold extends Tier_Silver {
    @Override
    protected void accessRewards(Customer _customer) {
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
