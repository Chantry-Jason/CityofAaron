/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.cityofaaron.control;

import byui.cit260.cityofaaron.exceptions.CropException;
import byui.cit260.cityofaaron.model.CropData;
import java.io.Serializable;
import java.util.Random;

 
/**
 *
 * @author JChantry, KStrobell
 */
public class CropControl implements Serializable{
  
    //Set Static variables
    public static int ACRES_PER_BUSHEL = 2;     //2 acres cost 1 bushel of wheat
    public static int PEOPLE_PER_ACRE = 10;     //1 person can take care of 10 acres
    public static int BUSHELS_PER_PERSON = 20;  //20 bushels of wheat to feed 1 person
    
    
            
    
    
    // The buyLand method
    // Purpose: To buy land
    // Parameters: the price of land and the number of acres to buy
    // Returns: the number of acres after the purchase
    // Pre-conditions: acres to buy must be positive or zero
    // and cost must be <= current coin
    // Author: JChantry
    public static int buyLand(int price, int acresToBuy, CropData cropData) throws CropException {
        
        //get wheat in store, and acres owned
        int wheatInStore = cropData.getWheatInStore();
        int acresOwned = cropData.getAcresOwned();
        int population = cropData.getPopulation();
        //if acresToBuy < 0, return -1
        if (acresToBuy < 0) {
            throw new CropException("A negative value was input.");
            //return -1;
        }
        //if (acresToBuy * landPrice) > wheatInStore,  return -1
        if ((acresToBuy * price) > wheatInStore) {
            //don't have enough wheat to purchase this land
            throw new CropException("There is insufficient wheat to buy this much land.");

            //return -2;  
        }
        //make sure the city has enough people to tend the land.
        if (((acresToBuy + acresOwned) / PEOPLE_PER_ACRE) > population) {
            //don't have enough people to tend this much land. 
            throw new CropException("Not enough people to work the land you wish to purchase.");
            //return -3;
        }
        //acresOwned = acresOwned + acresToBuy
        acresOwned += acresToBuy;
        cropData.setAcresOwned(acresOwned);
        //wheatInStore = wheatInStore - (acresToBuy x landPrice)
        wheatInStore -= (acresToBuy * price);
        cropData.setWheatInStore(wheatInStore);
        //return acresOwned
        return acresOwned;

    }
    // The setOffering method
    // Purpose: To set the amount of tithes user wants to pay
    // Parameters: userOffering 
    // Returns: the percentage the user wants to give to offerings
    // Pre-conditions: offering must be >= 0 and <=100
 
    // Author: Jason
    
    public static int setOffering(int userOffering, CropData cropData) throws CropException {
        //check pre-conditions
        if ((userOffering < 0) || (userOffering > 100)) {
            throw new CropException("The offering you entered is invalid. Please enter a number between 0 and 100 percent. Thank you m'Lord.");
            //return -1;          //offering invalid
        }
        //save the Offering entered by user in cropData.Offering
        cropData.setOffering(userOffering);
        return userOffering;
    }
    
    // The payOffering method
    // Purpose: Reconsile how much tithing the user wanted to pay, calculate
    //          percentage of wheat harvested, subtract from wheatinstore. Update
    //          harvest after offering
    // Parameters: percentage of wheat harvested in double, 0.01
    // Returns: percentage of tithes paid 
    // Pre-conditions: percentage must be >= 0 and <= 100% 
    //Outside variables: HarvestAfterOffering, Harvest, WheatInStore, Offering
    // Author: Jason Chantry
   public static int payOffering (double percentOffering, CropData cropData) throws CropException {
       
       //Calculate the bushels of wheat paid for offerings based on user percentage input
       //Outside variables: HarvestAfterOffering, Harvest, WheatInStore, Offering
       int wheatInStore = cropData.getWheatInStore();
       //System.out.println("WheatInStore: " + wheatInStore);
       int harvest = cropData.getHarvest();
       //System.out.println("Harvest: " + harvest);
       
        //amount of wheat in tithes = harvest * (percentOffering / 100)
        //account for 0 by setting to 0 and only doing division if offering
        //is greater then 0
       double amtWheatForTithes = 0;
       if (percentOffering > 0) {
           amtWheatForTithes = harvest * percentOffering;
       } 
       
       //System.out.println("AmountWheatForTithes: " + amtWheatForTithes);
       int amtIntWheatForTithes = (int) Math.round(amtWheatForTithes);
       //System.out.println("AmountIntWheatForTithes: " + amtIntWheatForTithes);
       //Update HarvestAfterOffering = harvest - amtWheatForTithes
       cropData.setHarvestAfterOffering(harvest - amtIntWheatForTithes);
       //Update WheatInStore to add HarvestAfterOffering
       //cropData.setWheatInStore(wheatInStore + (harvest - amtIntWheatForTithes));
       //No spec for what to return. For now return Harvest amount after tithes
       return amtIntWheatForTithes;
       
       
       
       
   }
    
