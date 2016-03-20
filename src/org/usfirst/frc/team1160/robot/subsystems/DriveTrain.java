package org.usfirst.frc.team1160.robot.subsystems;

import org.usfirst.frc.team1160.robot.OI;
import org.usfirst.frc.team1160.robot.RobotMap;
import org.usfirst.frc.team1160.robot.commands.drive.HumanDrive;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveTrain extends Subsystem implements RobotMap{
	
	public static DriveTrain instance;
	
	protected CANTalon frontLeft, backLeft, frontRight, backRight;
	
	private DriveTrain(){
		System.out.println("Drive train created and stuff.");
		frontLeft = new CANTalon(DT_FRONTLEFT);
		frontRight = new CANTalon(DT_FRONTRIGHT);
		backLeft = new CANTalon(DT_BACKLEFT);
		backRight = new CANTalon(DT_BACKRIGHT);
		frontLeft.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
		frontRight.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
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
	
	public void resetPos(){
		System.out.println("Talon positions set to 0.");
		frontLeft.setPosition(0);
		frontRight.setPosition(0);
	}
	
	public void setAuto(){
		frontLeft.setPID(P, I, D);
		frontRight.setPID(P, I, D);
		System.out.println("Talons set to autonomous mode.");
		frontLeft.changeControlMode(CANTalon.TalonControlMode.Position);
		frontRight.changeControlMode(CANTalon.TalonControlMode.Position);
		backLeft.changeControlMode(CANTalon.TalonControlMode.Follower);
		backRight.changeControlMode(CANTalon.TalonControlMode.Follower);
	}
	
	public void setManual(){
		System.out.println("Talons set to manual mode.");
		frontLeft.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
		frontRight.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
		backLeft.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
		backRight.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
	}
	
	public void driveDistance(double distance){
		System.out.println(frontRight.getPosition());
		frontLeft.set(distance);
		frontRight.set(-distance);
		backLeft.set(frontLeft.getDeviceID());
		backRight.set(frontRight.getDeviceID());
	}
	
	public void rotate(double distance){
		frontLeft.set(distance);
		frontRight.set(distance);
		backLeft.set(frontLeft.getDeviceID());
		backRight.set(frontRight.getDeviceID());
	}
	
	public boolean isDone(){
		return (frontRight.getError() < 0.5);
	}
	
	protected void initDefaultCommand() {
		setDefaultCommand(new HumanDrive());
	}

}
