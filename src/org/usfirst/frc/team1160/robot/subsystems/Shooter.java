package org.usfirst.frc.team1160.robot.subsystems;

import org.usfirst.frc.team1160.robot.RobotMap;

import edu.wpi.first.wpilibj.CounterBase;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Shooter extends Subsystem implements RobotMap{
	
	public static Shooter instance;
	
	Talon big, small;
	Encoder enc_big, enc_small;
	PID bP, sP;
	
	public static Shooter getInstance(){
		if(instance == null){
			instance = new Shooter();
		}
		return instance;
	}
	
	public Shooter(){
		big = new Talon(S_FLYWHEEL_LARGE);
		small = new Talon(S_FLYWHEEL_SMALL);
		enc_big = new Encoder(PID_S_BIG_A, PID_S_BIG_B, false, CounterBase.EncodingType.k1X);
		enc_small = new Encoder(PID_S_SMALL_A, PID_S_SMALL_B, false, CounterBase.EncodingType.k1X);
		bP = new PID("bigWheelPID",big,enc_big);
		sP = new PID("smallWheelPID",small,enc_small);
	}
	
	@SuppressWarnings("deprecation")
	public double getRPM(Encoder wheel){
		return wheel.getPeriod();
	}
	
	public void setFlywheel(double speed){
		big.set(speed);
		small.set(speed);
	}
	protected void initDefaultCommand() {
		
	}

}
