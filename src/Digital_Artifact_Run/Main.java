package DigitalArtifact_Refactored3_OOP.Digital_Artifact_Run;

public class Main {
    public static void main(String[] args) {

        // RUN Programme and create a new manager object. // Object is held in session only.
        // Required Class variable
        Manager manager = new Manager();
        // Run programme from single location
        manager.processManager();
    }
    /*
    Checklist
    - Console output                       |    Yes
    - User input                           |    Yes
    - Selection (If, If-else, Switch)      |    Yes
    - Loops                                |    Yes
    - Methods                              |    Yes
    - Arrays                               |    Yes
    - Testing                              |    Yes - apparently not
    - Objects                              |    Yes

    Code Features:                         |
    - Additional Features                  |    Additional Feature Set 1's completed.
    - Feature set 2                        |    Yes
    - Feature set 1                        |    Yes
    - Arrays, Testing                      |    Yes
    - Loops, Methods                       |    Yes
    - Selection                            |    Yes
    - Basic user input                     |    Yes

    Code Style:                            |
    - Self-directed code management        |    Maybe? See use of:
                                                Tier Class: _lowestTier,_middleTier,_highestTier & tierSelection() tierMenu: for breaks (in other places too)
                                                Satisfaction Class: numberOfQuestions, maxScore, minScore
                                                Customer Class: customerRetrieveMenu() variables
    - Appropriate package structure        |    Not described: Yes - or close approximation.
    - Extensive comments                   |    Yes
    - Consistent indentation               |    Yes
    - Variables named appropriately        |    Yes

    Feature Set 1:
    Are at least 2 Implemented? -- Yes
    - A Data Object                        |    Yes - See Customer, Tier, Satisfaction and Product Class'
    - File Input                           |    Yes - See ReadFile Class
    - File Output                          |    Yes - See WriteFile Class
    - Custom Exceptions                    |    Yes - See InvalidPolicyNumberException
    - User friendly UI                     |    Yes - See try-catch in ReadFile and do-while in Customer and .toLowerCase() in process manager.

    Feature Set 2:
    Are at least 2 Implemented? -- Yes
    - Encapsulation                        |    Yes
    - Abstract Classes or Interfaces       |    No
    - Inheritance                          |    Yes
    - Streams API                          |    No
    - GUI                                  |    No
    - Software Architecture/Design Patterns|    No

     */
}
