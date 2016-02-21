package org.usfirst.frc.team1160.robot.subsystems;

import org.usfirst.frc.team1160.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class PID  extends PIDSubsystem implements RobotMap{

	private CANTalon motor1,motor2;
	private Encoder enc;
	
	
	
	public PID(String name, CANTalon motor1, CANTalon motor2, Encoder enc){
		super(name, P, I, D);
		this.motor1 = motor1;
		this.motor2 = motor2;
		this.enc = enc;
		enc.setDistancePerPulse(ENC_DISTANCE_PER_PULSE);
		this.getPIDController().setContinuous();
		this.getPIDController().setAbsoluteTolerance(ABS_TOL);
	}
	public PID(String name, CANTalon motor1, Encoder enc){
		super(name, P, I, D);
		this.motor1 = motor1;
		this.enc = enc;
		enc.setDistancePerPulse(ENC_DISTANCE_PER_PULSE);
		this.getPIDController().setContinuous();
		this.getPIDController().setAbsoluteTolerance(ABS_TOL);
	}
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected double returnPIDInput() {
		// TODO Auto-generated method stub
		return enc.pidGet();
	}

	 public void reInit(){
	    	getPIDController().reset();
	    	getPIDController().setPID(SmartDashboard.getNumber("kP"), RobotMap.I, SmartDashboard.getNumber("kD"));
	    	this.enc.reset();
	 }
	
	 protected void logEncoder(){
	    	SmartDashboard.putNumber(this.getName() + ": PID: ", enc.pidGet());
	    	System.out.println(this.getName() + ": PID: " + enc.pidGet());
	}
	
	 public boolean finished(){
	    	SmartDashboard.putNumber(this.getName() + ": error: ", this.getPIDController().getError());
	    	return this.getPIDController().onTarget();
	}
	
	@Override
	protected void usePIDOutput(double output) {
		SmartDashboard.putNumber(this.getName() + ": MOTOR: ", output*(SCALE));
    	this.logEncoder();
    	motor1.pidWrite(output*(SCALE));
    	motor2.pidWrite(output*(SCALE));
	}

}
