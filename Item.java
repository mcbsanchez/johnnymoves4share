/**
 * Item class is the main class of Document
 *
 * @author Martin Christopher B. Sanchez & Earth Wendell B. Lopez
 */
public abstract class Item
{
    //Constructor
    /**Constructor for Item
     * @param length - double length of the item
     * @param width - double width of the item
     */
    public Item (double length, double width)
    {
        this.length = length;
        this.width = width;
    }

    //Methods
    /**Rotate return a double[] value of the specific orientation given "this"(item)'s length,width and height
     * @param orientation - int value that asks for 6 different rotational movements from 0-5
     * @return dimensions - double[] that give a certain arrangement of the length(l), width(w), and height(h)
     */

    //Getters
    public double[] rotate(int orientation)
    {
        double l = getLength();
        double h = getHeight();
        double w = getWidth();
        double[] dimensions = {l, w, h};
        if(orientation == 1)
            dimensions = new double[]{h, l, w};
        else if(orientation == 2)
            dimensions = new double[]{h, w, l};
        else if(orientation == 3)
            dimensions = new double[]{w, l, h};
        else if(orientation == 4)
            dimensions = new double[]{l, h, w};
        else if(orientation == 5)
            dimensions = new double[]{w, h, l};
        return dimensions;
    }
    /**Returns the length of the item
     * @return length - double val length of the item
     */
    public double getLength()
    {
        return length;
    }
    /**Returns the length of the item
     * @return length - double val width of the item
     */
    public double getWidth()
    {
        return width;
    }
    /**Returns the length of the item
     * @return length - double val height of the item
     */
    public abstract double getHeight();
    /**Returns the length of the item (abstract, depends on instance)
     * @return length - double val weight of the item
     */
    public abstract double getWeight();

    /**Attributes of the item (abstract, depends on instance)
     * length and width are stored in the Item class as every sub class has this
     */
    private double length;
    private double width;

}
