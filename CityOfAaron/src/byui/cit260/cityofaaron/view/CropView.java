/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.cityofaaron.view;
import byui.cit260.cityofaaron.model.*;
import byui.cit260.cityofaaron.control.*;
import java.util.Scanner;
import byui.cit260.cityofaaron.model.Game;



/**
 *
 * @author JChantry
 */
public class CropView {
    // Create a Scanner object
    private static Scanner keyboard = new Scanner(System.in);   
     
    // Get reference to the Game object and the Crops object
    private static Game theGame = Game.getCurrentGame();
    private static CropData theCropData = theGame.getCropData();
    
    // The runCropsView method()
    // Purpose: runs the Hamurabi game
    // Parameters: none
    // Returns: none
    public static void runCropsView()
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

        // Prompt the user to enter the number of acres to buy
        System.out.format("Land is selling for %d bushels per acre.%n",price);
        System.out.print("\nHow many acres of land do you wish to buy? "); 

        //  Get the user’s input and save it.
        int toBuy;
        toBuy = keyboard.nextInt();

        // Call the buyLand( ) method in the control layer to buy the land
        int acresOwned = CropControl.buyLand(price, toBuy, theCropData);
        
        //error handling. If return is -1 then ask again.
        if (acresOwned == -1) {
            //invalid number, ask again. jump up to top...
        }


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
    
    
    public static void feedPeopleView()
    {
        // Feed People for this round.
        int wheatInStore = theCropData.getwheatInStore();

        // Feed your people
        System.out.format("Feeding your people will cost %d of your wheat in store.%n",feed);
        System.out.print("\nAre you sure you want to proceed? "); 

        //  Get the user’s input and save it.
        int toFeed;
        toFeed = keyboard.nextInt();

        // Call the sellLand( ) method in the control layer to sell the land
        int wheatInStore = CropControl.feedPeople(population, feedPeople, theCropData);
        
        //error handling. If return is -1 then ask again.
        if (wheatInStore == -1) {
            //invalid number, ask again. Jump up to top...
            
        }


    }
  
}
