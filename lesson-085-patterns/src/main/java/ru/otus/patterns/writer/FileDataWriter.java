package ru.otus.patterns.writer;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileDataWriter implements DataWriter {

    @Override
    public void writeData(int number) {
        try {
            List<String> lines = new ArrayList<>();
            lines.add("result: " + number);
            Path file = Paths.get("output.txt");
            Files.write(file, lines, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
