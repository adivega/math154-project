package com.coldline.src.uihandler;

import java.util.ArrayList;

import javax.swing.JButton;
/**
 * interface for multiple button disabling
 * @author adrian erle vega
 *
 */
public interface DisableMultipleButtons {
	/**
	 * disables a group of buttons
	 * @param buttons arraylist of buttons type
	 */
	public void groupDisable(ArrayList<JButton> buttons);
	/**
	 * enables again a group of buttons
	 * @param buttons arraylist of buttons type
	 */
	public void groupEnable(ArrayList<JButton> buttons);
}
