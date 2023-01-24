package com.coldline.src.factory;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JTextField;

import com.coldline.src.dialogues.Dialogue;
import com.coldline.src.game.StaticData.GameData;
/**
 * driver when the state of the game is at apply state
 * @author ADRIAN ERLE B. VEGA
 *
 */
public class Apply extends CommandFactory implements ChoiceDeterminer {
/**
 * constructor which initializes Apply which extends
 * CommandFactory
 * the values of the parameters goes to the superclass 
 * @param textField value is received by the superclass
 * @param buttons value is received by the superclass
 * @param gameData value is received by the superclass
 */
	public Apply(JTextField textField, 
			     ArrayList<JButton> buttons, 
			     GameData gameData) {
		
		super(textField, buttons, gameData);
		
		this.processChoices();
	}

	@Override
	public void processChoices() {
		
		final String HIGH_RANKING  = super.gameFileNames.getHighRankingAudioFile(),
				     LOW_RANKING   = super.gameFileNames.getContactRepresentativeAudioFile(),
				     INVALID_INPUT = super.gameFileNames.getInvalidInputAudioFile();
		
		switch(super.getTextFromField()) {
			case "1":
				super.gameData.setCurrentInquiry("ContactRepresentative");
				super.dialogue = new Dialogue(LOW_RANKING);
				break;
			case "2":
				super.gameData.setCurrentInquiry("HighRanking");
				super.dialogue = new Dialogue(HIGH_RANKING);
				break;
			default:
				super.dialogue = new Dialogue(INVALID_INPUT);
				break;
		}
		
		super.audioPlayer.playSelectedAudio(super.dialogue.getAudioFilePath());
		
	}

}
