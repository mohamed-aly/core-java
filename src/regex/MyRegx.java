package regex;

public class MyRegx {
    public static void main(String[] args) {
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
    }
}
