
package org.usfirst.frc.team1160.robot.commands.shooter;

import org.usfirst.frc.team1160.robot.Robot;
import org.usfirst.frc.team1160.robot.RobotMap;
import org.usfirst.frc.team1160.robot.subsystems.Vision;

import edu.wpi.first.wpilibj.command.Command;


public class Spit extends Command implements RobotMap{
	
	double error, rpm;
	
	public Spit() {
		requires(Robot.shooter);
    }

    
	
	@Override
	protected void initialize() {
		Robot.shooter.setVBus(-.25);
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
		// We don't do anything here so the wheels maintain speed 
		// after command ends but still triggers the next sequential 
		// command when speed is hit
	}

	@Override
	protected void interrupted() {
		
	}
}