package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FollowerType;
import com.ctre.phoenix.motorcontrol.SensorCollection;
import com.ctre.phoenix.motorcontrol.StatusFrame;
import com.ctre.phoenix.motorcontrol.TalonSRXFeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.BaseMotorController;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

public class Launcher{

    //Enum for the three Launcher states
    public enum State{
        // Idle state for the Launcher
        kIdle("Idle"),
        // Setup state for the Launcher
        kSetup("Setup"),
        // Launch state for the Launcher
        kLaunch("Launch");

        private String stateName;
    
        State(String stateName) {
            this.stateName = stateName;
        }
    
        public String toString() {
            return this.stateName;
        }
    }
        //Declare the launcher state
        State m_state;
    
    //Declare the motors used for Launcher
    private TalonSRX m_masterMotor;
    private BaseMotorController m_closeSlaveMotor;
    private BaseMotorController m_farSlaveMotor1;
    private BaseMotorController m_farSlaveMotor2;

    //the encoder plugged into the master Talon
    SensorCollection m_encoder;

    /**
     * Constructor for Launcher objects
     * @param masterMoter The master motor for the Launcher
     * @param closeSlaveMotor The slave Launcher motor on the same side of the master motor 
     * @param farSlaveMotor1 The first slave Launcher motor on the opposite side of the master motor
     * @param farSlaveMotor2 The second slave Launcher motor on the opposite side of the master motor
     */
    public Launcher(TalonSRX masterMotor, BaseMotorController closeSlaveMotor, BaseMotorController farSlaveMotor1,BaseMotorController farSlaveMotor2){
        m_masterMotor = masterMotor;
        m_closeSlaveMotor = closeSlaveMotor;
        m_farSlaveMotor1 = farSlaveMotor1;
        m_farSlaveMotor2 = farSlaveMotor2;

        //Set the initial state to Idle
        setState(State.kIdle);

        //Run the config method to set up velocity control
        configVelocityControl();

    }

    /**
     * Vertical consrtuctor for instantiation
     */
    public Launcher(){
        m_masterMotor = new TalonSRX(RobotMap.MASTER_LAUNCHER_ID);
        m_closeSlaveMotor = new VictorSPX(RobotMap.CLOSE_LAUNCHER_SLAVE_ID);
        m_farSlaveMotor1 = new VictorSPX(RobotMap.FAR_LAUNCHER_SLAVE1_ID);
        m_farSlaveMotor2 = new VictorSPX(RobotMap.FAR_LAUNCHER_SLAVE2_ID);

        //Instantiates the encoder as the encoder plugged into the master
        m_encoder = new SensorCollection(m_masterMotor);

    }

    /**
     * Sets the Launcher to run based on on a set motor speed
     */
    public void setSpeed(double speed){
        m_masterMotor.set(ControlMode.PercentOutput, speed);
        m_closeSlaveMotor.follow(m_masterMotor, FollowerType.PercentOutput);
        m_farSlaveMotor1.follow(m_masterMotor, FollowerType.PercentOutput);
        m_farSlaveMotor2.follow(m_masterMotor, FollowerType.PercentOutput);
    }

    /**
     * Sets the velocity of the motors in rev/100ms
     * @param velocity target velocity in rev/100ms
     */
    public void setVelocity(double velocity) {
        //set the velocity of the motors
        m_masterMotor.set(ControlMode.Velocity, velocity);
        
        //set our slave motors to follow master
        m_closeSlaveMotor.follow(m_masterMotor, FollowerType.PercentOutput);
        m_farSlaveMotor1.follow(m_masterMotor, FollowerType.PercentOutput);
        m_farSlaveMotor2.follow(m_masterMotor, FollowerType.PercentOutput);
    }

