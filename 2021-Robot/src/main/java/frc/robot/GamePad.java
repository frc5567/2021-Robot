package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;

public class GamePad extends GenericHID {

	/**
	 * Constructor, used for calling super constructor
	 * @param port Port the gamepad is connected to
	 */
	public GamePad(final int port) {
		super(port);
	}

	/**
	 * Actions each button performs
	 * Change numbers to correct port number
	 */
	// this enum defines the buttons and what they do when active
	private enum GamePadControls {
		//Port values for the different gamepad buttons
		Move_Magazine_Down(4),
		Move_Magazine_For_Launch(5),
		Rev_Launcher(6),
		Launcher_And_Magazine(7),
		Enable_Intake(8),
		Disable_Intake(9),
		Dump_Balls(10);

		//Variable used to get port values 
		public final int portNum;

		//Enum constructor that allows for the different port values to be called upon
		GamePadControls(int newPortNum) {
			this.portNum = newPortNum;
		}
	}

	//Method to check if the Move Magazine Down button was pressed
	public boolean getMoveMagazineDown() {
		return super.getRawButton(GamePadControls.Move_Magazine_Down.portNum);
	}
	
	//Method to check if the Move Magazine for Launch button was pressed
	public boolean getMoveMagazine() {
		return super.getRawButton(GamePadControls.Move_Magazine_For_Launch.portNum);
	}

	//Method to check if the Rev Launcher button was pressed
	public boolean getRevLauncherPressed() {
		return super.getRawButtonPressed(GamePadControls.Rev_Launcher.portNum);
	}

	//Method to check if the Rev Launcher button was released from being held down
	public boolean getRevLauncherReleased() {
		return super.getRawButtonReleased(GamePadControls.Rev_Launcher.portNum);
	}

	/**
	 * expected to be used in co-pilot controller
	 * <p> enables intake. Doing so drops the drop bar and turns on the intake motors
	 */
	public boolean getIntake() {
		return super.getRawButton(GamePadControls.Enable_Intake.portNum);
	}

	//Method to check if the Enable Intake button was pressed
	public boolean getIntakePressed() {
		return super.getRawButtonPressed(GamePadControls.Enable_Intake.portNum);
	}
	
	//Method to check if the Disable Intake button was pressed
	public boolean getDisableIntakePressed() {
		return super.getRawButtonPressed(GamePadControls.Disable_Intake.portNum);
	}
	
	//Method to check if the Launcher and Magazine button is being held down
	public boolean getLauncherAndMagazine() {
		return super.getRawButton(GamePadControls.Launcher_And_Magazine.portNum);
	}

	//Method to check if the Launcher and Magazine button was pressed
	public boolean getLauncherAndMagazinePressed() {
		return super.getRawButtonPressed(GamePadControls.Launcher_And_Magazine.portNum);
	}

	//Method to check if the Launcher and Magazine button was released from being held down
	public boolean getLauncherAndMagazineReleased() {
		return super.getRawButtonReleased(GamePadControls.Launcher_And_Magazine.portNum);
	}

	//Method to check if the Dump Balls button is being held down
	public boolean getDumpAllBalls() {
		return super.getRawButton(GamePadControls.Dump_Balls.portNum);
	}

	/**
	 * These must be extended because GenericHID is abstract
	 * We cannot delete these, nor make them private
	 */

	//Method that returns the x axis value of the joystick
	public double getX(Hand hand) {
		return getRawAxis(0);
	}

	//Method that returns the y axis value of the joystick
	public double getY(Hand hand) {
		return getRawAxis(1);
	}

}