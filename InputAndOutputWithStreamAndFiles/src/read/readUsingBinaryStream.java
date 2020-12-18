package read;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class readUsingBinaryStream {
    public static void main(String[] args) {

        int length;
        char[] buffer = new char[10];
        try (Reader bufferedReader = getBufferedReader("file1.txt");
             Writer bufferedWriter = getBufferedWriter("file2.txt");
             MyAutoCloseable myAutoCloseable = new MyAutoCloseable();){
            while((length = bufferedReader.read(buffer))>0){
                for (int i = 0; i < length; i++) {
                    bufferedWriter.write(buffer[i]);
                }
                bufferedWriter.write('\n');
                myAutoCloseable.myMessage(String.valueOf(length));
            }
        } catch (IOException e) {
            e.printStackTrace();
            for(Throwable t: e.getSuppressed()){
                System.out.println(e.getMessage());
            }
        }
    }

    private static BufferedWriter getBufferedWriter(String file) throws IOException {
        return Files.newBufferedWriter(Paths.get(file));
    }

    private static BufferedReader getBufferedReader(String file) throws IOException {
        return Files.newBufferedReader(Paths.get(file));
    }
}
