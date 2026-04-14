package entity.actions;

import entity.Combatant;
import entity.TurnSummary;
import entity.ActionType;
import java.util.List;

public class BasicAttack extends Action {
    public BasicAttack() {
		super("Attack", TargetType.SINGLE);
		// TODO Auto-generated constructor stub
	}

	@Override
    public TurnSummary execute(Combatant user, List<Combatant> targets) {
    	Combatant target = targets.get(0);
        int initialHP = target.getHp();
        int rawDamage = user.getAttack();
        int damageDealt = target.receiveDamage(rawDamage);
        int finalHP = target.getHp();
        int mitigated = rawDamage - damageDealt;

        return new TurnSummary(
            user.getName(),
            target.getName(),
            ActionType.BASIC_ATTACK,
            damageDealt,
            0,
            false,
            !target.isAlive(),
            false,
            initialHP,
            finalHP,
            rawDamage,
            mitigated
        );
    }
}