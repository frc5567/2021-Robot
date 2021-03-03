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

    /**
     * Magazine Constants
     */
    public static final int MAGAZINE_MOTOR_PORT = 26;
    
    /**
     * General Constants
     */
    public static final int PCM_CAN_ID = 20;

}