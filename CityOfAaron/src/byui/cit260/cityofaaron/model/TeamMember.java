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
public enum TeamMember implements Serializable {
    
    Jason("Jason", "He is one of the team members of the team."),
    Ken("Ken", "He is one of the team members of the team."),
    Joshua("Joshua", "He is one of the team members of the team.");
    
    private String name;
    private String title;

    TeamMember(String name, String title) {
        this.name = name;
        this.title = title;
 
    }
   
    @Override
    public String toString() {
        return "TeamMember{" + "name=" + name + ", title=" + title + '}';
    }
    

    
}
