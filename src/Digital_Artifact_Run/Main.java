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
    - Testing                              |    Yes
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
    - Self-directed code management        |    Yes See use of:
                                                Git Repository x2 @: https://github.com/Studvart/DigitalArtifact_Refactored3_OOP AND https://github.com/Studvart/Learning_MMU , Includes learning Markdown
                                                Tier Class: _lowestTier,_middleTier,_highestTier & tierSelection() tierMenu: for breaks (in other places too)
                                                Satisfaction Class: numberOfQuestions, maxScore, minScore
                                                Customer Class: customerRetrieveMenu() variables
    - Appropriate package structure        |    Yes
    - Extensive comments                   |    Yes
    - Consistent indentation               |    Yes
    - Variables named appropriately        |    Yes

    Feature Set 1:
    Are at least 2 Implemented? -- Yes
    - A Data Object                        |    Yes - See Customer, Tier, Satisfaction and Product Class'
    - File Input                           |    Yes - See ReadFile Class
    - File Output                          |    Yes - See WriteFile Class
    - Custom Exceptions                    |    Yes - See InvalidPolicyNumberException
    - User friendly UI                     |    Yes - See try-catch in ReadFile, do-while in Customer, .toLowerCase() in process manager,
                                                checkPolicyNumber() in Product and the Testing Package where ConsoleColours are used in testing outputs.

    Feature Set 2:
    Are at least 2 Implemented? -- Yes
    - Encapsulation                        |    Yes - except for classes made public for testing - each noted.
    - Abstract Classes or Interfaces       |    No
    - Inheritance                          |    Yes - CoreDetails package = Tier and ExtendedTier package.
    - Streams API                          |    Yes - See Satisfaction.returnScores() and Satisfaction.calculateAverageScore()
    - GUI                                  |    No
    - Software Architecture/Design Patterns|    Maybe - Please consider the Tier class: using _lowestTier _middleTier _highestTier and Product class: for policyNumberMax policyNumberMin to reduce risk to future changes from needing to redefine set value throughout.
                                                Please also consider the Satisfaction Class, In my opinion, it adheres to SOLID and KISS.

     */
}
