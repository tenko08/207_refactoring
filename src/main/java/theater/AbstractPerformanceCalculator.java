package theater;

/**
 * Abstract base class for performance calculators.
 */
public abstract class AbstractPerformanceCalculator {

    private final Performance performance;
    private final Play play;

    /**
     * Constructor for AbstractPerformanceCalculator.
     * 
     * @param performance the performance
     * @param play        the play
     */
    public AbstractPerformanceCalculator(Performance performance, Play play) {
        this.performance = performance;
        this.play = play;
    }

    public Performance getPerformance() {
        return performance;
    }

    public Play getPlay() {
        return play;
    }

    /**
     * Factory method to create a performance calculator.
     * 
     * @param performance the performance
     * @param play        the play
     * @return the calculator
     */
    public static AbstractPerformanceCalculator createPerformanceCalculator(Performance performance, Play play) {
        switch (play.getType()) {
            case "tragedy":
                return new TragedyCalculator(performance, play);
            case "comedy":
                return new ComedyCalculator(performance, play);
            case "history":
                return new HistoryCalculator(performance, play);
            case "pastoral":
                return new PastoralCalculator(performance, play);
            default:
                throw new RuntimeException(String.format("unknown type: %s", play.getType()));
        }
    }

    /**
     * Calculates the amount for the performance.
     * 
     * @return the amount
     */
    public abstract int getAmount();

    /**
     * Calculates the volume credits for the performance.
     * 
     * @return the volume credits
     */
    public int getVolumeCredits() {
        return Math.max(performance.getAudience() - Constants.BASE_VOLUME_CREDIT_THRESHOLD, 0);
    }
}
