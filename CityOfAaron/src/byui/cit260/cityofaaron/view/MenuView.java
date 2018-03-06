/**
 * The MenuView class - base abstract class for all menu views
 * @author JChantry
 */
package byui.cit260.cityofaaron.view;

import java.util.Scanner;

public abstract class MenuView implements ViewInterface{
    // the data members common to all menu views
    //protected so they can be seen by methods in the child class
    protected final static Scanner keyboard = new Scanner(System.in);
        
    protected String menu;  // this string holds the menu string
    protected int max; // this int holds the max input value

    // MenuView Constructor
    // Purpose: Initialize the view object with the menu string
    // Parameters: the menu string and the max value
    // Returns: none
    public MenuView(String _menu, int _max)
    {
        menu = _menu;
        max = _max;
    }
    // The displayMenu method
    // Purpose: displays the menu, gets the user's input, and does the 
    //               selected action
    // Parameters: none
    // Returns: none
    // =========================================================    
    //@override tells java we are overriding the displayMenu() method declared 
    // in ViewInterface
    @Override public void displayMenu(){
        int menuOption = 0;
        // execute this loop as long as the selected option is not max
        do {
            // Display the menu
            System.out.println(menu);
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
    @Override public int getMenuOption() {
        // declare a variable to hold user’s input
        int userInput;
        // begin loop
        do
        {
            System.out.format("\nPlease enter an option(1 - %d):", max);

            // get user input from the keyboard
            userInput = keyboard.nextInt();
            // if it is not a valid value, output an error message
            if(userInput < 1 || userInput > max)
            {
                System.out.format("\nError: input value must be between 1 and %d.", max);
            }
        // loop back to the top if input was not valid
                 
        } while(userInput < 1 || userInput > max);
        // return the value input by the user  
        return userInput;

    }
}
