
/**
 *
 * @author Ken, Jason
 */
package byui.cit260.cityofaaron.model;

import java.io.Serializable;

public class ListItem implements Serializable{
    
    //class instance variales
    private String name;
    private int number;
    public ListItem(String name, int i) {
        this.name = name;
        this.number = i;        
    }
    public String getName() {
        return name;
    }
    public int getNumber() {
        return number;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(int number) {
        this.number = number;
    }
    
}
