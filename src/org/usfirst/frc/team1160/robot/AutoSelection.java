package org.usfirst.frc.team1160.robot;

import org.usfirst.frc.team1160.robot.commands.auto.LowBar;

import edu.wpi.first.wpilibj.command.Command;

public class AutoSelection {
	
	public AutoSelection(){
		
	}
	
	public Command picker(){
		return new LowBar();
	}
	
}
