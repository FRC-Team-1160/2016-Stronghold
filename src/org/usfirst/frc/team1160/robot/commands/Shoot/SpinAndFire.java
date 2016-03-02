package org.usfirst.frc.team1160.robot.commands.Shoot;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class SpinAndFire extends CommandGroup{

	public SpinAndFire(){
		addParallel(new ProportionalSpinWheels());
		addParallel(new ReadyAimFire());
	}
}
