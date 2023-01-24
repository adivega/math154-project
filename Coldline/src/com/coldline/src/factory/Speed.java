package com.coldline.src.factory;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JTextField;

import com.coldline.src.dialogues.Dialogue;
import com.coldline.src.game.StaticData.GameData;
/**
 * class when game state is at speed
 * @author adrian erle vega
 *
 */
public class Speed extends CommandFactory implements ChoiceDeterminer{
	/**
	 * polymorphed method from superclass
	 * @param textField received by superclass
	 * @param buttons received by superclass
	 * @param gameData received by superclass
	 */
	public Speed(JTextField textField, 
			     ArrayList<JButton> buttons, 
			     GameData gameData) {
		
		super(textField, buttons, gameData);
		
		this.processChoices();
	}

	@Override
	public void processChoices() {
		
		final String SLOW_MISSILE  = super.gameFileNames.getSlowMissileAudioFile(),
				     FAST_MISSILE  = super.gameFileNames.getFastMissileAudioFile(),
				     INVALID_INPUT = super.gameFileNames.getInvalidInputAudioFile();
		
		switch(super.getTextFromField()) {
			case "1":
				super.gameData.setCurrentInquiry("Missile");
				super.dialogue = new Dialogue(SLOW_MISSILE);
				break;
			case "2":
				super.gameData.setCurrentInquiry("Missile");
				super.dialogue = new Dialogue(FAST_MISSILE);
				break;
			default:
				super.dialogue = new Dialogue(INVALID_INPUT);
				break;
			}

		super.audioPlayer.playSelectedAudio(super.dialogue.getAudioFilePath());
		
	}

}
