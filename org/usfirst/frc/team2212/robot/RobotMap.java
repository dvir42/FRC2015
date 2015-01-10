package org.usfirst.frc.team2212.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

	// Drive Ports
	public static final int FRONT_LEFT_VICTOR_PORT = -1;
	public static final int BACK_LEFT_VICTOR_PORT = -1;
	public static final int FRONT_RIGHT_VICTOR_PORT = -1;
	public static final int BACK_RIGHT_VICTOR_PORT = -1;
	public static final int FRONT_VICTOR_PORT = -1;
	public static final int REAR_VICTOR_PORT = -1;
	public static final int ENCODER_PORT_1 = -1;
	public static final int ENCODER_PORT_2 = -1;

	// Lifter Ports
	public static final int LIFTER_YRELAY_PORT = -1;
	public static final int LIFTER_XRELAY_PORT = -1;
	public static final int LIFTER_UPPER_DI_PORT = -1;
	public static final int LIFTER_LOWER_DI_PORT = -1;
	public static final int LIFTER_OPENED_DI_PORT = -1;
	public static final int LIFTER_CLOSED_DI_PORT = -1;

	// PID Constants
	public static final double KP = 0;
	public static final double KI = 0;
	public static final double KD = 0;
	public static final long DT = 100;
	public static final double THRESHOLD = 0;

	// Other Useful Stuff
	public static final double METERS_PER_ENCODER_TICK = 0;
	public static final double METERS_BETWEEN_YELLOW_TOTES = 0;
	public static final double METERS_TO_AUTONOMOUS_ZONE = 0;
	public static final double METERS_TO_GO_BACK_AFTER_PUTTING_DOWN_A_STACK = 0;
	public static final double SECONDS_TO_LIFT_ONE_TOTE = 0;
	public static final double SECONDS_TO_LIFT_A_TOTE_ENOUGH_TO_DRIVE = 0;

}
