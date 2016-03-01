package org.usfirst.frc.team1160.robot.subsystems;

import org.usfirst.frc.team1160.robot.OI;
import org.usfirst.frc.team1160.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Shooter extends Subsystem implements RobotMap{
	
	public static Shooter instance;
	
	protected final CANTalon big, small;
	private double rpm, angleSec, finalRPM, smallCurrentRPM, largeCurrentRPM, logVel, hold;
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
		big.setFeedbackDevice(CANTalon.FeedbackDevice.CtreMagEncoder_Relative);
		small.setFeedbackDevice(CANTalon.FeedbackDevice.CtreMagEncoder_Relative);
		big.reverseOutput(true);
		SmartDashboard.putNumber("TEST_DISTANCE", TEST_DISTANCE);
		//big.changeControlMode(CANTalon.TalonControlMode.Speed);
		//small.changeControlMode(CANTalon.TalonControlMode.Speed);
		vision = Vision.getInstance();
		time = new Timer();
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
		//finalRPM = speedFromDistance(vision.getDistance()) + 102.788*velocity(vision.getDistance());
		//Test for bot w/o camera
		finalRPM = speedFromDistance(SmartDashboard.getNumber("TEST_DISTANCE")) + 102.788*velocity(SmartDashboard.getNumber("TEST_DISTANCE"));
		return finalRPM;
	}
	
	public void bangBang(double targetRPM){
		big.set(targetRPM);
		small.set(targetRPM);
		SmartDashboard.putNumber("Bottom Wheel RPM: ", smallCurrentRPM);
		SmartDashboard.putNumber("Top Wheel RPM: ", largeCurrentRPM);
		SmartDashboard.putNumber("Goal RPM: ", targetRPM);
		smallCurrentRPM = small.getSpeed();
		largeCurrentRPM = big.getSpeed();
		SmartDashboard.putNumber("Bottom Wheel RPM: ", smallCurrentRPM);
		SmartDashboard.putNumber("Top Wheel RPM: ", largeCurrentRPM);
		SmartDashboard.putNumber("Goal RPM: ", targetRPM);
		if(smallCurrentRPM<targetRPM){
			small.set(-1);
		}
		else{
			small.set(0);
		}
		if(largeCurrentRPM<targetRPM){
			big.set(-1);
		}
		else{
			big.set(0);
		}
		//big.set(-.8);
		//small.set(-.6);
	}
	
	protected void initDefaultCommand() {
		
	}

	public void testFire(){
		//SmartDashboard.putNumber("CANTalon Big: ", big.getEncVelocity());
		//SmartDashboard.putNumber("CANTalon Small: ", small.getEncVelocity());
	}
	public void startTime(){
		time.reset();
		time.start();
	}
	
	public double getTime(){
		return time.get();
	}
	
}
