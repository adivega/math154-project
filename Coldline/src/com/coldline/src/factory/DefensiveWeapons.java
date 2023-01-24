package com.coldline.src.factory;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JTextField;

import com.coldline.src.dialogues.Dialogue;
import com.coldline.src.game.StaticData.GameData;
/**
 * class when game state is at defensive weapons
 * @author adrian erle vega
 *
 */
public class DefensiveWeapons extends CommandFactory implements ChoiceDeterminer{
	/**
	 * polymorphed method from superclass
	 * @param textField received by superclass
	 * @param buttons received by superclass
	 * @param gameData received by superclass
	 */
	public DefensiveWeapons(JTextField textField, 
			                ArrayList<JButton> buttons, 
			                GameData gameData) {
		
		super(textField, buttons, gameData);
		
		this.processChoices();
	}

	@Override
	public void processChoices() {
		
		final String SPEED                = super.gameFileNames.getSpeedAudioFile(),
			         INTERCEPTION_METHODS = super.gameFileNames.getInterceptionMethodsAudioFile(),
			         WEAPON_TYPE          = super.gameFileNames.getTypesOfWeaponsAudioFile(),
			         INVALID_INPUT        = super.gameFileNames.getInvalidInputAudioFile();
		
		switch(super.getTextFromField()) {
			case "1":
				super.gameData.setCurrentInquiry("Speed");
				super.dialogue = new Dialogue(SPEED);
				break;
			case "2":
				super.gameData.setCurrentInquiry("InterceptionMethods");
				super.dialogue = new Dialogue(INTERCEPTION_METHODS);
				break;
			case "3":
				super.gameData.setCurrentInquiry("TypesOfWeapons");
				super.dialogue = new Dialogue(WEAPON_TYPE);
				break;
			default:
				super.dialogue = new Dialogue(INVALID_INPUT);
				break;
			}
	
		super.audioPlayer.playSelectedAudio(super.dialogue.getAudioFilePath());
		
	}

}
