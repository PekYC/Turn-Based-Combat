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
<<<<<<< HEAD
	
	void displayLoadingScreen();
	
	int promptDifficultySelection();
	
	Combatants promptCharacterSelection();
	
	List<Item> promptItemSelection();
	
	void displayBattleState(Combatants player, List <Combatants> enemies, int roundNumber); 
	
	int promptPlayerAction();
	
	Item promptItemUsage(List<Item> inventory);
	
	void displayVictoryScreen(int remainingHp, int totalRounds);
	
	void displayDefeatScreen(int enemiesRemaining, int totalRounds);
	
	void displayMessage(String message);
	
	void endOfBattleReport(BattleState gameState);
	
	void display(TurnSummary turnSummary);
	
	void display (Wave wave);
	
	void display(BattleState gamestate);
	
=======
    
    void displayLoadingScreen();
    
    int promptDifficultySelection();
    
    Player promptCharacterSelection();
    
    List<Item> promptItemSelection();
    
    Action promptAction(Player player, BattleState state);
    
    List<Combatant> promptTargets(Action action, BattleState state);
    
    void display(BattleState state);
    
    void display(TurnSummary turnSummary);
    
    void display(Wave wave);
    
    void displayMessage(String message);
    
    void endOfBattleReport(BattleState state);
>>>>>>> branch 'main' of https://github.com/PekYC/Turn-Based-Combat.git
}

