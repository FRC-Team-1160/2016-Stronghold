package org.usfirst.frc.team1160.robot;

import edu.wpi.first.wpilibj.Joystick;

public class ModifiedJoystick extends Joystick{

	public ModifiedJoystick(int port) {
		super(port);
	}
	
	public double getSquareX(){
		return Math.pow(super.getX(), 2);
	}	
	public double getSquareY(){
		return Math.pow(super.getY(), 2);
	}
	public double getSquareZ(){
		return Math.pow(super.getZ(), 2);
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
	
	

}
