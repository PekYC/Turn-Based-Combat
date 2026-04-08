package boundary;

import java.util.List;
import entity.Combatants;
import entity.Wave;
import entity.BattleState;
import entity.TurnSummary;

public interface UserInterface {
	
	void displayLoadingScreen();
	
	int promptDifficultySelection();
	
	int promptCharacterSelection();
	
	List<String> promptItemSelection();
	
	void displayBattleState(Combatants player, List <Combatants> enemies, int roundNumber);
	
	int promptPlayerAction();
	
	void displayVictoryScreen(int remainingHp, int totalRounds);
	
	void displayDefeatScreen(int enemiesRemaining, int totalRounds);
	
	void displayMessage(String message);
	
	void endOfBattleReport(BattleState gameState);
	
	void display(TurnSummary turnSummary);
	
	void display (Wave wave);
	
	void display(BattleState gamestate);
	
}

