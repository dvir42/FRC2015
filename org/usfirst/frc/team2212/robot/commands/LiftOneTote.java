package org.usfirst.frc.team2212.robot.commands;

import static org.usfirst.frc.team2212.robot.Robot.lifter;

import org.usfirst.frc.team2212.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class LiftOneTote extends Command {

	public LiftOneTote() {
		requires(lifter);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		setTimeout(RobotMap.SECONDS_TO_LIFT_ONE_TOTE);
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		lifter.up();
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return isTimedOut();
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		lifter.stopY();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		end();
	}

}
