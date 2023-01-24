package com.coldline.src.factory;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JTextField;

import com.coldline.src.dialogues.Dialogue;
import com.coldline.src.game.StaticData.GameData;
/**
 * class when game state is at to continue
 * @author adrian erle vega
 *
 */
public class ToContinue extends CommandFactory implements ChoiceDeterminer {
	/**
	 * initializes method which sends values to superclass 
	 * @param textField type JTextField
	 * @param buttons arraylist type
	 * @param gameData object from StaticData
	 */
	public ToContinue(JTextField textField, 
			          ArrayList<JButton> buttons, 
			          GameData gameData) {
		
		super(textField, buttons, gameData);
		
		this.processChoices();
	}

	@Override
	public void processChoices() {
		
		final String REALLY_SURE   = super.gameFileNames.getReallySureAudioFile(),
				     MAIN_MENU     = super.gameFileNames.getMainMenuAudioFile(),
				     INVALID_INPUT = super.gameFileNames.getInvalidInputAudioFile();
		
		switch(super.getTextFromField()) {
			case "1":
				super.gameData.setCurrentInquiry("ReallySure");
				super.dialogue = new Dialogue(REALLY_SURE);
				break;
			case "2":
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
