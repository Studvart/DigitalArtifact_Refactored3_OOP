package DigitalArtifact_Refactored3_OOP;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFile {
    public static void writeCustomerFile(Customer customer) {
        // Define file location and name convention of file to write.
        String filePath = customer.getPolicyNumber() + ".txt";
        // Initialise a new file object.
        File file = new File(Directory.DIRECTORY_POLICY_DETAILS, filePath);

        // If the intended directory isn't present, then create it.
        file.getParentFile().mkdir();

        // Try block allows Java to attempt a defined process which is expected to create an error, occasionally.
        try {
            // Initialise a new file writer object.
            FileWriter fileWriter = new FileWriter(file);
            // Initialise a new buffer writer object.
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            // Parse expected variables from customer object in the correct order to be written to file.
            bufferedWriter.write(customer.getPolicyNumber() + "\n");
            bufferedWriter.write(customer.getFirstName() + "\n");
            bufferedWriter.write(customer.getSurname() + "\n");
            bufferedWriter.write(customer.getTierSelected() + "\n");

            // Close the buffered writer to commit write action.
            bufferedWriter.close();
        }
        // Catch block elegantly handles errors created "thrown" by try block (Mullin 2024).
        catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

}
