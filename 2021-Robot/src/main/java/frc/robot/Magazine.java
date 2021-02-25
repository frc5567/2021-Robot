package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.SensorCollection;
import com.ctre.phoenix.motorcontrol.can.BaseMotorController;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;  

public class Magazine {

    //Declare motor controller for the magazine
    private TalonSRX m_motor;

    /**
     * Constructor for magazine objects
     * @param motor The motor that runs the magazine
     */
    public Magazine(TalonSRX motor){
        m_motor = motor;
    } 

    /**
     * Vertical constuctor for instantiation
     */
    public Magazine(){
        m_motor = new TalonSRX(RobotMap.MAGAZINE_MOTOR_PORT);
    }

    /**
     * Sets the magazine to run based on on a set motor speed
     */
    public void RunMagazine(double speed){
        m_motor.set(ControlMode.PercentOutput, speed);
    }

}