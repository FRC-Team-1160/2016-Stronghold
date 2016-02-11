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
	public static final int INTAKE_SPEED = 0;
	public static final int LOWBAR_DISTANCE = 0;
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
	public static final int S_FLYWHEEL_LARGE = 4;
	public static final int S_FLYWHEEL_SMALL = 5;

	
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
	public static final int STICK = 1;
	public static final int AUTO_INPUT_PORT = 0;
	
	
	//Joystick Buttons
	public static final int SEE_BUTTON = 8;
	public static final int FIRE = 0;
	public static final int INTAKE = 0;
	public static final int PIVOT_UP = 0;
	public static final int PIVOT_DOWN = 0;
	public static final int STOP = 0;
	
	
	//Shooter
	public static final int S_MIDDLE = 4;
	public static final int S_TOP = 5;
	
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
	
    
	//Vision Variables
	public static final int X_MAX = 480;
	public static final int X_MIN = 0;
	public static final int Y_MAX = 360;
	public static final int Y_MIN = 0;
	
	
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