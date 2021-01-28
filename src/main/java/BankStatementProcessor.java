import java.time.Month;
import java.util.List;

public class BankStatementProcessor {
    private final List<BankTransaction> transactions ;
    public BankStatementProcessor(final List<BankTransaction> transactions){
        this.transactions = transactions;
    }

    public double calculateTotalAmount(){
        double total = 0;
        for (final BankTransaction transaction:transactions)
            total+=transaction.getAmount();
        return total;
    }

    public double calculateTotalInMonth(final Month month)
    {
        double total = 0;
        for (final BankTransaction bankTransaction:transactions)
        {
            if (bankTransaction.getDate().getMonth() == month)
            {
                total+=bankTransaction.getAmount();
            }
        }
        return total;
    }

    public double calculateTotalForCategory(final String category){
        double total = 0;
        for (final BankTransaction bankTransaction:transactions)
        {
            if (bankTransaction.getDescription().equals(category))
            {
                total+=bankTransaction.getAmount();
            }
        }
        return total;
    }
}
