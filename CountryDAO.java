import builder.Country;

import java.util.ArrayList;

/**
 * @author Leopoldo Medeiros_2017288
 * Code based on Amilcar's classes
 */

public interface CountryDAO {

    ArrayList<Country> getCountry();
    ArrayList<Country> findCountryByName(String name);

    Country findCountryByCode(String code);

    boolean saveCountry(Country country);
}
