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

package com.device.api.ui.custom.container;

import com.device.api.ui.custom.component.ListStyleButtonField;

import net.rim.device.api.ui.*;
import net.rim.device.api.ui.container.*;

// TODO: Auto-generated Javadoc
/**
 * The Class ListStyleButtonSet.
 */
public class ListStyleButtonSet extends VerticalFieldManager {
	
	/** The Constant MARGIN. */
	public static final int MARGIN = 15;

	/**
	 * Instantiates a new list style button set.
	 */
	public ListStyleButtonSet() {
		super(NO_VERTICAL_SCROLL);
		setMargin(MARGIN, MARGIN, MARGIN, MARGIN);
	}

	/* (non-Javadoc)
	 * @see net.rim.device.api.ui.container.VerticalFieldManager#sublayout(int, int)
	 */
	protected void sublayout(int maxWidth, int maxHeight) {
		super.sublayout(maxWidth, maxHeight);

		int numChildren = this.getFieldCount();
		if (numChildren > 0) {
			if (numChildren == 1) {
				Field child = getField(0);
				if (child instanceof ListStyleButtonField) {
					((ListStyleButtonField) child)
							.setDrawPosition(ListStyleButtonField.DRAWPOSITION_SINGLE);
				}
			} else {
				int index = 0;
				Field child = getField(index);
				if (child instanceof ListStyleButtonField) {
					((ListStyleButtonField) child)
							.setDrawPosition(ListStyleButtonField.DRAWPOSITION_TOP);
				}
				for (index = 1; index < numChildren - 1; index++) {
					child = getField(index);
					if (child instanceof ListStyleButtonField) {
						((ListStyleButtonField) child)
								.setDrawPosition(ListStyleButtonField.DRAWPOSITION_MIDDLE);
					}
				}
				child = getField(index);
				if (child instanceof ListStyleButtonField) {
					((ListStyleButtonField) child)
							.setDrawPosition(ListStyleButtonField.DRAWPOSITION_BOTTOM);
				}
			}
		}
	}
}
