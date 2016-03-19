package org.usfirst.frc.team1160.robot.subsystems;

import org.usfirst.frc.team1160.robot.OI;
import org.usfirst.frc.team1160.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveTrain extends Subsystem implements RobotMap{
	
	public static DriveTrain instance;
	
	protected final CANTalon frontLeft, backLeft, frontRight, backRight;
	
	private DriveTrain(){
		frontLeft = new CANTalon(DT_FRONTLEFT);
		frontRight = new CANTalon(DT_FRONTRIGHT);
		backLeft = new CANTalon(DT_BACKLEFT);
		backRight = new CANTalon(DT_BACKRIGHT);
	}
	
	public static DriveTrain getInstance(){
		if(instance == null){
			instance = new DriveTrain();
		}
		return instance;
	}
	
	public void manualDrive(){
		frontLeft.set(OI.getInstance().getStick().getHalfQuintZ() - OI.getInstance().getStick().getCubeY());
		backLeft.set(OI.getInstance().getStick().getHalfQuintZ() - OI.getInstance().getStick().getCubeY());
		frontRight.set(OI.getInstance().getStick().getHalfQuintZ() + OI.getInstance().getStick().getCubeY());
		backRight.set(OI.getInstance().getStick().getHalfQuintZ() + OI.getInstance().getStick().getCubeY());
	}
	
	public void setAuto(){
		System.out.println("Talons set to autonomous mode.");
		frontLeft.changeControlMode(CANTalon.TalonControlMode.Follower);
		frontRight.changeControlMode(CANTalon.TalonControlMode.Position);
		backLeft.changeControlMode(CANTalon.TalonControlMode.Follower);
		backRight.changeControlMode(CANTalon.TalonControlMode.Position);
	}
	
	public void setManual(){
		System.out.println("Talons set to manual mode.");
		frontLeft.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
		frontRight.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
		backLeft.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
		backRight.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
	}
	
	public void driveDistance(){
		
	}
	
	protected void initDefaultCommand() {
		
	}

}
