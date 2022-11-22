package regexp.n108_109;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexExample1and2 {

    public static void main(String[] args) {

        System.out.println("- 1 -----------");
        //ABC
        String str = "ABCD ABCE ABCFABCGABCH";
        Pattern pattern1 = Pattern.compile("ABC");
        Matcher matcher = pattern1.matcher(str);
        while (matcher.find()){
            System.out.println("Position: " + matcher.start() + "  " + matcher.group());
        }

        System.out.println("- 2 -----------");
        // [ABC]
        String str2 = "OPABFKCNFD";
        Pattern pattern2 = Pattern.compile("[ABC]");
        Matcher matcher2 = pattern2.matcher(str2);
        while (matcher2.find()){
            System.out.println("Position: " + matcher2.start() + "  " + matcher2.group());
        }

        System.out.println("- 3 -----------");
        // [ABC]
        String str3 = "ABDOP";
        Pattern pattern3 = Pattern.compile("AB[C-F]OP");
        Matcher matcher3 = pattern3.matcher(str3);
        while (matcher3.find()){
            System.out.println("Position: " + matcher3.start() + "  " + matcher3.group());
        }

        System.out.println("- 4 -----------");
        // [ABC]
        String str4 = "AB7OPABDOP";
        Pattern pattern4 = Pattern.compile("AB[C-F]OP");
        Matcher matcher4 = pattern4.matcher(str4);
        while (matcher4.find()){
            System.out.println("Position: " + matcher4.start() + "  " + matcher4.group());
        }

        System.out.println("- 5 -----------");
        // [B-Fd-J3-8]
        String str5 = "abcd abce abc5abcg6abch";
        Pattern pattern5 = Pattern.compile("abc[e-g4-7]");
        Matcher matcher5 = pattern5.matcher(str5);
        while (matcher5.find()){
            System.out.println("Position: " + matcher5.start() + "  " + matcher5.group());
        }

        System.out.println("- 6 -----------");
        // [B-Fd-J3-8] со знаком ^
        String str6 = "abcd abce abc5abcg6abch";
        Pattern pattern6 = Pattern.compile("abc[^e-g4-7]");
        Matcher matcher6 = pattern6.matcher(str6);
        while (matcher6.find()){
            System.out.println("Position: " + matcher6.start() + "  " + matcher6.group());
        }

        System.out.println("- 7 -----------");
        // a|b со знаком ^
        String str7 = "abcd abce abc5abcg6abch";
        Pattern pattern7 = Pattern.compile("abc(5|e)");
        Matcher matcher7 = pattern7.matcher(str7);
        while (matcher7.find()){
            System.out.println("Position: " + matcher7.start() + "  " + matcher7.group());
        }

        System.out.println("- 8 -----------");
        // . - любой символ. Кроме символа новой строки
        String str8 = "abcd abce abc5abcg6abch";
        Pattern pattern8 = Pattern.compile("abc.");
        Matcher matcher8 = pattern8.matcher(str8);
        while (matcher8.find()){
            System.out.println("Position: " + matcher8.start() + "  " + matcher8.group());
        }

        System.out.println("- 9 -----------");
        // ^ выражение - соответствует выражению начала строки. Примечание - если не в  [..]
        String str9 = "abcd abce abc5abcg6abch";
        Pattern pattern9 = Pattern.compile("^abc");
        Matcher matcher9 = pattern9.matcher(str9);
        while (matcher9.find()){
            System.out.println("Position: " + matcher9.start() + "  " + matcher9.group());
        }

        System.out.println("- 10 -----------");
        // ^ выражение - соответствует выражению начала строки. Примечание - если не в  [..]
        String str10 = "abcd abce abc5abcg6abch";
        Pattern pattern10 = Pattern.compile("^5abc");
        Matcher matcher10 = pattern10.matcher(str10);
        while (matcher10.find()){
            System.out.println("Position: " + matcher10.start() + "  " + matcher10.group());
        }

        System.out.println("- 11 -----------");
        // $ выражение - соответствует выражению в конце строки
        String str11 = "abcd abce abc5abcg6abch";
        Pattern pattern11 = Pattern.compile("abc5abcg6abch$");
        Matcher matcher11 = pattern11.matcher(str11);
        while (matcher11.find()){
            System.out.println("Position: " + matcher11.start() + "  " + matcher11.group());
        }

        System.out.println("- 12 -----------");
        // \d - соответствует одной цифре. Тоже самое, что и [1-9]  d-digital-цифра
        String str12 = "abcd abce abc5abcg6abch";
        Pattern pattern12 = Pattern.compile("\\d"); //результат как при [1-9]
        Matcher matcher12 = pattern12.matcher(str12);
        while (matcher12.find()){
            System.out.println("Position: " + matcher12.start() + "  " + matcher12.group());
        }

        System.out.println("- 13 -----------");
        // \d - соответствует одной цифре. Тоже самое, что и [1-9]
        String str13 = "abcd abce abc5abcg6abch";
        Pattern pattern13 = Pattern.compile("\\D");
        Matcher matcher13 = pattern13.matcher(str13);
        while (matcher13.find()){
            System.out.println("Position: " + matcher13.start() + "  " + matcher13.group());
        }

        System.out.println("- 14 -----------");
        // \w - соответсвует букве, цифре или знаку андерскор "_". Но не пробелу. w-word-слово
        // То же самое, что [A-Za-z1-9_]
        String str14 = "abcd abce abc5abcg6abch";
        Pattern pattern14 = Pattern.compile("\\w");
        Matcher matcher14 = pattern14.matcher(str14);
        while (matcher14.find()){
            System.out.println("Position: " + matcher14.start() + "  " + matcher14.group());
        }

        System.out.println("- 15 -----------");
        // \W - соответсвует одному символу, который не буква, не цифра, не "_"
        // То же самое, что [^A-Za-z1-9_]
        String str15 = "abcd?!abce===abc ++5abcg6abch";
        Pattern pattern15 = Pattern.compile("\\W");
        Matcher matcher15 = pattern15.matcher(str15);
        while (matcher15.find()){
            System.out.println("Position: " + matcher15.start() + "  " + matcher15.group());
        }

        System.out.println("- 16 -----------");
        // + - одно или большее количество повторений
        String str16 = "abcd abce abc5abcg6abch";
        Pattern pattern16 = Pattern.compile("\\w+");
        Matcher matcher16 = pattern16.matcher(str16);
        while (matcher16.find()){
            System.out.println("Position: " + matcher16.start() + "  " + matcher16.group());
        }

        System.out.println("- 17 -----------");
        // + - одно или большее количество повторений
        String str17 = "abcd?!abce===abc+ ++5abcg6abch";
        Pattern pattern17 = Pattern.compile("\\W+");
        Matcher matcher17 = pattern17.matcher(str17);
        while (matcher17.find()){
            System.out.println("Position: " + matcher17.start() + "  " + matcher17.group());
        }

        System.out.println("- 18 -----------");
        // {n} - соотвтетствует количеству повторений n
        String str18 = "poka abc Roma dom kino abstrakcionizm";
        Pattern pattern18 = Pattern.compile("\\w{4}");
        Matcher matcher18 = pattern18.matcher(str18);
        while (matcher18.find()){
            System.out.println("Position: " + matcher18.start() + "  " + matcher18.group());
        }

        System.out.println("- 19 -----------");
        // \s - соответствует пробельному символу
        String str19 = "poka    abc Roma        dom kino abstrakcionizm";
        Pattern pattern19 = Pattern.compile("\\w\\s+\\w");
        Matcher matcher19 = pattern19.matcher(str19);
        while (matcher19.find()){
            System.out.println("Position: " + matcher19.start() + "  " + matcher19.group());
        }

        System.out.println();
        System.out.print("Текст который необходимо переписать.");//На экране отображается "Текст который необходимо переписать."
        System.out.print('\r');//На экране пусто
        System.out.println("Новый текст. После \\r");//На экране отображается "Новый текст."
        System.out.println();

        System.out.println("- 20 -----------");
        // \\D{2,6}
        String str20 = "abcd abce3 abc5abcg6a!!!!!!!!!!!!!!";
        Pattern pattern20 = Pattern.compile("\\D{2,6}");
        Matcher matcher20 = pattern20.matcher(str20);
        while (matcher20.find()){
            System.out.println("Position: " + matcher20.start() + "  " + matcher20.group());
        }

        System.out.println("- 21 -----------");
        // \\D{2,}
        String str21 = "abcd abce3 abc5abcg6a!!!!!!!!!!!!!!";
        Pattern pattern21 = Pattern.compile("\\D{2,}");
        Matcher matcher21 = pattern21.matcher(str21);
        while (matcher21.find()){
            System.out.println("Position: " + matcher21.start() + "  " + matcher21.group());
        }

        System.out.println("- 22 -----------");
        // AB{2,3}
        String str22 = "ABCABABDA";
        Pattern pattern22 = Pattern.compile("AB{2,3}");
        Matcher matcher22 = pattern22.matcher(str22);
        while (matcher22.find()){
            System.out.println("Position: " + matcher22.start() + "  " + matcher22.group());
        }

        System.out.println("- 23 -----------");
        // (AB){2,3}
        String str23 = "ABCABABDA";
        Pattern pattern23 = Pattern.compile("(AB){2,3}");
        Matcher matcher23 = pattern23.matcher(str23);
        while (matcher23.find()){
            System.out.println("Position: " + matcher23.start() + "  " + matcher23.group());
        }

        System.out.println("- 24 -----------");
        // CF(AB){2,}
        String str24 = "CFABCFABABABABABC";
        Pattern pattern24 = Pattern.compile("CF(AB){2,}");
        Matcher matcher24 = pattern24.matcher(str24);
        while (matcher24.find()){
            System.out.println("Position: " + matcher24.start() + "  " + matcher24.group());
        }

        System.out.println("- 25 -----------");
        // выражение? - соответствует 0 или 1 повторению.
        String str25 = "DABCDABABDA";
        Pattern pattern25 = Pattern.compile("D(AB)?");
        Matcher matcher25 = pattern25.matcher(str25);
        while (matcher25.find()){
            System.out.println("Position: " + matcher25.start() + "  " + matcher25.group());
        }

        System.out.println("- 26 -----------");
        // выражение? - соответствует 0 или 1 повторению.
        String str26 = "DABCDABABDA";
        Pattern pattern26 = Pattern.compile("D(AB)*");
        Matcher matcher26 = pattern26.matcher(str26);
        while (matcher26.find()){
            System.out.println("Position: " + matcher26.start() + "  " + matcher26.group());
        }
    }
}
