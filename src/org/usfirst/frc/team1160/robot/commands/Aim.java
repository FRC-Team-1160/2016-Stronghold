package org.usfirst.frc.team1160.robot.commands;

import org.usfirst.frc.team1160.robot.Robot;
import org.usfirst.frc.team1160.robot.subsystems.Vision;

import edu.wpi.first.wpilibj.command.Command;

public class Aim extends Command{

	int orientation;
	
	public Aim(){
		requires(Robot.dt);
	}
	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		Robot.dt.setManual();
	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		this.orientation = Vision.getInstance().getAlign();
		if(orientation == 1){
			Robot.dt.rotateRight();
		}
		else if(orientation ==2){
			Robot.dt.rotateLeft();
		}
		
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return Vision.getInstance().alignCheck();
	}

	@Override
	protected void end() {
		Robot.dt.manualDrive();
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		
	}

}
