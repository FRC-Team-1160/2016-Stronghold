package org.usfirst.frc.team1160.robot.subsystems;

import org.usfirst.frc.team1160.robot.RobotMap;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Pneumatics extends Subsystem{

	private static Pneumatics instance;
	
	Compressor comp;
	DoubleSolenoid pivot,hold;
	
	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(null);
	}
	
	public static Pneumatics getInstance(){
		if(instance == null){
			instance = new Pneumatics();
		}
		return instance;
	}
	
	private Pneumatics(){
		comp = new Compressor(RobotMap.COMPRESSOR);
		comp.start();
		
		pivot = new DoubleSolenoid(RobotMap.S_PIVOT_A,RobotMap.S_PIVOT_B);
		hold = new DoubleSolenoid(RobotMap.S_HOLD_A,RobotMap.S_HOLD_B);
	}
	
	
	public void pivotOut(){
		pivot.set(RobotMap.EXT);
	}
	
	public void pivotIn(){
		pivot.set(RobotMap.RET);
	}
	
	public void release(){
		hold.set(RobotMap.EXT);
	}
	public void contain(){
		hold.set(RobotMap.RET);
	}
	
}
