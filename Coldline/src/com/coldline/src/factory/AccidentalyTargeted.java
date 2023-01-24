package com.coldline.src.factory;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JTextField;

import com.coldline.src.dialogues.Dialogue;
import com.coldline.src.game.StaticData.GameData;
/**
 * main class for a state of the game accidentally targeted
 * @author ADRIAN ERLE B. VEGA
 *
 */
public class AccidentalyTargeted extends CommandFactory {
/**
 * constructor which initializes AccidentallyTargeted which extends
 * CommandFactory
 * the values of the parameters goes to the superclass 
 * @param textField value is received by the superclass
 * @param buttons value is received by the superclass
 * @param gameData value is received by the superclass
 */
	public AccidentalyTargeted(JTextField textField, 
			                ArrayList<JButton> buttons, 
			                GameData gameData) {
		
		super(textField, buttons, gameData);
		
		this.oneChoice();
	}
	
	private void oneChoice() {
		
		final String NEED_PERMISSION = super.gameFileNames.getNeedPermissionCodeAudioFile(),
				     INVALID_INPUT   = super.gameFileNames.getInvalidInputAudioFile();
		
		switch(super.getTextFromField()) {
			case "1":
				super.gameData.setCurrentInquiry("NeedPermission");
				super.dialogue = new Dialogue(NEED_PERMISSION);
				break;
			default:
				super.dialogue = new Dialogue(INVALID_INPUT);
				break;
				
		}
		
		super.audioPlayer.playSelectedAudio(super.dialogue.getAudioFilePath());
		
	}

}
