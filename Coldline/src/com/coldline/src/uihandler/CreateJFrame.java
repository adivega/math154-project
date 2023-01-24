package com.coldline.src.uihandler;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
/**
 * creates the window
 * @author adrian erle vega
 *
 */
public class CreateJFrame implements FrameGetter, FrameInitializer{
	
	private JFrame jframe;
	
	private int windowWidth, 
	            windowHeight;
	
	private String windowTitle;
	/**
	 * Sets the private values to the parameter values
	 * the methods below then get the values and returns it into the getX() 
	 * functions which would be used when called
	 * @param windowWidth type int
	 * @param windowHeight type int
	 * @param windowTitle type string
	 */
	public CreateJFrame(int windowWidth,
			            int windowHeight, 
			            String windowTitle) {
		
		this.windowWidth  = windowWidth;
		this.windowHeight = windowHeight;
		this.windowTitle  = windowTitle;
		
		this.initializeFrame();
		
	}
	
	@Override
	public JFrame getJFrame() {
		return this.jframe;
	}
	
	private int getWindowWidth() {
		return this.windowWidth;
	}
	
	private int getWindowHeight() {
		return this.windowHeight;
	}
	
	private String getWindowTitle() {
		return this.windowTitle;
	}
	
	private void createJFrame() {
		this.jframe = new JFrame(this.getWindowTitle());
	}
	
	@Override
	public void initializeFrame() {
		
		this.createJFrame();
		
		this.getJFrame().setSize(this.getWindowHeight(),
			this.getWindowWidth());
		this.getJFrame().setLocationRelativeTo(null);
		this.getJFrame().setLayout(null);
		this.getJFrame().setResizable(false);
		this.getJFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getJFrame().setVisible(true);
		
		this.getJFrame().addWindowListener(new WindowAdapter() {

		    @Override
		    public void windowClosing(WindowEvent e) {
		        System.exit(0);
		    }
		});
		
	}

	
	
}
