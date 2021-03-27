package frc.robot;

import com.ctre.phoenix.motorcontrol.NeutralMode;

import frc.robot.Drivetrain.Gear;

public class Auton{

    /**
     * Enum used to set the path to be used during periodic
     */
    public enum AutonType{
        /**
         * Auton used for the Barrel path
         */
        kBarrel,

        /**
         * Auton used for the Slalom path
         */
        kSlalom,

        /**
         * Auton used for the Bounce path
         */
        kBounce;
    }
    
    /**
     * Enum used to set the different steps of our robot during auton
     */
    public enum AutonStep{

        kStep1,

        kStep2,

        kStep3,

        kStep4,

        kStep5,

        kStep6,

        kStep7,

        kStep8,

        kStep9,

        kStep10,

        kStep11,

        kStep12,

        kStep13,

        kStep14,

        kStep15,

        kStep16,

        kStep17,

        kStep18,

        kStep19,

        kStep20,

        kStep21,

        kStep22,

        kStep23,

        kStop;
    }

    private AutonType m_type;

    private AutonStep m_step;

    private Drivetrain m_drivetrain;

    /**
     * Constructor for auton objects
     * @param drivetrain
     */
    public Auton(Drivetrain drivetrain){
        m_drivetrain = drivetrain;
        m_type = AutonType.kBarrel;
        m_step = AutonStep.kStep1;
    }

    /**
     * This will be the first thing that is run when entering Auton
     * This will reset everything to initial values
     */
    public void init(){
        m_drivetrain.zeroEncoders();
        m_drivetrain.zeroGyro();
        m_drivetrain.setNeutralMode(NeutralMode.Brake);
        m_drivetrain.shiftGear(Gear.kLowGear);
        m_type = AutonType.kBounce;
        m_step = AutonStep.kStep1;
    }

