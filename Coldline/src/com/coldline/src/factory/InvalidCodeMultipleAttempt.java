package com.coldline.src.factory;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JTextField;

import com.coldline.src.dialogues.Dialogue;
import com.coldline.src.game.StaticData.GameData;
/**
 * class when game state is at multiple attempt invalid
 * @author adrian erle vega
 *
 */
public class InvalidCodeMultipleAttempt extends CommandFactory implements ChoiceDeterminer {
	/**
	 * polymorphed method from superclass
	 * @param textField received by superclass
	 * @param buttons received by superclass
	 * @param gameData received by superclass
	 */
	public InvalidCodeMultipleAttempt(JTextField textField, 
			                          ArrayList<JButton> buttons, 
			                          GameData gameData) {
		
		super(textField, buttons, gameData);
		
		this.processChoices();

	}

	@Override
	public void processChoices() {
		
		final String TRY_AGAIN     = super.gameFileNames.getConnectToPresidentAudioFile(),
				     MAIN_MENU     = super.gameFileNames.getMainMenuAudioFile(),
				     INVALID_INPUT = super.gameFileNames.getInvalidInputAudioFile();
		
		switch(super.getTextFromField()) {
			case "1":
				super.gameData.setCurrentInquiry("ConnectToPresident");
				super.dialogue = new Dialogue(TRY_AGAIN);
				break;
			case "2":
				super.gameData.setCodeAttempt(0);
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
