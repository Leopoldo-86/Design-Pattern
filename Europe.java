package builder;

/**
 * @author Leopoldo Medeiros_2017288
 */
public class Europe {

    private String code;
    private String name;
    private String continent;
    private int surfaceArea;
    private String headOfState;

    // Defining a constructor
    protected Europe(BuilderEurope builder) {
        this.code = builder.code;
        this.name = builder.name;
        this.continent = builder.continent;
        this.surfaceArea = builder.surfaceArea;
        this.headOfState = builder.headOfState;
    }

    public Europe(Country.CountryBuilder countryBuilder) {
    }

    @Override
    public String toString() {

        return "Continent: Europe, Code: " + getCode() + ", Name: " + getName();
    }

    public String getCode() {

        return code;
    }

    public String getName() {

        return name;
    }

    public static class BuilderEurope {

        private String code;
        private String name;
        private String continent;
        private int surfaceArea;
        private String headOfState;

        public BuilderEurope(String code, String name, String continent, int surfaceArea, String headOfState) {
            this.code = code;
            this.name = name;
            this.continent = continent;
            this.surfaceArea = surfaceArea;
            this.headOfState = headOfState;
        }

        public void setCode(String code) {

            this.code = code;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Europe build() {

            return new Europe(this);
        }
    }
}