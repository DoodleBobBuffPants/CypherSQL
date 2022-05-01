package cyphersql.utils;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FileUtilsTest {
    private final Path file = Path.of("src", "test", "resources", "files", "sample_text");
    private List<String> oldContents = new ArrayList<>();

    @BeforeEach
    public void readOldContents() throws IOException {
        oldContents = Files.readAllLines(file);
    }

    @AfterEach
    public void restoreOldContents() throws IOException {
        Files.write(file, oldContents);
    }

    @Test
    public void trimsLines() throws IOException {
        FileUtils.trimLines(file, 2, 2);
        List<String> contents = Files.readAllLines(file);
        assertEquals(contents, Arrays.asList("3", "4", "5", "6", "7"));
    }
}
