package com.coldline.src.uihandler;

import java.util.ArrayList;

import javax.swing.JButton;
/**
 * group disable change of states
 * @author adrian erle vega
 *
 */
public class GroupDisable implements DisableButton, DisableMultipleButtons{

	@Override
	public void groupDisable(ArrayList<JButton> buttons) {
		for(JButton button : buttons) {
			this.disableButton(button);
		}
	}

	@Override
	public void groupEnable(ArrayList<JButton> buttons) {
		for(JButton button : buttons) {
			this.enableButton(button);
		}
	}

	@Override
	public void disableButton(JButton button) {
		button.setEnabled(false);
	}

	@Override
	public void enableButton(JButton button) {
		button.setEnabled(true);
	}

	
}
