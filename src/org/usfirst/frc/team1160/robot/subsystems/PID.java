package org.usfirst.frc.team1160.robot.subsystems;

import org.usfirst.frc.team1160.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class PID extends Subsystem implements RobotMap {

	private CANTalon motor, fMotor;

	public PID(CANTalon lMotor, CANTalon fmotor) {
		motor = lMotor;
		fMotor = fmotor;
		motor.changeControlMode(CANTalon.TalonControlMode.Position);
		fMotor.changeControlMode(CANTalon.TalonControlMode.Follower);
		motor.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
		motor.setPID(P, I, D);
		motor.configEncoderCodesPerRev(DT_GEAR_RATIO);
	}

	public void setD(double distance) {
		fMotor.set(motor.getDeviceID());
		motor.set(distance);
	}
	
	public void deAuto(){
		motor.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
		fMotor.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
		motor.set(0);
		fMotor.set(0);
	}

	public double getPosition(){
		return motor.getPosition();
	}
	
	protected void initDefaultCommand() {
		
	}

}