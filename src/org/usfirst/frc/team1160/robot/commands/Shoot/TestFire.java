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
<<<<<<< HEAD
		Robot.shoot.testFire();
		Robot.shoot.enabler();
=======
		Robot.shoot.setShootSpeed(Robot.shoot.addEnergy());
>>>>>>> 4f01322b881aa3f02bb2a22ae3b758a055885abe
	}

	@Override
	protected void execute() {
<<<<<<< HEAD
		
=======
>>>>>>> 4f01322b881aa3f02bb2a22ae3b758a055885abe
	}

	@Override
	protected boolean isFinished() {
		return Robot.shoot.isDone(Robot.shoot.addEnergy());
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub
		Robot.shoot.disabler();
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		
	}

}
