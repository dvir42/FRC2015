package driveStuff;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.VictorSP;

public class Gearbox implements SpeedController {

	VictorSP front, back;

	public Gearbox(VictorSP front, VictorSP back) {
		this.front = front;
		this.back = back;
	}

	public Gearbox(int frontPort, int backPort) {
		this(new VictorSP(frontPort), new VictorSP(backPort));
	}

	@Override
	public void pidWrite(double output) {
		front.pidWrite(output);
		back.pidWrite(output);
	}

	@Override
	public double get() {
		return front.get();
	}

	@SuppressWarnings("deprecation")
	@Override
	public void set(double speed, byte syncGroup) {
		front.set(speed, syncGroup);
		back.set(speed, syncGroup);
	}

	@Override
	public void set(double speed) {
		front.set(speed);
		back.set(speed);
	}

	@Override
	public void disable() {
		front.disable();
		back.disable();
	}

}
