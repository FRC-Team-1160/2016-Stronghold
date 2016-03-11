package org.usfirst.frc.team1160.robot.subsystems;

import org.usfirst.frc.team1160.robot.OI;
import org.usfirst.frc.team1160.robot.RobotMap;
import org.usfirst.frc.team1160.robot.commands.ManualDrive;

import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveTrain extends Subsystem implements RobotMap {

	private static DriveTrain instance;

	protected final CANTalon fl, bl, fr, br;
	protected final PID lP,rP;
	Timer time;
	// private final PowerDistributionPanel panel;

	/******************************************************************
	 * Singleton for DriveTrain constructor -Prevents constructor from running
	 * more than once ->If constructor runs more than once, ports are assigned
	 * that already have a spot, which results in an error upon building
	 ******************************************************************/
	public static DriveTrain getInstance() {
		if (instance == null) {
			instance = new DriveTrain();
		}
		
		return instance;
	}

	/******************************************************************
	 * Constructor for the DriveTrain Subsystem -Talons/Encoders are assigned
	 * ports and initialized -New instances of the PID class are created -Values
	 * for Proportional and Derivative are given to SmartDash
	 ******************************************************************/
	private DriveTrain() {
		fl = new CANTalon(DT_FRONTLEFT);
		bl = new CANTalon(DT_BACKLEFT);
		fr = new CANTalon(DT_FRONTRIGHT);
		br = new CANTalon(DT_BACKRIGHT);
		
		lP = new PID(bl,fl);
		rP = new PID(br,fr);
		time = new Timer();
		
		SmartDashboard.putNumber("lP pos: ", lP.getPosition());
		SmartDashboard.putNumber("rP pos: ", rP.getPosition());
		
	}

	/******************************************************************
	 * Takes joystick input from Z and Y axis of PS3 controller Some maths to
	 * make the motors go the right (or left) way
	 ******************************************************************/
	public void Drive() {
		fl.set(OI.getInstance().getStick().getCubeZ() - OI.getInstance().getStick().getCubeY());
		bl.set(OI.getInstance().getStick().getCubeZ() - OI.getInstance().getStick().getCubeY());
		fr.set(OI.getInstance().getStick().getCubeZ() + OI.getInstance().getStick().getCubeY());
		br.set(OI.getInstance().getStick().getCubeZ() + OI.getInstance().getStick().getCubeY());
		logPower();
		// SmartDashboard.putNumber("Left Drive Encoder", bl.getPosition());
		// SmartDashboard.putNumber("Right Drive Encoder", br.getPosition());

	}

	public void slowRight() {
		double speed = .2;
		fl.set(speed);
		bl.set(speed);
		fr.set(speed);
		br.set(speed);
	}

	public void slowLeft() {
		double speed = .2;
		fl.set(-speed);
		bl.set(-speed);
		fr.set(-speed);
		br.set(-speed);
	}

	/******************************************************************
	 * Uses PID to move the wheels a set distance forward
	 ******************************************************************/
	public void DriveDistance(double distance) {
		lP.setD(distance);
		rP.setD(-distance);
		System.out.println(lP.getPosition());
		System.out.println(rP.getPosition());

	}

	/******************************************************************
	 * Rotates the robot's frame left or right depending on the input
	 ******************************************************************/
	public void RotateLeft(double distance) {
		lP.setD(distance);
		rP.setD(distance);
	}

	/******************************************************************
	 * Should probably just use one of these rotates and set both neg or
	 * something
	 ******************************************************************/
	public void RotateRight(double distance) {
		lP.setD(distance);
		rP.setD(distance);
	}

	/******************************************************************
	 * Logs power to the SmartDash for monitoring
	 ******************************************************************/
	public void logPower() {
		/*
		 * SmartDashboard.putNumber("FrontLeft Power: ",
		 * panel.getCurrent(P_MOTOR_FL)); SmartDashboard.putNumber(
		 * "BackLeft Power: ", panel.getCurrent(P_MOTOR_BL));
		 * SmartDashboard.putNumber("FrontRight Power: ",
		 * panel.getCurrent(P_MOTOR_FR)); SmartDashboard.putNumber(
		 * "BackRight Power: ", panel.getCurrent(P_MOTOR_BR));
		 * SmartDashboard.putNumber("Total PDP Volts: ", panel.getVoltage());
		 * //SmartDashboard.putNumber("Total PDP Watts: ",
		 * panel.getTotalPower());
		 * 
		 */
	}

	public void startTime() {
		time.reset();
		time.start();
	}

	public double getTime() {
		return time.get();
	}

	/******************************************************************
	 * Sets the default command for the subsystem This command is returned to
	 * after any other command finishes
	 ******************************************************************/
	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new ManualDrive());
	}

}