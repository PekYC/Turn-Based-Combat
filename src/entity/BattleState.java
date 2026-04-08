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
	
	public BattleState(Level l, Combatants player) {
		this.level = l;
		this.waveQueue = new LinkedList<>(level.getWaves());
		this.activeWave = waveQueue.poll();
		this.player = player;
	}

	public void incrementRound() {
		roundCount++;
	}
	
	public BattleStatus getStatus() {
		if (!player.isAlive()) {
			return BattleStatus.DEFEATED;
		}
		
		if (activeWave.isDefeated()) {
			if (waveQueue.isEmpty()) {
				return BattleStatus.VICTORY;
			} else {
				return BattleStatus.WAVE_CLEARED;
			}
		}
		
		return BattleStatus.CONTINUE;
		
	}
	
	public Wave getActiveWave() {
		return activeWave;
	}
	
	public List<Combatants> getActiveEnemies() {
		return activeWave.getEnemies();
	}
	
	public Wave spawnNextWave() {
		return waveQueue.poll();
	}
	
}
