package org.usfirst.frc.team1160.robot.subsystems;

import org.usfirst.frc.team1160.robot.RobotMap;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Subsystem;

public class PID  extends PIDSubsystem{

	private Talon motor;
	private Encoder enc;
	
	
	public PID(String name,Talon motor, Encoder enc){
		super(name, RobotMap.P, RobotMap.I, RobotMap.D);
		this.motor = motor;
		this.enc = enc;
		enc.setDistancePerPulse(RobotMap.ENC_DISTANCE_PER_PULSE);
		this.getPIDController().setContinuous();
		this.getPIDController().setAbsoluteTolerance(RobotMap.ABS_TOL);
	}
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected double returnPIDInput() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	protected void usePIDOutput(double output) {
		// TODO Auto-generated method stub
		
	}

}
