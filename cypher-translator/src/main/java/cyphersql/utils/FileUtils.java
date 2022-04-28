package cyphersql.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileUtils {
    public static void trimLines(Path location, int start, int end) throws IOException {
        List<String> contents = Files.readAllLines(location);
        Files.write(location, contents.subList(start, contents.size() - end));
    }
}
