package boundary;

import java.util.List;

import entity.BattleState;
import entity.Combatants;
import entity.Item;
import entity.TurnSummary;
import entity.Wave;

public interface UserInterface {
	
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
	
}

