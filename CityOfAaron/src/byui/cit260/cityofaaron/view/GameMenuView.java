
package byui.cit260.cityofaaron.view;

import byui.cit260.cityofaaron.model.CropData;
import byui.cit260.cityofaaron.model.Game;
import byui.cit260.cityofaaron.model.Player;
import java.io.Serializable;
import java.util.Scanner;

/**
 *
 * @author KStrobell, JChantry
 */
public class GameMenuView extends MenuView implements Serializable{
    //private String gameMenu; //text of the menu
    //private int max; //number of items in the menu
    //Scanner keyboard = new Scanner(System.in);  
    //Constructor
    private static CropData theCrops;
    
    public GameMenuView() {

        
       
  
        super( "\n" +
            "**********************************\n" +
            "*    CITY OF AARON: GAME MENU    *\n" +
            "**********************************\n" +
            " 1 - View the Map\n" +
            " 2 - View/Print a List\n" +
            " 3 - Move to a new location\n" +
            " 4 - Manage the Crops\n" +
            " 5 - Return to the Main Menu\n",
        5);



    }

    
 
    
    // The doAction method
    // Purpose: performs the selected action
    // Parameters: none
    // Returns: none
    // ===================================       
    @Override public void doAction(int option)
    {
        //CropData theCrops = new CropData();
        switch(option) {
            case 1: // display map of the game
                displayMap();
                break;
            case 2: // view or print a list
                viewprintList();
                break;
            case 3: // move to a new location
                moveLocation();
                break;
            case 4: // Manage the Crops
                manageCrops();
                break;
            case 5: // back to main menu
                break;
        }
 

    
    }
    // The displayMap method
    // Purpose: displays the goals of the game
    // Parameters: none
    // Returns: none
    // ===================================   
    public void displayMap()
    {
        System.out.println("\nGame Map was selected.");
    }
    // The viewprintList method
    // Purpose: view a List
    // Parameters: none
    // Returns: none
    // ===================================   
    public void viewprintList()
    {
        //System.out.println("\nView/Print List was selected.");
        ListMenuView listMenu = new ListMenuView(); //JChantry
        listMenu.displayMenu();                     //JChantry
    }
    // The moveLocation method
    // Purpose: moves to another location
    // Parameters: none
    // Returns: none
    // ===================================   
    public void moveLocation()
    {
        System.out.println("\nMove to another location was selected.");
    }
    // The manageCrops method
    // Purpose: manage a players crops
    // Parameters: none
    // Returns: none
    // Author: JChantry
    // ===================================   
    public void manageCrops()
    {
        System.out.println("\n-----------------------------------");
        //CropData theCrops = new CropData();
        //Player player = new Player();
        Game theGame = CityOfAaron.Main.getTheGame();
        String name = theGame.getThePlayer().getName();
        //System.out.println(name);
        
        int startPopulation = theGame.getCropData().getPopulation();
        //System.out.println(startPopulation);
        
        //CropView cropView = new CropView();
        //byui.cit260.cityofaaron.view.CropView.
        CropView cv = new CropView();
        cv.runCropsView();
        
        //if more than 50% people died, end game
        int population = theGame.getCropData().getPopulation();
        
        double loss = ((population*1.00) / startPopulation);
        loss = 1.00 - loss;
        if (loss > 0.5) {
            
            System.out.println("You have received a letter from the High Priest over"
                    + " the City of Aaron. \nIt reads: \n");
            System.out.println("Dear " + name + ",\n"
                    + "It has come to my attention that you have killed " + (loss * 100) + "% \n"
                    + "of your people. This is not pleasing to the Lord nor to me. \n"
                    + "For this purpose, I have released you as ruler of the City of Aaron \n"
                    + "effective immediately! \n\n"
                    + "Regards, \n"
                    + "  The High Priest Over The Land \n\n"
                    + "The Game is over. Goodbye...");
            System.exit(0);
        }
        //Incrament year by 1
        int year = theGame.getCropData().getYear();
        year = year + 1;
        CropData _theCropData = theGame.getCropData();
        _theCropData.setYear(year);
    }
    
}
