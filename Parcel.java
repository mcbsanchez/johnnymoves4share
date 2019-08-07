import java.lang.reflect.Array;
import java.util.ArrayList;

public class Parcel {
    private double[][] size = {{9, 14, 1}, {12, 18, 3}, {12, 10, 5}, {14, 11, 7}, {18, 12, 9}, {20, 16, 12}};
    private boolean[] AVAILABLE_PARCELS = {false,false,false,false,false,false};
    private static String[] CURRENTSTATUS = {"PREPARING","SHIPPING","DELIVERED"};
    private static String[] PARCELTYPE = {"FLAT","BOX"};


    public Parcel (String destination)
    {
        if( destination.equalsIgnoreCase("Metro Manila") ||
            destination.equalsIgnoreCase("Provincial Luzon") ||
            destination.equalsIgnoreCase("Visayas") ||
            destination.equalsIgnoreCase("Mindanao"))
            this.destination = destination;
        else
            System.out.println("Error, Invalid Location, setting default to " + (this.destination = "Metro Manila"));
    }
    public void addItems(ArrayList<Item> items)
    {
        int i,j;
        double l,w,h;
        for(i = 0; i < items.size(); i++)
        {
            l = items.get(i).getLength();
            w = items.get(i).getWidth();
            if (items.get(i) instanceof Document)
            {
                h = ((Document) items.get(i)).getHeight();
            }
            else
            {
                h = ((Product) items.get(i)).getHeight();
            }
            items.get(i)
        }
    }
    private double accountWeight(Item items)
    {

    }
    public double[][] createTemporarySizes(double[][] prevSize, int row, Item item, int orientation)
    {
        double[][] nextSize;
        if(item instanceof Document)
        {
            nextSize = new double[][]{{prevSize[row][0] - ((Document) item).rotate(orientation)[0], prevSize[row][1], prevSize[row][2]},
                    {prevSize[row][0], prevSize[row][1] - ((Document) item).rotate(orientation)[1], prevSize[row][2]},
                    {prevSize[row][0], prevSize[row][1], prevSize[row][2] - ((Document) item).rotate(orientation)[2]}};
        }
        else
        {
            nextSize = new double[][]{{prevSize[row][0] - ((Product) item).rotate(orientation)[0], prevSize[row][1], prevSize[row][2]},
                    {prevSize[row][0], prevSize[row][1] - ((Product) item).rotate(orientation)[1], prevSize[row][2]},
                    {prevSize[row][0], prevSize[row][1], prevSize[row][2] - ((Product) item).rotate(orientation)[2]}};
        }
        return nextSize;
    }




    private String destination;
    private ArrayList<Item> items = new ArrayList<>();

    //length width and height

    private double[] size = new double[3];
}