    /**
     * Sets the Launcher state as specified and sets the motor dependent on that
     */
    public void setState(State state){
        //Checks if we are already in the state
        if(m_state == state) {
            return;
        }
        //Sets the input state to our state
        m_state = state;

        //Checks which state we are in and sets motor speed for each state
        if(m_state == State.kIdle) {
           setSpeed(0.0);
        }
        else if (m_state == State.kSetup) {
            setSpeed(0.5);
        }
        else if (m_state == State.kLaunch){
            setVelocity(0.8);
        }
    }
    private void configVelocityControl() {
        //Config remote sensors
        //Sets the sensor to be a quad encoder, sets our feedback device to be that sensor
        m_masterMotor.configSelectedFeedbackSensor(TalonSRXFeedbackDevice.CTRE_MagEncoder_Relative, RobotMap.PID_PRIMARY_SLOT, RobotMap.LAUNCHER_CONFIG_TIMEOUT_MS);

        //Zero the encoders on every init
        zeroEncoder();


        //This sets how often we pull data from our sensor
        m_masterMotor.setStatusFramePeriod(StatusFrame.Status_2_Feedback0, RobotMap.LAUNCHER_FEEDBACK_PERIOD_MS, RobotMap.LAUNCHER_CONFIG_TIMEOUT_MS);

        //This configs the deadband for the PID output. Any output with an absolute value less than this will be treated as zero
        m_masterMotor.configNeutralDeadband(0, RobotMap.LAUNCHER_CONFIG_TIMEOUT_MS);

        //This sets the peak output for our motor controller.
        m_masterMotor.configPeakOutputForward(RobotMap.LAUNCHER_PID_PEAK_OUTPUT, RobotMap.LAUNCHER_CONFIG_TIMEOUT_MS);
        //This does the same thing but for the reverse direction
        m_masterMotor.configPeakOutputReverse(0, RobotMap.LAUNCHER_CONFIG_TIMEOUT_MS);
        
        //Sets the period of the velocity sample
        //Effectively this defines the amount of time used to calculate the velocity
        m_masterMotor.configVelocityMeasurementPeriod(RobotMap.VELOCITY_MEASUREMENT_PERIOD, RobotMap.LAUNCHER_CONFIG_TIMEOUT_MS);

        //Sets the number of samples used in the rolling average for calculating velocity
        m_masterMotor.configVelocityMeasurementWindow(RobotMap.LAUNCHER_VELOCITY_MEASUREMENT_WINDOW, RobotMap.LAUNCHER_CONFIG_TIMEOUT_MS);
        
        //Set p, i, d, f values
        //The zero is the PID slot, in this case it is zero for the primary PID
        //The launcher has no auxillary or turning PID control
        m_masterMotor.config_kP(RobotMap.PID_PRIMARY_SLOT, RobotMap.LAUNCHER_P);
        m_masterMotor.config_kI(RobotMap.PID_PRIMARY_SLOT, RobotMap.LAUNCHER_I);
        m_masterMotor.config_kD(RobotMap.PID_PRIMARY_SLOT, RobotMap.LAUNCHER_D);
        m_masterMotor.config_kF(RobotMap.PID_PRIMARY_SLOT, RobotMap.LAUNCHER_F);

        //This sets the acceptable amount of Integral error, where if the absolute accumulated error exceeds this ammount, it resets to zero
        //This is designed to prevent the PID from going crazy if we move too far from our target
        m_masterMotor.config_IntegralZone(RobotMap.PID_PRIMARY_SLOT, RobotMap.LAUNCHER_I_ZONE, RobotMap.LAUNCHER_CONFIG_TIMEOUT_MS);

        //Sets the max output of the motor specifically within closed loop control
        m_masterMotor.configClosedLoopPeakOutput(RobotMap.PID_PRIMARY_SLOT, RobotMap.LAUNCHER_PID_PEAK_OUTPUT, RobotMap.LAUNCHER_CONFIG_TIMEOUT_MS);

        //This configures an allowable error in closed loop control
        //Any error less than this is treated as zero.
        m_masterMotor.configAllowableClosedloopError(RobotMap.PID_PRIMARY_SLOT, RobotMap.LAUNCHER_ACCEPTABLE_ERROR, RobotMap.LAUNCHER_CONFIG_TIMEOUT_MS);

        //Configures the period for closed loop calculations in MS 
        //Should be increased if the can bus is having issues
        m_masterMotor.configClosedLoopPeriod(RobotMap.PID_PRIMARY_SLOT, RobotMap.LAUNCHER_CLOSED_LOOP_PERIOD_MS, RobotMap.LAUNCHER_CONFIG_TIMEOUT_MS);

        //Configures ramp speed
        m_masterMotor.configOpenloopRamp(RobotMap.LAUNCHER_OPEN_LOOP_RAMP_TIME_S);
        m_masterMotor.configClosedloopRamp(0);

        //Sets our closed loop control to use our primary PID slot
        m_masterMotor.selectProfileSlot(RobotMap.PID_PRIMARY_SLOT, 0);
    }

    /**
     * Zeros the selected encoder
     */
    public void zeroEncoder() {
        m_masterMotor.setSelectedSensorPosition(0);
    }

    /**
     * @return The velocity of the encoder in units per 100ms
     */
    public int getEncoderVelocity() {
        return m_encoder.getQuadratureVelocity();
    }

    /**
     * @return the position of the encoder in encoder units
     */
    public int getEncoderPosition() {
        return m_encoder.getQuadraturePosition();
    }

    /**
     * toString method containing motor ID and inversion and encoder position
     * 
     * @return the state of the Launcher object summarized in a string
     */
    public String toString() {
        return "Motor ID: " + m_masterMotor.getDeviceID() + ", Motor Inversion: " + m_masterMotor.getInverted()
        + ", Current Output (percent): " + m_masterMotor.getMotorOutputPercent()+ " | Encoder Position: "+ m_encoder.getQuadraturePosition();
    }
}