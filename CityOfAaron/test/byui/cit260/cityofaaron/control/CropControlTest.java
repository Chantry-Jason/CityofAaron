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
     * Test of feedPeople method, of class CropControl.
     * Author: JChantry
     */
    @Test
    public void testFeedPeople() {
        System.out.println("feedPeople Test Case 1");
        CropData theCrops = new CropData();
        theCrops.setWheatInStore(2000);
        int amountToFeedPeople = 500;
        int expResult = 1500;
        int result = CropControl.feedPeople(amountToFeedPeople, theCrops);
        assertEquals(expResult, result);
        
        System.out.println("feedPeople Test Case 2");
        theCrops.setWheatInStore(1500);
        amountToFeedPeople = 750;
        expResult = 750;
        result = CropControl.feedPeople(amountToFeedPeople, theCrops);
        assertEquals(expResult, result);
        
        System.out.println("feedPeople Test Case 3");
        theCrops.setWheatInStore(2000);
        amountToFeedPeople = -5;
        expResult = -1;
        result = CropControl.feedPeople(amountToFeedPeople, theCrops);
        assertEquals(expResult, result);

        System.out.println("feedPeople Test Case 4");
        theCrops.setWheatInStore(2000);
        amountToFeedPeople = 2500;
        expResult = -2;
        result = CropControl.feedPeople(amountToFeedPeople, theCrops);
        assertEquals(expResult, result);     

        System.out.println("feedPeople Test Case 5");
        theCrops.setWheatInStore(3000);
        amountToFeedPeople = -200;
        expResult = -1;
        result = CropControl.feedPeople(amountToFeedPeople, theCrops);
        assertEquals(expResult, result);
        
        System.out.println("feedPeople Test Case 6");
        theCrops.setWheatInStore(2500);
        amountToFeedPeople = 0;
        expResult = 2500;
        result = CropControl.feedPeople(amountToFeedPeople, theCrops);
        assertEquals(expResult, result);
        
        System.out.println("feedPeople Test Case 7");
        theCrops.setWheatInStore(2500);
        amountToFeedPeople = 2500;
        expResult = 0;
        result = CropControl.feedPeople(amountToFeedPeople, theCrops);
        assertEquals(expResult, result);
        
        System.out.println("feedPeople Test Case 8");
        theCrops.setWheatInStore(500);
        amountToFeedPeople = 500;
        expResult = 0;
        result = CropControl.feedPeople(amountToFeedPeople, theCrops);
        assertEquals(expResult, result);
    }

    /**
     * Test of harvestCrops method, of class CropControl. Author: Ken Strobell
     */
    @Test
    public void testHarvestCrops() {
        int expResult = 0;
        //Test Case 1 ********************************************
        System.out.println("harvestCrops Test Case 1");
        CropData theCrops = new CropData();
        theCrops.setOffering(12);
        theCrops.setWheatInStore(2000);
        theCrops.setAcresPlanted(20);
        //Run the method
        int result = CropControl.harvestCrops(theCrops);
        
        //Account for random numbers generated. Read in cropYield and set expResult
        //for each random possibility.
        int cropYield = theCrops.getCropYield();
        System.out.println("get cropYield: " + cropYield);
        if (cropYield == 2) {expResult = 40;}
        if (cropYield == 3) {expResult = 60;}
        if (cropYield == 4) {expResult = 80;}        
        assertEquals(expResult, result);
        
        //Test Case 2 ********************************************
        System.out.println("harvestCrops Test Case 2");
        theCrops.setOffering(5);
        theCrops.setWheatInStore(2500);
        theCrops.setAcresPlanted(5);
        //Run the method
        result = CropControl.harvestCrops(theCrops);
        
        //Account for random numbers generated. Read in cropYield and set expResult
        //for each random possibility.
        cropYield = theCrops.getCropYield();
        System.out.println("get cropYield: " + cropYield);
        if (cropYield == 1) {expResult = 5;}
        if (cropYield == 2) {expResult = 10;}
        if (cropYield == 3) {expResult = 15;}        
        assertEquals(expResult, result);

        /*
        //Test Case 3 Invalid does not work well with random number generators********************************************
        System.out.println("harvestCrops Test Case 3 Invalid");
        theCrops.setOffering(0);
        theCrops.setWheatInStore(2000);
        theCrops.setAcresPlanted(0);
        //Run the method
        result = CropControl.harvestCrops(theCrops);
        
        //Account for random numbers generated. Read in cropYield and set expResult
        //for each random possibility.
        cropYield = theCrops.getCropYield();
        System.out.println("get cropYield: " + cropYield);
        if (cropYield == 0) {expResult = 0;}       
        assertEquals(expResult, result);
        */
        
        //Test Case 4 boundary ********************************************
        System.out.println("harvestCrops Test Case 4");
        theCrops.setOffering(1);
        theCrops.setWheatInStore(2000);
        theCrops.setAcresPlanted(10);
        //Run the method
        result = CropControl.harvestCrops(theCrops);
        
        //Account for random numbers generated. Read in cropYield and set expResult
        //for each random possibility.
        cropYield = theCrops.getCropYield();
        System.out.println("get cropYield: " + cropYield);
        if (cropYield == 1) {expResult = 10;}
        if (cropYield == 2) {expResult = 20;}
        if (cropYield == 3) {expResult = 30;}        
        assertEquals(expResult, result);
        
        //Test Case 5 boundary ********************************************
        System.out.println("harvestCrops Test Case 5");
        theCrops.setOffering(15);
        theCrops.setWheatInStore(2000);
        theCrops.setAcresPlanted(20);
        //Run the method
        result = CropControl.harvestCrops(theCrops);
        
        //Account for random numbers generated. Read in cropYield and set expResult
        //for each random possibility.
        cropYield = theCrops.getCropYield();
        System.out.println("get cropYield: " + cropYield);
        if (cropYield == 2) {expResult = 40;}
        if (cropYield == 3) {expResult = 60;}
        if (cropYield == 4) {expResult = 80;}        
        assertEquals(expResult, result);
        
    }


    
}
