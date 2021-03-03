package frc.robot;
/**
 * Constants for Variables needed throughout code
 */
public class RobotMap {
    /**
     * Controller Constants
    */

    /**The USB port for the drive controller */
    public static final int DRIVE_CONTROLLER_PORT = 1;
    
    /**the deadband on our controller sticks, used to prevent drift*/
    public static final double PILOT_CONTROLLER_STICK_DEADBAND = 0.08;

    /**
     * Drive Train Constants
     */

     /** The default scalar for drive inputs - what we multiply input from drive controller by */
    public static final double DRIVE_DEFAULT_INPUT_SCALAR = 0.6;

    //Whether the drivetrain has two solenoids
    public static final boolean DRIVETRAIN_HAS_TWO_SOLENOIDS = true;

    public static final int MASTER_LEFT_FALCON_ID = 3;
    public static final int MASTER_RIGHT_FALCON_ID = 4;
    public static final int SLAVE_LEFT_FALCON_ID = 13;
    public static final int SLAVE_RIGHT_FALCON_ID = 14;

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
     * General Constants
     */
    public static final int PCM_CAN_ID = 20;
}