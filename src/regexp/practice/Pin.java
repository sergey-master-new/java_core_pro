package regexp.practice;


//ATM machines allow 4 or 6 digit PIN codes and PIN codes cannot contain anything but exactly 4 digits or exactly 6 digits.
//If the function is passed a valid PIN string, return true, else return false.
//        Examples (Input --> Output)
//        "1234"   -->  true
//        "12345"  -->  false
//        "a234"   -->  false

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Pin {

    public static boolean validatePin(String pin) {

        Pattern pattern = Pattern.compile("\\d{4}|\\d{6}");
        Matcher matcher = pattern.matcher(pin);

        return matcher.matches();

//        Pattern pattern = Pattern.compile("^([0-9]{4}|[0-9]{6})$");
//        Matcher match = pattern.matcher(pin);
//        if (match.matches()) return true;
//        else return false;

//        Решение с методом String будет работать медленнее.
//        return pin.matches("[0-9]{4}|[0-9]{6}");
    }
}


class PinTest {

    public static void main(String[] args) {

        validPins();
        nonDigitCharacters();
        invalidLengths();
    }

    public static void validPins() {
        if (Pin.validatePin("1234")) {
            System.out.println("successful");
        } else {
            System.out.println("error");
        }

        if (Pin.validatePin("000000")) {
            System.out.println("successful");
        } else {
            System.out.println("error");
        }

//            assertEquals(true, Solution.validatePin("1234"));
//            assertEquals(true, Solution.validatePin("0000"));
//            assertEquals(true, Solution.validatePin("1111"));
//            assertEquals(true, Solution.validatePin("123456"));
//            assertEquals(true, Solution.validatePin("098765"));
//            assertEquals(true, Solution.validatePin("000000"));
//            assertEquals(true, Solution.validatePin("090909"));
    }


    public static void nonDigitCharacters() {

        if (!Pin.validatePin("a234")) {
            System.out.println("successful");
        } else {
            System.out.println("error");
        }

        if (!Pin.validatePin(".234")) {
            System.out.println("successful");
        } else {
            System.out.println("error");
        }

        if (!Pin.validatePin("a1234f")) {
            System.out.println("successful");
        } else {
            System.out.println("error");
        }
//            assertEquals(false, Solution.validatePin("a234"));
//            assertEquals(false, Solution.validatePin(".234"));
    }


    public static void invalidLengths() {

        if (!Pin.validatePin("12")) {
            System.out.println("successful");
        } else {
            System.out.println("error");
        }
        if (!Pin.validatePin("1234567")) {
            System.out.println("successful");
        } else {
            System.out.println("error");
        }

        if (!Pin.validatePin("-1234")) {
            System.out.println("successful");
        } else {
            System.out.println("error");
        }
//            assertEquals(false, Solution.validatePin("1"));
//            assertEquals(false, Solution.validatePin("12"));
//            assertEquals(false, Solution.validatePin("123"));
//            assertEquals(false, Solution.validatePin("12345"));
//            assertEquals(false, Solution.validatePin("1234567"));
//            assertEquals(false, Solution.validatePin("-1234"));
//            assertEquals(false, Solution.validatePin("1.234"));
//            assertEquals(false, Solution.validatePin("00000000"));
    }
}
