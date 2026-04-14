package entity;

public class DefendEffect extends StatusEffect {
	public DefendEffect() {
		super(2, "Defend", "Defending, +10 DEF");
	}
	
	public void onApply() {
		self.changeDefense(10);
	}
	
	public void onExpire() {
		self.changeDefense(-10);
	}
}
