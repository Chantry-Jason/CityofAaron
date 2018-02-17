/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.cityofaaron.control;

import byui.cit260.cityofaaron.model.CropData;
import java.io.Serializable;
import java.util.Random;

 
/**
 *
 * @author JChantry, KStrobell, JGregg
 */
public class CropControl implements Serializable{
  
    
    
    // The sellLand method
    // Purpose: To sell land
    // Parameters: the price of land and the number of acres to sell
    // Returns: the number of acres left after the sale
    // Pre-conditions: acres to sell must be positive
    // and <= acresOwned
    // Author: Ken, Jason, Josh
    public static int sellLand(int landPrice, int acresToSell, CropData cropData) {
        //if acresToSell < 0, return -1
        if (acresToSell < 0) {
            return -1;
        }
             
        //if acresToSell  > acresOwned, return -1
        int owned = cropData.getAcresOwned();
        if (acresToSell > owned) {
            return -1;
        }
        //acresOwned = acresOwned - acresToSell
        owned -= acresToSell;
        cropData.setAcresOwned(owned);
        
        //wheatInStore = wheatInStore + (acresToSell x landPrice)
        int wheat = cropData.getWheatInStore();
        wheat -= (acresToSell * landPrice);
        cropData.setWheatInStore(wheat);
        
        //return acresOwned
        return owned;

        
    }

    
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
            if (tithesPaid > 12) {
                TITHING_BASE = 2;
                TITHING_RANGE = 4;
                //System.out.println("Tithes > 12");
                
            }
            //1-3 random
            if (tithesPaid < 8) { 
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
            
            wheatInStore += wheatToHarvest;
            cropData.setWheatInStore(wheatInStore);
            cropData.setCropYield(cropYield);
            
            return wheatToHarvest;
                            
           
    }
    
    // The feedPeople method
    // Purpose: To set aside wheat to feed the people
    // Parameters: number of bushels to set aside for food
    // Returns: number of bushels remaining in the store
    // Pre-conditions: number of bushels to set aside must be positive. 
    // and must have enough wheat in the store to fill the requested amount of food.
    // Author: Jason Chantry

    public static int feedPeople (int amountToFeedPeople, CropData cropData) {
                      
        //Get wheatInStore
        int wheatInStore = cropData.getWheatInStore();
        
        //If amountToFeedPeople < 0 return -1
        //-1 means that the amount requested to feed the people is a negative
        //(invalid) number. Try again.
        if (amountToFeedPeople < 0) {
            return -1;
        }
        
        //If amountToFeedPeople > wheatInStore return -2
        //-2 will tell main program that there is not enough wheat in the store
        //to fill the request. Try again.
        if (amountToFeedPeople > wheatInStore) {
            return -2; //-2 will tell main program that there is not enough
        }

        //set wheatInStore = wheatInStore – amountToFeedPeople
        wheatInStore -= amountToFeedPeople;
        cropData.setWheatInStore(wheatInStore);
        
        //set wheatToFeedPeople = amountToFeedPeople
        cropData.setWheatForPeople(amountToFeedPeople);
        
        //return wheatInStore
        return wheatInStore;

    }
    
}
