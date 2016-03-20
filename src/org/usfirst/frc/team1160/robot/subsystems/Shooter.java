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

	public void potBoy() {
		// ??
		OI.getInstance().getAutoInput().getAxis(AxisType.kThrottle);
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

	public double speedFromDistance(double distance) {
		angleSec = 1 / Math.cos(SHOOTER_ANGLE_RADIANS);
		rpm = ((distance * angleSec
				* Math.sqrt((GRAVITATIONAL_ACCEL)
						/ (2 * (BALL_VERTICAL_DISPLACEMENT - distance * Math.tan(SHOOTER_ANGLE_RADIANS)))))
				/ SHOOTER_WHEEL_CIRCUMFERENCE) * 60;
		return rpm;
	}

	public double velocity(double distance) {
		angleSec = 1 / Math.cos(SHOOTER_ANGLE_RADIANS);
		logVel = FT_TO_M * (distance * angleSec * Math.sqrt((GRAVITATIONAL_ACCEL)
				/ (2 * (BALL_VERTICAL_DISPLACEMENT - distance * Math.tan(SHOOTER_ANGLE_RADIANS)))));
		SmartDashboard.putNumber("Goal Velocity Set At: ", logVel);
		return logVel;
	}

	public double addEnergy() {
		//finalRPM = speedFromDistance(vision.getDistance()) + 102.788 * velocity(vision.getDistance());
		finalRPM = speedFromDistance(SmartDashboard.getNumber("TEST_DISTANCE")) + 102.788 * velocity(SmartDashboard.getNumber("TEST_DISTANCE"));
		SmartDashboard.putNumber("Goal RPM: ", finalRPM * 1.25);
		return finalRPM * 1.25;
	}

	public void getRevolutions() {
		smallRPM = bottom.getSpeed();
		largeRPM = top.getSpeed();
		System.out.println("SmallRPM: " + smallRPM);
		System.out.println("LargeRPM: " + largeRPM);

		SmartDashboard.putNumber("SmallRPM: ", smallRPM);
		SmartDashboard.putNumber("LargeRPM: ", largeRPM);

	}

	public void testFire() {
		System.out.println("Top rev: " + top.getPosition());
		System.out.println("Bot rev: " + bottom.getPosition());
	}

	public void startTime() {
		time.reset();
		time.start();
	}

	public int getTopRpm(){
		return top.getEncVelocity();
	}
	
	public int getBottomRpm(){
		return bottom.getEncVelocity();
	}
	
	public double getTime() {
		return time.get();
	}

	public double getSmall() {
		return bottom.get();
	}

	//Pnuematic stuff beyond this point
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
