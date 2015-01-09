package org.usfirst.frc.team2212.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Lifter extends Subsystem {

	private final Relay motor;
	private final DigitalInput arrivedUp, arrivedDown;

	public Lifter(Relay motor, DigitalInput arrivedUp, DigitalInput arrivedDown) {
		this.motor = motor;
		this.arrivedUp = arrivedUp;
		this.arrivedDown = arrivedDown;
	}

	public Lifter(int motorPort, int arrivedUpPort, int arrivedDownPort) {
		this(new Relay(motorPort), new DigitalInput(arrivedUpPort),
				new DigitalInput(arrivedDownPort));
	}

	public void up() {
		motor.set(Relay.Value.kForward);
	}

	public void down() {
		motor.set(Relay.Value.kReverse);
	}

	public void stop() {
		motor.set(Relay.Value.kOff);
	}

	public boolean arrivedAtTop() {
		return arrivedUp.get();
	}

	public boolean arrivedAtBottom() {
		return arrivedDown.get();
	}

	@Override
	public void initDefaultCommand() {
	}

}
