package entity.effects;

public class SmokeBombEffect extends StatusEffect {
    public SmokeBombEffect() {
		super(2, "Smoke Bomb", "Smoke Bomb active - enemy attacks deal 0 damage (");
	}
    
    public int onReceivingAttack(int damage) {
    	return 0;
    }
}
