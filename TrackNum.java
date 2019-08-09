public class TrackNum
{
	public TrackNum (String p, int date, String code, int m)
	{
		parcelType = p;
		MMDD = date;

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
		return parcelType + MMDD + destinationCode + max + seq;
	}
	
	
	private String				parcelType;
	private int					MMDD;
	private String              destinationCode;
	private int                 max;
	private int					seq;
}
