package entity;

public class ArcaneBlastEffect extends StatusEffect {

	public ArcaneBlastEffect(Combatant self) {
		super(999, "Arcane Blast Damage Boost", "Bonus danage", self);
		// TODO Auto-generated constructor stub
	}
	
	public void onApply() {
		self.changeAttack(10);
	}
	
	@Override
	public void endTurn() { }
	
	@Override
	public boolean isExpired() {
		return false;
	}

}
