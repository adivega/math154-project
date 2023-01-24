package com.coldline.src.uihandler;

import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JFrame;
/**
 * blueprint for button creation
 * extends BaseRequirements and implements ButtonGetter
 * @author adrian erle vega
 *
 */
public class CreateJButton extends BaseRequirements implements ButtonGetter{
	
	private JButton jButton;
	/**
	 * button creation
	 * the parameter values are sent to the parent class BaseRequirements
	 * @param jframe type JFrame
	 * @param bounds type rectangle
	 */
	public CreateJButton(JFrame jframe, 
			            Rectangle bounds) {
		
		super(jframe, bounds);
		
		this.initializeJButton();
	}
	
	private void createJButton() {
		this.jButton = new JButton();
	}
	
	private void initializeJButton() {
		this.createJButton();
		
		this.getJButton().setBounds(super.getBounds());
		super.getJFrame().getContentPane().add(this.getJButton());
		
	}
	
	@Override
	public JButton getJButton() {
		return this.jButton;
	}

}
