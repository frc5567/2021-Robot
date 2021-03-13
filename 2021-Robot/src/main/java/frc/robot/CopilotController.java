package frc.robot;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import frc.robot.Drivetrain;
import frc.robot.Magazine;
import frc.robot.Drivetrain.Gear;
import frc.robot.GamePad;
import frc.robot.Intake;
import frc.robot.Intake.Position;

/**
 * A class to control the Intake, Launcher, and Magazine using the copilot controller
 * @author Caleb Overbeek
 * @version 3/2/2021
 */
public class CopilotController{
    public enum TargetingStage {
        kRevAndTarget, kRevToVelocity, kRunMagazine
    }

    //declare drivetrain
    private Drivetrain m_drivetrain;

    //declare Targeting enum to keep track of current targeting state
    private TargetingStage m_targetingStage = TargetingStage.kRevAndTarget;

    //Declares the gamePad for the use of the buttons from the GamePad class
    private GamePad m_gamePad;

    //Declares the Intake to use the positioning and setting motor speeds that are created in that class
    private Intake m_intake;

    //Declares the launcher to set the speed of the motors on the launcher
    private Launcher m_launcher;
    
    // Declares the magazine to index the balls into the launcher, backwards to unclog the balls, and back to the intake to dump the balls
    private Magazine m_magazine;

    // Declare the Drivetrain
    private Drivetrain m_drivetrain;

    /**
     * Creates the objects to allow the copilot controller/gamepad to control the intake, launcher,
     *  and shifting Gears
     * <p> We pass in the drivetrain to keep the same object as used in the PilotController.
     * All other objects are instantiated here for encapsulation
     * @param driveTrain the robot drivetrain
     */
    public CopilotController(Drivetrain drivetrain){
        m_gamePad = new GamePad(RobotMap.GAMEPAD_PORT);
        m_intake = new Intake();
        m_launcher = new Launcher();
        m_magazine = new Magazine();

        m_drivetrain = drivetrain;
    }

    /**
     * This method should be called periodically in Teleop in order to control all systems
     */
    public void periodicCopilotControl() {
        controlIntake();
        controlMagazineAndLauncher();
    }

    /**
     * Controls the launcher and magazine at the same time using one button to set the magazine speed to 0.37 moving the balls toward the launcher,
     * and it gets the launcher up to speed
     */
    public void controlMagazineAndLauncher(){
        //When we first start targeting, grab control of drivetrain and reset target
        if (m_gamePad.getLauncherAndMagazinePressed()) {
            //lock the drivetrain only on rising edge
            PilotController.is_currently_targeting = true;

            //set our stage to the first one
            m_targetingStage = TargetingStage.kRevAndTarget;

            m_drivetrain.arcadeDrive(0, 0);

            m_drivetrain.shiftGear(Gear.kLowGear);
        }
        //while the button is held, run the targeting and launching sequence
        else if(m_gamePad.getLauncherAndMagazine()) {
            //if we are in the first stage
            if (m_targetingStage == TargetingStage.kRevAndTarget) {
                //sets the launcher to the holding speed
                m_launcher.setSpeed(RobotMap.LAUNCHER_HOLDING_SPEED);

            }
            //revs the launcher up to launch speed
            else if (m_targetingStage == TargetingStage.kRevToVelocity) {

                //assigns the targetVelocity
                //ideally this would be a function of distance to target, currently it is set from testing
                double targetVelocity = 4800; //TODO: Grab launch speed as a function of distance

                //set the velocity to a launch speed
                m_launcher.setVelocity(targetVelocity *RobotMap.RPM_TO_UNITS_PER_100MS);

                //if we are at speed. exit out
                if (m_launcher.getEncoderVelocity() > targetVelocity * RobotMap.RPM_TO_UNITS_PER_100MS) {
                    m_targetingStage = TargetingStage.kRunMagazine;
                }
            }
            //drives the magazine for launching
            else if (m_targetingStage == TargetingStage.kRunMagazine) {
                //zero drivetrain
                m_drivetrain.arcadeDrive(0, 0);

                //run our magazine to launch balls
                m_magazine.RunMagazine(RobotMap.MAGAZINE_LAUNCH_SPEED);
            }
        }
        //zero all motors on release and return drive control
        else if (m_gamePad.getLauncherAndMagazineReleased()) {
            m_launcher.setSpeed(0);
            m_magazine.RunMagazine(0);
            m_drivetrain.arcadeDrive(0, 0);
            PilotController.is_currently_targeting = false;
        }
        else if(m_gamePad.getRevLauncherPressed()) {
            m_launcher.setSpeed(RobotMap.LAUNCHER_HOLDING_SPEED);
            m_drivetrain.shiftGear(Gear.kLowGear);
        }
        else if(m_gamePad.getRevLauncherReleased()) {
            m_launcher.setSpeed(0);
        }
        else if(m_gamePad.getMoveMagazine()){
            m_magazine.RunMagazine(RobotMap.MAGAZINE_LAUNCH_SPEED);
        } 
        //When the getMoveMagazineDown button is pushed, the magazine moves the balls back towars the intake at a speed of -0.37
        else if(m_gamePad.getMoveMagazineDown()){
            m_magazine.RunMagazine(-RobotMap.MAGAZINE_LAUNCH_SPEED);
        } 
        //When the getDumpAllBalls buton is pressed, the magazine moves backwards and 
        //the intake then pushes the balls out of the intake 
        //This doesn't work with chinese finger trap
        else if(m_gamePad.getDumpAllBalls()){
            m_magazine.RunMagazine(RobotMap.MAGAZINE_DUMP_SPEED);
        } 
        else {
            //Stops the magazine and zeros the launcher speed
            m_magazine.RunMagazine(0);
        }
    }

    /**
     * Turns on the Intake to take in the balls and turns the intake off to stop the intake of balls
     */
    public void controlIntake(){
        if (m_gamePad.getDumpAllBalls()) {
            m_intake.setInnerIntakeMotor(-RobotMap.INNER_INTAKE_SPEED);
            m_intake.setOuterIntakeMotor(-RobotMap.OUTER_INTAKE_SPEED);
            m_intake.setPosition(Position.kRaised);
            return;
        }

        //If the button is pressed on the gamePad, the intake is enabled for the drop bar to lower and the motors to run to take in the balls
        if(m_gamePad.getIntakePressed()){
            //moves the arm to the target position (it would move the position to the target position of lowered)
            m_intake.setPosition(Position.kLowered);
        }

        if (m_intake.m_position == Position.kLowered) {
            //Sets the motor speeds for the inner and outer motors to bring the balls in
            m_intake.setOuterIntakeMotor(RobotMap.OUTER_INTAKE_SPEED);
        }
        else {
            //sets the inner and outer motor speed to 0 to stop the intake of the balls
            m_intake.setInnerIntakeMotor(0);
            m_intake.setOuterIntakeMotor(0);
        }

        //If the B button is pressed, the intake is disabled to raise the drop bar and stop the motors
        if(m_gamePad.getDisableIntakePressed()){
            //sets the position to the new target position of raised
            m_intake.setPosition(Position.kRaised);
        }
    }

    /**
     * @return the magazine
     */
    public Magazine getMagazine() {
        return m_magazine;
    }

    /**
     * @return the launcher
     */
    public Launcher getLauncher() {
        return m_launcher;
    }

    /**
     * @return the intake
     */
    public Intake getIntake() {
        return m_intake;
    }
}