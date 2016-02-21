package org.usfirst.frc.team1160.robot.subsystems;

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
	private double rpm, angleSec, finalRPM;
	private Vision vision;
	
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
		vision = Vision.getInstance();
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
	
	public double velocity(double distance){
		angleSec = 1/Math.cos(SHOOTER_ANGLE_RADIANS);
		return FT_TO_M*(distance*angleSec*Math.sqrt((GRAVITATIONAL_ACCEL)/(2*(BALL_VERTICAL_DISPLACEMENT - distance*Math.tan(SHOOTER_ANGLE_RADIANS)))));
	}
	
	public double addEnergy(){
		finalRPM = speedFromDistance(vision.getDistance()) + 102.788*velocity(vision.getDistance());
		return finalRPM;
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
		System.out.println("BANG BANG BANG BANG!!! : " + targetRPM);
	}
	
	public boolean isDone(double rpm){
		if(rpm < 60/enc_small.getPeriod() && rpm > 60/enc_big.getPeriod()){
			return true;
		}
		System.out.println("Current RPM (small wheel): " + 60/enc_small.getPeriod());
		System.out.println("Current RPM (big wheel): " + 60/enc_big.getPeriod());
		return false;
	}
	
	protected void initDefaultCommand() {
		//setDefaultCommand(new TestFire());
	}

	public double testFire(double distance){
		//System.out.println(addEnergy(speedFromDistance(distance), velocity(distance)));
		return 0;
	}
	
}
