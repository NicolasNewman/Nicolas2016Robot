package org.usfirst.frc.team4500.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class BasicDriveTrain extends Subsystem {
	
	private DoubleSolenoid switchTrain;
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
    	switchTrain = new DoubleSolenoid(2, 3);
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public enum driveType {
    	OMNI, TANK
    }
    
    public void switchTrain(driveType driveTrain) {
    	if(driveTrain == driveType.OMNI) {
    		switchTrain.set(Value.kForward);
    		
    	} else {
    		switchTrain.set(Value.kReverse);
    	}
    }
}

