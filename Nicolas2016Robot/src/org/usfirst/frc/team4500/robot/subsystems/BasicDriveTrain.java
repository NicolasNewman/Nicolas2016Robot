package org.usfirst.frc.team4500.robot.subsystems;

import org.usfirst.frc.team4500.robot.RobotMap;
import org.usfirst.frc.team4500.robot.commands.DriveTank;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class BasicDriveTrain extends Subsystem {
	
	private DoubleSolenoid switchTrain;
	
	private Victor lTank, rTank;
	
	private Victor lOmni, rOmni;
	private Jaguar fOmni, bOmni;
	
	private RobotDrive tank;
	private RobotDrive wheel;
  

    public void initDefaultCommand() {
    	switchTrain = new DoubleSolenoid(2, 3);
    	lOmni = new Victor(RobotMap.LMOTOR);
    	rOmni = new Victor(RobotMap.RMOTOR);
    	fOmni = new Jaguar(RobotMap.FMOTOR);
    	bOmni = new Jaguar(RobotMap.BMOTOR);
    	lTank = lOmni;
    	rTank = rOmni;
    	
    	tank = new RobotDrive(lTank, rTank);
    	wheel = new RobotDrive(fOmni, bOmni);
        // Set the default command for a subsystem here.
        setDefaultCommand(new DriveTank());
    }
    
    public void tankDrive(double joyY, double joyTwist) {
    	tank.arcadeDrive(joyY, joyTwist, true);
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

