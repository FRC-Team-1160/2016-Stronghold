package org.usfirst.frc.team1160.robot.commands.Shoot;

import org.usfirst.frc.team1160.robot.Robot;
import org.usfirst.frc.team1160.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class TestFire extends Command implements RobotMap{

	public TestFire(){
		requires(Robot.shoot);
	}
	
	@Override
	protected void initialize() {
		Robot.shoot.setShootSpeed(Robot.shoot.addEnergy());
	}

	@Override
	protected void execute() {
	}

	@Override
	protected boolean isFinished() {
		return Robot.shoot.isDone(Robot.shoot.addEnergy());
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
