package org.usfirst.frc.team1160.robot.commands.air;

import org.usfirst.frc.team1160.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class CradlePush extends Command{
	
	public CradlePush(){
		requires(Robot.air);
	}

	@Override
	protected void initialize() {
		Robot.air.release();
	}

	@Override
	protected void execute() {
	}

	@Override
	protected boolean isFinished() {
		return true;
	}

	@Override
	protected void end() {
	}

	@Override
	protected void interrupted() {
	}
	
}
