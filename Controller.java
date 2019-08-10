import java.awt.event.*;
import java.util.*;

public class Controller implements ActionListener
{
	private Gui gui;
	private ArrayList<Parcel> parcels = new ArrayList<>();
	private ArrayList<Item> items = new ArrayList<> ();

	public Controller (Gui gui)
	{
		this.gui = gui;
		this.gui.addListeners(this);
	}


	// ActionListener
	public void actionPerformed (ActionEvent e)
	{
		int i;

		Item temp = null;

		if (e.getActionCommand ().equals ("Create Parcel"))
		{
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
			if (!gui.getDestination().equals("--- choose ---") && gui.getNum() > 0)
			{
				parcels.add(new Parcel (gui.getName(),gui.getDestination(),gui.getNum()));
				gui.resetAll();
				gui.updateContentPane (gui.CREATE);
			}
			else
				gui.updateContentPane (gui.SETUP);
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
			for (i = 0; i < parcels.get(0).getNumOfItems(); i++)
			{
				try
				{
					temp = gui.createItem();
				} catch (Exception ex) {

				}
				items.add(temp);
				gui.radiobtns.clearSelection();
				gui.updateContentPane(gui.CREATE);
				gui.resetAll();


			}
			parcels.get(0).setItems(items);
			gui.updateContentPane(gui.CHECKOUT);

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
			gui.setTracker(" ");
		}
		else if (e.getActionCommand ().equals ("Exit Program"))
		{
			gui.updateContentPane(gui.HOME);
		}

	}

}
