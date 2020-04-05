/**
 * @author Leopoldo Medeiros_2017288
 */

public enum Continent {
    ASIA("Asia"),
    AFRICA("Africa"),
    NORTH_AMERICA("North America"),
    SOUTH_AMERICA("South America"),
    ANTARCTICA("Antarctica"),
    EUROPE("Europe"),
    OCEANIA("Oceania");

    private final String continent;

    Continent(String continent){
        this.continent = continent;
    }

    @Override
    public java.lang.String toString() {
        return this.name();
    }
}
