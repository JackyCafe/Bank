import java.time.format.DateTimeFormatter;
import java.util.List;

public class BankStatementParser implements IBankStatementParse{
    private static final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    @Override
    public BankTransaction parseFrom(String line) {
        return null;
    }

    @Override
    public List<BankTransaction> parseLinesFrom(List<String> lines) {
        return null;
    }
}
