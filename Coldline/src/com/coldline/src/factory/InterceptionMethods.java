package com.coldline.src.factory;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JTextField;

import com.coldline.src.dialogues.Dialogue;
import com.coldline.src.game.StaticData.GameData;
/**
 * class when game state is at interception methods
 * @author adrian erle vega
 *
 */
public class InterceptionMethods extends CommandFactory implements ChoiceDeterminer{
	/**
	 * polymorphed method from superclass
	 * @param textField received by superclass
	 * @param buttons received by superclass
	 * @param gameData received by superclass
	 */
	public InterceptionMethods(JTextField textField, 
			                   ArrayList<JButton> buttons, 
			                   GameData gameData) {
		
		super(textField, buttons, gameData);
		
		this.processChoices();
	}

	@Override
	public void processChoices() {
		
		final String NORTH_HEMISPHERE = super.gameFileNames.getNorthHemisphereAudioFile(),
				     SOUTH_HEMISPHERE = super.gameFileNames.getSouthHemisphereAudioFile(),
				     INVALID_INPUT    = super.gameFileNames.getInvalidInputAudioFile();
		
		switch(super.getTextFromField()) {
			case "1":
				super.gameData.setCurrentInquiry("Hemisphere");
				super.dialogue = new Dialogue(NORTH_HEMISPHERE);
				break;
			case "2":
				super.gameData.setCurrentInquiry("Hemisphere");
				super.dialogue = new Dialogue(SOUTH_HEMISPHERE);
				break;
			default:
				super.dialogue = new Dialogue(INVALID_INPUT);
				break;
		}
	
		super.audioPlayer.playSelectedAudio(super.dialogue.getAudioFilePath());
		
	}

}
