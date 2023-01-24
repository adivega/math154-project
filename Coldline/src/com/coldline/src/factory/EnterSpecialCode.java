package com.coldline.src.factory;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JTextField;

import com.coldline.src.dialogues.Dialogue;
import com.coldline.src.game.StaticData.GameData;
/**
 * class when game state is at enter special code
 * @author adrian erle vega
 *
 */
public class EnterSpecialCode extends CommandFactory implements ChoiceDeterminer{
	/**
	 * polymorphed method from superclass
	 * @param textField received by superclass
	 * @param buttons received by superclass
	 * @param gameData received by superclass
	 */
	public EnterSpecialCode(JTextField textField, 
			                ArrayList<JButton> buttons, 
			                GameData gameData) {
		
		super(textField, buttons, gameData);
		
		this.processChoices();
	}

	@Override
	public void processChoices() {
		
		final String TO_CONTINUE   = super.gameFileNames.getToContinueAudioFile(),
				     INVALID_INPUT = super.gameFileNames.getInvalidInputAudioFile();
		
		switch(super.getTextFromField()) {
			case "4081#":
				super.gameData.setCurrentInquiry("ToContinue");
				super.dialogue = new Dialogue(TO_CONTINUE);
				break;
			default:
				super.dialogue = new Dialogue(INVALID_INPUT);
				break;
		}
		
		super.audioPlayer.playSelectedAudio(super.dialogue.getAudioFilePath());
		
	}

}
