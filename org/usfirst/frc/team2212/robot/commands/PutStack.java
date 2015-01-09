package org.usfirst.frc.team2212.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class PutStack extends CommandGroup {

	public PutStack() {
		addSequential(new LifterDown());
		addSequential(new DriveBackALittle());
	}
}
