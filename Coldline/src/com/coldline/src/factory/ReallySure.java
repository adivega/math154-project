package com.coldline.src.factory;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import com.coldline.src.dialogues.Dialogue;
import com.coldline.src.game.GoodEnding;
import com.coldline.src.game.MessageFrame;
import com.coldline.src.game.StaticData.GameData;
import com.coldline.src.uihandler.FrameCloser;
import com.coldline.src.uihandler.FrameGetter;
/**
 * class when game state is at really sure
 * @author adrian erle vega
 *
 */
public class ReallySure extends CommandFactory implements ChoiceDeterminer,
	FrameGetter, FrameCloser{
	
	private JFrame thisFrame;
	/**
	 * polymorphed method from superclass
	 * @param textField received by superclass
	 * @param buttons received by superclass
	 * @param gameData received by superclass
	 */
	public ReallySure(JTextField textField, 
			          ArrayList<JButton> buttons, 
			          GameData gameData,
			          JFrame thisFrame) {
		
		super(textField, buttons, gameData);
		this.thisFrame = thisFrame;
		
		this.processChoices();
		this.goodEnding();
	}

	@Override
	public void processChoices() {
		
		final String INTERCEPTION_SENT = super.gameFileNames.getIntercpetionSentAudioFile(),
				     MAIN_MENU         = super.gameFileNames.getMainMenuAudioFile(),
				     INVALID_INPUT     = super.gameFileNames.getInvalidInputAudioFile();
		
		switch(super.getTextFromField()) {
			case "1":
				super.gameData.setCurrentInquiry("GoodEnding");
				super.dialogue = new Dialogue(INTERCEPTION_SENT);
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
	
	private void goodEnding() {
		if(super.gameData.getCurrentInquiry().equals("GoodEnding")) {
			this.closeFrame();
			new GoodEnding();
		}
	}
	
	@Override
	public void closeFrame() {
		this.getJFrame().dispose();
	}

	@Override
	public JFrame getJFrame() {
		return this.thisFrame;
	}


}
