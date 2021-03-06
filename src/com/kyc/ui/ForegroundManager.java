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

package com.kyc.ui;

import com.device.api.ui.custom.container.NegativeMarginVerticalFieldManager;

import net.rim.device.api.ui.Graphics;

public class ForegroundManager extends NegativeMarginVerticalFieldManager {
    
    public ForegroundManager() {
        super( USE_ALL_HEIGHT | USE_ALL_WIDTH );
    }
    
    protected void paintBackground( Graphics g )
    {
        int oldColor = g.getColor();
        try {
            g.setColor( 0xDDDDDD );
            g.fillRect( 0, getVerticalScroll(), getWidth(), getHeight() );
        } finally {
            g.setColor( oldColor );
        }
    }
}