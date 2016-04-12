package org.usfirst.frc.team4500.robot.subsystems;

import org.usfirst.frc.team4500.robot.RobotMap;
import org.usfirst.frc.team4500.robot.commands.GrabberStop;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class BallGrabber extends Subsystem {
	
	private DoubleSolenoid loader;
	private Victor belt;
	
	public loadDir dir;
	
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
    	loader = new DoubleSolenoid(RobotMap.LOAD_SOLENOID_1, RobotMap.LOAD_SOLENOID_2);
		belt = new Victor(RobotMap.BELT_VICTOR);
        setDefaultCommand(new GrabberStop());
    }
    
    public void start() {
    	belt.set(RobotMap.LOAD_SPEED);
    }
    
    public void stop() {
    	belt.set(0);
    }
    
   /* public void up() {
    	loader.set(DoubleSolenoid.Value.kForward);
    }
    
    public void down() {
    	loader.set(DoubleSolenoid.Value.kReverse);
    }*/
    
    public enum loadDir {
    	UP, DOWN
    }
    
    public void load(loadDir dir) {
    	if(dir == loadDir.UP) {
    		loader.set(DoubleSolenoid.Value.kForward);
    	} else {
    		loader.set(DoubleSolenoid.Value.kReverse);
    	}
    }
}

