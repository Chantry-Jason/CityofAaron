// The MainMenuView class - part of the view layer
// Object of this class manage the main menu
// Author: JChantry, KStrobell, JGregg
// Date last modified: Feb 2018
//-------------------------------------------------------------

package byui.cit260.cityofaaron.view;
import java.util.Scanner;

import byui.cit260.cityofaaron.model.Game;
import byui.cit260.cityofaaron.model.Player;
import java.io.Serializable;

     
// The MainMenuView constructor
// Purpose: Initialize the menu data
// Parameters: none
// Returns: none
// ===================================

public class MainMenuView implements Serializable{
    private String mainMenu; //text of the menu
    private int max; //number of items in the menu
    Scanner keyboard = new Scanner(System.in);  
    //Constructor
    public MainMenuView() {


    
  
        mainMenu = "\n" +
            "**********************************\n" +
            "* CITY OF AARON: MAIN GAME MENU  *\n" +
            "**********************************\n" +
            " 1 - Start new game\n" +
            " 2 - Get and start a saved game\n" +
            " 3 - Get help on playing the game\n" +
            " 4 - Save game\n" +
            " 5 - Quit\n";
        max = 5;



    }

    
    // The displayMenuView method
    // Purpose: displays the menu, gets the user's input, and does the 
    //               selected action
    // Parameters: none
    // Returns: none
    // =========================================================    
    public void displayMenuView(){
        int menuOption;
        do {
            // Display the menu
            System.out.println(mainMenu);
            // Prompt the user and get the user’s input
            menuOption = getMenuOption();
            // Perform the desired action
            doAction(menuOption);
            // Determine and display the next view     
            
        } while (menuOption != max);
 
    }
    
    //Purpose: method gets a value from the user, makes sure that it
    //is valid, and if it is, returns that value to the calling
    //method.
    //Parameters: None
    //Returns: integer - the option selected
    public int getMenuOption() {
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
            case 1: // create and start a new game
                startNewGame();
                break;
            case 2: // get and start a saved game
                startSavedGame();
                break;
            case 3: // get help menu
                displayHelpMenuView();
                break;
            case 4: // save game
                displaySaveGameView();
                break;
            case 5: // quit game 
                System.out.println("Thanks for playing ... goodbye.");
        }
 


} 
    // The startNewGame method
    // Purpose: creates game object and starts the game
    // Parameters: none
    // Returns: none
    // ===================================     
    public void startNewGame()
    {
        //Create a new Game object.
        Game theGame = new Game();
        // Save a reference to it in the model.Game class.
        Game.setCurrentGame(theGame);
        // Display the Banner Page.
        System.out.println("\nWelcome to the city of Aaron.");
        // Create a new Player object
        Player thePlayer = new Player();
        // Prompt for and get the user’s name.
        String name;
        System.out.println("\nPlease type your first name: ");
        name = keyboard.next();
        // Save the user’s name in the Player object
        thePlayer.setName(name);
        // Save a reference to the player object in the Game object
        theGame.setThePlayer(thePlayer);
        // Display a welcome message
        System.out.println("\nWelcome " + name + " have fun!!");
        // Display the Game menu
 
    }
    
    
    // The startSavedGame method
    // Purpose: save the current game
    // Parameters: none
    // Returns: none
    // ===================================     
    public void startSavedGame()
    {
        System.out.println("\nSave game option selected.");
    }
    
    // The display Help menu method
    // Purpose: display the help menu
    // Parameters: none
    // Returns: none
    // ===================================     
    public void displayHelpMenuView()
    {
        System.out.println("\nHelp Menu View option selected.");
    }
    
    // The display saved game method
    // Purpose: to load and display a saved game from the disk
    // Parameters: none
    // Returns: none
    // ===================================     
    public void displaySaveGameView()
    {
        System.out.println("\nDisplay Save Game View option selected.");
    }

}
