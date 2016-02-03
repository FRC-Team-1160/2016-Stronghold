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

	//Speed Controllers
	public static int DT_FRONTLEFT = 0;
	public static int DT_BACKLEFT = 1;
	public static int DT_FRONTRIGHT = 2;
	public static int DT_BACKRIGHT = 3;
	public static int S_FLYWHEEL_LARGE = 4;
	public static int S_FLYWHEEL_SMALL = 5;

	//Encoders
	public static int PID_DT_LEFT_A = 0;
	public static int PID_DT_LEFT_B = 1;
	public static int PID_DT_RIGHT_A = 2;
	public static int PID_DT_RIGHT_B = 3;
	public static int PID_S_LARGE_A = 4;
	public static int PID_S_LARGE_B = 5;
	public static int PID_S_SMALL_A = 6;
	public static int PID_S_SMALL_B = 7;
	
	//Joysticks
	public static int STICK = 1;
	
	//Joystick Buttons
	public static int SEE_BUTTON = 8;
	
	//Shooter
	public static int S_MIDDLE = 4;
	public static int S_TOP = 5;
	
	//Pneumatics
	public static int COMPRESSOR = 0;
	public static int S_PIVOT_A = 0;
	public static int S_PIVOT_B = 1;
	public static int S_HOLD_A = 2;
	public static int S_HOLD_B = 3;
	public static final Value EXT = DoubleSolenoid.Value.kForward;
    public static final Value RET = DoubleSolenoid.Value.kReverse;
	
	//Vision Variables
	public static int X_MAX = 480;
	public static int X_MIN = 0;
}