package org.usfirst.frc.team2212.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class JoystickMap {

	private static final int DRIVER_JOYSTICK_PORT = 0;
	private static final int NAVIGATOR_JOYSTICK_PORT = 1;

	protected static final Joystick DRIVER_JOYSTICK = new Joystick(
			DRIVER_JOYSTICK_PORT);
	protected static final Joystick NAVIGATOR_JOYSTICK = new Joystick(
			NAVIGATOR_JOYSTICK_PORT);

	protected static final Button ROTATE_BUTTON = new JoystickButton(
			DRIVER_JOYSTICK, 1);
	protected static final Button LIFTER_UP_BUTTON = new JoystickButton(
			NAVIGATOR_JOYSTICK, 3);
	protected static final Button LIFTER_DOWN_BUTTON = new JoystickButton(
			NAVIGATOR_JOYSTICK, 2);

}
