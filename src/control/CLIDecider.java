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
	    	Action action;
	    	do {
	    		action = userInput.promptAction(player, state);
	    		if (!action.isReady()) {
	    			System.out.println("Skill is on cooldown");
	    		}
	    		
	    	} while (!action.isReady());
	    	List<Combatant> targets = switch(action.getTargeting()) {
	    		case SINGLE -> userInput.promptTargets(action, state);
	    		case MULTI -> state.getActiveEnemies();
	    		case SELF -> List.of(self);
	    	};
	    	return action.execute(self, targets);
	    	
	    } else {
	    	throw new IllegalArgumentException("CLIDecider can only be used by Player entities!");
	    }
	}
}
