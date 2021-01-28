import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class test {
    private static final String RESOURCES = "src/main/resources/";
    @Test
    public void Test() throws IOException {
        BankStatementCSVParser parser = new BankStatementCSVParser();
        final Path path = Paths.get(RESOURCES + "bank-data-simple.csv");
        final List<String> lines = Files.readAllLines(path);
        List<BankTransaction> transactions =  parser.parseLinesFromCSV(lines);
        System.out.println(transactions);
    }
}
