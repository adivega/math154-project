package com.coldline.src.game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.Timer;

import com.coldline.src.uihandler.GroupDisable;
import com.coldline.src.uihandler.TextFieldGetter;
/**
 * plays the audio in the background
 * @author adrian erle vega
 *
 */
public class PlayAudio implements TextFieldGetter{
	
	private JTextField textField;
	private GroupDisable groupDisable;
	private ArrayList<JButton> buttons;
	/**
	 * initializes the buttons and sets the private variables to parameter values
	 * @param textField textfield value
	 * @param buttons arraylist value
	 */
	public PlayAudio(JTextField textField,
			         ArrayList<JButton> buttons) {
		
		this.textField = textField;
		this.buttons = buttons;
		
		this.intializeButtons();
		
	}
	/**
	 * plays the selected audio in the background
	 * @param filePath string type
	 */
	public void playSelectedAudio(final String filePath) {
		
		File fileReader;
		AudioInputStream audioPlayer;
		Clip audioClip = null;
		
		try {
			this.groupDisable.groupDisable(this.getGroupButtons());
			
			fileReader = new File(filePath);
			audioPlayer = AudioSystem.getAudioInputStream(fileReader);
			audioClip = AudioSystem.getClip();
			audioClip.open(audioPlayer);
			audioClip.start();
			
			//Keep thread alive since Clip uses a daemon thread
			this.keepThreadAlive((int)audioClip.getMicrosecondLength());
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally {
			audioClip.close();
			this.groupDisable.groupEnable(this.getGroupButtons());
		}
	}
	
	private int convertToMillisecond(int microsecond) {
		return (int)(microsecond / 1000);
	}
	
	private void keepThreadAlive(final int audioClipMicrosecond) {
		
		final int additionalMillisecond = 500;
		final int convertedMillisecondAudioClip = this.convertToMillisecond(audioClipMicrosecond);
		final int totalMillisecond = convertedMillisecondAudioClip + additionalMillisecond;
		
		final JOptionPane pane = new JOptionPane("Click OK to skip", JOptionPane.QUESTION_MESSAGE);
        final JDialog dialog = pane.createDialog(null, "Do you want to skip?");
        Timer timer = new Timer(totalMillisecond, new ActionListener() {
        	
        	//Automatically Close JOPtionPane
            @Override
            public void actionPerformed(ActionEvent arg0) {
                dialog.dispose();
            }

        });
        timer.start();
        dialog.setVisible(true);
        dialog.dispose();
	}

	@Override
	public JTextField getTextField() {
		return this.textField;
	}
	
	private ArrayList<JButton> getGroupButtons() {
		return this.buttons;
	}
	
	private void intializeButtons() {
		this.groupDisable = new GroupDisable();
	}
	
}
