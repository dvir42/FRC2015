package org.usfirst.frc.team2212.robot.commands;

import org.usfirst.frc.team2212.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LiftToteEnoughToDrive extends CommandGroup {

	public LiftToteEnoughToDrive() {
		addSequential(new CloseLifter());
		addSequential(new LifterUp(),
				RobotMap.SECONDS_TO_LIFT_A_TOTE_ENOUGH_TO_DRIVE);
	}

}
