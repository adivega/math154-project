package com.coldline.src.factory;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JTextField;

import com.coldline.src.dialogues.Dialogue;
import com.coldline.src.game.StaticData.GameData;
/**
 * class when game state is at emergency cannot wait 
 * @author adrian erle vega
 *
 */
public class EmergencyCannotWait extends CommandFactory implements ChoiceDeterminer,
	GoToAnotherDialogue{
	
	private CommandFactory commandFactory;
	/**
	 * polymorphed method from superclass
	 * @param textField received by superclass
	 * @param buttons received by superclass
	 * @param gameData received by superclass
	 */

	public EmergencyCannotWait(JTextField textField, 
			                   ArrayList<JButton> buttons, 
			                   GameData gameData) {
		
		super(textField, buttons, gameData);
		
		this.processChoices();
		this.goToAnotherDialogue(textField, buttons, gameData);
	}

	@Override
	public void processChoices() {
		
		final String ECONOMIC_CHOICE = super.gameFileNames.getEconomicChoiceAudioFile(),
				     NUCLEAR_CHOICE  = super.gameFileNames.getNuclearChoiceAudioFile(),
				     INVALID_INPUT   = super.gameFileNames.getInvalidInputAudioFile();
		
		switch(super.getTextFromField()) {
			case "1":
				super.gameData.setCurrentInquiry("BookAppointment");
				super.dialogue = new Dialogue(ECONOMIC_CHOICE);
				break;
			case "2":
				super.gameData.setCurrentInquiry("NuclearWarConcern");
				super.dialogue = new Dialogue(NUCLEAR_CHOICE);
				break;
			default:
				super.dialogue = new Dialogue(INVALID_INPUT);
				break;
		}
		
		super.audioPlayer.playSelectedAudio(super.dialogue.getAudioFilePath());
		
	}
	
	@Override
	public void goToAnotherDialogue(JTextField textField, 
                                    ArrayList<JButton> buttons, 
                                    GameData gameData) {
		
		if(super.gameData.getCurrentInquiry() == "BookAppointment") {
			this.commandFactory = new BookAppointment(textField, buttons, gameData);
		}
		
	}

}
