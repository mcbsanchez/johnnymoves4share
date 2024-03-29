/**
 *  TrackNum class is a composition of a complete Item class
 *
 *  * @author Martin Christopher B. Sanchez & Earth Wendell B. Lopez
 */
public class TrackNum
{
	//Constructor
	/**Constructor for TrackNum
	 * @param p is the parcel, which is used by the Parcel class as "this"
	 */
	public TrackNum (Parcel p)
	{
		parcelType = p.getType();

		if(p.getMonth() < 10)
			this.month = "0"+ p.getMonth();
		else
			this.month = Integer.toString(p.getMonth());
		if(p.getDay() < 10)
			this.day = "0"+ p.getDay();
		else
			this.day = Integer.toString(p.getDay());

		if (p.getDestination().equalsIgnoreCase("Metro Manila"))
			destinationCode = "MML";
		else if (p.getDestination().equalsIgnoreCase("Luzon"))
			destinationCode = "LUZ";
		else if (p.getDestination().equalsIgnoreCase("Visayas"))
			destinationCode = "VIS";
		else if (p.getDestination().equalsIgnoreCase("Mindanao"))
			destinationCode = "MIN";

		if(p.getNumOfItems() < 10)
			max = "0"+p.getNumOfItems();
		else
			max = ""+p.getNumOfItems();


		if(p. getSequenceNumber() < 10)
			seq = "0"+"0"+p.getSequenceNumber();
		else if(p.getSequenceNumber() < 100)
			seq = "0"+p.getSequenceNumber();




	}

	/**toString function that return the String of the tracker id
	 * @return String including the
	 * parcelType of either FLT or BOX,
	 * Month and Day in MMDD format,
	 * destinationCode of either MNL, LUZ, VIS, or MIN,
	 * The max number of parcels, and the concurrent item of the day
	 */
	public String toString()
	{
		return parcelType + month + day + destinationCode + max + seq;
	}

	//Atributes
	/**
	 * These atributes rely heavily on a fully completed Parcel
	 */
	private String				parcelType;
	private String				month;
	private String				day;
	private String              destinationCode;
	private String              max;
	private String				seq;
}
