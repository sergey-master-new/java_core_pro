package regexp.practice;

//Write a simple regex to validate a username. Allowed characters are:
//
//        lowercase letters,
//        numbers,
//        underscore
//        Length should be between 4 and 16 characters (both included).

public class SimpleName {

    public static boolean validateUsr(String s) {

        return s.matches("[a-z|\\d|_]{4, 16}");
    }
}
