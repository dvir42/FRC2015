package org.usfirst.frc.team2212.robot.commands;

import static org.usfirst.frc.team2212.robot.Robot.driveBetweenYellowTotesPID;
import static org.usfirst.frc.team2212.robot.Robot.driveTrain;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveToNextYellowTote extends Command {

	public DriveToNextYellowTote() {
		requires(driveTrain);
		requires(driveBetweenYellowTotesPID);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		driveBetweenYellowTotesPID.reset();
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		driveBetweenYellowTotesPID.doPID();
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return driveBetweenYellowTotesPID.hasArrived();
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
