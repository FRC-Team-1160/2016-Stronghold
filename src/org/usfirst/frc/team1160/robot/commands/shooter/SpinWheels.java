package org.usfirst.frc.team1160.robot.commands.shooter;

import org.usfirst.frc.team1160.robot.Robot;
import org.usfirst.frc.team1160.robot.RobotMap;
import org.usfirst.frc.team1160.robot.subsystems.Vision;

import edu.wpi.first.wpilibj.command.Command;

public class SpinWheels extends Command implements RobotMap {

	private double rpm, error;
	
	// Rpm is target rpm for top and bottom
	// Error is the acceptable error for triggering a stop
	public SpinWheels(double targetRpm, int error){
		requires(Robot.shooter);
		this.rpm = targetRpm;
		this.error = error;
	}
	
	@Override
	protected void initialize() {
		Robot.shooter.setShoot();
		Robot.shooter.setBoth(rpm);
		System.out.println("Vision logged at: " + Vision.getInstance().neededRpm());
	}

	@Override
	protected void execute() {
		Robot.shooter.logRevolutions();
	}

	@Override
	protected boolean isFinished() {
		return (inRange(Robot.shooter.getTopRpm()) && 
			inRange(Robot.shooter.getBottomRpm()));
	}
	
	private boolean inRange(double rpm){
		System.out.println(Math.abs(Math.abs(rpm) - this.rpm));
		return Math.abs(Math.abs(rpm) - this.rpm) < error;
	}

	
	@Override
	protected void end() {
		// We don't do anything here so the wheels maintain speed 
		// after command ends but still triggers the next sequential 
		// command when speed is hit
	}

	@Override
	protected void interrupted() {
		
	}

}
