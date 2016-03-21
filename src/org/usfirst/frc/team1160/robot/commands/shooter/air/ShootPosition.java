package org.usfirst.frc.team1160.robot.commands.shooter.air;

import org.usfirst.frc.team1160.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ShootPosition extends Command {

	public ShootPosition(){
		requires(Robot.shooter);
	}
	@Override
	protected void initialize() {
		Robot.shooter.raiseShooter();
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
		// TODO Auto-generated method stub

	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub

	}

}
