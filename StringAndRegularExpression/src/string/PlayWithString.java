package string;

import java.util.StringJoiner;

public class PlayWithString {
    public static void main(String[] args) {
        StringJoiner joiner1 = new StringJoiner(", ");
        StringJoiner joiner2 = new StringJoiner("], [","[","]");
        joiner2.add("Apple");
        joiner2.add("Banana");
        StringJoiner joiner3 = new StringJoiner("], [","[","]");
        joiner3.setEmptyValue("EMPTY");
        System.out.println(joiner3.toString());

    }
}
