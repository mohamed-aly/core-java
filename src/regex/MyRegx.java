package regex;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyRegx {
    public static void main(String[] args) {
/*
        String string = "abcDeeekjh78ii665abcDeeef";

        //replace any letter with y
        System.out.println(string.replaceAll(".", "y"));

        //replace "abcDeee" at the beginning
        System.out.println(string.replaceAll("^abcDeee", "start "));

        //replace "abcDeee" at the end
        System.out.println(string.replaceAll("Deeef$", " end"));

        //replace any e or i
        System.out.println(string.replaceAll("[ei]", "?"));

        //any e ot i followed by k or f
        System.out.println(string.replaceAll("[ei][kf]", "?"));

        //replaces Harry or harry
        System.out.println("Harry".replaceAll("[Hh]arry", "Potter"));

        //replace all except e and j to x
        System.out.println(string.replaceAll("[^ej]", "x"));

        //replaces all letters from a to f and numbers from 3 to 9 to x
        System.out.println(string.replaceAll("[a-f3-9]", "x"));

        //replaces all letters from a to f and numbers from 3 to 9 to x ignoring case sensitivity
        System.out.println(string.replaceAll("(?i)[a-f3-9]", "x"));

        //replaces numbers to x
        System.out.println(string.replaceAll("\\d", "x"));

        //replaces all non-digits to x
        System.out.println(string.replaceAll("\\D", "x"));

        String hasWhiteSpaces = "I have blanks and \ta tab and also\n a new line$ 222";

        //replaces all spaces including tab and new lines to -
        System.out.println(hasWhiteSpaces.replaceAll("\\s","-"));

        //replaces tab to X
        System.out.println(hasWhiteSpaces.replaceAll("\t","X"));

        //replaces all non-space to X
        System.out.println(hasWhiteSpaces.replaceAll("\\S","X"));

        //replaces all except white spaces and special characters
        System.out.println(hasWhiteSpaces.replaceAll("\\w","X"));

        //replaces all except letters and numbers
        System.out.println(hasWhiteSpaces.replaceAll("\\W","X"));

        //surrounds avery set of letters or numbers with X
        System.out.println(hasWhiteSpaces.replaceAll("\\b","X"));

        //-----------------------------------------------------------------------------------------

        //Quantifiers Pattern and matchers
        String third = "abcdeeefffffffiiiiiiiiiiij";

        //e{3} means eee
        System.out.println(third.replaceAll("(?i)^abcDe{3}", "start "));

        //e{2,5} means between 2 and 5 e's
        System.out.println(third.replaceAll("(?i)^abcDe{2,5}", "start "));

        //e+ means one e or more
        System.out.println(third.replaceAll("(?i)^abcDe+", "start "));

        //e* means zero e or more
        System.out.println(third.replaceAll("(?i)^abcDe*", "start "));

        //e? means zero e or one
        System.out.println(third.replaceAll("(?i)^abcDe?", "start "));

        System.out.println(third.replaceAll("f+i*j", " end"));
*/

        StringBuilder builder = new StringBuilder("<h1>Heading</h1>");
        builder.append("<h2>Sun-heading</h2>");
        builder.append("<p>p1</p>");
        builder.append("<p>p2</p>");
        builder.append("<h2>summary</h2>");

        String h2Pattern = ".*<h[2-7]>.*</h[2-7]>.*";
        Pattern pattern = Pattern.compile(h2Pattern);
        Matcher matcher = pattern.matcher(builder.toString());
        System.out.println(matcher.matches());


    }
}
