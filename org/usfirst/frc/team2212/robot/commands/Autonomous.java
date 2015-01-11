package org.usfirst.frc.team2212.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Autonomous extends CommandGroup {

	public Autonomous() {
		Command driveCommand;
		addSequential(new LiftToteEnoughToDrive());
		addParallel(driveCommand = new DriveToNextYellowTote());
		addSequential(new LiftOneTote());
		while (driveCommand.isRunning())
			;
		addSequential(new LifterOpenDownClose());
		addSequential(new LiftToteEnoughToDrive());
		addParallel(driveCommand = new DriveToNextYellowTote());
		addSequential(new LiftOneTote());
		while (driveCommand.isRunning())
			;
		addSequential(new LifterOpenDownClose());
		addSequential(new LiftToteEnoughToDrive());
		addSequential(new DriveToAutonomousZone());
		addSequential(new PutStack());
	}

}
