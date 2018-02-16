/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.cityofaaron.control;

import byui.cit260.cityofaaron.model.CropData;
import java.io.Serializable;
import java.util.concurrent.ThreadLocalRandom;
 
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
            
            
            int cropYield = cropData.getCropYield();
            int tithesPaid = cropData.getOffering();
            int wheatInStore = cropData.getWheatInStore();
            int acresPlanted = cropData.getAcresPlanted();
            
            if (tithesPaid > 12) {
                cropYield = ThreadLocalRandom.current().nextInt(2 , 5 + 1);
                
            }
            
            if (tithesPaid < 8) { 
                cropYield = ThreadLocalRandom.current().nextInt(1 , 3 + 1);
                
            }
            
            if (tithesPaid >= 9 && tithesPaid <= 12) { 
                cropYield = ThreadLocalRandom.current().nextInt(2 , 4 + 1);
                
            }
            
            if (tithesPaid < 0) {
                return -1;
            }
                    
            int wheatToHarvest = acresPlanted * cropYield;
            
            wheatInStore += wheatToHarvest;
            cropData.setWheatInStore(wheatInStore);
            cropData.setCropYield(cropYield);
            
            return wheatToHarvest;
                            
           
    }
    
}
