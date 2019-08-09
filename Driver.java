import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;

public class Driver {

    Calendar cal = Calendar.getInstance();
    public void simulateTime()
    {
        Thread clock = new Thread() {
            public void run()
            {
                for(;;){
                    cal.add(Calendar.HOUR, 1);
                    try{
                        sleep(1000);
                    }catch (InterruptedException ex)
                    {
                    }
                }
            }
        };
        clock.start();
    }
    public static void main(String[] args)
    {
<<<<<<< Updated upstream
        ArrayList<Item> items = new ArrayList<>();
        items.add(new Document(4,4,1));
        items.add(new Product(4,4,1,100));
        items.add(new Irregular(4,4,1,1));
        Parcel parcel = new Parcel("Martin","Visayas",items.size());

        parcel.addItem(items);
        parcel.showAvailableParcels();
        parcel.setType(3);
        System.out.println(parcel.getType());
        System.out.println("L "+parcel.getDimensions()[0]+" W "+parcel.getDimensions()[1]+" H "+parcel.getDimensions()[2] + " WEIGHT " + parcel.getTotalWeight());
        parcel.setInsurance("Yes");
        parcel.showBreakdown();
=======
        System.out.println(LocalDate.now());

//        ArrayList<Item> items = new ArrayList<>();
//        items.add(new Document(4,4,1));
//        items.add(new Product(4,4,1,1));
//        Parcel parcel = new Parcel("Martin","Metro Manila",items.size());
//        parcel.addItem(items);
//        parcel.showAvailableParcels();
//        parcel.setType(1);
//        parcel.setType(2);
//        parcel.setType(3);
//        parcel.setType(4);
//        parcel.setType(5);
//        parcel.setType(7);
//        parcel.setType(0);
//        System.out.println(parcel.getType());
//        parcel.setInsurance("Yes");
//        parcel.showBreakdown();
//        cal.add(Calendar.DAY_OF_YEAR, 1);
>>>>>>> Stashed changes


    }
}
