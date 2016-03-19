package org.usfirst.frc.team1160.robot;

import edu.wpi.first.wpilibj.Joystick;

public class AutoSelection implements RobotMap {

	boolean[] on;
	int[] flipped = { 0, 0 };
	boolean turnDirection;
	int position;
	double rotationTime;
	
	public AutoSelection(Joystick input) {
		on = new boolean[input.getButtonCount()];

		for (int count = 0; count < input.getButtonCount(); count++) {
			on[count] = input.getRawButton(count);
			if (flipped[0] == 0 && on[count]) {
				flipped[0] = count;
			} else if (on[count]) {
				flipped[1] = count;
			}
		}
	}

}
