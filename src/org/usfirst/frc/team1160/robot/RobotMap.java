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
	public static final int TEST = 1;
	public static final int SEE = 2;
	public static final int INTAKE = 3;
	public static final int CRA_UP = 5;
	public static final int CRA_DOWN = 4;
	public static final int STOP = 6;
	public static final int PIVOT_DOWN = 7;
	public static final int PIVOT_UP = 8;
	public static final int FIRE = 9;
	public static final int SEE_BUTTON = 11;
	
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
	public static final int DT_BACKRIGHT = 1;
	public static final int DT_FRONTRIGHT = 3;
	public static final int DT_BACKLEFT = 2;
	public static final int DT_FRONTLEFT = 0;
	public static final int S_FLYWHEEL_LARGE = 20;
	public static final int S_FLYWHEEL_SMALL = 21;
	public static final int SERVO = 1;
	
	//Joysticks
	public static final int AUTO_INPUT_PORT = 0;
	public static final int STICK = 1;
	
	//Gyro
	public static final int GYRO = 0;
	//Shooter Speeds
	public static final double FIRE_BIG = 1;
	public static final double INTAKE_SPEED = .3;
	public static final double FIRING_TIME = 3;
	public static final double MAX_RPM = 3100;
	public static final double TICKS_PER_REV = 4096;
	
	
	//Shooter PID
	public static final double P_CONSTANT = .000001;
	
	//Pneumatics
	public static final int COMPRESSOR = 0;
	public static final int S_PIVOT_A = 0;
	public static final int S_HOLD_B = 4;
	public static final int S_HOLD_A = 3;
	public static final int S_PIVOT_B = 7;
		
    //Targeting Variables
    public static final int X_MAX = 165;
	public static final int X_MIN = 155;
	public static final int Y_MAX = 240;
	public static final int Y_MIN = 0;
	public static final double px = 53;
	public static final double px_dis = 118;
	public static final double px_margin_error = 3;
		
	//PID Variables
	public static double P = 1;
	public static int I = 0;
	public static int D = 0;
	
	//Power
	public static final int P_MOTOR_BL = 0;
    public static final int P_MOTOR_BR = 15;
    public static final int P_MOTOR_FL = 1;
    public static final int P_MOTOR_FR = 14;
    public static final int P_MOTOR_TOP = 12;
    public static final int P_MOTOR_BOT = 3;
    public static final int P_MOTOR_CLIMBLEFT = 2;
    public static final int P_MOTOR_CLIMBRIGHT = 13;
    
	//Constants
	public static final double FT_TO_M= .3048;
	public static final Value EXT = DoubleSolenoid.Value.kForward;
    public static final Value RET = DoubleSolenoid.Value.kReverse;
 	public static final int HEIGHT_ACTUAL = 12; //Tape
 	public static final int WIDTH_ACTUAL = 20;  //Tape
 	public static final int DT_GEAR_RATIO = 126;//TEST AND FIND
 	
	public static final double FOCAL_X = (px*px_dis)/WIDTH_ACTUAL;

 	
 	//FIND THESE ALL
		//Note:  B distances may not be needed
	
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

	//Autonomous Rotation times 
		// FIND THESE
	public static final double A_TIME = 1.5;
	public static final double B_TIME = 0.75;
	public static final double C_TIME = 0;
	public static final double D_TIME = 0.75;
	public static final double E_TIME = 1.5;
	public static final double AUTO_TIMEOUT = 2;//This should be good enough, but check
	
	//Shooting Equation Variables
	public static final double GRAVITATIONAL_ACCEL = -32.17;
	public static final double BALL_VERTICAL_DISPLACEMENT = 6.56;
	public static final double SHOOTER_WHEEL_CIRCUMFERENCE = Math.PI/3;
	public static final double SHOOTER_ANGLE_DEGREES = 68;
	public static final double SHOOTER_ANGLE_RADIANS = Math.toRadians(SHOOTER_ANGLE_DEGREES);
	public static final double TARGET_CENTER_HEIGHT_FEET = 8.08 - (32/12);
	
	//Image Boundaries
	public static final int X_MAX_BOUND = 320;
	public static final int X_MIN_BOUND = 0;
	public static final int Y_MAX_BOUND = 240;
	public static final int Y_MIN_BOUND = 0;
	public static final int HALF_Y_MAX_BOUND = Y_MAX_BOUND/2;
	
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