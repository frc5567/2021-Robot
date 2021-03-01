/**
 * Constants for Variables needed throughout code
 */
public class RobotMap {
    /**
     * Drive Train Constants
     */
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
}
    