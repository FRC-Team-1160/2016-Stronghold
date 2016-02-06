package org.usfirst.frc.team1160.robot;

import org.usfirst.frc.team1160.robot.commands.auto.LowBar;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;

public class AutoSelection {
	
	boolean[] on;
	int[] flipped = {0,0};
	
	public AutoSelection(Joystick input){
		on = new boolean[input.getButtonCount()];
		
		for(int count = 0; count < input.getButtonCount(); count++){
			on[count] = input.getRawButton(count);
			if(flipped[0] == 0 && on[count]){
				flipped[0] = count;
			}
			else if(on[count]){
				flipped[1] = count;
				return;
			}
		}
		
	}
	
	public Command picker(){
		return new LowBar();
	}
	
}
