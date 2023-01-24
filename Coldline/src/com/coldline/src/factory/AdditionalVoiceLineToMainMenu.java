package com.coldline.src.factory;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JTextField;

import com.coldline.src.dialogues.Dialogue;
import com.coldline.src.game.StaticData.GameData;
/**
 * main class for a state of the game in the main menu
 * @author ADRIAN ERLE B. VEGA
 *
 */
public class AdditionalVoiceLineToMainMenu extends CommandFactory implements ChoiceDeterminer{
/**
 * constructor which initializes AdditionalVoiceLineToMainMenu which extends
 * CommandFactory
 * the values of the parameters goes to the superclass 
 * @param textField value is received by the superclass
 * @param buttons value is received by the superclass
 * @param gameData value is received by the superclass
 */
	public AdditionalVoiceLineToMainMenu(JTextField textField, 
			                             ArrayList<JButton> buttons, 
			                             GameData gameData) {
		 
		super(textField, buttons, gameData);
		
		this.processChoices();
	}

	@Override
	public void processChoices() {
		
		final String MAIN_MENU     = super.gameFileNames.getMainMenuAudioFile(),
				     INVALID_INPUT = super.gameFileNames.getInvalidInputAudioFile();
		
		switch(super.getTextFromField()) {
			case "1":
				super.gameData.setCurrentInquiry("MainMenu");
				super.dialogue = new Dialogue(MAIN_MENU);
				break;
			default:
				super.dialogue = new Dialogue(INVALID_INPUT);
				break;
		}
		
		super.audioPlayer.playSelectedAudio(super.dialogue.getAudioFilePath());
		
	}
	
}
