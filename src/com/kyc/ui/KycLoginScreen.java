package com.kyc.ui;

import net.rim.device.api.system.Bitmap;
import net.rim.device.api.ui.Color;
import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.XYEdges;
import net.rim.device.api.ui.component.BasicEditField;
import net.rim.device.api.ui.component.LabelField;
import net.rim.device.api.ui.component.PasswordEditField;
import net.rim.device.api.ui.decor.Border;
import net.rim.device.api.ui.decor.BorderFactory;

import com.device.api.ui.custom.component.EmbossedButtonField;
import com.device.api.ui.custom.container.JustifiedEvenlySpacedHorizontalFieldManager;
import com.kyc.app.KycApp;

// TODO: Auto-generated Javadoc
/**
 * The Class KycLoginScreen.
 */
public class KycLoginScreen extends KycScreen {

	/** The flbl user name. */
	private Field flblUserName;

	/** The fef user name. */
	private Field fefUserName;

	/** The flbl pass. */
	private Field flblPass;

	/** The fef pass. */
	private Field fefPass;

	/** The hfm usr name. */
	private JustifiedEvenlySpacedHorizontalFieldManager hfmUsrName;

	/** The hfm pass. */
	private JustifiedEvenlySpacedHorizontalFieldManager hfmPass;

	/** The hfm embossed. */
	private JustifiedEvenlySpacedHorizontalFieldManager hfmEmbossed;

	/** The foreground manager. */
	private ForegroundManager foregroundManager;

	/** The btn login. */
	private EmbossedButtonField btnLogin;

	/** The btn cancel. */
	private EmbossedButtonField btnCancel;
	
	/** The app. */
	private KycApp app;

	/**
	 * Instantiates a new kyc login screen.
	 */
	public KycLoginScreen() {
		 super(USE_ALL_HEIGHT | DEFAULT_CLOSE | NO_VERTICAL_SCROLL
		 | VERTICAL_SCROLLBAR);
		setTitle("Know your customer");
		setupComponent();
	}

	/**
	 * Setup component.
	 */
	public void setupComponent() {
		app = getKycApp();
		
		/*************/
		hfmPass = new JustifiedEvenlySpacedHorizontalFieldManager();
		hfmUsrName = new JustifiedEvenlySpacedHorizontalFieldManager();
		// Foreground manager
		foregroundManager = new ForegroundManager();

		// User Name
		flblUserName = new LabelField("User Name", FIELD_HCENTER|USE_ALL_WIDTH);
		
		flblUserName.setMargin(10, 0, 10, 10);
		flblUserName.setPadding(10, 10, 10, 40);
		flblUserName.setBorder(BorderFactory.createRoundedBorder(new XYEdges(8,
				8, 8, 8), Color.LIGHTBLUE, Border.STYLE_FILLED));
		hfmUsrName.add(flblUserName);
		/*********/
		// Edit Field
		fefUserName = new BasicEditField(FIELD_HCENTER|USE_ALL_WIDTH) {
			protected void layout(int width, int height) {

				super.layout(flblUserName.getWidth()/2,
						flblUserName.getHeight() / 2);
				setExtent(flblUserName.getWidth()/2, flblUserName.getHeight() / 2);
			}
		};
		fefUserName.setMargin(10, 0, 10, 10);
		fefUserName.setPadding(5, 5, 5, 5);
		fefUserName.setBorder(BorderFactory.createBitmapBorder(new XYEdges(8,
				8, 8, 8), Bitmap.getBitmapResource("myborder.png")));
		hfmUsrName.add(fefUserName);
		/*************/
		flblPass = new LabelField("Password", FIELD_HCENTER|USE_ALL_WIDTH);
		flblPass.setMargin(10, 0, 10, 10);
		flblPass.setPadding(10, 18, 10, 48);
		flblPass.setBorder(BorderFactory.createRoundedBorder(new XYEdges(8, 8,
				8, 8), Color.LIGHTBLUE, Border.STYLE_FILLED));
		hfmPass.add(flblPass);
		/************/
		fefPass = new PasswordEditField("", "", 10, FIELD_HCENTER|USE_ALL_WIDTH) {
			protected void layout(int width, int height) {
				super.layout(flblUserName.getWidth()/2,
						flblUserName.getHeight() / 2);
				setExtent(flblUserName.getWidth()/2, flblUserName.getHeight() / 2);
			}
		};
		fefPass.setMargin(10, 0, 10, 10);
		fefPass.setPadding(5, 5, 5, 5);
		fefPass.setBorder(BorderFactory.createBitmapBorder(new XYEdges(8, 8, 8,
				8), Bitmap.getBitmapResource("myborder.png")));
		hfmPass.add(fefPass);
		/*************/
		hfmEmbossed = new JustifiedEvenlySpacedHorizontalFieldManager();
		btnLogin = new EmbossedButtonField("Login",USE_ALL_WIDTH);
		btnCancel = new EmbossedButtonField("Cancel",USE_ALL_WIDTH);
		btnLogin.setMargin(10, 0, 10, 10);
		// btnLogin.setPadding(5, 5, 5, 5);
		btnCancel.setMargin(10, 10, 10, 10);
		// btnCancel.setPadding(5, 5, 5, 5);
		hfmEmbossed.add(btnLogin);
		hfmEmbossed.add(btnCancel);
		/************/
		foregroundManager.add(hfmUsrName);
		foregroundManager.add(hfmPass);
		foregroundManager.add(hfmEmbossed);
		add(foregroundManager);
	}
	
	/* (non-Javadoc)
	 * @see net.rim.device.api.ui.Screen#navigationClick(int, int)
	 */
	protected boolean navigationClick(int status, int time) {
		Field field = getLeafFieldWithFocus();
		if(field == btnLogin){
			app.pushScreen(new DashboardScreen());
		}
		return super.navigationClick(status, time);
	}

}
