package com.kyc.ui;

import com.device.api.ui.custom.component.EmbossedButtonField;

import net.rim.device.api.system.Bitmap;
import net.rim.device.api.ui.Color;
import net.rim.device.api.ui.XYEdges;
import net.rim.device.api.ui.component.BasicEditField;
import net.rim.device.api.ui.component.LabelField;
import net.rim.device.api.ui.component.PasswordEditField;
import net.rim.device.api.ui.decor.Border;
import net.rim.device.api.ui.decor.BorderFactory;

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
		lblAccType = new LabelField("FirstName: ");
		lblAccType.setMargin(10, 0, 10, 5);
		lblAccType.setBorder(BorderFactory.createRoundedBorder(new XYEdges(8,
				8, 8, 8), Color.LIGHTBLUE, Border.STYLE_FILLED));
		/****/
		lblContact = new LabelField();
		lblContact.setMargin(10, 0, 10, 5);
		lblContact.setBorder(BorderFactory.createRoundedBorder(new XYEdges(8,
				8, 8, 8), Color.LIGHTBLUE, Border.STYLE_FILLED));
		/****/
		lblFirstName = new LabelField();
		lblFirstName.setMargin(10, 0, 10, 5);
		lblFirstName.setBorder(BorderFactory.createRoundedBorder(new XYEdges(8,
				8, 8, 8), Color.LIGHTBLUE, Border.STYLE_FILLED));
		/****/
		lblGen = new LabelField();
		lblGen.setMargin(10, 0, 10, 5);
		lblGen.setBorder(BorderFactory.createRoundedBorder(new XYEdges(8, 8, 8,
				8), Color.LIGHTBLUE, Border.STYLE_FILLED));
		/****/
		lblLastName = new LabelField();
		lblLastName.setMargin(10, 0, 10, 5);
		lblLastName.setBorder(BorderFactory.createRoundedBorder(new XYEdges(8,
				8, 8, 8), Color.LIGHTBLUE, Border.STYLE_FILLED));
		/****/
		lblPass = new LabelField();
		lblPass.setMargin(10, 0, 10, 5);
		lblPass.setBorder(BorderFactory.createRoundedBorder(new XYEdges(8, 8,
				8, 8), Color.LIGHTBLUE, Border.STYLE_FILLED));
		/****/
		lblRePass = new LabelField();
		lblRePass.setMargin(10, 0, 10, 5);
		lblRePass.setBorder(BorderFactory.createRoundedBorder(new XYEdges(8, 8,
				8, 8), Color.LIGHTBLUE, Border.STYLE_FILLED));
		/****/
		lblZip = new LabelField();
		lblZip.setMargin(10, 0, 10, 5);
		lblZip.setBorder(BorderFactory.createRoundedBorder(new XYEdges(8, 8, 8,
				8), Color.LIGHTBLUE, Border.STYLE_FILLED));
		/****/
		lblUserId = new LabelField();
		lblUserId.setMargin(10, 0, 10, 5);
		lblUserId.setBorder(BorderFactory.createRoundedBorder(new XYEdges(8, 8,
				8, 8), Color.LIGHTBLUE, Border.STYLE_FILLED));
		/****/
		efContact = new BasicEditField();
		efContact.setMargin(10, 0, 10, 5);
		efContact.setBorder(BorderFactory.createBitmapBorder(new XYEdges(8, 8,
				8, 8), Bitmap.getBitmapResource("myborder.png")));
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
		/****/
		pefPass = new PasswordEditField();
		pefPass.setMargin(10, 0, 10, 5);
		pefPass.setBorder(BorderFactory.createBitmapBorder(new XYEdges(8, 8, 8,
				8), Bitmap.getBitmapResource("myborder.png")));
		/****/
		pefRePass = new PasswordEditField();
		pefRePass.setMargin(10, 0, 10, 5);
		pefRePass.setBorder(BorderFactory.createBitmapBorder(new XYEdges(8, 8,
				8, 8), Bitmap.getBitmapResource("myborder.png")));
		/****/
		btnRegister = new EmbossedButtonField("Register", FIELD_HCENTER);
		/****/
	}
}
