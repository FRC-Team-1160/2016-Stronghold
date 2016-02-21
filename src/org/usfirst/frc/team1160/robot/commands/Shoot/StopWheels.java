package org.usfirst.frc.team1160.robot.commands.Shoot;

import org.usfirst.frc.team1160.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class StopWheels extends Command{

	public StopWheels(){
		requires(Robot.shoot);
	}
	
	@Override
	protected void initialize() {
		Robot.shoot.setFlywheel(0);
		System.out.println("Wheels Stopped");

	}

	@Override
	protected void execute() {
	}

	@Override
	protected boolean isFinished() {
		return true;
	}

	@Override
	protected void end() {
		
	}

	@Override
	protected void interrupted() {
		
	}
	

}
