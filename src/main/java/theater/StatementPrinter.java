package theater;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Map;

/**
 * This class generates a statement for a given invoice of performances.
 */
public class StatementPrinter {

    private final StatementData statementData;

    /**
     * Constructor for StatementPrinter.
     * 
     * @param invoice the invoice to print
     * @param plays   the map of plays
     */
    public StatementPrinter(Invoice invoice, Map<String, Play> plays) {
        this.statementData = new StatementData(invoice, plays);
    }

    /**
     * Returns a formatted statement of the invoice associated with this printer.
     * 
     * @return the formatted statement
     * @throws RuntimeException if one of the play types is not known
     */
    public String statement() {
        return renderPlainText(statementData);
    }

    private String renderPlainText(StatementData statementData) {
        StringBuilder result = new StringBuilder(
                "Statement for " + statementData.getCustomer() + System.lineSeparator());
        for (PerformanceData p : statementData.getPerformances()) {
            // print line for this order
            result.append(String.format("  %s: %s (%s seats)%n", p.getName(),
                    usd(p.getAmount()), p.getAudience()));
        }

        result.append(String.format("Amount owed is %s%n", usd(statementData.totalAmount())));
        result.append(String.format("You earned %s credits%n", statementData.volumeCredits()));
        return result.toString();
    }

    protected StatementData getStatementData() {
        return statementData;
    }

    protected String usd(int amount) {
        return NumberFormat.getCurrencyInstance(Locale.US).format(amount / Constants.PERCENT_FACTOR);
    }
}
