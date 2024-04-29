package DigitalArtifact_Refactored3_OOP.Digital_Artifact_Run;

// Extends from typical extension class and adds additional functionality specific to this programme.
public class InvalidPolicyNumberException extends Exception {
    // New method which takes 2 arguments from external class to add functionality.
    public InvalidPolicyNumberException(String inputMessage, int keyedValue) {
        //
        super("Invalid Policy Number: " + inputMessage + " : Keyed value: " + keyedValue);
    }
}