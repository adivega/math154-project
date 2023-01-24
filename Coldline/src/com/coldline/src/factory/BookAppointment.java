package com.coldline.src.factory;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JTextField;

import com.coldline.src.dialogues.Dialogue;
import com.coldline.src.game.StaticData.GameData;
/**
 * main class for a state of the game book appointment
 * @author ADRIAN ERLE B. VEGA
 *
 */
public class BookAppointment extends CommandFactory{
/**
 * constructor which initializes BookAppointment which extends
 * CommandFactory
 * the values of the parameters goes to the superclass 
 * @param textField value is received by the superclass
 * @param buttons value is received by the superclass
 * @param gameData value is received by the superclass
 */
	public BookAppointment(JTextField textField, 
			               ArrayList<JButton> buttons, 
			               GameData gameData) {
		
		super(textField, buttons, gameData);
		
		this.sameMessage();
	}
	
	private void sameMessage() {
		
		final String BOOK_APPOINTMENT = super.gameFileNames.getBookAppointmentAudioFile();
		
		super.dialogue = new Dialogue(BOOK_APPOINTMENT);
		super.audioPlayer.playSelectedAudio(super.dialogue.getAudioFilePath());
		
	}

}
