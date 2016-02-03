package org.usfirst.frc.team1160.robot.subsystems;

import org.usfirst.frc.team1160.robot.RobotMap;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Pneumatics extends Subsystem implements RobotMap{

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
		comp = new Compressor(COMPRESSOR);
		comp.start();
		
		pivot = new DoubleSolenoid(S_PIVOT_A, S_PIVOT_B);
		hold = new DoubleSolenoid(S_HOLD_A, S_HOLD_B);
	}
	
	
	public void pivotOut(){
		pivot.set(EXT);
	}
	
	public void pivotIn(){
		pivot.set(RET);
	}
	
	public void release(){
		hold.set(EXT);
	}
	public void contain(){
		hold.set(RET);
	}
	
}
