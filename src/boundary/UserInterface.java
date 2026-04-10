package boundary;

import java.util.List;
import entity.BattleState;
import entity.Combatant;
import entity.Item;
import entity.Player;
import entity.TurnSummary;
import entity.Wave;
import entity.actions.Action;

public interface UserInterface {
    
    void displayLoadingScreen();
    
    int promptDifficultySelection();
    
    Player promptCharacterSelection();
    
    List<Item> promptItemSelection();
    
    Action promptAction(Player player, BattleState state);
    
    List<Combatant> promptTargets(Action action, Player player, BattleState state);
    
    void display(BattleState state);
    
    void display(TurnSummary turnSummary);
    
    void display(Wave wave);
    
    void displayMessage(String message);
    
    void endOfBattleReport(BattleState state);
}

