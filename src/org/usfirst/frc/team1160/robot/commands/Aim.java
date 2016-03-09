package org.usfirst.frc.team1160.robot.commands;

import org.usfirst.frc.team1160.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Aim extends Command{

	private int index;
	public Aim(){
			requires(Robot.see);
			requires(Robot.dt);
			requires(Robot.air);
	}
	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		Robot.air.pivotIn();
	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		 index = Robot.see.getAlign();
		 
		 if(index==1){
			 Robot.dt.slowRight();
		 }
		 else if(index == 2){
			 Robot.dt.slowLeft();
		 }
		 
		 

		
	}

	@Override
	protected boolean isFinished() {
		return Robot.see.alignCheck();
		
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
