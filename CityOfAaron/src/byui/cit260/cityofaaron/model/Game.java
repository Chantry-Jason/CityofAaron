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
/**
 *
 * @author JChantry
 */
public class Game implements Serializable{
    
    // Class instance variables

   //private Map theMap;
    private Player thePlayer;
    private CropData cropData;
    private TeamMember[] team ;
    private ArrayList<ListItem> animals; 
    private ArrayList<ListItem> tools;
    private ArrayList<ListItem> provisions;
    
    //Main Function - entry point for the program
    //runs the main menu
    public static void main(String[] args) 
    {
        MainMenuView mmv = new MainMenuView();
        mmv.displayMenuView();       
    }
    
    //Constructor
    public Game() {

    }

//  public Map getTheMap() {
//        return theMap;
//    }

//    public void setTheMap(Map theMap) {
//        this.theMap = theMap;
//    }

    public Player getThePlayer() {
        return thePlayer;
    }

    public void setThePlayer(Player thePlayer) {
        this.thePlayer = thePlayer;
    }

    public CropData getCropData() {
        return cropData;
    }

    public void setCropData(CropData cropData) {
        this.cropData = cropData;
    }

    public TeamMember[] getTeam() {
        return team;
    }

    public void setTeam(TeamMember[] team) {
        this.team = team;
    }

    public ArrayList<ListItem> getAnimals() {
        return animals;
    }

    public void setAnimals(ArrayList<ListItem> animals) {
        this.animals = animals;
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
