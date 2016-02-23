package org.usfirst.frc.team1160.robot.commands.air;

import org.usfirst.frc.team1160.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class CradleHold extends Command{

	public CradleHold(){
		requires(Robot.air);
	}
	
	@Override
	protected void initialize() {
		Robot.air.contain();
		System.out.println("contained");
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
