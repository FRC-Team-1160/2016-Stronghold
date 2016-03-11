package org.usfirst.frc.team1160.robot.subsystems;

import org.usfirst.frc.team1160.robot.OI;
import org.usfirst.frc.team1160.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Joystick.AxisType;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Shooter extends Subsystem implements RobotMap {

	public static Shooter instance;

	protected final CANTalon big;
	protected final ModTal small;
	private double rpm, angleSec, finalRPM, smallRPM, largeRPM, logVel;
	private Timer time;
	private Vision vision;

	public static Shooter getInstance() {
		if (instance == null) {
			instance = new Shooter();
		}
		return instance;
	}

	private Shooter() {
		big = new CANTalon(S_FLYWHEEL_LARGE);
		small = new ModTal(S_FLYWHEEL_SMALL);
		big.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
		small.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
		small.configEncoderCodesPerRev(1024);
		big.configEncoderCodesPerRev(1024);
		SmartDashboard.putNumber("TEST_DISTANCE", TEST_DISTANCE);
		time = new Timer();
		vision = Vision.getInstance();
	}
	
	protected void initDefaultCommand() {
		
	}

	public void potBoy() {
		// ??
		OI.getInstance().getAutoInput().getAxis(AxisType.kThrottle);
	}
	
	public void setBig(double speed) {
		big.set(speed);
	}

	public void setSmall(double speed) {
		small.set(speed);
	}

	public void setFlywheel(double speed) {
		big.set(speed);
		small.set(-speed);
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
		// finalRPM = speedFromDistance(vision.getDistance()) + 102.788 * velocity(vision.getDistance());
		finalRPM = speedFromDistance(SmartDashboard.getNumber("TEST_DISTANCE")) + 102.788 * velocity(SmartDashboard.getNumber("TEST_DISTANCE"));
		SmartDashboard.putNumber("Goal RPM: ", finalRPM * 1.25);
		return finalRPM * 1.25;
	}

	public void getRevolutions() {
		smallRPM = small.getSpeed();
		largeRPM = big.getSpeed();
		System.out.println("SmallRPM: " + smallRPM);
		System.out.println("LargeRPM: " + largeRPM);

		SmartDashboard.putNumber("SmallRPM: ", smallRPM);
		SmartDashboard.putNumber("LargeRPM: ", largeRPM);

	}

	public void testFire() {
		System.out.println("Top rev: " + big.getPosition());
		System.out.println("Bot rev: " + small.getPosition());
	}

	public void startTime() {
		time.reset();
		time.start();
	}

	public double getTime() {
		return time.get();
	}

	public double getSmall() {
		return small.get();
	}

}
