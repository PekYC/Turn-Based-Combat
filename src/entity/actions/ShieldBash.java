package entity.actions;

import entity.Combatant;
import entity.TurnSummary;
import entity.ActionType;
import java.util.List;

public class ShieldBash implements Action {
    @Override
    public TurnSummary execute(Combatant user, List<Combatant> targets) {
        Combatant target = targets.get(0);
        int initialHP = target.getHp();
        int rawDamage = user.getAttack();
        int damageDealt = target.receiveDamage(rawDamage);
        int finalHP = target.getHp();
        int mitigated = rawDamage - damageDealt;
        
        target.setStunned(2);

        return new TurnSummary(
            user.getName(),
            target.getName(),
            ActionType.SHIELD_BASH,
            damageDealt,
            0,
            true,
            !target.isAlive(),
            false,
            initialHP,
            finalHP,
            rawDamage,
            mitigated
        );
    }
}
	