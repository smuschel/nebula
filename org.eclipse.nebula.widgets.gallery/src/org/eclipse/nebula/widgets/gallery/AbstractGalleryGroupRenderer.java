/*******************************************************************************
 * Copyright (c) 2006-2007 Nicolas Richeton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors :
 *    Nicolas Richeton (nicolas.richeton@gmail.com) - initial API and implementation
 *******************************************************************************/
package org.eclipse.nebula.widgets.gallery;

import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;

/**
 * 
 * <p>
 * NOTE: THIS WIDGET AND ITS API ARE STILL UNDER DEVELOPMENT. THIS IS A
 * PRE-RELEASE ALPHA VERSION. USERS SHOULD EXPECT API CHANGES IN FUTURE
 * VERSIONS.
 * </p>
 * 
 * @author Nicolas Richeton (nicolas.richeton@gmail.com)
 */
public abstract class AbstractGalleryGroupRenderer {

	protected Gallery gallery;

	protected boolean expanded;

	protected boolean drawVertically;

	public boolean isDrawVertically() {
		return drawVertically;
	}

	public void setDrawVertically(boolean drawVertically) {
		this.drawVertically = drawVertically;
	}

	/**
	 * Get the expand/collapse state of the current group
	 * 
	 * @return true is the current group is expanded
	 */
	public boolean isExpanded() {
		return expanded;
	}

	public void setExpanded(boolean selected) {
		this.expanded = selected;
	}

	/**
	 * This method is called before drawing the first item. It can be used to
	 * calculate some values (like font metrics) that will be used for each
	 * item.
	 * 
	 * @param gc
	 */
	public void preDraw(GC gc) {

	}

	/**
	 * Group size informations can be retrieved from group. Clipping
	 * informations
	 * 
	 * @param gc
	 * @param group
	 * @param x
	 * @param y
	 */
	public abstract void draw(GC gc, GalleryItem group, int x, int y, int clipX, int clipY, int clipWidth, int clipHeight);

	public abstract void dispose();

	/**
	 * Returns the item that should be selected when the current item is 'item'
	 * and the 'key' is pressed
	 * 
	 * @param item
	 * @param key
	 * @return
	 */
	public abstract GalleryItem getNextItem(GalleryItem item, int key);

	/**
	 * This method is called before the layout of the first item. It can be used
	 * to calculate some values (like font metrics) that will be used for each
	 * item.
	 * 
	 * @param gc
	 */
	public void preLayout(GC gc) {

	}

	public abstract void layout(GC gc, GalleryItem group);

	/**
	 * Returns the item at coords relative to the parent group.
	 * 
	 * @param group
	 * @param coords
	 * @return
	 */
	public abstract GalleryItem getItem(GalleryItem group, Point coords);

	/**
	 * Returns the size of a group.
	 * 
	 * @param item 
	 * @return
	 */
	public abstract Rectangle getSize(GalleryItem item);

	public abstract boolean mouseDown(GalleryItem group, MouseEvent e, Point coords);

	public Gallery getGallery() {
		return gallery;
	}

	public void setGallery(Gallery gallery) {
		this.gallery = gallery;
	}

}