  // The storeWheat method
    // Purpose: adds wheat harvested, subtracts wheat after offerings and saves 
    //          back to store wheat
    //  
    // Parameters: none
    // Returns: wheat in store 
    // Pre-conditions: none 
    //Outside variables: HarvestAfterOffering, Harvest, WheatInStore
    // Author: Jason Chantry
   public static int storeWheat (CropData cropData) {
       int wheatInStore = cropData.getWheatInStore();
       int harvestAfterOffering = cropData.getHarvestAfterOffering();
       //harvestAfterOffering is wheat Harvested - wheat for offerings. 
       
       // add the harvested amount of wheat (after subtracting offerings) to the 
       // store.
       int newWheatInStore = wheatInStore + harvestAfterOffering;
       cropData.setWheatInStore(newWheatInStore);
       return newWheatInStore;
   }  
    
    // The sellLand method
    // Purpose: To sell land
    // Parameters: the price of land and the number of acres to sell
    // Returns: the number of acres left after the sale
    // Pre-conditions: acres to sell must be positive
    // and <= acresOwned
    // Author: Ken, Jason, Josh
    public static int sellLand(int landPrice, int acresToSell, CropData cropData) throws CropException {
        //if acresToSell < 0, return -1
        if (acresToSell < 0) {
            throw new CropException("A negative value was entered. Please enter a positive value.");
        }
             
        //if acresToSell  > acresOwned, return -1
        int owned = cropData.getAcresOwned();
        if (acresToSell > owned) {
            throw new CropException("m'Lord, you don't have that much land to sell.");
        }
        //acresOwned = acresOwned - acresToSell
        owned -= acresToSell;
        cropData.setAcresOwned(owned);
        
        //wheatInStore = wheatInStore + (acresToSell x landPrice)
        int wheat = cropData.getWheatInStore();
        wheat += (acresToSell * landPrice);
        cropData.setWheatInStore(wheat);
        
        //return acresOwned
        return owned;

        
    }
    // The plantCrops method
    // Purpose: To set aside how many crops to plant
    // Parameters: how many crops the user wants to plant
    // Returns: the wheat left in store after planting or -1 for error
    // Pre-conditions: number of crops must be >=0, and #crops*ACRESPERBUSHEL must
    //                 be less than wheat we have in store, and #crops to plant  
    //                 must be <= total crops owned
    
