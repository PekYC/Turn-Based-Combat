package entity;

public class DefendEffect extends StatusEffect {
	public DefendEffect(Combatant self) {
		super(2, "Defend", "Defending, +10 DEF", self);
	}
	
	public void onApply() {
		self.changeDefense(10);
	}
	
	public void onExpire() {
		self.changeDefense(-10);
	}
}
