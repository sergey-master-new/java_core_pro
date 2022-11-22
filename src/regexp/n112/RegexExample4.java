package regexp.n112;

// Проверка IP: 0-255.0-255.0-255.0-255

import java.util.regex.Pattern;

public class RegexExample4 {

    void checkIP(String ip){

//        String regex = "((25[0-5]|2[0-4]\\d|[01]?\\d?\\d)(\\.)){3}" +
//                "(25[0-5]|2[0-4]\\d|[01]?\\d?\\d)";
//        System.out.println(ip + " is OK? " + Pattern.matches(regex, ip));

//        25[0-5]   |  2[0-4]\d  |     [01]?\d?\d)             (\.)
//        250-255   |  200-249   |        0-199             должна быть точка
//                                 [01]? - 0 или 1 может быть или не быть
//                                  d?   - цифра от 0 до 9 может быть или не быть
//                                  d    - цифра от 0 до 9

//        Более короткий вариант ^((25[0-5]|(2[0-4]|1\d|[1-9]|)\d)\.?\b){4}$
        String regex = "^((25[0-5]|(2[0-4]|1\\d|[1-9]|)\\d)\\.?\\b){4}$";
        System.out.println(ip + " is OK? " + Pattern.matches(regex, ip));
    }

    public static void main(String[] args) {

        String ip1 = "255.38.192.99";
        String ip2 = "182.262.91.05";
        String ip3 = "92.38.0.0";
        String ip4 = "1.1.1.1";

        RegexExample4 example4 = new RegexExample4();
        example4.checkIP(ip1);
        example4.checkIP(ip2);
        example4.checkIP(ip3);
        example4.checkIP(ip4);
    }
}
