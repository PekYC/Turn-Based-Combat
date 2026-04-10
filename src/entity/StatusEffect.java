package entity;

public interface StatusEffect {
    String getName();
    void apply(Combatant target);
    void remove(Combatant target);
    boolean isExpired();
    String getDescription();
}
