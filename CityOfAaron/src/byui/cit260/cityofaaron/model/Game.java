// The City of Aaron Game
// The driver file, contains the main() method
// Author: JChantry, KStrobell, JGregg
// Date last modified: February 2018
//-------------------------------------------------------------

package byui.cit260.cityofaaron.model;

import java.io.Serializable;
import java.util.Objects;
import java.util.ArrayList;
import byui.cit260.cityofaaron.view.*;
import byui.cit260.cityofaaron.model.Game;
import byui.cit260.cityofaaron.control.*;

/**
 *
 * @author JChantry
 */
public class Game implements Serializable{

    // Class instance variables

   //private Map theMap;
    private  Player thePlayer;
    //private static CropData cropData;
    private  CropData theCrops;
    private  TeamMember[] team ;
    private  ArrayList<ListItem> animals; 
    private  ArrayList<ListItem> tools ;
    private  ArrayList<ListItem> provisions;
    

    private static Game theGame;
    //private static CropData theCropData = theGame.getCropData();
    //private CropData theCrops;
    private  Map theMap;



/*  public static void setErrorLog(PrintWriter printWriter){

    }
    public PrintWriter getErrorLog(){

    }
*/
    //Constructor
    public Game() {

    }

    public Map getTheMap() {
        return theMap;
    }

    public void setTheMap(Map theMap) {
        this.theMap = theMap;
    }
    // the getCrops() method
    // Purpose: get a reference to the crop object
    // Parameters: none
    // Returns: a reference to a crop object
    public CropData getCrop()
    {
        return theCrops;
    }
    
    // the setCrops() method
    // Purpose: store a reference to a crop object
    // Parameters: a reference to a crop object
    // Returns: none    
    public void setCrop(CropData _cropRef)
    {
        theCrops = _cropRef;
    }
    public static void setCurrentGame(Game game){
        theGame = game;
    }
    public static Game getCurrentGame(){
        return theGame;
    }
    public Player getThePlayer() {
        return thePlayer;
    }

    public void setThePlayer(Player thePlayer) {
        this.thePlayer = thePlayer;
    }

    public CropData getCropData() {
        //return cropData;
        return theCrops;
    }

    public void setCropData(CropData cropData) {
        //this.cropData = cropData;
        this.theCrops = cropData;
    }

    public TeamMember[] getTeam() {
        return team;
    }

    public void setTeam(TeamMember[] team) {
        this.team = team;
    }

    public ArrayList<ListItem> getAnimals(){
        return animals;
    }

    public void setAnimals(ArrayList<ListItem> animals) {
        //public void setAnimals(string[] name, int[] numObj) {
        this.animals = new ArrayList<ListItem>(animals);
    }

    public ArrayList<ListItem> getTools() {
        return tools;
    }

    public void setTools(ArrayList<ListItem> tools) {
        this.tools = tools;
    }

    public ArrayList<ListItem> getProvisions() {
        return provisions;
    }

    public void setProvisions(ArrayList<ListItem> provisions) {
        this.provisions = provisions;
    }



    

    
    
    
}
