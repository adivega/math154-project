package com.coldline.src.factory;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JTextField;

import com.coldline.src.dialogues.Dialogue;
import com.coldline.src.game.StaticData.GameData;
/**
 * class when game state is at nuclear program
 * @author adrian erle vega
 *
 */
public class NuclearProgram extends  CommandFactory implements ChoiceDeterminer{
	/**
	 * polymorphed method from superclass
	 * @param textField received by superclass
	 * @param buttons received by superclass
	 * @param gameData received by superclass
	 */
	public NuclearProgram(JTextField textField, 
			              ArrayList<JButton> buttons, 
			              GameData gameData) {
		
		super(textField, buttons, gameData);
		
		this.processChoices();
	}

	@Override
	public void processChoices() {
		
		final String PREVENT_WAR      = super.gameFileNames.getPreventWarAudioFile(),
				     TYPES_OF_WEAPONS = super.gameFileNames.getTypesOfWeaponsAudioFile(),
				     INVALID_INPUT    = super.gameFileNames.getInvalidInputAudioFile();
		
		switch(super.getTextFromField()) {
			case "1":
				super.gameData.setCurrentInquiry("AdditionalVoiceLineToMainMenu");
				super.dialogue = new Dialogue(PREVENT_WAR);
				break;
			case "2":
				super.gameData.setCurrentInquiry("TypesOfWeapons");
				super.dialogue = new Dialogue(TYPES_OF_WEAPONS);
				break;
			default:
				super.dialogue = new Dialogue(INVALID_INPUT);
				break;
		}
		
		super.audioPlayer.playSelectedAudio(super.dialogue.getAudioFilePath());
		
	}

}
