package com.coldline.src.game;

import java.awt.Rectangle;

import javax.swing.JButton;
import com.coldline.src.uihandler.CreateNormalButton;
import com.coldline.src.uihandler.CreateSmallFontLabel;
import com.coldline.src.uihandler.InitializeButtons;
import com.coldline.src.uihandler.SingleButtonClickable;
import com.coldline.src.uihandler.TextSetter;
/**
 * class during the start of the game
 * uses the classes which constitute the UI
 * @author adrian erle 123
 *
 */
public class Home extends MessageFrame implements SingleButtonClickable, 
	TextSetter, InitializeButtons {
	
	private CreateSmallFontLabel introMessage;
	private CreateNormalButton startButton;
	/**
	 * initializes methods immediately
	 */
	public Home() {
		this.gameIntroMessage();
		this.initializeButtons();
	}
	
	@Override
	public void initializeButtons() {
		
		final int BUTTON_X = 350,
				  BUTTON_Y = 575,
				  BUTTON_H = 100,
				  BUTTON_W = 300;
		
		final Rectangle START_BUTTON_BOUNDS = new Rectangle(BUTTON_X, BUTTON_Y, 
				                             BUTTON_W, BUTTON_H);
		
		this.startButton = new CreateNormalButton(this.getJFrame(), START_BUTTON_BOUNDS);
		
		this.setButtonText();
		
		this.makeButtonClickable(this.startButton.getJButton());
	}

	@Override
	public void setButtonText() {
		this.startButton.getJButton().setText("Start");
	}

	@Override
	public void makeButtonClickable(JButton button) {
		button.addActionListener(this);
	}
	
	private void gameIntroMessage() {
		
		final int MSG_X = 0,
				  MSG_Y = 100,
				  MSG_H = 1000,
				  MSG_W = 350;
		
		final Rectangle GAME_OVER_BOUNDS = new Rectangle(MSG_X, MSG_Y, MSG_H, MSG_W);
		
		this.introMessage = new CreateSmallFontLabel(this.getJFrame(), GAME_OVER_BOUNDS);
		this.introMessage.getLabel().setText("<html><center>You are the "
				+ "Prime Minister of Japan. <br/> Due to a technical failure,"
				+ "<br/>a nuclear warhead is heading to Manila. <br/>"
				+ "Advanced Japanese technology grants you <br/> 7 "
				+ "minutes before the warhead reaches the city.<br/>"
				+ "Have the Philippine Army intercept the "
				+ "warhead <br/> before its too late.</center></html>");
		
	}
	
	
}
