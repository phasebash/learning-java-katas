import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileWordCounterAnswer {
    
    public Map<String, Long> countWords(String fileName) throws IOException {
        final Path path = FileSystems.getDefault().getPath(fileName);

        Map<String, Long> counts = Files.lines(path)
                                           .flatMap(line -> Stream.of(line.split("\\s+")))
                .collect(Collectors.groupingBy(value -> value, Collectors.counting()));

        return counts;
    }
    
}
