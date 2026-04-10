package control;

import java.util.List;

import boundary.UserInterface;
import entity.BattleState;
import entity.Combatant;
import entity.Player;
import entity.actions.Action;

public class CLIDecider implements ActionDecider {
	private UserInterface userInput;
	
	public CLIDecider(UserInterface ui) {
		this.userInput = ui;
	}
	
	@Override
	public void decide(Combatant self, BattleState state) {

	    if (self instanceof Player player) {
	    	Action action = userInput.promptAction(player, state);
	        List<Combatant> targets = userInput.promptTargets(action, player, state);
	        self.setTurnData(action, targets);
	    } else {
	    	throw new IllegalArgumentException("CLIDecider can only be used by Player entities!");
	    }
	}
}
