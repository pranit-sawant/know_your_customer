/*
* Copyright (c) 2011 Research In Motion Limited.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
* http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

package com.device.api.ui.custom.component;

import net.rim.device.api.system.*;
import net.rim.device.api.ui.*;


// TODO: Auto-generated Javadoc
/**
 * Implements all the stuff we don't want to do each time we need a new button.
 */
public abstract class BaseButtonField extends Field 
{
    
    /** The _draw focus temp rect. */
    private XYRect _drawFocusTempRect = new XYRect();
    
    /**
     * Instantiates a new base button field.
     */
    public BaseButtonField()
    {
        this( 0 );
    }
    
    /**
     * Instantiates a new base button field.
     *
     * @param style the style
     */
    public BaseButtonField( long style )
    {        
        super( Field.FOCUSABLE | style );
    }
        
    /* (non-Javadoc)
     * @see net.rim.device.api.ui.Field#layout(int, int)
     */
    protected void layout( int width, int height )
    {
        setExtent( 10, 10 );
    }
    
    /* (non-Javadoc)
     * @see net.rim.device.api.ui.Field#drawFocus(net.rim.device.api.ui.Graphics, boolean)
     */
    protected void drawFocus( Graphics g, boolean on )
    {
        getFocusRect( _drawFocusTempRect );
    
        boolean oldDrawStyleFocus = g.isDrawingStyleSet( Graphics.DRAWSTYLE_FOCUS );
        boolean notEmpty = g.pushContext( _drawFocusTempRect.x, _drawFocusTempRect.y, _drawFocusTempRect.width, _drawFocusTempRect.height, 0, 0 );

        try {
            if( notEmpty ) {
                g.setDrawingStyle( Graphics.DRAWSTYLE_FOCUS, on );
                paintBackground( g );
                paint( g );
            }
        } finally {
            g.popContext();
            g.setDrawingStyle( Graphics.DRAWSTYLE_FOCUS, oldDrawStyleFocus );
        }
    }
    
    /* (non-Javadoc)
     * @see net.rim.device.api.ui.Field#keyChar(char, int, int)
     */
    protected boolean keyChar( char character, int status, int time ) 
    {
        if( character == Characters.ENTER ) {
            clickButton();
            return true;
        }
        return super.keyChar( character, status, time );
    }
    
    /* (non-Javadoc)
     * @see net.rim.device.api.ui.Field#navigationClick(int, int)
     */
    protected boolean navigationClick( int status, int time ) 
    {
        if (status != 0) clickButton(); 
        return true;    
    }
    
    /* (non-Javadoc)
     * @see net.rim.device.api.ui.Field#trackwheelClick(int, int)
     */
    protected boolean trackwheelClick( int status, int time )
    {        
        if (status != 0) clickButton();    
        return true;
    }
    
    /* (non-Javadoc)
     * @see net.rim.device.api.ui.Field#invokeAction(int)
     */
    protected boolean invokeAction( int action ) 
    {
        switch( action ) {
            case ACTION_INVOKE: {
                clickButton(); 
                return true;
            }
        }
        return super.invokeAction( action );
    }    

    /* (non-Javadoc)
     * @see net.rim.device.api.ui.Field#touchEvent(net.rim.device.api.ui.TouchEvent)
     */
    protected boolean touchEvent( TouchEvent message )
    {
        int x = message.getX( 1 );
        int y = message.getY( 1 );
        if( x < 0 || y < 0 || x > getExtent().width || y > getExtent().height ) {
            // Outside the field
            return false;
        }
        switch( message.getEvent() ) {
       
            case TouchEvent.UNCLICK:
                clickButton();
                return true;
        }
        return super.touchEvent( message );
    }
    
    /* (non-Javadoc)
     * @see net.rim.device.api.ui.Field#setDirty(boolean)
     */
    public void setDirty( boolean dirty ) {
        // We never want to be dirty or muddy
    }
     
    /* (non-Javadoc)
     * @see net.rim.device.api.ui.Field#setMuddy(boolean)
     */
    public void setMuddy( boolean muddy ) {
        // We never want to be dirty or muddy
    }
         
    /**
     * A public way to click this button.
     */
    public void clickButton() 
    {
        fieldChangeNotify( 0 );
    }
}

