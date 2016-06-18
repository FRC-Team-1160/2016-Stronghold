package org.usfirst.frc.team1160.robot.commands.shooter;

import org.usfirst.frc.team1160.robot.Robot;
import org.usfirst.frc.team1160.robot.RobotMap;
import org.usfirst.frc.team1160.robot.subsystems.Vision;

import edu.wpi.first.wpilibj.command.Command;

public class SpinWheels extends Command implements RobotMap {

	private double rpmTop, rpmBot, error, sum;
	private double[] input;
	
	// Rpm is target rpm for top and bottom
	// Error is the acceptable error for triggering a stop
	public SpinWheels(double targetRpm, int error){
		requires(Robot.shooter);
		input = new double[7];
		this.rpmTop = targetRpm * 1.325;
		this.rpmBot = targetRpm;
		this.error = error;
	}
	
	@Override
	protected void initialize() {
		Robot.shooter.setShoot();
		Robot.shooter.setBottom(rpmBot);
		Robot.shooter.setTop(rpmTop);
		System.out.println("Vision logged at: " + Vision.getInstance().neededRpm());
	}

	@Override
	protected void execute() {
		Robot.shooter.logRevolutions();
	}

	@Override
	protected boolean isFinished() {
		return (inRange(Robot.shooter.getTopRpm(), true) && 
			inRange(Robot.shooter.getBottomRpm(), false));
	}
	
	private boolean inRange(double rpm, boolean top){
		if(top){
			input[6] = Robot.shooter.getTopRpm();
			for(int i = 0; i < input.length-1; i++){
				input[i] = input[i+1];
			}
			for(int i = 0; i < input.length; i++){
				sum +=input[i];
			}
			sum = sum/7;
			System.out.println(Math.abs(Math.abs(sum) - this.rpmTop));
			return Math.abs(Math.abs(sum) - this.rpmTop) < error;
		}else{
			input[6] = Robot.shooter.getBottomRpm();
			for(int i = 0; i < input.length-1; i++){
				input[i] = input[i+1];
			}
			for(int i = 0; i < input.length; i++){
				sum +=input[i];
			}
			sum = sum/7;
			System.out.println(Math.abs(Math.abs(sum) - this.rpmBot));
			return Math.abs(Math.abs(sum) - this.rpmBot) < error;
		}
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
