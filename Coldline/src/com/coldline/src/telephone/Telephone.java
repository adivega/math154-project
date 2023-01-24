package com.coldline.src.telephone;

import java.awt.Component;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import com.coldline.src.factory.ConnectToPresident;
import com.coldline.src.factory.ContactRepresentative;
import com.coldline.src.factory.DefensiveWeapons;
import com.coldline.src.factory.EmergencyCannotWait;
import com.coldline.src.factory.EnterSpecialCode;
import com.coldline.src.factory.HighRanking;
import com.coldline.src.factory.HotlineVerification;
import com.coldline.src.factory.InterceptionMethods;
import com.coldline.src.factory.InvalidCodeMultipleAttempt;
import com.coldline.src.factory.AccidentalyTargeted;
import com.coldline.src.factory.AdditionalVoiceLineToMainMenu;
import com.coldline.src.factory.Apply;
import com.coldline.src.factory.BookAppointment;
import com.coldline.src.factory.CommandFactory;
import com.coldline.src.factory.MainMenu;
import com.coldline.src.factory.NeedPermission;
import com.coldline.src.factory.NuclearChoice;
import com.coldline.src.factory.NuclearProgram;
import com.coldline.src.factory.OtherMatters;
import com.coldline.src.factory.ReallySure;
import com.coldline.src.factory.Missile;
import com.coldline.src.factory.Hemisphere;
import com.coldline.src.factory.Speed;
import com.coldline.src.factory.ToContinue;
import com.coldline.src.factory.TradeDeals;
import com.coldline.src.factory.TypesOfWeapons;
import com.coldline.src.factory.WelcomePrimeMinister;
import com.coldline.src.game.StaticData;
import com.coldline.src.uihandler.BaseRequirements;
import com.coldline.src.uihandler.SingleButtonClickable;
import com.coldline.src.uihandler.CreateTextField;
import com.coldline.src.uihandler.InitializeButtons;
import com.coldline.src.uihandler.MultipleButtonClickable;
import com.coldline.src.uihandler.ObjectMovable;
import com.coldline.src.uihandler.TextFieldGetter;
/**
 * creates and adds functionality to the telephone ui
 * @author adrian erle vega
 *
 */
