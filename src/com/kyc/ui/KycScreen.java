package com.kyc.ui;

import com.api.util.FontUtilities;
import com.device.api.ui.custom.component.CustomLabelField;
import com.kyc.app.KycApp;

import net.rim.device.api.ui.Color;
import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.UiApplication;
import net.rim.device.api.ui.container.MainScreen;

public class KycScreen extends MainScreen {
	public KycScreen() {
		this(0);
	}

	public KycScreen(long style) {
		super(style);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * net.rim.device.api.ui.container.MainScreen#setTitle(java.lang.String)
	 */
	public void setTitle(String title) {
		CustomLabelField titleLabel = new CustomLabelField(
				title, Color.NAVY, Color.LIGHTBLUE,
				Field.USE_ALL_WIDTH);
		titleLabel.setFont(FontUtilities.getApplicationFont());
		super.setTitle(titleLabel);
	}

	/* (non-Javadoc)
	 * @see net.rim.device.api.ui.container.MainScreen#setTitle(net.rim.device.api.ui.Field)
	 */
	public void setTitle(Field title) {
		title.setFont(FontUtilities.getApplicationFont());
		super.setTitle(title);
	}
	
	/**
	 * Gets the kyc app object.
	 *
	 * @return the kyc app object
	 */
	public KycApp getKycApp(){
		return ((KycApp) UiApplication.getUiApplication());
	}
}
