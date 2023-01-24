package com.coldline.src.factory;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JTextField;

import com.coldline.src.dialogues.Dialogue;
import com.coldline.src.game.StaticData;
/**
 * main class for a state of the game ConnectToPresident
 * inherits the methods from superclass CommandFactory and ChoiceDeterminer interface
 * @author ADRIAN ERLE B. VEGA
 *
 */
public class ConnectToPresident extends CommandFactory implements ChoiceDeterminer {
	
	private boolean isCodeCorrect = false;
	/**
	 * polymorphed constructor inherited from CommandFactory
	 * @param textField received by superclass
	 * @param buttons received by superclass
	 * @param gameData received by superclass
	 */
	public ConnectToPresident(JTextField textField, 
			                  ArrayList<JButton> buttons,
			                  StaticData.GameData gameData) {
		
		super(textField, buttons, gameData);
		
		this.processChoices();
		this.checkCodeIfCorrect();
		
	}

	@Override
	public void processChoices() {
		
		final String WELCOME                        = super.gameFileNames.getWelcomeAudioFile(),
				     INVALID_CODE_SINGLE_ATTEMPT    = super.gameFileNames
				     	                              .getInvalidCodeSingleAttemptAudioFile(),
					 INVALID_CODE_MULTIPLE_ATTEMPTS = super.gameFileNames
					 								  .getInvalidCodeMultipleAttemptsAudioFile();
					 								  
		
		switch(super.getTextFromField()) {
			case "060795#":
				super.gameData.setCurrentInquiry("WelcomePrimeMinister");
				super.dialogue = new Dialogue(WELCOME);
				this.isCodeCorrect = true;
				break;
			default:
				super.gameData.setCodeAttempt(super.gameData.getCodeAttempts() + 1);
				if(this.gameData.getCodeAttempts() > 2) {
					super.gameData.setCurrentInquiry("InvalidCodeMultipleAttempt");
					super.dialogue = new Dialogue(INVALID_CODE_MULTIPLE_ATTEMPTS);
				}
				else {
					super.dialogue = new Dialogue(INVALID_CODE_SINGLE_ATTEMPT);
				}
				break;
		}
		
		super.audioPlayer.playSelectedAudio(super.dialogue.getAudioFilePath());
	}
	
	private void checkCodeIfCorrect() {
		if(this.isCodeCorrect == true) {
			this.presidentNotAvailable();
		}
	}
	
	private void presidentNotAvailable() {
		
		final String PRESIDENT_NOT_AVAILABLE = super.gameFileNames.getPresidentNotAvailableAudioFile();
		
		super.dialogue = new Dialogue(PRESIDENT_NOT_AVAILABLE);
		super.audioPlayer.playSelectedAudio(super.dialogue.getAudioFilePath());
		
	}

}
