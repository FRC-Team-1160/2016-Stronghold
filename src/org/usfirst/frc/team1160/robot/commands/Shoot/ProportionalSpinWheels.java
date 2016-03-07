package org.usfirst.frc.team1160.robot.commands.Shoot;

import org.usfirst.frc.team1160.robot.Robot;
import org.usfirst.frc.team1160.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ProportionalSpinWheels extends Command implements RobotMap{

	double  initialSpeed, timeElapsed, targetRPM, targetSpeed, bigRPMError, smallRPMError, bigError, smallError, bigCurrentRPM, smallCurrentRPM,bigCurrentSpeed,smallCurrentSpeed,bigCorrectedSpeed,smallCorrectedSpeed;
	
	public ProportionalSpinWheels(){
		requires(Robot.shoot);
		requires(Robot.see);
	}
	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		targetRPM = Robot.shoot.addEnergy();
<<<<<<< HEAD
		//targetSpeed = targetRPM/MAX_RPM;
		targetSpeed = 0;
=======
		initialSpeed = targetRPM/MAX_RPM;
>>>>>>> 4f01322b881aa3f02bb2a22ae3b758a055885abe
		
		smallCurrentSpeed = -initialSpeed;
		bigCurrentSpeed = -initialSpeed;
		SmartDashboard.putNumber("Initial Speed:", -initialSpeed);
		
		Robot.shoot.setFlywheel(initialSpeed);
		Robot.shoot.startTime();

	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		Robot.shoot.getRevolutions();
		bigCurrentRPM = SmartDashboard.getNumber("LargeRPM: ");
		smallCurrentRPM = SmartDashboard.getNumber("SmallRPM: ");
		
		bigRPMError = bigCurrentRPM-targetRPM;
		smallRPMError = smallCurrentRPM-targetRPM;
		bigError = bigRPMError*P_CONSTANT;
		smallError = smallRPMError*P_CONSTANT;
		SmartDashboard.putNumber("Top RPM Error: ", bigRPMError);
		SmartDashboard.putNumber("Bottom RPM Error: ", smallRPMError);
		
		
		bigCorrectedSpeed = (bigCurrentSpeed -bigError);
		smallCorrectedSpeed = (smallCurrentSpeed - smallError);
		
		bigCurrentSpeed = bigCorrectedSpeed;
		smallCurrentSpeed = smallCorrectedSpeed;

		
		
		Robot.shoot.setBig(bigCorrectedSpeed);
		Robot.shoot.setSmall(smallCorrectedSpeed);
		
		System.out.println("set big scaled: " + bigCorrectedSpeed);
		System.out.println("set small scaled: " + smallCorrectedSpeed);
		
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
		bigCurrentSpeed = 0;
		smallCurrentSpeed = 0;
		

	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		
	}

}
