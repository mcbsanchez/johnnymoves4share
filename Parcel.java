import javax.swing.*;
import java.util.ArrayList;

public class Parcel {

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

    public void showAvailableParcels(double[][]size)
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
        System.out.println("Available Parcel Size");
        for(i = 0; i < 6; i++)
        {
            if(available[i])
                if(i < 2)
                        System.out.println("FLAT PARCEL( "+SIZES[i][0]+" x "+SIZES[i][1]+" x "+SIZES[i][2]+" )");
                else
                        System.out.println("BOX PARCEL( "+SIZES[i][0]+" x "+SIZES[i][1]+" x "+SIZES[i][2]+" )");
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

    public void setType(int n)
    {
        if(n < 2)
        {
            if(available[n])
            {
                type = PARCELTYPE[0];
                size = SIZES[n];
            }
        }
        else if(n >= 2 && n < 6)
        {
            if(available[n])
            {
                type = PARCELTYPE[1];
                size = SIZES[n];
            }
        }
        else
        {
            System.out.println("Invalid");
        }
    }

    public void setInsurance (String choice)
    {
        if (choice.equalsIgnoreCase("Yes"))
        {
            insured = true;
            listBreakdown(insured);
        }
        else
            listBreakdown(insured);
    }

    public void setTracking ()
    {
        track = new TrackNum(type, /*date*/, destination, countItems, /*sequence in the day*/)
    }

    public double getBaseFee()
    {
        int i;
        double baseFee = 0;

        if (type == PARCELTYPE[0]) // FLAT
        {
            if (size == SIZES[0])
                return 30;
            else
                return 50;
        }
        else // BOX
        {
            for (i = 0; i < items.size(); i++)
            {
                if (items.get(i) instanceof Document || items.get(i) instanceof Product)
                {
                    baseFee += 40 * items.get(i).getWeight();
                }
                else
                {
                    if ((items.get(i).getLength() * items.get(i).getWidth() * items.get(i).getHeight() / 305) * 30 > 40 * items.get(i).getWeight())
                        baseFee += 30 * (items.get(i).getLength() * items.get(i).getWidth() * items.get(i).getHeight() / 305);
                    else
                        baseFee += 40 * items.get(i).getWeight();
                }
            }
            return baseFee;
        }
    }

    public String getType()
    {
        return type;
    }

    public double getServiceFee()
    {
        int i;
        double totalWeight = 0, volume = size[0]*size[1]*size[2];
        for(i = 0; i < items.size(); i++)
        {
            totalWeight += items.get(i).getWeight();
        }

        double fee;

        if(destination.equalsIgnoreCase(DESTINATIONS[0]))
            fee = 50;
        else if(destination.equalsIgnoreCase(DESTINATIONS[1]))
            fee = 100;
        else if(destination.equalsIgnoreCase(DESTINATIONS[2]))
        {
            if(totalWeight*.10 > volume && totalWeight*.10 > 1000 )
                fee = totalWeight*.10;
            if(volume > totalWeight*.10 && volume > 1000 )
                fee = volume;
            if(1000 > volume &&  1000 > totalWeight*.10 )
                fee = 1000;
        }
        else if(destination.equalsIgnoreCase(DESTINATIONS[3])
        {
            if(totalWeight*.25 > volume && totalWeight*.25 > 3000 )
                fee = totalWeight*.10;
            if(volume > totalWeight*.25 && volume > 3000 )
                fee = volume;
            if(3000 > volume &&  3000 > totalWeight*.25)
                fee = 3000;
        }

        return fee;

    }

    private boolean[] available = {false,false,false,false,false,false};
    private double[][] SIZES = {{9, 14, 1}, {12, 18, 3}, {12, 10, 5}, {14, 11, 7}, {18, 12, 9}, {20, 16, 12}};
    private static String[] DESTINATIONS = {"Metro Manila","Provincial Luzon", "Visayas", "Mindanao"};
    private static String[] CURRENTSTATUS = {"PREPARING","SHIPPING","DELIVERED"};
    private static String[] PARCELTYPE = {"FLT","BOX"};

    private String type;
    private double[] size;
    private boolean insured = false;
    private String recipient;
    private String destination;
    private int countItems;
    private ArrayList <Item> items;
    private TrackNum track;
}
