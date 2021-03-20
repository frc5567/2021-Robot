package frc.robot;

import com.ctre.phoenix.motorcontrol.VelocityMeasPeriod;

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
    //the total number of encoder ticks in a rotate----TODO: Check to see if this is the correct number
    public static final double STARTING_TICK_VALUE = 1440;


    /**
     * Launcher Constants
     */
    public static final int MASTER_LAUNCHER_ID = 21;
    public static final int CLOSE_LAUNCHER_SLAVE_ID = 22;
    public static final int FAR_LAUNCHER_SLAVE1_ID = 23;
    public static final int FAR_LAUNCHER_SLAVE2_ID = 24;

    //Motor inversion
    public static final boolean LAUNCHER_FAR_SLAVE_1_INVERTED = false;
    public static final boolean LAUNCHER_FAR_SLAVE_2_INVERTED = true;


    //launcher PID constants for velocity control
    public static final double LAUNCHER_P = 0.1;//1
    public static final double LAUNCHER_I = 0;
    public static final double LAUNCHER_D = 0;// 0.1
    public static final double LAUNCHER_F = 0;// .27
    
    //the launcher timeout for running confing methods
    public static final int LAUNCHER_CONFIG_TIMEOUT_MS = 30;

    //the period for reading data from the encoders attached to the motor controllers
    public static final int LAUNCHER_FEEDBACK_PERIOD_MS = 10;

    //the neutral deadband for our launcher PID
    public static final double LAUNCHER_NEUTRAL_DEADBAND = 0.04;

    //the peak output on our launcher PID
    public static final double LAUNCHER_PID_PEAK_OUTPUT = 0.9;

    //the number of samples use in rolling average. Valid values are 1,2,4,8,16,32. If another value is specified, it will truncate to nearest support value.
    //this number is currently arbitrary
    public static final int LAUNCHER_VELOCITY_MEASUREMENT_WINDOW = 8;

    //the acceptable integral zone for the launch master motor
    //100 is the value used last year, this should be adjusted in testing if need be
    public static final int LAUNCHER_I_ZONE = 1000;

    //the acceptable error for the launcher PID. Any error less than this will be treated as zero
    public static final int LAUNCHER_ACCEPTABLE_ERROR = 50;

    //the closed loop period for the launcher PID
    public static final int LAUNCHER_CLOSED_LOOP_PERIOD_MS = 10; 
    public static final int LAUNCHER_OPEN_LOOP_RAMP_TIME_S = 3;

    //the measurement period for calculating velocity off of the encoder
    public static final VelocityMeasPeriod VELOCITY_MEASUREMENT_PERIOD = VelocityMeasPeriod.Period_10Ms;

    public static final double LAUNCHER_SETUP_SPEED = 0.5;

    public static final double LAUNCHER_FIRING_SPEED = 0.7;
    
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
    public static final int MAGAZINE_MOTOR_PORT = 30;

    /**The DIO port for the photoelectric sensor mounted near the intake */
    public static final int MAGAZINE_IN_SENSOR_PORT = 7;

    /**The DIO port for the photoelectric sensor mounted near the launcher */
    public static final int MAGAZINE_OUT_SENSOR_PORT = 8;

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

    public static final double LAUNCHER_HOLDING_SPEED = 0.5; //original 0.5
    public static final double MAGAZINE_LAUNCH_SPEED = 0.3; //original 0.65
    public static final double MAGAZINE_DUMP_SPEED = -0.45; //original -0.45
    public static final double MAGAZINE_INTAKE_SPEED = 0.4; //original 0.65

    public static final double INNER_INTAKE_SPEED = 0.3;
    public static final double OUTER_INTAKE_SPEED = 0.8;

    /** A storage class to put all of the gamepad button IDs in the same spot */
    static final class GAMEPAD_BUTTON_ID
    {
		public static final int MOVE_MAGAZINE_DOWN = 4;
		public static final int MOVE_MAGAZINE_LAUNCH = 5;
		public static final int LAUNCHER_AND_MAGAZINE = 7;
		public static final int REV_LAUNCHER = 6;
		public static final int ENABLE_INTAKE = 8;
		public static final int DISABLE_INTAKE = 9;
		public static final int DUMP_BALLS = 12;
    }   

    
    /**
     * General Constants
     */
    public static final int PCM_CAN_ID = 20;
    
     /**
     * The primary slot for a CTRE PID controller. This slot controlls the main motion of the system, 
     * as oppose to an auxillary controller which controls turning
     */
    public static final int PID_PRIMARY_SLOT = 0;


    /**
     * Auton Constants
     */
    public static final double FORWARD_DRIVE_SPEED = 0.25;

    public static final double BACKWARD_DRIVE_SPEED = -0.25;

    public static final double CLOCKWISE_SPEED = 0.25;

    public static final double COUNTER_CLOCKWISE_SPEED = -0.25;

    public static final double ROTATE_BOUND = 0.05;

}
