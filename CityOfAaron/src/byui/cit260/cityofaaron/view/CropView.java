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
        feedPeopleView();
        plantCropsView();
        
        setOfferingView();
        //Calculate crops harvested. data already checked so no errors should occur
        CropControl.harvestCrops(theCropData);
        //payOffering
        payOfferingView();
        //storeWheat
        CropControl.storeWheat(theCropData);
        //calcEatenByRats
        CropControl.calcEatenByRats(theCropData);
        //calcStarved
        CropControl.calcStarved(theCropData);
        //growPopulation
        CropControl.growPopulation(theCropData);
        //showStarvedView()
        showStarvedView();
        //displayCropsReportView()
        endOfYearReportView();

        
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
        boolean paramsNotOkay;
        int toSell;
// Prompt the user to enter the number of acres to buy
        System.out.format("Land is selling for %d bushels per acre.%n",price);

        // Call the sellLand( ) method in the control layer to sell the land
        
        do {
            paramsNotOkay = false;
            System.out.print("\nHow many acres of land do you wish to sell? "); 
            //  Get the user’s input and save it.
            toSell = keyboard.nextInt();
            try {
                // Call the sellLand( ) method in the control layer to sell the land
                CropControl.sellLand(price, toSell, theCropData);   
            } catch(CropException e) {
                System.out.println("I am sorry master, I cannot do this.");
                System.out.println(e.getMessage());
                paramsNotOkay = true;
 
            }
        }while(paramsNotOkay);


    }
    // The plantCropsView method
    // Purpose: interface with the user input for planting crops
    // Parameters: none
    // Returns: none
    //Author: Jason Chantry
    public static void plantCropsView()
    {
        // Get the cost of land for this round.
        int landOwned = theCropData.getAcresOwned();
        boolean paramsNotOkay;
        int toPlant;
// Prompt the user to enter the number of acres to buy
        System.out.format("You currently own %d acres of land.%n",landOwned);

        // Call the plantCrops( ) method in the control layer to set aside how many crops to plant
        
        do {
            paramsNotOkay = false;
            System.out.print("\nHow many acres of land do you wish to plant? "); 
            //  Get the user’s input and save it.
            toPlant = keyboard.nextInt();
            try {
                // Call the sellLand( ) method in the control layer to sell the land
                CropControl.plantCrops(toPlant, theCropData);   
            } catch(CropException e) {
                System.out.println("I am sorry master, I cannot do this.");
                System.out.println(e.getMessage());
                paramsNotOkay = true;
 
            }
        }while(paramsNotOkay);


    }
    // The showStarvedView method
    // Purpose: display how many people starved due to lack of food
    // Parameters: none
    // Returns: none
    //Author: Jason Chantry
    public static void showStarvedView()
    {
        // Get the cost of land for this round.
        int starved = theCropData.getNumStarved();
        int population = theCropData.getPopulation();


        // determine if people starved or not
        if (starved > 0) {
            System.out.println("M'Lord, unfortunately you did not set aside enough wheat \n"
                    + "to feed all of your people. " + starved + " of your citizens \n"
                    + "starved to death. The total city population is now " + population + " %n.");
        } else {
            System.out.println("Blessed be the name of the Lord! None of your \n"
                    + "citizens starved this year. Your population is now"
                    + " " + population + ".");
        }
  
    }



    // The setOffering method
    // Purpose: ask user what amount of wheat they would like to give to offerings
    // Parameters: none
    // Returns: none
    //Author: Jason Chantry
    public static void setOfferingView()
    {
                
        int offering;
        boolean paramsNotOkay;
        
        // Prompt the user to enter the percentage to offer
        System.out.format("Offerings to the Lord will bring forth blessings.");
        
        do {
            paramsNotOkay = false;
            System.out.print("\nWhat percentage of your harvest would you like to set aside for tithes and offerings? ");   
            offering = keyboard.nextInt();
            try {
                // Call the setOffering( ) method in the control layer to set aside offerings
                CropControl.setOffering(offering, theCropData);   
            } catch(CropException e) {
                System.out.println("I am sorry master, I cannot do this.");
                System.out.println(e.getMessage());
                paramsNotOkay = true;
 
            }
        }while(paramsNotOkay);

    }
    // The payOfferingView method
    // Purpose: pay the offerings that the user already set in setOffering
    // Parameters: none
    // Returns: none
    //Author: Jason Chantry
    public static void payOfferingView()
    {
        // Get the cost of land for this round.
        int offering = theCropData.getOffering();
        double offeringPercent;
        boolean paramsNotOkay;
        
        do {
            paramsNotOkay = false;
            System.out.print("\nHanding tithes to the high priest... ");   
            //toBuy = keyboard.nextInt();
            try {
                offeringPercent = offering / 100.00;
                
                // Call the payOffering( ) method in the control layer to pay tithes
                CropControl.payOffering(offeringPercent, theCropData);   
            } catch(CropException e) {
                System.out.println("I am sorry master, I cannot do this. There was an error in paying tithes.");
                paramsNotOkay = true;
 
            }
        }while(paramsNotOkay);

    }    


