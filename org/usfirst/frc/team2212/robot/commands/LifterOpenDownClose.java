package org.usfirst.frc.team2212.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LifterOpenDownClose extends CommandGroup {

	public LifterOpenDownClose() {
		addSequential(new OpenLifter());
		addSequential(new LifterDown());
		addSequential(new CloseLifter());
	}

}
