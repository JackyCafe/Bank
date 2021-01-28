import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class BankStatementCSVParser {
    final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    private BankTransaction parseFromCSV(final  String line){
        final  String[] columns = line.split(",");
        String description = columns[2];
        double amount = Double.parseDouble(columns[1]);
        LocalDate date = LocalDate.parse(columns[0],formatter);
        return new BankTransaction(date,amount,description);
    }

    public List<BankTransaction> parseLinesFromCSV(final List<String> lines){
        final List<BankTransaction> bankTransactions = new ArrayList<>();
        for (final String line:lines){
            bankTransactions.add(parseFromCSV(line));
        }
        return bankTransactions;
    }
}
