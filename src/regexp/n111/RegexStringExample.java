package regexp.n111;

import java.util.Arrays;

public class RegexStringExample {

    public static void main(String[] args) {
        String str
                = "Ivanov Vasiliy, Russia, Moscow, Lenin street, 51, Flat 48," +
                " email: vivanov@mail.ru, Postcode: AA99, Phone Number: +123456798;"
                + "Petrova Marya, Ukraine, Kiyev, Lomonosov street, 33, Flat 18," +
                " email: masha@yandex.ru, Postcode: UKR54, Phone Number: +987654321;"
                + "Chuck Norris, USA, Hollywood, All stars street, 87, Flat 21," +
                " email: chuck@gmail.com, Postcode: USA23, Phone Number: +136478952.";



        System.out.println("- 1 -----------");
        // Соответствие email - true
        String str1 = "chuck@gmail.com";
        boolean result1  = str1.matches("\\w+@\\w+\\.(ru|com)");
        System.out.println("Result1: " + result1);

        System.out.println("- 2 -----------");
        // Соответствие email - false
        String str2 = "chuck@gmail.com masha@yandex.ru";
        boolean result2  = str2.matches("\\w+@\\w+\\.(ru|com)");
        System.out.println("Result2: " + result2);

        System.out.println("- 3 -----------");
        String []array = str.split(" ");
        System.out.println("Result3: " + Arrays.toString(array));
    }
}
