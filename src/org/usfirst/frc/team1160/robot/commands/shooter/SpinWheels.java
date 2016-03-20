package org.usfirst.frc.team1160.robot.commands.shooter;

import org.usfirst.frc.team1160.robot.Robot;
import org.usfirst.frc.team1160.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class SpinWheels extends Command implements RobotMap {

	private int rpm, error;
	
	// Rpm is target rpm for top and bottom
	// Error is the acceptable error for triggering a stop
	public SpinWheels(int rpm, int error){
		requires(Robot.shoot);
		this.rpm = rpm;
		this.error = error;
	}
	
	@Override
	protected void initialize() {
		Robot.shoot.setBoth(rpm);
	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
	}

	@Override
	protected boolean isFinished() {
		return inRange(Robot.shoot.getTopRpm()) && 
			inRange(Robot.shoot.getBottomRpm());
	}
	
	private boolean inRange(double rpm){
		return Math.abs(this.rpm - rpm) < error;
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
