import javax.swing.*;
import java.util.ArrayList;

public class Parcel {
    private boolean[] available = {false,false,false,false,false,false};
    private static String[] CURRENTSTATUS = {"PREPARING","SHIPPING","DELIVERED"};
    private static String[] PARCELTYPE = {"FLAT","BOX"};
    private String recipient;
    private String destination;
    private int countItems;
    private ArrayList <Item> items;


    public Parcel (String recipient, String destination, int countItems)
    {
        this.recipient = recipient;
        this.destination = destination;
        this.countItems = countItems;
    }

    public void addItem (ArrayList<Item> items)
    {
        this.items = items;
    }

    public double[][] showAvailableParcels(double[][]size)
    {
        /*
        i - number of spaces
        j - number of rotations
        k - number of sides
        c - number of difference above negative
         */
        int i, j, k, c = 0;
        boolean tempAvailable[] = {false, false, false, false, false, false};
        this.items = items;
        if (items.size() == 1)
        {
            if (!isTooHeavy(items))
            {
                for (i = 0; i < 2; i++)
                    for (j = 0; j < 6; j++)
                    {
                        for (k = 0; k < 3; k++)
                        {
                            if (size[i][k] >= items.get(0).rotate(j)[k])
                                c++;
                            if (c == 3)
                                available[i] = true;
                        }
                        c = 0;
                    }
            }
            for (i = 2; i < 6; i++)
                for (j = 0; j < 6; j++)
                {
                    for (k = 0; k < 3; k++)
                    {
                        if (size[i][k] >= items.get(0).rotate(j)[k])
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
                            if (size[i][k] >= items.get(0).rotate(j)[k])
                                c++;
                            if (c == 3)
                                tempAvailable[j] = true;
                        }
                        c = 0;
                    }
                    for (j = 0; j < 6; j++) {
                        if (tempAvailable[j])
                            available[i] = isFit(createNewSpace(size, i, items.get(0).rotate(j)), items);
                        tempAvailable[j] = false;
                    }
                }
            }
            for (i = 2; i < 6; i++)
            {
                for (j = 0; j < 6; j++)
                {
                    for (k = 0; k < 3; k++)
                    {
                        if (size[i][k] >= items.get(0).rotate(j)[k])
                            c++;
                        if (c == 3)
                            tempAvailable[j] = true;
                    }
                    c = 0;
                }
                for (j = 0; j < 6; j++)
                {
                    if (tempAvailable[j])
                    {
                        available[i] = isFit(createNewSpace(size, i, items.get(0).rotate(j)), items);
                        tempAvailable[j] = false;
                    }
                }
            }

        }
        for(i = 0; i < 6; i++)
        {
            System.out.println(available[i]);
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
        double[][] newSize;
        boolean condition = false;
        boolean[] test = {false,false,false,false,false,false};
        if(items.size() == 1)
        {
            for (i = 0; i < 3; i++) {
                for (j = 0; j < 6; j++) {

                    for (k = 0; k < 3; k++) {
                        if (size[i][k] >= items.get(0).rotate(j)[k])
                            c++;
                        if (c == 3) {
                            test[j] = true;
                        }
                    }
                    c = 0;
                }
                for (j = 0; j < 6; j++) {
                    if (test[j]) {
                        condition = true;
                        test[j] = false;
                    }
                }
            }
        }
        else
        {
            items.remove(0);
            for(i = 0; i < 3; i++) {
                for (j = 0; j < 6; j++) {

                    for (k = 0; k < 3; k++)
                    {
                        if (size[i][k] >= items.get(0).rotate(j)[k])
                            c++;
                        if (c == 3) {
                            test[j] = true;
                        }
                    }
                    c = 0;
                }
                for (j = 0; j < 6; j++) {
                    if (test[j]) {
                        condition = isFit(createNewSpace(size, i, items.get(0).rotate(j)), items);
                        test[j] = false;
                    }
                }
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
    public double computeBaseFee()
    {
        int i;
        if (/*pType*/ == "FLAT")
        {
            if (/*dimension*/ == /*given dimension1*/)
                return 30;
            else
                return 50;
        }
        for (i = 0; i < items.size(); i++)
        {
            if ()
        }
    }
}
