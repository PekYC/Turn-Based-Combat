package control;

import java.util.List;

import boundary.UserInterface;
import entity.BattleState;
import entity.BattleStatus;
import entity.Combatants;
import entity.TurnSummary;

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
		while (state.getStatus() != BattleStatus.DEFEATED) {
			List<Combatants> turnOrder = orderStrategy.calculateTurnOrder(state.getActiveWave());
			
			for (Combatants c : turnOrder) {
				if (c.isAlive()) {
					c.performTurn(state);
					TurnSummary summary = c.endTurn();
					ui.display(summary);
					
					BattleStatus status = state.getStatus();
					
					if (status == BattleStatus.WAVE_CLEARED) {
						state.spawnNextWave();
						ui.display(state.getActiveWave());
					} else if (status == BattleStatus.DEFEATED) {
						break;
					}
				}
			}
			
			endRound();
		}
		
		ui.endOfBattleReport(state);
	}
	
}