public class Telephone extends BaseRequirements implements ObjectMovable,
	TextFieldGetter, SingleButtonClickable, MultipleButtonClickable,
	InitializeButtons, ActionListener{
	
	private CreateTelephoneButton one, two, three, four, five,
	             				  six, seven, eight, nine, zero,
	             				  asterisk, pound;
	
	private ArrayList<Component> componentList = new ArrayList<Component>();
	private ArrayList<JButton> buttonList = new ArrayList<JButton>();
	
	private CreateTextField telephoneScreen;
	
	private CommandFactory commandFactory;
	private StaticData.GameData gameData;
	
	/**
	 * receives and sets private variable values to parameter values
	 * @param jFrame type JFrame
	 * @param bounds type Rectangle
	 * @param gameData object type
	 */
	public Telephone(JFrame jFrame,
			         Rectangle bounds,
			         StaticData.GameData gameData) {
		
		super(jFrame, bounds);
		
		this.gameData = gameData;
		
		this.initializeTelephone();
		
	}
	
	private void initializeTelephone() {
		this.setTelephoneTextField();
		this.setTelephoneButtons();
		this.moveAllPosition();
		this.initializeButtons();
	}
	
	private void setTelephoneTextField() {

		//SCREEN PROPERTIES
		final int TEXT_FIELD_X = 70,
				  TEXT_FIELD_Y = 30;
		
		final int TEXT_FIELD_HEIGHT = 75,
				  TEXT_FIELD_WIDTH  = 350;

		//TEXT-FIELD BOUNDS 
		final Rectangle TEXT_FIELD_BOUNDS = new Rectangle(TEXT_FIELD_X, TEXT_FIELD_Y,
										    TEXT_FIELD_WIDTH, TEXT_FIELD_HEIGHT);
		
		//SET SCREEN
		this.telephoneScreen = new CreateTextField(super.getJFrame(), TEXT_FIELD_BOUNDS);
	}
	
	private void setTelephoneButtons() {
		
		//BUTTON PROPERTIES
		final Character ONE_VALUE = '1',
				        TWO_VALUE = '2',
				        THREE_VALUE = '3',
				        FOUR_VALUE = '4',
				        FIVE_VALUE = '5',
				        SIX_VALUE = '6',
				        SEVEN_VALUE = '7',
				        EIGHT_VALUE = '8',
				        NINE_VALUE = '9',
				        ZERO_VALUE = '0',
				        ASTERISK_VALUE = '*',
				        POUND_VALUE = '#';
		
		final int FIRST_COLUMN_X  = 70,
				  SECOND_COLUMN_X = 195,
				  THIRD_COLUMN_X  = 320,
				  
				  FIRST_ROW_Y  = 125,
				  SECOND_ROW_Y = 250,
				  THIRD_ROW_Y  = 375,
				  FOURTH_ROW_Y = 500;
		
		final int BUTTON_HEIGHT = 100,
				  BUTTON_WIDTH  = 100;
		
		//BUTTON BOUNDS
		final Rectangle ONE_BOUNDS = new Rectangle(FIRST_COLUMN_X, FIRST_ROW_Y, 
								     BUTTON_WIDTH, BUTTON_HEIGHT),
				        TWO_BOUNDS = new Rectangle(SECOND_COLUMN_X, FIRST_ROW_Y, 
				        			 BUTTON_WIDTH, BUTTON_HEIGHT),
				        THREE_BOUNDS = new Rectangle(THIRD_COLUMN_X, FIRST_ROW_Y, 
				        			   BUTTON_WIDTH, BUTTON_HEIGHT),
				        FOUR_BOUNDS = new Rectangle(FIRST_COLUMN_X, SECOND_ROW_Y, 
				        			  BUTTON_WIDTH, BUTTON_HEIGHT),
				        FIVE_BOUNDS = new Rectangle(SECOND_COLUMN_X, SECOND_ROW_Y, 
			        			  	  BUTTON_WIDTH, BUTTON_HEIGHT),
				        SIX_BOUNDS = new Rectangle(THIRD_COLUMN_X, SECOND_ROW_Y, 
			        			     BUTTON_WIDTH, BUTTON_HEIGHT),
			        	SEVEN_BOUNDS = new Rectangle(FIRST_COLUMN_X, THIRD_ROW_Y, 
				        			   BUTTON_WIDTH, BUTTON_HEIGHT),
				        EIGHT_BOUNDS = new Rectangle(SECOND_COLUMN_X, THIRD_ROW_Y, 
			        			  	   BUTTON_WIDTH, BUTTON_HEIGHT),
				        NINE_BOUNDS = new Rectangle(THIRD_COLUMN_X, THIRD_ROW_Y, 
			        			      BUTTON_WIDTH, BUTTON_HEIGHT),
				        ASTERISK_BOUNDS = new Rectangle(FIRST_COLUMN_X, FOURTH_ROW_Y, 
			        			          BUTTON_WIDTH, BUTTON_HEIGHT),
				        ZERO_BOUNDS = new Rectangle(SECOND_COLUMN_X, FOURTH_ROW_Y, 
		        			  	      BUTTON_WIDTH, BUTTON_HEIGHT),
				        POUND_BOUNDS = new Rectangle(THIRD_COLUMN_X, FOURTH_ROW_Y, 
		        			           BUTTON_WIDTH, BUTTON_HEIGHT);
		
		//SET BUTTONS
		this.one = new CreateTelephoneButton(super.getJFrame(), ONE_BOUNDS, 
				   ONE_VALUE);
		this.two = new CreateTelephoneButton(super.getJFrame(), TWO_BOUNDS, 
				   TWO_VALUE);
		this.three = new CreateTelephoneButton(super.getJFrame(), THREE_BOUNDS, 
				     THREE_VALUE);
		this.four = new CreateTelephoneButton(super.getJFrame(), FOUR_BOUNDS, 
				    FOUR_VALUE);
		this.five = new CreateTelephoneButton(super.getJFrame(), FIVE_BOUNDS, 
				    FIVE_VALUE);
		this.six = new CreateTelephoneButton(super.getJFrame(), SIX_BOUNDS, 
				   SIX_VALUE);
		this.seven = new CreateTelephoneButton(super.getJFrame(), SEVEN_BOUNDS, 
				     SEVEN_VALUE);
		this.eight = new CreateTelephoneButton(super.getJFrame(), EIGHT_BOUNDS, 
				     EIGHT_VALUE);
		this.nine = new CreateTelephoneButton(super.getJFrame(), NINE_BOUNDS, 
				    NINE_VALUE);
		this.zero = new CreateTelephoneButton(super.getJFrame(), ZERO_BOUNDS, 
				    ZERO_VALUE);
		this.asterisk = new CreateTelephoneButton(super.getJFrame(), ASTERISK_BOUNDS, 
				        ASTERISK_VALUE);
		this.pound = new CreateTelephoneButton(super.getJFrame(), POUND_BOUNDS, 
				     POUND_VALUE);
		
	}

	@Override
	public void movePosition(Component object, int newX, int newY) {
		object.setLocation(object.getLocation().x + newX, 
				object.getLocation().y + newY);
		
	}
	
	@Override 
	public void addAllMovableComponents() {
		Collections.addAll(this.componentList, 
				this.telephoneScreen.getTextField(),
				this.one.getJButton(),
				this.two.getJButton(),
				this.three.getJButton(),
				this.four.getJButton(),
				this.five.getJButton(),
				this.six.getJButton(),
				this.seven.getJButton(),
				this.eight.getJButton(),
				this.nine.getJButton(),
				this.zero.getJButton(),
				this.asterisk.getJButton(),
				this.pound.getJButton());
	}

	@Override
	public void moveAllPosition() {
		this.addAllMovableComponents();
		
		final int STARTING_X = (int)super.getBounds().getX(),
				  STARTING_Y = (int)super.getBounds().getY();
		
		for(Component component : this.componentList) {
			this.movePosition(component, STARTING_X, STARTING_Y);
		}
	}
	
	@Override
	public JTextField getTextField() {
		return this.telephoneScreen.getTextField();
	}
	
	@Override
	public void addAllClickableButtons() {
		Collections.addAll(this.buttonList,
				this.one.getJButton(),
				this.two.getJButton(),
				this.three.getJButton(),
				this.four.getJButton(),
				this.five.getJButton(),
				this.six.getJButton(),
				this.seven.getJButton(),
				this.eight.getJButton(),
				this.nine.getJButton(),
				this.zero.getJButton(),
				this.asterisk.getJButton(),
				this.pound.getJButton());
	}
	
	@Override
	public void makeButtonClickable(JButton button) {
		button.addActionListener(this);
	}
	
	@Override
	public void makeAllButtonsClickable() {
		for(JButton button : this.buttonList) {
			this.makeButtonClickable(button);
		}
	}

	@Override
	public void initializeButtons() {
		this.addAllClickableButtons();
		this.makeAllButtonsClickable();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String textFromField = this.getTextField().getText();
		String buttonValue = ((JButton)e.getSource()).getText();
		
		this.getTextField().setText(textFromField + buttonValue);
		
		if(this.gameData.getCurrentInquiry() != "ConnectToPresident"
			&& this.gameData.getCurrentInquiry() != "BookAppointment"
			&& this.gameData.getCurrentInquiry() != "EnterSpecialCode") {
			
			//Single digit input
			switch(this.gameData.getCurrentInquiry()) {
				case "MainMenu":
					this.commandFactory = new MainMenu(this.getTextField(), 
							              this.getAllClickableButtons(), this.gameData);
					break;
				case "ContactRepresentative":
					this.commandFactory = new ContactRepresentative(this.getTextField(), 
				                          this.getAllClickableButtons(), this.gameData);
					break;
				case "InvalidCodeMultipleAttempt":
					this.commandFactory = new InvalidCodeMultipleAttempt(this.getTextField(),
				                          this.getAllClickableButtons(), this.gameData);
					break;
				case "WelcomePrimeMinister":
					this.commandFactory = new WelcomePrimeMinister(this.getTextField(), 
							              this.getAllClickableButtons(), this.gameData);
					break;
				case "EmergencyCannotWait":
					this.commandFactory = new EmergencyCannotWait(this.getTextField(),
							              this.getAllClickableButtons(), this.gameData);
					break;
				case "NuclearWarConcern":
					this.commandFactory = new NuclearChoice(this.getTextField(),
				                          this.getAllClickableButtons(), this.gameData);
					break;
				case "AccidentalyTargeted":
					this.commandFactory = new AccidentalyTargeted(this.getTextField(),
							              this.getAllClickableButtons(), this.gameData);
					break;
				case "NeedPermission":
					this.commandFactory = new NeedPermission(this.getTextField(), 
							              this.getAllClickableButtons(), this.gameData);
					break;
				case "ToContinue":
					this.commandFactory = new ToContinue(this.getTextField(), 
				                          this.getAllClickableButtons(), this.gameData);
					break;
				case "ReallySure":
					this.commandFactory = new ReallySure(this.getTextField(), 
				                          this.getAllClickableButtons(), this.gameData,
				                          this.getJFrame());
					break;
				case "OtherMatters":
					this.commandFactory = new OtherMatters(this.getTextField(), 
	                                      this.getAllClickableButtons(), this.gameData);
					break;
				case "TradeDeals":
					this.commandFactory = new TradeDeals(this.getTextField(), 
	                                      this.getAllClickableButtons(), this.gameData);
					break;
				
				case "NuclearProgram":
					this.commandFactory = new NuclearProgram(this.getTextField(), 
                                          this.getAllClickableButtons(), this.gameData);
					break;
				case "AdditionalVoiceLineToMainMenu":
					this.commandFactory = new AdditionalVoiceLineToMainMenu(this.getTextField(), 
                                          this.getAllClickableButtons(), this.gameData);
					break;
				case "TypesOfWeapons":
					this.commandFactory = new TypesOfWeapons(this.getTextField(), 
                                          this.getAllClickableButtons(), this.gameData);
					break;
				case "DefensiveWeapons":
					this.commandFactory = new DefensiveWeapons(this.getTextField(), 
                                          this.getAllClickableButtons(), this.gameData);
					break;
				case "Speed":
					this.commandFactory = new Speed(this.getTextField(), 
                                          this.getAllClickableButtons(), this.gameData);
					break;
				case "InterceptionMethods":
					this.commandFactory = new InterceptionMethods(this.getTextField(), 
                                          this.getAllClickableButtons(), this.gameData);
					break;
				case "Missile":
					this.commandFactory = new Missile(this.getTextField(), 
                                          this.getAllClickableButtons(), this.gameData);
					break;
				case "Hemisphere":
					this.commandFactory = new Hemisphere(this.getTextField(), 
                                          this.getAllClickableButtons(), this.gameData);
					break;
				case "HotlineVerification":
					this.commandFactory = new HotlineVerification(this.getTextField(), 
                                          this.getAllClickableButtons(), this.gameData);
					break;
				case "Apply":
					this.commandFactory = new Apply(this.getTextField(), 
                                          this.getAllClickableButtons(), this.gameData);
					break;
				case "HighRanking":
					this.commandFactory = new HighRanking(this.getTextField(), 
                                          this.getAllClickableButtons(), this.gameData);
					break;
				default:
					break;
			}
			this.resetScreen();
		}
		else {
			//Multiple digit input
			if(buttonValue.equals("#")) {
				switch(this.gameData.getCurrentInquiry()) {
					case "ConnectToPresident":
						this.commandFactory = new ConnectToPresident(this.getTextField(), 
					                          this.getAllClickableButtons(), this.gameData);
						break;
					case "BookAppointment":
						this.commandFactory = new BookAppointment(this.getTextField(),
								              this.getAllClickableButtons(), this.gameData);
						break;
					case "EnterSpecialCode":
						this.commandFactory = new EnterSpecialCode(this.getTextField(),
					                          this.getAllClickableButtons(), this.gameData);
						break;
					default:
						break;
				}
				this.resetScreen();
			}
		}
		
	}
	/**
	 * list of all clickable buttons
	 * @return arraylist
	 */
	public ArrayList<JButton> getAllClickableButtons() {
		return this.buttonList;
	}
	/**
	 * resets telephone functionality
	 */
	private void resetScreen() {
		this.getTextField().setText("");
	}
	
}
