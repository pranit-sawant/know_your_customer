package com.kyc.app;

import com.kyc.ui.SplashScreen;

import net.rim.device.api.ui.UiApplication;

// TODO: Auto-generated Javadoc
/**
 * The Class KycApp.
 */
public class KycApp extends UiApplication {
	
	/**
	 * Instantiates a new kyc app.
	 */
	public KycApp() {
		pushScreen(new SplashScreen());
	}

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		new KycApp().enterEventDispatcher();
	}
}
