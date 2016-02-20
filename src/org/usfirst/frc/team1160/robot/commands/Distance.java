package org.usfirst.frc.team1160.robot.commands;

import org.usfirst.frc.team1160.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;


public class Distance extends Command{

	int index;
	public Distance(int index){
		requires(Robot.see);
		this.index = index;
	}
	
	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		Robot.see.getDistanceToTarget(index);
	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
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