    /**
     * This method is to run throughout autonomous mode 
     */
    public void periodic(){
      System.out.println("entered periodic");
      System.out.println("AutonPath: " + m_type + " | AutonStep: " + m_step);
        // Auton used for Barrel Path
        if(m_type == AutonType.kBarrel){
            System.out.println("entered pathing");

            //Drives forward for 120 inches
            if(m_step == AutonStep.kStep1){

                if(driveToTarget(RobotMap.FORWARD_DRIVE_SPEED, 120)){
                   m_step = AutonStep.kStep2;
                }

                else{
                    return;
                }
            }

            //Rotates Clockwise 45 degrees
            else if(m_step == AutonStep.kStep2){
                
                if(turnToAngle(RobotMap.CLOCKWISE_SPEED, 55)){
                    m_step = AutonStep.kStep3;
                }

                else{
                    return;
                }
            }

            //Drives forward for 40 inches
            else if(m_step == AutonStep.kStep3){

                if(driveToTarget(RobotMap.FORWARD_DRIVE_SPEED, 40)){
                    m_step = AutonStep.kStep4;
                }

                else{
                    return;
                }
            }

            //Rotates Clockwise 45 degrees
            else if(m_step == AutonStep.kStep4){

                if(turnToAngle(RobotMap.CLOCKWISE_SPEED, 45)){
                    m_step = AutonStep.kStep5;
                }

                else{
                    return;
                }
            }

            //Drives forward for 40 inches
            else if(m_step == AutonStep.kStep5){

                if(driveToTarget(RobotMap.FORWARD_DRIVE_SPEED, 40)){
                    m_step = AutonStep.kStep6;
                }

                else{
                    return;
                }
            }

            //Rotates Clockwise 45 degrees
            else if(m_step == AutonStep.kStep6){

                if(turnToAngle(RobotMap.CLOCKWISE_SPEED, 45)){
                    m_step = AutonStep.kStep7;
                }

                else{
                    return;
                }
            }

            //Drives forward for 40 inches
            else if(m_step == AutonStep.kStep7){

                if(driveToTarget(RobotMap.FORWARD_DRIVE_SPEED, 25)){
                    m_step = AutonStep.kStep8;
                }

                else{
                    return;
                }
            }

            //Rotates Clockwise 50 degrees
            else if(m_step == AutonStep.kStep8){

                if(turnToAngle(RobotMap.CLOCKWISE_SPEED, 30)){
                    m_step = AutonStep.kStep9;
                }

                else{
                    return;
                }
            }

            //Drives forward for 160 inches
            else if(m_step == AutonStep.kStep9){

                if(driveToTarget(RobotMap.FORWARD_DRIVE_SPEED, 125)){
                    m_step = AutonStep.kStep10;
                }

                else{
                    return;
                }
            }

            //Rotates Counter Clockwise 95 degrees
            else if(m_step == AutonStep.kStep10){

                if(turnToAngle(RobotMap.COUNTER_CLOCKWISE_SPEED, 50)){
                    m_step = AutonStep.kStep11;
                }

                else{
                    return;
                }
            }
                
            //Drives forward for 40 inches
            else if(m_step == AutonStep.kStep11){

                if(driveToTarget(RobotMap.FORWARD_DRIVE_SPEED, 40)){
                    m_step = AutonStep.kStep12;
                }
    
                    else{
                        return;
                    }
                }

            //Rotates Counter Clockwise 45 degrees
            else if(m_step == AutonStep.kStep12){
    
                if(turnToAngle(RobotMap.COUNTER_CLOCKWISE_SPEED, 20)){                        
                    m_step = AutonStep.kStep13;
                }
    
                else{
                    return;
                }
            }        
        
            //Drives forward for 40 inches
            else if(m_step == AutonStep.kStep13){

                if(driveToTarget(RobotMap.FORWARD_DRIVE_SPEED, 45)){
                    m_step = AutonStep.kStep14;
                }
    
                else{
                    return;
                }
            }
    
            //Rotates Counter Clockwise 60 degrees
            else if(m_step == AutonStep.kStep14){
    
                if(turnToAngle(RobotMap.COUNTER_CLOCKWISE_SPEED, 75)){
                    m_step = AutonStep.kStep15;
                }

                else{
                    return;
                }
            }
    
            //Drives forward for 130 inches
            else if(m_step == AutonStep.kStep15){

                if(driveToTarget(RobotMap.FORWARD_DRIVE_SPEED, 110)){
                    m_step = AutonStep.kStep16;
                }
    
                else{
                    return;
                }
            }
    
            //Rotates Counter Clockwise 75 degrees
            else if(m_step == AutonStep.kStep16){
    
                if(turnToAngle(RobotMap.COUNTER_CLOCKWISE_SPEED, 25)){
                    m_step = AutonStep.kStep17;
                }

                else{
                    return;
                }
            }
            
            //Drives forward for 40 inches
            else if(m_step == AutonStep.kStep17){

                if(driveToTarget(RobotMap.FORWARD_DRIVE_SPEED, 60)){
                    m_step = AutonStep.kStep18;
                }
    
                else{
                    return;
                }
            }
    
            //Rotates Counter Clockwise 45 degrees
            else if(m_step == AutonStep.kStep18){
    
                if(turnToAngle(RobotMap.COUNTER_CLOCKWISE_SPEED, 15)){
                    m_step = AutonStep.kStep19;
                }

                else{
                    return;
                }
            }
        
            //Drives forward for 40 inches
            else if(m_step == AutonStep.kStep19){

                if(driveToTarget(RobotMap.FORWARD_DRIVE_SPEED, 35)){
                    m_step = AutonStep.kStep20;
                }
    
                else{
                    return;
                }
            }
    
            //Rotates Counter Clockwise 20 degrees
            else if(m_step == AutonStep.kStep20){
    
                if(turnToAngle(RobotMap.COUNTER_CLOCKWISE_SPEED, 40)){
                    m_step = AutonStep.kStep21;
                }

                else{
                    return;
                }
            }
        
            //Drives forward for 270 inches
            else if(m_step == AutonStep.kStep21){

                if(driveToTarget(RobotMap.FORWARD_DRIVE_SPEED, 20)){
                    m_step = AutonStep.kStep22;
                }
    
                else{
                    return;
                }
            }

            //Rotates Counter Clockwise 20 degrees
            else if(m_step == AutonStep.kStep22){
    
                if(turnToAngle(RobotMap.COUNTER_CLOCKWISE_SPEED, 10)){
                    m_step = AutonStep.kStep23;
                }

                else{
                    return;
                }
            }
        
            //Drives forward for 270 inches
            else if(m_step == AutonStep.kStep23){

                if(driveToTarget(RobotMap.FORWARD_DRIVE_SPEED, 215)){
                    m_step = AutonStep.kStop;
                }
    
                else{
                    return;
                }
            }

            //Stops all Robot movement
            else if(m_step == AutonStep.kStop){
                m_drivetrain.arcadeDrive(0, 0);
            }

        }

        // Auton used for Slalom path
        else if(m_type == AutonType.kSlalom){

            //Drives forward for 30 inches
            if(m_step == AutonStep.kStep1){

                if(driveToTarget(RobotMap.FORWARD_DRIVE_SPEED, 30)){
                    m_step = AutonStep.kStep2;
                }

                else{
                    return;
                }
            }

            //Rotates Counter Clockwise 45 degrees
            else if(m_step == AutonStep.kStep2){

                if(turnToAngle(RobotMap.COUNTER_CLOCKWISE_SPEED, 45)){
                    m_step = AutonStep.kStep3;
                }

                else{
                    return;
                }
            }

            //Drives forward for 40 inches
            else if(m_step == AutonStep.kStep3){

                if(driveToTarget(RobotMap.FORWARD_DRIVE_SPEED, 41)){
                    m_step = AutonStep.kStep4;
                }

                else{
                    return;
                }
            }

            //Rotates Clockwise 45 degrees
            else if(m_step == AutonStep.kStep4){

                if(turnToAngle(RobotMap.CLOCKWISE_SPEED, 30)){
                    m_step = AutonStep.kStep5;
                }

                else{
                    return;
                }
            }

            //Drives forward for 120 inches
            else if(m_step == AutonStep.kStep5){

                if(driveToTarget(RobotMap.FORWARD_DRIVE_SPEED, 142)){
                    m_step = AutonStep.kStep6;
                }

                else{
                    return;
                }
            }

            //Rotates Clockwise 45 degrees
            else if(m_step == AutonStep.kStep6){

                if(turnToAngle(RobotMap.CLOCKWISE_SPEED, 45)){
                    m_step = AutonStep.kStep7;
                }

                else{
                    return;
                }
            }

            //Drives forward for 90 inches
            else if(m_step == AutonStep.kStep7){

                if(driveToTarget(RobotMap.FORWARD_DRIVE_SPEED, 40)){
                    m_step = AutonStep.kStep8;
                }

                else{
                    return;
                }
            }

            //Rotates Counter Clockwise 90 degrees
            else if(m_step == AutonStep.kStep8){

                if(turnToAngle(RobotMap.COUNTER_CLOCKWISE_SPEED, 45)){
                    m_step = AutonStep.kStep9;
                }

                else{
                    return;
                }
            }

            //Drives forward for 40 inches
            else if(m_step == AutonStep.kStep9){

                if(driveToTarget(RobotMap.FORWARD_DRIVE_SPEED, 40)){
                    m_step = AutonStep.kStep10;
                }

                else{
                    return;
                }
            }

            //Rotates Counter Clockwise 45 degrees
            else if(m_step == AutonStep.kStep10){

                if(turnToAngle(RobotMap.COUNTER_CLOCKWISE_SPEED, 45)){
                    m_step = AutonStep.kStep11;
                }

                else{
                    return;
                }
            }
                
            //Drives forward for 40 inches
            else if(m_step == AutonStep.kStep11){

                if(driveToTarget(RobotMap.FORWARD_DRIVE_SPEED, 45)){
                    m_step = AutonStep.kStep12;
                }
    
                    else{
                        return;
                    }
                }
            
            //Rotates Counter Clockwise 90 degrees
            else if(m_step == AutonStep.kStep12){
    
                if(turnToAngle(RobotMap.COUNTER_CLOCKWISE_SPEED, 45)){                        
                    m_step = AutonStep.kStep13;
                }
    
                else{
                    return;
                }
            }        
        
            //Drives forward for 70 inches
            else if(m_step == AutonStep.kStep13){

                if(driveToTarget(RobotMap.FORWARD_DRIVE_SPEED, 50)){
                    m_step = AutonStep.kStep14;
                }
    
                else{
                    return;
                }
            }
    
            //Rotates Clockwise 45 degrees
            else if(m_step == AutonStep.kStep14){
    
                if(turnToAngle(RobotMap.COUNTER_CLOCKWISE_SPEED, 45)){
                    m_step = AutonStep.kStep15;
                }

                else{
                    return;
                }
            }
    
            //Drives forward for 120 inches
            else if(m_step == AutonStep.kStep15){

                if(driveToTarget(RobotMap.FORWARD_DRIVE_SPEED, 50)){
                    m_step = AutonStep.kStep16;
                }
    
                else{
                    return;
                }
            }

                //Rotates Clockwise 45 degrees
            else if(m_step == AutonStep.kStep16){
    
                if(turnToAngle(RobotMap.CLOCKWISE_SPEED, 41)){
                    m_step = AutonStep.kStep17;
                }

                else{
                    return;
                }
            }
            
            //Drives forward for 70 inches
            else if(m_step == AutonStep.kStep17){

                if(driveToTarget(RobotMap.FORWARD_DRIVE_SPEED, 150)){
                    m_step = AutonStep.kStep18;
                }
    
                else{
                    return;
                }
            }

            //Rotates Clockwise 45 degrees
            else if(m_step == AutonStep.kStep18){
    
                if(turnToAngle(RobotMap.CLOCKWISE_SPEED, 48)){
                    m_step = AutonStep.kStep19;
                }

                else{
                    return;
                }
            }
            
            //Drives forward for 70 inches
            else if(m_step == AutonStep.kStep19){

                if(driveToTarget(RobotMap.FORWARD_DRIVE_SPEED, 50)){
                    m_step = AutonStep.kStep20;
                }
    
                else{
                    return;
                }
            }    
    
                //Rotates Clockwise 45 degrees
            else if(m_step == AutonStep.kStep20){
    
                if(turnToAngle(RobotMap.COUNTER_CLOCKWISE_SPEED, 45)){
                    m_step = AutonStep.kStep21;
                }

                else{
                    return;
                }
            }
            
            //Drives forward for 70 inches
            else if(m_step == AutonStep.kStep21){

                if(driveToTarget(RobotMap.FORWARD_DRIVE_SPEED, 10)){
                    m_step = AutonStep.kStop;
                }
    
                else{
                    return;
                }
            }
            //Stops all Robot movement
            else if(m_step == AutonStep.kStop){
                m_drivetrain.arcadeDrive(0, 0);
            }

        }

        // Auton used for Bounce
        else if (m_type == AutonType.kBounce){

            //Drives forward for 70 inches
            if(m_step == AutonStep.kStep1){

                if(driveToTarget(RobotMap.FORWARD_DRIVE_SPEED, 35)){
                    m_step = AutonStep.kStep2;
                }

                else{
                    return;
                }
            }

            //Rotates Counter Clockwise 30 degrees
            else if(m_step == AutonStep.kStep2){

                if(turnToAngle(RobotMap.COUNTER_CLOCKWISE_SPEED, 40)){
                    m_step = AutonStep.kStep3;
                }

                else{
                    return;
                }
            }

            //Drives backwards for 130 inches
            else if(m_step == AutonStep.kStep3){

                if(driveToTarget(RobotMap.FORWARD_DRIVE_SPEED, 30)){
                    m_step = AutonStep.kStep4;
                }

                else{
                    return;
                }
            }

            //Rotates Counter Clockwise 60 degrees
            else if(m_step == AutonStep.kStep4){

                if(driveToTarget(RobotMap.BACKWARD_DRIVE_SPEED, 19)){
                    m_step = AutonStep.kStep5;
                }

                else{
                    return;
                }
            }

            //Drives backwards for 120 inches
            else if(m_step == AutonStep.kStep5){

                if(turnToAngle(RobotMap.COUNTER_CLOCKWISE_SPEED, 10)){
                    m_step = AutonStep.kStep6;
                }

                else{
                    return;
                }
            }
        
            //Rotates Counter Clockwise 70 degrees
            else if(m_step == AutonStep.kStep6){

                if(driveToTarget(RobotMap.BACKWARD_DRIVE_SPEED, 105)){
                    m_step = AutonStep.kStep7;
                }

                else{
                    return;
                }
            }

            //Drives forward for 120 inches
            else if(m_step == AutonStep.kStep7){

                if(turnToAngle(RobotMap.CLOCKWISE_SPEED, 7)){
                    m_step = AutonStep.kStep8;
                }

                else{
                    return;
                }
            }

            //Drives forward for 120 inches
            else if(m_step == AutonStep.kStep8){

                if(driveToTarget(RobotMap.FORWARD_DRIVE_SPEED, 20)){
                    m_step = AutonStep.kStep9;
                }

                else{
                    return;
                }
            }

            //Drives forward for 120 inches
            else if(m_step == AutonStep.kStep9){

                if(turnToAngle(RobotMap.CLOCKWISE_SPEED, 3)){
                    m_step = AutonStep.kStep10;
                }

                else{
                    return;
                }
            }

            //Rotates Counter Clockwise 40 degrees
            else if(m_step == AutonStep.kStep10){

                if(driveToTarget(RobotMap.FORWARD_DRIVE_SPEED, 100)){
                    m_step = AutonStep.kStep11;
                }

                else{
                    return;
                }
            }

            //Drives forward for 30 inches
            else if(m_step == AutonStep.kStep11){

                if(driveToTarget(RobotMap.BACKWARD_DRIVE_SPEED, 95)){
                    m_step = AutonStep.kStep12;
                }

                else{
                    return;
                }
            }

            //Rotates Counter Clockwise 70 degrees
            else if(m_step == AutonStep.kStep12){

                if(turnToAngle(RobotMap.CLOCKWISE_SPEED, 45)){
                    m_step = AutonStep.kStep13;
                }

                else{
                    return;
                }
            }
                
            //Drives forward for 120 inches
            else if(m_step == AutonStep.kStep13){

                if(driveToTarget(RobotMap.FORWARD_DRIVE_SPEED, 65)){
                    m_step = AutonStep.kStep14;
                }
    
                    else{
                        return;
                    }
                }
    
            //Rotates Counter Clockwise 50 degrees
            else if(m_step == AutonStep.kStep14){
    
                if(turnToAngle(RobotMap.COUNTER_CLOCKWISE_SPEED, 45)){                        
                    m_step = AutonStep.kStep15;
                }
    
                else{
                    return;
                }
            }        
        
            //Drives backwards for 90 inches
            else if(m_step == AutonStep.kStep15){

                if(driveToTarget(RobotMap.FORWARD_DRIVE_SPEED, 30)){
                    m_step = AutonStep.kStep16;
                }
    
                else{
                    return;
                }
            }

            //Drives backwards for 90 inches
            else if(m_step == AutonStep.kStep16){

                if(driveToTarget(RobotMap.BACKWARD_DRIVE_SPEED, 30)){
                    m_step = AutonStep.kStep17;
                }
    
                else{
                    return;
                }
            }

            //Drives backwards for 90 inches
            else if(m_step == AutonStep.kStep17){

                if(turnToAngle(RobotMap.COUNTER_CLOCKWISE_SPEED, 45)){
                    m_step = AutonStep.kStep18;
                }
    
                else{
                    return;
                }
            }

            //Drives backwards for 90 inches
            else if(m_step == AutonStep.kStep18){

                if(driveToTarget(RobotMap.BACKWARD_DRIVE_SPEED, 20)){
                    m_step = AutonStep.kStop;
                }
    
                else{
                    return;
                }
            }
    
            //Stops all Robot movement
            else if(m_step == AutonStep.kStop){
                m_drivetrain.arcadeDrive(0, 0);
            }

        }
            
    }

