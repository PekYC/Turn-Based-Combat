package entity;

public class SmokeBombEffect extends StatusEffect {
    public SmokeBombEffect(Combatant self) {
		super(2, "Smoke Bomb", "Smoke Bomb active - enemy attacks deal 0 damage (", self);
	}
}
