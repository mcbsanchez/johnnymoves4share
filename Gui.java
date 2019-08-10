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

public class Gui extends JFrame
{

	public final String BLANK = "Blank";
	public final String HOME = "Home";
	public final String CREATE = "Create Parcel";
	public final String TRACK = "Track Parcel";
	public final String EXIT = "Exit Program";
	public final String DOCUMENT = "Document";
	public final String PRODUCT = "Product";
	public final String IRREGULAR = "Irregular";
	public final String DONE = "Done";
	
	private JPanel contentPane;
	private JPanel pnlHome;
	private JPanel pnlCreate;
	private JPanel pnlCount;
	private JPanel pnlChoose;
	private JPanel pnlTypes;
	private JPanel pnlDimensions;
	private JPanel pnlTally;
	private JPanel pnlDperType;
	private JPanel pnlBlank;
	private JPanel pnlDocument;
	private JPanel pnlProduct;
	private JPanel pnlIrregular;
	private JPanel pnlDone;
	private JPanel pnlTrack;
	private JPanel pnlExit;
	
	private JSplitPane spltAdd;
	
	private JButton btnCreate;
	private JButton btnTrackParcel;
	private JButton btnExitProgram;
	private JButton btnEnter;
	private JButton btnDAddItem;
	private JButton btnPAdd;
	private JButton btnIAdd;
	private JButton btnBackToMenu;
	private JButton btnTrack;
	private JButton btnExitPass;
	
	public ButtonGroup radiobtns;
	
	public JRadioButton rdbtnIrregular;
	public JRadioButton rdbtnProduct;
	public JRadioButton rdbtnDocument;
	
	public JTextField tfCount;
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
	public JTextField tfTracker;
	
