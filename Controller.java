import java.awt.event.*;

public class Controller implements ActionListener, ItemListener
{
	private Gui gui;

	public Controller (Gui gui)
	{
		this.gui = gui;
		this.gui.addListeners(this);
	}
<<<<<<< Updated upstream

=======
	ArrayList<Parcel> p = new ArrayList<>();
	ArrayList<Item> i = new ArrayList<>();
	int a = 0;
>>>>>>> Stashed changes
	// ActionListener
	public void actionPerformed (ActionEvent e)
	{

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
<<<<<<< Updated upstream
=======
			ArrayList<Item> i = new ArrayList<>();
			p.add(new Parcel(gui.tfName.getText(),
					gui.cbDestination.getSelectedItem().toString(),
					Integer.parseInt((gui.tfCount.getText()))));
>>>>>>> Stashed changes
			gui.updateContentPane(gui.CREATE);
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
			gui.updateContentPane(gui.HOME);
		}

	}

	@Override
	public void itemStateChanged(ItemEvent e)
	{
		if (e.getStateChange () == ItemEvent.SELECTED)
		{

		}

	}

}
