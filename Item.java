package com.combat.entity.item;

import com.combat.entity.combatant.Combatant;
import com.combat.entity.combatant.Player;
import java.util.List;

/**
 * Item interface — OCP: new items can be added without modifying existing logic.
 * ISP: only use() is required; items don't share unneeded behaviours.
 */
public interface Item {
    String getName();
    String getDescription();
    void use(Player user, List<Combatant> allCombatants);
}
