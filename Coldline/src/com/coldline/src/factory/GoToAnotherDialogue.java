package com.coldline.src.factory;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JTextField;

import com.coldline.src.game.StaticData;
/**
 * interface for jumping to another dialogue
 * @author adrian erle vega
 *
 */
public interface GoToAnotherDialogue {
	/**
	 * jumps to another dialogue once game state changes
	 * @param textField type jtextfield
	 * @param buttons type arraylist 
	 * @param gameData type gamedata
	 */
	public void goToAnotherDialogue(JTextField textField, ArrayList<JButton> buttons,
		StaticData.GameData gameData);
}
