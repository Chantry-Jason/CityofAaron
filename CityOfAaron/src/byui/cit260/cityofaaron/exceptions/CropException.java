/**
 *
 * @author JChantry, KStrobell
 */
package byui.cit260.cityofaaron.exceptions;


public class CropException extends Exception{
    // Default constructor
    // Purpose: Initializes data members to default values
    // Parameters: none
    // Returns: none
    public CropException() { 
    
    }


    // Parameterized  constructor
    // Purpose: Initializes data members to value passed as a parameter
    // Parameters: A string containing the error message
    // Returns: none
    public CropException(String string)
    {
        super(string);
    } 
    
}
