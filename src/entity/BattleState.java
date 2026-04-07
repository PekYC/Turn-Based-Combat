package entity;

import java.util.List;

public class BattleState {
	private Integer roundCount = 1;
	private Level level;
	private Wave activeWave;

	public void incrementRound() {
		roundCount++;
	}
	
	public boolean isActiveWaveDefeated() {
		
	}
	
	public boolean isGameOver() {
		
	}
	
	public List<Combatants> getActiveWave() {
		
	}
	
}
