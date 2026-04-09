package boundary;

import java.util.List;
import entity.BattleState;
import entity.Combatants;
import entity.Item;
import entity.TurnSummary;
import entity.Wave;
import entity.actions.Action;

public interface UserInterface {
    
    void displayLoadingScreen();
    
    int promptDifficultySelection();
    
    Combatants promptCharacterSelection();
    
    List<Item> promptItemSelection();
    
    Action promptAction(Combatants player, BattleState state);
    
    List<Combatants> promptTargets(Action action, Combatants player, BattleState state);
    
    void display(BattleState state);
    
    void display(TurnSummary turnSummary);
    
    void display(Wave wave);
    
    void displayMessage(String message);
    
    void endOfBattleReport(BattleState state);
}

