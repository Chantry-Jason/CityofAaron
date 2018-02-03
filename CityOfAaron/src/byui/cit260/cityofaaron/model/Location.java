/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.cityofaaron.model;

import java.io.Serializable;
/**
 *
 * @author JChantry
 */
public class Location implements Serializable {
    // Class instance variables
    private String description;
    private String symbol;
    
    //Constructor
    public Location () {
        
    }

    //Getter Methods
    public String getDescription() {
        return description;
    }

    public String getSymbol() {
        return symbol;
    }

    //Setter Methods
    public void setDescription(String description) {
        this.description = description;
    }
    
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
    
    
    
}
