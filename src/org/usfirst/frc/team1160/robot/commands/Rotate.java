package org.usfirst.frc.team1160.robot.commands;

import org.usfirst.frc.team1160.robot.Robot;
import org.usfirst.frc.team1160.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class Rotate extends Command implements RobotMap{

	private double duration, timeElapsed;
	private boolean direction;
	public Rotate(double time, Boolean Direction){
		duration = time;
		direction = Direction;		
		requires(Robot.dt);
		requires(Robot.shoot);
	}
	
	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		Robot.shoot.startTime();
	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		if(direction){
			Robot.dt.slowLeft();
		}
		else{
			Robot.dt.slowRight();
		}
		timeElapsed = Robot.shoot.getTime();
	}

	@Override
	protected boolean isFinished() {

		if(timeElapsed>duration){
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
