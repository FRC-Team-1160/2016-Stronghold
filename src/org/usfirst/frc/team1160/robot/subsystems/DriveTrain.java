package org.usfirst.frc.team1160.robot.subsystems;

import org.usfirst.frc.team1160.robot.OI;
import org.usfirst.frc.team1160.robot.RobotMap;
import org.usfirst.frc.team1160.robot.commands.ManualDrive;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveTrain extends Subsystem implements RobotMap{

	public static DriveTrain instance;
	
	Timer timer;
	RobotDrive dt;
	Talon fl, bl, fr, br;
	Encoder enc_left, enc_right;
	public PID lPID, rPID;
	
	public static DriveTrain getInstance(){
		if(instance == null){
			instance = new DriveTrain();
		}
		return instance;
	}
	
	public DriveTrain(){
		fl = new Talon(DT_FRONTLEFT);
		bl = new Talon(DT_BACKLEFT);
		fr = new Talon(DT_FRONTRIGHT);
		br = new Talon(DT_BACKRIGHT);
		enc_left = new Encoder(PID_DT_LEFT_A, PID_DT_LEFT_B);
		enc_right = new Encoder(PID_DT_RIGHT_A, PID_DT_RIGHT_B);
		lPID = new PID("Left",fl,bl,enc_left);
		rPID = new PID("Right",fr,br,enc_right);
		timer = new Timer();
	} 
	
	public void Drive(){
		fl.set(OI.getInstance().getStick().getCubeZ() - OI.getInstance().getStick().getCubeY());
		bl.set(OI.getInstance().getStick().getCubeZ() - OI.getInstance().getStick().getCubeY());
		fr.set(OI.getInstance().getStick().getCubeZ() + OI.getInstance().getStick().getCubeY());
		br.set(OI.getInstance().getStick().getCubeZ() + OI.getInstance().getStick().getCubeY());
	}
	
	//Check directions of motor, make sure setpoint is going correct way
	public void DriveDistance(double distance){
		lPID.setSetpoint(-distance);
		rPID.setSetpoint(distance);
	}
	
	public boolean commandDone(){
		return (lPID.finished() && rPID.finished());
	}
	
	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new ManualDrive());
	}

}