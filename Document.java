public class Document extends Item
{
    public Document(double length, double width, int pages)
    {
        super(length,width);
        this.pages = pages;
    }

    public int getPages()
    {
        return pages;
    }

    public double getHeight()
    {
        return (pages-1)/25 + 1;
    }

    public double getWeight()
    {
        return (pages-1)/25*.2 + 0.2;
    }

    private int pages;
}
