package entity;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BattleState {
	private Integer roundCount = 1;
	private Level level;
	private Queue<Wave> waveQueue;
	private Wave activeWave;
	private Combatants player;
	private enum currentStatus {
		CONTINUE,
		WAVE_CLEARED,
		DEFEATED,
		VICTORY
	}
	
	public BattleState(Level l, Combatants player) {
		this.level = l;
		this.waveQueue = new LinkedList<>(level.getWaves());
		this.activeWave = waveQueue.poll();
		this.player = player;
	}

	public void incrementRound() {
		roundCount++;
	}
	
	public currentStatus getStatus() {
		if (!player.isAlive()) {
			return currentStatus.DEFEATED;
		}
		
		if (activeWave.isDefeated) {
			if (waveQueue.isEmpty()) {
				return currentStatus.VICTORY;
			} else {
				return currentStatus.WAVE_CLEARED;
			}
		}
		
		return currentStatus.CONTINUE;
		
	}
	
	public Wave getActiveWave() {
		return activeWave;
	}
	
	public Wave spawnNextWave() {
		return waveQueue.poll();
	}
	
}
