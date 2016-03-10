package org.usfirst.frc.team1160.robot.subsystems;

import edu.wpi.first.wpilibj.CANTalon;

public class ModTal extends CANTalon{
	
	public ModTal(int port){
		super(port);
	}
	
	public void set(double value){
		super.set(-value);
	}

}
