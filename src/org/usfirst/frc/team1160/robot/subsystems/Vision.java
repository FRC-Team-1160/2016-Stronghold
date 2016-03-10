package org.usfirst.frc.team1160.robot.subsystems;

import org.usfirst.frc.team1160.robot.OI;
import org.usfirst.frc.team1160.robot.RobotMap;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Vision extends Subsystem implements RobotMap {

	private static Vision instance;

	private double[] areas, centerY, centerX, height, width, defaultValue;
	private double theta, yPixelDisplacement, dtt, distance, alignmentCenterX;
	private int index;
	public NetworkTable table;

	public static Vision getInstance() {
		if (instance == null) {
			instance = new Vision();
		}
		return instance;
	}

	public boolean aligned() {
		table = NetworkTable.getTable("GRIP/myContoursReport");
		centerX = table.getNumberArray("centerX", defaultValue);

		if (centerX[0] - 160 <= Math.abs(10)) {
			return true;
		}

		return false;
	}

	private Vision() {
		table = NetworkTable.getTable("GRIP/myContoursReport");
		defaultValue = new double[0];
		centerX = new double[defaultValue.length];
		centerY = new double[defaultValue.length];
		height = new double[defaultValue.length];

	}

	public boolean alignCheck() {
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
	}

	public int getAlign() {
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
			return 0;
		}
	}

	/**************************************************************************************************
	 * http://www.pyimagesearch.com/2015/01/19/find-distance-camera-objectmarker
	 * -using-python-opencv/ Basically fractions: uses apparent size of image
	 * (pixels) uses actual size of object (inches) uses focal length of camera
	 * (preset conditions)
	 **************************************************************************************************/
	public double getDistance() {
		table = NetworkTable.getTable("GRIP/myContoursReport");
		width = table.getNumberArray("width", defaultValue);
		centerX = table.getNumberArray("centerX", defaultValue);
		alignmentCenterX = (X_MAX + X_MIN) / 2;

		for (int i = 0; i < centerX.length; i++) {
			if (Math.abs(centerX[i] - alignmentCenterX) < Math.abs(centerX[0] - alignmentCenterX)) {
				index = i;
			}
		}

		System.out.println(width[index]);
		distance = FOCAL_X * WIDTH_ACTUAL / width[0];
		// System.out.println("Width is reported as: " + width[0] + " pixels");
		// System.out.println("Robot is: " + distance/12 + " feet away - BY
		// WIDTH");
		SmartDashboard.putNumber("Distance Recorded as: ", distance / 12);
		return distance / 12;

	}

	public void visualize() {
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
	 * Find distance by similar triangles and trig Should work, doesn't right
	 * now for some reason Need to figure out how to find theta
	 **************************************************************************************************/
	public double getDistanceToTarget(int index) {
		height = table.getNumberArray("height", defaultValue);
		centerY = table.getNumberArray("centerY", defaultValue);

		yPixelDisplacement = height[index] - centerY[index];

		theta = Math.atan((yPixelDisplacement / HALF_Y_MAX_BOUND) * Math.tan(HALF_CV_HEIGHT_RADIANS));
		dtt = TARGET_CENTER_HEIGHT_FEET / (Math.tan(ANGLE_FROM_GROUND_RADIANS + theta));

		System.out.println("Robot is " + dtt + " feet away from the tower.");

		return dtt;
	}

	@Override
	protected void initDefaultCommand() {

	}

}
