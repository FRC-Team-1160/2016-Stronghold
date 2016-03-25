package org.usfirst.frc.team1160.robot.commands.shooter;

import org.usfirst.frc.team1160.robot.OI;
import org.usfirst.frc.team1160.robot.Robot;
import org.usfirst.frc.team1160.robot.commands.shooter.air.CradleHold;
import org.usfirst.frc.team1160.robot.commands.shooter.air.CradleShoot;
import org.usfirst.frc.team1160.robot.commands.shooter.air.ShootPosition;
import org.usfirst.frc.team1160.robot.subsystems.Vision;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

public class ShootSequence extends CommandGroup {
	double targetRpm;
	public ShootSequence(){
		
		targetRpm = Robot.see.neededRpm();
		
		addSequential(new CradleHold());
		addSequential(new ShootPosition());
		addSequential(new SpinWheels(this.targetRpm, 50));
		addSequential(new CradleShoot());
		addSequential(new WaitCommand(1));
		addSequential(new StopWheel());
		addSequential(new CradleHold());
	}
}