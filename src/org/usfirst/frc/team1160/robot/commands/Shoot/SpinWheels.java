package org.usfirst.frc.team1160.robot.commands.Shoot;

import org.usfirst.frc.team1160.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class SpinWheels extends Command{

	double rate;
	
	public SpinWheels(double rpm){
		requires(Robot.shoot);
	rate = rpm;
	}
	@Override
	protected void initialize() {
		
	}

	@Override
	protected void execute() {
		 Robot.shoot.bangBang(rate);
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
