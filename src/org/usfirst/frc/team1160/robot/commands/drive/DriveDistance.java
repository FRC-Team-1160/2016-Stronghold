package org.usfirst.frc.team1160.robot.commands.drive;

import org.usfirst.frc.team1160.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class DriveDistance extends Command{

	double distance;
	
	public DriveDistance(double distance){
		this.distance = distance;
		requires(Robot.dt);
		Robot.dt.resetPos();
	}
	
	@Override
	protected void initialize() {
		Robot.dt.setAuto();
		Robot.dt.driveDistance(distance);
	}

	@Override
	protected void execute() {
		Robot.dt.log();
	}

	@Override
	protected boolean isFinished() {
		return Robot.dt.isDone();
	}

	@Override
	protected void end() {
		
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		
	}

}
