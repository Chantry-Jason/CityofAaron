/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.cityofaaron.view;

import java.util.Scanner;
import java.io.Serializable;

/**
 *
 * @author JChantry
 */
public class HelpMenuView extends MenuView implements Serializable {
    //private String helpMenu; //text of the menu
    //private int max; //number of items in the menu
    //Scanner keyboard = new Scanner(System.in);  
    //Constructor
    public HelpMenuView() {


    
  
        super("\n" +
            "**********************************\n" +
            "* CITY OF AARON: HELP MENU  *\n" +
            "**********************************\n" +
            " 1 - What are the goals of the game?\n" +
            " 2 - Where is the city of Aaron?\n" +
            " 3 - How do I view the map?\n" +
            " 4 - How do I move to another location?\n" +
            " 5 - How do I display a list of animals, provisions and tools in the city storehouse?\n" +
            " 6 - Back to the Main Menu\n",
        6);



    }

    
 
    
    // The doAction method
    // Purpose: performs the selected action
    // Parameters: none
    // Returns: none
    // ===================================       
    @Override public void doAction(int option)
    {
        switch(option) {
            case 1: // display goals of the game
                displayHelpGoalsOfGame();
                break;
            case 2: // display where the city of Aaron is
                displayHelpWhere();
                break;
            case 3: // display how view map
                displayHelpViewMap();
                break;
            case 4: // display how to move to another location
                displayHelpMoveLocation();
                break;
            case 5: // display animals, provisions, and tools in storehouse
                displayHelpWhatInStorehouse();
                break;
            case 6: // back to main menu
                break;
        }
 

    
    }
    // The displayHelpGoalsOfGame method
    // Purpose: displays the goals of the game
    // Parameters: none
    // Returns: none
    // ===================================   
    public void displayHelpGoalsOfGame()
    {
        System.out.println("\nGoals of the Game was Selected.");
    }
    // The displayHelpWhere method
    // Purpose: displays where the city of Aaron is loacted
    // Parameters: none
    // Returns: none
    // ===================================   
    public void displayHelpWhere()
    {
        System.out.println("\nWhere is the City of Aaron was Selected.");
    }
    // The displayHelpViewMap method
    // Purpose: displays the goals of the game
    // Parameters: none
    // Returns: none
    // ===================================   
    public void displayHelpViewMap()
    {
        System.out.println("\nHow do I view the map was Selected.");
    }
    // The displayHelpMoveLocation method
    // Purpose: explains how to move to another location
    // Parameters: none
    // Returns: none
    // ===================================   
    public void displayHelpMoveLocation()
    {
        System.out.println("\nHow to move to another location was Selected.");
    }
    // The displayHelpWhatInStorehouse method
    // Purpose: shows a list of the animals, provisions, and tools that are in
    //          the storehouse.
    // Parameters: none
    // Returns: none
    // ===================================   
    public void displayHelpWhatInStorehouse()
    {
        System.out.println("\nList Animals, Provisions, and Tools was Selected.");
    }
}
