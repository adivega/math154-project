package com.coldline.src.uihandler;

import java.awt.Font;
import java.awt.Rectangle;

import javax.swing.JFrame;
/**
 * creates a normal button
 * @author adrian erle vega
 *
 */
public class CreateNormalButton extends CreateJButton implements SetComponentFont{
	
	private String fontName;
	private int fontStyle,
	            fontSize;
	/**
	 * returns parameter value to the parent class
	 * @param jframe type jframe
	 * @param bounds type rectangle
	 */
	public CreateNormalButton(JFrame jframe, 
			                  Rectangle bounds) {
		
		super(jframe, bounds);
		
		this.initializeComponentAppearance();
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
	public void setFont(String buttonFontName, int buttonFontStyle, int buttonFontSize) {
		
		super.getJButton().setFont(new Font(
			buttonFontName, buttonFontStyle, buttonFontSize));
	}

	@Override
	public void initializeComponentAppearance() {
		
		final String buttonFontName = "Helvetica";
		final int buttonFontStyle = Font.BOLD,
				  buttonFontSize  = 30;
		
		this.setFontName(buttonFontName);
		this.setFontStyle(buttonFontStyle);
		this.setFontSize(buttonFontSize);
		
		this.setFont(this.getFontName(), this.getFontStyle(), this.getFontSize());
		
	}

}
