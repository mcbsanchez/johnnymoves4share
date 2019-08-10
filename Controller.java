import java.awt.event.*;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Controller implements ActionListener
{
	private Gui gui;
	private ArrayList<Parcel> parcels = new ArrayList<>();
	int p = 0; // pang ilang parcel
	private ArrayList<Item> items = new ArrayList<> ();
	int parcelNumber = 0; // pang ilang parcel PER DAY
	Calendar cal = Calendar.getInstance();
	long start = System.nanoTime();

	public Controller (Gui gui)
	{
		this.gui = gui;
		this.gui.addListeners(this);
	}

	// ActionListener
	public void actionPerformed (ActionEvent e)
	{
		int i;
		
		//idk where to insert yung pang check ng time after each iteration?
		//---start here--
		long end = System.nanoTime();
		long elapsedTime = end - start;
		long convert = TimeUnit.SECONDS.convert(elapsedTime, TimeUnit.NANOSECONDS); // ilang seconds nag pass
		if (convert / 3 > 0) {
	    	cal.add(Calendar.DAY_OF_YEAR, (int)convert/3);
            System.out.println(convert);
            start = System.nanoTime();
            parcelNumber = 0;
           	}
		//---end here--
		p++; // <- yung pang ilang parcel
		p--; // <- yung kapag nacancel (not sure if kailangan pa?)
		long start = System.nanoTime();
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
				parcelNumber++;
				parcels.add(new Parcel (gui.getName(),gui.getDestination(),gui.getNum()));
				gui.updateContentPane (gui.CREATE);
				parcels.get(p).setSequenceNumber(parcelNumber);
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
			for (i = 0; i < parcels.get(p).getNumOfItems(); i++)
			{
				gui.updateContentPane(gui.CREATE);
				try
				{
					temp = gui.createItem();
				} catch (Exception ex) {

				}
				items.add(temp);
				gui.radiobtns.clearSelection();
				gui.updateDperType (gui.BLANK);
				gui.resetAll();
			}
			parcels.get(0).setItems(items);
			gui.updateContentPane(gui.CHECKOUT);

			/*
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
			gui.updateDperType (gui.BLANK);*/
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
