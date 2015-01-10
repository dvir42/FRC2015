package org.usfirst.frc.team2212.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Lifter extends Subsystem {

	private final Relay ymotor, xmotor;
	private final DigitalInput arrivedUp, arrivedDown, opened, closed;

	public Lifter(Relay ymotor, Relay xmotor, DigitalInput arrivedUp,
			DigitalInput arrivedDown, DigitalInput opened, DigitalInput closed) {
		this.ymotor = ymotor;
		this.xmotor = xmotor;
		this.arrivedUp = arrivedUp;
		this.arrivedDown = arrivedDown;
		this.opened = opened;
		this.closed = closed;
	}

	public Lifter(int ymotorPort, int xmotorPort, int arrivedUpPort,
			int arrivedDownPort, int openedPort, int closedPort) {
		this(new Relay(ymotorPort), new Relay(xmotorPort), new DigitalInput(
				arrivedUpPort), new DigitalInput(arrivedDownPort),
				new DigitalInput(openedPort), new DigitalInput(closedPort));
	}

	public void up() {
		ymotor.set(Relay.Value.kForward);
	}

	public void down() {
		ymotor.set(Relay.Value.kReverse);
	}

	public void stopY() {
		ymotor.set(Relay.Value.kOff);
	}

	public void open() {
		xmotor.set(Relay.Value.kForward);
	}

	public void close() {
		xmotor.set(Relay.Value.kReverse);
	}

	public void stopX() {
		xmotor.set(Relay.Value.kOff);
	}

	public boolean arrivedAtTop() {
		return arrivedUp.get();
	}

	public boolean arrivedAtBottom() {
		return arrivedDown.get();
	}

	public boolean opened() {
		return opened.get();
	}

	public boolean closed() {
		return closed.get();
	}

	@Override
	public void initDefaultCommand() {
	}

}
