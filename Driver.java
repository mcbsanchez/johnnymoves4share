import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Driver {

    public static void main(String[] args)
    {
        long start = System.nanoTime();
        Calendar cal = Calendar.getInstance();
        Scanner sc = new Scanner(System.in);
        boolean exit = false;
        ArrayList<Parcel> p = new ArrayList<>();
        int count = 0;
        int parcelNumber = 0;

        while(!exit) {
            boolean option;
            parcelNumber++;

            ArrayList<Item> items = new ArrayList<>();
            items.add(new Document(4, 4, 1));
            items.add(new Product(4, 4, 1, 100));
            items.add(new Irregular(4, 4, 1, 1));
            p.add(new Parcel("Martin", "Visayas", items.size()));

            p.get(count).addItem(items);
            p.get(count).showAvailableParcels();
            p.get(count).setType(3);
            System.out.println(p.get(count).getType());
            p.get(count).setInsurance("Yes");
            p.get(count).showBreakdown();
            long end = System.nanoTime();
            p.get(count).setSequenceNumber(parcelNumber);
            p.get(count).generateTrackingNum();

            long elapsedTime = end - start;
            double elapsedTimeInSecond = (double) elapsedTime / 1_000_000_000;
            long convert = TimeUnit.SECONDS.convert(elapsedTime, TimeUnit.NANOSECONDS);
            p.get(count).setTime(cal);
            if (convert / 3 > 0) {
                cal.add(Calendar.DAY_OF_YEAR, (int)convert/3);
                System.out.println(convert);
                start = System.nanoTime();
                System.out.println("Next Day");
                parcelNumber = 0;
            }
            System.out.println("Month-" + p.get(count).getMonth() + " Day-" + p.get(count).getDay());
            System.out.println(p.get(count).getTrackingNum());
            System.out.println("Do you want to proceed?");
            option = sc.nextBoolean();
            if (!option) {
                exit = true;
            }
            count++;
        }

    }
}
