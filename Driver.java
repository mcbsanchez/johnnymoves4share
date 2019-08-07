import java.util.ArrayList;

public class Driver {
    public static void main(String[] args)
    {
        ArrayList<Item> items = new ArrayList<>();
        items.add(new Document(10,17,22));
        items.add(new Product(1,1,1,1));
        items.add(new Product(1,1,1,1));
        Parcel parcel = new Parcel("Metro Manila");
    }
}
