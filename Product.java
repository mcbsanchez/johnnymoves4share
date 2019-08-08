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
    /*
    to be used by loop method in fitItem
    0 - l,w,h ; 1 - h,l,w ; 2 - h,w,l
    3 - w,l,h ; 4 - l,h,w ; 5 - w,h,l
    */
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
}
