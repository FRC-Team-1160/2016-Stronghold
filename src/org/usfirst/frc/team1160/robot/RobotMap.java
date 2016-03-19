package org.usfirst.frc.team1160.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public interface RobotMap {
	public static final double TEST_DISTANCE = 9;
	
	//Joystick Buttons

	
	/************************************
	 * -----------PRACTICE------------
	 * DT_BACKRIGHT = 10;
	 * DT_FRONTRIGHT = 11;
	 * DT_BACKLEFT = 12;
	 * DT_FRONTLEFT = 13;
	 * S_FLYWHEEL_LARGE = 20;
	 * S_FLYWHEEL_SMALL = 21; 
	 * ------------FINAL---------------
	 * DT_BACKRIGHT = 10;
	 * DT_FRONTRIGHT = 11;
	 * DT_BACKLEFT = 12;
	 * DT_FRONTLEFT = 13;
	 * S_FLYWHEEL_LARGE = 20;
	 * S_FLYWHEEL_SMALL = 21;
	 ***********************************/
	//Speed Controllers
	public static final int DT_BACKRIGHT = 21;
	public static final int DT_FRONTRIGHT = 20;
	public static final int DT_BACKLEFT = 6;
	public static final int DT_FRONTLEFT = 5;
	public static final int S_FLYWHEEL_LARGE = 20;
	public static final int S_FLYWHEEL_SMALL = 21;
	public static final int SERVO = 1;
	
	//Joysticks
	public static final int AUTO_INPUT_PORT = 0;
	public static final int STICK = 1;

	
	public static final double TICKS_PER_REV = 4096;
	
	//Shooter PID
	public static final double P_CONSTANT = .000001;
	
	//Pneumatics
	public static final int COMPRESSOR = 0;
	public static final int S_PIVOT_A = 0;
	public static final int S_HOLD_B = 4;
	public static final int S_HOLD_A = 3;
	public static final int S_PIVOT_B = 7;

	public static final double px = 53;
	public static final double px_dis = 118;
	public static final double px_margin_error = 3;
		
	//PID Variables
	public static double P = 1;
	public static int I = 0;
	public static int D = 0;

    
	//Constants
	public static final double FT_TO_M= .3048;
	public static final Value EXT = DoubleSolenoid.Value.kForward;
    public static final Value RET = DoubleSolenoid.Value.kReverse;
 	public static final int HEIGHT_ACTUAL = 12; //Tape
 	public static final int WIDTH_ACTUAL = 20;  //Tape
 	public static final int DT_GEAR_RATIO = 126;//TEST AND FIND
 	
	public static final double FOCAL_X = (px*px_dis)/WIDTH_ACTUAL;

	
	//A Group
	public static final double WHEEL_DIAMETER = (8*Math.PI)/12;
	public static final double LOWBAR_DISTANCE = 4/WHEEL_DIAMETER;
	public static final double PORTCULLIS_A_DISTANCE = 2/WHEEL_DIAMETER;
	public static final double PORTCULLIS_B_DISTANCE = 3/WHEEL_DIAMETER;
	public static final double CHEVAL_A_DISTANCE = 3/WHEEL_DIAMETER;
	public static final double CHEVAL_B_DISTANCE = 3/WHEEL_DIAMETER;
	//B Group
	public static final double MOAT_DISTANCE = 4/WHEEL_DIAMETER;
	public static final double RAMPART_DISTANCE = 4/WHEEL_DIAMETER;
	//C Group
	public static final double DRAWBRIDGE_A_DISTANCE = 0/WHEEL_DIAMETER;
	public static final double DRAWBRIDGE_B_DISTANCE = 0/WHEEL_DIAMETER;
	public static final double SALLYPORT_A_DISTANCE = 0/WHEEL_DIAMETER;
	public static final double SALLYPORT_B_DISTANCE = 0/WHEEL_DIAMETER;
	//D Group
	public static final double ROUGH_DISTANCE = 4/WHEEL_DIAMETER;
	public static final double ROCK_DISTANCE = 4/WHEEL_DIAMETER;
	
	//Shooting Equation Variables
	public static final double GRAVITATIONAL_ACCEL = -32.17;
	public static final double BALL_VERTICAL_DISPLACEMENT = 6.56;
	public static final double SHOOTER_WHEEL_CIRCUMFERENCE = Math.PI/3;
	public static final double SHOOTER_ANGLE_DEGREES = 68;
	public static final double SHOOTER_ANGLE_RADIANS = Math.toRadians(SHOOTER_ANGLE_DEGREES);
	public static final double TARGET_CENTER_HEIGHT_FEET = 8.08 - (32/12);
	
	//AUTO SELECTION
	public static final int s0 = 0;
	public static final int s1 = 4;
	public static final int s2 = 3;
	public static final int s3 = 2;
	public static final int s4 = 1;
	public static final int s5 = 1000;
	public static final int s6 = 5;
	public static final int s7 = 7;
	public static final int s8 = 8;
	public static final int s9 = 12;
	public static final int s10 = 11;
	
	
}