package org.usfirst.frc.team1160.robot.subsystems;

import java.io.IOException;

import org.usfirst.frc.team1160.robot.RobotMap;

import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Vision implements RobotMap {

	private static Vision instance;

	private double[]  width, centerX, defaultValue;
	private double distance, alignmentCenterX, abc;
	private int index;
	public NetworkTable table;
	private final NetworkTable grip = NetworkTable.getTable("grip");

	public static Vision getInstance() {
		if (instance == null) {
			instance = new Vision();
		}
		return instance;
	}

	private Vision() {
		table = NetworkTable.getTable("GRIP/myContoursReport");
		defaultValue = new double[0];
		centerX = new double[defaultValue.length];
		runGrip();
	}

	public boolean aligned() {
		table = NetworkTable.getTable("GRIP/myContoursReport");
		centerX = table.getNumberArray("centerX", defaultValue);

		if (centerX[0] - 160 <= Math.abs(10)) {
			return true;
		}

		return false;
	}

	public boolean alignCheck() {
		/*
		table = NetworkTable.getTable("GRIP/myContoursReport");
		centerX = table.getNumberArray("centerX", defaultValue);
		centerY = table.getNumberArray("centerY", defaultValue);
		alignmentCenterX = (X_MAX + X_MIN) / 2;

		if (centerX.length > 1) {
			for (int i = 0; i < centerX.length; i++) {
				if (Math.abs(centerX[i] - alignmentCenterX) < Math.abs(centerX[0] - alignmentCenterX)) {
					centerX[0] = centerX[i];
				}
			}
		}

		System.out.println(centerX[0]);
		if (centerX[0] <= X_MAX && centerX[0] >= X_MIN) {
			System.out.println("Aligned");
			return true;
		}
		return false;
		*/
		return true;
	}

	public int getAlign() {
		/*
		table = NetworkTable.getTable("GRIP/myContoursReport");
		centerX = table.getNumberArray("centerX", defaultValue);
		alignmentCenterX = (X_MAX + X_MIN) / 2;

		
		if (centerX.length > 1) {
			for (int i = 0; i < centerX.length; i++) {
				if (Math.abs(centerX[i] - alignmentCenterX) < Math.abs(centerX[0] - alignmentCenterX)) {
					centerX[0] = centerX[i];
				}
			}
		}

		if (centerX[0] < alignmentCenterX - px_margin_error) {
			return 1;
		}

		else if (centerX[0] > alignmentCenterX + px_margin_error) {
			return 2;
		} else {
			*/
			return 0;
		}

	public void runGrip() {
	        /* Run GRIP in a new process */
	        try {
	            new ProcessBuilder("/home/lvuser/grip").inheritIO().start();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	
	/**************************************************************************************************
	 * http://www.pyimagesearch.com/2015/01/19/find-distance-camera-objectmarker
	 * -using-python-opencv/ Basically fractions: uses apparent size of image
	 * (pixels) uses actual size of object (inches) uses focal length of camera
	 * (preset conditions)
	 **************************************************************************************************/
	public double getDistance() {
		width = NetworkTable.getTable("GRIP").getNumberArray("targets/width", defaultValue);
		centerX = table.getNumberArray("centerX", defaultValue);
		
		table.putNumber("borked? ", 8732);
		
		for (double area : NetworkTable.getTable("GRIP").getNumberArray("targets/width", new double[0])) {
		    //System.out.println("Got contour with width=" + area);
		}
		//System.out.println("size of networktable array: " + NetworkTable.getTable("GRIP").getNumberArray("targets/width", new double[0]).length);
		
		//alignmentCenterX = (X_MAX + X_MIN) / 2;
		
		if(width.length == 0){
			//System.out.println("HAH BORKED");
			return 7;
		}

		for (int i = 0; i < centerX.length; i++) {
			if (Math.abs(centerX[i] - alignmentCenterX) < Math.abs(centerX[0] - alignmentCenterX)) {
				index = i;
			}
		}

		if(width.length == 0){
			System.out.println("nooooo :(");
			return 7;
		}
		
		System.out.println(width[0]);
		distance = FOCAL_X * WIDTH_ACTUAL / width[0];
		SmartDashboard.putNumber("Distance Recorded as: ", distance / 12);
		//System.out.println("distance: " + distance / 12);
		return distance / 12;
	}

	// Calculates the needed velocity for the ball
	private double velocity(double distance) {
		double angleSec = 1 / Math.cos(SHOOTER_ANGLE_RADIANS);
		double velocity = FT_TO_M * (distance * angleSec * Math.sqrt((GRAVITATIONAL_ACCEL)
				/ (2 * (BALL_VERTICAL_DISPLACEMENT - distance * Math.tan(SHOOTER_ANGLE_RADIANS)))));
		return velocity;
	}

	// Calculates rpm needed to achieve said speed
	private double speedFromDistance(double distance) {
		return this.velocity(distance)*60/SHOOTER_WHEEL_CIRCUMFERENCE;
	}
	
	// Accounts for loss of energy from ball contacting fly wheels
	private double addEnergy(double distance) {
		// Calculated on wolfram alpha
		// Update when shoot angle changes
		double wolframConstant = 102.788;
		
		return speedFromDistance(distance) 
				+ wolframConstant 
				* velocity(distance)
				* 1.25;
	}
	
	public double neededRpm(){
		return addEnergy(getDistance());
	}

}
