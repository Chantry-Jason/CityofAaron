/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cityofaaron;

import byui.cit260.cityofaaron.model.Game;
import byui.cit260.cityofaaron.model.Player;
import byui.cit260.cityofaaron.model.TeamMember;

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
         
        
        //set and get the name from the Player class
        playerOne.setName("Fred Flinstone");
        String playerOneName = playerOne.getName();
        System.out.println("Name = " + playerOneName);
        

        

    }
    
}
