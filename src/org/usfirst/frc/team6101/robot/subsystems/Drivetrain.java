package org.usfirst.frc.team6101.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team6101.robot.RobotMap;
import org.usfirst.frc.team6101.robot.commands.Calibration;

/**
 *
 */
public class Drivetrain extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public Encoder rEncoder = new Encoder(RobotMap.EncoderMap.RIGHT_ENCODER_FIRST_PORT, RobotMap.EncoderMap.RIGHT_ENCODER_SECOND_PORT, false, Encoder.EncodingType.k4X); 
	public Encoder lEncoder = new Encoder(RobotMap.EncoderMap.LEFT_ENCODER_FIRST_PORT, RobotMap.EncoderMap.RIGHT_ENCODER_SECOND_PORT, false, Encoder.EncodingType.k4X);
	public long rDriftm, lDrift;
    
	public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
	}
	
	public void resetEncoders(){
		rEncoder.reset();
		lEncoder.reset();
	}
	
	public void startEncoders(){
		rEncoder.start();
		lEncoder.start();
	}
	
	public void stopEncoders(){
		rEncoder.stop();
		lEncoder.stop();
	}
	
	public int[] getRevolutions(){
		// Way to calculate revolutions
		int [] revCounts = new int[2];
		int lRevs = // number of revoutions;
		int rRevs = // number of revolutions;	
		revCounts[0] = lRevs;
		revCounts[1] = rRevs;
		return (revCounts);
	}
	
	public void slowRight(lRevs, rRevs){
		rDrift = lRevs/rRevs;
		lDrift = 1;
	}
	
	public void slowLeft(lRevs, rRevs){
		rDrift = 1;
		lDrift = rRevs/lRevs;
	}
	
	public void motorSame(){
		rDrift = 1;
		lDrift = 1;
	}
	
	

