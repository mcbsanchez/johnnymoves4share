/**
 * Document class generates a given height and weight, along with the length and width from Item
 *
 * @author Martin Christopher B. Sanchez & Earth Wendell B. Lopez
 */
public class Document extends Item
{
    /**Constructor for Document extends from Item
     *
     * @param length - double length of the Item
     * @param width - double width of the Item
     * @param pages - double pages of the Item
     */
    public Document(double length, double width, int pages)
    {
        super(length,width);
        this.pages = pages;
    }

    /**
     * @return pages - int number of pages the document has
     */
    public int getPages()
    {
        return pages;
    }

    /**
     * @return height - double val of the computed height of the document given a number of pages
     */
    public double getHeight()
    {
        return (pages-1)/25 + 1;
    }

    /**
     * @return weight - double val of the computed weight of the document given a number of pages
     */
    public double getWeight()
    {
        return (pages-1)/25*.2 + 0.2;
    }

    /**
     * pages - number of pages the document has
     */
    private int pages;
}
