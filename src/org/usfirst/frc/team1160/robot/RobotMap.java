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

}