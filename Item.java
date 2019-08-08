public abstract class Item
{
    public Item (double length, double width)
    {
        this.length = length;
        this.width = width;
    }

    public double getLength()
    {
        return length;
    }
    public double getWidth()
    {
        return width;
    }
    public abstract double getHeight();
    public abstract double getWeight();
    public double[] rotate(int orientation)
    {
        double l = getLength();
        double h = getHeight();
        double w = getWidth();
        double[] dimensions = new double[]{l,w,h};
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
    private double length;
    private double width;
}
