package org.usfirst.frc.team1160.robot.subsystems;

import org.usfirst.frc.team1160.robot.OI;
import org.usfirst.frc.team1160.robot.RobotMap;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Vision extends Subsystem implements RobotMap{


	private static Vision instance;
	
	private double[] areas, centerY, centerX, height, width, defaultValue;
	private double theta, yPixelDisplacement, dtt, distance;
	public NetworkTable table;
	private Servo camAngle;
	
	
	public static Vision getInstance(){
		if (instance == null){
			instance = new Vision();
		}
		return instance;
	}
	
	private Vision(){
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
	
	/**************************************************************************************************
	 * http://www.pyimagesearch.com/2015/01/19/find-distance-camera-objectmarker-using-python-opencv/
	 * Basically fractions: 
	 * uses apparent size of image (pixels)
	 * uses actual size of object (inches)
	 * uses focal length of camera (preset conditions)
	 **************************************************************************************************/
	public double getDistance(){
		table = NetworkTable.getTable("GRIP/myContoursReport");
		width = table.getNumberArray("width", defaultValue);
		distance = FOCAL_X*WIDTH_ACTUAL/width[0];
		//System.out.println("Width is reported as: " + width[0] + " pixels");
		//System.out.println("Robot is: " + distance/12 + " feet away - BY WIDTH");
		SmartDashboard.putNumber("Distance Recorded as: ", distance/12);
		return distance/12;
	}
	
	public void angleAdjust(){
		System.out.println("set angle to: " + camAngle.get());
		camAngle.set(OI.getInstance().getStick().getCubeZ());
	}
	
	public void setCamAngle(double angle){
		camAngle.set(angle);
		System.out.println("Angle set to " + angle + " degrees.");
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
	
	/**************************************************************************************************
	 * Find distance by similar triangles and trig
	 * Should work, doesn't right now for some reason
	 * Need to figure out how to find theta
	 **************************************************************************************************/
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
		//setDefaultCommand(new CameraAngle());
	}

}
