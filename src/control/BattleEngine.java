package control;

import boundary.UserInterface;
import entity.BattleState;

public class BattleEngine {
	private BattleState state;
	private UserInterface ui;
	
	public BattleEngine(BattleState state, UserInterface ui) {
		this.state = state;
		this.ui = ui;
	}
	
	
}