    /**
     * 
     * @param speed the speed the robot will travel at
     * @param target the target distance in inches
     * @return whether or not we have reached our target
     */
    public boolean driveToTarget(double speed, double target){
        double rightEncoder = m_drivetrain.getRightDriveEncoderPosition();
        double leftEncoder = m_drivetrain.getLeftDriveEncoderPosition();
        target = target * RobotMap.INCHES_TO_ENCODER_TICKS_LOWGEAR;
        System.out.println("EncoderTarget: " + target);
        System.out.println("Right Encoder Ticks: " + rightEncoder);
        System.out.println("Left Encoder Ticks: " + leftEncoder);
        System.out.println("RIGHT ENCODER POS: " + m_drivetrain.m_masterRightMotor.getSelectedSensorPosition());
        if(speed < 0){
            target = target * -1;
            if((target > 0) && (speed > 0)){

                if(leftEncoder < target || rightEncoder < target){
                    m_drivetrain.arcadeDrive(speed, 0);
                    return false;
                }
                else{
                    m_drivetrain.arcadeDrive(0, 0);
                    m_drivetrain.zeroEncoders();
                    m_drivetrain.zeroGyro();
                    return true;
                }
                
            }
    
            else if((target < 0) && (speed < 0)){
    
                if(leftEncoder > target || rightEncoder > target){
                    m_drivetrain.arcadeDrive(speed, 0);
                    return false;
                }
                else{
                    m_drivetrain.arcadeDrive(0, 0);
                    m_drivetrain.zeroEncoders();
                    m_drivetrain.zeroGyro();
                    return true;
                }
                
            }
    
            else{
                System.out.println("Robot will never reach target. Exiting Pathing");
                m_step = AutonStep.kStop;
                return false;
            }
            
        }
        else{
            if((target > 0) && (speed > 0)){

                if(leftEncoder < target || rightEncoder < target){
                    m_drivetrain.arcadeDrive(speed, 0);
                    return false;
                }
                else{
                    m_drivetrain.arcadeDrive(0, 0);
                    m_drivetrain.zeroEncoders();
                    m_drivetrain.zeroGyro();
                    return true;
                }
                
            }
    
            else if((target < 0) && (speed < 0)){
    
                if(leftEncoder > target || rightEncoder > target){
                    m_drivetrain.arcadeDrive(speed, 0);
                    return false;
                }
                else{
                    m_drivetrain.arcadeDrive(0, 0);
                    m_drivetrain.zeroEncoders();
                    m_drivetrain.zeroGyro();
                    return true;
                }
                
            }
    
            else{
                System.out.println("Robot will never reach target. Exiting Pathing");
                m_step = AutonStep.kStop;
                return false;
            }
            
        }
        
    }

