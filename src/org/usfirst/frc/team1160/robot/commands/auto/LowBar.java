package org.usfirst.frc.team1160.robot.commands.auto;

import org.usfirst.frc.team1160.robot.RobotMap;
import org.usfirst.frc.team1160.robot.commands.Drive;
import org.usfirst.frc.team1160.robot.commands.Rotate;
import org.usfirst.frc.team1160.robot.commands.Wait;
import org.usfirst.frc.team1160.robot.commands.Shoot.FireSequence;
import org.usfirst.frc.team1160.robot.commands.air.PickupPosition;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class LowBar extends CommandGroup implements RobotMap{
    
    public  LowBar() {
    	addSequential(new PickupPosition());
    	addSequential(new Wait(1));
    	addSequential(new Drive(LOWBAR_DISTANCE));
    	//addSequential(new Rotate(A_TIME, false));
    	//addSequential(new FireSequence());

    }
}
