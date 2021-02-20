package by.makarchuk.shape.reader;

import by.makarchuk.shape.exception.WrongInputParam;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReadFile {
    public List<String> read(String filePath) throws WrongInputParam {
        if (filePath == null) {
            throw new WrongInputParam("file path is null");
        }
        Path path = Paths.get(filePath);
        List<String> data;
        try (Stream<String> stringStream = Files.lines(path)) {
            data = stringStream.collect(Collectors.toList());
        } catch (IOException e) {
            throw new WrongInputParam("file " + filePath + " not found", e);
        }

        return data;
    }
}
