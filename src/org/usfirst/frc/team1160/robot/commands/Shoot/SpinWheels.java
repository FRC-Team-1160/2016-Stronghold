package org.usfirst.frc.team1160.robot.commands.Shoot;

import org.usfirst.frc.team1160.robot.Robot;
import org.usfirst.frc.team1160.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class SpinWheels extends Command implements RobotMap{

	double rpm, timeElapsed;
	
	public SpinWheels(){
		requires(Robot.shoot);
	}
	@Override
	protected void initialize() {
		rpm = Robot.shoot.addEnergy();
		Robot.shoot.startTime();
	}

	@Override
	protected void execute() {
		//System.out.println("going at " + rpm);
		Robot.shoot.bangBang(rpm);
		timeElapsed = Robot.shoot.getTime();
	}

	@Override
	protected boolean isFinished() {
		if(timeElapsed>=FIRING_TIME){
			return true;
		}
		
		//return Robot.shoot.isDone(rpm);
		return false;
	}

	@Override
	protected void end() {
		Robot.shoot.setFlywheel(0);
	}

	@Override
	protected void interrupted() {
		
	}

}
