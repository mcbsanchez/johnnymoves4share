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
			if (gui.rdbtnDocument.isSelected())
			{
				gui.radiobtns.clearSelection();
				gui.clearDDocument();
			}
			else if (gui.rdbtnProduct.isSelected())
			{
				gui.radiobtns.clearSelection();
				gui.clearDProduct();

			}
			else if (gui.rdbtnIrregular.isSelected())
			{
				gui.radiobtns.clearSelection();
				gui.clearDIrregular();
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
			gui.updateContentPane(gui.HOME);
		}

	}


}
