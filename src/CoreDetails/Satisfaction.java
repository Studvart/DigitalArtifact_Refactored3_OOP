package DigitalArtifact_Refactored3_OOP.CoreDetails;

// Required packages to be present to run functions in this class.

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Satisfaction {
    // Declared absolute values
    private final int numberOfQuestions = 5;
    private final int maxScore = 5;
    private final int minScore = 1;
    // Required Class item
    Scanner scanner = new Scanner(System.in);

    // Declared Array to store responses
    int[] surveyArray = new int[numberOfQuestions];
    // Need to be global to be accessed in repeatable function
    int i;
    // May be returned in future functionality.
    double averageScore;

    public void satisfactionActivity() {
        // Declared Array to store responses
        int[] surveyArray = new int[numberOfQuestions];
        surveyArray = satisfactionSurvey();
        returnScores(surveyArray);
        calculateAverageScore(surveyArray);
    }

    private int[] satisfactionSurvey() {
        // Collect customer response into an array, for later use.
        int[] _surveyArray = new int[numberOfQuestions];
        String _hWYS = "How would you score:";

        // Explain how the collection works and set expectations.
        // Used global variable to ensure content is consistent and updated in relevant places.
        System.out.printf("""
                We would like to ask you a few satisfaction questions.
                Please provide a score of %d (low) to %d (high) for the next %d questions.
                                
                """, minScore, maxScore, numberOfQuestions);
        // for loop to ensure each question is asked and placed in the correct array position.
        for (i = 0; i < numberOfQuestions; i++) {
            //switch uses input from i
            switch (i) {
                case 0:
                    System.out.printf("""
                            %s
                            The ease of your journey?
                            """, _hWYS);
                    _surveyArray[i] = validateSurveyInput();
                    scanner.nextLine();
                    break;
                case 1:
                    System.out.printf("""
                            %s
                            The speed of your journey?
                            """, _hWYS);
                    _surveyArray[i] = validateSurveyInput();
                    scanner.nextLine();
                    break;
                case 2:
                    System.out.printf("""
                            %s
                            The clarity of the information presented?
                            """, _hWYS);
                    _surveyArray[i] = validateSurveyInput();
                    scanner.nextLine();
                    break;
                case 3:
                    System.out.printf("""
                            %s
                            The claims registration experience?
                            """, _hWYS);
                    _surveyArray[i] = validateSurveyInput();
                    scanner.nextLine();
                    break;
                case 4:
                    System.out.printf("""
                            %s
                            Your likelihood to recommend us?
                            """, _hWYS);
                    _surveyArray[i] = validateSurveyInput();
                    scanner.nextLine();
                    break;
            }
        }
        System.out.println("""
                Thank you for participating.
                """);
        return _surveyArray;
    }

    // On the advice of Jimmy - This method was made public for the purpose of testing. It should be private.
    // Created Method to reduce code repetition.
    public int validateSurveyInput() {
        int _inputValue = 0;

        // Declare a name for the following statement so that the break function, actions in the correct place.
        do {
            System.out.printf("Please score between %d and %d.\n", minScore, maxScore);
            try {
                _inputValue = scanner.nextInt();

                if (_inputValue >= minScore && _inputValue <= maxScore) {
                    break;
                }

                System.out.printf("%d is not a valid option.\n", _inputValue);

            } catch (InputMismatchException e) {
                System.err.println("Please enter a valid integer for your score.\n");
                scanner.nextLine();
            }

        } while (!(_inputValue >= minScore && _inputValue <= maxScore));
        return _inputValue;
    }

    // On the advice of Jimmy - This method was made public for the purpose of testing. It should be private.
    // Updated method to print scores for each question.
    public void returnScores(int[] _surveyArray) {
        System.out.println("You scored us:");
        // Using IntStream to iterate over the indices of the surveyArray
        IntStream.range(0, numberOfQuestions).forEach(j -> {
            // Switch statement to print score for each question
            switch (j) {
                case 0:
                    System.out.printf("""
                            Ease: %d
                            """, _surveyArray[j]);
                    break;
                case 1:
                    System.out.printf("""
                            Speed: %d
                            """, _surveyArray[j]);
                    break;
                case 2:
                    System.out.printf("""
                            Clarity: %d
                            """, _surveyArray[j]);
                    break;
                case 3:
                    System.out.printf("""
                            Claims: %d
                            """, _surveyArray[j]);
                    break;
                case 4:
                    System.out.printf("""
                            Recommendation: %d
                            """, _surveyArray[j]);
                    break;
            }
        });
    }

    private void calculateAverageScore(int[] _surveyArray) {
        // Calculate the average using Streams API rather than repeated addition and eventual divide.
        averageScore = IntStream.of(_surveyArray).average().orElse(0.0);
        System.out.printf("Average Score: %.2f\n", averageScore);
        // This is tested as part of testReturnScores()
    }
}

