package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;  

import edu.wpi.first.wpilibj.DigitalInput;

public class Magazine {

    //Declare motor controller for the magazine
    private VictorSPX m_motor;

     //Declare sensors 
     private DigitalInput m_intakeSensor;
     private DigitalInput m_launchSensor;

    /**
     * Constructor for magazine objects
     * @param motor The motor that drives the magazine
     * @param intakeSensor The sensor mounted near the input to index our balls
     * @param launchSensor The sensor mounted near the launchers to tick our count in the magazine down
     */
     public Magazine(){
        m_motor = new VictorSPX(RobotMap.MAGAZINE_MOTOR_PORT);

        m_intakeSensor = new DigitalInput(RobotMap.MAGAZINE_IN_SENSOR_PORT);
        m_launchSensor = new DigitalInput(RobotMap.MAGAZINE_OUT_SENSOR_PORT);
    }

    /**
     * Sets the magazine to run based on on a set motor speed
     */
    public void RunMagazine(double speed){
        m_motor.set(ControlMode.PercentOutput, speed);
    }

     /**
     * Runs the belt at an inputted speed
     * @param speed The percent speed both belts should move at from -1.0 to 1.0
     */
    public void runBelt(double speed) {
        //sets percent output on both belts
        m_motor.set(ControlMode.PercentOutput, speed);
    }

    /**
     * Runs the belt based off of sensor input
     * <p>Every time the intake sensor is tripped, 
     * the magazine runs until the ball is clear of the intake sensor.
     */
    public void sensorBeltControl() {
        if (!m_intakeSensor.get() && m_launchSensor.get()) {
            runBelt(RobotMap.MAGAZINE_INTAKE_SPEED);
        }
        else {
            runBelt(0);
        }
    }
    
}