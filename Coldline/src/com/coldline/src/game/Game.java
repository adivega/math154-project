package com.coldline.src.game;

import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.coldline.src.clock.CountDownClock;
import com.coldline.src.dialogues.Dialogue;
import com.coldline.src.telephone.Telephone;
import com.coldline.src.uihandler.CreateBigFontLabel;
import com.coldline.src.uihandler.CreateJFrame;
import com.coldline.src.uihandler.FrameGetter;
import com.coldline.src.uihandler.FrameInitializer;
import com.coldline.src.uihandler.SetBackground;
/**
 * main UI for the base game which implements FrameGetter 
 * and FrameInitializer
 * @author ADRIAN ERLE B. VEGA
 *
 */
public class Game implements FrameGetter, FrameInitializer, 
	GameDataInitializer, GameDetailsInitializer, GameFileNameInitializer,
	SetBackground{
	
	private CreateJFrame createJFrame;
	private Telephone telephone;
	private StaticData.GameData gameData;
	private StaticData.GameDetails gameDetails;
	private StaticData.GameFileNames gameFileNames;
	private CountDownClock countDownClock;
	private CreateBigFontLabel countDownTimerLabel;
	private Dialogue dialogue;
	private PlayAudio playAudio;
	/**
	 * initializes several methods
	 */
	public Game() {
		this.initializeGameDetails();
		this.initializeGameData();
		this.initializeGameFileNames();
		this.initializeFrame();
		this.setBackground();
		this.initializePhone();
		this.initializeClock();
		
		this.playIntro();
	}
	
	@Override
	public void initializeGameData() {
		this.gameData = new StaticData.GameData();
		this.gameData.setCurrentInquiry("MainMenu");
	}
	
	@Override
	public void initializeGameDetails() {
		this.gameDetails = new StaticData.GameDetails();
	}
	
	@Override
	public void initializeGameFileNames() {
		this.gameFileNames = new StaticData.GameFileNames();
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
		final String BACKGROUND_IMAGE_FILE_PATH = System.getProperty("user.dir")
			.concat("/src/assets/images/Background_Image.png");
		
		try {
			this.getJFrame().setContentPane(new JLabel(new ImageIcon(ImageIO.read(
				new File(BACKGROUND_IMAGE_FILE_PATH)))));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void initializePhone() {
		
		final int TELEPHONE_X = -7,
				  TELEPHONE_Y = 135,
				  TEMP_SIZE   = 0;
		
		final Rectangle TELEPHONE_BOUNDS = new Rectangle(TELEPHONE_X, TELEPHONE_Y,
			TEMP_SIZE, TEMP_SIZE);
		
		this.telephone = new Telephone(this.getJFrame(), TELEPHONE_BOUNDS,
			this.gameData); 
		
	}
	
	private void initializeClock() {
		
		final int COUNTDOWN_CLOCK_X = 510,
			      COUNTDOWN_CLOCK_Y = 0,
			      COUNTDOWN_CLOCK_H = 400,
			      COUNTDOWN_CLOCK_W = 400;
		
		final Rectangle COUNTDOWN_LABEL_BOUNDS = new Rectangle(COUNTDOWN_CLOCK_X, 
			COUNTDOWN_CLOCK_Y, COUNTDOWN_CLOCK_H, COUNTDOWN_CLOCK_W);
		
		this.countDownTimerLabel = new CreateBigFontLabel(this.getJFrame(), 
			COUNTDOWN_LABEL_BOUNDS); 
		
		this.countDownClock = new CountDownClock(this.getJFrame(),
			this.countDownTimerLabel.getLabel());
	}
	
	private void playIntro() {
		
		final JTextField TEXT_FIELD = this.telephone.getTextField();
		final ArrayList<JButton> BUTTONS = this.telephone.getAllClickableButtons();
		
		this.playAudio = new PlayAudio(TEXT_FIELD, BUTTONS);
		
		final String FILE_NAME = this.gameFileNames.getMainMenuAudioFile();
		
		this.dialogue = new Dialogue(FILE_NAME);
		
		this.playAudio.playSelectedAudio(this.dialogue.getAudioFilePath());
	}

}
