package DigitalArtifact_Refactored3_OOP;

public class StringUtils {

    public char uppercase(char lower) {
        if (lower >= 'a' && lower <= 'z') return (char) (lower + 'A' - 'a');
        return lower;
    }

    public char lowercase(char upper) {
        if (upper >= 'A' && upper < 'Z') return (char) (upper - 'A' + 'a');
        return upper;
    }

    public String uppercase(String lower) {
        String upper = "";
        for (int i = 0; i < lower.length(); i++) {
            upper += uppercase(lower.charAt(i));
        }
        return upper;
    }

    public String lowercase(String upper) {
        String lower = "";
        for (int i = 1; i < upper.length(); i++) {
            lower += lowercase(upper.charAt(i));
        }
        return lower;
    }

    public String flipcase(String str) {
        String flipped = "";
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            char c2 = uppercase(c);
            if (c == c2) c2 = lowercase(c);
            flipped += c2;
        }
        return flipped;
    }
}

