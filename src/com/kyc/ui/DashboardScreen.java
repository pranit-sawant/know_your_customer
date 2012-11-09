/*
 * 
 */
package com.kyc.ui;

import net.rim.device.api.system.Display;
import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.container.VerticalFieldManager;

import com.device.api.ui.custom.component.EmbossedButtonField;
import com.device.api.ui.custom.container.JustifiedEvenlySpacedHorizontalFieldManager;

// TODO: Auto-generated Javadoc
/**
 * The Class DashboardScreen.
 */
public class DashboardScreen extends KycScreen {
	
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

	/**
	 * Instantiates a new dashboard screen.
	 */
	public DashboardScreen() {
		super(NO_VERTICAL_SCROLL);
		setTitle("Know your customer");
		setupComponent();
	}

	/**
	 * Setup component.
	 */
	private void setupComponent() {
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
	}

}
