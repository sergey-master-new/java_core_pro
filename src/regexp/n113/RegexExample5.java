package regexp.n113;

public class RegexExample5 {

    public static void main(String[] args) {

        String str = "Privet,    moy drug! Kak idet izuchenie    Java?";
        System.out.println("str: " + str);

        //Замена Java на SQL
        System.out.println("- 1 ------------");
        String str1 = str.replace("Java", "SQL");
        System.out.println("str1: " + str1);

        //Замена пробелов на 1 пробел
        System.out.println("- 2 ------------");
        String str2 = str.replaceAll(" {2,}", " ");
        System.out.println("str2: " + str2);

        //Слова, начинающееся с i заменить на 4444, \\b - граница слова
        System.out.println("- 3 ------------");
        String str3 = str.replaceAll("\\bi\\w+", "4444");
        System.out.println("str3: " + str3);

        //Превое слово, начинающееся с i заменить на 4444, \\b - граница слова
        System.out.println("- 4 ------------");
        String str4 = str.replaceFirst("\\bi\\w+", "4444");
        System.out.println("str4: " + str4);

    }
}
