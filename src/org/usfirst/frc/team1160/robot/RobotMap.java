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
	public static final double TEST_DISTANCE = 5;
	
	//Joystick Buttons
	public static final int TEST = 1;
	public static final int SEE = 2;
	public static final int INTAKE = 3;
	public static final int CRA_UP = 4;
	public static final int CRA_DOWN = 5;
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
	public static final int DT_BACKRIGHT = 0;
	public static final int DT_FRONTRIGHT = 1;
	public static final int DT_BACKLEFT = 3;
	public static final int DT_FRONTLEFT = 2;
	public static final int S_FLYWHEEL_LARGE = 20;
	public static final int S_FLYWHEEL_SMALL = 4;
	public static final int SERVO = 1;
	
	//Joysticks
	public static final int AUTO_INPUT_PORT = 0;
	public static final int STICK = 1;
	
	//Shooter Speeds
	public static final double FIRE_BIG = 1;
<<<<<<< HEAD
	public static final double INTAKE_SPEED = -1;
	public static final double FIRING_TIME = 2.75;
=======
	public static final double INTAKE_SPEED = -.3;
	public static final double FIRING_TIME = 3;
>>>>>>> 4f01322b881aa3f02bb2a22ae3b758a055885abe
	public static final double MAX_RPM = 3100;
	public static final double TICKS_PER_REV = 4096;
	
	
	//Shooter PID
	public static final double P_CONSTANT = .0000035;
	
	//Pneumatics
	public static final int COMPRESSOR = 0;
	public static final int S_PIVOT_A = 3;
	public static final int S_HOLD_B = 0;
	public static final int S_HOLD_A = 7;
	public static final int S_PIVOT_B = 4;
	
    //Targeting Variables
    public static final int X_MAX = 320;
	public static final int X_MIN = 0;
	public static final int Y_MAX = 240;
	public static final int Y_MIN = 0;
	public static final double FOCAL_X = 360;
		
	//PID Variables
	public static final double ENC_DISTANCE_PER_PULSE = 0.005;
	//placeholders
	public static int P = 1;
	public static int I = 1;
	public static int D = 1;
	public static final int ABS_TOL = 1;
	public static double SCALE = 1;
	public static final double L_180 = 1;
	public static final double R_180 = 1;
	
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
	public static final int LOWBAR_DISTANCE = 0;
	public static final double GRAVITY = -9.8;
	public static final double SHOOT_ANGLE = 38;
	public static final double Y_DISTANCE = 2;
	public static final double IB = 0.0093;
	public static final double IW = 0.0048;
	public static final double RB = 0.18;
	public static final double FT_TO_M= .3048;
	public static final Value EXT = DoubleSolenoid.Value.kForward;
    public static final Value RET = DoubleSolenoid.Value.kReverse;
 	public static final int HEIGHT_ACTUAL = 12; //Tape
 	public static final int WIDTH_ACTUAL = 20;  //Tape
 	
	//A Group
	public static final int PORTCULLIS_A_DISTANCE = 0;
	public static final int PORTCULLIS_B_DISTANCE = 0;
	public static final int CHEVAL_A_DISTANCE = 0;
	public static final int CHEVAL_B_DISTANCE = 0;
	//B Group
	public static final int MOAT_DISTANCE = 0;
	public static final int RAMPART_DISTANCE = 0;
	//C Group
	public static final int DRAWBRIDGE_A_DISTANCE = 0;
	public static final int DRAWBRIDGE_B_DISTANCE = 0;
	public static final int SALLYPORT_A_DISTANCE = 0;
	public static final int SALLYPORT_B_DISTANCE = 0;
	//D Group
	public static final int ROUGH_DISTANCE = 0;
	public static final int ROCK_DISTANCE = 0;

	//Shooting Equation Variables
	public static final double GRAVITATIONAL_ACCEL = -32.17;
	public static final double BALL_VERTICAL_DISPLACEMENT = 6.56;
	public static final double SHOOTER_WHEEL_CIRCUMFERENCE = Math.PI/3;
	public static final double SHOOTER_ANGLE_DEGREES = 68;
	public static final double SHOOTER_ANGLE_RADIANS = Math.toRadians(SHOOTER_ANGLE_DEGREES);
	public static final double TARGET_CENTER_HEIGHT_FEET = 8.08 - (32/12);

	//Camera Variables
	public static final double CAMERA_VIEW_WIDTH_DEGREES = 63;
	public static final double CAMERA_VIEW_HEIGHT_DEGREES = 51;
	public static final double HALF_CV_HEIGHT_DEGREES = CAMERA_VIEW_HEIGHT_DEGREES/2;
	public static final double HALF_CV_HEIGHT_RADIANS = Math.toRadians(HALF_CV_HEIGHT_DEGREES);
	//placeholder
	public static final double ANGLE_FROM_GROUND = 36;
	public static final double ANGLE_FROM_GROUND_RADIANS = Math.toRadians(ANGLE_FROM_GROUND);
	
	//Image Boundaries
	public static final int X_MAX_BOUND = 320;
	public static final int X_MIN_BOUND = 0;
	public static final int Y_MAX_BOUND = 240;
	public static final int Y_MIN_BOUND = 0;
	public static final int HALF_Y_MAX_BOUND = Y_MAX_BOUND/2;
}