public class Irregular extends Product
{
    public Irregular (double length, double width, double height, double weight)
    {
        super (length, width, height, weight);
    }
    public double getVWeight()
    {
        return (getLength()*getWidth()*getHeight())/305.0;
    }
}
