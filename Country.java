package builder;

/**
 * @author Leopoldo Medeiros_2017288
 */

public class Country {

    private String code;
    private String name;
    private String continent;
    private int surfaceArea;
    private String headOfState;

    // Defining a constructor
    public Country(CountryBuilder builder) {
        this.code = builder.code;
        this.name = builder.name;
        this.continent = builder.continent;
        this.surfaceArea = builder.surfaceArea;
        this.headOfState = builder.headOfState;
    }

    public Country(String code, String name, String continent, int surfaceArea, String headOfState) {
    }

    public String getCode() {

        return code;
    }

    public String getName() {

        return name;
    }

    public String getContinent() {
        return continent;
    }

    public int getSurfaceArea() {
        return surfaceArea;
    }

    public String getHeadOfState() {
        return headOfState;
    }

    public static class CountryBuilder {

        private String code;
        private String name;
        private String continent;
        private int surfaceArea;
        private String headOfState;

        public CountryBuilder(String code, String name, String continent, int surfaceArea, String headOfState) {
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
            if (code.equals("Europe")) {
                return new Europe(this);
            }
            return null;
        }
    }
}