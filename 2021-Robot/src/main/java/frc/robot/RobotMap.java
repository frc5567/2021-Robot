package frc.robot;

import com.ctre.phoenix.motorcontrol.VelocityMeasPeriod;

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

    //launcher PID constants for velocity control
    public static final double LAUNCHER_P = 1.0;
    public static final double LAUNCHER_I = 0;
    public static final double LAUNCHER_D = 0.1;
    public static final double LAUNCHER_F = .27;
    
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

     /**
     * The primary slot for a CTRE PID controller. This slot controlls the main motion of the system, 
     * as oppose to an auxillary controller which controls turning
     */
    public static final int PID_PRIMARY_SLOT = 0;
}