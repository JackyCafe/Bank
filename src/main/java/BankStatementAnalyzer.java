import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.List;

public class BankStatementAnalyzer {
    private static final String RESOURCES = "src/main/resources/";
    private static final BankStatementCSVParser bankStatementParser = new BankStatementCSVParser();

    public static void main(String[] args) throws IOException {
        final String filename = args[0];
        final Path path =Paths.get(RESOURCES+filename);
        final List<String> lines = Files.readAllLines(path);
        final List<BankTransaction> bankTransactions = bankStatementParser.parseLinesFromCSV(lines);
        final BankStatementProcessor processor = new BankStatementProcessor(bankTransactions);
        collectSummary(processor);
    }

    private static void collectSummary(BankStatementProcessor processor) {
        System.out.println(processor.calculateTotalAmount());
        System.out.println(processor.calculateTotalInMonth(Month.JANUARY));
        System.out.println(processor.calculateTotalInMonth(Month.FEBRUARY));
        System.out.println(processor.calculateTotalForCategory("Salary"));
    }
}
