package uniandes.dpoo.proyecto1.modelo;

import java.time.Duration;
import java.time.LocalDateTime;

public class Stopwatch {


	private LocalDateTime startTime;
	private Duration totalRunTime = Duration.ZERO;

	public void start() {
		startTime = LocalDateTime.now();
	}

	public void stop() {
		Duration runTime = Duration.between(startTime, LocalDateTime.now());
		totalRunTime = totalRunTime.plus(runTime);
		startTime = null;
	}

	public void pause() {
		stop();
	}

	public void resume() {
		start();
	}

	public void reset() {
		stop();
		totalRunTime = Duration.ZERO;
	}
	

	public boolean isRunning() {
		return startTime != null;
	}

	public Duration getDuration() {
		Duration currentDuration = Duration.ZERO;
		currentDuration = currentDuration.plus(totalRunTime);
		if (isRunning()) {
			Duration runTime = Duration.between(startTime, LocalDateTime.now());
			currentDuration = currentDuration.plus(runTime);
		}
		return currentDuration;

	}

}
