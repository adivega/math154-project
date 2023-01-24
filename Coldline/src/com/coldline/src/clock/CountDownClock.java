package com.coldline.src.clock;

import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JLabel;

import com.coldline.src.game.BadEnding;
import com.coldline.src.uihandler.FrameCloser;
import com.coldline.src.uihandler.FrameGetter;
/**
 * class for the seven minute timer
 * inherits abstract methods from interface FrameGetter and FrameCloser
 * @author Adrian Erle B. Vega
 *
 */
public class CountDownClock implements FrameGetter, FrameCloser {
	
	private int minutes = 6,
	            seconds = 59;
	
	private Timer timer = new Timer();
	private TimerTask timerTask;
	
	private JFrame jFrame;
	/**
	 * creates UI for the clock
	 * @param jFrame clock
	 * @param label clock timer
	 */
	public CountDownClock(JFrame jFrame, 
			              JLabel label) {
		
		this.jFrame = jFrame;
		
		this.startTimer(label);
	}
	
	private int getRemainingMinutes() {
		return this.minutes;
	}
	
	private int getRemainingSeconds() {
		return this.seconds;
	}
	
	private String getOutputMinutes() {
		return String.format("%02d", this.getRemainingMinutes());
	}
	
	private String getOutputSeconds() {
		return String.format("%02d", this.getRemainingSeconds());
	}
	
	private void decrementMinutes() {
		if(this.getRemainingMinutes() > 0) {
			--this.minutes;
		}
	}
	
	private void decrementSeconds() {
		if(this.getRemainingMinutes() > 0 || this.getRemainingSeconds() > 0) {
			if(this.getRemainingSeconds() > 0) {
				--this.seconds;
			}
			else {
				this.decrementMinutes();
				this.resetSeconds();
			}
		}
		else {
			this.stopTimer();
		}	
	}
		
	private void resetSeconds() {
		this.seconds = 59;
	}
	
	private void startTimer(JLabel label) {
		
		final int DELAY = 0,
				  MILLISECOND_SPEED = 1000;
		
		this.timerTask = new TimerTask() {
			
			@Override
			public void run() {
				label.setText(getOutputMinutes().concat(":").concat(getOutputSeconds()));
				decrementSeconds();
			}
			
		};
		this.timer.scheduleAtFixedRate(timerTask, DELAY, MILLISECOND_SPEED);
	}
	
	private void stopTimer() {
		this.timerTask.cancel();
		this.closeFrame();
		new BadEnding();
	}

	@Override
	public JFrame getJFrame() {
		return this.jFrame;
	}

	@Override
	public void closeFrame() {
		this.getJFrame().dispose();
	}
	
}
