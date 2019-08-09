import java.util.ArrayList;
import java.util.Calendar;

public class Driver {

    public static void main(String[] args)
    {
        Calendar cal = Calendar.getInstance();

        ArrayList<Item> items = new ArrayList<>();
        items.add(new Document(4,4,1));
        items.add(new Product(4,4,1,1));
        Parcel parcel = new Parcel("Martin","Metro Manila",items.size());
        parcel.addItem(items);
        parcel.showAvailableParcels();
        parcel.setType(1);
        parcel.setType(2);
        parcel.setType(3);
        parcel.setType(4);
        parcel.setType(5);
        parcel.setType(7);
        parcel.setType(0);
        System.out.println(parcel.getType());
        parcel.setInsurance("Yes");
        parcel.showBreakdown();
        cal.add(Calendar.DAY_OF_YEAR, 1);


    }
}
