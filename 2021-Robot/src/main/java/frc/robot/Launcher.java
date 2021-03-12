package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.FollowerType;
import com.ctre.phoenix.motorcontrol.SensorCollection;
import com.ctre.phoenix.motorcontrol.StatusFrame;
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
        SetState(State.kIdle);

        //Instantiates the encoder as the encoder plugged into the master
        m_encoder = new SensorCollection(m_masterMotor);
    }

    /**
     * Vertical constuctor for instantiation
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
    public void SetSpeed(double speed){
        m_masterMotor.set(ControlMode.PercentOutput, speed);
        m_closeSlaveMotor.follow(m_masterMotor, FollowerType.PercentOutput);
        m_farSlaveMotor1.follow(m_masterMotor, FollowerType.PercentOutput);
        m_farSlaveMotor2.follow(m_masterMotor, FollowerType.PercentOutput);
    }

    /**
     * Sets the Launcher state as specified and sets the motor dependent on that
     */
    public void SetState(State state){
        //Checks if we are already in the state
        if(m_state == state) {
            return;
        }
        //Sets the input state to our state
        m_state = state;

        //Checks which state we are in and sets motor speed for each state
        if(m_state == State.kIdle) {
           SetSpeed(0.0);
        }
        else if (m_state == State.kSetup) {
            SetSpeed(0.5);
        }
        else if (m_state == State.kLaunch){
            SetSpeed(0.8);
        }
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