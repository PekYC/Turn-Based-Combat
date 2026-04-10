package entity.actions;


import entity.Combatant;
import entity.TurnSummary;
import entity.ActionType;
import java.util.List;

public class DefendSkill implements Action {
    @Override
    public TurnSummary execute(Combatant user, List<Combatant> targets) {
        user.setDefending(2);
        
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