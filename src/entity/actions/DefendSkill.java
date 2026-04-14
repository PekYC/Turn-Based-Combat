package entity.actions;


import entity.Combatant;
import entity.DefendEffect;
import entity.TurnSummary;
import entity.ActionType;
import java.util.List;

public class DefendSkill extends Action {
    public DefendSkill() {
		super("Defend", TargetType.SELF);
		// TODO Auto-generated constructor stub
	}

	@Override
    public TurnSummary execute(Combatant user, List<Combatant> targets) {
        user.applyStatus(new DefendEffect());
        
        return new TurnSummary(
            user.getName(),
            user.getName(),
            ActionType.DEFEND,
            0,
            0,
            false,
            false,
            false,
            user.getHp(),
            user.getHp(),
            0,
            0
        );
    }
}