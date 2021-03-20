package frc.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;


/* this class's inputs will be from the co pilot's controller and auton code 
this class will take information from robot.map
*/

public class Intake {

    /**
     * Enum for the intake's position. 
     * <p>Possible values:
     * <li> {@link #kLowered}
     * <li> {@link #kRaised}
     * <li> {@link #kUnknown}
     */
    public enum Position{
        /**
         * The lowered position of the intake
         * <p>This is the position we use to actually run our system
         */
        kLowered("Lowered"),
        /**
         * The raised position of the intake
         * <p>This is the position we need to be in at the start of the match
         * and the position we use while driving around
         */
        kRaised("Raised"),
        /**
         * The starting value of the intake
         * <p>We intialize our storage variable to this position,
         * however at no point in the match should this ever be the state of the intake
         */
        kUnknown("Unknown");
       
        private String positionName;

        /**
         * @param positionName The name of the position
         */
        Position(String positionName) {
            this.positionName = positionName;
        }

        /**
         * Returns the position object represented as a string
         */
        public String toString() {
            return this.positionName;
        }
    }

    //declare our intake motor controllers
    SpeedController m_outerMotor;
    SpeedController m_innerMotor;
  
    //delcare our position control solenoid
    DoubleSolenoid m_positionPiston;
  
    //declare our position tracker
    Position m_position;

    /**
     * constructor for intake
     * Uses robot map constants for instantation
     * 
     * @param outerIntakeMotor A default motor controller for running the intake
     * @param innerIntakeMotor The inner intake wheel for pulling balls into the magazine
     * @param positionPiston The double solenoid used to control the piston controlling position
     */
    public Intake() {
        //the motors are currently set to operate over PWM to reduce can bus traffic
        m_outerMotor = new VictorSP(RobotMap.INTAKE_OUTER_MOTOR_PORT);
        m_innerMotor = new Talon(RobotMap.INTAKE_INNER_MOTOR_PORT);

        //set inversions to match our physical intuition of forward being into the robot
        m_outerMotor.setInverted(RobotMap.OUTER_INTAKE_INVERTED);
        m_innerMotor.setInverted(RobotMap.INNER_INTAKE_INVERTED);

        m_positionPiston = new DoubleSolenoid(RobotMap.PCM_CAN_ID, RobotMap.INTAKE_POSITION_PISTON_FORWARD_PORT, RobotMap.INTAKE_POSITION_PISTON_REVERSE_PORT);

        //set our starting position to unknown
        m_position = Position.kUnknown;

        //then set the solenoids to the raised position
        setPosition(Position.kRaised);
    }

    
    /**
     * Sets the speed of the inner intake motor
     * @param speed The percent speed between -1.0 and 1.0
     */
    public void setInnerIntakeMotor(double speed) {
        m_innerMotor.set(speed);
    }

    /**
     * Sets the speed of the outer intake motor
     * @param speed The percent speed between -1.0 and 1.0
     */
    public void setOuterIntakeMotor(double speed) {
        m_outerMotor.set(speed);
    }

    /**
     * Sets the position of the intake to the requested value
     * @param position The position the intake should move to
     */
    public void setPosition(Position position) {
        //breaks out of method if we are already at our target position
        if(m_position == position) {
            return;
        }

        //sets our current position to the desired position
        m_position = position;

        //sets the value of the piston based on the passed in position
        if(m_position == Position.kLowered) {
            m_positionPiston.set(Value.kForward);
        }
        else if (m_position == Position.kRaised) {
            m_positionPiston.set(Value.kReverse);
        }
    }

    /**
     * this function allows other parts of the code to access the position that the intake arm is in
     * @return the double solenoid that sets our position
     */
    public DoubleSolenoid getPositionPiston() {
        return m_positionPiston;
    }

}