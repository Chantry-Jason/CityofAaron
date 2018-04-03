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
    //private static Game _theGame = Game.getCurrentGame();
    //private static CropData _theCropData = _theGame.getCropData();

    public CropView() {
    }
    
    
    // The runCropsView method()
    // Purpose: runs the Hamurabi game
    // Parameters: none
    // Returns: none
    public void runCropsView()
    {
        Game theGame = CityOfAaron.Main.getTheGame();
        CropData _theCropData = theGame.getCropData();
        int year = _theCropData.getYear();
        if (year == 0) {
            startReportView();
        }
        // call the buyLandView( ) method
        buyLandView();
        
        sellLandView();
        feedPeopleView();
        plantCropsView();
        
        setOfferingView();
        //Calculate crops harvested. data already checked so no errors should occur
        CropControl.harvestCrops(_theCropData);
        //payOffering
        payOfferingView();
        //storeWheat
        CropControl.storeWheat(_theCropData);
        //calcEatenByRats
        CropControl.calcEatenByRats(_theCropData);
        //calcStarved
        CropControl.calcStarved(_theCropData);
        //growPopulation
        CropControl.growPopulation(_theCropData);
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
        Game theGame = CityOfAaron.Main.getTheGame();
        CropData _theCropData = theGame.getCropData();
        // Get the cost of land for this round.
        int price = CropControl.calcLandCost(_theCropData);
        int toBuy;
        boolean paramsNotOkay;
        
        // Prompt the user to enter the number of acres to buy
        System.out.format("\nLand is selling for %d bushels per acre.\n",price);
        
        do {
            paramsNotOkay = false;
            System.out.print("How many acres of land do you wish to buy? ");   
            toBuy = keyboard.nextInt();
            try {
                // Call the buyLand( ) method in the control layer to buy the land
                CropControl.buyLand(price, toBuy, _theCropData);   
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
        Game theGame = CityOfAaron.Main.getTheGame();
        CropData _theCropData = theGame.getCropData();
        // Get the cost of land for this round.
        int price = _theCropData.getCostOfLandThisRound();
        boolean paramsNotOkay;
        int toSell;
// Prompt the user to enter the number of acres to buy
        System.out.format("\nLand is selling for %d bushels per acre.\n",price);

        // Call the sellLand( ) method in the control layer to sell the land
        
        do {
            paramsNotOkay = false;
            System.out.print("How many acres of land do you wish to sell? "); 
            //  Get the user’s input and save it.
            toSell = keyboard.nextInt();
            try {
                // Call the sellLand( ) method in the control layer to sell the land
                CropControl.sellLand(price, toSell, _theCropData);   
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
        Game theGame = CityOfAaron.Main.getTheGame();
        CropData _theCropData = theGame.getCropData();       
        // Get the cost of land for this round.
        int landOwned = _theCropData.getAcresOwned();
        boolean paramsNotOkay;
        int toPlant;
// Prompt the user to enter the number of acres to buy
        System.out.format("\nYou currently own %d acres of land.\n",landOwned);

        // Call the plantCrops( ) method in the control layer to set aside how many crops to plant
        
        do {
            paramsNotOkay = false;
            System.out.print("How many acres of land do you wish to plant? "); 
            //  Get the user’s input and save it.
            toPlant = keyboard.nextInt();
            try {
                // Call the sellLand( ) method in the control layer to sell the land
                CropControl.plantCrops(toPlant, _theCropData);   
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
        Game theGame = CityOfAaron.Main.getTheGame();
        CropData _theCropData = theGame.getCropData();
        // Get the cost of land for this round.
        int starved = _theCropData.getNumStarved();
        int population = _theCropData.getPopulation();


        // determine if people starved or not
        if (starved > 0) {
            System.out.println("\nM'Lord, unfortunately you did not set aside enough wheat \n"
                    + "to feed all of your people. " + starved + " of your citizens \n"
                    + "starved to death. The total city population is now " + population + " %n.");
        } else {
            System.out.println("\nBlessed be the name of the Lord! None of your \n"
                    + "citizens starved this year. Your population is now"
                    + " " + population + ".%n");
        }
  
    }



    // The setOffering method
    // Purpose: ask user what amount of wheat they would like to give to offerings
    // Parameters: none
    // Returns: none
    //Author: Jason Chantry
    public static void setOfferingView()
    {
        Game theGame = CityOfAaron.Main.getTheGame();
        CropData _theCropData = theGame.getCropData();        
        int offering;
        boolean paramsNotOkay;
        
        // Prompt the user to enter the percentage to offer
        System.out.format("\nOfferings to the Lord will bring forth blessings.");
        
        do {
            paramsNotOkay = false;
            System.out.print("\nWhat percentage of your harvest would you like to set aside for tithes and offerings? ");   
            offering = keyboard.nextInt();
            try {
                // Call the setOffering( ) method in the control layer to set aside offerings
                CropControl.setOffering(offering, _theCropData);   
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
        Game theGame = CityOfAaron.Main.getTheGame();
        CropData _theCropData = theGame.getCropData();
        // Get the cost of land for this round.
        int offering = _theCropData.getOffering();
        double offeringPercent;
        boolean paramsNotOkay;
        
        do {
            paramsNotOkay = false;
            System.out.print("\nHanding tithes to the high priest... ");   
            //toBuy = keyboard.nextInt();
            try {
                offeringPercent = offering / 100.00;
                
                // Call the payOffering( ) method in the control layer to pay tithes
                CropControl.payOffering(offeringPercent, _theCropData);   
            } catch(CropException e) {
                System.out.println("I am sorry master, I cannot do this. There was an error in paying tithes.");
                paramsNotOkay = true;
 
            }
        }while(paramsNotOkay);

    }    


//Author: Ken Strobell
    public static void feedPeopleView()
    {
        Game theGame = CityOfAaron.Main.getTheGame();
        CropData _theCropData = theGame.getCropData();
        // Feed People for this round.
        int wheatInStore = _theCropData.getWheatInStore();

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
                CropControl.feedPeople(toFeed, _theCropData);  
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
        Game theGame = CityOfAaron.Main.getTheGame();
        CropData _theCropData = theGame.getCropData();
        // Get the cost of land for this round.
        int year = _theCropData.getYear();
        int starved = _theCropData.getNumStarved();
        int growth = _theCropData.getNewPeople();
        int population = _theCropData.getPopulation();
        int land = _theCropData.getAcresOwned();
        int bushelsPerAcre = _theCropData.getCostOfLandThisRound();
        int wheatHarvested = _theCropData.getHarvest();
        int offerings = _theCropData.getOffering();
        int harvestAfterOfferings = _theCropData.getHarvestAfterOffering();
        int eatenByRats = _theCropData.getEatenByRats();
        int wheatToPeople = _theCropData.getWheatForPeople();
        int wheat = _theCropData.getWheatInStore();

        System.out.println(
            "\n******************************************************\n" +
            "*           CITY OF AARON: ANNUAL REPORT             *\n" +
            "******************************************************\n" +
            "Current Year: " + (year + 1) + " \n" +  //will incrament year when exiting cropview class
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
            "Total bushels of wheat in the storehouse: " + wheat + "\n" );
        System.out.println("******************************************************\n");
    }
         // The startReportView method
    // Purpose: display the city stats
    // Parameters: none
    // Returns: none
    //Author: Jason Chantry
    public static void startReportView()
    {
        Game theGame = CityOfAaron.Main.getTheGame();
        CropData _theCropData = theGame.getCropData();
       
        int population = _theCropData.getPopulation();
        int land = _theCropData.getAcresOwned();
        //int year = _theCropData.getYear();
        int wheat = _theCropData.getWheatInStore();

        System.out.println(
            "\n******************************************************\n" +
            "*           CITY OF AARON: BEGINNING REPORT            *\n" +
            "******************************************************\n" +
            "You have just started as ruler of Aaron. Here are your starting stats. \n" + 
            
            "Current population: " + population + "\n" + 
            "Acres of land owned by the city: " + land + "\n" + 
            "Total bushels of wheat in the storehouse: " + wheat + "\n" );
        System.out.println("******************************************************\n");

  
    }
}
