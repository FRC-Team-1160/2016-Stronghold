package org.usfirst.frc.team1160.robot.commands;

import org.usfirst.frc.team1160.robot.Robot;
import org.usfirst.frc.team1160.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class Drive extends Command implements RobotMap{

	double distance, timeElapsed;
	
    public Drive(double distance) {
    	requires(Robot.dt);
    	this.distance = distance;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.dt.startTime();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.dt.DriveDistance(distance);
    	timeElapsed = Robot.dt.getTime();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if(timeElapsed>AUTO_TIMEOUT){
        	return true;
        }
    	return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
