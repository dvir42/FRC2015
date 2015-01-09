package org.usfirst.frc.team2212.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Autonomous extends CommandGroup {

	public Autonomous() {
		addSequential(new LiftToteEnoughToDrive());
		addParallel(new DriveToNextYellowTote());
		addSequential(new LiftOneTote());
		addSequential(new LiftToteEnoughToDrive());
		addParallel(new DriveToNextYellowTote());
		addSequential(new LiftOneTote());
		addSequential(new LiftToteEnoughToDrive());
		addSequential(new DriveToAutonomousZone());
		addSequential(new PutStack());
	}
}
