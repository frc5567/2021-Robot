package frc.robot;
/**
 * Constants for Variables needed throughout code
 */
public class RobotMap {
    /**

     * Drivetrain Constants for motors
     */
    /** Motor ID Constants */

    public static final int MASTER_LEFT_FALCON_ID = 3;
    public static final int MASTER_RIGHT_FALCON_ID = 4;
    public static final int SLAVE_LEFT_FALCON_ID = 13;
    public static final int SLAVE_RIGHT_FALCON_ID = 14;

    /** Drivetrain Constants for double solenoids/pistons */
    public static final int LEFT_SOLENOID_FORWARD_PORT = 4;
    public static final int LEFT_SOLENOID_REVERSE_PORT = 5;
    public static final int RIGHT_SOLENOID_FORWARD_PORT = 2;
    public static final int RIGHT_SOLENOID_REVERSE_PORT = 1;

    /** The timeout constant for the CTRE config methods in miliseconds */
    public static final int TIMEOUT_MS = 30;

    public static final double INCHES_TO_ENCODER_TICKS = 4096 / 18.85;

    /**
     * Launcher Constants
     */
    public static final int MASTER_LAUNCHER_ID = 21;
    public static final int CLOSE_LAUNCHER_SLAVE_ID = 22;
    public static final int FAR_LAUNCHER_SLAVE1_ID = 23;
    public static final int FAR_LAUNCHER_SLAVE2_ID = 24;
    
    /**
     * Intake Constants
     */
    public static final int INTAKE_VICTOR_ID = 16;

    //the PWM port for the outer motor - this is on PWM to reduce CAN traffic
    public static final int INTAKE_PWM_SPARK_PORT = 2;
    public static final int INTAKE_INNER_MOTOR_PORT = 1;

    //inversion for our intake motors
    public static final boolean OUTER_INTAKE_INVERTED = true;
    public static final boolean INNER_INTAKE_INVERTED = true;

      //the ports for the intake position piston
    public static final int INTAKE_POSITION_PISTON_FORWARD_PORT = 0;
    public static final int INTAKE_POSITION_PISTON_REVERSE_PORT = 3;

    /**
     * Magazine Constants
     */
    public static final int MAGAZINE_MOTOR_PORT = 26;

     /**
     * Pilot Controller Constants
     */
    public static final boolean DRIVETRAIN_HAS_TWO_SOLENOIDS = true;
 
    public static final int DRIVE_CONTROLLER_PORT = 1;
 
    public static final double DRIVE_DEFAULT_INPUT_SCALAR = 0.6;
    public static final double PILOT_CONTROLLER_STICK_DEADBAND = 0.08;

    /**
     * GamePad/CopilotController Constants
     */
    /**The USB port for the GamePad */
    public static final int GAMEPAD_PORT = 2;

    public static final double RPM_TO_UNITS_PER_100MS = 2048.0 / 600;

    public static final double LAUNCHER_HOLDING_SPEED = 0.5;
    public static final double MAGAZINE_LAUNCH_SPEED = 0.65;
    public static final double MAGAZINE_DUMP_SPEED = -0.45;
    public static final double MAGAZINE_INTAKE_SPEED = 0.65;

    public static final double INNER_INTAKE_SPEED = 0.3;
    public static final double OUTER_INTAKE_SPEED = 0.8;

    /** A storage class to put all of the gamepad button IDs in the same spot */
    static final class GAMEPAD_BUTTON_ID
    {
		public static final int MOVE_MAGAZINE_DOWN = 4;
		public static final int MOVE_MAGAZINE_LAUNCH = 5;
		public static final int LAUNCHER_AND_MAGAZINE = 7;
		public static final int REV_LAUNCHER = 7;
		public static final int ENABLE_INTAKE = 8;
		public static final int DISABLE_INTAKE = 9;
		public static final int DUMP_BALLS = 12;
    }   

    
    /**
     * General Constants
     */
    public static final int PCM_CAN_ID = 20;


}

