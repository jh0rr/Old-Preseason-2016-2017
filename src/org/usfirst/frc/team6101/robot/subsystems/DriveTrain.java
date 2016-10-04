package org.usfirst.frc.team6101.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team6101.robot.RobotMap;
import org.usfirst.frc.team6101.robot.commands.Calibration;

/**
 *
 */
public class DriveTrain extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public Encoder rEncoder = new Encoder(RobotMap.EncoderMap.RIGHT_ENCODER_FIRST_PORT, RobotMap.EncoderMap.RIGHT_ENCODER_SECOND_PORT, false, Encoder.EncodingType.k4X); 
	public Encoder lEncoder = new Encoder(RobotMap.EncoderMap.LEFT_ENCODER_FIRST_PORT, RobotMap.EncoderMap.RIGHT_ENCODER_SECOND_PORT, false, Encoder.EncodingType.k4X); 
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

