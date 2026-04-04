package com.combat.entity.item;

import com.combat.entity.combatant.Combatant;
import com.combat.entity.combatant.Player;
import com.combat.entity.effect.SmokeBombEffect;
import com.combat.boundary.GameCLI;
import java.util.List;

/** Smoke Bomb: enemy attacks deal 0 damage for current turn and next turn. */
public class SmokeBomb implements Item {

    @Override
    public String getName() { return "Smoke Bomb"; }

    @Override
    public String getDescription() { return "Enemy attacks deal 0 damage for 2 turns"; }

    @Override
    public void use(Player user, List<Combatant> allCombatants) {
        user.removeEffect("SmokeBomb"); // prevent duplicate stacking
        user.addStatusEffect(new SmokeBombEffect());
        GameCLI.getInstance().print(user.getName() + " used Smoke Bomb! Enemy attacks deal 0 damage this turn and next.");
    }
}
