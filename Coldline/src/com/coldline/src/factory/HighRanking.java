package com.coldline.src.factory;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JTextField;

import com.coldline.src.dialogues.Dialogue;
import com.coldline.src.game.StaticData.GameData;
/**
 * class when game state is at hihg ranking
 * @author adrian erle vega
 *
 */
public class HighRanking extends CommandFactory implements ChoiceDeterminer{
	/**
	 * polymorphed method from superclass
	 * @param textField received by superclass
	 * @param buttons received by superclass
	 * @param gameData received by superclass
	 */
	public HighRanking(JTextField textField, 
			          ArrayList<JButton> buttons, 
			          GameData gameData) {
		
		super(textField, buttons, gameData);
		
		this.processChoices();
	}

	@Override
	public void processChoices() {
		
		final String PROXY_HEAD    = super.gameFileNames.getProxyHeadAudioFile(),
				     STATE_HEAD    = super.gameFileNames.getStateHeadAudioFile(),
				     INVALID_INPUT = super.gameFileNames.getInvalidInputAudioFile();
		
		switch(super.getTextFromField()) {
			case "1":
				super.gameData.setCurrentInquiry("AdditionalVoiceLineToMainMenu");
				super.dialogue = new Dialogue(PROXY_HEAD);
				break;
			case "2":
				super.gameData.setCurrentInquiry("AdditionalVoiceLineToMainMenu");
				super.dialogue = new Dialogue(PROXY_HEAD);
				break;
			case "3":
				super.gameData.setCurrentInquiry("AdditionalVoiceLineToMainMenu");
				super.dialogue = new Dialogue(STATE_HEAD);
				break;
			default:
				super.dialogue = new Dialogue(INVALID_INPUT);
				break;
		}
		
		super.audioPlayer.playSelectedAudio(super.dialogue.getAudioFilePath());
		
	}

}
