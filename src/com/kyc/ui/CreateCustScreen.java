package com.kyc.ui;

import com.device.api.ui.custom.component.ListStyleButtonField;
import com.device.api.ui.custom.container.ListStyleButtonSet;
import com.kyc.app.KycApp;

import net.rim.device.api.system.Bitmap;
import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.FieldChangeListener;
import net.rim.device.api.ui.Screen;

// TODO: Auto-generated Javadoc
/**
 * The Class CreateCustScreen.
 */
public class CreateCustScreen extends KycScreen {

	/** The caret. */
	private Bitmap bmpCaret = Bitmap
			.getBitmapResource("chevron_right_black_15x22.png");

	/** The parent fore manager. */
	private ForegroundManager parentForeManager;

	/** The link. */
	private ListStyleButtonField link;

	/** The button set. */
	private ListStyleButtonSet buttonSet;
	
	/** The app. */
	private KycApp app;

	/**
	 * Instantiates a new creates the cust screen.
	 */
	public CreateCustScreen() {
		super(NO_VERTICAL_SCROLL | USE_ALL_HEIGHT);
		initComp();
	}

	/**
	 * Inits the comp.
	 */
	private void initComp() {
		app = getKycApp();
		/****/
		parentForeManager = new ForegroundManager();
		/****/
		buttonSet = new ListStyleButtonSet();
		link = new ListStyleButtonField("General Information", bmpCaret);
		link.setChangeListener(new FieldChangeListener() {

			public void fieldChanged(Field field, int context) {
				// TODO Auto-generated method stub
				pushScreen(new GeneralInfoScreen());
			}
		});
		buttonSet.add(link);
		/****/
		link = new ListStyleButtonField("Personal Information", bmpCaret);
		link.setChangeListener(new FieldChangeListener() {

			public void fieldChanged(Field field, int context) {
				// TODO Auto-generated method stub
				pushScreen(new PersonalInfoScreen());
			}
		});

		buttonSet.add(link);
		/****/
		link = new ListStyleButtonField("Picture", bmpCaret);
		link.setChangeListener(new FieldChangeListener() {

			public void fieldChanged(Field field, int context) {
				// TODO Auto-generated method stub
				pushScreen(new GeneralInfoScreen());
			}
		});
		buttonSet.add(link);

		/****/
		link = new ListStyleButtonField("Location", bmpCaret);
		link.setChangeListener(new FieldChangeListener() {

			public void fieldChanged(Field field, int context) {
				// TODO Auto-generated method stub
				// pushScreen(new GeneralInfoScreen());
			}
		});
		buttonSet.add(link);
		parentForeManager.add(buttonSet);
		
		add(parentForeManager);
	}

	/**
	 * Push screen.
	 * 
	 * @param toPush
	 *            the to push
	 */
	private void pushScreen(Screen toPush) {
		app.pushScreen(toPush);
	}
}
