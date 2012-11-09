package com.kyc.ui;

import com.device.api.ui.custom.component.EmbossedButtonField;

import net.rim.device.api.system.Bitmap;
import net.rim.device.api.ui.Color;
import net.rim.device.api.ui.XYEdges;
import net.rim.device.api.ui.component.BasicEditField;
import net.rim.device.api.ui.component.LabelField;
import net.rim.device.api.ui.component.PasswordEditField;
import net.rim.device.api.ui.component.RadioButtonField;
import net.rim.device.api.ui.component.RadioButtonGroup;
import net.rim.device.api.ui.container.HorizontalFieldManager;
import net.rim.device.api.ui.container.VerticalFieldManager;
import net.rim.device.api.ui.decor.Border;
import net.rim.device.api.ui.decor.BorderFactory;
import net.rim.device.api.ui.text.TextFilter;

// TODO: Auto-generated Javadoc
/**
 * The Class RegisterScreen.
 */
public class RegisterScreen extends KycScreen {

	/** The parent manager. */
	private ForegroundManager parentManager;

	/** The lbl first name. */
	private LabelField lblFirstName;

	/** The lbl last name. */
	private LabelField lblLastName;

	/** The lbl user id. */
	private LabelField lblUserId;

	/** The lbl pass. */
	private LabelField lblPass;

	/** The lbl re pass. */
	private LabelField lblRePass;

	/** The lbl contact. */
	private LabelField lblContact;

	/** The lbl zip. */
	private LabelField lblZip;

	/** The lbl acc type. */
	private LabelField lblAccType;

	/** The lbl gen. */
	private LabelField lblGen;

	/** The ef first name. */
	private BasicEditField efFirstName;

	/** The ef last name. */
	private BasicEditField efLastName;

	/** The ef id. */
	private BasicEditField efId;

	/** The pef pass. */
	private PasswordEditField pefPass;

	/** The pef re pass. */
	private PasswordEditField pefRePass;

	/** The ef contact. */
	private BasicEditField efContact;

	/** The ef zip. */
	private BasicEditField efZip;

	/** The btn register. */
	private EmbossedButtonField btnRegister;
	
	/** The vfm child manager. */
	private VerticalFieldManager vfmChildManager;
	
	/** The rbg gen. */
	private RadioButtonGroup rbgGen;
	
	/** The rbf male. */
	private RadioButtonField rbfMale;
	
	/** The rbf female. */
	private RadioButtonField rbfFemale;
	
	/** The rbg acc type. */
	private RadioButtonGroup rbgAccType;
	
	/** The rbf agent. */
	private RadioButtonField rbfAgent;
	
	/** The rbf admin. */
	private RadioButtonField rbfAdmin;
	
	/** The hfm radio gen. */
	private HorizontalFieldManager hfmRadioGen;
	
	/** The hfm radio acc. */
	private HorizontalFieldManager hfmRadioAcc;

	/**
	 * Instantiates a new register screen.
	 */
	public RegisterScreen() {
		super(VERTICAL_SCROLL | VERTICAL_SCROLLBAR);
		setTitle("Know Your Customer");
		setupComp();
	}

