package com.kyc.ui;

import org.json.me.JSONException;
import org.json.me.JSONObject;

import net.rim.device.api.system.Bitmap;
import net.rim.device.api.ui.Color;
import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.XYEdges;
import net.rim.device.api.ui.component.BasicEditField;
import net.rim.device.api.ui.component.Dialog;
import net.rim.device.api.ui.component.LabelField;
import net.rim.device.api.ui.component.PasswordEditField;
import net.rim.device.api.ui.decor.Border;
import net.rim.device.api.ui.decor.BorderFactory;

import com.device.api.ui.custom.component.EmbossedButtonField;
import com.device.api.ui.custom.container.JustifiedEvenlySpacedHorizontalFieldManager;
import com.helper.JSONParser;
import com.helper.asynctask.AsyncTask;
import com.helper.asynctask.PleaseWaitPopupScreen;
import com.kyc.app.KycApp;

// TODO: Auto-generated Javadoc
/**
 * The Class KycLoginScreen.
 */
public class KycLoginScreen extends KycScreen {

	/** The flbl user name. */
	private Field flblUserName;

	/** The fef user name. */
	private BasicEditField fefUserName;

	/** The flbl pass. */
	private Field flblPass;

	/** The fef pass. */
	private PasswordEditField fefPass;

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

	/** The btn Register. */
	private EmbossedButtonField btnRegister;

	/** The app. */
	private KycApp app;

	/** The parser. */
	private JSONParser parser;

	/** The j obj. */
	private JSONObject jObj;

	/** The url. */
	private String url = "";

	// JSON node name
	/** The Constant AUTHONTICATED. */
	private static final String AUTHONTICATED = "authenticated";

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
		parser = new JSONParser();
		/*************/
		hfmPass = new JustifiedEvenlySpacedHorizontalFieldManager();
		hfmUsrName = new JustifiedEvenlySpacedHorizontalFieldManager();
		// Foreground manager
		foregroundManager = new ForegroundManager();

		// User Name
		flblUserName = new LabelField("User Name", FIELD_HCENTER
				| USE_ALL_WIDTH);

		flblUserName.setMargin(10, 0, 10, 10);
		flblUserName.setPadding(10, 10, 10, 40);
		flblUserName.setBorder(BorderFactory.createRoundedBorder(new XYEdges(8,
				8, 8, 8), Color.LIGHTBLUE, Border.STYLE_FILLED));
		hfmUsrName.add(flblUserName);
		/*********/
		// Edit Field
		fefUserName = new BasicEditField(FIELD_HCENTER | USE_ALL_WIDTH) {
			protected void layout(int width, int height) {

				super.layout(flblUserName.getWidth() / 2, flblUserName
						.getHeight() / 2);
				setExtent(flblUserName.getWidth() / 2,
						flblUserName.getHeight() / 2);
			}
		};
		fefUserName.setMargin(10, 0, 10, 10);
		fefUserName.setPadding(5, 5, 5, 5);
		fefUserName.setBorder(BorderFactory.createBitmapBorder(new XYEdges(8,
				8, 8, 8), Bitmap.getBitmapResource("myborder.png")));
		hfmUsrName.add(fefUserName);
		/*************/
		flblPass = new LabelField("Password", FIELD_HCENTER | USE_ALL_WIDTH);
		flblPass.setMargin(10, 0, 10, 10);
		flblPass.setPadding(10, 18, 10, 48);
		flblPass.setBorder(BorderFactory.createRoundedBorder(new XYEdges(8, 8,
				8, 8), Color.LIGHTBLUE, Border.STYLE_FILLED));
		hfmPass.add(flblPass);
		/************/
		fefPass = new PasswordEditField("", "", 10, FIELD_HCENTER
				| USE_ALL_WIDTH) {
			protected void layout(int width, int height) {
				super.layout(flblUserName.getWidth() / 2, flblUserName
						.getHeight() / 2);
				setExtent(flblUserName.getWidth() / 2,
						flblUserName.getHeight() / 2);
			}
		};
		fefPass.setMargin(10, 0, 10, 10);
		fefPass.setPadding(5, 5, 5, 5);
		fefPass.setBorder(BorderFactory.createBitmapBorder(new XYEdges(8, 8, 8,
				8), Bitmap.getBitmapResource("myborder.png")));
		hfmPass.add(fefPass);
		/*************/
		hfmEmbossed = new JustifiedEvenlySpacedHorizontalFieldManager();
		btnLogin = new EmbossedButtonField("Login", USE_ALL_WIDTH);
		btnRegister = new EmbossedButtonField("Register", USE_ALL_WIDTH);
		btnLogin.setMargin(10, 0, 10, 10);
		// btnLogin.setPadding(5, 5, 5, 5);
		btnRegister.setMargin(10, 10, 10, 10);
		// btnCancel.setPadding(5, 5, 5, 5);
		hfmEmbossed.add(btnLogin);
		hfmEmbossed.add(btnRegister);
		/************/
		foregroundManager.add(hfmUsrName);
		foregroundManager.add(hfmPass);
		foregroundManager.add(hfmEmbossed);
		add(foregroundManager);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.rim.device.api.ui.Screen#navigationClick(int, int)
	 */
	protected boolean navigationClick(int status, int time) {
		Field field = getLeafFieldWithFocus();
		if (field == btnLogin) {

			new AuthUserTask().onExecute();
		}
		
		if (field == btnRegister) {
			app.pushScreen(new RegisterScreen());
		}
		
		return super.navigationClick(status, time);
	}

	/**
	 * The Class AuthUserTask.
	 */
	class AuthUserTask extends AsyncTask {

		/** The popup screen. */
		private PleaseWaitPopupScreen popupScreen;

		/*
		 * (non-Javadoc)
		 * 
		 * @see com.helper.asynctask.AsyncTask#doInBackground()
		 */
		public void doInBackground() {
			final String user = fefUserName.getText().trim();
			final String pass = fefPass.getText().trim();

			if (user.length() > 0 && pass.length() > 0) {
				url = "http://10.0.10.52:8084/KYC-WEB/auth?id=" + user
						+ "&pwd=" + pass;
				final String str = url;
				try {
					jObj = (JSONObject) parser.getJsonFromUrl(url);

					app.invokeLater(new Runnable() {

						public void run() {
							try {
								Dialog.alert("Error: "
										+ jObj.getBoolean(AUTHONTICATED) + "  "
										+ str);
							} catch (JSONException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					});
				} catch (final Exception e) {
					app.invokeLater(new Runnable() {

						public void run() {
							Dialog.alert("Error: " + e.getMessage());
						}
					});

				}
			}
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see com.helper.asynctask.AsyncTask#onPostExecute()
		 */
		public void onPostExecute() {
			app.popScreen(popupScreen);
			if (jObj != null) {
				try {
					if (jObj.getBoolean(AUTHONTICATED)) {
						app.pushScreen(new DashboardScreen());
					} else {
						app.invokeLater(new Runnable() {

							public void run() {
								Dialog.alert("fatal: Authentication failed");
							}
						});
					}
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else{
				app.invokeLater(new Runnable() {

					public void run() {
						Dialog.alert("User name & password field can not be empty !");
					}
				});
			}
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see com.helper.asynctask.AsyncTask#onPreExecute()
		 */
		public void onPreExecute() {
			popupScreen = new PleaseWaitPopupScreen("wait..");
			app.pushScreen(popupScreen);
		}

	}

}
