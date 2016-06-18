
package org.usfirst.frc.team1160.robot.commands.shooter;

import org.usfirst.frc.team1160.robot.RobotMap;
import org.usfirst.frc.team1160.robot.commands.Wait;
import org.usfirst.frc.team1160.robot.commands.shooter.air.CradleHold;
import org.usfirst.frc.team1160.robot.commands.shooter.air.CradleShoot;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class LowGoal extends CommandGroup implements RobotMap{
	public LowGoal(){
		addSequential(new RollIn(INTAKE_RPM + 250, INTAKE_RPM_ERR));
		// ^ these are placeholder values ^ //
	}
}
