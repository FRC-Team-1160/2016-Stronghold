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
	//Constants
	public static final double INTAKE_SPEED = 0.05;
	public static final int LOWBAR_DISTANCE = 0;
	public static final double GRAVITY = -9.8;
	public static final double SHOOT_ANGLE = 38;
	public static final double Y_DISTANCE = 2;
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

	
	//Speed Controllers
	public static final int DT_FRONTLEFT = 0;
	public static final int DT_BACKLEFT = 1;
	public static final int DT_FRONTRIGHT = 2;
	public static final int DT_BACKRIGHT = 3;
	public static final int S_FLYWHEEL_LARGE = 5;
	public static final int S_FLYWHEEL_SMALL = 4;

	
	//Encoders
	public static final int PID_DT_LEFT_A = 0;
	public static final int PID_DT_LEFT_B = 1;
	public static final int PID_DT_RIGHT_A = 2;
	public static final int PID_DT_RIGHT_B = 3;
	public static final int PID_S_BIG_A = 4;
	public static final int PID_S_BIG_B = 5;
	public static final int PID_S_SMALL_A = 6;
	public static final int PID_S_SMALL_B = 7;
	
	
	//Joysticks
	public static final int TEST_STICK = 2;
	public static final int STICK = 1;
	public static final int AUTO_INPUT_PORT = 0;
	
	
	//Joystick Buttons
	public static final int SEE_BUTTON = 8;
	public static final int FIRE = 0;
	public static final int INTAKE = 2;
	public static final int PIVOT_UP = 0;
	public static final int PIVOT_DOWN = 0;
	public static final int STOP = 0;
	public static final int TEST = 1;
	
	
	//Shooter
	public static final int S_MIDDLE = 4;
	public static final int S_TOP = 5;
		//placeholder
	public static final double FIRING_TIME = 1;
	public static final double FIRING_SPEED = 1;
	
	//Shooting Equation Variables
	public static final double GRAVITATIONAL_ACCEL = -32.17;
	public static final double BALL_VERTICAL_DISPLACEMENT = 6.56;
	public static final double SHOOTER_WHEEL_CIRCUMFERENCE = Math.PI/3;
	public static final double SHOOTER_ANGLE_DEGREES = 52;
	public static final double SHOOTER_ANGLE_RADIANS = Math.toRadians(SHOOTER_ANGLE_DEGREES);
	
	//Shooter Speeds
	public static final double FIRE_BIG = 1;
	
	
	//Pneumatics
	public static final int COMPRESSOR = 0;
	public static final int S_PIVOT_A = 0;
	public static final int S_PIVOT_B = 1;
	public static final int S_HOLD_A = 2;
	public static final int S_HOLD_B = 3;
	public static final Value EXT = DoubleSolenoid.Value.kForward;
    public static final Value RET = DoubleSolenoid.Value.kReverse;
	
    
	//Vision Parameters
	
    //Targeting Variables
    public static final int X_MAX = 480;
	public static final int X_MIN = 0;
	public static final int Y_MAX = 360;
	public static final int Y_MIN = 0;
	
	//Image Boundaries
	public static final int X_MAX_BOUND = 480;
	public static final int X_MIN_BOUND = 0;
	public static final int Y_MAX_BOUND = 360;
	public static final int Y_MIN_BOUND = 0;
	public static final int HALF_Y_MAX_BOUND = Y_MAX_BOUND/2;
	
	//Camera Variables
	public static final double CAMERA_VIEW_WIDTH_DEGREES = 63;
	public static final double CAMERA_VIEW_HEIGHT_DEGREES = 51;
	public static final double HALF_CV_HEIGHT_DEGREES = CAMERA_VIEW_HEIGHT_DEGREES/2;
	public static final double HALF_CV_HEIGHT_RADIANS = Math.toRadians(HALF_CV_HEIGHT_DEGREES);
		//placeholder
	public static final double ANGLE_FROM_GROUND = 40;
	public static final double ANGLE_FROM_GROUND_RADIANS = Math.toRadians(ANGLE_FROM_GROUND);
	
	// Actual Distances
	public static final double TARGET_CENTER_HEIGHT_FEET = 8.08;
	
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
	
	public static final int P_MOTOR_BL = 13;
    public static final int P_MOTOR_BR = 14;
    public static final int P_MOTOR_FL = 12;
    public static final int P_MOTOR_FR = 15;

}