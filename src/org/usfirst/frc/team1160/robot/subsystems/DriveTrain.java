package org.usfirst.frc.team1160.robot.subsystems;

import org.usfirst.frc.team1160.robot.OI;
import org.usfirst.frc.team1160.robot.RobotMap;
import org.usfirst.frc.team1160.robot.commands.drive.HumanDrive;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveTrain extends Subsystem implements RobotMap{
	
	public static DriveTrain instance;
	
	protected CANTalon frontLeft, backLeft, frontRight, backRight;
	//protected Talon frontLeft, backLeft, frontRight, backRight;
	private Timer time;
	
	private DriveTrain(){
		time = new Timer();
		System.out.println("Drive train created and stuff.");
		frontLeft = new CANTalon(DT_FRONTLEFT);
		frontRight = new CANTalon(DT_FRONTRIGHT);
		backLeft = new CANTalon(DT_BACKLEFT);
		backRight = new CANTalon(DT_BACKRIGHT);
		frontLeft.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
		frontRight.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
		backLeft.configEncoderCodesPerRev(DT_GEAR_RATIO);
		backRight.configEncoderCodesPerRev(DT_GEAR_RATIO);
		backLeft.reverseSensor(true);
		backRight.reverseSensor(true);
	}
	
/*	private DriveTrain(){
		time = new Timer();
		System.out.println("Drive train created and stuff.");
		frontLeft = new Talon(DT_FRONTLEFT);
		frontRight = new Talon(DT_FRONTRIGHT);
		backLeft = new Talon(DT_BACKLEFT);
		backRight = new Talon(DT_BACKRIGHT);
	}
	*/
	public static DriveTrain getInstance(){
		if(instance == null){
			instance = new DriveTrain();
		}
		return instance;
	}
	
	public void startTime(){
		time.reset();
		time.start();
	}
	
	public boolean timeDone(double var){
		return time.get() > var;
	}
	
	public void manualDrive(){
		frontLeft.set(.7*(OI.getInstance().getStick().getZ() - OI.getInstance().getStick().getY()));
		backLeft.set(.7*(OI.getInstance().getStick().getZ() - OI.getInstance().getStick().getY()));
		frontRight.set(.7*(OI.getInstance().getStick().getZ() + OI.getInstance().getStick().getY()));
		backRight.set(.7*(OI.getInstance().getStick().getZ() + OI.getInstance().getStick().getY()));
		//SmartDashboard.putNumber("BackLeft Position: ", backLeft.getPosition());
		//SmartDashboard.putNumber("BackRight Position: ", backRight.getPosition());
	}
	
	public void resetPos(){
		System.out.println("Talon positions set to 0.");
		backLeft.setPosition(0);
		backRight.setPosition(0);
	}
	
	public void setAuto(){
		resetPos();
		backLeft.configMaxOutputVoltage(9);
		backRight.configMaxOutputVoltage(9);
		backLeft.setPID(dP, I, D);
		backRight.setPID(dP, I, D);
		System.out.println("Talons set to autonomous mode.");
		backLeft.changeControlMode(CANTalon.TalonControlMode.Position);
		backRight.changeControlMode(CANTalon.TalonControlMode.Follower);
		frontLeft.changeControlMode(CANTalon.TalonControlMode.Follower);
		frontRight.changeControlMode(CANTalon.TalonControlMode.Position);
		backLeft.setAllowableClosedLoopErr(100);
		backRight.setAllowableClosedLoopErr(100);
		SmartDashboard.putNumber("BackLeft Position: ", backLeft.getPosition());
		SmartDashboard.putNumber("BackRight Position: ", backRight.getPosition());
	}
	
	public void setManual(){
	backLeft.configMaxOutputVoltage(13);
		backRight.configMaxOutputVoltage(13);
		System.out.println("Talons set to manual mode.");
		frontLeft.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
		frontRight.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
		backLeft.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
		backRight.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
	}
	
	public void driveDistance(double distance){
		frontLeft.set(backLeft.getDeviceID());
		backRight.set(frontRight.getDeviceID());
		backLeft.set(-distance);
		frontRight.set(distance);
		System.out.println("Trying to go: " + distance);
		backLeft.enable();
		backRight.enable();
		
	}
	
	public void rotate(double distance){
/*		frontLeft.set(backLeft.getDeviceID());
		frontRight.set(backRight.getDeviceID());
		backLeft.set(distance);
		backRight.set(distance);
*/	}
	public void rotateLeft(){
/*		frontLeft.set(backLeft.getDeviceID());
		frontRight.set(backRight.getDeviceID());
		backLeft.set(.3);
		backRight.set(-.3);
*/	}
	public void rotateRight(){
/*		frontLeft.set(backLeft.getDeviceID());
		frontRight.set(backRight.getDeviceID());
		backLeft.set(-.3);
		backRight.set(.3);
*/	}
	
	public void log(){
	System.out.println("RIGHT: " + backRight.getError());
		System.out.println("LEFT: " + backLeft.getError());
		System.out.println(backLeft.getPosition());
		SmartDashboard.putNumber("Left Closed Err", backLeft.getClosedLoopError());
		SmartDashboard.putNumber("Right Closed Err", backRight.getClosedLoopError());
		SmartDashboard.putNumber("Left Err", backLeft.getError());
		SmartDashboard.putNumber("Right Err", backRight.getError());
		SmartDashboard.putNumber("BackLeft Position", backLeft.get());
		SmartDashboard.putNumber("BackRight Position", backRight.get());

	}
	
	public boolean isDone(){
		if((Math.abs(backLeft.getError()) < 150) 
				//&& (Math.abs(backRight.getError()) < 150)
				){
			System.out.println("Done!");
			return true;
		}
		return false;
	}
	
	protected void initDefaultCommand() {
		setDefaultCommand(new HumanDrive());
	}

}
