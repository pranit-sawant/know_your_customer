package com.kyc.ui;

import com.device.api.ui.custom.component.EmbossedButtonField;

import net.rim.device.api.system.Bitmap;
import net.rim.device.api.ui.Color;
import net.rim.device.api.ui.XYEdges;
import net.rim.device.api.ui.component.BasicEditField;
import net.rim.device.api.ui.component.LabelField;
import net.rim.device.api.ui.decor.Border;
import net.rim.device.api.ui.decor.BorderFactory;

// TODO: Auto-generated Javadoc
/**
 * The Class PersonalInfoScreen.
 */
public class PersonalInfoScreen extends KycScreen {

	/** The parent manager. */
	private ForegroundManager parentManager;

	/** The lbl qual. */
	private LabelField lblQual;

	/** The lbl weigh. */
	private LabelField lblWeigh;

	/** The lbl blood grp. */
	private LabelField lblBloodGrp;

	/** The ef qual. */
	private BasicEditField efQual;

	/** The ef weif. */
	private BasicEditField efWeigh;

	/** The ef blood grp. */
	private BasicEditField efBloodGrp;

	/** The btn submit. */
	private EmbossedButtonField btnSubmit;

	/**
	 * Instantiates a new personal info screen.
	 */
	public PersonalInfoScreen() {
		super();
		setTitle("Know your customer");
		initComp();
	}

	/**
	 * Inits the comp.
	 */
	private void initComp() {
		/****/
		lblBloodGrp = new LabelField("Qualificatin: ");
		lblBloodGrp.setMargin(10, 0, 10, 5);
		lblBloodGrp.setBorder(BorderFactory.createRoundedBorder(new XYEdges(8,
				8, 8, 8), Color.LIGHTBLUE, Border.STYLE_FILLED));
		/****/
		lblQual = new LabelField("Weight: ");
		lblQual.setMargin(10, 0, 10, 5);
		lblQual.setBorder(BorderFactory.createRoundedBorder(new XYEdges(8,
				8, 8, 8), Color.LIGHTBLUE, Border.STYLE_FILLED));
		/****/
		lblWeigh = new LabelField("Blood Group: ");
		lblWeigh.setMargin(10, 0, 10, 5);
		lblWeigh.setBorder(BorderFactory.createRoundedBorder(new XYEdges(8,
				8, 8, 8), Color.LIGHTBLUE, Border.STYLE_FILLED));
		/****/
		efBloodGrp = new BasicEditField();
		efBloodGrp.setMargin(10, 0, 10, 5);
		efBloodGrp.setBorder(BorderFactory.createBitmapBorder(new XYEdges(8, 8,
				8, 8), Bitmap.getBitmapResource("myborder.png")));
		/****/
		efQual = new BasicEditField();
		efQual.setMargin(10, 0, 10, 5);
		efQual.setBorder(BorderFactory.createBitmapBorder(new XYEdges(8, 8,
				8, 8), Bitmap.getBitmapResource("myborder.png")));
		/****/
		efWeigh = new BasicEditField();
		efWeigh.setMargin(10, 0, 10, 5);
		efWeigh.setBorder(BorderFactory.createBitmapBorder(new XYEdges(8, 8,
				8, 8), Bitmap.getBitmapResource("myborder.png")));
		/****/
		btnSubmit = new EmbossedButtonField("Submit");
		
	}
}
