import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Driver {

//    public static void main(String []args)
//    {
//        JMGui gui = new JMGui ();
//        Controller controller =  new Controller(gui);
////        gui.init();
//    }
    public static void main(String[] args)
    {
        Gui gui = new Gui ();
        Controller controller = new Controller (gui);

//        long start = System.nanoTime();
//        Calendar cal = Calendar.getInstance();
//        Scanner sc = new Scanner(System.in);
//        boolean exit = false;
//        ArrayList<Parcel> p = new ArrayList<>();
//        int count = 0;
//        int parcelNumber = 0;
//        int i;
//        while(!exit) {
//            boolean option;
//            parcelNumber++;
//
//            ArrayList<Item> items = new ArrayList<>();
//            items.add(new Document(4, 4, 1));
//            items.add(new Product(4, 4, 1, 100));
//            items.add(new Irregular (4, 4, 1, 1));
//            p.add(new Parcel("Martin", "Visayas", items.size()));
//
//            p.get(count).addItem(items);
//            p.get(count).showAvailableParcels();
//            p.get(count).setType(3);
//            System.out.println(p.get(count).getType());
//            p.get(count).setInsurance("Yes");
//            p.get(count).showBreakdown();
//            p.get(count).setSequenceNumber(parcelNumber);
//            long end = System.nanoTime();
//            long elapsedTime = end - start;
//            long convert = TimeUnit.SECONDS.convert(elapsedTime, TimeUnit.NANOSECONDS);
//            if (convert / 3 > 0) {
//                cal.add(Calendar.DAY_OF_YEAR, (int)convert/3);
//                System.out.println(convert);
//                start = System.nanoTime();
//                parcelNumber = 0;
//            }
//            p.get(count).setTime(cal);
//            p.get(count).generateTrackingNum();
//
//            System.out.println(p.get(0).viewStatusToday(cal));
//            System.out.println("Month-" + p.get(count).getMonth() + " Day-" + p.get(count).getDay());
//            System.out.println(p.get(count).getTrackingNum());
//            System.out.println("Do you want to proceed?");
//            option = sc.nextBoolean();
//            if (!option) {
//                exit = true;
//            }
//            count++;
//        }
//        exit = false;
//        String track;
//        while(!exit)
//        {
//            track = sc.next();
//            for(i = 0; i < p.size(); i++)
//            {
//                if (p.get(i).getTrackingNum().equalsIgnoreCase(track))
//                    System.out.println(p.get(i).viewStatusToday(cal));
//            }
//        }

    }
}
