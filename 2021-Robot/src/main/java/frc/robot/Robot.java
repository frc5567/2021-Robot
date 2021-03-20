// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix.motorcontrol.NeutralMode;

import edu.wpi.first.wpilibj.TimedRobot;
import frc.robot.PilotController.DriveType;


import com.ctre.phoenix.motorcontrol.ControlMode;
/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {

  //Declares controller and drivetrain for testing drive code
  /** The class that we wrote to read values from the controller and control the drivetrain */
  private PilotController m_pilotController;

  /** The copilot class for controlling all other systems on the robot */
  private CopilotController m_copilotController;

  /** The auton class that runs our auton */
  private Auton m_auton;

  private Magazine m_magazine;
  private Launcher m_launcher;
  //Declare our limelight reader object
  //LimelightReader m_limelightReader;

  // //Declare private variables for creating a camera tab, and putting up variables to test for angles and distance
  // //This tab is exclusively for testing, but could still be moved into limelight targeting test mode
  // private ShuffleboardTab m_cameraTab;
  // private NetworkTableEntry m_cameraHeight;
  // private NetworkTableEntry m_cameraAngle;
  // private NetworkTableEntry m_targetHeight;
  // private NetworkTableEntry m_distance;


  public Robot(){
   // m_limelightReader = new LimelightReader();
    //instantiates our PilotController, which controls all systems on the drivetrain
    m_pilotController = new PilotController(DriveType.kArcade);

    //instantiates our copilotController, which controls the other systems of our robot
    m_copilotController = new CopilotController(m_pilotController.getDrivetrain());

    //instantiates the auton
    m_auton = new Auton(m_pilotController.getDrivetrain());

    //Sets up our camera testing tab
    shuffleboardConfig();

  }


  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {

  }

  @Override
  public void robotPeriodic() {
    

  }

  @Override
  public void autonomousInit() {
    //runs the init part of our auton
    m_auton.init();
  
  }

  @Override
  public void autonomousPeriodic() {
    //Runs periodic auton code
    m_auton.periodic();
  }

  @Override
  public void teleopInit() {
    m_pilotController.getDrivetrain().setNeutralMode(NeutralMode.Brake);
  }

  @Override
  public void teleopPeriodic() {
    m_pilotController.controlDriveTrainPeriodic();
    m_copilotController.periodicCopilotControl();
    //m_launcher.m_farSlaveMotor2.setInverted(true);
  }

  /**
   * Prints out the y degrees to target and
   * calculates distance based on shuffleboard and limelight
   */
  public void periodicDistanceTuning(){

  }

  @Override
  public void disabledInit() {
    m_pilotController.getDrivetrain().setNeutralMode(NeutralMode.Coast);
  }

  @Override
  public void disabledPeriodic() {
    //this method pulls our input scalars off of the driver tab on shuffleboard
    //and sets them on our drivetrain class. Our driver input is multiplied by our scalar values
    //in order to scale back drivetrain speed.
    m_pilotController.setInputScalar();
    m_pilotController.getDrivetrain().setNeutralMode(NeutralMode.Coast);
  }

  @Override
  public void testInit() {

  }

  @Override
  public void testPeriodic() {

  }

  public void shuffleboardConfig(){

  }
}
