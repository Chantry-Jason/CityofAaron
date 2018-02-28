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
    public GameMenuView() {


    
  
        gameMenu = "\n" +
            "**********************************\n" +
            "* CITY OF AARON: GAME MENU  *\n" +
            "**********************************\n" +
            " 1 - View the Map\n" +
            " 2 - View/Print a List\n" +
            " 3 - Move to a new location\n" +
            " 4 - Manage the Crops\n" +
            " 5 - Return to the Main Menu\n";
        max = 5;



    }

    
    // The displayHelpView method
    // Purpose: displays the helpmenu, gets the user's input, and does the 
    //               selected action
    // Parameters: none
    // Returns: none
    // =========================================================    
    public void displayGameView(){
        int gameMenuOption;
        do {
            // Display the menu
            System.out.println(gameMenu);
            // Prompt the user and get the user’s input
            gameMenuOption = getHelpMenuOption();
            // Perform the desired action
            doAction(gameMenuOption);
            // Determine and display the next view     
            
        } while (gameMenuOption != max);
        //How will this go back to display menu?
    }
    
    //Purpose: method gets a value from the user, makes sure that it
    //is valid, and if it is, returns that value to the calling
    //method.
    //Parameters: None
    //Returns: integer - the option selected
    public int getGameMenuOption() {
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
    }
    
}
