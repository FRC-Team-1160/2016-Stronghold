package org.usfirst.frc.team1160.robot.subsystems;

import org.usfirst.frc.team1160.robot.OI;
import org.usfirst.frc.team1160.robot.RobotMap;
import org.usfirst.frc.team1160.robot.commands.CameraAngle;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

public class Vision extends Subsystem implements RobotMap{


	private static Vision instance;
	
	private Timer timer;
	private double[] areas, centerY, centerX, height, width, defaultValue;
	private double theta, yPixelDisplacement, dtt;
	public NetworkTable table;
	private Servo camAngle;
	
	
	public static Vision getInstance(){
		if (instance == null){
			instance = new Vision();
		}
		return instance;
	}
	
	private Vision(){
		timer = new Timer();
		table = NetworkTable.getTable("GRIP/myContoursReport");
		defaultValue = new double[0];
		camAngle = new Servo(SERVO);
		centerX = new double[defaultValue.length];
		centerY = new double [defaultValue.length];
		height = new double[defaultValue.length];
		
	}
	
	public boolean alignCheck(){
		centerX = table.getNumberArray("centerX", defaultValue);
		centerY = table.getNumberArray("centerY", defaultValue);
		
		for(int i = 0;i < centerY.length; i++){
			if (centerY[i] <= Y_MAX && centerY[i] >= Y_MIN && centerX[i] <= X_MAX && centerX[i] >= X_MIN){
				return true;			
				}
			}
			return false;
	}
	
	public void angleAdjust(){
		System.out.println("set angle to: " + camAngle.get());
		camAngle.set(OI.getInstance().getStick().getCubeZ());
	}
	
	public void visualize(){
		table = NetworkTable.getTable("GRIP/myContoursReport");
		
		double[] defaultValue = new double[0];
		areas = table.getNumberArray("area", defaultValue);
		System.out.println("areas: ");
		for (double area : areas) {
			System.out.println(area + " ");
			
		}
		centerY = table.getNumberArray("centerY", defaultValue);
		System.out.println("centerY: ");
		for (double centersY : centerY) {
			System.out.println(centersY + " ");
		}
		centerX = table.getNumberArray("centerX", defaultValue);
		System.out.println("centerX: ");
		for (double centersX : centerX) {
			System.out.println(centersX + " ");
		}
		height = table.getNumberArray("height", defaultValue);
		System.out.println("height: ");
		for (double heights : height) {
			System.out.println(heights + " ");
		}
		width = table.getNumberArray("width", defaultValue);
		System.out.println("width: ");
		for (double widths : width) {
			System.out.println(widths + " ");
		}
		System.out.println();	

	}
	
	public double getDistanceToTarget(int index){
	height = table.getNumberArray("height", defaultValue);
	centerY = table.getNumberArray("centerY", defaultValue);
		
	yPixelDisplacement = height[index] - centerY[index];
	
	theta = Math.atan((yPixelDisplacement/HALF_Y_MAX_BOUND)*Math.tan(HALF_CV_HEIGHT_RADIANS));
	dtt = TARGET_CENTER_HEIGHT_FEET/(Math.tan(ANGLE_FROM_GROUND_RADIANS + theta));
	
	System.out.println("Robot is " + dtt + " feet away from the tower.");
	
	return dtt;
	}
	
	public void testing(){
		height = table.getNumberArray("height", defaultValue);
		System.out.println("height is: " + height[defaultValue.length]);
	}
	
	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new CameraAngle());
	}

}
