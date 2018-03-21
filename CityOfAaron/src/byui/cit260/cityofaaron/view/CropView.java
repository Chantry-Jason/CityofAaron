/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.cityofaaron.view;
import byui.cit260.cityofaaron.model.*;
import byui.cit260.cityofaaron.control.*;
import byui.cit260.cityofaaron.exceptions.CropException;
import java.util.Scanner;
import byui.cit260.cityofaaron.model.Game;
import java.io.Serializable;



/**
 *
 * @author JChantry
 */
public class CropView implements Serializable{
    // Create a Scanner object
    private static Scanner keyboard = new Scanner(System.in);   
     
    // Get reference to the Game object and the Crops object
    private static Game theGame = Game.getCurrentGame();
    private static CropData theCropData = theGame.getCropData();
    
    // The runCropsView method()
    // Purpose: runs the Hamurabi game
    // Parameters: none
    // Returns: none
    public void runCropsView()
    {
        // call the buyLandView( ) method
        buyLandView();
        
        sellLandView();
        // add calls to the other crop view methods
        // as they are written
        /*   
            feedPeopleView()
            plantCropsView()
            showStarvedView()
            displayCropsReportView()
        */
    }

    
    
    // The buyLandView method
    // Purpose: interface with the user input for buying land
    // Parameters: none
    // Returns: none
    //Author: Jason Chantry, Ken Strobell
    public static void buyLandView()
    {
        // Get the cost of land for this round.
        int price = CropControl.calcLandCost(theCropData);
        int toBuy;
        boolean paramsNotOkay;
        
        // Prompt the user to enter the number of acres to buy
        System.out.format("Land is selling for %d bushels per acre.%n",price);
        
        do {
            paramsNotOkay = false;
            System.out.print("\nHow many acres of land do you wish to buy? ");   
            toBuy = keyboard.nextInt();
            try {
                // Call the buyLand( ) method in the control layer to buy the land
                CropControl.buyLand(price, toBuy, theCropData);   
            } catch(CropException e) {
                System.out.println("I am sorry master, I cannot do this.");
                System.out.println(e.getMessage());
                paramsNotOkay = true;
 
            }
        }while(paramsNotOkay);

    }
    // The sellLandView method
    // Purpose: interface with the user input for selling land
    // Parameters: none
    // Returns: none
    //Author: Jason Chantry
    public static void sellLandView()
    {
        // Get the cost of land for this round.
        int price = theCropData.getCostOfLandThisRound();

        // Prompt the user to enter the number of acres to buy
        System.out.format("Land is selling for %d bushels per acre.%n",price);
        System.out.print("\nHow many acres of land do you wish to sell? "); 

        //  Get the user’s input and save it.
        int toSell;
        toSell = keyboard.nextInt();

        // Call the sellLand( ) method in the control layer to sell the land
        int acresOwned = CropControl.sellLand(price, toSell, theCropData);
        
        //error handling. If return is -1 then ask again.
        if (acresOwned == -1) {
            //invalid number, ask again. Jump up to top...
            
        }


    }
    
    //Author: Ken Strobell
    public static void feedPeopleView()
    {
        // Feed People for this round.
        int wheatInStore = theCropData.getWheatInStore();

        // Feed your people
        //System.out.format("Feeding your people will cost %d of your wheat in store.%n",feed);
        System.out.print("\nHow many bushels of grain do you want to give to the people? "); 

        //  Get the user’s input and save it.
        int toFeed;
        toFeed = keyboard.nextInt();

        // Call the sellLand( ) method in the control layer to sell the land
        wheatInStore = CropControl.feedPeople(toFeed, theCropData);
        
        //error handling. If return is -1 then ask again.
        if (wheatInStore == -1) {
            //number entered is less than 0, ask again. Jump up to top...
        }
        if (wheatInStore == -2) {
            //number endered is more than the total wheat instore, ask again. Jump to top...
        }


    }
  
}
