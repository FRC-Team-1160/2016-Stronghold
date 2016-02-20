package org.usfirst.frc.team1160.robot.commands;

import org.usfirst.frc.team1160.robot.Robot;
import org.usfirst.frc.team1160.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class CameraAngle extends Command implements RobotMap{

	public CameraAngle(){
		requires(Robot.see);
	}
	
	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void execute() {
		Robot.see.angleAdjust();
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
