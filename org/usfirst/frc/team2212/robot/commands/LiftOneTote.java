package org.usfirst.frc.team2212.robot.commands;

import org.usfirst.frc.team2212.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LiftOneTote extends CommandGroup {

	public LiftOneTote() {
		addSequential(new CloseLifter());
		addSequential(new LifterUp(), RobotMap.SECONDS_TO_LIFT_ONE_TOTE);
	}

}