    /**
     * 
     * @param speed The speed at which we want to turn
     * @param target The target angle in degrees we want to turn to
     * @return
     */
    public boolean turnToAngle(double speed, double target){
        double currentAngle = m_drivetrain.getGyro();

        if(speed < 0 ){
            target = target * -1;
            System.out.println("Target Angle: " + target);
            System.out.println("Current Angle: " + currentAngle);
            // if our angle is less than the upper bound (target angle times the rotate bound) and our angle is more than the lower bound  
            if(currentAngle < (target * (1 - RobotMap.ROTATE_BOUND))){
                m_drivetrain.arcadeDrive(0, 0);
                m_drivetrain.zeroGyro();
                System.out.println("Zero Gyro" + m_drivetrain.getGyro());
                m_drivetrain.zeroEncoders();
                System.out.println("At Target angle" + currentAngle);
                return true;
            }
            else{
                m_drivetrain.arcadeDrive(0, speed);
                System.out.println("Not at Target angle" + currentAngle);
                return false;
            }
        }
        else{
            System.out.println("Target Angle: " + target);
            System.out.println("Current Angle: " + currentAngle);
            // if our angle is less than the upper bound (target angle times the rotate bound) and our angle is more than the lower bound  
            if(currentAngle > (target * (1 - RobotMap.ROTATE_BOUND))){
                m_drivetrain.arcadeDrive(0, 0);
                m_drivetrain.zeroGyro();
                System.out.println("Zero Gyro" + m_drivetrain.getGyro());
                m_drivetrain.zeroEncoders();
                System.out.println("At Target angle" + currentAngle);
                return true;
            }
            else{
                m_drivetrain.arcadeDrive(0, speed);
                System.out.println("Not at Target angle" + currentAngle);
                return false;
            }
        }

    }
}