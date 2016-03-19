package org.usfirst.frc.team1160.robot.subsystems;

import com.ni.vision.NIVision;
import com.ni.vision.NIVision.Image;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.vision.AxisCamera;

import edu.wpi.first.wpilibj.CameraServer;

public class NewVision extends Subsystem{
	
	private static NewVision instance;
	
	private AxisCamera camera;
	private Image frame;
	

	public NewVision getInstance(){
		if(instance == null){
			instance = new NewVision();
		}
		return instance;
	}
	
	private NewVision(){
		camera = new AxisCamera("10.11.60.11");
		frame = NIVision.imaqCreateImage(NIVision.ImageType.IMAGE_HSL, 0);
	}
	
	/*public Image threshold(){
		return NIVision.imaqThreshold(dest, source, rangeMin, rangeMax, useNewValue, newValue);
	}
	*/
	protected void initDefaultCommand() {
		
	}
}
