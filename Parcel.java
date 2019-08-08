import java.util.ArrayList;

public class Parcel {
    private boolean[] available = {false,false,false,false,false,false};
    private static String[] CURRENTSTATUS = {"PREPARING","SHIPPING","DELIVERED"};
    private static String[] PARCELTYPE = {"FLAT","BOX"};
    private String recipient;
    private String destination;
    private int countItems;


    public Parcel (String recipient, String destination, int countItems) {
        this.recipient = recipient;
        this.destination = destination;
        this.countItems = countItems;
    }

    public void addItem(ArrayList<Item> items, double[][]size) {
        /*
        i - number of spaces
        j - number of rotations
        k - number of sides
        c - number of difference above negative
         */
        int i, j, k, c = 0;
        boolean tempAvailable[] = {false, false, false, false, false, false};
        if (items.size() == 1)
            if (!isTooHeavy(items))
            {
                for (i = 0; i < 2; i++)
                    for (j = 0; j < 6; j++)
                    {
                        for (k = 0; k < 3; k++)
                        {
                            if (size[i][k] > items.get(i).rotate(j)[k])
                                c++;
                            if (c == 3)
                                available[i] = true;
                        }
                        c = 0;
                    }
            }
            else
            {
                for (i = 2; i < 6; i++)
                    for (j = 0; j < 6; j++)
                    {
                        for (k = 0; k < 3; k++)
                        {
                            if (size[i][k] > items.get(i).rotate(j)[k])
                                c++;
                            if (c == 3)
                                available[i] = true;
                        }
                        c = 0;
                    }
            }
        else
        {
            if (!isTooHeavy(items))
            {
                for (i = 0; i < 2; i++)
                {
                    for (j = 0; j < 6; j++)
                    {
                        for (k = 0; k < 3; k++)
                        {
                            if (size[i][k] > items.get(i).rotate(j)[k])
                                c++;
                            if (c == 3)
                                tempAvailable[j] = true;
                        }
                        c = 0;
                    }
                    for (j = 0; j < 6; j++) {
                        if (tempAvailable[j])
                            available[i] = isFit(createNewSpace(size, i, items.get(i).rotate(j)), items);
                        tempAvailable[j] = false;
                    }
                }
            }
            else{
                for (i = 2; i < 6; i++)
                {
                    for (j = 0; j < 6; j++)
                    {
                        for (k = 0; k < 3; k++)
                        {
                            if (size[i][k] > items.get(i).rotate(j)[k])
                                c++;
                            if (c == 3)
                                tempAvailable[j] = true;
                        }
                        c = 0;
                    }
                    for (j = 0; j < 6; j++) {
                        if (tempAvailable[j])
                            available[i] = isFit(createNewSpace(size, i, items.get(i).rotate(j)), items);
                        tempAvailable[j] = false;
                    }
                }
            }
        }

    }
    private double[][]createNewSpace(double[][] size,int i, double[] item)
    {
        return new double[][]{  {size[i][0] - item[0], size[i][1], size[i][2]},
                                {size[i][0], size[i][1] - item[1], size[i][2]},
                                {size[i][0], size[i][1], size[i][2] - item[2]}};
    }
    private boolean isFit(double[][] size, ArrayList<Item> items)
    {
        int i, j, k, c = 0;
        boolean condition = false;
        if(items.size() == 0)
            condition = true;
        else
        {
            items.remove(0);
            for(i = 0; i < 3; i++)
                for(j = 0; j < 6; j++)
                    for(k = 0; k < 3; k++)
                    {
                        if ((size[i][k] > items.get(i).rotate(j)[k]))
                            c++;
                        if (c == 3)
                            condition = isFit(createNewSpace(size,i,items.get(i).rotate(j)),items);
                    }
        }
        return condition;

    }

    private boolean isTooHeavy(ArrayList<Item> items)
    {
        int i;
        double totalWeight = 0;
        for(i = 0; i < items.size(); i++)
        {
            totalWeight += items.get(i).getWeight();
        }
        return totalWeight > 3;
    }
}
