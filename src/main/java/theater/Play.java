package theater;

/**
 * Class representing a play.
 */
public class Play {

    private String name;
    private String type;

    /**
     * Constructor for Play.
     * 
     * @param name the name of the play
     * @param type the type of the play
     */
    public Play(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }
}
