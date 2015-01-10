package org.usfirst.frc.team2212.robot.commands;

import static org.usfirst.frc.team2212.robot.Robot.lifter;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CloseLifter extends Command {

	public CloseLifter() {
		requires(lifter);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		lifter.close();
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return lifter.closed();
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		lifter.stopX();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		end();
	}

}
