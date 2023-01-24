package com.coldline.src.factory;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JTextField;

import com.coldline.src.dialogues.Dialogue;
import com.coldline.src.game.StaticData.GameData;
/**
 * class when game state is at welcome prime minister
 * @author adrian erle vega
 *
 */
public class WelcomePrimeMinister extends CommandFactory implements ChoiceDeterminer{
	/**
	 * polymorphed method from superclass
	 * @param textField received by superclass
	 * @param buttons received by superclass
	 * @param gameData received by superclass
	 */
	public WelcomePrimeMinister(JTextField textField, 
			                    ArrayList<JButton> buttons, 
			                    GameData gameData) {
		
		super(textField, buttons, gameData);
		
		this.processChoices();
	}

	@Override
	public void processChoices() {
		
		final String BOOK_APPOINTMENT      = super.gameFileNames.getBookAppointmentAudioFile(),
				     EMERGENCY_CANNOT_WAIT = super.gameFileNames.getEmergencyCannotWaitAudioFile(),
				     INVALID_INPUT         = super.gameFileNames.getInvalidInputAudioFile();
		
		switch(super.getTextFromField()) {
			case "1":
				super.gameData.setCurrentInquiry("BookAppointment");
				super.dialogue = new Dialogue(BOOK_APPOINTMENT);
				break;
			case "2":
				super.gameData.setCurrentInquiry("EmergencyCannotWait");
				super.dialogue = new Dialogue(EMERGENCY_CANNOT_WAIT);
				break;
			default:
				super.dialogue = new Dialogue(INVALID_INPUT);
				break;
		}
		
		super.audioPlayer.playSelectedAudio(super.dialogue.getAudioFilePath());
		
	}

}
