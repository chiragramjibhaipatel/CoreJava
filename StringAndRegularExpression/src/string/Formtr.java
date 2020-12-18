package string;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.Format;
import java.util.Formatter;

public class Formtr {
    public static void main(String[] args) throws IOException {
        extracted();
        useFormatterClass();
    }

    private static void useFormatterClass() throws IOException {
        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(Paths.get("file1.txt"))) {
            try (Formatter formatter = new Formatter(bufferedWriter)) {
                formatter.format("Hello %s","Chirag");
                formatter.format("\n");
                formatter.format("Hello %s","Rahul");
            }

        }
    }

    private static void extracted() {
        System.out.printf("%-15s %015d%n","Decimal", 30);
        System.out.printf("%-15s %#015o%n","Octal", 30);
        System.out.printf("%-15s %#015x%n","HexDecimal", 30);
        System.out.printf("%-15s %0#15X%n","HexDecimal", 30);
        System.out.printf("%-15s %015.2f%n","Floating", 30.0);
        System.out.printf("%2$-15s %<-15s %1$015.2e%n", 31345.0, "Exp");
        System.out.printf("%-15s %015.2E%n","Exp", 31345.0);
    }
}
