package boundary;

import java.util.List;
import entity.BattleState;
import entity.Combatant;
import entity.Item;
import entity.TurnSummary;
import entity.Wave;
import entity.actions.Action;

public interface UserInterface {
    
    void displayLoadingScreen();
    
    int promptDifficultySelection();
    
    Combatant promptCharacterSelection();
    
    List<Item> promptItemSelection();
    
    Action promptAction(Combatant player, BattleState state);
    
    List<Combatant> promptTargets(Action action, Combatant player, BattleState state);
    
    void display(BattleState state);
    
    void display(TurnSummary turnSummary);
    
    void display(Wave wave);
    
    void displayMessage(String message);
    
    void endOfBattleReport(BattleState state);
}

