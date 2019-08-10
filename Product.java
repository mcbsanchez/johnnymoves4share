/**
 * Product class extends Item class
 *
 * @author Martin Christopher B. Sanchez & Earth Wendell B. Lopez
 */
public class Product extends Item
{
    /**Constructor for Product
     * @param length double val of the length
     * @param width double val of the width
     * @param height double val of the height
     * @param weight double val of the weight
     */
    public Product (double length, double width, double height, double weight)
    {
        super (length, width);
        this.height = height;
        this.weight = weight;
    }
    /** Returns the height in double val
     * @return weight - double val of the height of the product
     */
    public double getHeight()
    {
        return height;
    }
    /** Returns the weight in double val
     * @return weight - double val of the weight of the product
     */
    public double getWeight()
    {
        return weight;
    }
    //Attributes of the document
    /**
     * height - height the product has
     * weight - weight the product has
     */
    private double height;
    private double weight;

}
