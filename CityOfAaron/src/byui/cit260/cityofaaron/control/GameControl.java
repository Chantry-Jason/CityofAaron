/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.cityofaaron.control;

import java.io.Serializable;
import java.util.ArrayList;
import byui.cit260.cityofaaron.*;
import byui.cit260.cityofaaron.model.*;
import byui.cit260.cityofaaron.control.*;



/**
 *
 * @author JChantry
 */
public class GameControl implements Serializable{
    // size of the Locations array
    private static final int MAX_ROW = 5;
    private static final int MAX_COL = 5;
    
    // reference to a Game object
    private static Game theGame;
    
    public static void createNewGame(String pName)
    {
        // Created the game object. Save it in the main driver file
            theGame = new Game();
            Game.setCurrentGame(theGame);
            
        // create the player object. Save it in the game object
        Player thePlayer = new Player();
        thePlayer.setName(pName);
        theGame.setThePlayer(thePlayer); 
        

        // create the CropData object
        
        // create the list of animals
        // create the list of tools
        //create the list of provisions
        
        // create the Locations and the Map object        
    }
// method prologue ….
    public static void createCropDataObject()
    {
        CropData theCrops = new CropData();
        
        theCrops.setYear(0);
        theCrops.setPopulation(100);
        theCrops.setNewPeople(5);
        theCrops.setCropYield(3);
        theCrops.setNumberWhoDied(0);
        theCrops.setOffering(10);
        theCrops.setWheatInStore(2700);
        theCrops.setAcresOwned(1000);
        theCrops.setAcresPlanted(1000);
        theCrops.setHarvest(3000);
        theCrops.setOfferingBushels(300);
        theCrops.setAcresPlanted(1000); 
        
        theGame.setCropData(theCrops);         
    }
    public static void createAnimalList()
    {
        ArrayList<ListItem> animals = new ArrayList<ListItem>();
        
        animals.add(new ListItem("cows", 12));
        animals.add(new ListItem("horses", 3));
        animals.add(new ListItem("pigs", 7));
        animals.add(new ListItem("goats", 4));
       
        theGame.setAnimals(animals);
    }
    public static void createToolList()
    {
        ArrayList<ListItem> tool = new ArrayList<ListItem>();
        
        tool.add(new ListItem("hammer", 12));
        tool.add(new ListItem("shovel", 3));
        tool.add(new ListItem("Axe", 7));
        tool.add(new ListItem("Plow", 4));
       
        theGame.setTools(tool);
    }
    public static void createProvisionsList()
    {
        ArrayList<ListItem> provisions = new ArrayList<ListItem>();
        
        provisions.add(new ListItem("Sugar", 12));
        provisions.add(new ListItem("prov2", 3));
        provisions.add(new ListItem("prov3", 7));
        provisions.add(new ListItem("prov4", 4));
       
        theGame.setProvisions(provisions);
    }
    // The createMap method
    // Purpose: creates the location objects and the map
    // Parameters: none
    // Returns: none
    public static void createMap()   
    {
        // create the Map object, it is 5 x 5
        // refer to the Map constructor
        Map theMap = new Map(MAX_ROW, MAX_COL);
        
        
        //********************************************************************
        //** River Col 0-4, 4
        // create a string that will go in the Location objects
        // that contain the river
        String river = "\nYou are on the River. The river is the source" +
                       "\nof life for our city. The river marks the eastern " +
                       "\nboundary of the city - it is wilderness to the East.";

        // create a new Location object
        Location loc = new Location();

        // use setters in the Location class to set the description and symbol
        loc.setDescription(river);
        loc.setSymbol("~~~");  

        // set this location object in each cell of the array in column 4      
        for(int i = 0; i < MAX_ROW; i++)
        {
            theMap.setLocation(i, 4, loc);
        }
    
        //********************************************************************
        //** Hint for Loc 0,2
        // define the string for a farm land location
        String farmland = "\nYou are on the fertile banks of the River." +
        "\nIn the springthis low farmland floods and is covered with rich" +
        "\nnew soil. Wheat is planted as far as you can see."; 

        // set a farmland location with a hint
        loc = new Location();
        loc.setDescription(farmland + "\nOne bushel will plant two acres of wheat.");
        loc.setSymbol("!!!");
        theMap.setLocation(0, 2, loc);
    
       
        
        
        
        
        
        
        theGame.setTheMap(theMap);

        
    }






}
