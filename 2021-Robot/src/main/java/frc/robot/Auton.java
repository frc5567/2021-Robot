package frc.robot;

public class Auton{

    /**
     * Enum used to set the path to be used during periodic
     */
    public enum AutonType{
        /**
         * Auton used for the Barrel path
         */
        kBarrel(0),

        /**
         * Auton used for the Slalom path
         */
        kSlalom(1),

        /**
         * Auton used for the Bounce path
         */
        kBounce(2);
    }
    
    /**
     * Enum used to set the different steps of our robot during auton
     */
    public enum AutonStep{

        kStep1(0),

        kStep2(1),

        kStep3(2),

        kStep4(3),

        kStep5(4),

        kStep6(5),

        kStep7(6),

        kStep8(7),

        kStep9(8),

        kStep10(9),

        kStep11(10),

        kStep12(11),

        kStep13(12),

        kStep14(13),

        kStep15(14),

        kStep16(15),

        kStep17(16),

        kStep18(17),

        kStep19(18),

        kStep20(19),

        kStep21(20),

        kStop(21);
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
        m_type = AutonType.kBarrel;
        m_step = AutonStep.kStep1;
    }

    /**
     * This method is to run throughout autonomous mode 
     */
    public void periodic(){
      
        // Auton used for Barrel Path
        if(m_type = AutonType.kBarrel){

            //Drives forward for 120 inches
            if(m_step = AutonStep.kStep1){

                if(driveToTarget(speed, 120)){
                    m_step = AutonStep.kStep2;
                }

                else{
                    return;
                }
            }

            //Rotates Clockwise 45 degrees
            else if(m_step = AutonStep.kStep2){

                if(turnToAngle(speed, 45)){
                    m_step = AutonStep.kStep3;
                }

                else{
                    return;
                }
            }

            //Drives forward for 40 inches
            else if(m_step = AutonStep.kStep3){

                if(driveToTarget(speed, 40)){
                    m_step = AutonStep.kStep4;
                }

                else{
                    return;
                }
            }

            //Rotates Clockwise 45 degrees
            else if(m_step = AutonStep.kStep4){

                if(turnToAngle(speed, 45)){
                    m_step = AutonStep.kStep5;
                }

                else{
                    return;
                }
            }

            //Drives forward for 40 inches
            else if(m_step = AutonStep.kStep5){

                if(driveToTarget(speed, 40)){
                    m_step = AutonStep.kStep6;
                }

                else{
                    return;
                }
            }

            //Rotates Clockwise 45 degrees
            else if(m_step = AutonStep.kStep6){

                if(turnToAngle(speed, 45)){
                    m_step = AutonStep.kStep7;
                }

                else{
                    return;
                }
            }

            //Drives forward for 40 inches
            else if(m_step = AutonStep.kStep7){

                if(driveToTarget(speed, 40)){
                    m_step = AutonStep.kStep8;
                }

                else{
                    return;
                }
            }

            //Rotates Clockwise 50 degrees
            else if(m_step = AutonStep.kStep8){

                if(turnToAngle(speed, 50)){
                    m_step = AutonStep.kStep9;
                }

                else{
                    return;
                }
            }

            //Drives forward for 160 inches
            else if(m_step = AutonStep.kStep9){

                if(driveToTarget(speed, 160)){
                    m_step = AutonStep.kStep10;
                }

                else{
                    return;
                }
            }

            //Rotates Counter Clockwise 95 degrees
            else if(m_step = AutonStep.kStep10){

                if(turnToAngle(-speed, 95)){
                    m_step = AutonStep.kStep11;
                }

                else{
                    return;
                }
            }
                
            //Drives forward for 40 inches
            else if(m_step = AutonStep.kStep11){

                if(driveToTarget(speed, 40)){
                    m_step = AutonStep.kStep12;
                }
    
                    else{
                        return;
                    }
                }

            //Rotates Counter Clockwise 45 degrees
            else if(m_step = AutonStep.kStep12){
    
                if(turnToAngle(-speed, 45)){                        
                    m_step = AutonStep.kStep13;
                }
    
                else{
                    return;
                }
            }        
        
            //Drives forward for 40 inches
            else if(m_step = AutonStep.kStep13){

                if(driveToTarget(speed, 40)){
                    m_step = AutonStep.kStep14;
                }
    
                else{
                    return;
                }
            }
    
            //Rotates Counter Clockwise 60 degrees
            else if(m_step = AutonStep.kStep14){
    
                if(turnToAngle(-speed, 60)){
                    m_step = AutonStep.kStep15;
                }

                else{
                    return;
                }
            }
    
            //Drives forward for 130 inches
            else if(m_step = AutonStep.kStep15){

                if(driveToTarget(speed, 130)){
                    m_step = AutonStep.kStep16;
                }
    
                else{
                    return;
                }
            }
    
            //Rotates Counter Clockwise 75 degrees
            else if(m_step = AutonStep.kStep16){
    
                if(turnToAngle(-speed, 45)){
                    m_step = AutonStep.kStep17;
                }

                else{
                    return;
                }
            }
            
            //Drives forward for 40 inches
            else if(m_step = AutonStep.kStep17){

                if(driveToTarget(speed, 40)){
                    m_step = AutonStep.kStep18;
                }
    
                else{
                    return;
                }
            }
    
            //Rotates Counter Clockwise 45 degrees
            else if(m_step = AutonStep.kStep18){
    
                if(turnToAngle(-speed, 45)){
                    m_step = AutonStep.kStep19;
                }

                else{
                    return;
                }
            }
        
            //Drives forward for 40 inches
            else if(m_step = AutonStep.kStep19){

                if(driveToTarget(speed, 40)){
                    m_step = AutonStep.kStep20;
                }
    
                else{
                    return;
                }
            }
    
            //Rotates Counter Clockwise 20 degrees
            else if(m_step = AutonStep.kStep20){
    
                if(turnToAngle(-speed, 20)){
                    m_step = AutonStep.kStep21;
                }

                else{
                    return;
                }
            }
        
            //Drives forward for 270 inches
            else if(m_step = AutonStep.kStep21){

                if(driveToTarget(speed, 270)){
                    m_step = AutonStep.kStop;
                }
    
                else{
                    return;
                }
            }

            //Stops all Robot movement
            else if(m_step = AutonStep.kStop){
                m_drivetrain.arcadeDrive(0, 0);
            }

        }

        // Auton used for Slalom path
        else if(m_type = AutonType.kSlalom){

            //Drives forward for 30 inches
            if(m_step = AutonStep.kStep1){

                if(driveToTarget(speed, 30)){
                    m_step = AutonStep.kStep2;
                }

                else{
                    return;
                }
            }

            //Rotates Counter Clockwise 45 degrees
            else if(m_step = AutonStep.kStep2){

                if(turnToAngle(-speed, 45)){
                    m_step = AutonStep.kStep3;
                }

                else{
                    return;
                }
            }

            //Drives forward for 40 inches
            else if(m_step = AutonStep.kStep3){

                if(driveToTarget(speed, 40)){
                    m_step = AutonStep.kStep4;
                }

                else{
                    return;
                }
            }

            //Rotates Clockwise 45 degrees
            else if(m_step = AutonStep.kStep4){

                if(turnToAngle(speed, 45)){
                    m_step = AutonStep.kStep5;
                }

                else{
                    return;
                }
            }

            //Drives forward for 120 inches
            else if(m_step = AutonStep.kStep5){

                if(driveToTarget(speed, 120)){
                    m_step = AutonStep.kStep6;
                }

                else{
                    return;
                }
            }

            //Rotates Clockwise 45 degrees
            else if(m_step = AutonStep.kStep6){

                if(turnToAngle(speed, 45)){
                    m_step = AutonStep.kStep7;
                }

                else{
                    return;
                }
            }

            //Drives forward for 90 inches
            else if(m_step = AutonStep.kStep7){

                if(driveToTarget(speed, 90)){
                    m_step = AutonStep.kStep8;
                }

                else{
                    return;
                }
            }

            //Rotates Counter Clockwise 90 degrees
            else if(m_step = AutonStep.kStep8){

                if(turnToAngle(-speed, 90)){
                    m_step = AutonStep.kStep9;
                }

                else{
                    return;
                }
            }

            //Drives forward for 40 inches
            else if(m_step = AutonStep.kStep9){

                if(driveToTarget(speed, 40)){
                    m_step = AutonStep.kStep10;
                }

                else{
                    return;
                }
            }

            //Rotates Counter Clockwise 45 degrees
            else if(m_step = AutonStep.kStep10){

                if(turnToAngle(-speed, 45)){
                    m_step = AutonStep.kStep11;
                }

                else{
                    return;
                }
            }
                
            //Drives forward for 40 inches
            else if(m_step = AutonStep.kStep11){

                if(driveToTarget(speed, 40)){
                    m_step = AutonStep.kStep12;
                }
    
                    else{
                        return;
                    }
                }
            
            //Rotates Counter Clockwise 90 degrees
            else if(m_step = AutonStep.kStep12){
    
                if(turnToAngle(-speed, 90)){                        
                    m_step = AutonStep.kStep13;
                }
    
                else{
                    return;
                }
            }        
        
            //Drives forward for 70 inches
            else if(m_step = AutonStep.kStep13){

                if(driveToTarget(speed, 70)){
                    m_step = AutonStep.kStep14;
                }
    
                else{
                    return;
                }
            }
    
            //Rotates Clockwise 45 degrees
            else if(m_step = AutonStep.kStep14){
    
                if(turnToAngle(speed, 45)){
                    m_step = AutonStep.kStep15;
                }

                else{
                    return;
                }
            }
    
            //Drives forward for 120 inches
            else if(m_step = AutonStep.kStep15){

                if(driveToTarget(speed, 120)){
                    m_step = AutonStep.kStep16;
                }
    
                else{
                    return;
                }
            }
    
            //Rotates Clockwise 45 degrees
            else if(m_step = AutonStep.kStep16){
    
                if(turnToAngle(speed, 45)){
                    m_step = AutonStep.kStep17;
                }

                else{
                    return;
                }
            }
            
            //Drives forward for 70 inches
            else if(m_step = AutonStep.kStep17){

                if(driveToTarget(speed, 70)){
                    m_step = AutonStep.kStop;
                }
    
                else{
                    return;
                }
            }
    
            //Stops all Robot movement
            else if(m_step = AutonStep.kStop){
                m_drivetrain.arcadeDrive(0, 0);
            }

        }

        // Auton used for Bounce
        else if (m_type = AutonType.kBounce){

            //Drives forward for 70 inches
            if(m_step = AutonStep.kStep1){

                if(driveToTarget(speed, 70)){
                    m_step = AutonStep.kStep2;
                }

                else{
                    return;
                }
            }

            //Rotates Counter Clockwise 30 degrees
            else if(m_step = AutonStep.kStep2){

                if(turnToAngle(-speed, 30)){
                    m_step = AutonStep.kStep3;
                }

                else{
                    return;
                }
            }

            //Drives backwards for 130 inches
            else if(m_step = AutonStep.kStep3){

                if(driveToTarget(-speed, 130)){
                    m_step = AutonStep.kStep4;
                }

                else{
                    return;
                }
            }

            //Rotates Counter Clockwise 60 degrees
            else if(m_step = AutonStep.kStep4){

                if(turnToAngle(-speed, 60)){
                    m_step = AutonStep.kStep5;
                }

                else{
                    return;
                }
            }

            //Drives backwards for 120 inches
            else if(m_step = AutonStep.kStep5){

                if(driveToTarget(-speed, 120)){
                    m_step = AutonStep.kStep6;
                }

                else{
                    return;
                }
            }
        
            //Rotates Counter Clockwise 70 degrees
            else if(m_step = AutonStep.kStep6){

                if(turnToAngle(-speed, 70)){
                    m_step = AutonStep.kStep7;
                }

                else{
                    return;
                }
            }

            //Drives forward for 120 inches
            else if(m_step = AutonStep.kStep7){

                if(driveToTarget(speed, 120)){
                    m_step = AutonStep.kStep8;
                }

                else{
                    return;
                }
            }

            //Rotates Counter Clockwise 40 degrees
            else if(m_step = AutonStep.kStep8){

                if(turnToAngle(-speed, 40)){
                    m_step = AutonStep.kStep9;
                }

                else{
                    return;
                }
            }

            //Drives forward for 30 inches
            else if(m_step = AutonStep.kStep9){

                if(driveToTarget(speed, 30)){
                    m_step = AutonStep.kStep10;
                }

                else{
                    return;
                }
            }

            //Rotates Counter Clockwise 70 degrees
            else if(m_step = AutonStep.kStep10){

                if(turnToAngle(-speed, 70)){
                    m_step = AutonStep.kStep11;
                }

                else{
                    return;
                }
            }
                
            //Drives forward for 120 inches
            else if(m_step = AutonStep.kStep11){

                if(driveToTarget(speed, 120)){
                    m_step = AutonStep.kStep12;
                }
    
                    else{
                        return;
                    }
                }
    
            //Rotates Counter Clockwise 50 degrees
            else if(m_step = AutonStep.kStep12){
    
                if(turnToAngle(-speed, 50)){                        
                    m_step = AutonStep.kStep13;
                }
    
                else{
                    return;
                }
            }        
        
            //Drives backwards for 90 inches
            else if(m_step = AutonStep.kStep13){

                if(driveToTarget(-speed, 90)){
                    m_step = AutonStep.kStop;
                }
    
                else{
                    return;
                }
            }
    
            //Stops all Robot movement
            else if(m_step = AutonStep.kStop){
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
        
        target = target * RobotMap.INCHES_TO_ENCODER_TICKS;

        if(m_drivetrain.getLeftDriveEncoderPosition() < target || m_drivetrain.getRightDriveEncoderPosition() < target){
            m_drivetrain.arcadeDrive(speed, 0);
            return false;
        }
        else{
            m_drivetrain.arcadeDrive(0, 0);
            return true;
        }
        
    }

    /**
     * 
     * @param speed The speed at which we want to turn
     * @param target The target angle in degrees we want to turn to
     * @return
     */
    public boolean turnToAngle(double speed, double target){

        if((m_drivetrain.getGyro() != (target * 1.01)) || (m_drivetrain.getGyro() != (target * 0.99))){
            m_drivetrain.tankDrive(leftSpeed, -rightSpeed);;
            return false;
        }
        else{
            m_drivetrain.tankDrive(0, 0);
            return true;
        }

    }
}