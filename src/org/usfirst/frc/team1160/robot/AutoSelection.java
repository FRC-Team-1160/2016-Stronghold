package org.usfirst.frc.team1160.robot;

import org.usfirst.frc.team1160.robot.commands.auto.Cheval;
import org.usfirst.frc.team1160.robot.commands.auto.Drawbridge;
import org.usfirst.frc.team1160.robot.commands.auto.LowBar;
import org.usfirst.frc.team1160.robot.commands.auto.Moat;
import org.usfirst.frc.team1160.robot.commands.auto.Portcullis;
import org.usfirst.frc.team1160.robot.commands.auto.Ramparts;
import org.usfirst.frc.team1160.robot.commands.auto.Rock;
import org.usfirst.frc.team1160.robot.commands.auto.Rough;
import org.usfirst.frc.team1160.robot.commands.auto.Sallyport;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;

public class AutoSelection implements RobotMap{
	
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
	 
	public Command picker(int[] switches){
		switch (switches[0]) {
		case 0: return new LowBar();
		case 1: return new Portcullis();
		case 2: return new Cheval();
		case 3: return new Moat();
		case 4: return new Ramparts();
		case 5: return new Drawbridge();
		case 6: return new Sallyport();
		case 7: return new Rough();
		case 8: return new Rock();
		}
		return null;
	}
	
}
