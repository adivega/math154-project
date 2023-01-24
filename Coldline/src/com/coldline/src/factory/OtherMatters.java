package com.coldline.src.factory;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JTextField;

import com.coldline.src.dialogues.Dialogue;
import com.coldline.src.game.StaticData.GameData;
/**
 * class when game state is at other matters
 * @author adrian erle vega
 *
 */
public class OtherMatters extends CommandFactory implements ChoiceDeterminer{
	/**
	 * polymorphed method from superclass
	 * @param textField received by superclass
	 * @param buttons received by superclass
	 * @param gameData received by superclass
	 */
	public OtherMatters(JTextField textField,
			            ArrayList<JButton> buttons, 
			            GameData gameData) {
		
		super(textField, buttons, gameData);
		
		this.processChoices();
	}

	@Override
	public void processChoices() {
		
		final String TRADE_DEALS          = super.gameFileNames.getTradeDealsAudioFile(),
		             NUCLEAR_PROGRAM      = super.gameFileNames.getNuclearProgramAudioFile(),
		             HOTLINE_VERIFICATION = super.gameFileNames.getHotlineVerificationAudioFile(),
		             INVALID_INPUT        = super.gameFileNames.getInvalidInputAudioFile();
		             
		switch(super.getTextFromField()) {
			case "1":
				super.gameData.setCurrentInquiry("TradeDeals");
				super.dialogue = new Dialogue(TRADE_DEALS);
				break;
			case "2":
				super.gameData.setCurrentInquiry("NuclearProgram");
				super.dialogue = new Dialogue(NUCLEAR_PROGRAM);
				break;
			case "3":
				super.gameData.setCurrentInquiry("HotlineVerification");
				super.dialogue = new Dialogue(HOTLINE_VERIFICATION);
				break;
			default:
				super.dialogue = new Dialogue(INVALID_INPUT);
				break;
		}
		
		super.audioPlayer.playSelectedAudio(super.dialogue.getAudioFilePath());
		
	}

}
