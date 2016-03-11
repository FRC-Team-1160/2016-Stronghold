package org.usfirst.frc.team1160.robot;

import edu.wpi.first.wpilibj.Joystick;

public class ModifiedJoystick extends Joystick{

	public ModifiedJoystick(int port) {
		super(port);
	}
	
	public double getCubeX(){
		return Math.pow(super.getX(), 3);
	}
	public double getCubeY(){
		return Math.pow(super.getY(), 3);
	}
	public double getCubeZ(){
		return Math.pow(super.getZ(), 3);
	}
	
	public double getQuintX(){
		return Math.pow(super.getX(), 5);
	}
	public double getQuintY(){
		return Math.pow(super.getY(), 5);
	}
	public double getHalfQuintZ(){
		return (Math.pow(super.getZ(), 5)/3);
	}
	public double getModZ(){
		return Math.pow(super.getZ(), 4.2);
	}
	
	

}
