package com.api.util;

import net.rim.device.api.ui.Font;
import net.rim.device.api.ui.FontFamily;

// TODO: Auto-generated Javadoc
/**
 * The Class FontUtilities.
 */
public class FontUtilities {
	
	/**
	 * Instantiates a new font utilities.
	 */
	public FontUtilities(){
		
	}

    /**
     * Gets the application font.
     *
     * @return the application font
     */
    public static Font getApplicationFont(){
		
		FontFamily fontFamily[] = FontFamily.getFontFamilies();
//	    Font font = fontFamily[1].getFont(FontFamily.CBTF_FONT, 17);
		Font font = fontFamily[1].getFont(0,FontUtilities.getApplicationFontHeight());
		return font;
	}
    
    /**
     * Gets the application font height.
     *
     * @return the application font height
     */
    public static int getApplicationFontHeight(){    	
    	return 20;
    }
}
