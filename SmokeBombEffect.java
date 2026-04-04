package com.combat.entity.effect;

import com.combat.entity.combatant.Combatant;

/**
 * Smoke Bomb: enemy attacks deal 0 damage for the current turn and the next turn.
 * BattleEngine checks hasEffect("SmokeBomb") on the player before resolving enemy attacks.
 */
public class SmokeBombEffect implements StatusEffect {

    private int turnsRemaining = 2;

    @Override
    public String getName() { return "SmokeBomb"; }

    @Override
    public void apply(Combatant target) {
        turnsRemaining--;
    }

    @Override
    public void remove(Combatant target) {
        // no stat to revert
    }

    @Override
    public boolean isExpired() { return turnsRemaining <= 0; }

    @Override
    public String getDescription() {
        return "Smoke Bomb active — enemy attacks deal 0 damage (" + turnsRemaining + " turn(s))";
    }
}