    // Author: Jason
    public static int plantCrops(int userPlantCrops, CropData cropData) throws CropException {
        
        int wheatInStore = cropData.getWheatInStore();
        int landOwned = cropData.getAcresOwned();
        if (userPlantCrops < 0) {
            throw new CropException("Negative value not valid.");
            //return -1;      //negative number. Invalid
        }
        if ((userPlantCrops * ACRES_PER_BUSHEL) > wheatInStore) {
             throw new CropException("Not enough Wheat In Store.");
            //return -2;      //don't have enough wheat in store to plant the requested crops
        }
        if (userPlantCrops > landOwned) {
            //trying to plant more acres than is owned.
            throw new CropException("Not enough land.");
            //return -3;
        }
        int numBushelsReqToPlant = userPlantCrops * ACRES_PER_BUSHEL;
        int cropsLeft = wheatInStore - numBushelsReqToPlant;
        cropData.setWheatInStore(cropsLeft);
        cropData.setAcresPlanted(userPlantCrops);
        return cropsLeft;
        
    }
    
    
    //Author: Ken Strobell
    public static int harvestCrops (CropData cropData) {
            
                
            // nextInt is normally exclusive of the top value,
            // so add 1 to make it inclusive
            //int cropYield = ThreadLocalRandom.current().nextInt(2, 5 + 1);
            
            Random random = new Random();
            
            int tithesPaid = cropData.getOffering();
            int wheatInStore = cropData.getWheatInStore();
            int acresPlanted = cropData.getAcresPlanted();
            int TITHING_BASE = 0;
            int TITHING_RANGE = 0;
            //2-5 random
            if (tithesPaid >= 12) {
                TITHING_BASE = 2;
                TITHING_RANGE = 4;
                //System.out.println("Tithes > 12");
                
            }
            //1-3 random
            if (tithesPaid <= 8) { 
                TITHING_BASE = 1;
                TITHING_RANGE = 3;                
                //System.out.println("Tithes <8");
            }
            
            //2-4
            if (tithesPaid >= 9 && tithesPaid <= 12) { 
                TITHING_BASE = 2;
                TITHING_RANGE = 3;                
                //System.out.println("Tithes >=9 <=12");
            }
            
            if (tithesPaid < 0) {
                return -1;
            }
            int cropYield = random.nextInt(TITHING_RANGE)+ TITHING_BASE; 
            //System.out.println("CropYield: " + cropYield);
            int wheatToHarvest = acresPlanted * cropYield;
            
            //wheatInStore += wheatToHarvest;
            //cropData.setWheatInStore(wheatInStore);
            cropData.setCropYield(cropYield);
            cropData.setHarvest(wheatToHarvest); //added to update harvest variable. JEC
            
            return wheatToHarvest;
    }
         
            // The calcEatenByRats Method
            // Purpose: see if rats ate some of your wheat in store.
            // Parameter: If random number is 1-30, rats eat crops, if number is 30-100 rats do not.
            // Returns: New amount of wheat in store after rats eat some.
            // if tithesPaid is > 12 , random value between 3-5% of wheat in store is eaten
            // if tithesPaid is < 8 , random value between 6-10% of wheat in store is eaten
            // if tithesPaid is >= 9 and < 12 , random value between 3-7% of wheat in store is eaten
            // nextInt is normally exclusive of the top value,
            // so add 1 to make it inclusive
            //int calcEatenByRats = ThreadLocalRandom.current().nextInt(1, 100 + 1);
            //Author: Ken Strobell
    public static int calcEatenByRats (CropData cropData) {
            
           
            
            Random random = new Random();
            
            int RAT_BASE = 100;
            int RAT_RANGE = 1;        
            int tithesPaid = cropData.getOffering();
            int wheatInStore = cropData.getWheatInStore();
            int BUSHELS_BASE = 0;
            int BUSHELS_RANGE = 0;
            int eatenByRats = 0;
            
            int ratProblem = random.nextInt(RAT_BASE) + RAT_RANGE;
            
            if (ratProblem < 30 ){
               //3-5 random
                if (tithesPaid > 12) {
                    BUSHELS_BASE = 3;
                    BUSHELS_RANGE = 2;
                    //System.out.println("Tithes > 12");
                
                }
                //6-10 random
                if (tithesPaid < 8) { 
                    BUSHELS_BASE = 6;
                    BUSHELS_RANGE = 4;                
                    //System.out.println("Tithes <8");
                }
            
                //3-7
                if (tithesPaid >= 8 && tithesPaid <= 12) { 
                    BUSHELS_BASE = 3;
                    BUSHELS_RANGE = 4;                
                    //System.out.println("Tithes >=9 <=12");
                }
            
                //if (tithesPaid < 0) {
                //    return -1;
                //}
                //Calculate random percentage eaten by rats
                int percentEaten = random.nextInt(BUSHELS_RANGE)+ BUSHELS_BASE;
                double perEatDec = wheatInStore * (percentEaten / 100.00);
                eatenByRats = (int) Math.round(perEatDec);
                //subtract wheat eaten by rats from wheat in store
                wheatInStore = wheatInStore - eatenByRats;
                cropData.setWheatInStore(wheatInStore);
                //cropData.setEatenByRats(eatenByRats);
            }              
            cropData.setEatenByRats(eatenByRats); //moved so 0 will be written if no rat prob. JEC
            return eatenByRats;
       
    }
    
