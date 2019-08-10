/**
 * Irregular class is a subclass of Product
 *
 * @author Martin Christopher B. Sanchez & Earth Wendell B. Lopez
 */
public class Irregular extends Product
{
    //Constructor
    /**Constructor for Irregular class
     * @param length - double length of the Irregular Product Item
     * @param width - double length of the Irregular Product Item
     * @param height - double length of the Irregular Product Item
     * @param weight - double length of the Irregular Product Item
     */
    public Irregular (double length, double width, double height, double weight)
    {
        super (length, width, height, weight);
    }

    //Getter
    /**Return the volumetric weight of the Irregular Product Item
     * @return double val of the computation for volumetric weight
     */
    public double getVWeight()
    {
        return (getLength()*getWidth()*getHeight())/305.0;
    }
}
