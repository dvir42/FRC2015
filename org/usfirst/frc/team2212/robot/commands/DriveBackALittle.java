package org.usfirst.frc.team2212.robot.commands;

import static org.usfirst.frc.team2212.robot.Robot.driveBackALittlePID;
import static org.usfirst.frc.team2212.robot.Robot.driveTrain;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveBackALittle extends Command {

	public DriveBackALittle() {
		requires(driveTrain);
		requires(driveBackALittlePID);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		driveBackALittlePID.reset();
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		driveBackALittlePID.doPID();
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return driveBackALittlePID.hasArrived();
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		driveTrain.moveYX(0, 0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		end();
	}

}
