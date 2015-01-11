package org.usfirst.frc.team2212.robot.subsystems;

import org.usfirst.frc.team2212.robot.RobotMap;
import org.usfirst.frc.team2212.robot.commands.DriveYX;

import driveStuff.Gearbox;
import driveStuff.PIDIn;
import driveStuff.PIDOut;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveTrain extends Subsystem implements PIDIn, PIDOut {

	private final Gearbox left, right;
	private final Victor front, rear;
	private final Encoder encoder;

	public DriveTrain(Gearbox left, Gearbox right, Victor front, Victor rear,
			Encoder encoder) {
		this.left = left;
		this.right = right;
		this.front = front;
		this.rear = rear;
		this.encoder = encoder;
	}

	public DriveTrain(int leftFrontPort, int leftBackPort, int rightFrontPort,
			int rightBackPort, int frontPort, int rearPort, int encoderPot1,
			int encoderPort2) {
		this(new Gearbox(leftFrontPort, leftBackPort), new Gearbox(
				rightFrontPort, rightBackPort), new Victor(frontPort),
				new Victor(rearPort), new Encoder(encoderPot1, encoderPort2));
	}

	public void moveYX(double speedY, double speedX) {
		left.set(speedY);
		front.set(speedX);
		right.set(-speedY);
		rear.set(-speedX);
	}

	public void rotate(double speed) {
		left.set(speed);
		front.set(speed);
		right.set(speed);
		rear.set(speed);
	}

	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new DriveYX());
	}

	@Override
	public void set(double output, String name) {
		if (name.equals("DriveToNextYellowTote"))
			moveYX(0, output);
		else if (name.equals("DriveToAutonomousZone")
				|| name.equals("DriveBackALittle"))
			moveYX(output, 0);
	}

	@Override
	public double get() {
		return encoder.get() * RobotMap.METERS_PER_ENCODER_TICK;
	}

}
