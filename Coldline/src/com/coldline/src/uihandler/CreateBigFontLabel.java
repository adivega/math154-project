package com.coldline.src.uihandler;

import java.awt.Font;
import java.awt.Rectangle;

import javax.swing.JFrame;
/**
 * UI blueprint for big fonts splash texts
 * inherits methods and variables from CreateJLabel and SetComponentFont
 * @author adrian erle b. vega
 *
 */
public class CreateBigFontLabel extends CreateJLabel implements SetComponentFont{

	private String fontName;
	private int fontStyle,
	            fontSize;
	/**
	 * creates a method which accepts the ui parametrs
	 * @param jframe type JFrame
	 * @param bounds type Rectangle
	 */
	public CreateBigFontLabel(JFrame jframe, 
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
	public void setFont(String fontName, int fontStyle, int fontSize) {
		this.getLabel().setFont(new Font(fontName, fontStyle,
			fontSize));
	}

	@Override
	public void initializeComponentAppearance() {
		
		final String jLabelFontName = "Helvetica";
		final int jLabelFontStyle = Font.BOLD,
				  jLabelFontSize = 150;
		
		this.setFontName(jLabelFontName);
		this.setFontStyle(jLabelFontStyle);
		this.setFontSize(jLabelFontSize);
		this.setColor();
		
		this.setFont(this.getFontName(), this.getFontStyle(), this.getFontSize());
		
	}

}
