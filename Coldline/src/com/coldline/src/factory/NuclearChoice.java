package com.coldline.src.factory;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JTextField;

import com.coldline.src.dialogues.Dialogue;
import com.coldline.src.game.StaticData.GameData;
/**
 * class when game state is at nuclear choice
 * @author adrian erle vega
 *
 */
public class NuclearChoice extends CommandFactory implements ChoiceDeterminer {
	/**
	 * polymorphed method from superclass
	 * @param textField received by superclass
	 * @param buttons received by superclass
	 * @param gameData received by superclass
	 */
	public NuclearChoice(JTextField textField, 
			             ArrayList<JButton> buttons, 
			             GameData gameData) {
		
		super(textField, buttons, gameData);
		
		this.processChoices();
		
	}

	@Override
	public void processChoices() {
		
		final String COUNTRY_IN_DANGER     = super.gameFileNames.getCountryInDangerAudioFile(),
				     COUNTRY_NOT_IN_DANGER = super.gameFileNames.getCountryNotInDangerAudioFile(),
				     INVALID_INPUT         = super.gameFileNames.getInvalidInputAudioFile();
		
		switch(super.getTextFromField()) {
			case "1":
				super.gameData.setCurrentInquiry("AdditionalVoiceLineToMainMenu");
				super.dialogue = new Dialogue(COUNTRY_NOT_IN_DANGER);
				break;
			case "2":
				super.gameData.setCurrentInquiry("AccidentalyTargeted");
				super.dialogue = new Dialogue(COUNTRY_IN_DANGER);
				break;
			default:
				super.dialogue = new Dialogue(INVALID_INPUT);
				break;
		}
		
		super.audioPlayer.playSelectedAudio(super.dialogue.getAudioFilePath());
		
	}

}
