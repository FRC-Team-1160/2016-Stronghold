package org.usfirst.frc.team1160.robot.commands;

import org.usfirst.frc.team1160.robot.Robot;
import org.usfirst.frc.team1160.robot.RobotMap;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

public class Detect extends Command{

	NetworkTable table;
	int xmax,xmin;
	Timer timer;
	
	public Detect(){
		requires(Robot.see);
	}
	
	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void execute() {
		table = NetworkTable.getTable("GRIP/myContoursReport");
		
		double[] defaultValue = new double[0];
		double[] areas = table.getNumberArray("area", defaultValue);
		System.out.println("areas: ");
		for (double area : areas) {
			System.out.println(area + " ");
		}
		double[] centerY = table.getNumberArray("centerY", defaultValue);
		System.out.println("centerY: ");
		for (double centersY : centerY) {
			System.out.println(centersY + " ");
		}
		double[] centerX = table.getNumberArray("centerX", defaultValue);
		System.out.println("centerX: ");
		for (double centersX : centerX) {
			System.out.println(centersX + " ");
		}
		double[] height = table.getNumberArray("height", defaultValue);
		System.out.println("height: ");
		for (double heights : height) {
			System.out.println(heights + " ");
		}
		double[] width = table.getNumberArray("width", defaultValue);
		System.out.println("width: ");
		for (double widths : width) {
			System.out.println(widths + " ");
		}
		System.out.println();	
	}

	@Override
	protected boolean isFinished() {
		table = NetworkTable.getTable("GRIP/myContoursReport");
		double[] defaultValue = new double[0];
		timer = new Timer();
		xmax = RobotMap.X_MAX;
		xmin = RobotMap.X_MIN;
		
			double[] centerY = table.getNumberArray("centerY", defaultValue);
			
			for(int i = 0;i < centerY.length; i++){
			if (centerY[i]<=xmax && centerY[i]>= xmin){
				return true;			
				}
			}
			return false;
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		
	}
	

}
