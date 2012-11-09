package com.kyc.ui;

import com.device.api.ui.custom.component.EmbossedButtonField;

import net.rim.device.api.system.Bitmap;
import net.rim.device.api.ui.Color;
import net.rim.device.api.ui.XYEdges;
import net.rim.device.api.ui.component.BasicEditField;
import net.rim.device.api.ui.component.LabelField;
import net.rim.device.api.ui.decor.Border;
import net.rim.device.api.ui.decor.BorderFactory;
import net.rim.device.api.ui.text.TextFilter;

public class GeneralInfoScreen extends KycScreen {

	/**
	 * Instantiates a new general info screen.
	 */
	/** The parent manager. */
	private ForegroundManager parentManager;

	/** The lbl first name. */
	private LabelField lblFirstName;

	/** The lbl last name. */
	private LabelField lblLastName;

	/** The lbl user id. */
	private LabelField lblAge;

	/** The ef first name. */
	private BasicEditField efFirstName;

	/** The ef last name. */
	private BasicEditField efLastName;

	/** The ef id. */
	private BasicEditField efAge;

	/** The btn submit. */
	private EmbossedButtonField btnSubmit;

	/**
	 * Instantiates a new general info screen.
	 */
	public GeneralInfoScreen() {
		super();
		setTitle("Know your customer");
		initComp();
	}

	/**
	 * Inits the comp.
	 */
	private void initComp() {
		/****/
		lblFirstName = new LabelField("First Name: ");
		lblFirstName.setMargin(10, 0, 10, 5);
		lblFirstName.setBorder(BorderFactory.createRoundedBorder(new XYEdges(8,
				8, 8, 8), Color.LIGHTBLUE, Border.STYLE_FILLED));
		/****/
		lblLastName = new LabelField("Last Name: ");
		lblLastName.setMargin(10, 0, 10, 5);
		lblLastName.setBorder(BorderFactory.createRoundedBorder(new XYEdges(8,
				8, 8, 8), Color.LIGHTBLUE, Border.STYLE_FILLED));
		/****/
		lblAge = new LabelField("Age: ");
		lblAge.setMargin(10, 0, 10, 5);
		lblAge.setBorder(BorderFactory.createRoundedBorder(new XYEdges(8, 8, 8,
				8), Color.LIGHTBLUE, Border.STYLE_FILLED));
		/****/
		efFirstName = new BasicEditField();
		efFirstName.setMargin(10, 0, 10, 5);
		efFirstName.setBorder(BorderFactory.createBitmapBorder(new XYEdges(8,
				8, 8, 8), Bitmap.getBitmapResource("myborder.png")));
		/****/
		efLastName = new BasicEditField();
		efLastName.setMargin(10, 0, 10, 5);
		efLastName.setBorder(BorderFactory.createBitmapBorder(new XYEdges(8, 8,
				8, 8), Bitmap.getBitmapResource("myborder.png")));
		/****/
		efAge = new BasicEditField();
		efAge.setMargin(10, 0, 10, 5);
		efAge.setBorder(BorderFactory.createBitmapBorder(
				new XYEdges(8, 8, 8, 8), Bitmap
						.getBitmapResource("myborder.png")));
		efAge.setFilter(TextFilter.get(TextFilter.NUMERIC));
		/****/
		btnSubmit = new EmbossedButtonField("Submit");
	}
}
