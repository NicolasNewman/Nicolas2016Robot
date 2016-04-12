package org.usfirst.frc.team4500.robot.commands;

import org.usfirst.frc.team4500.robot.Robot;
import org.usfirst.frc.team4500.robot.subsystems.BallGrabber.loadDir;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class GrabberDown extends Command {

	public loadDir dir;
	
    public GrabberDown(loadDir dir) {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.grabber);
        this.dir = dir;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.grabber.load(dir);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
