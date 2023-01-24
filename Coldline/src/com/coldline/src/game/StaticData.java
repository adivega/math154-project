package com.coldline.src.game;
/**
 * houses all the static data the package needs such as the game data between states,
 * asset file names,and provides methods for getting the audio file for each state
 * @author adrian erle vega
 *
 */
public class StaticData {
	/**
	 * game data class which measures each state of the game
	 * @author adrian erle vega
	 *
	 */
	public static class GameData {
		
		private String currentInquiry,
		               nuclearCode = "060795#";
		
		private int codeAttempt = 0;
		/**
		 * sets the current state for each iteration
		 * @param currentInquiry string type
		 */
		public void setCurrentInquiry(String currentInquiry) {
			this.currentInquiry = currentInquiry;
		}
		/**
		 * notes the current state of the game
		 * @return string type
		 */
		public String getCurrentInquiry() {
			return this.currentInquiry;
		}
		/**
		 * gets the inputted code by the player
		 * @return string type
		 */
		public String getNuclearCode() {
			return this.nuclearCode;
		}
		/**
		 * a state of the game requires multiple attempts
		 * @return number of attempts for a certain puzzle
		 */
		public int getCodeAttempts() {
			return this.codeAttempt;
		}
		/**
		 * resets attempt count or sets it
		 * @param codeAttempt int type
		 */
		public void setCodeAttempt(int codeAttempt) {
			this.codeAttempt = codeAttempt;
		}
		
	}
	/**
	 * ui window
	 * @author adrian erle vega
	 *
	 */
	public static class GameDetails {
		
		private final String WINDOW_TITLE = "Coldine";
		
		private final int WINDOW_WIDTH  = 1000,
				          WINDOW_HEIGHT = 800;
		/**
		 * gets the window title
		 * @return constant string
		 */
		public String getWindowTitle() {
			return this.WINDOW_TITLE;
		}
		/**
		 * gets the window width
		 * @return constant int
		 */
		public int getWindowWidth() {
			return this.WINDOW_WIDTH;
		}
		/**
		 * gets the window height
		 * @return constant int
		 */
		public int getWindowHeight() {
			return this.WINDOW_HEIGHT;
		}
		
	}
	/**
	 * class which has the file names as constant strings
	 * used in Dialogue class
	 * @author adrian erle vega
	 *
	 */
	public static class GameFileNames {
		
