package org.usfirst.frc.team1160.robot.commands.auto;

import org.usfirst.frc.team1160.robot.RobotMap;
import org.usfirst.frc.team1160.robot.commands.Drive;
import org.usfirst.frc.team1160.robot.commands.Rotate;
import org.usfirst.frc.team1160.robot.commands.Wait;
import org.usfirst.frc.team1160.robot.commands.Shoot.FireSequence;
import org.usfirst.frc.team1160.robot.commands.air.PickupPosition;
import org.usfirst.frc.team1160.robot.commands.air.ShootPosition;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Portcullis extends CommandGroup implements RobotMap{
    
    public  Portcullis(double rotationTime, boolean turnDirection) {
    	addSequential(new PickupPosition());
    	addSequential(new Wait(1));
    	addSequential(new Drive(PORTCULLIS_A_DISTANCE));
    	addSequential(new ShootPosition());
    	addSequential(new Drive(PORTCULLIS_B_DISTANCE));
    	//addSequential(new Rotate(rotationTime,turnDirection));
    	//addSequential(new FireSequence());

    }
}