	/**
	 * Setup comp.
	 */
	private void setupComp() {
		lblAccType = new LabelField("Account Type: ");
		lblAccType.setMargin(10, 0, 10, 5);
		lblAccType.setBorder(BorderFactory.createRoundedBorder(new XYEdges(8,
				8, 8, 8), Color.LIGHTBLUE, Border.STYLE_FILLED));
		/****/
		lblContact = new LabelField("Contact: ");
		lblContact.setMargin(10, 0, 10, 5);
		lblContact.setBorder(BorderFactory.createRoundedBorder(new XYEdges(8,
				8, 8, 8), Color.LIGHTBLUE, Border.STYLE_FILLED));
		/****/
		lblFirstName = new LabelField("First Name: ");
		lblFirstName.setMargin(10, 0, 10, 5);
		lblFirstName.setBorder(BorderFactory.createRoundedBorder(new XYEdges(8,
				8, 8, 8), Color.LIGHTBLUE, Border.STYLE_FILLED));
		/****/
		lblGen = new LabelField("Gender");
		lblGen.setMargin(10, 0, 10, 5);
		lblGen.setBorder(BorderFactory.createRoundedBorder(new XYEdges(8, 8, 8,
				8), Color.LIGHTBLUE, Border.STYLE_FILLED));
		/****/
		lblLastName = new LabelField("Last Name: ");
		lblLastName.setMargin(10, 0, 10, 5);
		lblLastName.setBorder(BorderFactory.createRoundedBorder(new XYEdges(8,
				8, 8, 8), Color.LIGHTBLUE, Border.STYLE_FILLED));
		/****/
		lblPass = new LabelField("Password: ");
		lblPass.setMargin(10, 0, 10, 5);
		lblPass.setBorder(BorderFactory.createRoundedBorder(new XYEdges(8, 8,
				8, 8), Color.LIGHTBLUE, Border.STYLE_FILLED));
		/****/
		lblRePass = new LabelField("Retype Password: ");
		lblRePass.setMargin(10, 0, 10, 5);
		lblRePass.setBorder(BorderFactory.createRoundedBorder(new XYEdges(8, 8,
				8, 8), Color.LIGHTBLUE, Border.STYLE_FILLED));
		/****/
		lblZip = new LabelField("Zip: ");
		lblZip.setMargin(10, 0, 10, 5);
		lblZip.setBorder(BorderFactory.createRoundedBorder(new XYEdges(8, 8, 8,
				8), Color.LIGHTBLUE, Border.STYLE_FILLED));
		/****/
		lblUserId = new LabelField("User Id: ");
		lblUserId.setMargin(10, 0, 10, 5);
		lblUserId.setBorder(BorderFactory.createRoundedBorder(new XYEdges(8, 8,
				8, 8), Color.LIGHTBLUE, Border.STYLE_FILLED));
		/****/
		efContact = new BasicEditField();
		efContact.setMargin(10, 0, 10, 5);
		efContact.setBorder(BorderFactory.createBitmapBorder(new XYEdges(8, 8,
				8, 8), Bitmap.getBitmapResource("myborder.png")));
		efContact.setFilter(TextFilter.get(TextFilter.PHONE));
		/****/
		efFirstName = new BasicEditField();
		efFirstName.setMargin(10, 0, 10, 5);
		efFirstName.setBorder(BorderFactory.createBitmapBorder(new XYEdges(8,
				8, 8, 8), Bitmap.getBitmapResource("myborder.png")));
		/****/
		efId = new BasicEditField();
		efId.setMargin(10, 0, 10, 5);
		efId.setBorder(BorderFactory.createBitmapBorder(
				new XYEdges(8, 8, 8, 8), Bitmap
						.getBitmapResource("myborder.png")));
		/****/
		efLastName = new BasicEditField();
		efLastName.setMargin(10, 0, 10, 5);
		efLastName.setBorder(BorderFactory.createBitmapBorder(new XYEdges(8, 8,
				8, 8), Bitmap.getBitmapResource("myborder.png")));
		/****/
		efZip = new BasicEditField();
		efZip.setMargin(10, 0, 10, 5);
		efZip.setBorder(BorderFactory.createBitmapBorder(
				new XYEdges(8, 8, 8, 8), Bitmap
						.getBitmapResource("myborder.png")));
		efZip.setFilter(TextFilter.get(TextFilter.NUMERIC));
		/****/
		pefPass = new PasswordEditField("", "", 10, USE_ALL_WIDTH);
		pefPass.setMargin(10, 0, 10, 5);
		pefPass.setBorder(BorderFactory.createBitmapBorder(new XYEdges(8, 8, 8,
				8), Bitmap.getBitmapResource("myborder.png")));
		/****/
		pefRePass = new PasswordEditField("", "", 10, USE_ALL_WIDTH);
		pefRePass.setMargin(10, 0, 10, 5);
		pefRePass.setBorder(BorderFactory.createBitmapBorder(new XYEdges(8, 8,
				8, 8), Bitmap.getBitmapResource("myborder.png")));
		/****/
		btnRegister = new EmbossedButtonField("Register", FIELD_HCENTER);
		/****/
		rbgAccType = new RadioButtonGroup();
		rbfAdmin = new RadioButtonField("Admin", rbgAccType, true);
		rbfAgent = new RadioButtonField("Agent", rbgAccType, false);
		/****/
		rbgGen = new RadioButtonGroup();
		rbfFemale = new RadioButtonField("Female", rbgGen, false);
		rbfMale = new RadioButtonField("Male", rbgGen, true);
		/****/
		parentManager = new ForegroundManager();
		vfmChildManager = new VerticalFieldManager(VERTICAL_SCROLL|VERTICAL_SCROLLBAR);
		hfmRadioAcc = new HorizontalFieldManager(USE_ALL_WIDTH);
		hfmRadioGen = new HorizontalFieldManager(USE_ALL_WIDTH);
		/****/
		vfmChildManager.add(lblFirstName);
		vfmChildManager.add(efFirstName);
		vfmChildManager.add(lblLastName);
		vfmChildManager.add(efLastName);
		vfmChildManager.add(lblUserId);
		vfmChildManager.add(efId);
		vfmChildManager.add(lblPass);
		vfmChildManager.add(pefPass);
		vfmChildManager.add(lblRePass);
		vfmChildManager.add(pefRePass);
		vfmChildManager.add(lblContact);
		vfmChildManager.add(efContact);
		vfmChildManager.add(lblZip);
		vfmChildManager.add(efZip);
		vfmChildManager.add(lblAccType);
		hfmRadioAcc.add(rbfAdmin);
		hfmRadioAcc.add(rbfAgent);
		vfmChildManager.add(hfmRadioAcc);
		vfmChildManager.add(lblGen);
		hfmRadioGen.add(rbfMale);
		hfmRadioGen.add(rbfFemale);
		vfmChildManager.add(hfmRadioGen);
		vfmChildManager.add(btnRegister);
		
		parentManager.add(vfmChildManager);
		add(parentManager);
	}
}
