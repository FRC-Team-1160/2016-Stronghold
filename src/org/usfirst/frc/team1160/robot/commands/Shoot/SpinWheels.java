package org.usfirst.frc.team1160.robot.commands.Shoot;

import org.usfirst.frc.team1160.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class SpinWheels extends Command{

	double rpm;
	
	public SpinWheels(){
		requires(Robot.shoot);
	}
	@Override
	protected void initialize() {
		rpm = Robot.shoot.addEnergy();
	}

	@Override
	protected void execute() {
		System.out.println("going at " + rpm);
		Robot.shoot.bangBang(rpm);
	}

	@Override
	protected boolean isFinished() {
		return Robot.shoot.isDone(rpm);
	}

	@Override
	protected void end() {
		
	}

	@Override
	protected void interrupted() {
		
	}

}
