
import byui.cit260.cityofaaron.control.Map;
import byui.cit260.cityofaaron.model.CropData;
import byui.cit260.cityofaaron.model.Game;
import byui.cit260.cityofaaron.view.MainMenuView;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author JChantry
 */
public class Main {
    private static Game theGame;
    private CropData theCrops;
    private Map theMap;

    //Main Function - entry point for the program
    //runs the main menu
    public static void main(String[] args) 
    {
        MainMenuView mmv = new MainMenuView();
        
        mmv.displayMenu();
    }   
}
