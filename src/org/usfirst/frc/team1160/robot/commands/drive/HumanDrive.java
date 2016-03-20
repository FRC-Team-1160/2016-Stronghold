package org.usfirst.frc.team1160.robot.commands.drive;

import org.usfirst.frc.team1160.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class HumanDrive extends Command{
	
	public HumanDrive(){
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
