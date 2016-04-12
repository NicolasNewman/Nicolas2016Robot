package org.usfirst.frc.team4500.robot.subsystems;

import org.usfirst.frc.team4500.robot.commands.CannonDoNothing;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Cannon extends Subsystem {
    
	private Victor horizMotor, vertMotor, fireMotor;

    public void initDefaultCommand() {
    	horizMotor = new Victor(5);
    	vertMotor = new Victor(7);
    	fireMotor = new Victor(6);
        // Set the default command for a subsystem here.
        setDefaultCommand(new CannonDoNothing());
    }
    
    public void doNothing() {
    	horizMotor.set(0);
    	vertMotor.set(0);
    	fireMotor.set(0);
    	
    }
    
    public void moveHorizontaly(double speed) {
    	horizMotor.set(speed);
    }
    
    public void moveVerticaly(double speed) {
    	vertMotor.set(speed);
    }
}

