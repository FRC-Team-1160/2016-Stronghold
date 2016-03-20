package org.usfirst.frc.team1160.robot.commands.drive;

import org.usfirst.frc.team1160.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ManualDrive extends Command{
	
	public ManualDrive(){
		requires(Robot.dt);
	}
	
	protected void initialize() {
		Robot.dt.setManual();
	}

	protected void execute() {
		Robot.dt.manualDrive();
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {		
	}

	protected void interrupted() {

	}

}
