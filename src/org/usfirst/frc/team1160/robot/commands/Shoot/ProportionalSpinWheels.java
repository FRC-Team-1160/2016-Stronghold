package org.usfirst.frc.team1160.robot.commands.Shoot;

import org.usfirst.frc.team1160.robot.Robot;
import org.usfirst.frc.team1160.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ProportionalSpinWheels extends Command implements RobotMap{

	double timeElapsed, targetRPM, targetSpeed, bigRPMError, smallRPMError, bigCurrentRPM, smallCurrentRPM,bigCorrectedSpeed,smallCorrectedSpeed;
	
	public ProportionalSpinWheels(){
		requires(Robot.shoot);
		requires(Robot.see);
	}
	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		targetRPM = Robot.shoot.addEnergy();
		targetSpeed = targetRPM/MAX_RPM;
		
		
		Robot.shoot.setFlywheel(targetSpeed);
		Robot.shoot.startTime();

	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		Robot.shoot.getRevolutions();
		bigCurrentRPM = SmartDashboard.getNumber("LargeRPM: ");
		smallCurrentRPM = -SmartDashboard.getNumber("SmallRPM: ");
		
		bigRPMError = targetRPM-bigCurrentRPM;
		smallRPMError = targetRPM-smallCurrentRPM;
		SmartDashboard.putNumber("Top RPM Error: ", bigRPMError);
		SmartDashboard.putNumber("Bottom RPM Error: ", smallRPMError);
		
		bigCorrectedSpeed = (bigCurrentRPM + (bigRPMError*P_CONSTANT))/MAX_RPM;
		smallCorrectedSpeed = -(smallCurrentRPM + (smallRPMError*P_CONSTANT))/MAX_RPM;

		
		
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
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		
	}

}
