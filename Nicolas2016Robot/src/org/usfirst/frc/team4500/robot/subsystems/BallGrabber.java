package org.usfirst.frc.team4500.robot.subsystems;

import org.usfirst.frc.team4500.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class BallGrabber extends Subsystem {
	
	private DoubleSolenoid loader;
	private Victor belt;
	
	public BallGrabber() {
		loader = new DoubleSolenoid(RobotMap.LOAD_SOLENOID_1, RobotMap.LOAD_SOLENOID_2);
	}
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void up() {
    	loader.set(DoubleSolenoid.Value.kForward);
    }
    
    public void down() {
    	loader.set(DoubleSolenoid.Value.kReverse);
    }
    
    public enum loadDir {
    	UP, DOWN
    }
    
    public void load(loadDir dir) {
    	if(dir == loadDir.UP) {
    		up();
    	} else {
    		down();
    	}
    }
}

