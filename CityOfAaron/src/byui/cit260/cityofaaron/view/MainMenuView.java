// The MainMenuView class - part of the view layer
// Object of this class manage the main menu
// Author: JChantry, KStrobell, JGregg
// Date last modified: Feb 2018
//-------------------------------------------------------------

package byui.cit260.cityofaaron.view;
import byui.cit260.cityofaaron.control.GameControl;
import byui.cit260.cityofaaron.model.CropData;
//import java.util.Scanner;

import byui.cit260.cityofaaron.model.Game;
import byui.cit260.cityofaaron.model.Player;
//import byui.cit260.cityofaaron.view.HelpMenuView;
import java.io.Serializable;

     
// The MainMenuView constructor
// Purpose: Initialize the menu data
// Parameters: none
// Returns: none
// ===================================

public class MainMenuView extends MenuView implements Serializable{
    //private String mainMenu; //text of the menu
    //private int max; //number of items in the menu
    //Scanner keyboard = new Scanner(System.in);  
    //Constructor 
    public MainMenuView() {


        //super will call the base class contructor and send these variables 
  
        super ("\n" +
            "**********************************\n" +
            "* CITY OF AARON: MAIN GAME MENU  *\n" +
            "**********************************\n" +
            " 1 - Start new game\n" +
            " 2 - Get and start a saved game\n" +
            " 3 - Get help on playing the game\n" +
            " 4 - Save game\n" +
            " 5 - Quit\n",
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
                System.exit(0);
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
        // Create the CropData object, 
        // initialize it and save a reference to it in the Game
        CropData theCrops = new CropData();
        theCrops.setYear(0);
        theCrops.setPopulation(100);
        theCrops.setNewPeople(5);
        theCrops.setCropYield(3);
        theCrops.setNumberWhoDied(0);
        theCrops.setOffering(10);
        theCrops.setWheatInStore(2700);
        theCrops.setAcresOwned(1000);
        theCrops.setAcresPlanted(1000);
        theCrops.setHarvest(3000);
        theCrops.setOfferingBushels(300);
        theCrops.setAcresPlanted(1000); 
        
        theGame.setCropData(theCrops);
        
        // Display the Banner Page.
        System.out.println(
            "\n********************************************************\n" +
            "* Welcome to the City of Aaron. You have been summoned *\n" +
            "* by the High Priest to assume your role as ruler of   *\n" +
            "* the city. Your responsibility is to buy land, sell   *\n" +
            "* land, determine how much wheat to plant each year,   *\n" +
            "* and how much to set aside to feed the people. You    *\n" +
            "* will also be required to pay an annual tithe on the  *\n" +
            "* that is harvested. If you fail to provide            *\n" +
            "* enough wheat for the people to eat, people will die  *\n" +
            "* and your workforce will be diminished. Plan very     *\n" +
            "* carefully or you may find yourself in trouble with   *\n" +
            "* the people. And oh, watch out for plagues and rats!  *\n" +
            "********************************************************\n");
        // Create a new Player object
        Player thePlayer = new Player();
        // Prompt for and get the user’s name.
        String name;
        System.out.println("\nWhat is your name M'Lord? ");
        name = keyboard.next();
        // Save the user’s name in the Player object
        thePlayer.setName(name);
        // Save a reference to the player object in the Game object
        theGame.setThePlayer(thePlayer);
        // Display a welcome message
        System.out.println("\nWelcome to the city " + name + " have fun!!");
        // call the createNewGame( ) method. Pass the name as a parameter
        GameControl.createNewGame(name);


        // Display the Game menu
        GameMenuView gameMenu = new GameMenuView();
        gameMenu.displayMenu();
        




    }
    
    
    // The startSavedGame method
    // Purpose: save the current game
    // Parameters: none
    // Returns: none
    // ===================================     
    public void startSavedGame()
    {
       
        String filePath ;
        
        // prompt user and get a file path
        System.out.println("\n\nEnter the file path where you want to load the game from:");
        keyboard.nextLine();  // this gets rid of the newline left by getMenuOption( )
        filePath = keyboard.nextLine();
         
        // calls the getSavedGame( ) method in the GameControl class to load the game
        GameControl.getSavedGame(filePath);

        // and now you can display the game menu for the loaded game
        GameMenuView gmv = new GameMenuView();
        gmv.displayMenu();



    }
    
    // The display Help menu method
    // Purpose: display the help menu
    // Parameters: none
    // Returns: none
    // ===================================     
    public void displayHelpMenuView()
    {
        System.out.println("\nHelp Menu View option selected.");
        HelpMenuView helpMenu = new HelpMenuView();
        helpMenu.displayMenu();
        
    }
    
    // The display saved game method
    // Purpose: to load and display a saved game from the disk
    // Parameters: none
    // Returns: none
    // ===================================     
    public void displaySaveGameView()
    {
  
        String location;
  
            System.out.print("\nWhere would you like to save your game? ");   
            keyboard.nextLine();  // this gets rid of the newline left by getMenuOption( )
            location = keyboard.nextLine();
            
            // Save the Game
            GameControl.saveGame(location);   
            

    
    }

}
