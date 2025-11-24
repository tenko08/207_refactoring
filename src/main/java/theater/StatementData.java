package theater;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StatementData {

    private final String customer;
    private final List<PerformanceData> performances;

    public StatementData(Invoice invoice, Map<String, Play> plays) {
        this.customer = invoice.getCustomer();
        this.performances = new ArrayList<>();
        for (Performance p : invoice.getPerformances()) {
            this.performances.add(createPerformanceData(p, plays.get(p.getPlayID())));
        }
    }

    private PerformanceData createPerformanceData(Performance performance, Play play) {
        AbstractPerformanceCalculator calculator = AbstractPerformanceCalculator
                .createPerformanceCalculator(performance, play);
        return new PerformanceData(performance, play, calculator.getAmount(), calculator.getVolumeCredits());
    }

    public String getCustomer() {
        return customer;
    }

    public List<PerformanceData> getPerformances() {
        return performances;
    }

    public int totalAmount() {
        int result = 0;
        for (PerformanceData perf : performances) {
            result += perf.getAmount();
        }
        return result;
    }

    public int volumeCredits() {
        int result = 0;
        for (PerformanceData perf : performances) {
            result += perf.getVolumeCredits();
        }
        return result;
    }
}
