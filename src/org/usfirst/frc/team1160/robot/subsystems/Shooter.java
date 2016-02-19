package org.usfirst.frc.team1160.robot.subsystems;

import org.usfirst.frc.team1160.robot.OI;
import org.usfirst.frc.team1160.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CounterBase;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Shooter extends Subsystem implements RobotMap{
	
	public static Shooter instance;
	
	protected final CANTalon big, small;
	protected final Encoder enc_big, enc_small;
	public PID bP, sP;
	private double rpm, initV, angleSec, motorOutput;
	
	public static Shooter getInstance(){
		if(instance == null){
			instance = new Shooter();
		}
		return instance;
	}
	
	private Shooter(){
		big = new CANTalon(S_FLYWHEEL_LARGE);
		small = new CANTalon(S_FLYWHEEL_SMALL);
		enc_big = new Encoder(PID_S_BIG_A, PID_S_BIG_B, false, CounterBase.EncodingType.k1X);
		enc_small = new Encoder(PID_S_SMALL_A, PID_S_SMALL_B, false, CounterBase.EncodingType.k1X);
		//bP = new PID("bigWheelPID",big,enc_big);
		//sP = new PID("smallWheelPID",small,enc_small);
	}
	
	public double distanceRPM(double distance){
		
		return 0;
	}
	
	@SuppressWarnings("deprecation")
	public double getRPM(Encoder wheel){
		return wheel.getPeriod();
	}
	
	public void setFlywheel(double speed){
		big.set(speed);
		small.set(speed);
	}
	public double speedFromDistance(double distance){
		angleSec = 1/Math.cos(SHOOTER_ANGLE_RADIANS);
		rpm = ((distance*angleSec*Math.sqrt((GRAVITATIONAL_ACCEL)/(2*(BALL_VERTICAL_DISPLACEMENT - distance*Math.tan(SHOOTER_ANGLE_RADIANS)))))/SHOOTER_WHEEL_CIRCUMFERENCE)*60;	
		//motorOutput = 
		return rpm;
	}
	
	@SuppressWarnings("deprecation")
	public void bangBang(double targetRPM){
		double smallCurrentRPM = (1/enc_small.getPeriod())*60;
		double largeCurrentRPM = (1/enc_big.getPeriod())*60;
		if(smallCurrentRPM<targetRPM){
			small.set(1);
		}
		else{
			small.set(0);
		}
		if(largeCurrentRPM<targetRPM){
			big.set(1);
		}
		else{
			big.set(0);
		}
	}
	protected void initDefaultCommand() {
	}

	public void testFire(){
		System.out.println("works?");
		big.set(OI.getInstance().getTest().getZ());
		small.set(-OI.getInstance().getTest().getZ());
	}
	
}
