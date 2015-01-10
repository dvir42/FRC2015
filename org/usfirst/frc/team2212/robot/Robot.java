package org.usfirst.frc.team2212.robot;

import org.usfirst.frc.team2212.robot.commands.Autonomous;
import org.usfirst.frc.team2212.robot.subsystems.DriveTrain;
import org.usfirst.frc.team2212.robot.subsystems.Lifter;
import org.usfirst.frc.team2212.robot.subsystems.PID;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static DriveTrain driveTrain;
	public static PID driveBetweenYellowTotesPID;
	public static PID driveToAutonomousZonePID;
	public static PID driveBackALittlePID;
	public static Lifter lifter;
	public static OI oi;

	Command autonomousCommand;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		oi = new OI();
		driveTrain = new DriveTrain(RobotMap.FRONT_LEFT_VICTOR_PORT,
				RobotMap.BACK_LEFT_VICTOR_PORT,
				RobotMap.FRONT_RIGHT_VICTOR_PORT,
				RobotMap.BACK_RIGHT_VICTOR_PORT, RobotMap.FRONT_VICTOR_PORT,
				RobotMap.REAR_VICTOR_PORT, RobotMap.ENCODER_PORT_1,
				RobotMap.ENCODER_PORT_2);
		driveBetweenYellowTotesPID = new PID(
				RobotMap.METERS_BETWEEN_YELLOW_TOTES, RobotMap.KP, RobotMap.KI,
				RobotMap.KD, RobotMap.DT, RobotMap.THRESHOLD, driveTrain,
				driveTrain);
		driveToAutonomousZonePID = new PID(RobotMap.METERS_TO_AUTONOMOUS_ZONE,
				RobotMap.KP, RobotMap.KI, RobotMap.KD, RobotMap.DT,
				RobotMap.THRESHOLD, driveTrain, driveTrain);
		driveBackALittlePID = new PID(
				RobotMap.METERS_TO_GO_BACK_AFTER_PUTTING_DOWN_A_STACK,
				RobotMap.KP, RobotMap.KI, RobotMap.KD, RobotMap.DT,
				RobotMap.THRESHOLD, driveTrain, driveTrain);
		lifter = new Lifter(RobotMap.LIFTER_YRELAY_PORT,
				RobotMap.LIFTER_XRELAY_PORT, RobotMap.LIFTER_UPPER_DI_PORT,
				RobotMap.LIFTER_LOWER_DI_PORT, RobotMap.LIFTER_OPENED_DI_PORT,
				RobotMap.LIFTER_CLOSED_DI_PORT);
		// instantiate the command used for the autonomous period
		autonomousCommand = new Autonomous();
	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void autonomousInit() {
		// schedule the autonomous command (example)
		if (autonomousCommand != null)
			autonomousCommand.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null)
			autonomousCommand.cancel();
	}

	/**
	 * This function is called when the disabled button is hit. You can use it
	 * to reset subsystems before shutting down.
	 */
	@Override
	public void disabledInit() {

	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}

}
