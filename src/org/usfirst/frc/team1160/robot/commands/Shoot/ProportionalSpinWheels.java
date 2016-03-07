package org.usfirst.frc.team1160.robot.commands.Shoot;

import org.usfirst.frc.team1160.robot.Robot;
import org.usfirst.frc.team1160.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ProportionalSpinWheels extends Command implements RobotMap{

	double  timeElapsed, 
            targetRPM, 
            bigError, 
            smallError, 
            bigCurrentRPM, 
            smallCurrentRPM;
	
	public ProportionalSpinWheels(){
		requires(Robot.shoot);
		requires(Robot.see);
	}
	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		targetRPM = Robot.shoot.addEnergy();
		initialPWM = 0;
    
	    //I don't know what this negative is about	
		smallCurrentPWM = -initialPWM;
		bigCurrentPWM = -initialPWM;

		SmartDashboard.putNumber("Initial PWM:", -initialPWM);
		
		Robot.shoot.setFlywheel(initialPWM);
		Robot.shoot.startTime();

	}

	@Override
	protected void execute() {
		Robot.shoot.getRevolutions();

		bigCurrentRPM = Robot.shoot.getBigRevolutions();
		smallCurrentRPM = Robot.shoot.getSmallRevolutions();
		
		bigError = bigCurrentRPM-targetRPM;
		smallError = smallCurrentRPM-targetRPM;

	    bigCurrentPWM += bigError*P_CONSTANT;
		smallCurrentPWM += smallError*P_CONSTANT;

		Robot.shoot.setBig(bigCurrentPWM);
		Robot.shoot.setSmall(smallCurrentPWM);
		
		SmartDashboard.putNumber("Top RPM Error: ", bigError);
		SmartDashboard.putNumber("Bottom RPM Error: ", smallError);

		System.out.println("set big: " + bigCurrentPWM);
		System.out.println("set small: " + smallCurrentPWM);
		
		timeElapsed = Robot.shoot.getTime();
		
	}

	@Override
	protected boolean isFinished() {
		if(timeElapsed>FIRING_TIME){
			return(true);
		}
		return false;
	}

	@Override
	protected void end() {
		Robot.shoot.setFlywheel(0);
		bigCurrentPWM = 0;
		smallCurrentPWM = 0;
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		
	}

}
