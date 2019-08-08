import java.util.ArrayList;

public class Driver {

    public static void main(String[] args)
    {
        double[][] size = {{9, 14, 1}, {12, 18, 3}, {12, 10, 5}, {14, 11, 7}, {18, 12, 9}, {20, 16, 12}};

        ArrayList<Item> items = new ArrayList<>();
        items.add(new Document(10,17,22));
        items.add(new Product(1,1,1,1));
        Parcel parcel = new Parcel("Martin","Metro Manila",1);

    }
}
