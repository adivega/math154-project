package com.coldline.src.game;

import java.awt.Rectangle;

import javax.swing.JButton;

import com.coldline.src.uihandler.CreateBigFontLabel;
import com.coldline.src.uihandler.CreateNormalButton;
import com.coldline.src.uihandler.InitializeButtons;
import com.coldline.src.uihandler.SingleButtonClickable;
import com.coldline.src.uihandler.TextSetter;
/**
 * sets the UI once the good ending is met
 * @author ADRIAN ERLE B. VEGA
 *
 */
public class GoodEnding extends MessageFrame implements SingleButtonClickable,
	TextSetter, InitializeButtons{
	/**
	 * constructor that initializes gameOverMessage and 
	 * initializeButtons methods 
	 */
	private CreateBigFontLabel gameOver;
	private CreateNormalButton exitButton;
	/**
	 * method which initializes gameOverMessage() and initializeButtons() if called
	 */
	public GoodEnding() {
		this.gameOverMessage();
		this.initializeButtons();
	}

	@Override
	public void initializeButtons() {
		
		final int BUTTON_X = 350,
				  BUTTON_Y = 575,
				  BUTTON_H = 100,
				  BUTTON_W = 300;
		
		final Rectangle EXIT_BUTTON_BOUNDS = new Rectangle(BUTTON_X, BUTTON_Y, 
				                             BUTTON_W, BUTTON_H);
		
		this.exitButton = new CreateNormalButton(this.getJFrame(), EXIT_BUTTON_BOUNDS);
		
		this.setButtonText();
		
		this.makeButtonClickable(this.exitButton.getJButton());
	}

	@Override
	public void setButtonText() {
		this.exitButton.getJButton().setText("Exit");
	}

	@Override
	public void makeButtonClickable(JButton button) {
		button.addActionListener(this);
	}
	
	private void gameOverMessage() {
		
		final int MSG_X = 0,
				  MSG_Y = 100,
				  MSG_H = 1000,
				  MSG_W = 400;
		
		final Rectangle GAME_OVER_BOUNDS = new Rectangle(MSG_X, MSG_Y, MSG_H, MSG_W);
		
		this.gameOver = new CreateBigFontLabel(this.getJFrame(), GAME_OVER_BOUNDS);
		this.gameOver.getLabel().setText("<html>GAME<br/>OVER</html>");
		
	}
	
}
