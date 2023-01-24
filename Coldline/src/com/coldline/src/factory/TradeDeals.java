package com.coldline.src.factory;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JTextField;

import com.coldline.src.dialogues.Dialogue;
import com.coldline.src.game.StaticData.GameData;
/**
 * class when game state is at trade deals
 * @author adrian erle vega
 *
 */
public class TradeDeals extends CommandFactory implements ChoiceDeterminer{
	/**
	 * polymorphed method from superclass
	 * @param textField received by superclass
	 * @param buttons received by superclass
	 * @param gameData received by superclass
	 */
	public TradeDeals(JTextField textField,
			          ArrayList<JButton> buttons, 
			          GameData gameData) {
		
		super(textField, buttons, gameData);
		
		this.processChoices();
		
	}

	@Override
	public void processChoices() {
		
		final String KNOW_MORE     = super.gameFileNames.getKnowMoreAudioFile(),
				     MAIN_MENU     = super.gameFileNames.getMainMenuAudioFile(),
				     INVALID_INPUT = super.gameFileNames.getInvalidInputAudioFile();
		
		switch(super.getTextFromField()) {
			case "1":
				super.gameData.setCurrentInquiry("AdditionalVoiceLineToMainMenu");
				super.dialogue = new Dialogue(KNOW_MORE);
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
