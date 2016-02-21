package org.usfirst.frc.team1160.robot.commands;

import org.usfirst.frc.team1160.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;


public class Wait extends Command{

	private double waitTime,timeElapsed;

	public Wait(double time){
		requires(Robot.air);
		waitTime = time; 		
	}
	
	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		Robot.air.start();
	}

	@Override
	protected void execute() {
		timeElapsed = Robot.air.getTime();
	}

	@Override
	protected boolean isFinished() {
		if(timeElapsed>=waitTime){
			return true;
		}
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
