package org.usfirst.frc.team1160.robot.subsystems;

import org.usfirst.frc.team1160.robot.OI;
import org.usfirst.frc.team1160.robot.RobotMap;
import org.usfirst.frc.team1160.robot.commands.Shoot.TestFire;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CounterBase;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Shooter extends Subsystem implements RobotMap{
	
	public static Shooter instance;
	
	protected final CANTalon big, small;
	//protected final Encoder enc_big, enc_small;
	public PID bP, sP;
	private double rpm, angleSec, finalRPM, smallCurrentRPM, largeCurrentRPM, logVel, logDis;
	private Vision vision;
	private Timer time;
	
	public static Shooter getInstance(){
		if(instance == null){
			instance = new Shooter();
		}
		return instance;
	}
	
	private Shooter(){
		big = new CANTalon(S_FLYWHEEL_LARGE);
		small = new CANTalon(S_FLYWHEEL_SMALL);
		//big.setFeedbackDevice(CANTalon.FeedbackDevice.EncRising);
		//small.setFeedbackDevice(CANTalon.FeedbackDevice.EncRising);
		//big.changeControlMode(CANTalon.TalonControlMode.Speed);
		//small.changeControlMode(CANTalon.TalonControlMode.Speed);
		/*enc_big = new Encoder(PID_S_BIG_A, PID_S_BIG_B, false, CounterBase.EncodingType.k1X);
		enc_small = new Encoder(PID_S_SMALL_A, PID_S_SMALL_B, false, CounterBase.EncodingType.k1X);*/
		big.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
		small.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
		vision = Vision.getInstance();
		time = new Timer();
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
		SmartDashboard.putNumber("Top Shooter Wheel",big.getSpeed());
		SmartDashboard.putNumber("Bottom Shooter Wheel",small.getSpeed());
	}
	public double speedFromDistance(double distance){
		angleSec = 1/Math.cos(SHOOTER_ANGLE_RADIANS);
		rpm = ((distance*angleSec*Math.sqrt((GRAVITATIONAL_ACCEL)/(2*(BALL_VERTICAL_DISPLACEMENT - distance*Math.tan(SHOOTER_ANGLE_RADIANS)))))/SHOOTER_WHEEL_CIRCUMFERENCE)*60;
		//motorOutput = 
		return rpm;
	}
	
	public double velocity(double distance){
		angleSec = 1/Math.cos(SHOOTER_ANGLE_RADIANS);
		logVel = FT_TO_M*(distance*angleSec*Math.sqrt((GRAVITATIONAL_ACCEL)/(2*(BALL_VERTICAL_DISPLACEMENT - distance*Math.tan(SHOOTER_ANGLE_RADIANS)))));
		SmartDashboard.putNumber("Goal Velocity Set At: ", logVel);
		return logVel;
	} 
	
	public double addEnergy(){
		finalRPM = speedFromDistance(vision.getDistance()) + 102.788*velocity(vision.getDistance());		finalRPM = speedFromDistance(vision.getDistance()) + 102.788*velocity(vision.getDistance());
		//Test for bot w/o camera
			//finalRPM = speedFromDistance(10);

		return finalRPM;
	}
	
	@SuppressWarnings("deprecation")
	public void bangBang(double targetRPM){
		//smallCurrentRPM = (1/small.getEncVelocity())*60;
		//largeCurrentRPM = (1/big.getEncVelocity())*60;
		SmartDashboard.putNumber("Bottom Wheel RPM: ", smallCurrentRPM);
		SmartDashboard.putNumber("Top Wheel RPM: ", largeCurrentRPM);
		SmartDashboard.putNumber("Goal RPM: ", targetRPM);
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
		//System.out.println("BANG BANG BANG BANG!!! : " + targetRPM);
	}
	
/*	@SuppressWarnings("deprecation")
	public boolean isDone(double rpm){
		if(rpm < 60/enc_small.getPeriod() && rpm > 60/enc_big.getPeriod()){
			return true;
		}
		System.out.println("Current RPM (small wheel): " + 60/enc_small.getPeriod());
		System.out.println("Current RPM (big wheel): " + 60/enc_big.getPeriod());
		return false;
	}*/
	
	protected void initDefaultCommand() {
		setDefaultCommand(new TestFire());
	}

	public void testFire(double distance){
		setFlywheel(OI.getInstance().getStick().getX ());
		SmartDashboard.putNumber("CANTalon Big: ", big.getEncVelocity());
		SmartDashboard.putNumber("CANTalon Small: ", small.getEncVelocity());
	}
	public void startTime(){
		time.reset();
		time.start();
	}
	
	public double getTime(){
		return time.get();
	}
	
}
