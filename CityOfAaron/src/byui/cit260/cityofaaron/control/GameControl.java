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

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Arrays;



/**
 *
 * @author JChantry
 */
public class GameControl implements Serializable{
    // size of the Locations array
    private static final int MAX_ROW = 6;
    private static final int MAX_COL = 6;
    
    // reference to a Game object
    private static Game theGame;
    
    public static void createNewGame(String pName)
    {
        // Created the game object. Save it in the main driver file
        theGame = new Game();
        //Game.setCurrentGame(theGame);
        CityOfAaron.Main.setTheGame(theGame);
        // create the player object. Save it in the game object
        Player thePlayer = new Player();
        thePlayer.setName(pName);
        //System.out.println("/npname passed to createNewGame: " + pName );
        theGame.setThePlayer(thePlayer); 
        //System.out.println("/nthePlayer in createNewGame: " + thePlayer );
        

        // create the CropData object
        createCropDataObject();
        // create the list of animals
        createAnimalList();
        // create the list of tools
        createToolList();
        //create the list of provisions
        createProvisionsList();
        // create the Locations and the Map object  
        createMap();
    }
// method prologue ….
    public static void createCropDataObject()
    {
        CropData theCrops = new CropData();
        //System.out.println("running createCropDataObject");
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
    public static ArrayList<ListItem> createAnimalList()
    {
        ArrayList<ListItem> animals = new ArrayList<>();
        
        animals.add(new ListItem("cows", 12));
        animals.add(new ListItem("horses", 3));
        animals.add(new ListItem("pigs", 7));
        animals.add(new ListItem("goats", 4));
       
        theGame.setAnimals(animals);
        
        return animals;
    }
    public static ArrayList<ListItem> createToolList()
    {
        ArrayList<ListItem> tool = new ArrayList<>();
        
        tool.add(new ListItem("hammer", 12));
        tool.add(new ListItem("shovel", 3));
        tool.add(new ListItem("Axe", 7));
        tool.add(new ListItem("Plow", 4));
       
        theGame.setTools(tool);
        return tool;
    }
    public static ArrayList<ListItem> createProvisionsList()
    {
        ArrayList<ListItem> provisions = new ArrayList<>();
        
        provisions.add(new ListItem("Sugar", 12));
        provisions.add(new ListItem("prov2", 3));
        provisions.add(new ListItem("prov3", 7));
        provisions.add(new ListItem("prov4", 4));
       
        theGame.setProvisions(provisions);
        return provisions;
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
        //System.out.println("createMap: " + MAX_ROW + " x " + MAX_COL);
        
        //********************************************************************
        //** River Col 0-4, 4
        // create a string that will go in the Location objects
        // that contain the river
        //System.out.println("creating river");
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
        //System.out.println("creating farmland hint 0,2");
        String farmland = "\nYou are on the fertile banks of the River." +
        "\nIn the spring this low farmland floods and is covered with rich" +
        "\nnew soil. Wheat is planted as far as you can see."; 

        // set a farmland location with a hint
        loc = new Location();
        loc.setDescription(farmland + "\nHint: One bushel will plant two acres of wheat.");
        loc.setSymbol("!!!");
        theMap.setLocation(0, 2, loc);
    
        //********************************************************************
        //** Hint for Loc 2,0
        // define the string for a farm land location
        //System.out.println("creating farmland hint 2,0");
        String farmland2 = "\nYou are on farmland with rich soil" +
        "\nThis farmland is next to the desert so don't plant rice here," +
        "\nit's too hot! Nothing is currently planted in this field."; 

        // set a farmland location with a hint
        loc = new Location();
        loc.setDescription(farmland2 + "\nHint: Twenty bushels of wheat is needed to feed" +
        "one person.");
        loc.setSymbol("---");
        theMap.setLocation(2, 0, loc);  
        
        //********************************************************************
        //** Desert  0-1, 0-1
        // create a string that will go in the Location objects
        // that contain the Desert
        //System.out.println("creating desert");
        String desert = "\nYou are in the Desert. The desert is where criminals" +
                       "\nare banished. It is sand and bones as far as the eye" +
                       "\ncan see. The desert is the North West boundary of the map.";



        // use setters in the Location class to set the description and symbol
        loc.setDescription(desert);
        loc.setSymbol("@@@");  

        // set this location object in each cell 0,0 to 1,1      
        for(int i = 0; i < 1; i++)
        {
            theMap.setLocation(i, 0, loc);
            theMap.setLocation(i, 1, loc);
        }
        //********************************************************************
        //** Farmland, WheatFields Pos 0-4, 3
        // create a string that will go in the Location objects
        // that contain the Farmland - wheatfields
        String farmWheat = "\nYou are in the Desert. The desert is where criminals" +
                       "\nare banished. It is sand and bones as far as the eye" +
                       "\ncan see. The desert is the North West boundary of the map.";



        // use setters in the Location class to set the description and symbol
        loc.setDescription(farmWheat);
        loc.setSymbol("!!!");  

        // set this location object in each cell       
        for(int i = 0; i < 4; i++)
        {
            theMap.setLocation(i, 3, loc);
 
        }        
       //********************************************************************
        //** Wilderness,  Pos 0-5, 5
        // create a string that will go in the Location objects
        // that contain the wilderness
        String wilderness = "\nYou are in the wilderness. Off in the distance" +
                       "\nyou can see settlements of Lamanites who want to pillage" +
                       "\nyour city for gain. Better keep an eye on them!";



        // use setters in the Location class to set the description and symbol
        loc.setDescription(wilderness);
        loc.setSymbol("fff");  

        // set this location object in each cell       
        for(int i = 0; i < MAX_ROW; i++)
        {
            theMap.setLocation(i, 5, loc);
 
        }         
        
        
        theGame.setTheMap(theMap);

        
    }

    // the getSavedGame method
    // Purpose: load a saved game from disk
    // Parameters: the file path
    // Returns: none
    // Side Effect: the game reference in the driver is updated
    public static void getSavedGame(String filePath)
    {
        Game theGame = null;
        
        try (FileInputStream fips = new FileInputStream(filePath))
        {
            ObjectInputStream input = new ObjectInputStream(fips);
            //theGame = (Game)  input.readObject();
            theGame = (Game) input.readObject();
            CityOfAaron.Main.setTheGame(theGame);
        }
        catch(Exception e)
        {
            System.out.println("\nThere was an error reading the saved game file");
        }
    }

    // the saveGame method
    // Purpose: save a saved game from disk
    // Parameters: the file path
    // Returns: none
    // Side Effect: the game reference in the driver is updated
    public static void saveGame(String filePath) 
    {
        Game theGame = CityOfAaron.Main.getTheGame();
        //theGame = new Game();
        try (FileOutputStream fops = new FileOutputStream(filePath))
        {
            ObjectOutputStream out = new ObjectOutputStream(fops);
            out.writeObject(theGame);
        }
        catch(Exception e)
        {
            System.out.println("\nThere was an error saving the game file. " + e.getMessage());
        }
    }

    // the printWriter method
    // Purpose: save a list to disk
    // Parameters: the file path, the object, the name of the list.
    // Returns: none. Will print success message.
    
    public static void printWriter(String filePath, ArrayList<ListItem> inventoryItems, String ListName) 
    {
        
        //theGame = new Game();
        try (PrintWriter pwout = new PrintWriter(filePath))
        {
            pwout.println("\n\n   " + ListName + " Inventory Report                ");
            
            pwout.printf("%n%-20s%10s", ListName, "Quantity");
            pwout.printf("%n%-20s%10s", "------", "--------"); 
            for (ListItem item : inventoryItems) {
                pwout.printf("%n%-20s%7d", item.getName(), item.getNumber());
               
                //System.out.println(item.getName());
                //System.out.println(item.getNumber());
            }
            System.out.println("\nReport was saved to " + filePath + " successfully!");
            pwout.close();
        }
        catch(Exception e)
        {
            System.out.println("\nThere was an error saving the the list to disk. " + e.getMessage());
        }
    }

}
