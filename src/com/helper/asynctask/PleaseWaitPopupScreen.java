package com.helper.asynctask;

import com.api.util.FontUtilities;

import net.rim.device.api.system.Characters;
import net.rim.device.api.system.GIFEncodedImage;
import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.component.LabelField;
import net.rim.device.api.ui.container.PopupScreen;
import net.rim.device.api.ui.container.VerticalFieldManager;

// TODO: Auto-generated Javadoc
/**
 * The Class PleaseWaitPopupScreen.
 */
public class PleaseWaitPopupScreen extends PopupScreen {

	/** The anmt fld cycle. */
	private AnimatedGIFField anmtFldCycle = null;
	
	/** The lbl message. */
	private LabelField lblMessage = null;
	
	/** The gif img cycle. */
	private GIFEncodedImage gifImgCycle;

	/**
	 * Instantiates a new please wait popup screen.
	 *
	 * @param text the text
	 */
	public PleaseWaitPopupScreen(String text) {
		
		super(new VerticalFieldManager(VerticalFieldManager.VERTICAL_SCROLL	| VerticalFieldManager.VERTICAL_SCROLLBAR));
		gifImgCycle = (GIFEncodedImage) GIFEncodedImage.getEncodedImageResource("cycle.gif");
		anmtFldCycle = new AnimatedGIFField(gifImgCycle, Field.FIELD_HCENTER);
		this.add(anmtFldCycle);
		
		lblMessage = new LabelField(text, Field.FIELD_HCENTER);
		lblMessage.setFont(FontUtilities.getApplicationFont());
		this.add(lblMessage);

	}

	/* (non-Javadoc)
	 * @see net.rim.device.api.ui.Screen#keyChar(char, int, int)
	 */
	protected boolean keyChar(char c, int status, int time) {
		// TODO Auto-generated method stub
		if (c == Characters.ESCAPE) {
			close();
		}
		return super.keyChar(c, status, time);
	}

}
