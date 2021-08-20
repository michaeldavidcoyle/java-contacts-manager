package contacts;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileIO {
    protected static String directory = "data";
    protected static String filename = "contacts.txt";
    protected static Path dataDirectory = Paths.get(directory);
    protected static Path contactsFile = Paths.get(directory, filename);

    public static Path getContactsFile() throws IOException {
        if (Files.notExists(dataDirectory)) {
            Files.createDirectories(dataDirectory);
        }

        if (Files.notExists(contactsFile)) {
            Files.createFile(contactsFile);
        }

        return contactsFile;
    }

    public static void main(String[] args) {
        try {
            getContactsFile();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