		private final String GREETINGS                      = "Greeting.wav",
				             CONNECT_TO_PRESIDENT           = "Connect_To_President.wav",
				             CONTACT_REPRESENTATIVE         = "Contact_Representative.wav",
				             OTHER_MATTERS                  = "Other_Matters.wav",
				             TRY_AGAIN_ANOTHER_TIME         = "Try_Again_Another_Time.wav",
				             WELCOME                        = "Welcome.wav",
				             INVALID_CODE_SINGLE_ATTEMPT    = "Invalid_Code_Single_Attempt.wav",
				             INVALID_CODE_MULTIPLE_ATTEMPTS = "Invalid_Code_Multiple_Attempts.wav",
				             PRESIDENT_NOT_AVAILABLE        = "President_Not_Available.wav",
				             BOOK_APPOINTMENT               = "Book_Appointment.wav",
				             EMERGENCY_CANNOT_WAIT          = "Emergency_Cannot_Wait.wav",
				             ECONOMIC_CHOICE                = "Economic_Choice.wav",
				             NUCLEAR_CHOICE                 = "Nuclear_Choice.wav",
				             COUNTRY_IN_DANGER              = "Country_In_Danger.wav",
				             COUNTRY_NOT_IN_DANGER          = "Country_Not_In_Danger.wav",
				             NO_PERSONNEL                   = "No_Personel.wav",
				             ACCIDENTALLY_TARGETED          = "Accidentally_Targeted.wav",
				             NEED_PERMISSION_CODE           = "Need_Permission_Code.wav",
				             ENTER_SPECIAL_CODE             = "Enter_Special_Code.wav",
				             TO_CONTINUE                    = "To_Continue.wav",
				             REALLY_SURE                    = "Really_Sure.wav",
				             INTERCEPTION_SENT              = "Interception_Sent.wav",
				             TRADE_DEALS                    = "Trade_Deals.wav",
				             NUCLEAR_PROGRAM                = "Nuclear_Program.wav",
				             HOTLINE_VERIFICATION           = "Hotline_Verification.wav",
				             KNOW_MORE                      = "Know_More.wav",
				             PREVENT_WAR                    = "Prevent_War.wav",
				             TYPES_OF_WEAPONS               = "Types_Of_Weapons.wav",
				             OFFENSIVE_WEAPONS              = "Offensive_Weapons.wav",
				             DEFENSIVE_WEAPONS              = "Defensive_Weapons.wav",
				             SPEED                          = "Speed.wav",
				             INTERCEPTION_METHODS           = "Interception_Methods.wav",
				             SLOW_MISSILE                   = "Slow_Missile.wav",
				             FAST_MISSILE                   = "Fast_Missile.wav",
				             NORTH_HEMISPHERE               = "North_Hemisphere.wav",
				             SOUTH_HEMISPHERE               = "South_Hemisphere.wav",
				             APPLY                          = "Apply.wav",
				             HIGH_RANKING                   = "High_Ranking.wav",
				             PROXY_HEAD                     = "Proxy_Head.wav",
				             STATE_HEAD                     = "State_Head.wav",
				             INVALID_INPUT                  = "Invalid_Input.wav";
		/**
		 * gets the string name for the respective file
		 * @return string type
		 */
		public String getMainMenuAudioFile() {
			return this.GREETINGS;
		}
		/**
		 * gets the string name for the respective file
		 * @return string type
		 */
		public String getConnectToPresidentAudioFile() {
			return this.CONNECT_TO_PRESIDENT;
		}
		/**
		 * gets the string name for the respective file
		 * @return string type
		 */
		public String getContactRepresentativeAudioFile() {
			return this.CONTACT_REPRESENTATIVE;
		}
		/**
		 * gets the string name for the respective file
		 * @return string type
		 */
		public String getOtherMattersAudioFile() {
			return this.OTHER_MATTERS;
		}
		/**
		 * gets the string name for the respective file
		 * @return string type
		 */
		public String getTryAgainAnotherTimeAudioFile() {
			return this.TRY_AGAIN_ANOTHER_TIME;
		}
		/**
		 * gets the string name for the respective file
		 * @return string type
		 */
		public String getWelcomeAudioFile() {
			return this.WELCOME;
		}
		/**
		 * gets the string name for the respective file
		 * @return string type
		 */
		public String getInvalidCodeSingleAttemptAudioFile() {
			return this.INVALID_CODE_SINGLE_ATTEMPT;
		}
		/**
		 * gets the string name for the respective file
		 * @return string type
		 */
		public String getInvalidCodeMultipleAttemptsAudioFile() {
			return this.INVALID_CODE_MULTIPLE_ATTEMPTS;
		}
		/**
		 * gets the string name for the respective file
		 * @return string type
		 */
		public String getPresidentNotAvailableAudioFile() {
			return this.PRESIDENT_NOT_AVAILABLE;
		}
		/**
		 * gets the string name for the respective file
		 * @return string type
		 */
		public String getBookAppointmentAudioFile() {
			return this.BOOK_APPOINTMENT;
		}
		/**
		 * gets the string name for the respective file
		 * @return string type
		 */
		public String getEmergencyCannotWaitAudioFile() {
			return this.EMERGENCY_CANNOT_WAIT;
		}
		/**
		 * gets the string name for the respective file
		 * @return string type
		 */
		public String getEconomicChoiceAudioFile() {
			return this.ECONOMIC_CHOICE;
		}
		/**
		 * gets the string name for the respective file
		 * @return string type
		 */
		public String getNuclearChoiceAudioFile() {
			return this.NUCLEAR_CHOICE;
		}
		/**
		 * gets the string name for the respective file
		 * @return string type
		 */
		public String getCountryInDangerAudioFile() {
			return this.COUNTRY_IN_DANGER;
		}
		/**
		 * gets the string name for the respective file
		 * @return string type
		 */
		public String getCountryNotInDangerAudioFile() {
			return this.COUNTRY_NOT_IN_DANGER;
		}
		/**
		 * gets the string name for the respective file
		 * @return string type
		 */
		public String getNoPersonnelAudioFile() {
			return this.NO_PERSONNEL;
		}
		/**
		 * gets the string name for the respective file
		 * @return string type
		 */
		public String getAccidentalyTargetedAudioFile() {
			return this.ACCIDENTALLY_TARGETED;
		}
		/**
		 * gets the string name for the respective file
		 * @return string type
		 */
		public String getNeedPermissionCodeAudioFile() {
			return this.NEED_PERMISSION_CODE;
		}
		/**
		 * gets the string name for the respective file
		 * @return string type
		 */
		public String getEnterSpecialCodeAudioFile() {
			return this.ENTER_SPECIAL_CODE;
		}
		/**
		 * gets the string name for the respective file
		 * @return string type
		 */
		public String getToContinueAudioFile() {
			return this.TO_CONTINUE;
		}
		/**
		 * gets the string name for the respective file
		 * @return string type
		 */
		public String getReallySureAudioFile() {
			return this.REALLY_SURE;
		}
		/**
		 * gets the string name for the respective file
		 * @return string type
		 */
		public String getIntercpetionSentAudioFile() {
			return this.INTERCEPTION_SENT;
		}
		/**
		 * gets the string name for the respective file
		 * @return string type
		 */
		public String getTradeDealsAudioFile() {
			return this.TRADE_DEALS;
		}
		/**
		 * gets the string name for the respective file
		 * @return string type
		 */
		public String getNuclearProgramAudioFile() {
			return this.NUCLEAR_PROGRAM;
		}
		/**
		 * gets the string name for the respective file
		 * @return string type
		 */
		public String getHotlineVerificationAudioFile() {
			return this.HOTLINE_VERIFICATION;
		}
		/**
		 * gets the string name for the respective file
		 * @return string type
		 */
		public String getKnowMoreAudioFile() {
			return this.KNOW_MORE;
		}
		/**
		 * gets the string name for the respective file
		 * @return string type
		 */
		public String getPreventWarAudioFile() {
			return this.PREVENT_WAR;
		}
		/**
		 * gets the string name for the respective file
		 * @return string type
		 */
		public String getTypesOfWeaponsAudioFile() {
			return this.TYPES_OF_WEAPONS;
		}
		/**
		 * gets the string name for the respective file
		 * @return string type
		 */
		public String getOffensiveWeaponsAudioFile() {
			return this.OFFENSIVE_WEAPONS;
		}
		/**
		 * gets the string name for the respective file
		 * @return string type
		 */
		public String getDefensiveWeaponsAudioFile() {
			return this.DEFENSIVE_WEAPONS;
		}
		/**
		 * gets the string name for the respective file
		 * @return string type
		 */
		public String getSpeedAudioFile() {
			return this.SPEED;
		}
		/**
		 * gets the string name for the respective file
		 * @return string type
		 */
		public String getInterceptionMethodsAudioFile() {
			return this.INTERCEPTION_METHODS;
		}
		/**
		 * gets the string name for the respective file
		 * @return string type
		 */
		public String getSlowMissileAudioFile() {
			return this.SLOW_MISSILE;
		}
		/**
		 * gets the string name for the respective file
		 * @return string type
		 */
		public String getFastMissileAudioFile() {
			return this.FAST_MISSILE;
		}
		/**
		 * gets the string name for the respective file
		 * @return string type
		 */
		public String getNorthHemisphereAudioFile() {
			return this.NORTH_HEMISPHERE;
		}
		/**
		 * gets the string name for the respective file
		 * @return string type
		 */
		public String getSouthHemisphereAudioFile() {
			return this.SOUTH_HEMISPHERE;
		}
		/**
		 * gets the string name for the respective file
		 * @return string type
		 */
		public String getApplyAudioFile() {
			return this.APPLY;
		}
		/**
		 * gets the string name for the respective file
		 * @return string type
		 */
		public String getHighRankingAudioFile() {
			return this.HIGH_RANKING;
		}
		/**
		 * gets the string name for the respective file
		 * @return string type
		 */
		public String getProxyHeadAudioFile() {
			return this.PROXY_HEAD;
		}
		/**
		 * gets the string name for the respective file
		 * @return string type
		 */
		public String getStateHeadAudioFile() {
			return this.STATE_HEAD;
		}
		/**
		 * gets the string name for the respective file
		 * @return string type
		 */
		public String getInvalidInputAudioFile() {
			return this.INVALID_INPUT;
		}
		
	}
	
}
