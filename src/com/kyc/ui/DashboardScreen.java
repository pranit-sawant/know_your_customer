/*
 * 
 */
package com.kyc.ui;

import net.rim.device.api.system.Display;
import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.FieldChangeListener;
import net.rim.device.api.ui.container.VerticalFieldManager;

import com.device.api.ui.custom.component.EmbossedButtonField;
import com.device.api.ui.custom.container.JustifiedEvenlySpacedHorizontalFieldManager;
import com.kyc.app.KycApp;

// TODO: Auto-generated Javadoc
/**
 * The Class DashboardScreen.
 */
public class DashboardScreen extends KycScreen implements FieldChangeListener{
	
	/** The parent manager. */
	private ForegroundManager parentManager;
	
	/** The vfm parent center. */
	private VerticalFieldManager vfmParentCenter;
	
	/** The hfm cust btn. */
	private JustifiedEvenlySpacedHorizontalFieldManager hfmCustBtn;
	
	/** The hfm sett btn. */
	private JustifiedEvenlySpacedHorizontalFieldManager hfmSettBtn;
	
	/** The btn new cust. */
	private EmbossedButtonField btnNewCust;
	
	/** The btn show cust. */
	private EmbossedButtonField btnShowCust;
	
	/** The btn settings. */
	private EmbossedButtonField btnSettings;
	
	/** The btn download. */
	private EmbossedButtonField btnDownload;
	
	/** The app. */
	private KycApp app;

	/**
	 * Instantiates a new dashboard screen.
	 */
	public DashboardScreen() {
		super(NO_VERTICAL_SCROLL);
		
		setTitle("Know Your Customer");
		
		setupComponent();
	}

	/**
	 * Setup component.
	 */
	private void setupComponent() {
		app = getKycApp();
		// Init manager
		parentManager = new ForegroundManager();
		vfmParentCenter = new VerticalFieldManager();
		hfmCustBtn = new JustifiedEvenlySpacedHorizontalFieldManager(
				Field.FIELD_VCENTER);
		hfmSettBtn = new JustifiedEvenlySpacedHorizontalFieldManager(
				Field.FIELD_VCENTER);

		// Init button
		btnDownload = new EmbossedButtonField("Download", USE_ALL_WIDTH
				| FIELD_HCENTER);
		btnNewCust = new EmbossedButtonField("Create New Cust", USE_ALL_WIDTH
				| FIELD_HCENTER);
		btnSettings = new EmbossedButtonField("Settings", USE_ALL_WIDTH
				| FIELD_HCENTER);
		btnShowCust = new EmbossedButtonField("Show Cust List", USE_ALL_WIDTH
				| FIELD_HCENTER);

		/************/
		int a = Display.getHeight() / 2 - btnDownload.getHeight() / 2;
		hfmCustBtn.setMargin(a - 35, 0, 0, 0);
		hfmCustBtn.add(btnNewCust);
		hfmCustBtn.add(btnShowCust);
		vfmParentCenter.add(hfmCustBtn);

		/************/
		hfmSettBtn.add(btnSettings);
		hfmSettBtn.add(btnDownload);
		vfmParentCenter.add(hfmSettBtn);

		/************/
		parentManager.add(vfmParentCenter);
		add(parentManager);
		
		btnDownload.setChangeListener(this);
		btnNewCust.setChangeListener(this);
		btnSettings.setChangeListener(this);
		btnShowCust.setChangeListener(this);
	}

	/* (non-Javadoc)
	 * @see net.rim.device.api.ui.FieldChangeListener#fieldChanged(net.rim.device.api.ui.Field, int)
	 */
	public void fieldChanged(Field field, int context) {
		if(field == btnNewCust){
			app.pushScreen(new CreateCustScreen());
		}
	}

}
