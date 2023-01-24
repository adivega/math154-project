package com.coldline.src.uihandler;

import java.awt.Rectangle;

import javax.swing.JFrame;
/**
 * sets the bounds of the base jframe which implements FrameGetter
 * @author ADRIAN ERLE B. VEGA
 * @version 24/01/2023
 *
 */
public class BaseRequirements implements FrameGetter{
	
	private JFrame jframe;
	private Rectangle bounds;
	/**
	 * class which receives values for the bounds of the jframe
	 * @param jframe jframe object
	 * @param bounds value for jframe bounds
	 */
	public BaseRequirements(JFrame jframe,
							Rectangle bounds) {
		this.bounds = bounds;
		this.jframe = jframe;
	}
	
	protected Rectangle getBounds() {
		return this.bounds;
	}
	

	@Override
	public JFrame getJFrame() {
		return this.jframe;
	}
	
}
