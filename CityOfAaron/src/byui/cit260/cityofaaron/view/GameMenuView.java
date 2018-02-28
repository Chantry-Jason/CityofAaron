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
public class GameMenuView implements Serializable{
    private String gameMenu; //text of the menu
    private int max; //number of items in the menu
    Scanner keyboard = new Scanner(System.in);  
    //Constructor
    public HelpMenuView() {


    
  
        helpMenu = "\n" +
            "**********************************\n" +
            "* CITY OF AARON: HELP MENU  *\n" +
            "**********************************\n" +
            " 1 - What are the goals of the game?\n" +
            " 2 - Where is the city of Aaron?\n" +
            " 3 - How do I view the map?\n" +
            " 4 - How do I move to another location?\n" +
            " 5 - How do I display a list of animals, provisions and tools in the city storehouse?\n" +
            " 6 - Back to the Main Menu\n";
        max = 6;



    }

    
    // The displayHelpView method
    // Purpose: displays the helpmenu, gets the user's input, and does the 
    //               selected action
    // Parameters: none
    // Returns: none
    // =========================================================    
    public void displayHelpView(){
        int helpMenuOption;
        do {
            // Display the menu
            System.out.println(helpMenu);
            // Prompt the user and get the user’s input
            helpMenuOption = getHelpMenuOption();
            // Perform the desired action
            doAction(helpMenuOption);
            // Determine and display the next view     
            
        } while (helpMenuOption != max);
        //How will this go back to display menu?
    }
    
    //Purpose: method gets a value from the user, makes sure that it
    //is valid, and if it is, returns that value to the calling
    //method.
    //Parameters: None
    //Returns: integer - the option selected
    public int getHelpMenuOption() {
        // declare a variable to hold user’s input
        int userInput;
        // begin loop
        do
        {
            // get user input from the keyboard
            userInput = keyboard.nextInt();
            // if it is not a valid value, output an error message
            if(userInput < 1 || userInput > max)
            {
                System.out.println("\noption must be between 1 and " + max);
            }
        // loop back to the top if input was not valid
                 
        } while(userInput < 1 || userInput > max);
        // return the value input by the user  
        return userInput;

    }
    
    // The doAction method
    // Purpose: performs the selected action
    // Parameters: none
    // Returns: none
    // ===================================       
    public void doAction(int option)
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
