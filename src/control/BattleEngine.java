package control;

import java.util.List;

import boundary.UserInterface;
import entity.BattleState;
import entity.Combatants;

public class BattleEngine {
	private BattleState state;
	private UserInterface ui;
	private TurnOrderStrategy orderStrategy;
	
	public BattleEngine(BattleState state, UserInterface ui, TurnOrderStrategy os) {
		this.state = state;
		this.ui = ui;
		this.orderStrategy = os;
	}
	
	private void endRound() {
		state.incrementRound();
		ui.display(state);
	}
	
	public void run() {
		while (state.getStatus() != currentStatus.DEFEATED) {
			List<Combatants> turnOrder = orderStrategy.calculateTurnOrder(state.getActiveWave());
			
			for (Combatants c : turnOrder) {
				if (c.isAlive()) {
					c.performTurn();
					TurnSummary summary = c.endTurn();
					ui.display(summary);
					
					currentStatus status = state.getStatus();
					
					if (status == currentStatus.WAVE_CLEARED) {
						state.spawnNextWave();
						ui.display(state.getActiveWave());
					} else if (status == currentStatus.DEFEATED) {
						break;
					}
				}
			}
			
			endRound();
		}
	}
	
}
