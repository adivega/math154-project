package com.coldline.src.uihandler;
/**
 * blueprint for the font appearance
 * @author adrian erle vega
 *
 */
public interface SetComponentFont {
	/**
	 * sets the font name
	 * @param fontName is of type string
	 */
	public void setFontName(String fontName);
	/**
	 * sets the font name
	 * @param fontStyle type int
	 */
	public void setFontStyle(int fontStyle);
	/**
	 * sets the font size
	 * @param fontSize type int
	 */
	public void setFontSize(int fontSize);
	/**
	 * gets the font name
	 * @return type string after implemented
	 */
	public String getFontName();
	/**
	 * gets the font style
	 * @return type integer
	 */
	public int getFontStyle();
	/**
	 * gets the font size
	 * @return type integer
	 */
	public int getFontSize();
	/**
	 * sets the font characteristics
	 * @param fontName type string
	 * @param fontStyle type int
	 * @param fontSize type int
	 */
	public void setFont(String fontName, int fontStyle, int fontSize);
	/**
	 * initializes appearance of component
	 */
	public void initializeComponentAppearance();
}
