import java.awt.CardLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.EventListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Gui extends JFrame
{

	public final String BLANK = "Blank";
	public final String HOME = "Home";
	public final String SETUP = "Setup";
	public final String CREATE = "Create Parcel";
	public final String TRACK = "Track Parcel";
	public final String EXIT = "Exit Program";
	public final String DOCUMENT = "Document";
	public final String PRODUCT = "Product";
	public final String IRREGULAR = "Irregular";
	public final String CHECKOUT = "Checkout";
	public final String INSURE = "Insure";
	public final String BREAKDOWN = "Breakdown";
	//public final String DONE = "Done";

	private JPanel contentPane;
	private JPanel pnlHome;
	private JPanel pnlSetup;
	private JPanel pnlCreate;
	private JPanel pnlChoose;
	private JPanel pnlTypes;
	private JPanel pnlDimensions;
	private JPanel pnlTally;
	private JPanel pnlDperType;
	private JPanel pnlBlank;
	private JPanel pnlDocument;
	private JPanel pnlProduct;
	private JPanel pnlIrregular;
	private JPanel pnlCheckout;
	private JPanel pnlInsure;
	private JPanel pnlBreakdown;
	private JPanel pnlCBacktoMenu;
	private JPanel pnlTrack;
	private JPanel pnlExit;

	private JSplitPane spltAdd;

	public JButton btnCreate;
	public JButton btnTrackParcel;
	public JButton btnExitProgram;
	public JButton btnAddItems;
	public JButton btnDAddItem;
	public JButton btnPAdd;
	public JButton btnIAdd;
	public JButton btnBackToMenu;
	public JButton btnBreakdown;
	public JButton btnBackToMenu_2;
	public JButton btnProceed;
	public JButton btnTrack;
	public JButton btnTBackToMenu;
	public JButton btnExitPass;
	public JButton btnEBackToMenu;

	public ButtonGroup radiobtns;

	public JRadioButton rdbtnIrregular;
	public JRadioButton rdbtnProduct;
	public JRadioButton rdbtnDocument;


	private JTextField tfName;
	private JTextField tfCount;
	private JTextField tfDLength;
	private JTextField tfDWidth;
	private JTextField tfDPages;
	private JTextField tfPLength;
	private JTextField tfPWidth;
	private JTextField tfPHeight;
	private JTextField tfPWeight;
	private JTextField tfILength;
	private JTextField tfIWidth;
	private JTextField tfIHeight;
	private JTextField tfIWeight;
	private JTextField tfTracker;

	private JTextArea taReport;
	private JTextArea taTracked;

	public JPasswordField pfPassword;

	private JLabel lblTracking;
	private JLabel LBL;
	private JLabel lblNameOfRecipient;
	private JLabel lblDestination;
	private JButton btnBackToMenu_1;
	private JLabel lblCreate_1;
	private JLabel lblBreakdownOfFees;
	private JLabel lblBreakdown;

	public JComboBox<String> cbDestination;
	
	/**
	 * Create the application.
	 */
	public Gui()
	{
		super ("Johnny Moves");
		initialize();
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		setResizable(false);
		setVisible (true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//	setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));

		// HOME
		pnlHome = new JPanel(null);
		contentPane.add(pnlHome, HOME);
		JLabel lblJohnnyMoves = new JLabel("JOHNNY MOVES");
		lblJohnnyMoves.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 45));
		lblJohnnyMoves.setHorizontalAlignment(SwingConstants.CENTER);
		lblJohnnyMoves.setBounds(0, 6, 490, 100);
		pnlHome.add(lblJohnnyMoves);

		btnCreate = new JButton("Create Parcel");
		btnCreate.setBounds(20, 381, 125, 50);
		pnlHome.add(btnCreate);

		btnTrackParcel = new JButton("Track Parcel");
		btnTrackParcel.setBounds(182, 381, 125, 50);
		pnlHome.add(btnTrackParcel);

		btnExitProgram = new JButton("Exit Program");
		btnExitProgram.setBounds(345, 381, 125, 50);
		pnlHome.add(btnExitProgram);

		taReport = new JTextArea();
		taReport.setLineWrap(true);
		taReport.setWrapStyleWord(true);
		taReport.setEditable(false);
		taReport.setBounds(20, 134, 450, 200);
		pnlHome.add(taReport);

		// CREATE (SET-UP)
		pnlSetup = new JPanel();
		contentPane.add(pnlSetup, SETUP);
		pnlSetup.setLayout(null);

		JLabel lblCount = new JLabel("Number of items to include in the parcel:");
		lblCount.setBounds(40, 254, 259, 16);
		pnlSetup.add(lblCount);

		tfCount = new JTextField();
		tfCount.setBounds(325, 249, 96, 26);
		pnlSetup.add(tfCount);
		tfCount.setColumns(5);

		btnAddItems = new JButton("Add Items");
		btnAddItems.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		btnAddItems.setBounds(182, 337, 125, 50);
		pnlSetup.add(btnAddItems);

		LBL = new JLabel("CREATE");
		LBL.setHorizontalAlignment(SwingConstants.CENTER);
		LBL.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 72));
		LBL.setBounds(6, 6, 478, 93);
		pnlSetup.add(LBL);

		lblNameOfRecipient = new JLabel("Name of Recipient");
		lblNameOfRecipient.setBounds(40, 130, 120, 16);
		pnlSetup.add(lblNameOfRecipient);

		lblDestination = new JLabel("Parcel Destination");
		lblDestination.setBounds(40, 192, 142, 16);
		pnlSetup.add(lblDestination);

		tfName = new JTextField();
		tfName.setBounds(181, 125, 240, 26);
		pnlSetup.add(tfName);
		tfName.setColumns(25);

		cbDestination = new JComboBox<String>();
		cbDestination.setModel(new DefaultComboBoxModel(new String[] {"--- choose ---", "Metro Manila (MML)", "Luzon (LUZ)", "Visayas (VIS)", "Mindanao (MIN)"}));
		cbDestination.setMaximumRowCount(4);
		cbDestination.setBounds(181, 187, 240, 27);
		pnlSetup.add(cbDestination);

		// CREATE
		pnlCreate = new JPanel();
		contentPane.add(pnlCreate, CREATE);
		pnlCreate.setLayout(new BorderLayout(0, 0));

		spltAdd = new JSplitPane();
		pnlCreate.add(spltAdd, BorderLayout.CENTER);

		pnlChoose = new JPanel();
		spltAdd.setLeftComponent(pnlChoose);
		pnlChoose.setLayout(new BorderLayout(0, 0));

		JLabel lblChoose = new JLabel("Choose the type of item.");
		lblChoose.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		lblChoose.setVerticalAlignment(SwingConstants.TOP);
		pnlChoose.add(lblChoose, BorderLayout.NORTH);

		pnlTypes = new JPanel();
		pnlChoose.add(pnlTypes);
		pnlTypes.setLayout(null);

		rdbtnIrregular = new JRadioButton("Irregular Product");
		rdbtnIrregular.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		rdbtnIrregular.setBounds(6, 166, 155, 31);
		pnlTypes.add(rdbtnIrregular);

		rdbtnProduct = new JRadioButton("Product");
		rdbtnProduct.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		rdbtnProduct.setBounds(6, 103, 89, 31);
		pnlTypes.add(rdbtnProduct);

		rdbtnDocument = new JRadioButton("Document");
		rdbtnDocument.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		rdbtnDocument.setBounds(6, 40, 127, 31);
		pnlTypes.add(rdbtnDocument);

		radiobtns = new ButtonGroup();
		radiobtns.add(rdbtnDocument);
		radiobtns.add(rdbtnProduct);
		radiobtns.add(rdbtnIrregular);

		pnlDimensions = new JPanel();
		spltAdd.setRightComponent(pnlDimensions);
		pnlDimensions.setLayout(new BorderLayout(0, 0));

		pnlTally = new JPanel();
		pnlDimensions.add(pnlTally, BorderLayout.SOUTH);

		JLabel lblNumberOfItems = new JLabel("Number of items in the parcel:");
		lblNumberOfItems.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumberOfItems.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		pnlTally.add(lblNumberOfItems);

		JLabel lblTally = new JLabel("");
		lblTally.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		pnlTally.add(lblTally);

		pnlDperType = new JPanel();
		pnlDimensions.add(pnlDperType, BorderLayout.CENTER);
		pnlDperType.setLayout(new CardLayout(0, 0));

		pnlBlank = new JPanel();
		pnlDperType.add(pnlBlank, "BLANK");
		pnlBlank.setLayout(new CardLayout(0, 0));

		pnlDocument = new JPanel();
		pnlDperType.add(pnlDocument, DOCUMENT);
		pnlDocument.setLayout(null);

		JLabel lblDLength = new JLabel("Length");
		lblDLength.setBounds(40, 89, 61, 16);
		pnlDocument.add(lblDLength);

		tfDLength = new JTextField();
		tfDLength.setBounds(128, 84, 130, 26);
		pnlDocument.add(tfDLength);
		tfDLength.setColumns(10);

		JLabel lblDWidth = new JLabel("Width");
		lblDWidth.setBounds(40, 162, 61, 16);
		pnlDocument.add(lblDWidth);

		tfDWidth = new JTextField();
		tfDWidth.setColumns(10);
		tfDWidth.setBounds(128, 157, 130, 26);
		pnlDocument.add(tfDWidth);

		JLabel lblDNoOfPages = new JLabel("No. of Pages");
		lblDNoOfPages.setBounds(37, 235, 79, 16);
		pnlDocument.add(lblDNoOfPages);

		tfDPages = new JTextField();
		tfDPages.setColumns(10);
		tfDPages.setBounds(128, 230, 130, 26);
		pnlDocument.add(tfDPages);

		btnDAddItem = new JButton("Add Item");
		btnDAddItem.setBounds(96, 295, 117, 29);
		pnlDocument.add(btnDAddItem);

		JLabel lblDInput = new JLabel("Please input the following dimensions in INCHES");
		lblDInput.setHorizontalAlignment(SwingConstants.CENTER);
		lblDInput.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblDInput.setBounds(19, 34, 272, 16);
		pnlDocument.add(lblDInput);

		pnlProduct = new JPanel();
		pnlDperType.add(pnlProduct, PRODUCT);
		pnlProduct.setLayout(null);

		JLabel lblPLength = new JLabel("Length");
		lblPLength.setBounds(48, 69, 61, 16);
		pnlProduct.add(lblPLength);

		tfPLength = new JTextField();
		tfPLength.setColumns(10);
		tfPLength.setBounds(136, 64, 130, 26);
		pnlProduct.add(tfPLength);

		JLabel lblPWidth = new JLabel("Width");
		lblPWidth.setBounds(48, 126, 61, 16);
		pnlProduct.add(lblPWidth);

		tfPWidth = new JTextField();
		tfPWidth.setColumns(10);
		tfPWidth.setBounds(136, 121, 130, 26);
		pnlProduct.add(tfPWidth);

		JLabel lblPHeight = new JLabel("Height");
		lblPHeight.setBounds(48, 183, 61, 16);
		pnlProduct.add(lblPHeight);

		tfPHeight = new JTextField();
		tfPHeight.setColumns(10);
		tfPHeight.setBounds(136, 178, 130, 26);
		pnlProduct.add(tfPHeight);

		JLabel lblPWeight = new JLabel("Weight");
		lblPWeight.setBounds(48, 240, 61, 16);
		pnlProduct.add(lblPWeight);

		tfPWeight = new JTextField();
		tfPWeight.setColumns(10);
		tfPWeight.setBounds(136, 235, 130, 26);
		pnlProduct.add(tfPWeight);

		btnPAdd = new JButton("Add Item");
		btnPAdd.setBounds(96, 305, 117, 29);
		pnlProduct.add(btnPAdd);

		JLabel lblPInput = new JLabel("Please input the following dimensions in INCHES");
		lblPInput.setHorizontalAlignment(SwingConstants.CENTER);
		lblPInput.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblPInput.setBounds(13, 23, 283, 16);
		pnlProduct.add(lblPInput);

		pnlIrregular = new JPanel();
		pnlDperType.add(pnlIrregular, IRREGULAR);
		pnlIrregular.setLayout(null);

		JLabel lblILength = new JLabel("Length");
		lblILength.setBounds(43, 69, 61, 16);
		pnlIrregular.add(lblILength);

		tfILength = new JTextField();
		tfILength.setColumns(10);
		tfILength.setBounds(131, 64, 130, 26);
		pnlIrregular.add(tfILength);

		JLabel lblIWidth = new JLabel("Width");
		lblIWidth.setBounds(43, 124, 61, 16);
		pnlIrregular.add(lblIWidth);

		tfIWidth = new JTextField();
		tfIWidth.setColumns(10);
		tfIWidth.setBounds(131, 119, 130, 26);
		pnlIrregular.add(tfIWidth);

		JLabel lblIHeight = new JLabel("Height");
		lblIHeight.setBounds(43, 176, 61, 16);
		pnlIrregular.add(lblIHeight);

		tfIHeight = new JTextField();
		tfIHeight.setColumns(10);
		tfIHeight.setBounds(131, 171, 130, 26);
		pnlIrregular.add(tfIHeight);

		JLabel lblIWeight = new JLabel("Weight");
		lblIWeight.setBounds(43, 233, 61, 16);
		pnlIrregular.add(lblIWeight);

		tfIWeight = new JTextField();
		tfIWeight.setColumns(10);
		tfIWeight.setBounds(131, 228, 130, 26);
		pnlIrregular.add(tfIWeight);

		btnIAdd = new JButton("Add Item");
		btnIAdd.setBounds(96, 296, 117, 29);
		pnlIrregular.add(btnIAdd);

		JLabel lblIInput = new JLabel("Please input the following with the largest dimensions for each in INCHES");
		lblIInput.setHorizontalAlignment(SwingConstants.CENTER);
		lblIInput.setFont(new Font("Lucida Grande", Font.PLAIN, 8));
		lblIInput.setBounds(6, 20, 298, 26);
		pnlIrregular.add(lblIInput);

		pnlCBacktoMenu = new JPanel();
		pnlCreate.add(pnlCBacktoMenu, BorderLayout.SOUTH);
		pnlCBacktoMenu.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		btnBackToMenu = new JButton("Back to Menu");
		btnBackToMenu.setBounds(74, 154, 117, 29);
		pnlCBacktoMenu.add(btnBackToMenu);

		// CHECKOUT
		pnlCheckout = new JPanel();
		contentPane.add(pnlCheckout, CHECKOUT);
		pnlCheckout.setLayout(new CardLayout(0, 0));

		// INSURE
		pnlInsure = new JPanel();
		pnlCheckout.add(pnlInsure, INSURE);
		pnlInsure.setLayout(null);

		JLabel lblInsureParcel = new JLabel("Insure Parcel?");
		lblInsureParcel.setBounds(52, 243, 115, 16);
		pnlInsure.add(lblInsureParcel);

		JLabel lblAvailableParcels = new JLabel("Available Parcels:");
		lblAvailableParcels.setBounds(52, 169, 115, 16);
		pnlInsure.add(lblAvailableParcels);

		JComboBox<String> comboBox = new JComboBox<>();
		comboBox.setModel(new DefaultComboBoxModel<>(new String[] {"----- choose -----"}));
		comboBox.setBounds(213, 164, 228, 27);
		pnlInsure.add(comboBox);

		JLabel lblCreate = new JLabel("CREATE");
		lblCreate.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 72));
		lblCreate.setBounds(91, 41, 308, 71);
		pnlInsure.add(lblCreate);

		btnBreakdown = new JButton("See Breakdown");
		btnBreakdown.setBounds(285, 336, 125, 50);
		pnlInsure.add(btnBreakdown);

		JComboBox<String> comboBox_1 = new JComboBox<>();
		comboBox_1.setModel(new DefaultComboBoxModel<>(new String[] {"-- choose --", "Yes", "No"}));
		comboBox_1.setBounds(300, 238, 141, 27);
		pnlInsure.add(comboBox_1);

		btnBackToMenu_1 = new JButton("Back to Menu");
		btnBackToMenu_1.setBounds(80, 336, 125, 50);
		pnlInsure.add(btnBackToMenu_1);

		// BREAKDOWN
		pnlBreakdown = new JPanel();
		pnlCheckout.add(pnlBreakdown, BREAKDOWN);
		pnlBreakdown.setLayout(null);

		lblCreate_1 = new JLabel("CREATE");
		lblCreate_1.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 72));
		lblCreate_1.setBounds(92, 6, 305, 82);
		pnlBreakdown.add(lblCreate_1);

		lblBreakdownOfFees = new JLabel("Breakdown of Fees:");
		lblBreakdownOfFees.setBounds(73, 103, 133, 16);
		pnlBreakdown.add(lblBreakdownOfFees);

		lblBreakdown = new JLabel("");
		lblBreakdown.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBreakdown.setBounds(73, 131, 324, 199);
		pnlBreakdown.add(lblBreakdown);

		btnBackToMenu_2 = new JButton("Back to Menu");
		btnBackToMenu_2.setBounds(63, 369, 150, 50);
		pnlBreakdown.add(btnBackToMenu_2);

		btnProceed = new JButton("Proceed");
		btnProceed.setBounds(275, 369, 150, 50);
		pnlBreakdown.add(btnProceed);


		// TRACK
		pnlTrack = new JPanel();
		pnlTrack.setVisible(false);
		contentPane.add(pnlTrack, TRACK);
		pnlTrack.setLayout(null);

		JLabel lblInputTrack = new JLabel("Input Tracking Number of Parcel:");

		lblInputTrack.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		lblInputTrack.setHorizontalAlignment(SwingConstants.LEFT);
		lblInputTrack.setBounds(20, 111, 192, 16);
		pnlTrack.add(lblInputTrack);

		tfTracker = new JTextField();
		tfTracker.setBounds(20, 129, 206, 26);
		pnlTrack.add(tfTracker);
		tfTracker.setColumns(40);

		taTracked = new JTextArea();
		taTracked.setBounds(20, 166, 450, 200);
		pnlTrack.add(taTracked);

		btnTrack = new JButton("Track");
		btnTrack.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		btnTrack.setBounds(236, 129, 130, 27);
		pnlTrack.add(btnTrack);

		lblTracking = new JLabel("TRACKING");
		lblTracking.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 42));
		lblTracking.setHorizontalAlignment(SwingConstants.CENTER);
		lblTracking.setBounds(101, 6, 287, 92);
		pnlTrack.add(lblTracking);

		btnTBackToMenu = new JButton("Back to Menu");
		btnTBackToMenu.setBounds(186, 404, 117, 41);
		pnlTrack.add(btnTBackToMenu);



		// EXIT
		pnlExit = new JPanel();
		pnlExit.setVisible(false);
		contentPane.add(pnlExit, EXIT);
		pnlExit.setLayout(null);

		JLabel lblExit = new JLabel("Please input admin password to exit.");
		lblExit.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblExit.setHorizontalAlignment(SwingConstants.CENTER);
		lblExit.setBounds(6, 135, 478, 26);
		pnlExit.add(lblExit);

		pfPassword = new JPasswordField();
		pfPassword.setBounds(127, 196, 235, 26);
		pnlExit.add(pfPassword);

		btnExitPass = new JButton("Exit Program");
		btnExitPass.setBounds(252, 292, 145, 45);
		pnlExit.add(btnExitPass);

		btnEBackToMenu = new JButton("Back to Menu");
		btnEBackToMenu.setBounds(95, 292, 145, 45);
		pnlExit.add(btnEBackToMenu);

		getContentPane().add(contentPane);
	}

	public void addListeners(EventListener listener)
	{
		btnCreate.addActionListener((ActionListener) listener);
		btnTrackParcel.addActionListener((ActionListener) listener);
		btnExitProgram.addActionListener((ActionListener) listener);
		btnAddItems.addActionListener((ActionListener) listener);
		btnDAddItem.addActionListener((ActionListener) listener);;
		btnPAdd.addActionListener((ActionListener) listener);
		btnIAdd.addActionListener((ActionListener) listener);
		btnBackToMenu.addActionListener((ActionListener) listener);
		btnBreakdown.addActionListener((ActionListener) listener);
		btnBackToMenu_2.addActionListener((ActionListener) listener);
		btnProceed.addActionListener((ActionListener) listener);
		btnTrack.addActionListener((ActionListener) listener);
		btnTBackToMenu.addActionListener((ActionListener) listener);
		btnExitPass.addActionListener((ActionListener) listener);
		btnEBackToMenu.addActionListener((ActionListener) listener);

		rdbtnDocument.addActionListener((ActionListener) listener);
		rdbtnProduct.addActionListener((ActionListener) listener);
		rdbtnIrregular.addActionListener((ActionListener) listener);
	}

	public void updateContentPane (String name)
	{
		CardLayout cards = (CardLayout) contentPane.getLayout ();
		cards.show(contentPane, name);
	}

	public void updateDperType (String name)
	{
		CardLayout cards_1 = (CardLayout) pnlDperType.getLayout ();
		cards_1.show(pnlDperType, name);
	}

	public void updateCheckout (String name)
	{
		CardLayout cards_2 = (CardLayout) pnlCheckout.getLayout ();
		cards_2.show(pnlCheckout, name);
	}

	public void clearDDocument ()
	{
		tfDLength.setText(" ");
		tfDWidth.setText(" ");
		tfDPages.setText(" ");
	}

	public void clearDProduct ()
	{
		tfPLength.setText(" ");
		tfPWidth.setText(" ");
		tfPHeight.setText(" ");
		tfPWeight.setText(" ");
	}

	public void clearDIrregular ()
	{
		tfILength.setText(" ");
		tfIWidth.setText(" ");
		tfIHeight.setText(" ");
		tfIWeight.setText(" ");
	}

	// PARCEL INITIALIZATION
	public String getName()
	{
		return tfName.getText();
	}

	public String getDestination()
	{
		if (cbDestination.getSelectedItem().toString().equals("Metro Manila (MML)"))
		{
			return "MML";
		}
		else if (cbDestination.getSelectedItem().toString().equals("Luzon (LUZ)"))
		{
			return "LUZ";
		}
		else if (cbDestination.getSelectedItem().toString().equals("Visayas (VIS)"))
		{
			return "VIS";
		}
		else if (cbDestination.getSelectedItem().toString().equals("Mindanao (MIN)"))
		{
			return "MIN";
		}
		else
			return "--- choose ---";
	}

	public int getNum ()
	{
		return Integer.parseInt(tfCount.getText());
	}

	public Item createItem () throws Exception
	{
		Item item;

		int pages;
		double length, width, height, weight;
		try
		{
			if (rdbtnDocument.getSelectedObjects().toString().equals("Document")) {
				length = Double.parseDouble(tfDLength.getText());
				width = Double.parseDouble(tfDWidth.getText());
				pages = Integer.parseInt(tfDPages.getText());

				if (length > 0 && width > 0 && pages > 0)
					item = new Document(length, width, pages);
				else
					throw new Exception();
			}

			else if (rdbtnProduct.getSelectedObjects().toString().equals("Product")) {
				length = Double.parseDouble(tfPLength.getText());
				width = Double.parseDouble(tfPWidth.getText());
				height = Double.parseDouble(tfPHeight.getText());
				weight = Double.parseDouble(tfPWeight.getText());


				if (length > 0 && width > 0 && height > 0 && weight > 0)
					item = new Product(length, width, height, weight);
				else
					throw new Exception();
			}

			else if (rdbtnIrregular.getSelectedObjects().toString().equals("Irregular Product"))
			{
				length = Double.parseDouble(tfILength.getText());
				width = Double.parseDouble(tfIWidth.getText());
				height = Double.parseDouble(tfIHeight.getText());
				weight = Double.parseDouble(tfIWeight.getText());


				if (length > 0 && width > 0 && height > 0 && weight > 0)
					item = new Irregular(length, width, height, weight);
				else
					throw new Exception();
			}

			else
				throw new Exception();

			return item;
		}
		catch (Exception e)
		{
			throw e;
		}
	}

	public void resetAll ()
	{

			tfName.setText(" ");
			cbDestination.setSelectedIndex(0);
			tfCount.setText(" ");

			tfDLength.setText(" ");
			tfDWidth.setText(" ");
			tfDPages.setText(" ");

			tfPLength.setText(" ");
			tfPWidth.setText(" ");
			tfPHeight.setText(" ");
			tfPWeight.setText(" ");

			tfILength.setText(" ");
			tfIWidth.setText(" ");
			tfIHeight.setText(" ");
			tfIWeight.setText(" ");
	}

	public void setTracker (String s)
	{
		tfTracker.setText(s);
	}
}
