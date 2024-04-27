package DigitalArtifact_Refactored3_OOP;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {
    protected String tierSelected;

    public static Customer accessPolicyData(int policyNumber) {
        // Define file location and name convention of file to retrieve.
        String filePath = Directory.DIRECTORY_POLICY_DETAILS + File.separator + policyNumber + ".txt";
        // Initialise a new file object.
        File file = new File(filePath);

        // Try block allows Java to attempt a defined process which is expected to create an error, occasionally.
        try {
            // Initialise a new file reader object.
            FileReader fileReader = new FileReader(file);
            // Initialise a new buffer reader object.
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            // Parse expected data in file and assign to local variables.
            int policyNum = Integer.parseInt(bufferedReader.readLine());
            String firstName = bufferedReader.readLine();
            String surname = bufferedReader.readLine();
            String tierSelected = bufferedReader.readLine();

            // Close the buffered reader to commit read action.
            bufferedReader.close();
            // Assign local variables to the customer class, overriding previous details in object.
            return new Customer(policyNum, firstName, surname, tierSelected);
        }
        // Catch block elegantly handles errors created "thrown" by try block (Mullin 2024).
        // Runs same code for either IOException or NumberFormatException.
        catch (IOException | NumberFormatException e) {
            // When exception thrown, print message and return to managed process.
            System.err.println(e.getMessage());
            return null;
        }
    }
}
