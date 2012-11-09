//package com.inbux.component;
//
//import net.rim.device.api.system.Characters;
//import net.rim.device.api.system.GIFEncodedImage;
//import net.rim.device.api.ui.Field;
//import net.rim.device.api.ui.component.LabelField;
//import net.rim.device.api.ui.container.PopupScreen;
//import net.rim.device.api.ui.container.VerticalFieldManager;
//
//import com.inbux.utils.AnimatedGIFField;
//
//public class PleaseWaitPopupScreen extends PopupScreen {
//
//	private AnimatedGIFField anmtFldCycle = null;
//	private LabelField lblMessage = null;
//	private GIFEncodedImage gifImgCycle;
//
//	public PleaseWaitPopupScreen(String text) {
//
//		super(new VerticalFieldManager(VerticalFieldManager.VERTICAL_SCROLL
//				| VerticalFieldManager.VERTICAL_SCROLLBAR));
//		gifImgCycle = (GIFEncodedImage) GIFEncodedImage
//				.getEncodedImageResource("cycle.gif");
//		anmtFldCycle = new AnimatedGIFField(gifImgCycle, Field.FIELD_HCENTER);
//		this.add(anmtFldCycle);
//
//		lblMessage = new LabelField(text, Field.FIELD_HCENTER);
//		this.add(lblMessage);
//	}
//
//	protected boolean keyChar(char c, int status, int time) {
//		// TODO Auto-generated method stub
//		if (c == Characters.ESCAPE) {
//			close();
//		}
//		return super.keyChar(c, status, time);
//	}
//
//}
package com.helper.asynctask;

import net.rim.device.api.system.Characters;
import net.rim.device.api.system.GIFEncodedImage;
import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.component.LabelField;
import net.rim.device.api.ui.container.PopupScreen;
import net.rim.device.api.ui.container.VerticalFieldManager;

public class PleaseWaitPopupScreen extends PopupScreen {

	private LabelField lblMessage = null;

	public PleaseWaitPopupScreen(String text) {




		super(new VerticalFieldManager(VerticalFieldManager.VERTICAL_SCROLL
				| VerticalFieldManager.VERTICAL_SCROLLBAR));
		add(new AnimatedGIFField((GIFEncodedImage) GIFEncodedImage.getEncodedImageResource("greenloadingspinner.gif")));

		lblMessage = new LabelField(text, Field.FIELD_HCENTER);
		this.add(lblMessage);
//		Animator.setFadeAnimation(this);

	}

	protected boolean keyChar(char c, int status, int time) {
		// TODO Auto-generated method stub
		if (c == Characters.ESCAPE) {
			close();
		}
		return super.keyChar(c, status, time);
	}

}
