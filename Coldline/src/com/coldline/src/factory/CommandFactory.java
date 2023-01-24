package com.coldline.src.factory;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JTextField;

import com.coldline.src.dialogues.Dialogue;
import com.coldline.src.game.GameFileNameInitializer;
import com.coldline.src.game.PlayAudio;
import com.coldline.src.game.StaticData;
import com.coldline.src.uihandler.TextFieldGetter;

/**
 * parent class for polymorphism
 * extends to several classes
 * applies and the values from the subclasses in this class
 * @author ADRIAN ERLE B. VEGA
 *
 */

public class CommandFactory implements TextFieldGetter, GameFileNameInitializer{
/**
 * constructs initializeGameFileNames() and also sets and receives 
 * the values of the different parameters.
 * initializes PlayAudio class
 */
	private JTextField textField;
	
	protected Dialogue dialogue;
	protected PlayAudio audioPlayer;
	protected StaticData.GameData gameData;
	protected StaticData.GameFileNames gameFileNames;
	/**
	 * receives the parameters
	 * @param textField type JTextField
	 * @param buttons receives buttons values
	 * @param gameData type StaticData.GameData
	 */
	public CommandFactory(JTextField textField,
			              ArrayList<JButton> buttons,
			              StaticData.GameData gameData) {
		
		this.textField = textField;
		this.gameData  = gameData;
		
		this.initializeGameFileNames();
		this.audioPlayer = new PlayAudio(this.getTextField(),
				           buttons);
	}
	
	protected String getTextFromField() {
		return this.textField.getText();
	}
	
	@Override
	public JTextField getTextField() {
		return this.textField;
	}

	@Override
	public void initializeGameFileNames() {
		this.gameFileNames = new StaticData.GameFileNames();
	}
	
}
