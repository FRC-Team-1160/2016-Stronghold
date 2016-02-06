package org.usfirst.frc.team1160.robot.commands.Shoot;

import org.usfirst.frc.team1160.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Intake extends Command{

	double rate;
	
	public Intake(double speed){
		requires(Robot.shoot);
		rate = speed;
	}
	
	@Override
	protected void initialize() {
	}

	@Override
	protected void execute() {
		Robot.shoot.setFlywheel(rate);
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
	}

	@Override
	protected void interrupted() {
	}

}
