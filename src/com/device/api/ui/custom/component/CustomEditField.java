package com.device.api.ui.custom.component;

import net.rim.device.api.system.Bitmap;
import net.rim.device.api.ui.XYEdges;
import net.rim.device.api.ui.component.EditField;
import net.rim.device.api.ui.decor.BorderFactory;

public class CustomEditField extends EditField {
	
	private int height = 0;
	private int width = 0;
	
	public CustomEditField(){
		super();		
	}
	
	public CustomEditField(long style) {
		super(null, null, 1, style);
		
		
	}
	
	public CustomEditField(int height,int width, int maxChars,long style) {
		super(null, null, maxChars, style);
		this.height = height;
		this.width = width;
	}

	public void layout(int width, int height) {
		super.layout(getPreferredWidth(), getPreferredHeight());
		setExtent(getPreferredWidth(), getPreferredHeight());
	}

	public int getPreferredWidth() {
		return width;
	}

	public int getPreferredHeight() {
		return height;
	}
	
	protected void onFocus(int direction) {
		super.onFocus(direction);
		
		setBorder(BorderFactory.createBitmapBorder(new XYEdges(
				10, 10, 10, 10), Bitmap.getBitmapResource("myborder.png")));
		
		invalidate();
	}

	protected void onUnfocus() {
		super.onUnfocus();
		
		setBorder(BorderFactory.createBitmapBorder(new XYEdges(
				10, 10, 10, 10), Bitmap.getBitmapResource("border_edit.png")));
		invalidate();
	}
}
