import java.util.Scanner;
import builder.Country;
/**
 * @author Leopoldo Medeiros_2017288
 */

public class Menu {

    /**
     * The main menu get information available in the database World
     * It gives the user the interaction with it
     */
    public Menu() {
        MySQLWorldDAO dao = new MySQLWorldDAO();
        int optionSelected;
        do {
        	Scanner sc = new Scanner(System.in);
            optionSelected = Menu();
            switch (optionSelected) {

                /**
                 * It displays all countries available in the DB World, Table Country
                 */
                case 1:
                    System.out.println("Option 1 is selected. Thank you.");

                    System.out.println(dao.getCountry());
                    new Menu();
                    break;

                /**
                 * Here you can find a country by code
                 */
                case 2:
                    System.out.println("Option 2 is selected. Thank you.");
                    System.out.print("Code: ");
                    String code = sc.nextLine();
                    System.out.println(dao.findCountryByCode(code));
                    new Menu();
                    break;

                /**
                 * Here you can add a new country with all attributes presented in the Table Country from DB.
                 */
                case 3:
                    System.out.println("Option 3 is selected. Thank you.");
                    System.out.print("Code: ");
                    code = sc.nextLine();
                    System.out.print("Name: ");
                    String name  = sc.next();
                    System.out.print("Continent: ");   
                    String continent = sc.next();
                    System.out.print("Surface Area: "); 
                    int  surfaceArea = sc.nextInt();
                    System.out.print("Head of State: "); 
                    String headOfState = sc.next();
                    Country c = new Country(code, name, continent, surfaceArea, headOfState);
                    if(dao.saveCountry(c)) {System.out.println("Country Added");};
                    new Menu();
                    break;

                /**
                 * Here you can find a country by name
                 */
                case 4:
                    System.out.println("Option 4 is selected. Thank you.");
                    System.out.print("Name: ");
                    String key = sc.nextLine();
                    System.out.println(dao.findCountryByName(key));
                    new Menu();
                    break;

                /**
                 * This option is to quit menu.
                 */
                case 5:
                    System.out.println("Option 5 is selected. Thank you.");
                    break;
            }
        } while (optionSelected > 5);

    }
    public static int Menu (){

            int selection;
            Scanner sc = new Scanner(System.in);
            System.out.println("Select your option:");
            System.out.println("--------------------\n");
            System.out.println("1. Display all Countries");
            System.out.println("2. Find a country by code");
            System.out.println("3. Save a new country to the list");
            System.out.println("4. Find a country by name");
            System.out.println("5. Quit");

            System.out.println("Your selected option is: ");
            selection = sc.nextInt();
            return selection;
        }
    }