//Author: Ken Strobell
    public static void feedPeopleView()
    {
        // Feed People for this round.
        int wheatInStore = theCropData.getWheatInStore();

        // Feed your people
        //System.out.format("Feeding your people will cost %d of your wheat in store.%n",feed);
        //System.out.print("\nDo you wish to feed your people? "); 

        //  Get the user’s input and save it.
        int toFeed;
        
        
        boolean paramsNotOkay;
        
        // Prompt the user to enter the number of acres to buy
        //System.out.format("Land is selling for %d bushels per acre.%n",price);
        
        do {
            paramsNotOkay = false;
            System.out.print("\nHow many bushels of grain do you want to give to the people?  ");   
            toFeed = keyboard.nextInt();
            try {
                // Call the feedPeople( ) method in the control layer to feed people
                CropControl.feedPeople(toFeed, theCropData);  
            } catch(CropException e) {
                System.out.println("I am sorry master, I cannot do this.");
                System.out.println(e.getMessage());
                paramsNotOkay = true;
 
            }
        }while(paramsNotOkay);
        
        // Call the sellLand( ) method in the control layer to sell the land
        //wheatInStore = CropControl.feedPeople(toFeed, theCropData);
        
        //error handling. If return is -1 then ask again.
        //if (wheatInStore == -1) {
            //number entered is less than 0, ask again. Jump up to top...
        //}
       // if (wheatInStore == -2) {
            //number endered is more than the total wheat instore, ask again. Jump to top...
        //}


    }
     // The endOfYearReportView method
    // Purpose: display the city stats
    // Parameters: none
    // Returns: none
    //Author: Jason Chantry
    public static void endOfYearReportView()
    {
        // Get the cost of land for this round.
        int year = theCropData.getYear();
        int starved = theCropData.getNumStarved();
        int growth = theCropData.getNewPeople();
        int population = theCropData.getPopulation();
        int land = theCropData.getAcresOwned();
        int bushelsPerAcre = theCropData.getCostOfLandThisRound();
        int wheatHarvested = theCropData.getHarvest();
        int offerings = theCropData.getOffering();
        int harvestAfterOfferings = theCropData.getHarvestAfterOffering();
        int eatenByRats = theCropData.getEatenByRats();
        int wheatToPeople = theCropData.getWheatForPeople();
        int wheat = theCropData.getWheatInStore();

        System.out.println(
            "******************************************************\n" +
            "*           CITY OF AARON: ANNUAL REPORT             *\n" +
            "******************************************************\n" +
            "Years since you were made ruler: " + year + " \n" + 
            "People who starved: " + starved + "\n" + 
            "People who moved into the city: " + growth + "\n" + 
            "Current population: " + population + "\n" + 
            "Acres of land owned by the city: " + land + "\n" + 
            "Number of bushels per acre for this years harvest: " + bushelsPerAcre + "\n" + 
            "Bushels of wheat that was harvested: " + wheatHarvested + "\n" + 
            "Bushels of wheat paid in offerings: " + offerings + "\n" + 
            "Bushels of wheat harvested after payment of offerings: " + harvestAfterOfferings + "\n" + 
            "Bushels of wheat eaten by rats: " + eatenByRats + "\n" + 
            "Bushels of wheat fed to the people: " + wheatToPeople + "\n" +
            "Total bushels of wheat inthe storehouse: " + wheat + "\n" );
        System.out.println("******************************************************\n");
        

  
    }
}
