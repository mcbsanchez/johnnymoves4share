public class TrackNum
{
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
		{
			destinationCode = "MML";
		}
		else if (p.getDestination().equalsIgnoreCase("Luzon"))
		{
			destinationCode = "LUZ";
		}
		else if (p.getDestination().equalsIgnoreCase("Visayas"))
		{
			destinationCode = "VIS";
		}
		else if (p.getDestination().equalsIgnoreCase("Mindanao"))
		{
			destinationCode = "MIN";
		}

		max = p.getNumOfItems();

		if(p. getSequenceNumber() < 10)
		{
			seq = "0"+"0"+p.getSequenceNumber();
		}
		else if(p.getSequenceNumber() < 100)
		{
			seq = "0"+p.getSequenceNumber();
		}



	}
	
	public String toString()
	{
		return parcelType + month + day + destinationCode + max + seq;
	}
	
	
	private String				parcelType;
	private String				month;
	private String				day;
	private String              destinationCode;
	private int                 max;
	private String				seq;
}
