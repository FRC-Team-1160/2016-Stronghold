
package org.usfirst.frc.team1160.robot;

import org.usfirst.frc.team1160.robot.commands.auto.UnevenTerrain;
import org.usfirst.frc.team1160.robot.subsystems.DriveTrain;
import org.usfirst.frc.team1160.robot.subsystems.Shooter;
import org.usfirst.frc.team1160.robot.subsystems.Vision;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;


public class Robot extends IterativeRobot implements RobotMap{

	public static OI oi;
	public static DriveTrain dt;
	public static Shooter shoot;
	public static Vision see;
	public static DeployConfirm dc;
	public static AutoSelection autochoose;

    Command autonomousCommand;


    public void robotInit() {
    	dt = DriveTrain.getInstance();
//    	shoot = Shooter.getInstance();
//   	see = Vision.getInstance();
//		air = Pneumatics.getInstance();
   		oi = OI.getInstance();
		dc = new DeployConfirm();
		
    }

    public void disabledInit(){

    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select between different autonomous modes
	 * using the dashboard. The sendable chooser code works with the Java SmartDashboard. If you prefer the LabVIEW
	 * Dashboard, remove all of the chooser code and uncomment the getString code to get the auto name from the text box
	 * below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the chooser code above (like the commented example)
	 * or additional comparisons to the switch structure below with additional strings & commands.
	 */
    public void autonomousInit() {
    	dt.resetPos();
        autonomousCommand = new UnevenTerrain();
        autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
      Scheduler.getInstance().run();
    }

    public void teleopInit() {
        if (autonomousCommand != null) autonomousCommand.cancel();
        dt.setManual();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
    	//System.out.println("oh yes");
        Scheduler.getInstance().run();
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
