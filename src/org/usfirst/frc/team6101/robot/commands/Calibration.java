package org.usfirst.frc.team6101.robot.commands;

import org.usfirst.frc.team6101.robot.RobotMap;

import org.usfirst.frc.team6101.robot.Robot;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team6101.robot.subsystems.DriveTrain;


/**
 *
 */
public class Calibration extends Command {
	
	public Calibration() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {

    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.driveTrain.rEncoder.reset();
    	Robot.driveTrain.lEncoder.reset();
    	//Set encoders to 0
    	
    	Robot.driveTrain.rEncoder.start();
    	Robot.driveTrain.lEncoder.start();
    	//Start encoders

    	//*Run motors x number of seconds here*

    	Robot.driveTrain.rEncoder.stop();
    	Robot.driveTrain.lEncoder.stop();
    	//Stop encoders from counting

    	int rRevs = Robot.driveTrain.rEncoder.get();
    	int lRevs = Robot.driveTrain.lEncoder.get();
    	//store the number of revolutions during calibration period as "rRevs" and "lRevs"

    	if (rRevs > lRevs) {
    	    long rDrift = lRevs/rRevs;
    	    long lDrift = 1;
    	//if number of the right motor is more than the left motor the robot will turn right
    	} 
    	else if (rRevs < lRevs) {
    		long rDrift = 1;
    		long lDrift = rRevs/lRevs;
    	//if number of the right motor is less than the left motor the robot will turn left
    	} 
    	else if (rRevs == lRevs)){
    	    long rDrift = 1;
    	    long lDrift = 1;
    	//If the number of revolutions for both the left and right motors they both won’t change the direction (stay straight)
    	}

    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
