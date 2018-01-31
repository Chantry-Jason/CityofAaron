/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.cityofaaron.model;

import java.io.Serializable;
import java.util.Objects;
/**
 *
 * @author JChantry
 */
public class Game implements Serializable{
    
    // Class instance variables

    Map theMap = new Map();
    Player thePlayer = new Player();
    CropData cropData = new CropData();
    TeamMember team[] = new TeamMember(); //Not Sure
    private ArrayList<ListItem> animals = new ArrayList<ListItem>(); //Not Sure
    private ArrayList<ListItem> tools = new ArrayList<ListItem>();  //Not Sure
    ListItem provisions = new ListItem();
    
    public Game() {
        
    }

    public Map getTheMap() {
        return theMap;
    }

    public void setTheMap(Map theMap) {
        this.theMap = theMap;
    }

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

    public <any> getAnimals() {
        return animals;
    }

    public void setAnimals(<any> animals) {
        this.animals = animals;
    }

    public <any> getTools() {
        return tools;
    }

    public void setTools(<any> tools) {
        this.tools = tools;
    }

    public ListItem getProvisions() {
        return provisions;
    }

    public void setProvisions(ListItem provisions) {
        this.provisions = provisions;
    }
    
    
}
