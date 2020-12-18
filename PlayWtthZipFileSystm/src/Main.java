import java.io.BufferedWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException, URISyntaxException {
        String[] data = {
                "Line 1",
                "Line 2 2",
                "Line 3 3 3",
                "Line 4 4 4 4",
                "Line 5 5 5 5 5"
        };
        try (FileSystem zipFs = openZip(Paths.get("myData1.zip"))) {
//            copyToZip(zipFs);
//            writeToFileZip1(zipFs, data);
                writeToFileZip2(zipFs, data);
        }
    }

    private static void writeToFileZip2(FileSystem zipFs, String[] data) throws IOException {
        Files.write(zipFs.getPath("/newFile2.txt"), Arrays.asList(data),
                Charset.defaultCharset(), StandardOpenOption.CREATE);
        //TODO: not able to write to file using Files.write method
    }

    private static void writeToFileZip1(FileSystem zipFs, String[] data) throws IOException {
        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(zipFs.getPath("newFiles1.txt"))) {
            for(String s: data){
                bufferedWriter.write(s);
                bufferedWriter.newLine();
            }
        }
    }

    private static FileSystem openZip(Path zipPath) throws URISyntaxException, IOException {
        Map<String, String> providerProps = new HashMap<>();
        providerProps.put("create", "true");

        URI zipURI = new URI("jar:file", zipPath.toUri().getPath(), null);
        FileSystem zipFs = FileSystems.newFileSystem(zipURI, providerProps);

        return zipFs;
    }

    public static void copyToZip(FileSystem zipFs) throws IOException {
        Path sourceFile = Paths.get("file1.txt");
        Path destinationFile = zipFs.getPath("/file1.txt");
        Files.copy(sourceFile, destinationFile,StandardCopyOption.REPLACE_EXISTING);
    }

}
