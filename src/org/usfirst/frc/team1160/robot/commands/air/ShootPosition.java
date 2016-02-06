package org.usfirst.frc.team1160.robot.commands.air;

import org.usfirst.frc.team1160.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ShootPosition extends Command{
	
	public ShootPosition(){
		requires(Robot.air);
	}

	protected void initialize() {
		Robot.air.pivotIn();
	}

	protected void execute() {
		
	}

	protected boolean isFinished() {
		return true;
	}

	protected void end() {
		
	}

	protected void interrupted() {
		
	}
	
}
