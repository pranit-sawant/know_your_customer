

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

package com.api.util;

import net.rim.device.api.ui.*;


import net.rim.device.api.ui.decor.*;
// TODO: Auto-generated Javadoc



/**
 * The Class FieldDimensionUtilities.
 */
public class FieldDimensionUtilities
{
    
    /**
     * Instantiates a new field dimension utilities.
     */
    private FieldDimensionUtilities() { }
    
    /**
     * Gets the border width.
     *
     * @param field the field
     * @return the border width
     */
    public static int getBorderWidth( Field field )
    {
        int width = 0;




        Border border = field.getBorder();
        if( border != null ) {
            width = border.getLeft() + border.getRight();
        }

        return width;
    }
    
    /**
     * Gets the border height.
     *
     * @param field the field
     * @return the border height
     */
    public static int getBorderHeight( Field field )
    {
        int height = 0;
        



        Border border = field.getBorder();
        if( border != null ) {
            height = border.getTop() + border.getBottom();
        }

        return height;
    }

    /**
     * Gets the border and padding width.
     *
     * @param field the field
     * @return the border and padding width
     */
    public static int getBorderAndPaddingWidth( Field field )
    {
        int width = 0;



        width = field.getPaddingLeft() + field.getPaddingRight();
        Border border = field.getBorder();
        if( border != null ) {
            width += border.getLeft() + border.getRight();
        }

        return width;
    }

    /**
     * Gets the border and padding height.
     *
     * @param field the field
     * @return the border and padding height
     */
    public static int getBorderAndPaddingHeight( Field field )
    {
        int height = 0;



        height = field.getPaddingTop() + field.getPaddingBottom();
        Border border = field.getBorder();
        if( border != null ) {
            height += border.getTop() + border.getBottom();
        }

        return height;
    }

}
