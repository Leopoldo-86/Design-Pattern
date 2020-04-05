import builder.Country;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MySQLWorldDAO implements CountryDAO {

    DataSource db = new DataSource();

    @Override
    public ArrayList<Country> getCountry() {

        ArrayList<Country> countries = new ArrayList<Country>();

    // It gets all countries og the country table
    String query = "SELECT * FROM country;";

    ResultSet rs = db.select(query);
    String code = "";
    String name = "";
    String continent = "";
    int surfaceArea = 0;
    String headOfState = "";
    Country c = null;

    try {

        /**
         * Looping through all column(Attributes) from the Table Country
         */
        while (rs.next()) {
            code = rs.getString(1);
            name = rs.getString(2);
            continent = rs.getString(3);
            surfaceArea = rs.getInt(4);
            headOfState = rs.getString(5);

            // Creating an instance of the country class
            c = new Country(code, name, continent, surfaceArea, headOfState);

            // Adding the instances of the country class into the array.
            countries.add(c);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return countries;

    }

    @Override
    public ArrayList<Country> findCountryByName(String name) {
    	
    	ArrayList<Country> countries = new ArrayList<Country>();

        // It gets all countries og the country table
        String query = "SELECT * FROM country WHERE name LIKE '%"+name+"%';";

        ResultSet rs = db.select(query);
        String code = "";
        String continent = "";
        int surfaceArea = 0;
        String headOfState = "";
        Country c = null;

        try {

            while (rs.next()) {
                code = rs.getString(1);
                name = rs.getString(2);
                continent = rs.getString(3);
                surfaceArea = rs.getInt(4);
                headOfState = rs.getString(5);

                // Creating an instance of the country class
                c = new Country(code, name, continent, surfaceArea, headOfState);

                // Adding the instances of the country class into the array.
                countries.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return countries;
    }

    /**
     * In this method the query won't find all countries we have iin the country table,
     * instead, the query will find  the country which is in the parameter "code".
     * @param code
     * @return
     */
    @Override
    public Country findCountryByCode(String code) {

        // call the database with a query
        String query = "SELECT * FROM country WHERE code = '" + code + "';";
        ResultSet rs = db.select(query);

        String name = "";
        String continent = "";
        int surfaceArea = 0;
        String headOfState = "";
        Country c = null;

        try {
            /**
             * If the ResultSet has some sort of data, get the populate the variables
             * and create a new instance of the country class
             * and return it if that is not true, return a null object. (It means that the CODE you're looking for doesn't exist in the database.
             */
            if (rs.next()) {
                name = rs.getString(2);
                continent = rs.getString(3);
                surfaceArea = rs.getInt(4);
                headOfState = rs.getString(5);

                // Creating an instance of the country class
                c = new Country(code, name, continent, surfaceArea, headOfState);

                // It returns the country found.
                return c;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * This method is getting an instance of the country class
     * and that instance is getting everything inside. It's getting (code, name, continent, surfaceArea and headOfState).
     * @param country
     * @return
     */
    @Override
    public boolean saveCountry(Country country) {
    	String code = country.getCode();
        String name = country.getName();
        String continent = country.getContinent();
        int surfaceArea = country.getSurfaceArea();
        String headOfState = country.getHeadOfState();

        String query = "INSERT INTO country (code, name, continent, surfaceArea, headOfState) VALUES ('"+code+"', '"+name+"', '"+continent+"', '"+surfaceArea+"', '"+headOfState+"');";

        return db.save(query);
    }
}
