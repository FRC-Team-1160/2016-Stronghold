package org.usfirst.frc.team1160.robot.commands.Shoot;

import org.usfirst.frc.team1160.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class SpinWheels extends Command{

	double rate;
	
	public SpinWheels(){
		requires(Robot.shoot);
	}
	@Override
	protected void initialize() {
		
	}

	@Override
	protected void execute() {
		System.out.println("going at " + Robot.shoot.addEnergy());
		Robot.shoot.bangBang(Robot.shoot.addEnergy());
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
