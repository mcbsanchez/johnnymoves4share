import java.awt.event.*;
import java.util.*;


public class Controller implements ActionListener, ItemListener
{
	private Gui gui;
	private ArrayList<Parcel> parcels = new ArrayList<>();
	private ArrayList<Item> items = new ArrayList<> ();

	public Controller (Gui gui, Parcel parcel)
	{
		this.gui = gui;
		this.gui.addListeners(this);
	}

// 	ArrayList<Parcel> p = new ArrayList<>();
// 	ArrayList<Item> i = new ArrayList<>();
// 	String password = "animo!";
// 	int a = 0;


	// ActionListener
	public void actionPerformed (ActionEvent e)
	{
		int i;
		int countItems = gui.getNum();

		if (e.getActionCommand ().equals ("Create Parcel"))
		{
			gui.updateContentPane (gui.SETUP);
			if (!gui.getDestination().equals("--- choose ---") && gui.getNum() > 0)
			{

				parcels.add(new Parcel (gui.getName(),gui.getDestination(),gui.getNum()));
			}
			else
				gui.updateContentPane (gui.SETUP);
		}
		else if (e.getActionCommand ().equals ("Track Parcel"))
		{
			gui.updateContentPane(gui.TRACK);

		}
		else if (e.getActionCommand ().equals ("Exit Program"))
		{
			gui.updateContentPane (gui.EXIT);
		}
		else if (e.getActionCommand().equals ("Add Items"))
		{
			for (i = 0; i < countItems; i++)
			{
				gui.updateContentPane(gui.CREATE);
				items.add(gui.createItem());
				//reset values

			}
		}
		else if (e.getActionCommand ().equals ("Document"))
		{
			gui.updateDperType (gui.DOCUMENT);
		}
		else if (e.getActionCommand ().equals ("Product"))
		{
			gui.updateDperType (gui.PRODUCT);
		}
		else if (e.getActionCommand ().equals ("Irregular Product"))
		{
			gui.updateDperType (gui.IRREGULAR);
		}
		else if (e.getActionCommand ().equals ("Add Item"))
		{
			if(p.get(a).getNumOfItems() != i.size())
			{
				if (gui.rdbtnDocument.isSelected()) {
					i.add(new Document(Integer.parseInt(gui.tfDLength.getText()),
							Integer.parseInt(gui.tfDWidth.getText()),
							Integer.parseInt(gui.tfDPages.getText())));
					gui.radiobtns.clearSelection();
					gui.clearDDocument();
				} else if (gui.rdbtnProduct.isSelected()) {
					i.add(new Product(Integer.parseInt(gui.tfILength.getText()),
							Integer.parseInt(gui.tfPWidth.getText()),
							Integer.parseInt(gui.tfPHeight.getText()),
							Integer.parseInt(gui.tfPWeight.getText())));
					gui.radiobtns.clearSelection();
					gui.clearDProduct();

				} else if (gui.rdbtnIrregular.isSelected()) {
					gui.radiobtns.clearSelection();
					gui.clearDIrregular();
				}
				a++;
			}
			gui.radiobtns.clearSelection();
			gui.updateDperType (gui.BLANK);
		}
		else if (e.getActionCommand().equals ("Back to Menu"))
		{
			gui.updateContentPane(gui.HOME);
		}
		else if (e.getActionCommand ().equals ("See Breakdown"))
		{
			gui.updateCheckout(gui.BREAKDOWN);
		}
		else if (e.getActionCommand ().equals ("Proceed"))
		{
			gui.updateContentPane(gui.HOME);
		}
		else if (e.getActionCommand ().equals ("Track"))
		{
			gui.tfTracker.setText(" ");
		}
		else if (e.getActionCommand ().equals ("Exit Program"))
		{
			if(gui.pfPassword.getPassword().toString().equalsIgnoreCase(password)) {
			}
			gui.updateContentPane(gui.HOME);
		}

	}


}
