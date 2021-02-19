/* this class's inputs will be from the co pilot's controller and auton code 
this class will take information from robot.map
*/

// comments are made assuming that we will pull the intake arm up while we are not trying to gather balls

public class Intake {

    //declare all motors and solenoids

    //enum to describe our possible positions of the intake arm

    public Intake(){
        /**
         * instantiate the motors and the intake arm's solenoid
         * invert one side of motors to match the other
         * set starting values
        */
    }

    /**
     * if the co-pilot's button is pressed
     * the arm needs to move to / be in the lowered position
     * all motors speed gets set to 1
    */

    /** 
     * else the co-pilot's button is released
     * the arm needs to move to / be in the raised position
     * all motors speed gets set to 0
    */
}
