package com.coldline.src.dialogues;

import com.coldline.src.game.StaticData;

abstract class DialogueAbstract {
	
	protected String audioFileName;
	                 
	protected String audioBasePath = System.getProperty("user.dir")
			.concat("/src/assets/voice/");
	/**
	 * gets the file path of the wav file
	 * @return string type when implemented
	 */
	public abstract String getAudioFilePath();
	/**
	 * sets the value of the parameter to the abstract variable
	 * @param audioFileName type string
	 */
	public abstract void setFileName(String audioFileName);
	/**
	 * returns the abstract file name value
	 * @return string type
	 */
	public abstract String getFileName();
	
}
/**
 * dialogue class which sets the file name and returns the path to the file
 * @author adrian erle vega
 *
 */
public class Dialogue extends DialogueAbstract{
	
	protected StaticData.GameFileNames gameFileNames;
	/**
	 * this method sets the abstract class value to the parameter value
	 * @param audioFileName type string
	 */
	public Dialogue(String audioFileName) {
		super.audioFileName = audioFileName;
		
		this.setFileName(audioFileName);
	}

	@Override
	public String getAudioFilePath() {
		return super.audioBasePath.concat(this.getFileName());
	}

	@Override
	public void setFileName(String audioFileName) {
		this.audioFileName = audioFileName;
	}

	@Override
	public String getFileName() {
		return super.audioFileName;
	}
	
}
