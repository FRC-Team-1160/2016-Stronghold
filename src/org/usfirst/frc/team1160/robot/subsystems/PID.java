package org.usfirst.frc.team1160.robot.subsystems;

import org.usfirst.frc.team1160.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class PID extends Subsystem implements RobotMap {

	private CANTalon motor, fMotor;

	public PID(CANTalon lMotor, CANTalon fmotor) {
		motor =lMotor;
		fMotor = fmotor;
			motor.setPID(P, I, D);
			motor.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
			// Check This
			motor.configEncoderCodesPerRev(DT_GEAR_RATIO);	
	}

	public void setD(double distance) {
		motor.configEncoderCodesPerRev(DT_GEAR_RATIO);	
		motor.changeControlMode(CANTalon.TalonControlMode.Position);
		fMotor.changeControlMode(CANTalon.TalonControlMode.Follower);
		fMotor.set(motor.getDeviceID());
		motor.set(distance);
	}
	
	public double getWheel(){
		return motor.getPosition();
	}

	public double getPosition(){
		return motor.getPosition();
	}
	
	protected void initDefaultCommand() {
		
	}

}
