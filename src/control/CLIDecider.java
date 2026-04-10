package control;

import java.util.List;

import boundary.UserInterface;
import entity.BattleState;
import entity.Combatant;
import entity.Player;
import entity.TurnSummary;
import entity.actions.Action;

public class CLIDecider implements ActionDecider {
	private UserInterface userInput;
	
	public CLIDecider(UserInterface ui) {
		this.userInput = ui;
	}
	
	@Override
	public TurnSummary decide(Combatant self, BattleState state) {

	    if (self instanceof Player player) {
	    	Action action = userInput.promptAction(player, state);
	    	List<Combatant> targets;
//	    	if (action.targetable) {
	    	if (true) {
		        targets = userInput.promptTargets(action, player, state);
	    	} else {
	    		targets = state.getActiveEnemies();
	    	}
	    	return action.execute(self, targets);
	    	
	    } else {
	    	throw new IllegalArgumentException("CLIDecider can only be used by Player entities!");
	    }
	}
}
