package stream;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {



    public static void main(String[] args) {

        Stream<String> onceModifiedStream =
                Stream.of("abcd", "bbcd", "cbcd").skip(2);


        System.out.println(onceModifiedStream.collect(Collectors.toList()));
    }

}
