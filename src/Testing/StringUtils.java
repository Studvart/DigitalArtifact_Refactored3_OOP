package DigitalArtifact_Refactored3_OOP.Testing;

public class StringUtils {

    public static char uppercase(char lower) {
        if (lower >= 'a' && lower <= 'z')
            // a =  97, A = 65  (offset by 65-97)
            return (char) (lower - 32);
        return lower;
    }

    public static char lowercase(char upper) {
        if (upper >= 'A' && upper <= 'Z')
            return (char) (upper - 'A' + 'a');
        return upper;
    }

    public static char uppercase2(char lower) {
        switch (lower) {
            case 'a':
                return 'A';
            case 'b':
                return 'B';
            case 'c':
                return 'C';
            case 'd':
                return 'D';
            case 'e':
                return 'E';
            case 'f':
                return 'F';
            case 'g':
                return 'G';
            case 'h':
                return 'H';
            case 'i':
                return 'I';
            case 'j':
                return 'J';
            case 'k':
                return 'K';
            case 'l':
                return 'L';
            case 'm':
                return 'M';
            case 'n':
                return 'N';
            case 'o':
                return 'O';
            case 'p':
                return 'P';
            case 'q':
                return 'Q';
            case 'r':
                return 'R';
            case 's':
                return 'S';
            case 't':
                return 'T';
            case 'u':
                return 'U';
            case 'v':
                return 'V';
            case 'w':
                return 'W';
            case 'x':
                return 'X';
            case 'y':
                return 'Y';
            case 'z':
                return 'Z';
            default:
                return lower;
        }
    }

    public static String uppercase(String lower) {
        String upper = "";
        for (int i = 0; i < lower.length(); i++) {
            upper += uppercase(lower.charAt(i));
        }
        return upper;
    }

    public static String flipcase(String str) {
        String flipped = "";
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            char c2 = uppercase(c);
            if (c == c2)
                c2 = lowercase(c);
            flipped += c2;
        }
        return flipped;
    }

    public static int timesCharOccurs(char ch, String string) {
        //Returns an integer indicating how many times the character in the parameter ‘ch’ occurred in the string in the parameter ‘string’.
        int lengthOfString = string.length();
        int totalOccurances = 0;

        for (int i = 0; i < lengthOfString; i++) {
            char chToBeAssessed = string.charAt(i);
            char chToBeAssessedLowered = StringUtils.lowercase(chToBeAssessed);
            if (chToBeAssessedLowered == ch) {
                totalOccurances += 1;
            }
        }

        return totalOccurances;
    }

    public static String frequencyReport(String string) {
        // Prints to the console the number of times each letter ‘a-z’ occurs in the string
        // You should convert the string to lowercase as part of the method
        // You can use a for loop to go through every character in the string
        // return: The character a occurs 0 times

        int lengthOfString = string.length();

        for (int i = 0; i < lengthOfString; i++) {
            char chToBeAssessed = string.charAt(i);
            char chToBeAssessedLowered = StringUtils.lowercase(chToBeAssessed);
            int totalOccurances = StringUtils.timesCharOccurs(chToBeAssessedLowered, string);
            System.out.printf("The character %c occurs %d times\n", chToBeAssessed, totalOccurances);
        }
        System.out.println();

        return string;
    }

}
