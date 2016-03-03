package org.usfirst.frc.team1160.robot.commands.Shoot;

import org.usfirst.frc.team1160.robot.Robot;
import org.usfirst.frc.team1160.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ProportionalSpinWheels extends Command implements RobotMap{

	double timeElapsed, targetRPM, targetSpeed, bigRPMError, smallRPMError, bigCurrentRPM, smallCurrentRPM,bigScaledError,smallScaledError;
	
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
		smallCurrentRPM = SmartDashboard.getNumber("SmallRPM: ");
		
		bigRPMError = targetRPM-bigCurrentRPM;
		smallRPMError = targetRPM-smallCurrentRPM;
		SmartDashboard.putNumber("Top RPM Error: ", bigRPMError);
		SmartDashboard.putNumber("Bottom RPM Error: ", smallRPMError);
		
		bigScaledError = bigRPMError/MAX_RPM;
		smallScaledError = smallRPMError/MAX_RPM;
		
		Robot.shoot.setBig(targetSpeed+bigScaledError*P_CONSTANT);
		Robot.shoot.setSmall(targetSpeed+smallScaledError*P_CONSTANT);
		
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
