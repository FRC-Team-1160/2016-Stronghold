package org.usfirst.frc.team1160.robot.commands;

import org.usfirst.frc.team1160.robot.Robot;
import org.usfirst.frc.team1160.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Drive extends Command implements RobotMap{

	private double targetDistance, timeElapsed,leftPosition,rightPosition;
	
    public Drive(double distance) {
    	requires(Robot.dt);
    	this.targetDistance = distance;
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.dt.startTime();
    	Robot.dt.DriveDistance(targetDistance);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	timeElapsed = Robot.dt.getTime();
    	leftPosition = SmartDashboard.getNumber("Left Auto Position");
    	rightPosition = SmartDashboard.getNumber("Right Auto Position");
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if(timeElapsed>AUTO_TIMEOUT){
        	return true;
        }
        else if(leftPosition>=targetDistance && rightPosition<=-targetDistance){
        	return true;
        }
    	return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.dt.noMoreAuto();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.dt.noMoreAuto();
    }
}
