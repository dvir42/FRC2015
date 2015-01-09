package org.usfirst.frc.team2212.robot;

import org.usfirst.frc.team2212.robot.commands.DriveRotate;
import org.usfirst.frc.team2212.robot.commands.LifterDown;
import org.usfirst.frc.team2212.robot.commands.LifterUp;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI extends JoystickMap {

	public OI() {
		ROTATE_BUTTON.whileHeld(new DriveRotate());
		LIFTER_UP_BUTTON.whileHeld(new LifterUp());
		LIFTER_DOWN_BUTTON.whileHeld(new LifterDown());
	}

	public double getY() {
		return DRIVER_JOYSTICK.getY();
	}

	public double getX() {
		return DRIVER_JOYSTICK.getX();
	}

}
