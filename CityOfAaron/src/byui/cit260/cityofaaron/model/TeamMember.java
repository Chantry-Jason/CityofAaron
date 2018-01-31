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
    
    Jason("Jason", "He is one of the team members of the team.", new Point(1,1)),
    Ken("Ken", "He is one of the team members of the team.", new Point(1,2)),
    Joshua("Joshua", "He is one of the team members of the team.", new Point(1,3));    
    private String name;
    private String title;
    private Point coordinates;

    TeamMember(String name, String title, Point coordinates) {
        this.name = name;
        this.title = title;
        this.coordinates = coordinates;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Point getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Point coordinates) {
        this.coordinates = coordinates;
    }

    @Override
    public String toString() {
        return "TeamMember{" + "name=" + name + ", title=" + title + ", coordinates=" + coordinates + '}';
    }
    

    
}
