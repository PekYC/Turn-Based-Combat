package entity;

public class ArcaneBlastEffect extends StatusEffect {

	public ArcaneBlastEffect() {
		super(999, "Arcane Blast Damage Boost", "Bonus danage");
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
