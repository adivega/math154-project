package com.coldline.src.uihandler;

import javax.swing.JButton;
/**
 * interface for clickable single buttons
 * @author adrian erle vega
 *
 */
public interface SingleButtonClickable {
	/**
	 * provides an interface method with the parameters of button type
	 * @param button receives the type button
	 */
	public void makeButtonClickable(JButton button);
}
