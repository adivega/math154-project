package com.coldline.src.uihandler;

import java.awt.Color;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
/**
 * used to display texts
 * @author adrian erle vega
 *
 */
public class CreateJLabel extends BaseRequirements implements SetComponentColor, 
	CenterText{
	
	private JLabel label;
	/**
	 * sends the values to the parent class
	 * @param jframe type JFrame
	 * @param bounds type rectangle
	 */
	public CreateJLabel(JFrame jframe, 
			            Rectangle bounds) {
		
		super(jframe, bounds);
		
		this.initializeJLabel();
		this.centerText();
	}
	/**
	 * returns the value to get
	 * @return label type JLabel
	 */
	public JLabel getLabel() {
		return this.label;
	}
	
	private void createJLabel() {
		this.label = new JLabel();
	}
	
	private void initializeJLabel() {
		
		this.createJLabel();
		
		this.getLabel().setBounds(super.getBounds());
		super.getJFrame().getContentPane().add(this.getLabel());
	}

	@Override
	public void setColor() {
		
		final Color FONT_COLOR = Color.yellow;
		this.getLabel().setForeground(FONT_COLOR);
	}

	@Override
	public void centerText() {
		this.getLabel().setHorizontalAlignment(SwingConstants.CENTER);
	}

}
