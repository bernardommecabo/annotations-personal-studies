package org.bernardomecabo.ProgrammingLogic;

public class StringBuildingExamples {
    public static void formatString(String str) {
        System.out.println("Inputted string: " + str);
        System.out.println("Lower Case: " + str.toLowerCase());
        System.out.println("Upper Case: " + str.toUpperCase());
        System.out.println("Without corner white spaces: " + str.trim());
        System.out.println("Substring: " + str.substring(8,str.length()));
    }

    public static void replaceString(String str, String replacement, String input) {
        System.out.println("Inputted string: " + str);
        System.out.println("Replacement string: " + replacement);
        System.out.println("Replacer string: " + input);
        System.out.println();
        System.out.println("Replaced String: \n" +
                str.replace(replacement, input));
    }

    public static void vectorizeString(String str) {
        String[] words = new String[0];
        words = str.split(" ");
        for (int i = 0; i < words.length; i++) {
            words[i] = words[i].toLowerCase();
            System.out.println(words[i]);
        }
    }
}
