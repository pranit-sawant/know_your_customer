package com.kyc.ui;

import com.device.api.ui.custom.component.EmbossedButtonField;
import com.kyc.app.KycApp;

import net.rim.device.api.system.Bitmap;
import net.rim.device.api.ui.Color;
import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.FieldChangeListener;
import net.rim.device.api.ui.XYEdges;
import net.rim.device.api.ui.component.BasicEditField;
import net.rim.device.api.ui.component.LabelField;
import net.rim.device.api.ui.container.VerticalFieldManager;
import net.rim.device.api.ui.decor.Border;
import net.rim.device.api.ui.decor.BorderFactory;

// TODO: Auto-generated Javadoc
/**
 * The Class PersonalInfoScreen.
 */
public class PersonalInfoScreen extends KycScreen implements
		FieldChangeListener {

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

	/** The vfm child manager. */
	private VerticalFieldManager vfmChildManager;
	
	/** The app. */
	private KycApp app;

	/**
	 * Instantiates a new personal info screen.
	 */
	public PersonalInfoScreen() {
		super(USE_ALL_HEIGHT);
		setTitle("Know your customer");
		initComp();
	}

	/**
	 * Inits the comp.
	 */
	private void initComp() {
//		app = getKycApp();
		/****/
		lblBloodGrp = new LabelField("Blood Group: ");
		lblBloodGrp.setMargin(10, 0, 10, 5);
		lblBloodGrp.setBorder(BorderFactory.createRoundedBorder(new XYEdges(8,
				8, 8, 8), Color.LIGHTBLUE, Border.STYLE_FILLED));
		/****/
		lblQual = new LabelField("Qualificatin: ");
		lblQual.setMargin(10, 0, 10, 5);
		lblQual.setBorder(BorderFactory.createRoundedBorder(new XYEdges(8, 8,
				8, 8), Color.LIGHTBLUE, Border.STYLE_FILLED));
		/****/
		lblWeigh = new LabelField("Blood Group: ");
		lblWeigh.setMargin(10, 0, 10, 5);
		lblWeigh.setBorder(BorderFactory.createRoundedBorder(new XYEdges(8, 8,
				8, 8), Color.LIGHTBLUE, Border.STYLE_FILLED));
		/****/
		efBloodGrp = new BasicEditField();
		efBloodGrp.setMargin(10, 5, 10, 5);
		efBloodGrp.setBorder(BorderFactory.createBitmapBorder(new XYEdges(8, 8,
				8, 8), Bitmap.getBitmapResource("myborder.png")));
		/****/
		efQual = new BasicEditField();
		efQual.setMargin(10, 5, 10, 5);
		efQual.setBorder(BorderFactory.createBitmapBorder(new XYEdges(8, 8, 8,
				8), Bitmap.getBitmapResource("myborder.png")));
		/****/
		efWeigh = new BasicEditField();
		efWeigh.setMargin(10, 5, 10, 5);
		efWeigh.setBorder(BorderFactory.createBitmapBorder(new XYEdges(8, 8, 8,
				8), Bitmap.getBitmapResource("myborder.png")));
		/****/
		btnSubmit = new EmbossedButtonField("Submit");
		btnSubmit.setMargin(10, 0, 10, 5);
		/****/
		vfmChildManager = new VerticalFieldManager();
		parentManager = new ForegroundManager();
		/****/
		vfmChildManager.add(lblQual);
		vfmChildManager.add(efQual);
		vfmChildManager.add(lblWeigh);
		vfmChildManager.add(efWeigh);
		vfmChildManager.add(lblBloodGrp);
		vfmChildManager.add(efBloodGrp);
		vfmChildManager.add(btnSubmit);

		parentManager.add(vfmChildManager);

		add(parentManager);

		btnSubmit.setChangeListener(this);
	}

	public void fieldChanged(Field field, int context) {
		if(field == btnSubmit){
			
		}
	}
}
