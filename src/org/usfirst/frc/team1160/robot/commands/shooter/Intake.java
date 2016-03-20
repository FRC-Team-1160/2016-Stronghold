package org.usfirst.frc.team1160.robot.commands.shooter;

import org.usfirst.frc.team1160.robot.commands.shooter.air.CradleHold;
import org.usfirst.frc.team1160.robot.commands.shooter.air.PickupPosition;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Intake extends CommandGroup {
	public Intake(){
		addSequential(new CradleHold());
		addSequential(new PickupPosition());
		addSequential(new SpinWheels(1000, 10));
		// ^ these are placeholder values ^ //
	}
}
