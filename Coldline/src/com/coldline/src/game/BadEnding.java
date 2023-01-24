package com.coldline.src.game;

import java.awt.Rectangle;

import javax.swing.JButton;

import com.coldline.src.uihandler.CreateMediumFontLabel;
import com.coldline.src.uihandler.CreateNormalButton;
import com.coldline.src.uihandler.InitializeButtons;
import com.coldline.src.uihandler.SingleButtonClickable;
import com.coldline.src.uihandler.TextSetter;
/**
 * sets menu UI state when the bad ending is met
 * @author ADRIAN ERLE B. VEGA
 *
 */
public class BadEnding extends MessageFrame implements SingleButtonClickable,
	TextSetter, InitializeButtons{
	/**
	 * initializes an internal initializeButtons() method which
	 * sets up a few buttons that becomes clickable once the state 
	 * of the bad ending is met
	 */
	private CreateMediumFontLabel gameOver;
	private CreateNormalButton tryAgainButton,
	                           exitButton;
	/**
	 * initializes initializeButtons() method
	 */
	public BadEnding() {
		this.initializeButtons();
	}
	
	@Override
	public void initializeButtons() {
		
		this.gameOverMessage();
		this.initializeButton1();
		this.initializeButton2();
		
		this.setButtonText();
		this.makeButtonClickable(this.tryAgainButton.getJButton());
		this.makeButtonClickable(this.exitButton.getJButton());
	}

	@Override
	public void setButtonText() {
		this.tryAgainButton.getJButton().setText("Try Again");
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
				  MSG_W = 350;
		
		final Rectangle GAME_OVER_BOUNDS = new Rectangle(MSG_X, MSG_Y, MSG_H, MSG_W);
		
		this.gameOver = new CreateMediumFontLabel(this.getJFrame(), GAME_OVER_BOUNDS);
		this.gameOver.getLabel().setText("<html><center>*SPLASH TEST*<br/>Manila has been "
				+ "destroyed.<br/>You did not manage to navigate the phone"
				+ " menu on time.</center></html>");
		
	}
	
	private void initializeButton1() {
		
		final int BUTTON_X = 275,
				  BUTTON_Y = 575,
				  BUTTON_H = 75,
				  BUTTON_W = 200;
		
		final Rectangle TRY_AGAIN_BUTTON_BOUNDS = new Rectangle(BUTTON_X, BUTTON_Y, 
				                                  BUTTON_W, BUTTON_H);
		
		this.tryAgainButton = new CreateNormalButton(this.getJFrame(), 
			TRY_AGAIN_BUTTON_BOUNDS);
	}
	
	private void initializeButton2() {
		
		final int BUTTON_X = 525,
				  BUTTON_Y = 575,
				  BUTTON_H = 75,
				  BUTTON_W = 200;
		
		final Rectangle EXIT_BUTTON_BOUNDS = new Rectangle(BUTTON_X, BUTTON_Y, 
				                             BUTTON_W, BUTTON_H);
		
		this.exitButton = new CreateNormalButton(this.getJFrame(), 
			EXIT_BUTTON_BOUNDS);
		
	}

}
