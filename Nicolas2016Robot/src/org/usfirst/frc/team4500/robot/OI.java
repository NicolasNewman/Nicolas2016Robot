package org.usfirst.frc.team4500.robot;

import org.usfirst.frc.team4500.robot.commands.CannonFire;
import org.usfirst.frc.team4500.robot.commands.CannonHoriz;
import org.usfirst.frc.team4500.robot.commands.CannonVert;
import org.usfirst.frc.team4500.robot.commands.DrivetrainSwitch;
import org.usfirst.frc.team4500.robot.commands.GrabberDown;
import org.usfirst.frc.team4500.robot.commands.GrabberStart;
import org.usfirst.frc.team4500.robot.commands.GrabberUp;
import org.usfirst.frc.team4500.robot.subsystems.BallGrabber.loadDir;
import org.usfirst.frc.team4500.robot.subsystems.BasicDriveTrain.driveType;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	Joystick stick;
	Button 
	loadUp, loadDown, loadStart, 
	cannonHorizLeft, cannonHorizRight, 
	cannonVertUp, cannonVertDown, 
	cannonFire, 
	switchTrainOmni, switchTrainTank;
	
	
	public OI() {
		stick = new Joystick(0);
		
		loadUp = new JoystickButton(stick, 7);
		loadUp.whileHeld(new GrabberUp(loadDir.UP));
		
		loadDown = new JoystickButton(stick, 9);
		loadDown.whileHeld(new GrabberDown(loadDir.DOWN));
		
		loadStart = new JoystickButton(stick, 10);
		loadStart.whileHeld(new GrabberStart());
		
		cannonHorizLeft = new JoystickButton(stick, 3);
		cannonHorizLeft.whileHeld(new CannonHoriz(-0.5));
		cannonHorizLeft.whenReleased(new CannonHoriz(0));
		
		cannonHorizRight = new JoystickButton(stick, 4);
		cannonHorizRight.whileHeld(new CannonHoriz(0.5));
		cannonHorizRight.whenReleased(new CannonHoriz(0));
		
		/*cannonVertUp = new JoystickButton(stick, 5);
		cannonVertUp.whileHeld(new CannonVert(-0.4));
		cannonVertUp.whenReleased(new CannonVert(0));
		
		cannonVertDown = new JoystickButton(stick, 6);
		cannonVertDown.whileHeld(new CannonVert(0.4));
		cannonVertDown.whenReleased(new CannonVert(0));*/
		
		cannonFire = new JoystickButton(stick, 1);
		cannonFire.whileHeld(new CannonFire(0.1));
		cannonFire.whenReleased(new CannonFire(0));
		
		switchTrainOmni = new JoystickButton(stick, 5);
		switchTrainOmni.whenPressed(new DrivetrainSwitch(driveType.OMNI));
		
		switchTrainTank = new JoystickButton(stick, 6);
		switchTrainTank.whenPressed(new DrivetrainSwitch(driveType.TANK));
	
	}
	
	public double getJoyX() {
		return stick.getX();	
	}
	
	public double getJoyY() {
		return stick.getY();	
	}
	
	public double getJoyTwist() {
		return stick.getTwist();	
	}
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
}

