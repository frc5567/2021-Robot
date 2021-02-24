/**
 * Some of the class's inputs are received the Pilot Controller and Auton Code
 * This class will uses information from robotMap.
 */

package frc.robot;

/**
 * The drivetrain has four motors, and has two speeds for our robot
 */
public class Drivetrain {
    
    // TalonFX right motor
    // TalonFX left motor
    // TalonFX slave right motor
    // TalonFX slave left motor

    // Right Encoder
    // Left Encoder

    // Right Solenoid
    // Left Solenoid

    // enum for storing the possible gears that are used for the drivetrain


    /**
     * Constructor for instantiating drivetrain objects 
     */ 
    public Drivetrain(){
        // Instantiate TalonFX motors

        // Instantiate left and right pistons (solenoids)

        // Set gears initially to unknown, so gears can be switch to high or low at first

        // Configure the drivetrain
    }

    /**
     * This function sets the drive gear using the pistons to a value
     * It sets both the left and right solenoid to a value
     */
    private void setPistons(){

    }

    /**
     * This function allows the gears to be switched between high and low.
     * The function setPistons is used in this function
     */
    public void shiftGear(){

    }

    /**
     * This function set sthe motors into "arcade drive", which means the pilot controls the speed of the robot with the 
     * triggers and the direction of the robot with the x axis on the left joystick
     * @param velocityInput
     * @param turnInput
     */
    public void arcadeDrive(double velocityInput, double turnInput){

    }
    
    /**
     * This function sets the motors up to be used to drive like a tank. Meaning each side is contolled individually.
     * The slave motors will following the master motors that are on the same side of the robot
     * @param leftInput
     * @param rightInput
     */
    public void tankDrive(double leftInput, double rightInput){

    }
}
