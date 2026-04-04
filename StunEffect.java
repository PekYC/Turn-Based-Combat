package com.combat.entity.effect;

import com.combat.entity.combatant.Combatant;

public class StunEffect implements StatusEffect {

    private int turnsRemaining = 2;

    @Override
    public String getName() { return "Stun"; }

    @Override
    public void apply(Combatant target) {
        // BattleEngine checks for stun before letting combatant act.
        turnsRemaining--;
    }

    @Override
    public void remove(Combatant target) {
        // No stat to revert for stun.
    }

    @Override
    public boolean isExpired() { return turnsRemaining <= 0; }

    @Override
    public String getDescription() {
        return "Stunned — cannot act (" + turnsRemaining + " turn(s) remaining)";
    }
}
