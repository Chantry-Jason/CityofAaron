package byui.cit260.cityofaaron.view;

import java.io.Serializable;
import java.util.Scanner;

/**
 *
 * @author KStrobell
 */
public class ListMenuView implements Serializable{
    private String gameMenu; //text of the menu
    private int max; //number of items in the menu
    Scanner keyboard = new Scanner(System.in);  
    //Constructor
    public ListMenuView() {


    
  
        listMenu = "\n" +
            "**********************************\n" +
            "* CITY OF AARON: LIST MENU  *\n" +
            "**********************************\n" +
            " 1 - List or View the animals in the storehouse\n" +
            " 2 - List or View the tools in the storehouse\n" +
            " 3 - List or View the provisions in the storehouse\n" +
            " 4 - List or View the authors of this game\n" +
            " 5 - Return to the Main Menu\n";
        max = 5;



    }

    
    // The displayListView method
    // Purpose: displays the listmenu, gets the user's input, and does the 
    //               selected action
    // Parameters: none
    // Returns: none
    // =========================================================    
    public void displayListView(){
        int listMenuOption;
        do {
            // Display the menu
            System.out.println(listMenu);
            // Prompt the user and get the user’s input
            listMenuOption = getlistMenuOption();
            // Perform the desired action
            doAction(listMenuOption);
            // Determine and display the next view     
            
        } while (listMenuOption != max);
        //How will this go back to display menu?
    }
    
    //Purpose: method gets a value from the user, makes sure that it
    //is valid, and if it is, returns that value to the calling
    //method.
    //Parameters: None
    //Returns: integer - the option selected
    public int getListMenuOption() {
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
    public void viewprintAnimals()
    {
        System.out.println("\nView/Print Animals was selected.");
    }
    // The viewprintList of Tools method
    // Purpose: view a List of Tools
    // Parameters: none
    // Returns: none
    // ===================================   
    public void viewprintTools()
    {
        System.out.println("\nView/Print Tools was selected.");
    }
    // The viewprintList of Provisions method
    // Purpose: view a List of Provisions
    // Parameters: none
    // Returns: none
    // ===================================   
    public void viewprintProvisions()
    {
        System.out.println("\nView/Print Provisions was selected.");
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