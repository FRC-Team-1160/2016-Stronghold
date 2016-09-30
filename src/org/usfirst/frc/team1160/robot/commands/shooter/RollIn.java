
package org.usfirst.frc.team1160.robot.commands.shooter;

import org.usfirst.frc.team1160.robot.Robot;
import org.usfirst.frc.team1160.robot.RobotMap;
import org.usfirst.frc.team1160.robot.subsystems.Vision;

import edu.wpi.first.wpilibj.command.Command;


public class RollIn extends Command implements RobotMap{
	
	double error, rpm;
	
	public RollIn(double rpm, double error) {
		requires(Robot.shooter);
		this.rpm = rpm;
		this.error = rpm;
    }
	
	@Override
	protected void initialize() {
/*		Robot.shooter.setIntake();
		Robot.shooter.setBoth(rpm);
*/	
		Robot.shooter.setVBus(-0.5);
	}

	@Override
	protected void execute() {
		Robot.shooter.logRevolutions();
	}

	@Override
	protected boolean isFinished() {
		return (inRange(Robot.shooter.getTopRpm()) && 
			inRange(Robot.shooter.getBottomRpm()));
	}
	
	private boolean inRange(double rpm){
		System.out.println(Math.abs(Math.abs(rpm) - this.rpm));
		return Math.abs(Math.abs(rpm) - this.rpm) < error;
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