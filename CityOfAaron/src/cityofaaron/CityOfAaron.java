/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cityofaaron;

import byui.cit260.cityofaaron.model.CropData;
import byui.cit260.cityofaaron.model.Game;
import byui.cit260.cityofaaron.model.Location;
import byui.cit260.cityofaaron.model.Player;
import byui.cit260.cityofaaron.model.TeamMember;
import byui.cit260.cityofaaron.model.ListItem;




/**
 *
 * @author JChantry
 */
public class CityOfAaron {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Player playerOne = new Player();
        Location gameLocation = new Location(); 
        ListItem gameList = new ListItem();
        CropData gameCrop = new CropData();
        
        //set and get the name from the Player class
        playerOne.setName("Fred Flinstone");
        String playerOneName = playerOne.getName();
        System.out.println("Name = " + playerOneName);
        
        //print separator
        System.out.println("****************************************");
        
        //set and get description and symbol from location class
        gameLocation.setDescription("Aaron's House");
        gameLocation.setSymbol("Hse:Ar");
        String locationDescription = gameLocation.getDescription();
        String locationSymbol = gameLocation.getSymbol();
        System.out.println("Location Description: " + locationDescription);
        System.out.println("Location Symbol: " + locationSymbol);
        
        //print separator
        System.out.println("****************************************");
        
        //set and get description and symbol from ListItem class
        gameList.setName("Abraham's Sword");
        gameList.setNumber(2);
        String itemName = gameList.getName();
        int itemNumber = gameList.getNumber();
        System.out.println("Item Name: " + itemName);
        System.out.println("Item Number: " + itemNumber);
        
        
        //print separator
        System.out.println("****************************************");
        
        //set and get description and symbol from CropData class
        gameCrop.setAcresOwned(100);
        gameCrop.setAcresPlanted(50);
        int cropAcresOwned = gameCrop.getAcresOwned();
        int cropAcresPlanted = gameCrop.getAcresPlanted();
        System.out.println("CropData Acres Owned: " + cropAcresOwned);
        System.out.println("CropData Acres Planted: " + cropAcresPlanted);
        


        
    }
    
}
