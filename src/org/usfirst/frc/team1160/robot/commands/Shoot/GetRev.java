package org.usfirst.frc.team1160.robot.commands.Shoot;

import org.usfirst.frc.team1160.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class GetRev extends Command{

	public GetRev(){
		requires(Robot.shoot);
	}
	
	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		Robot.shoot.reset();
	}

	@Override
	protected void execute() {
		Robot.shoot.getRevolutions();
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
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
