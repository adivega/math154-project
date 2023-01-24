package com.coldline.src.game;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import com.coldline.src.uihandler.CreateJFrame;
import com.coldline.src.uihandler.FrameCloser;
import com.coldline.src.uihandler.FrameGetter;
import com.coldline.src.uihandler.FrameInitializer;
import com.coldline.src.uihandler.SetBackground;
/**
 * creates the MessageFrame class which implements from a few interfaces
 * sets the UI characteristics
 * @author ADRIAN ERLE B. VEGA
 *
 */
public class MessageFrame implements FrameGetter, FrameInitializer, FrameCloser,
	GameDetailsInitializer, SetBackground, ActionListener{
	
	private CreateJFrame createJFrame;
	private StaticData.GameDetails gameDetails;
/**
 * constructs methods pertaining to frame characteristics	
 */
	public MessageFrame() {
		
		this.initializeGameDetails();
		this.initializeFrame();
		this.setBackground();
		
	}

	@Override
	public void initializeGameDetails() {
		this.gameDetails = new StaticData.GameDetails();
	}

	@Override
	public void initializeFrame() {
		this.createJFrame = new CreateJFrame(this.gameDetails.getWindowHeight(),
			this.gameDetails.getWindowWidth(), this.gameDetails.getWindowTitle());
	}
	

	@Override
	public JFrame getJFrame() {
		return this.createJFrame.getJFrame();
	}

	@Override
	public void setBackground() {
		this.getJFrame().getContentPane().setBackground(Color.BLACK);
	}

	@Override
	public void closeFrame() {
		this.getJFrame().dispose();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String buttonValue = ((JButton)e.getSource()).getText();
		
		this.closeFrame();
		if(buttonValue.equals("Try Again") || buttonValue.equals("Start")) {
			new Game();
		}
		else{
			System.exit(0);
		}
	}
	
}
