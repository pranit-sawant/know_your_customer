package com.kyc.ui;

import net.rim.device.api.system.Bitmap;
import net.rim.device.api.system.Display;
import net.rim.device.api.ui.component.BitmapField;
import net.rim.device.api.ui.container.VerticalFieldManager;

import com.kyc.app.KycApp;

// TODO: Auto-generated Javadoc
/**
 * The Class SplashScreen.
 */
public class SplashScreen extends KycScreen {
	
	/** ***** Parent Manager *******. */
	private VerticalFieldManager verManager;

	/** The app. */
	private KycApp app;
	
	/** The bmp kyc scaled. */
	private Bitmap bmpKycScaled;
	
	/** The bmpfld kyc. */
	private BitmapField bmpfldKyc;
	
	/** The scroll. */
	private long scroll;

	/**
	 * Instantiates a new splash screen.
	 */
	public SplashScreen() {
		super(USE_ALL_HEIGHT | DEFAULT_CLOSE | VERTICAL_SCROLL
				| VERTICAL_SCROLLBAR);
		setTitle("Know your customer");
		app = getKycApp();

		verManager = new VerticalFieldManager(FIELD_HCENTER);

		/***************************/
		bmpKycScaled = new Bitmap(Display.getWidth(), Display.getHeight());
		Bitmap.getBitmapResource("splash_screen.png").scaleInto(bmpKycScaled,
				Bitmap.FILTER_LANCZOS);

		bmpfldKyc = new BitmapField(bmpKycScaled, verManager.FIELD_VCENTER);

		verManager.add(bmpfldKyc);
		add(verManager);

		if (Display.getHeight() < 250) {

		}

		// Thread to push HomeScreen after some time
		app.invokeLater(new Runnable() {

			/*
			 * (non-Javadoc)
			 * 
			 * @see java.lang.Runnable#run()
			 */
			public void run() {
				app.popScreen(SplashScreen.this);
				app.pushScreen(new KycLoginScreen());
			}
		}, 500, false);
	}

}
