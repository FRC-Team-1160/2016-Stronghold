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
	private double rpm, angleSec, finalRPM, smallRPM, largeRPM, logVel, hold,largeRev,smallRev;
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
		big.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
		small.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
<<<<<<< HEAD
		small.reverseSensor(true);
		big.configEncoderCodesPerRev(4096);
		small.configEncoderCodesPerRev(4096);
		big.setP(P);
		big.setI(I);
		small.setP(P);
		small.setI(I);
		
=======
		//big.reverseOutput(true);
>>>>>>> 4f01322b881aa3f02bb2a22ae3b758a055885abe
		/*
		small.setFeedbackDevice(CANTalon.FeedbackDevice.CtreMagEncoder_Relative);
		big.reverseOutput(true);
		*/

		SmartDashboard.putNumber("TEST_DISTANCE", TEST_DISTANCE);
		//big.changeControlMode(CANTalon.TalonControlMode.Speed);
		//small.changeControlMode(CANTalon.TalonControlMode.Speed);
		time = new Timer();
	}
	
	public void enabler(){
		small.enable();
		big.enable();
	}
	
	public boolean done(){
		return false;
	}
	
	public void disabler(){
		small.disableControl();
		big.disableControl();
	}
	
	public double distanceRPM(double distance){
		
		return 0;
	}
	
	@SuppressWarnings("deprecation")
	public double getRPM(Encoder wheel){
		return wheel.getPeriod();
	}
	
	public void setFlywheel(double speed){
		big.set(-speed);
		small.set(-speed);
	}
	
	public void setBig(double speed){
		big.set(speed);
	}
	
	public void setSmall(double speed){
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
		logVel = FT_TO_M*(distance*angleSec*Math.sqrt((GRAVITATIONAL_ACCEL)/(2*(BALL_VERTICAL_DISPLACEMENT - distance*Math.tan(SHOOTER_ANGLE_RADIANS)))));
		SmartDashboard.putNumber("Goal Velocity Set At: ", logVel);
		return logVel;
	} 
	
	public double addEnergy(){
		//finalRPM = speedFromDistance(vision.getDistance()) + 102.788*velocity(vision.getDistance());
		//Test for bot w/o camera
		finalRPM = speedFromDistance(SmartDashboard.getNumber("TEST_DISTANCE")) + 102.788*velocity(SmartDashboard.getNumber("TEST_DISTANCE"));
		SmartDashboard.putNumber("Goal RPM: ", finalRPM);
		return finalRPM;
	}
	
	public void getRevolutions(){
		 	/*
		    smallRev = small.get();
		 	largeRev = big.getPosition() / 4096;
		 	System.out.println("Small: " + smallRev);
		 	*/
		
			smallRPM = small.getSpeed() * 600 / TICKS_PER_REV;
			largeRPM = big.getSpeed() * 600 / TICKS_PER_REV;
			
<<<<<<< HEAD
			System.out.println("SmallRPM: " + small.getSpeed());
			System.out.println("LargeRPM: " + big.getSpeed());
=======
			System.out.println("SmallRPM: " + smallRPM);
			System.out.println("LargeRPM: " + largeRPM);
			//System.out.println("he");
>>>>>>> 4f01322b881aa3f02bb2a22ae3b758a055885abe
			
			SmartDashboard.putNumber("SmallRPM: ", smallRPM);
			SmartDashboard.putNumber("LargeRPM: ", largeRPM);

		 	}
	
	public void setShootSpeed(double speedRPM){
		small.changeControlMode(CANTalon.TalonControlMode.Speed);
		big.changeControlMode(CANTalon.TalonControlMode.Speed);
		small.setProfile(0);
		big.setProfile(0);
		small.set(speedRPM * 4096 / 600);
		big.set(speedRPM * 4096 / 600);
		small.enable();
		big.enable();
	}
	
	public boolean isDone(double setSpeed){
		double goal = setSpeed * 4096 / 600;
		getRevolutions();
		SmartDashboard.putNumber("Bottom Wheel RPM: ", small.getSpeed() * 600 / 4096);
		return small.getSpeed() >= goal;
	}
	
	protected void initDefaultCommand() {
		
	}

	public void testFire(){
		small.set(addEnergy());
		big.set(addEnergy());
	}
	public void startTime(){
		time.reset();
		time.start();
	}
	
	public double getTime(){
		return time.get();
	}
	
}
