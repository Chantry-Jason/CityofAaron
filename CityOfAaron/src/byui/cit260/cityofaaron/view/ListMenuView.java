package byui.cit260.cityofaaron.view;

import byui.cit260.cityofaaron.model.Game;
import byui.cit260.cityofaaron.model.ListItem;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author KStrobell
 */
public class ListMenuView extends MenuView implements Serializable{
    //private String gameMenu; //text of the menu
    private int max; //number of items in the menu
    Scanner keyboard = new Scanner(System.in);  
    // reference to a Game object
    private static Game theGame;
    //Constructor
    public ListMenuView() {


    
  
        super( "\n" +
            "**********************************\n" +
            "* CITY OF AARON: LIST MENU  *\n" +
            "**********************************\n" +
            " 1 - List or View the animals in the storehouse\n" +
            " 2 - List or View the tools in the storehouse\n" +
            " 3 - List or View the provisions in the storehouse\n" +
            " 4 - List or View the development team\n" +
            " 5 - Return to the Main Menu\n",
        5);



    }

    
  
    
    // The doAction method
    // Purpose: performs the selected action
    // Parameters: none
    // Returns: none
    // ===================================       
    @ Override public void doAction(int option)
    {
        
        switch(option) {
            case 1: // view or print list of Animals
                viewprintAnimals();
                break;
            case 2: // view or print a list of Tools
                viewprintTools();
                break;
            case 3: // view or print a list of Provisions
                viewprintProvisions();
                break;
            case 4: // view or print a list of Authors
                viewprintAuthors();
                break;
            case 5: // back to main menu
                break;
        }
 

    
    }
    // The view print Animals method
    // Purpose: displays a list of animals in the storehouse
    // Parameters: none
    // Returns: none
    // ===================================   
    public static void viewprintAnimals()
    {
        
        
        System.out.println("\nHere is a list of the animals you currently have.");
        Game theGame = new Game();
        ArrayList<ListItem> animals = theGame.getAnimals();
        

        for (int i = 0; i < animals.size(); i++) {
            ListItem listItem = animals.get(i);
            System.out.println("\n\tItem: " + listItem.getName() +
                               "\n\tQuantity: " + listItem.getNumber());
        }
        
        
    }
    // The viewprintList of Tools method
    // Purpose: view a List of Tools
    // Parameters: none
    // Returns: none
    // ===================================   
    public void viewprintTools()
    {
        System.out.println("\nHere is a list of the tools you have in the shed.");
        Game theGame = new Game();
        ArrayList<ListItem> tools = theGame.getTools();
        
        for (int i = 0; i < tools.size(); i++) {
            ListItem listItem = tools.get(i);
            System.out.println("\n\tItem: " + listItem.getName() +
                               "\n\tQuantity: " + listItem.getNumber());
        }
    }
    // The viewprintList of Provisions method
    // Purpose: view a List of Provisions
    // Parameters: none
    // Returns: none
    // ===================================   
    public void viewprintProvisions()
    {
        System.out.println("\nHere is a list of your current provisions.");
               
        Game theGame = new Game();
        ArrayList<ListItem> prov = theGame.getTools();
        
        for (int i = 0; i < prov.size(); i++) {
            ListItem listItem = prov.get(i);
            System.out.println("\n\tItem: " + listItem.getName() +
                               "\n\tQuantity: " + listItem.getNumber());
        }
    }
    // The viewprintList of Authors method
    // Purpose: view a List of Authors
    // Parameters: none
    // Returns: none
    // ===================================   
    public void viewprintAuthors()
    {
        System.out.println("\nView/Print Authors was selected.");
        
    }
    
}