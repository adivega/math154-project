package com.coldline.src.uihandler;

import javax.swing.JButton;
/**
 * interface for singular button disabling
 * @author adrian erle vega
 *
 */
public interface DisableButton {
	/**
	 * disables the buttons
	 * @param button Jbutton type
	 */
	public void disableButton(JButton button);
	/**
	 * enables the buttons again
	 * @param button JButton type
	 */
	public void enableButton(JButton button);
}
