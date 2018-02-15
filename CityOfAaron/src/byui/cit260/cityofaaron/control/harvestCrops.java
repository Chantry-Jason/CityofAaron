/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.cityofaaron.control;

/**
 *
 * @author kenpc
 */

import java.util.concurrent.ThreadLocalRandom;
import acresPlanted
import wheatInStore
import tithesPaid
        
//our min and max ranges
 
//int max = 5;
//int min = 1;

public class harvestCrops {

    Random randomNum = new Random();
    
    public static int harvestCrops ()
            
            // nextInt is normally exclusive of the top value,
            // so add 1 to make it inclusive
            //int cropYield = ThreadLocalRandom.current().nextInt(2, 5 + 1);
            
            int cropYield () {
            if (tithesPaid > 12) { cropYield = ThreadLocalRandom.current(2 , 5 + 1)
                return cropYield;
            }
            
            if (tithesPaid < 8) { cropYield = ThreadLocalRandom.current(1 , 3 + 1)
                return cropYield;
            }
            
            if (tithesPaid >= 9 & <= 12) { cropYield = ThreadLocalRandom.current(2 , 4 + 1)
                return cropYield;
            }
            
            if (tithesPaid < 0) { )
                return -1;
            }
    }    
            private int wheatToHarvest ()
            int wheatToHarvest = { acresPlanted * cropYield
            }
            int wheatInStore = {wheatInStore + wheatToHarvest
                    return wheatToHarvest
                            }
           
    }
    
    
}
