public class TrackNum
{
	public TrackNum (String p, int month, int day, String code, int m)
	{
		parcelType = p;
		if(month < 10)
			this.month = "0"+Integer.toString(month);
		else
			this.month = Integer.toString(month);
		if(day < 10)
			this.day = "0"+Integer.toString(day);
		else
			this.day = Integer.toString(day);

		if (code.equalsIgnoreCase("Metro Manila"))
		{
			destinationCode = "MML";
		}
		else if (code.equalsIgnoreCase("Luzon"))
		{
			destinationCode = "LUZ";
		}
		else if (code.equalsIgnoreCase("Visayas"))
		{
			destinationCode = "VIS";
		}
		else if (code.equalsIgnoreCase("Mindanao"))
		{
			destinationCode = "MIN";
		}

		max = m;


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
	private int					seq;
}
