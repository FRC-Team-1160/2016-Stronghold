package org.usfirst.frc.team1160.robot.subsystems;

import org.usfirst.frc.team1160.robot.OI;
import org.usfirst.frc.team1160.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Joystick.AxisType;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Shooter extends Subsystem implements RobotMap {

	private static Shooter instance;

	protected final CANTalon top, bottom;
	private double rpm, angleSec, finalRPM, smallRPM, largeRPM, logVel;
	private Timer time;
	protected final Compressor comp;
	protected final DoubleSolenoid pivot, cradle;

	public static Shooter getInstance() {
		if (instance == null) {
			instance = new Shooter();
		}
		return instance;
	}

	private Shooter() {
		top = new CANTalon(S_FLYWHEEL_TOP);
		bottom = new CANTalon(S_FLYWHEEL_BOTTOM);
		top.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
		bottom.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
		bottom.configEncoderCodesPerRev(1024);
		top.configEncoderCodesPerRev(1024);
		SmartDashboard.putNumber("TEST_DISTANCE", TEST_DISTANCE);
		time = new Timer();
	
		comp = new Compressor(COMPRESSOR);
		comp.start();
		
		pivot = new DoubleSolenoid(S_PIVOT_A, S_PIVOT_B);
		cradle = new DoubleSolenoid(S_HOLD_A, S_HOLD_B);
	}
	
	protected void initDefaultCommand() {
		
	}

	public void setTop(double speed) {
		top.set(speed);
	}

	public void setBottom(double speed) {
		bottom.set(speed);
	}

	public void setBoth(double speed) {
		top.set(speed);
		bottom.set(-speed);
	}

	public void logRevolutions() {
		smallRPM = bottom.getSpeed();
		largeRPM = top.getSpeed();
		
		System.out.println("SmallRPM: " + smallRPM);
		System.out.println("LargeRPM: " + largeRPM);

		SmartDashboard.putNumber("SmallRPM: ", smallRPM);
		SmartDashboard.putNumber("LargeRPM: ", largeRPM);

	}

	public void startTime() {
		time.reset();
		time.start();
	}

	public double getTime() {
		return time.get();
	}
	
	public double getTopRpm(){
		return top.getSpeed();
	}
	
	public double getBottomRpm(){
		return bottom.getSpeed();
	}
	
	//Pneumatic stuff beyond this point
	public void lowerShooter(){
		pivot.set(EXT);
	}
	
	public void raiseShooter(){
		pivot.set(RET);
	}
	
	public void shootCradle(){
		cradle.set(EXT);
	}
	
	public void holdCradle(){
		cradle.set(RET);
	}
}
