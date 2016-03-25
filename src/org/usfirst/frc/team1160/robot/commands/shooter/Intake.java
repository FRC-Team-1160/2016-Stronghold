
package org.usfirst.frc.team1160.robot.commands.shooter;

import org.usfirst.frc.team1160.robot.RobotMap;
import org.usfirst.frc.team1160.robot.commands.shooter.air.CradleHold;
import org.usfirst.frc.team1160.robot.commands.shooter.air.PickupPosition;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Intake extends CommandGroup implements RobotMap{
	public Intake(){
		addSequential(new CradleHold());
		addSequential(new PickupPosition());
		addSequential(new RollIn(-INTAKE_RPM, INTAKE_RPM_ERR));
		// ^ these are placeholder values ^ //
	}
}
