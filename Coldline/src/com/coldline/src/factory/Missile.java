package com.coldline.src.factory;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JTextField;

import com.coldline.src.dialogues.Dialogue;
import com.coldline.src.game.StaticData.GameData;
/**
 * class when game state is at missile
 * @author adrian erle vega
 *
 */
public class Missile extends CommandFactory implements ChoiceDeterminer {
	/**
	 * polymorphed method from superclass
	 * @param textField received by superclass
	 * @param buttons received by superclass
	 * @param gameData received by superclass
	 */
	public Missile(JTextField textField,
			           ArrayList<JButton> buttons, 
			           GameData gameData) {
		
		super(textField, buttons, gameData);
		
		this.processChoices();
	}

	@Override
	public void processChoices() {
		
		final String INTERCEPTION_METHODS = super.gameFileNames.getInterceptionMethodsAudioFile(),
				     INVALID_INPUT        = super.gameFileNames.getInvalidInputAudioFile();
		
		switch(super.getTextFromField()) {
			case "1":
				super.gameData.setCurrentInquiry("InterceptionMethods");
				super.dialogue = new Dialogue(INTERCEPTION_METHODS);
				break;
			default:
				super.dialogue = new Dialogue(INVALID_INPUT);
				break;
		}

		super.audioPlayer.playSelectedAudio(super.dialogue.getAudioFilePath());
		
	}
	
}
