public class Product extends Item
{
    public Product (double length, double width, double height, double weight)
    {
        super (length, width);
        this.height = height;
        this.weight = weight;
    }

    public double getHeight()
    {
        return height;
    }

    public double getWeight()
    {
        return weight;
    }
    private double height;
    private double weight;

}
