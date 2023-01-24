package com.coldline.src.factory;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JTextField;

import com.coldline.src.dialogues.Dialogue;
import com.coldline.src.game.StaticData;
/**
 * class when game state is at main menu
 * start game state
 * @author adrian erle vega
 *
 */
public class MainMenu extends CommandFactory implements ChoiceDeterminer{
	/**
	 * polymorphed method from superclass
	 * @param textField received by superclass
	 * @param buttons received by superclass
	 * @param gameData received by superclass
	 */
	public MainMenu(JTextField textField,
			        ArrayList<JButton> buttons,
			        StaticData.GameData gameData) {
		
		super(textField, buttons, gameData);
		
		this.processChoices();
		this.playAdditionalCase2();
		
	}

	@Override
	public void processChoices() {
		final String CONNECT_TO_PRESIDENT   = super.gameFileNames.getConnectToPresidentAudioFile(),
		             CONTACT_REPRESENTATIVE = super.gameFileNames.getContactRepresentativeAudioFile(),
		             OTHER_MATTERS          = super.gameFileNames.getOtherMattersAudioFile(),
			         INVALID_INPUT          = super.gameFileNames.getInvalidInputAudioFile();
	
		switch(super.getTextFromField()) {
			case "1":
				super.gameData.setCurrentInquiry("ConnectToPresident");
				super.dialogue = new Dialogue(CONNECT_TO_PRESIDENT);
				break;
			case "2":
				super.gameData.setCurrentInquiry("ContactRepresentative");
				super.dialogue = new Dialogue(CONTACT_REPRESENTATIVE);
				break;
			case "3":
				super.gameData.setCurrentInquiry("OtherMatters");
				super.dialogue = new Dialogue(OTHER_MATTERS);
				break;
			default:
				super.dialogue = new Dialogue(INVALID_INPUT);
				break;
		}
	
	super.audioPlayer.playSelectedAudio(super.dialogue.getAudioFilePath());
	
	}
	
	private void playAdditionalCase2() {
		
		final String TRY_AGAIN_ANOTHER_TIME = super.gameFileNames.getTryAgainAnotherTimeAudioFile();
		
		if(super.gameData.getCurrentInquiry().equals("ContactRepresentative")) {
			super.dialogue = new Dialogue(TRY_AGAIN_ANOTHER_TIME);
			super.audioPlayer.playSelectedAudio(super.dialogue.getAudioFilePath());
		}
	}
	
	

}
