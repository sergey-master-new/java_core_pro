package regexp.n110;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexExample3 {

    public static void main(String[] args) {
        String str
                = "Ivanov Vasiliy, Russia, Moscow, Lenin street, 51, Flat 48," +
                " email: vivanov@mail.ru, Postcode: AA99, Phone Number: +123456798;"
                + "Petrova Marya, Ukraine, Kiyev, Lomonosov street, 33, Flat 18," +
                " email: masha@yandex.ru, Postcode: UKR54, Phone Number: +987654321;"
                + "Chuck Norris, USA, Hollywood, All stars street, 87, Flat 21," +
                " email: chuck@gmail.com, Postcode: USA23, Phone Number: +136478952.";

        List<Pattern> patterns = new ArrayList<>();

//        Pattern pattern = Pattern.compile("\\d{2}");
//        patterns.add(Pattern.compile("\\w+"));
        patterns.add(Pattern.compile("\\d{2}"));
        patterns.add(Pattern.compile("\\b\\d{2}\\b"));              //Задача: найти все номера домов и все номера квартир
        patterns.add(Pattern.compile("\\+\\d{9}"));                 //Задача: найти все номера телефонов
        patterns.add(Pattern.compile("\\w+@\\w+\\.(com|ru)"));      //Задача: найти все электронные адреса


        for (Pattern pattern : patterns) {

            System.out.println("Pattern:" + pattern);

            Matcher matcher = pattern.matcher(str);
            while (matcher.find()) {
                System.out.print(matcher.group() + "  ");
            }
            System.out.println();
            System.out.println();
        }

        System.out.println("- 1 -----------");
        // ^ выражение - соответствует выражению начала строки. Примечание - если не в  [..]
        String str1 = "abcd abce abc5abcg6abch";
        Pattern pattern1 = Pattern.compile("^\\w{3}");
        Matcher matcher1 = pattern1.matcher(str1);
        while (matcher1.find()){
            System.out.println("Position: " + matcher1.start() + "  " + matcher1.group());
        }

        System.out.println("- 2 -----------");
        // \A - соответствует выражению начала строки. Примечание: \\A\\w{3} тоже работает
        String str2 = "abcd abce abc5abcg6abch";
//        Pattern pattern2 = Pattern.compile("\\A\\w{3}");
        Pattern pattern2 = Pattern.compile("\\Aabc");
        Matcher matcher2 = pattern2.matcher(str2);
        while (matcher2.find()){
            System.out.println("Position: " + matcher2.start() + "  " + matcher2.group());
        }

        System.out.println("- 3 -----------");
        // \z - соответствует выражению в конце строки.
        String str3 = "abcd abce abc5abcg6abch";
        Pattern pattern3 = Pattern.compile("g6abch\\Z");
        Matcher matcher3 = pattern3.matcher(str3);
        while (matcher3.find()){
            System.out.println("Position: " + matcher3.start() + "  " + matcher3.group());
        }

        System.out.println("- 4 -----------");
        // [abcd][efgh3-7]
        String str4 = "abcd abcd4 abc5abcg6abch";
        Pattern pattern4 = Pattern.compile("[abcd][efgh3-7]");
        Matcher matcher4 = pattern4.matcher(str4);
        while (matcher4.find()){
            System.out.println("Position: " + matcher4.start() + "  " + matcher4.group());
        }
    }
}

