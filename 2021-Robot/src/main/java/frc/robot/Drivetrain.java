/**
 * Some of the class's inputs are received the Pilot Controller and Auton Code
 * This class will uses information from robotMap.
 */

package frc.robot;

    import edu.wpi.first.wpilibj.DoubleSolenoid;
    import edu.wpi.first.wpilibj.SerialPort;
    import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

    import com.ctre.phoenix.motorcontrol.can.TalonFX;
    import com.ctre.phoenix.motorcontrol.ControlMode;
    import com.ctre.phoenix.motorcontrol.DemandType;
    import com.ctre.phoenix.motorcontrol.NeutralMode;
    import com.ctre.phoenix.motorcontrol.SensorCollection;

/**
 * The drivetrain has four motors, and has two speeds for our robot
 */
public class Drivetrain {
    // enum for storing the possible gears that are used for the drivetrain
    public enum Gear{
        kLowGear("Low Gear"),

        kHighGear("High Gear"),

        kUnknown("Unknown");

        private String gearName;

        Gear(String gearName){
            this.gearName = gearName;
        }

        public String toString() {
            return this.gearName;
        }
    }
     
    // Declares TalonFX right motor
    private TalonFX m_masterRightMotor;
    // Declares TalonFX left motor
    private TalonFX m_masterLeftMotor;
    // Declares TalonFX slave right motor
    private TalonFX m_slaveRightMotor;
    // Declares TalonFX slave left motor
    private TalonFX m_slaveLeftMotor;

    // Declares Right Encoder
    private SensorCollection m_leftDriveEncoder;
    // Declares Left Encoder
    private SensorCollection m_rightDriveEncoder;

    // Decares Right Solenoid
    private DoubleSolenoid m_rightSolenoid;
    // Declares Left Solenoid
    private DoubleSolenoid m_leftSolenoid;

    // Declares the Gear
    private Gear m_gear;

    // Declares the Gyro
    private NavX m_gyro;


    /**
     * Constructor for instantiating drivetrain objects 
     */ 
    public Drivetrain(){
        // Instantiate TalonFX motors
        m_masterLeftMotor = new TalonFX(RobotMap.MASTER_LEFT_FALCON_ID);
        m_masterRightMotor = new TalonFX(RobotMap.MASTER_RIGHT_FALCON_ID);
        m_slaveLeftMotor = new TalonFX(RobotMap.SLAVE_LEFT_FALCON_ID);
        m_slaveRightMotor = new TalonFX(RobotMap.SLAVE_RIGHT_FALCON_ID);

        // Instantiate left and right pistons (solenoids)
        m_leftSolenoid = new DoubleSolenoid(RobotMap.PCM_CAN_ID, RobotMap.LEFT_SOLENOID_FORWARD_PORT, RobotMap.LEFT_SOLENOID_REVERSE_PORT);
        m_rightSolenoid = new DoubleSolenoid(RobotMap.PCM_CAN_ID, RobotMap.RIGHT_SOLENOID_FORWARD_PORT, RobotMap.RIGHT_SOLENOID_REVERSE_PORT);

        // Instatiate the left and right encoders
        m_leftDriveEncoder = new SensorCollection(m_masterLeftMotor);
        m_rightDriveEncoder = new SensorCollection(m_masterRightMotor);

        // Set gears initially to unknown, and then shifts the Gear so the robot always starts in low gear
        m_gear = Gear.kUnknown;
        shiftGear(Gear.kLowGear);

        // Instantiates the NavX Gyro
        m_gyro = new NavX(SerialPort.Port.kMXP);
    }

    /**
     * Zero the drive encoders
     */
    public void zeroEncoders(){
        m_leftDriveEncoder.setQuadraturePosition(0, RobotMap.TIMEOUT_MS);
        m_rightDriveEncoder.setQuadraturePosition(0, RobotMap.TIMEOUT_MS);
    }

    public void zeroGyro(){
        m_gyro.zeroYaw();
    }

    /**
     * This function sets the drive gear using the pistons to a value
     * It sets both the left and right solenoid to a value
     */
    private void setPistons(DoubleSolenoid.Value value){
        m_leftSolenoid.set(value);
        m_rightSolenoid.set(value);
    }

    /**
     * This function allows the gears to be switched between high and low.
     * The function setPistons is used in this function
     */
    public void shiftGear(Gear gear){
        if (m_gear == gear){
            return;
        }

        m_gear = gear;

        if (m_gear == Gear.kLowGear){
            setPistons(Value.kForward);

        }
        else if (m_gear == Gear.kHighGear){
            setPistons(Value.kReverse);
        }
    }

    /**
     * This function set sthe motors into "arcade drive", which means the pilot controls the speed of the robot with the 
     * triggers and the direction of the robot with the x axis on the left joystick
     * @param velocityInput
     * @param turnInput
     */
    public void arcadeDrive(double forward, double turn){
        m_masterLeftMotor.set(ControlMode.PercentOutput, forward, DemandType.ArbitraryFeedForward, turn);
        m_masterRightMotor.set(ControlMode.PercentOutput, -forward, DemandType.ArbitraryFeedForward, turn);
        m_slaveLeftMotor.follow(m_masterLeftMotor);
        m_slaveRightMotor.follow(m_masterRightMotor);
    }
    
    /**
     * This function sets the motors up to be used to drive like a tank. Meaning each side is contolled individually.
     * The slave motors will following the master motors that are on the same side of the robot
     * @param leftInput
     * @param rightInput
     */

    public void tankDrive(double leftSpeed, double rightSpeed){
        m_masterLeftMotor.set(ControlMode.PercentOutput, leftSpeed);
        m_masterRightMotor.set(ControlMode.PercentOutput, rightSpeed);

        m_slaveLeftMotor.follow(m_masterLeftMotor);
        m_slaveRightMotor.follow(m_masterRightMotor);
    }

    /**
     * Returns the position of the drivetrain's left side encoder
     */
    public double getLeftDriveEncoderPosition() {
        return m_masterLeftMotor.getSelectedSensorPosition();
    }

    /**
     * Returns the position of the drivetrain's right side encoder
     */
    public double getRightDriveEncoderPosition(){
        return m_masterRightMotor.getSelectedSensorPosition();
    }

    /**
     * Returns the velocity of the drivetrain's left side encoder
     */
    public double getLeftDriveEncoderVelocity() {
        return m_masterLeftMotor.getSelectedSensorVelocity();
    }

    /**
     * Returns the velocity of the drivetrain's right side encoder
     */
    public double getRightDrvieEncoderVelocity(){
        return m_masterRightMotor.getSelectedSensorVelocity();
    }

    /**
     * Returns the angle of the robot in degrees
     */
    public double getGyro(){
        return m_gyro.getOffsetYaw();
    }

    /**
     * Returns the gear we are currently in
     */
    public Gear getGear(){
        return m_gear;
    }


    /**
     * Sets all motors, master and slave, to neutral mode
     */
    public void setNeutralMode(NeutralMode neutralMode){
        m_masterLeftMotor.setNeutralMode(neutralMode);
        m_masterRightMotor.setNeutralMode(neutralMode);
        m_slaveLeftMotor.setNeutralMode(neutralMode);
        m_slaveRightMotor.setNeutralMode(neutralMode);
    }

}
