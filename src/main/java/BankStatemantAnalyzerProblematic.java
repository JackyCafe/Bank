import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class BankStatemantAnalyzerProblematic {
    private static final String RESOURCES = "src/main/resources/";

    public static void main(String[] args) throws IOException {
        Path path = Paths.get(RESOURCES + "bank-data-simple.csv");
        List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
        double total = 0;
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        for (String line:lines)
        {
            final String column[] = line.split(",");
            final LocalDate date = LocalDate.parse(column[0],formatter);
            if (date.getMonth()== Month.JANUARY)
          {
                final double amount = Double.parseDouble(column[1]);
                total +=amount;
            }
        }
        System.out.println(total);
    }
}
