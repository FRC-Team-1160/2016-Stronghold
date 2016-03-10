package org.usfirst.frc.team1160.robot.commands.auto;

import org.usfirst.frc.team1160.robot.RobotMap;
import org.usfirst.frc.team1160.robot.commands.Drive;
import org.usfirst.frc.team1160.robot.commands.Rotate;
import org.usfirst.frc.team1160.robot.commands.Shoot.FireSequence;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Sallyport extends CommandGroup implements RobotMap{
    
    public  Sallyport(double rotationTime, boolean turnDirection) {
    	addSequential(new Drive(SALLYPORT_A_DISTANCE));
    	addSequential(new Rotate(rotationTime,turnDirection));
    	addSequential(new FireSequence());

    }
}
