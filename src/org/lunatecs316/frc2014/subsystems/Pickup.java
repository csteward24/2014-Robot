package org.lunatecs316.frc2014.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import org.lunatecs316.frc2014.RobotMap;

/**
 * Pickup subsystem. <br>
 * Picks stuff up - what more do you need?
 * @author christiansteward
 */
public class Pickup {
    private Victor roller = new Victor(RobotMap.kPickupRoller);
    private Solenoid solenoid = new Solenoid(RobotMap.kPickupSolenoid);
    private DigitalInput lowerLimit = new DigitalInput(RobotMap.kPickupLowerLimit);
    private DigitalInput upperLimit = new DigitalInput(RobotMap.kPickupUpperLimit);
    private DigitalInput ballDetector = new DigitalInput(RobotMap.kPickupSensor);
    
    public static double kForward = 1.0;
    public static double kReverse = -1.0;
    
    public Pickup() {
    }
    
    /**
     * Initialize the subsystem
     */
    public void init() {
        LiveWindow.addActuator("Pickup", "Roller", roller);
        LiveWindow.addActuator("Pickup", "Solenoid", solenoid);
        LiveWindow.addSensor("Pickup", "Lower Limit", lowerLimit);
        LiveWindow.addSensor("Pickup", "Upper Limit", upperLimit);
        LiveWindow.addSensor("Pickup", "ballDetector", ballDetector);
    }
   
    /**
     * Move the pickup to the raised position. 
     */
    public void raise(){
        solenoid.set(true);
    }
    
    /**
     * Move the pickup to the lowered position through actuation of the Solenoid
     */        
    public void lower() {
        solenoid.set(false);
    }
    
    /**
     * Sets speed of the roller for max versatility 
     * @param speed the speed of the roller
     */
    public void setRollerSpeed(double speed) {
        roller.set(speed);
    }
    
    /**
     * Get the state of the upper limit switch
     * @return true if pickup is raised
     */
    public boolean isRaised() {
        return upperLimit.get();
    }
    
    /**
     * Get the state of the lower limit switch
     * @return true if pickup is lowered
     */
    public boolean isLowered() {
        return lowerLimit.get();
    }
    
    /**
     * Does it haz Ball?
     * @return Y/N
     */
    public boolean hasBall() {
        return ballDetector.get();
    }
}
