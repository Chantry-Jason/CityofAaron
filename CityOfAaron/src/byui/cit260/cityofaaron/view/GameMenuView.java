/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.cityofaaron.view;

import java.io.Serializable;
import java.util.Scanner;

/**
 *
 * @author KStrobell
 */
public class GameMenuView extends MenuView implements Serializable{
    private String gameMenu; //text of the menu
    private int max; //number of items in the menu
    Scanner keyboard = new Scanner(System.in);  
    //Constructor
    public GameMenuView() {


    
  
        super( "\n" +
            "**********************************\n" +
            "* CITY OF AARON: GAME MENU  *\n" +
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
        System.out.println("\nView/Print List was selected.");
        ListMenuView listMenu = new ListMenuView();
        listMenu.displayMenu();
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
    // ===================================   
    public void manageCrops()
    {
        System.out.println("\nManage Crops was selected.");
        CropView cropView = new CropView();
        cropView.runCropsView();
    }
    
}
