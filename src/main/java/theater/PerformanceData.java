package theater;

/**
 * Data class for performance information.
 */
public class PerformanceData {

    private final String name;
    private final int audience;
    private final String type;
    private final int amount;
    private final int volumeCredits;

    public PerformanceData(Performance performance, Play play, int amount, int volumeCredits) {
        this.name = play.getName();
        this.audience = performance.getAudience();
        this.type = play.getType();
        this.amount = amount;
        this.volumeCredits = volumeCredits;
    }

    public String getName() {
        return name;
    }

    public int getAudience() {
        return audience;
    }

    public String getType() {
        return type;
    }

    public int getAmount() {
        return amount;
    }

    public int getVolumeCredits() {
        return volumeCredits;
    }
}
