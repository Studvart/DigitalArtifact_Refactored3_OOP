package DigitalArtifact_Refactored3_OOP.CoreDetails;

import DigitalArtifact_Refactored3_OOP.Digital_Artifact_Run.InvalidPolicyNumberException;

public class Product {
    // Declared absolute values for range of possible policy numbers.
    private final int policyNumberMax = 999999;
    private final int policyNumberMin = 100000;

    public int getPolicyNumberMax() {
        return policyNumberMax;
    }

    public int getPolicyNumberMin() {
        return policyNumberMin;
    }

    // Provides more descriptive error handling message for unacceptable input values.
    public void checkPolicyNumber(int _inputPolicyNumber) throws InvalidPolicyNumberException {
        // Passes appropriate message depending on input value
        if (_inputPolicyNumber < getPolicyNumberMin())
            throw new InvalidPolicyNumberException("Policy number is invalid, minimum = 100,000", _inputPolicyNumber);
        else if (_inputPolicyNumber > getPolicyNumberMax())
            throw new InvalidPolicyNumberException("Policy number is invalid, maximum = 999,999", _inputPolicyNumber);
    }

}
