import java.util.ArrayList;
import java.util.Calendar;
/**Parcel class is the one that is being aggregated by Items and is being composited from TrackNum
 * @author Martin Christopher B. Sanchez & Earth Wendell B. Lopez
 */
public class Parcel {
    //Constructor
    /**Constructor for Parcel which intializes at the following parameters
     * @param recipient - name of the person
     * @param destination - destination (full format, ex. Metro Manila, Provincial Luzon, etc.)
     * @param countItems - number of items that should be in this item
     */
    public Parcel (String recipient, String destination, int countItems)
    {
        this.recipient = recipient;
        this.destination = destination;
        this.countItems = countItems;
    }

    /** Prints the available parcels and also computes for which items fit the parcel
     *
     */
    public void setAvailableParcels()
    {
        /*
        i - number of spaces
        j - number of rotations
        k - number of sides
        c - number of difference above negative
         */
        int i, j, k, c = 0;
        boolean tempAvailable[] = {false, false, false, false, false, false};
        if (items.size() == 1)
        {
            if (!isTooHeavy())
            {
                for (i = 0; i < 2; i++)
                    for (j = 0; j < 6; j++)
                    {
                        for (k = 0; k < 3; k++)
                        {
                            if (SIZES[i][k] >= items.get(0).rotate(j)[k])
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
                        if (SIZES[i][k] >= items.get(0).rotate(j)[k])
                            c++;
                        if (c == 3)
                            available[i] = true;
                    }
                    c = 0;
                }
        }
        else
        {
            if (!isTooHeavy())
            {
                for (i = 0; i < 2; i++)
                {
                    for (j = 0; j < 6; j++)
                    {
                        for (k = 0; k < 3; k++)
                        {
                            if (SIZES[i][k] >= items.get(0).rotate(j)[k])
                                c++;
                            if (c == 3)
                                tempAvailable[j] = true;
                        }
                        c = 0;
                    }
                    for (j = 0; j < 6; j++) {
                        if (tempAvailable[j])
                        {
                            available[i] = isFit(createNewSpace(SIZES[i], items.get(0).rotate(j)), items);
                            tempAvailable[j] = false;
                        }
                    }
                }
            }
            for (i = 2; i < 6; i++)
            {
                for (j = 0; j < 6; j++)
                {
                    for (k = 0; k < 3; k++)
                    {
                        if (SIZES[i][k] >= items.get(0).rotate(j)[k])
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
                        available[i] = isFit(createNewSpace(SIZES[i], items.get(0).rotate(j)), items);
                        tempAvailable[j] = false;
                    }
                }
            }

        }
    }
    /**Used by showAvailableParcels() method that is being used as a parameter in isFit
     * @param size - the dimensions taken from the space
     * @param item - the item's dimensions
     * @return double[][] that consists of 3 new spaces for the next item to check
     */
    private double[][]createNewSpace(double[] size, double[] item)
    {
        return new double[][]{  {size[0] - item[0], size[1], size[2]},
                {size[0], size[1] - item[1], size[2]},
                {size[0], size[1], size[2] - item[2]}};
    }

    /**Method that is being recursively called until all items fit the box
     * @param size - the createNewSpace() method will be passed here
     * @param items -
     * @return
     */
    private boolean isFit(double[][] size, ArrayList<Item> items)
    {
        ArrayList<Item> tempItems = new ArrayList<>(items);
        int i, j, k, c = 0;
        double[][] newSize;
        boolean condition = false;
        boolean[] test = {false,false,false,false,false,false};
        if(items.size() == 1)
        {
            for (i = 0; i < 3; i++)
            {
                for (j = 0; j < 6; j++)
                {

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
                for (j = 0; j < 6; j++)
                {
                    if (test[j])
                    {
                        condition = true;
                        test[j] = false;
                    }
                }
            }
        }
        else
        {
            tempItems.remove(0);
            for(i = 0; i < 3; i++)
            {
                for (j = 0; j < 6; j++)
                {

                    for (k = 0; k < 3; k++)
                    {
                        if (size[i][k] >= tempItems.get(0).rotate(j)[k])
                            c++;
                        if (c == 3) {
                            test[j] = true;
                        }
                    }
                    c = 0;
                }
                for (j = 0; j < 6; j++)
                {
                    if (test[j])
                    {
                        condition = isFit(createNewSpace(size[i], tempItems.get(0).rotate(j)), tempItems);
                        test[j] = false;
                    }
                }
            }
        }
        return condition;
    }

    /**Checks if the item is too heavy for the flat parcel
     * @return boolean if the total weight of the item is greater than 3
     */
    private boolean isTooHeavy()
    {
        return getTotalWeight() > 3;
    }

    /** Adds the items as long as they both have equal counts to the intialized item count
     * @param items - ArrayList of Item that can range from 1 to * number of items
     * @param n - number of items initialized at the start
     */
    public void addItems(ArrayList<Item> items, int n)
    {
        if(countItems == items.size())
        {
            setItems(items);
            setType(n);
        }
        else
            System.out.println("Invalid, number of items inconsistent");
    }
    /** Sets the items for the parcel
     * @param items - ArrayList of Item that can range from 1 to * number of items
     */
    public void setItems (ArrayList<Item> items)
    {

        this.items = new ArrayList<>(items);
//        System.out.println(items.get(0).getWeight());
//        System.out.println(items.get(1).getWeight());
//        System.out.println(items.get(2).getWeight());
//        System.out.println(this.items.get(0).getWeight());
//        System.out.println(this.items.get(1).getWeight());
//        System.out.println(this.items.get(2).getWeight());
    }
    /**Sets the type of parcel and its dimensions
     * @param n - number of items initialized at the start
     */
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
    /**Sets the insurance of the item to either true or false
     * @param choice either yes or no (will only be yes if inputed yes, no otherwise)
     */
    public void setInsurance(String choice)
    {
        if (choice.equalsIgnoreCase("Yes"))
        {
            insured = true;
        }
        else
            insured = false;
    }
    /** Generates the TrackingNumber of the Parcel
     */
    public void generateTrackingNum() {
        if(countItems == items.size()
                && daySent.get(Calendar.DATE) != 0
                && destination != null
                && sequenceNumber != 0
                && type != null)
            track = new TrackNum(this);
    }
    //Getters
    /** Gets the tracking number stored in the parcel
     * @return String - which is the Tracking Number of the Parcel
     */
    public String getTrackingNum()
    {
        return track.toString();
    }
    /** Gets the Type of Parcel of the item
     * @return
     */
    public String getType()
    {
        return type;
    }
    /**Gets the Dimensions of the Parcel
     * @return double[] which consist of 3, the length, width, and height
     */
    public double[] getDimensions()
    {
        return size;
    }
    /**Gets the specific item in the parcel
     * @param i - the index number of the item being taken from parcel
     * @return Item that gets the contents of an Item as well
     */
    public Item getItem(int i)
    {
        return items.get(i);
    }
    /**Sets the sequence number of the parcel
     * @param n - the sequence number is being set in with this function base from the controller
     */
    public void setSequenceNumber(int n)
    {
        sequenceNumber = n;
    }
    /**Gets the sequence number of the parcel
     * @return int - the sequence number is grabbed from parcel
     */
    public int getSequenceNumber()
    {
        return sequenceNumber;
    }
    /**Gets the total weight of the parcel
     * @return double values of the total weight from parcel
     */
    public double getTotalWeight()
    {
        int i;
        double totalWeight = 0;
        for(i = 0; i < items.size(); i++)
        {
            totalWeight += items.get(i).getWeight();
        }
        return totalWeight;
    }
    /**Gets the destination of the parcel
     * @return String of the destination from parcel
     */
    public String getDestination()
    {
        return destination;
    }
    /**Gets the number of items in the parcel
     * @return int which is the attribute countItems in the parcel class
     */
    public int getNumOfItems()
    {
        return countItems;
    }
    /**Gets the base fee of the parcel
     * @return double values of the base fee
     */
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
                    baseFee += 40 * Math.ceil(items.get(i).getWeight());
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
    /**Gets the service fee of the parcel
     * @return double values of the base fee
     */
    public double getServiceFee()
    {
        int i;
        double fee = 0, volume = size[0]*size[1]*size[2];

        if(destination.equalsIgnoreCase(DESTINATIONS[0]))
            fee = 50;
        else if(destination.equalsIgnoreCase(DESTINATIONS[1]))
            fee = 100;
        else if(destination.equalsIgnoreCase(DESTINATIONS[2]))
        {
            if(getTotalWeight()*.10 > volume && getTotalWeight() > 1000 )
                fee = getTotalWeight()*.10;
            else if(volume > getTotalWeight()*.10 && volume > 1000 )
                fee = volume;
            else if(1000 > volume &&  1000 > getTotalWeight()*.10 )
                fee = 1000;
        }
        else if(destination.equalsIgnoreCase(DESTINATIONS[3]))
        {
            if(getTotalWeight()*.25 > volume && getTotalWeight()*.25 > 3000 )
                fee = getTotalWeight()*.10;
            else if(volume > getTotalWeight()*.25 && volume > 3000 )
                fee = volume;
            else if(3000 > volume &&  3000 > getTotalWeight()*.25)
                fee = 3000;
        }

        return fee;

    }
    /**Gets the insurance fee of the parcel
     * @return double values of the base fee
     */
    public double getInsuranceFee()
    {
        if(insured)
            return items.size()*5;
        else
            return 0;
    }
    /**Gets the total fee of the parcel base from the base fee, insurance fee, and service fee
     * @return double values of the total fee
     */
    public double getTotalFee()
    {
        return getBaseFee() + getInsuranceFee() + getServiceFee();
    }
    /**This method shows the breakdown using different fees which are
     *  base fee
     *  insurance fee
     *  service fee
     *  and total fee
     */
    public void showBreakdown()
    {
        System.out.printf("     Base Fee \t %.2f \n", getBaseFee());
        System.out.printf("  Service Fee \t %.2f \n", getServiceFee());
        System.out.printf("Insurance Fee \t %.2f \n", getInsuranceFee());
        System.out.println("--------------\t----------------------");
        System.out.printf("    Total Fee \t %.2f \n", getTotalFee());
    }
    /**Gets the recipient's name in the parcel
     * @return String which is the recipient's name
     */
    public String getRecipient()
    {
        return recipient;
    }
    /**Sets the time the parcel was processed, along with the estimated delivery day
     * @param cal - current day simulated in the parcel's creation
     */
    public void setTime(Calendar cal) {

        daySent = (Calendar) cal.clone();
        dayReceived = (Calendar) cal.clone();
        if(getDestination().equalsIgnoreCase("Metro Manila"))
            dayReceived.add(Calendar.DAY_OF_MONTH,1);
        else if(getDestination().equalsIgnoreCase("Provincial Luzon"))
            dayReceived.add(Calendar.DAY_OF_MONTH,2);
        if(getDestination().equalsIgnoreCase("Visayas"))
            dayReceived.add(Calendar.DAY_OF_MONTH,5);
        else if(getDestination().equalsIgnoreCase("Mindanao"))
            dayReceived.add(Calendar.DAY_OF_MONTH,8);
    }
    /**Gets the month of the parcel's creation
     * @return int values of the month
     */
    public int getMonth()
    {
        return daySent.get(Calendar.MONTH)+1;
    }
    /**Gets the day of the parcel's creation
     * @return int values of the day
     */
    public int getDay()
    {
        return daySent.get(Calendar.DAY_OF_MONTH);
    }
    /**Checks the status of the parcel from PROCESSING, SHIPPING, and DELIVERED
     * @param cal - date that is being compared to the day the parcel was processed and received
     * @return String which are PROCESSING, SHIPPING, and DELIVERED
     */
    public String viewStatusToday(Calendar cal)
    {
//        System.out.println(daySent.get(Calendar.DAY_OF_YEAR));
//        System.out.println(dayReceived.get(Calendar.DAY_OF_YEAR));
//        System.out.println(cal.get(Calendar.DAY_OF_YEAR));
        if (daySent.get(Calendar.DAY_OF_YEAR) == cal.get(Calendar.DAY_OF_YEAR)) {
            status = CURRENTSTATUS[0];
        }
        else if (dayReceived.get(Calendar.YEAR) == daySent.get(Calendar.YEAR)) {
            if (cal.get(Calendar.DAY_OF_YEAR) >= dayReceived.get(Calendar.DAY_OF_YEAR)) {
                status = CURRENTSTATUS[2];
            } else if (daySent.get(Calendar.DAY_OF_YEAR) != cal.get(Calendar.DAY_OF_YEAR) && dayReceived.get(Calendar.DAY_OF_YEAR) != cal.get(Calendar.DAY_OF_YEAR)) {
                status = CURRENTSTATUS[1];
            }
        }
        else if(dayReceived.get(Calendar.YEAR) > cal.get(Calendar.YEAR) && cal.get(Calendar.YEAR) == daySent.get(Calendar.YEAR))
        {
            if (cal.get(Calendar.DAY_OF_YEAR) >= dayReceived.get(Calendar.DAY_OF_YEAR) + cal.getMaximum(Calendar.DAY_OF_YEAR)) {
                status = CURRENTSTATUS[2];
            } else if (daySent.get(Calendar.DAY_OF_YEAR) != cal.get(Calendar.DAY_OF_YEAR) && dayReceived.get(Calendar.DAY_OF_YEAR) != cal.get(Calendar.DAY_OF_YEAR)) {
                status = CURRENTSTATUS[1];
            }
        }
        else if(dayReceived.get(Calendar.YEAR) > cal.get(Calendar.YEAR) && cal.get(Calendar.YEAR) > daySent.get(Calendar.YEAR))
        {
            if (cal.get(Calendar.DAY_OF_YEAR) >= dayReceived.get(Calendar.DAY_OF_YEAR) + cal.getMaximum(Calendar.DAY_OF_YEAR)) {
                status = CURRENTSTATUS[2];
            } else if (daySent.get(Calendar.DAY_OF_YEAR) != cal.get(Calendar.DAY_OF_YEAR) && dayReceived.get(Calendar.DAY_OF_YEAR) != cal.get(Calendar.DAY_OF_YEAR)) {
                status = CURRENTSTATUS[1];
            }
        }
        return status;

    }

    /**Gets the available parcels
     * @return boolean[] all the parcel sizes that fit the items
     */
    public boolean[]getAvailableParcels()
    {
        return available;
    }

    /**
     * prints the available parcels
     */
    public void printAvailableParcels()
    {
        int i;
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

    //Attributes
    private static String[] DESTINATIONS = {"Metro Manila","Provincial Luzon", "Visayas", "Mindanao"};
    private double[][] SIZES = {{9, 14, 1}, {12, 18, 3}, {12, 10, 5}, {14, 11, 7}, {18, 12, 9}, {20, 16, 12}};
    private static String[] PARCELTYPE = {"FLT","BOX"};
    private static String[] CURRENTSTATUS = {"PREPARING","SHIPPING","DELIVERED"};

    private String recipient;
    private String destination;
    private int countItems;

    private boolean[] available = {false,false,false,false,false,false};
    private String type;
    private double[] size;

    private ArrayList <Item> items;
    private boolean insured = false;
    private int sequenceNumber;
    private Calendar daySent;
    private Calendar dayReceived;
    private TrackNum track;
    private String status;

}