	public JPasswordField pfPassword;


	
	/**
	 * Create the application.
	 */
	public Gui() 
	{
		initialize();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
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
					lblJohnnyMoves.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 28));
					lblJohnnyMoves.setHorizontalAlignment(SwingConstants.CENTER);
					lblJohnnyMoves.setBounds(3, 6, 434, 42);
				pnlHome.add(lblJohnnyMoves);
				
				btnCreate = new JButton("Create Parcel");
				btnCreate.setBounds(43, 84, 100, 100);
				pnlHome.add(btnCreate);
				
				btnTrackParcel = new JButton("Track Parcel");
				btnTrackParcel.setBounds(170, 84, 100, 100);
				pnlHome.add(btnTrackParcel);
				
				btnExitProgram = new JButton("Exit Program");
				btnExitProgram.setBounds(294, 84, 100, 100);
				pnlHome.add(btnExitProgram);
			
		// CREATE
				pnlCreate = new JPanel();
				contentPane.add(pnlCreate, CREATE);
				pnlCreate.setLayout(new BorderLayout(0, 0));
				
				pnlCount = new JPanel();
				pnlCreate.add(pnlCount, BorderLayout.NORTH);		
				
				JLabel lblCount = new JLabel("Number of items to include in the parcel:");
				pnlCount.add(lblCount);
				
				tfCount = new JTextField();
				pnlCount.add(tfCount);
				tfCount.setColumns(5);
				
				btnEnter = new JButton("Enter");
				pnlCount.add(btnEnter);
				
				spltAdd = new JSplitPane();
				pnlCreate.add(spltAdd, BorderLayout.CENTER);
				
				pnlChoose = new JPanel();
				spltAdd.setLeftComponent(pnlChoose);
				pnlChoose.setLayout(new BorderLayout(0, 0));
				
				JLabel lblNewLabel_1 = new JLabel("Choose the type of item.");
				lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
				lblNewLabel_1.setVerticalAlignment(SwingConstants.TOP);
				pnlChoose.add(lblNewLabel_1, BorderLayout.NORTH);
				
				pnlTypes = new JPanel();
				pnlChoose.add(pnlTypes, BorderLayout.CENTER);
				pnlTypes.setLayout(null);
				
				rdbtnIrregular = new JRadioButton("Irregular Product");
				rdbtnIrregular.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
				rdbtnIrregular.setBounds(20, 149, 127, 31);
				pnlTypes.add(rdbtnIrregular);
				
				rdbtnProduct = new JRadioButton("Product");
				rdbtnProduct.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
				rdbtnProduct.setBounds(20, 89, 89, 31);
				pnlTypes.add(rdbtnProduct);
				
				rdbtnDocument = new JRadioButton("Document");
				rdbtnDocument.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
				rdbtnDocument.setBounds(20, 29, 127, 31);
				pnlTypes.add(rdbtnDocument);
				
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
				lblTally.setFont(new Font("Lucida Grande", Font.BOLD, 12));
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
				lblDLength.setBounds(20, 41, 61, 16);
				pnlDocument.add(lblDLength);
				
				tfDLength = new JTextField();
				tfDLength.setBounds(108, 36, 130, 26);
				pnlDocument.add(tfDLength);
				tfDLength.setColumns(10);
				
				JLabel lblDWidth = new JLabel("Width");
				lblDWidth.setBounds(20, 80, 61, 16);
				pnlDocument.add(lblDWidth);
				
				tfDWidth = new JTextField();
				tfDWidth.setColumns(10);
				tfDWidth.setBounds(108, 75, 130, 26);
				pnlDocument.add(tfDWidth);
				
				JLabel lblDNoOfPages = new JLabel("No. of Pages");
				lblDNoOfPages.setBounds(20, 122, 79, 16);
				pnlDocument.add(lblDNoOfPages);
				
				tfDPages = new JTextField();
				tfDPages.setColumns(10);
				tfDPages.setBounds(111, 117, 130, 26);
				pnlDocument.add(tfDPages);
				
				btnDAddItem = new JButton("Add Item");
				btnDAddItem.setBounds(71, 157, 117, 29);
				pnlDocument.add(btnDAddItem);
				
				JLabel lblDInput = new JLabel("Please input the following dimensions in INCHES");
				lblDInput.setHorizontalAlignment(SwingConstants.CENTER);
				lblDInput.setFont(new Font("Lucida Grande", Font.PLAIN, 8));
				lblDInput.setBounds(20, 6, 218, 16);
				pnlDocument.add(lblDInput);
				
				pnlProduct = new JPanel();	
				pnlDperType.add(pnlProduct, PRODUCT);
				pnlProduct.setLayout(null);
				
				JLabel lblPLength = new JLabel("Length");
				lblPLength.setBounds(25, 30, 61, 16);
				pnlProduct.add(lblPLength);
				
				tfPLength = new JTextField();
				tfPLength.setColumns(10);
				tfPLength.setBounds(113, 25, 130, 26);
				pnlProduct.add(tfPLength);
				
				JLabel lblPWidth = new JLabel("Width");
				lblPWidth.setBounds(25, 63, 61, 16);
				pnlProduct.add(lblPWidth);
				
				tfPWidth = new JTextField();
				tfPWidth.setColumns(10);
				tfPWidth.setBounds(113, 58, 130, 26);
				pnlProduct.add(tfPWidth);
				
				JLabel lblPHeight = new JLabel("Height");
				lblPHeight.setBounds(25, 96, 61, 16);
				pnlProduct.add(lblPHeight);
				
				tfPHeight = new JTextField();
				tfPHeight.setColumns(10);
				tfPHeight.setBounds(113, 91, 130, 26);
				pnlProduct.add(tfPHeight);
				
				JLabel lblPWeight = new JLabel("Weight");
				lblPWeight.setBounds(25, 129, 61, 16);
				pnlProduct.add(lblPWeight);
				
				tfPWeight = new JTextField();
				tfPWeight.setColumns(10);
				tfPWeight.setBounds(113, 124, 130, 26);
				pnlProduct.add(tfPWeight);
				
				btnPAdd = new JButton("Add Item");
				btnPAdd.setBounds(71, 157, 117, 29);
				pnlProduct.add(btnPAdd);
				
				JLabel lblPInput = new JLabel("Please input the following dimensions in INCHES");
				lblPInput.setHorizontalAlignment(SwingConstants.CENTER);
				lblPInput.setFont(new Font("Lucida Grande", Font.PLAIN, 8));
				lblPInput.setBounds(21, 6, 218, 16);
				pnlProduct.add(lblPInput);
				
				pnlIrregular = new JPanel();
				pnlDperType.add(pnlIrregular, IRREGULAR);
				pnlIrregular.setLayout(null);
				
				JLabel lblILength = new JLabel("Length");
				lblILength.setBounds(25, 33, 61, 16);
				pnlIrregular.add(lblILength);
				
				tfILength = new JTextField();
				tfILength.setColumns(10);
				tfILength.setBounds(113, 28, 130, 26);
				pnlIrregular.add(tfILength);
				
				JLabel lblIWidth = new JLabel("Width");
				lblIWidth.setBounds(25, 66, 61, 16);
				pnlIrregular.add(lblIWidth);
				
				tfIWidth = new JTextField();
				tfIWidth.setColumns(10);
				tfIWidth.setBounds(113, 61, 130, 26);
				pnlIrregular.add(tfIWidth);
				
				JLabel lblIHeight = new JLabel("Height");
				lblIHeight.setBounds(25, 99, 61, 16);
				pnlIrregular.add(lblIHeight);
				
				tfIHeight = new JTextField();
				tfIHeight.setColumns(10);
				tfIHeight.setBounds(113, 94, 130, 26);
				pnlIrregular.add(tfIHeight);
				
				JLabel lblIWeight = new JLabel("Weight");
				lblIWeight.setBounds(25, 132, 61, 16);
				pnlIrregular.add(lblIWeight);
				
				tfIWeight = new JTextField();
				tfIWeight.setColumns(10);
				tfIWeight.setBounds(113, 127, 130, 26);
				pnlIrregular.add(tfIWeight);
				
				btnIAdd = new JButton("Add Item");
				btnIAdd.setBounds(71, 157, 117, 29);
				pnlIrregular.add(btnIAdd);
				
				JLabel lblIInput = new JLabel("Please input the following with the largest dimensions for each in INCHES");
				lblIInput.setHorizontalAlignment(SwingConstants.CENTER);
				lblIInput.setFont(new Font("Lucida Grande", Font.PLAIN, 7));
				lblIInput.setBounds(6, 6, 248, 26);
				pnlIrregular.add(lblIInput);
				
				// DONE ADDING
				pnlDone = new JPanel();
				pnlDperType.add(pnlDone, DONE);
				pnlDone.setLayout(null);
				
				JLabel lblReady = new JLabel("Your parcel is set. The tracking number is:");
				lblReady.setHorizontalAlignment(SwingConstants.CENTER);
				lblReady.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
				lblReady.setBounds(6, 48, 248, 16);
				pnlDone.add(lblReady);
				
				JLabel lblTrackNum = new JLabel("");
				lblTrackNum.setFont(new Font("Lucida Grande", Font.BOLD, 11));
				lblTrackNum.setForeground(Color.BLUE);
				lblTrackNum.setBounds(6, 86, 248, 16);
				pnlDone.add(lblTrackNum);
				
				btnBackToMenu = new JButton("Back to Menu");
				btnBackToMenu.setBounds(74, 154, 117, 29);
				pnlDone.add(btnBackToMenu);
				
				
				
		// TRACK
				pnlTrack = new JPanel();
				pnlTrack.setVisible(false);
				contentPane.add(pnlTrack, TRACK);
				pnlTrack.setLayout(null);
				
				JLabel lblInputTrackingNumber = new JLabel("Input Tracking Number of Parcel:");
				
				lblInputTrackingNumber.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
				lblInputTrackingNumber.setHorizontalAlignment(SwingConstants.CENTER);
				lblInputTrackingNumber.setBounds(65, 33, 309, 16);
				pnlTrack.add(lblInputTrackingNumber);
				
				tfTracker = new JTextField();
				tfTracker.setBounds(75, 61, 179, 26);
				pnlTrack.add(tfTracker);
				tfTracker.setColumns(25);
				
				JTextArea taTracked = new JTextArea();
				taTracked.setBounds(65, 106, 309, 139);
				pnlTrack.add(taTracked);
				
				btnTrack = new JButton("Track");
				btnTrack.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
				btnTrack.setBounds(254, 61, 117, 29);
				pnlTrack.add(btnTrack);
				
				
				
		// EXIT
				pnlExit = new JPanel();
				pnlExit.setVisible(false);
				contentPane.add(pnlExit, EXIT);
				pnlExit.setLayout(null);
				
				JLabel lblExit = new JLabel("Please input admin password to exit.");
				lblExit.setHorizontalAlignment(SwingConstants.CENTER);
				lblExit.setBounds(77, 84, 285, 16);
				pnlExit.add(lblExit);
				
				pfPassword = new JPasswordField();
				pfPassword.setBounds(101, 112, 235, 26);
				pnlExit.add(pfPassword);
				
				btnExitPass = new JButton("Exit Program");
				btnExitPass.setBounds(161, 168, 117, 29);
				pnlExit.add(btnExitPass);
				
			getContentPane().add(contentPane);
	}
	
	public void addListeners(EventListener listener)
	{
		btnCreate.addActionListener((ActionListener) listener);
		btnTrackParcel.addActionListener((ActionListener) listener);
		btnExitProgram.addActionListener((ActionListener) listener);
		btnEnter.addActionListener((ActionListener) listener);
		btnDAddItem.addActionListener((ActionListener) listener);;
		btnPAdd.addActionListener((ActionListener) listener);
		btnIAdd.addActionListener((ActionListener) listener);
		btnBackToMenu.addActionListener((ActionListener) listener);
		btnTrack.addActionListener((ActionListener) listener);
		btnExitPass.addActionListener((ActionListener) listener);
		
		
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
}
