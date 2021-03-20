package frc.robot;
 
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import frc.robot.Drivetrain.Gear;
 
/**
 * A class to control the drivetrain with the pilot controller
 * @author Caleb Overbeek
 * @version 2/22/2021
 */
public class PilotController {
    /**
     * Enum to indicate different control systems
     * <li>{@link #kTank}</li>
     * <li>{@link #kArcade}</li>
     */
    public enum DriveType {
         /** 
         * A tank drive system where the user inputs drive speed to the left and right halves
         * of the drivetrain individually
         */
        kTank("Tank Drive"),
 
        /**
         * An arcade drive system where the user inputs a linear speed and a rotation speed
         * which controls the whole drivetrain as a unit
         */ 
        kArcade("Arcade Drive");
 
        //Variable that when returned shows the current control system in use
        private final String driveName;
 
        //Constructor that allows a toString function to be called for debugging
        DriveType(String driveName) {
            this.driveName = driveName;
        }
 
        //toString function to return the current drive type for debugging
        public String toString() {
            return this.driveName;
        }
    }
 
    /**Checks whether or not we are currently targeting and using the drivetrain */
    public static boolean is_currently_targeting = false;
 
    //declare our controller and our drivetrain
    private XboxController m_controller;
    private Drivetrain m_drivetrain;
   
    //declare the drive control type
    private final DriveType m_driveType;
 
    //scalars and network table entries to scale our input on our drivetrain
    //this is to reduce our speed for driver testing and potentially for comp
    private double m_highGearVelocityScalar = RobotMap.DRIVE_DEFAULT_INPUT_SCALAR;
    private double m_highGearTurnScalar = RobotMap.DRIVE_DEFAULT_INPUT_SCALAR;
    private double m_lowGearVelocityScalar = RobotMap.DRIVE_DEFAULT_INPUT_SCALAR;
    private double m_lowGearTurnScalar = RobotMap.DRIVE_DEFAULT_INPUT_SCALAR;
    private NetworkTableEntry m_highGearVelocityScalarEntry;
    private NetworkTableEntry m_highGearTurnScalarEntry;
    private NetworkTableEntry m_lowGearVelocityScalarEntry;
    private NetworkTableEntry m_lowGearTurnScalarEntry;
    private ShuffleboardTab m_driverTab;
 
    //these variables allow us to reduce the amount of logic on every cycle
    //we set this value everytime we switch gears
    private double m_currentVelocityScalar = RobotMap.DRIVE_DEFAULT_INPUT_SCALAR;
    private double m_currentTurnScalar = RobotMap.DRIVE_DEFAULT_INPUT_SCALAR;
 
    /**
     * Creates an object to allow the pilot to control the drivetrain
     * 
     * @param controller The pilot controller to control the drive train with
     * @param drivetrain The robot drivetrain
     * @param driveType The type of drive control that the pilot wants (tank or arcade)
     */
    public PilotController(XboxController controller, Drivetrain drivetrain, DriveType driveType) {
        m_controller = controller;
        m_drivetrain = drivetrain;
        m_driveType = driveType;
 
        //puts input scalar widgets on the shuffleboard
        shuffleboardConfig();
    }
 
     /**
     * Creates an object to allow the pilot to control the drivetrain
     * <p>this constructor instantiates its own xbox controller, drivetrain, and targeting object
     * 
     * @param driveType The type of drive control that the pilot wants (tank or arcade)
     */
    public PilotController(DriveType driveType) {
        m_drivetrain = new Drivetrain();
        m_driveType = driveType;
 
        //instantiate xbox controller for controlling the drivetrain
        m_controller = new XboxController(RobotMap.DRIVE_CONTROLLER_PORT);
 
        //puts input scalar widgets on the shuffleboard
        shuffleboardConfig();
    }
 
     /**
     * Refreshes input scalars based on input from shuffleboard
     * <p> The driver input is multiplied by input scalars in order to reduce the speed of the system.
     *     This should be called only while disabled to prevent constant changing of settings mid match
     */
    public void setInputScalar() {
        m_highGearVelocityScalar = m_highGearVelocityScalarEntry.getDouble(RobotMap.DRIVE_DEFAULT_INPUT_SCALAR);
        m_highGearTurnScalar = m_highGearTurnScalarEntry.getDouble(RobotMap.DRIVE_DEFAULT_INPUT_SCALAR);
        m_lowGearVelocityScalar = m_lowGearVelocityScalarEntry.getDouble(RobotMap.DRIVE_DEFAULT_INPUT_SCALAR);
        m_lowGearTurnScalar = m_lowGearTurnScalarEntry.getDouble(RobotMap.DRIVE_DEFAULT_INPUT_SCALAR);
    }
 
