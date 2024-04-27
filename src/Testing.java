package DigitalArtifact_Refactored3_OOP;

public class Testing {
    StringUtils stringUtils = new StringUtils();
    //testUppercaseChar();
    //testLowercaseChar();

    // uncomment for part 2

//    testUppercaseString();
//    testLowercaseString();

    public void testChar(char ch1, char ch2) {
        if (ch1 == ch2) {
            System.out.println("Test Passed");
        } else {
            System.out.println("Test Failed: " + ch1 + " " + ch2);
        }
    }

    private void testUppercaseChar() {
        testChar(stringUtils.uppercase('a'), 'A');
        testChar(stringUtils.uppercase('A'), 'A');
        testChar(stringUtils.uppercase('b'), 'B');
        testChar(stringUtils.uppercase('B'), 'B');
        testChar(stringUtils.uppercase('y'), 'Y');
        testChar(stringUtils.uppercase('Y'), 'Y');
        testChar(stringUtils.uppercase('z'), 'Z');
        testChar(stringUtils.uppercase('Z'), 'Z');
        testChar(stringUtils.uppercase('!'), '!');
        testChar(stringUtils.uppercase('1'), '1');
        testChar(stringUtils.uppercase('2'), '2');
        testChar(stringUtils.uppercase('@'), '@');
    }

    private void testLowercaseChar() {
        testChar(stringUtils.lowercase('a'), 'a');
        testChar(stringUtils.lowercase('A'), 'a');
        testChar(stringUtils.lowercase('b'), 'b');
        testChar(stringUtils.lowercase('B'), 'b');
        testChar(stringUtils.lowercase('y'), 'y');
        testChar(stringUtils.lowercase('Y'), 'y');
        testChar(stringUtils.lowercase('z'), 'z');
        testChar(stringUtils.lowercase('Z'), 'z');
        testChar(stringUtils.lowercase('!'), '!');
        testChar(stringUtils.lowercase('1'), '1');
        testChar(stringUtils.lowercase('2'), '2');
        testChar(stringUtils.lowercase('@'), '@');
    }

    public void testStr(String str1, String str2) {
        if (str1.equals(str2)) {
            System.out.println("Test Passed");
        } else {
            System.out.println("Test Failed: " + str1 + " " + str2);
        }
    }

    private void testUppercaseString() {
        testStr(stringUtils.uppercase(""), "");
        testStr(stringUtils.uppercase("a"), "A");
        testStr(stringUtils.uppercase("aA"), "AA");
        testStr(stringUtils.uppercase("Aa"), "AA");
        testStr(stringUtils.uppercase("AaA"), "AAA");
        testStr(stringUtils.uppercase("abcdefghijklmnopqrstuvwxyz"), "ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        testStr(stringUtils.uppercase("!"), "!");
        testStr(stringUtils.uppercase("A!"), "A!");
        testStr(stringUtils.uppercase("a!"), "A!");
        testStr(stringUtils.uppercase("!A"), "!A");
        testStr(stringUtils.uppercase("!a"), "!A");
        testStr(stringUtils.uppercase("a!a"), "A!A");
        testStr(stringUtils.uppercase("A!A"), "A!A");
        testStr(stringUtils.uppercase("!@£$%^&*()_+{}[];:,<.>/?"), "!@£$%^&*()_+{}[];:,<.>/?");
    }

    private void testLowercaseString() {
        // add your tests here
    }

}