    // The feedPeople method
    // Purpose: To set aside wheat to feed the people
    // Parameters: number of bushels to set aside for food
    // Returns: number of bushels remaining in the store
    // Pre-conditions: number of bushels to set aside must be positive. 
    // and must have enough wheat in the store to fill the requested amount of food.
    // Author: Jason Chantry

    public static int feedPeople (int amountToFeedPeople, CropData cropData) throws CropException {
                      
        //Get wheatInStore
        int wheatInStore = cropData.getWheatInStore();
        
        //If amountToFeedPeople < 0 return -1
        //-1 means that the amount requested to feed the people is a negative
        //(invalid) number. Try again.
        if (amountToFeedPeople < 0) {
            throw new CropException("M'Lord, you can't take food from the people's mouths. Please enter a number greater or equal to 0.");
            //return -1;
        }
        
        //If amountToFeedPeople > wheatInStore return -2
        //-2 will tell main program that there is not enough wheat in the store
        //to fill the request. Try again.
        if (amountToFeedPeople > wheatInStore) {
            throw new CropException("M'Lord, There is not enough wheat in the storehouse to grant your request.");
            //return -2; //-2 will tell main program that there is not enough
        }

        //set wheatInStore = wheatInStore – amountToFeedPeople
        wheatInStore -= amountToFeedPeople;
        cropData.setWheatInStore(wheatInStore);
        
        //set wheatToFeedPeople = amountToFeedPeople
        cropData.setWheatForPeople(amountToFeedPeople);
        
        //return wheatInStore
        return wheatInStore;

    }
   
   // calcStarved() method
   // Purpose: Calculate how many people were not fed and decrease population
   // Parameters: int? None. 
   // Returns: num people starved
   //Author: Jason
    public static int calcStarved(CropData cropData) {
        //100 people will cost 2000 wheat
        int peopleFed = cropData.getWheatForPeople() / BUSHELS_PER_PERSON;
        int peopleStarved = 0;
        if (peopleFed < cropData.getPopulation()) {
            //Some people Starved.
            peopleStarved = cropData.getPopulation() - peopleFed;
            
        }
        //Save the number of people that starved this round
        cropData.setNumStarved(peopleStarved);
        //Calculate new population. Pop - Starved
        int newPopulation = cropData.getPopulation() - peopleStarved;
        cropData.setPopulation(newPopulation);
        return peopleStarved;
        
        
    }
 
   
   // growPopulation() method
   // Purpose: Determine how much to grow the population
   // Parameters: int? None. 
   // Returns: num people moved into city
   //Author: Jason
    public static int growPopulation(CropData cropData) {
        Random random = new Random();
        //Set base as 1 and range of 4. This is 1-5%
        int GROW_BASE = 1;
        int GROW_RANGE = 4;
        int population = cropData.getPopulation();
        
        //random number between 1 and 5%
        int randPercent = random.nextInt(GROW_RANGE) + GROW_BASE;
        //System.out.println("random %: " + randPercent);
        //convert int to double
        double randDPercent = randPercent / 100.00;
        //System.out.println("random %: " + randDPercent);
        int newPeople = (int) Math.round(population * randDPercent);
        //System.out.println("new people" + newPeople);
        
        cropData.setPopulation(population += newPeople);
        cropData.setNewPeople(newPeople);
   
        //return new people
        return newPeople;

    
    
    }
    
   // calcLandCost() method
    // Purpose: Calculate a random land cost between 17 and 26 bushels/acre
    // Parameters: none
    // Returns: the land cost
   //Author: Jason
    public static int calcLandCost(CropData cropData) {
        Random random = new Random();
        
        int LAND_BASE = 17;
        int LAND_RANGE = 10;
        
        int landPrice = random.nextInt(LAND_RANGE) + LAND_BASE;
        //Save the cost of land for this round to be referenced.
        cropData.setCostOfLandThisRound(landPrice);
        return landPrice;            
    }

}
