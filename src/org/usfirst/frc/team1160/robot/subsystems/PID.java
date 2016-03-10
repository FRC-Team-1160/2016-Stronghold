package org.usfirst.frc.team1160.robot.subsystems;

import org.usfirst.frc.team1160.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;

public class PID extends Subsystem implements RobotMap{

	private CANTalon Motor;
	public PID(CANTalon motor){
		Motor = motor;
	    motor.changeControlMode(CANTalon.TalonControlMode.Position);
		motor.setPID(P, I, D);
		//Check This
		motor.configEncoderCodesPerRev(DT_GEAR_RATIO);

	}

	public void set(double distance){		
		Motor.set(distance);
	}
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}

	
}
