package com.coldline.src.telephone;

import java.awt.Font;
import java.awt.Rectangle;
import javax.swing.JFrame;

import com.coldline.src.uihandler.ButtonPropertiesGetter;
import com.coldline.src.uihandler.CreateJButton;
import com.coldline.src.uihandler.SetComponentFont;
import com.coldline.src.uihandler.TextSetter;
/**
 * creates a telephone button
 * @author adrian erle vega
 *
 */
public class CreateTelephoneButton extends CreateJButton implements ButtonPropertiesGetter,
	TextSetter, SetComponentFont{
	
	private Character buttonValue;
	private String fontName;
	private int fontStyle,
	            fontSize;
	/**
	 * returns parameter value to the parent class
	 * initializes the telephone buttons since in some instances the game disables it
	 * @param jframe type jframe
	 * @param bounds type rectangle
	 * @param buttonValue type char
	 */
	public CreateTelephoneButton(JFrame jframe, 
						         Rectangle bounds,
			                     Character buttonValue) {
		
		super(jframe, bounds);
		this.buttonValue = buttonValue;
		
		this.initializeComponentAppearance();
		this.initializeTelephoneButton();
		
	}

	@Override
	public Character getButtonValue() {
		return this.buttonValue;
	}
	
	@Override
	public void setButtonText() {
		super.getJButton().setText(Character.toString(this.getButtonValue()));
	}

	private void initializeTelephoneButton() {
		this.setButtonText();
	}

	@Override
	public void setFontName(String fontName) {
		this.fontName = fontName;
	}

	@Override
	public void setFontStyle(int fontStyle) {
		this.fontStyle = fontStyle;
	}

	@Override
	public void setFontSize(int fontSize) {
		this.fontSize = fontSize;
	}

	@Override
	public String getFontName() {
		return this.fontName;
	}

	@Override
	public int getFontStyle() {
		return this.fontStyle;
	}

	@Override
	public int getFontSize() {
		return this.fontSize;
	}
	
	@Override
	public void setFont(String buttonFontName,
			            int    buttonFontStyle,
			            int    buttonFontSize) {
		
		super.getJButton().setFont(new Font(
				buttonFontName, buttonFontStyle, buttonFontSize));
	}

	@Override
	public void initializeComponentAppearance() {
		
		final String buttonFontName = "Helvetica";
		final int buttonFontStyle = Font.BOLD,
				  buttonFontSize = 25;
		
		this.setFontName(buttonFontName);
		this.setFontStyle(buttonFontStyle);
		this.setFontSize(buttonFontSize);
		
		this.setFont(this.getFontName(), this.getFontStyle(),
				this.getFontSize());
		
	}

}
