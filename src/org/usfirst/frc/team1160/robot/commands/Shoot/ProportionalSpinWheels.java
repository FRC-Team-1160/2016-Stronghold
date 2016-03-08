package org.usfirst.frc.team1160.robot.commands.Shoot;

import org.usfirst.frc.team1160.robot.Robot;
import org.usfirst.frc.team1160.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ProportionalSpinWheels extends Command implements RobotMap{

	double  initialSpeedBIG, initialSpeedSMALL, timeElapsed, targetRPMBig, targetRPMSmall, targetSpeed, bigRPMError, smallRPMError, bigError, smallError, bigCurrentRPM, smallCurrentRPM,bigCurrentSpeed,smallCurrentSpeed,bigCorrectedSpeed,smallCorrectedSpeed;
	
	public ProportionalSpinWheels(){
		requires(Robot.shoot);
		requires(Robot.see);
	}
	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		targetRPMSmall = Robot.shoot.addEnergy();
		targetRPMBig = -Robot.shoot.addEnergy();
		initialSpeedBIG = -1;
		initialSpeedSMALL = 1;
		
		smallCurrentSpeed = initialSpeedSMALL;
		bigCurrentSpeed = initialSpeedBIG;
		//SmartDashboard.putNumber("Initial Speed:", -initialSpeed);
		
		//Robot.shoot.setFlywheel(-initialSpeed);
		Robot.shoot.startTime();

	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		Robot.shoot.getRevolutions();
		bigCurrentRPM = SmartDashboard.getNumber("LargeRPM: ");
		smallCurrentRPM = SmartDashboard.getNumber("SmallRPM: ");
		
		bigRPMError = targetRPMBig - bigCurrentRPM;
		smallRPMError = targetRPMSmall -smallCurrentRPM;
		bigError = bigRPMError*P_CONSTANT;
		smallError = smallRPMError*P_CONSTANT;
		//SmartDashboard.putNumber("Top RPM Error: ", bigRPMError);
		//SmartDashboard.putNumber("Bottom RPM Error: ", smallRPMError);
		
		
		bigCorrectedSpeed = (bigCurrentSpeed + bigError);
		smallCorrectedSpeed = (smallCurrentSpeed + smallError);
		
		bigCurrentSpeed = bigCorrectedSpeed;
		smallCurrentSpeed = smallCorrectedSpeed;
		
		/*big -> -1000
		 * small -> 1000
		 * bigErrorRPM -> -500
		 * smallErrorRPM -> 500
		 * bigE = -500*.00007
		 * smallE = 500*.00007
		 * 
		 */

		
		//The Test robot is Batshit Crazy
		
		//Robot.shoot.setBig(bigCorrectedSpeed);
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
