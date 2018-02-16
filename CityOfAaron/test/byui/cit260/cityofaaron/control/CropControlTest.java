/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.cityofaaron.control;

import byui.cit260.cityofaaron.model.CropData;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author JChantry
 */
public class CropControlTest {
    
    public CropControlTest() {

    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of sellLand method, of class CropControl.
     */
    @Test
    public void testSellLand() {
      
        System.out.println("sellLand Test Case 1");
        CropData theCrops = new CropData();
        theCrops.setWheatInStore(1000);
        theCrops.setAcresOwned(2800);
        int toSell = 10;
        int landCost = 20;
        int expResult = 2790;
        int result = CropControl.sellLand(landCost, toSell, theCrops);
        assertEquals(expResult, result);
         
        System.out.println("sellLand Test Case 2");
        
        theCrops.setWheatInStore(1000);
        theCrops.setAcresOwned(2800);
        toSell = -5;
        landCost = 20;
        expResult = -1;
        result = CropControl.sellLand(landCost, toSell, theCrops);
        assertEquals(expResult, result);     

        System.out.println("sellLand Test Case 3");
        theCrops.setWheatInStore(1000);
        theCrops.setAcresOwned(2800);
        toSell = 3000;
        landCost = 20;
        expResult = -1;
        result = CropControl.sellLand(landCost, toSell, theCrops);
        assertEquals(expResult, result);        

        System.out.println("sellLand Test Case 4");
        theCrops.setWheatInStore(1000);
        theCrops.setAcresOwned(2000);
        toSell = 2000;
        landCost = 10;
        expResult = 0;
        result = CropControl.sellLand(landCost, toSell, theCrops);
        assertEquals(expResult, result);        
        
        System.out.println("sellLand Test Case 5");
        theCrops.setWheatInStore(1000);
        theCrops.setAcresOwned(2000);
        toSell = 0;
        landCost = 10;
        expResult = 2000;
        result = CropControl.sellLand(landCost, toSell, theCrops);
        assertEquals(expResult, result);        
        
        

    }

    /**
     * Test of harvestCrops method, of class CropControl.
     
    @Test
    public void testHarvestCrops() {
        System.out.println("harvestCrops");
        CropData cropData = null;
        int expResult = 0;
        int result = CropControl.harvestCrops(cropData);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    * */
    
}
