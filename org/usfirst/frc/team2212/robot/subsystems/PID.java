package org.usfirst.frc.team2212.robot.subsystems;

import driveStuff.PIDIn;
import driveStuff.PIDOut;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class PID extends Subsystem {

	private final double DESTINATION, KP, KI, KD, THRESHOLD;
	private final long DT;
	private double p, i, d, error, prevError;
	private final PIDIn IN;
	private final PIDOut OUT;

	public PID(double DESTINATION, double KP, double KI, double KD, long DT,
			double THRESHOLD, PIDIn IN, PIDOut OUT) {
		this.DESTINATION = DESTINATION;
		this.KP = KP;
		this.KI = KI;
		this.KD = KD;
		this.DT = DT;
		this.THRESHOLD = THRESHOLD;
		this.IN = IN;
		this.OUT = OUT;
		reset();
	}

	public void doPID() {
		prevError = error;
		error = DESTINATION - IN.get();
		p = KP * error;
		i += KI * DT * error;
		d = KD * (prevError - error) / DT;
		OUT.set(p + i + d);
		long prevTime = System.currentTimeMillis();
		while (System.currentTimeMillis() - prevTime < DT)
			prevTime = System.currentTimeMillis();

	}

	public boolean hasArrived() {
		return Math.abs(IN.get()) < +THRESHOLD;
	}

	public void reset() {
		p = 0;
		i = 0;
		d = 0;
		error = DESTINATION - IN.get();
		prevError = error;
	}

	@Override
	public void initDefaultCommand() {
	}

}
