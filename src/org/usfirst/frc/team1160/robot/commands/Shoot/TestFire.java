package org.usfirst.frc.team1160.robot.commands.Shoot;

import org.usfirst.frc.team1160.robot.Robot;
import org.usfirst.frc.team1160.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class TestFire extends Command implements RobotMap{

	public TestFire(){
		//requires(Robot.shoot);
		requires(Robot.see);
	}
	
	@Override
	protected void initialize() {
		Robot.see.getDistance();
	}

	@Override
	protected void execute() {
		//Robot.see.visualize();
		//Robot.shoot.testFire();
	}

	@Override
	protected boolean isFinished() {
		return true;
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub
		//Robot.shoot.disabler();
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		
	}

}
