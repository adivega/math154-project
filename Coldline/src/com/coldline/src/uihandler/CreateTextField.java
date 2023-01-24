package com.coldline.src.uihandler;

import java.awt.Font;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JTextField;
/**
 * creates text field to receive inputs from buttons
 * @author hp
 *
 */
public class CreateTextField extends BaseRequirements implements TextFieldGetter,
	SetComponentFont{
	
	private JTextField jTextField;
	private String fontName;
	private int fontSyle,
	            fontSize;
	/**
	 * returns parameter value to the parent class
	 * 
	 * @param jframe type jframe
	 * @param bounds type rectangle
	 */
	public CreateTextField(JFrame jframe, Rectangle bounds) {
		
		super(jframe, bounds);
		
		this.initializeTextField();
		this.initializeComponentAppearance();
		
	}
	
	private void createTextField() {
		this.jTextField = new JTextField();
	}
	
	@Override
	public JTextField getTextField() {
		return this.jTextField;
	}
	
	private void initializeTextField() {
		
		this.createTextField();
		
		this.getTextField().setBounds(super.getBounds());
		super.getJFrame().getContentPane().add(this.getTextField());
		this.getTextField().setEditable(false);
		this.getTextField().setHorizontalAlignment(JTextField.CENTER);
	}

	@Override
	public void setFontName(String fontName) {
		this.fontName = fontName;
	}

	@Override
	public void setFontStyle(int fontStyle) {
		this.fontSyle = fontStyle;
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
		return this.fontSyle;
	}

	@Override
	public int getFontSize() {
		return this.fontSize;
	}

	@Override
	public void setFont(String fontName, 
			            int fontStyle, 
			            int fontSize) {
		
		this.getTextField().setFont(new Font(
				fontName, fontStyle, fontSize));
	}

	@Override
	public void initializeComponentAppearance() {
		
		final String textFieldFontName = "Helvetica";
		final int textFieldFontStyle = Font.PLAIN,
				  textFieldFontSize = 20;
		
		this.setFontName(textFieldFontName);
		this.setFontStyle(textFieldFontStyle);
		this.setFontSize(textFieldFontSize);
		
		this.setFont(this.getFontName(), this.getFontStyle(),
				this.getFontSize());
		
	}
	
}
