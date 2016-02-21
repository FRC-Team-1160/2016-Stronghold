package org.usfirst.frc.team1160.robot.subsystems;

import org.usfirst.frc.team1160.robot.RobotMap;
import org.usfirst.frc.team1160.robot.commands.ManualDrive;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveTrain extends Subsystem implements RobotMap{
	
	private static DriveTrain instance;
	
	public PID lPID, rPID;
	protected final CANTalon fl, bl, fr, br;
	protected final Encoder enc_left, enc_right;
	private final PowerDistributionPanel panel;
	
    /******************************************************************
     * Singleton for DriveTrain constructor
     * -Prevents constructor from running more than once
     * ->If constructor runs more than once, ports are assigned that 
     *   already have a spot, which results in an error upon building
     ******************************************************************/
	public static DriveTrain getInstance(){
		if(instance == null){
			instance = new DriveTrain();
		}
		return instance;
	}
	
	
    /******************************************************************
     *  Constructor for the DriveTrain Subsystem
     * -Talons/Encoders are assigned ports and initialized
     * -New instances of the PID class are created
     * -Values for Proportional and Derivative are given to SmartDash
     ******************************************************************/
	private DriveTrain(){
		fl = new CANTalon(DT_FRONTLEFT);
		bl = new CANTalon(DT_BACKLEFT);
		fr = new CANTalon(DT_FRONTRIGHT);
		br = new CANTalon(DT_BACKRIGHT);
		enc_left = new Encoder(PID_DT_LEFT_A, PID_DT_LEFT_B);
		enc_right = new Encoder(PID_DT_RIGHT_A, PID_DT_RIGHT_B);
		lPID = new PID("Left",fl,bl,enc_left);
		rPID = new PID("Right",fr,br,enc_right);
		panel = new PowerDistributionPanel();
	}
	
	
    /******************************************************************
     *  Takes joystick input from Z and Y axis of PS3 controller
     *  Some maths to make the motors go the right (or left) way
     ******************************************************************/
	public void Drive(){
/*		fl.set(OI.getInstance().getStick().getCubeZ() - OI.getInstance().getStick().getCubeY());
		bl.set(OI.getInstance().getStick().getCubeZ() - OI.getInstance().getStick().getCubeY());
		fr.set(OI.getInstance().getStick().getCubeZ() + OI.getInstance().getStick().getCubeY());
		br.set(OI.getInstance().getStick().getCubeZ() + OI.getInstance().getStick().getCubeY());
		logPower();*/
		/*fl.set(-OI.getInstance().getStick().getY());
		bl.set(-OI.getInstance().getStick().getY());
		fr.set(OI.getInstance().getStick().getCubeZ());
		br.set(OI.getInstance().getStick().getCubeZ());*/
	}
	
	
    /******************************************************************
     * Uses PID to move the wheels a set distance forward
     ******************************************************************/
	public void DriveDistance(double distance){
		lPID.setSetpoint(-distance);
		rPID.setSetpoint(distance);
	}
	
	
    /******************************************************************
     * Rotates the robot's frame left or right depending on the input
     ******************************************************************/
	public void RotateLeft(double distance){
		lPID.setSetpoint(distance);
		rPID.setSetpoint(distance);
	}
	
	
    /******************************************************************
     * Should probably just use one of these rotates and set both neg or something
     ******************************************************************/
	public void RotateRight(double distance){
		lPID.setSetpoint(distance);
		rPID.setSetpoint(distance);
	}
	
	
    /******************************************************************
     * Logs power to the SmartDash for monitoring
     ******************************************************************/
	public void logPower(){
	    	SmartDashboard.putNumber("FrontLeft Power: ", panel.getCurrent(P_MOTOR_FL));
	    	SmartDashboard.putNumber("BackLeft Power: ", panel.getCurrent(P_MOTOR_BL));
	    	SmartDashboard.putNumber("FrontRight Power: ", panel.getCurrent(P_MOTOR_FR));
	    	SmartDashboard.putNumber("BackRight Power: ", panel.getCurrent(P_MOTOR_BR));
	    	SmartDashboard.putNumber("Total PDP Volts: ", panel.getVoltage());
	    	//SmartDashboard.putNumber("Total PDP Watts: ", panel.getTotalPower());
	    }
	 
	
    /******************************************************************
     * Commands call this for PID to see if both sides are done
     ******************************************************************/
	public boolean commandDone(){
		return (lPID.finished() && rPID.finished());
	}
	
	
    /******************************************************************
     * Sets the default command for the subsystem
     * This command is returned to after any other command finishes
     ******************************************************************/
	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new ManualDrive());
	}

}