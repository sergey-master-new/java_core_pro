package regexp.n113;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexExample6 {

    public static void main(String[] args) {

        String strCards = "12345678912345670325987;" +
                "98765432198765430926654;" +
                "85274196345612381124333;";
        // 16 цифр карта: 1234 5678 9123 4567 мес/год: 03/25 cvc: 987
        // Изменить на: 03/25 1234 5678 9123 4567 (987)

        Pattern pattern =
                Pattern.compile("(\\d{4})(\\d{4})(\\d{4})(\\d{4})(\\d{2})(\\d{2})(\\d{3})");
        Matcher matcher = pattern.matcher(strCards);

//        System.out.println("- matcher.group() -------------");
//        while (matcher.find()){
//            System.out.println(matcher.group());
//        }

        System.out.println("- matcher.group(7) -------------");
        while (matcher.find()){
            System.out.println(matcher.group(7));
        }

        System.out.println("- After replaceAll -------------");
        String newStrCards = matcher.replaceAll("$5/$6 $1 $2 $3 $4 ($7)");
        System.out.println("newStrCards: " + newStrCards);
    }
}
