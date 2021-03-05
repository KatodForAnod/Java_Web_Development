package by.makarchuk.infhandling.reader;

import by.makarchuk.infhandling.exception.WrongInputParam;
import org.apache.log4j.Logger;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReadFile {
    private static final Logger logger = Logger.getLogger(ReadFile.class);

    public List<String> read(String filePath) throws WrongInputParam {
        if (filePath == null) {
            logger.error("file path is null");
            throw new WrongInputParam("file path is null");
        }
        Path path = Paths.get(filePath);
        List<String> data;
        try (Stream<String> stringStream = Files.lines(path)) {
            data = stringStream.collect(Collectors.toList());
        } catch (IOException e) {
            logger.error("file " + filePath + " not found", e);
            throw new WrongInputParam("file " + filePath + " not found", e);
        }

        return data;
    }
}
