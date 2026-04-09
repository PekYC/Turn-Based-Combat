package entity.actions;

import entity.Combatants;
import entity.TurnSummary;
import entity.ActionType;
import java.util.List;

public class ArcaneBlastAction implements Action {
    @Override
    public TurnSummary execute(Combatants user, List<Combatants> targets) {
        Combatants target = targets.get(0);
        int initialHP = target.getHp();
        int rawDamage = user.getAttack() + 20;
        int damageDealt = target.receiveDamage(rawDamage);
        int finalHP = target.getHp();
        int mitigated = rawDamage - damageDealt;

        return new TurnSummary(
            user.getName(),
            target.getName(),
            ActionType.ARCANE_BLAST,
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