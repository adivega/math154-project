package com.coldline.src.uihandler;

import java.awt.Component;
/**
 * interface for movable objects
 * @author adrian erle vega
 *
 */
public interface ObjectMovable {
	/**
	 * interface method for position
	 * @param object component
	 * @param newX type int x-axis
	 * @param newY type int y-axis
	 */
	public void movePosition(Component object, int newX, int newY);
	/**
	 * moves every every component position
	 */
	public void moveAllPosition();
	/**
	 * adds available movable components
	 */
	public void addAllMovableComponents();
}
