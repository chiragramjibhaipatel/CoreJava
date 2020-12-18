package read;

import java.io.IOException;

public class MyAutoCloseable implements AutoCloseable{
    public void myMessage(String message) throws IOException {
        System.out.println(message);
        throw new IOException("exception from myMessage");
    }

    @Override
    public void close() throws IOException {
        System.out.println("closed");
        throw new IOException("exception from Close");
    }
}
