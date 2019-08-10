import java.awt.event.*;

public class Controller implements ActionListener, ItemListener
{
	private Gui gui;
	
	public Controller (Gui gui)
	{
		this.gui = gui;
		this.gui.addListeners(this);
	}
	
	// ActionListener
	public void actionPerformed (ActionEvent e)
	{
		
		if (e.getActionCommand ().equals ("Create Parcel"))
		{
			gui.updateContentPane (gui.CREATE);
		}
		else if (e.getActionCommand ().equals ("Track Parcel"))
		{
			gui.updateContentPane(gui.TRACK);
		}
		else if (e.getActionCommand ().equals ("Exit Program"))
		{
			gui.updateContentPane (gui.EXIT);
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
		else if (e.getActionCommand ().equals ("Track"))
		{
			gui.tfTracker.setText(" ");
		}
		else if (e.getActionCommand ().equals ("Exit"))
		{
			
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