     /**
     * Controls our drivetrain with an arcade control system
     * Triggers are forward and back (left trigger is back, right is forward), left stick horizontal is turn
     */
    private void arcadeDrive() {
        //read our current velocity by subtracting left trigger input from right, and turn by reading the x value from left stick
        double velocityInput = (m_controller.getTriggerAxis(Hand.kRight) - m_controller.getTriggerAxis(Hand.kLeft));
        double turnInput =  m_controller.getX(Hand.kLeft);
 
        //adjust our input based on our deadband
        turnInput = adjustForDeadband(turnInput);

        //halfs speed when A button is held
        if(m_controller.getAButton()){
            //multiplies our input by our current scalar
            //commented out squared inputs per previous pilot's request, may still change to current pilot's preference
            velocityInput *= 0.1;// * Math.abs(velocityInput);
            turnInput *= 0.1;// * Math.abs(turnInput);
        }
        else{
            //multiplies our input by our current scalar
            //commented out squared inputs per previous pilot's request, may still change to current pilot's preference
            velocityInput *= m_currentVelocityScalar;// * Math.abs(velocityInput);
            turnInput *= m_currentTurnScalar;// * Math.abs(turnInput);
        }
 
        //run our drivetrain with the adjusted input
        m_drivetrain.arcadeDrive(velocityInput, turnInput);
    }
 
    /**
     * Sets us to high gear on x button input and low gear on y button input
     */
    private void controlGear() {
        if (m_controller.getXButtonPressed()) {
            //set the actual drive gear on the drivetrain to high gear
            m_drivetrain.shiftGear(Gear.kHighGear);
 
            //sets our current scalar to the one used in high gear
            m_currentVelocityScalar = m_highGearVelocityScalar;
            m_currentTurnScalar = m_highGearTurnScalar;
        }
        else if (m_controller.getYButtonPressed()) {
            //set the actual drive gear on the drivetrain to low gear
            m_drivetrain.shiftGear(Gear.kLowGear);
 
            //sets our current scalar to the one used in low gear
            m_currentVelocityScalar = m_lowGearVelocityScalar;
            m_currentTurnScalar = m_lowGearTurnScalar;
        }
    }
 
    /**
     * Controls all pilot controlled systems
     */
    public void controlDriveTrainPeriodic() {
        //runs our drivetrain based on control scheme passed in
        if (m_driveType == DriveType.kArcade) {
            arcadeDrive();
        }
 
        //Controls shifting the gears off of the x and y buttons
        controlGear();
    }
 
    /**
     * @return The drivetrain controlled by the pilot controller
     */
    public Drivetrain getDrivetrain() {
        return m_drivetrain;
    }
 
    /**
     * @return the pilot xbox controller
     */
    public XboxController getController() {
        return m_controller;
    }
 
    /**
     * @return the current control system
     * @see frc.robot.PilotController.DriveType DriveType
     */
    public DriveType getDriveType() {
        return m_driveType;
    }
 
    /**
     * Take in input from a stick with drift, remove the drift and then scale the input to remove a jump in velocity due to deadbands
     * @param stickInput The direct input from the joystick
     * @return the adjusted value for the deadband
     */
    public double adjustForDeadband(double stickInput) {
        //grab the absolute value of the stick input to reduce comparisons
        double absoluteStickInput = Math.abs(stickInput);
 
        //if our absolute stick input is within our deadband, we set it equal to zero and early exit
        if (absoluteStickInput < RobotMap.PILOT_CONTROLLER_STICK_DEADBAND) {
            return 0;
        }
        //otherwise, if we're outside of the deadband:
        else {
            //reduce the input of the stick by the deadband to center the output on zero to prevent jumps
            absoluteStickInput -= RobotMap.PILOT_CONTROLLER_STICK_DEADBAND;
 
            //then we assign the original sign to the modified input
            stickInput = Math.copySign(absoluteStickInput, stickInput);
 
            //then we output the stick input scaled to cover the whole range of values from 0 to 1
            return stickInput / (1.0 - RobotMap.PILOT_CONTROLLER_STICK_DEADBAND);
        }
    }
 
    /**
     * instantiates all of our network table entries and displays them under the Driver tab
     * <p>the point of this method is to move the shuffleboard code out of init/constructor
     */
    public void shuffleboardConfig() {
        //Put drive control scalars onto the shuffleboard for editing mid drive
        m_driverTab = Shuffleboard.getTab("Driver Tab");
        m_highGearVelocityScalarEntry = m_driverTab.addPersistent("High Gear Speed Scalar", RobotMap.DRIVE_DEFAULT_INPUT_SCALAR)
                                        .withWidget(BuiltInWidgets.kTextView)
                                        .getEntry();
 
        m_highGearTurnScalarEntry = m_driverTab.addPersistent("High Gear Turn Scalar", RobotMap.DRIVE_DEFAULT_INPUT_SCALAR)
                                        .withWidget(BuiltInWidgets.kTextView)
                                        .getEntry();
 
        m_lowGearVelocityScalarEntry = m_driverTab.addPersistent("Low Gear Speed Scalar", RobotMap.DRIVE_DEFAULT_INPUT_SCALAR)
                                        .withWidget(BuiltInWidgets.kTextView)
                                        .getEntry();
 
        m_lowGearTurnScalarEntry = m_driverTab.addPersistent("Low Gear Turn Scalar", RobotMap.DRIVE_DEFAULT_INPUT_SCALAR)
                                        .withWidget(BuiltInWidgets.kTextView)
                                        .getEntry();
    }
}