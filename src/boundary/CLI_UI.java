package boundary;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import entity.Combatants;
import entity.Wave;
import entity.BattleState;
import entity.TurnSummary;

public class CLI_UI implements UserInterface {
	
	private Scanner scanner;
	
	public CLI_UI() {
		this.scanner = new Scanner(System.in);
	}
	
	@Override
	public void displayLoadingScreen() {
		System.out.println("=====================================");
		System.out.println("       TURN-BASED COMBAT ARENA            ");
		System.out.println("=====================================");
		System.out.println("Loading game assets...");
	}
	
	@Override
	public int promptDifficultySelection() {
		System.out.println("\nSelect Difficulty:");
		System.out.println("1. Easy");
		System.out.println("2. Medium");
		System.out.println("3. Hard");
		System.out.print("Enter choice (1-3): ");
		return scanner.nextInt(); 
	}

	@Override
	public int promptCharacterSelection() {
		System.out.println("\nSelect Character Class:");
		System.out.println("1. Warrior");
		System.out.println("2. Wizard");
		System.out.print("Enter choice (1-2): ");
		return scanner.nextInt();
	}

	@Override
	public List<String> promptItemSelection() {
		List<String> selectedItems = new ArrayList<>();
		System.out.println("\nSelect 2 Starting Items (Duplicates allowed):");
		System.out.println("1. Potion (Heals HP)");
		System.out.println("2. Power Stone (Boosts next attack)");
		System.out.println("3. Smoke Bomb (Dodges next attack)");
		
		for (int i = 1; i <= 2; i++) {
			System.out.print("Choose Item " + i + " (1-3): ");
			int choice = scanner.nextInt();
			if (choice == 1) selectedItems.add("Potion");
			else if (choice == 2) selectedItems.add("Power Stone");
			else if (choice == 3) selectedItems.add("Smoke Bomb");
		}
		return selectedItems;
	}

	@Override
	public void displayBattleState(Combatants player, List<Combatants> enemies, int roundNumber) {
		System.out.println("\n--- ROUND " + roundNumber + " ---");
		System.out.println("Player HP: " + player.getHp() + " / " + player.getMaxHp());
		System.out.println("Enemies Alive:");
		
		for (int i = 0; i < enemies.size(); i++) {
			Combatants enemy = enemies.get(i);
			if (enemy.isAlive()) {
				 System.out.println(" - Enemy " + (i+1) + " HP: " + enemy.getHp());
			}
		}
	}

	@Override
	public int promptPlayerAction() {
		System.out.println("\nChoose Action:");
		System.out.println("1. Basic Attack");
		System.out.println("2. Defend");
		System.out.println("3. Use Item");
		System.out.println("4. Special Skill");
		System.out.print("Enter choice (1-4): ");
		return scanner.nextInt();
	}

	@Override
	public void displayVictoryScreen(int remainingHp, int totalRounds) {
		System.out.println("\nVICTORY! Enemies defeated in " + totalRounds + " rounds.");
	}

	@Override
	public void displayDefeatScreen(int enemiesRemaining, int totalRounds) {
		System.out.println("\nDEFEAT... " + enemiesRemaining + " enemies were too strong.");
	}

	@Override
	public void displayMessage(String message) {
		System.out.println(message);
	}

	@Override
	public void endOfBattleReport(BattleState gameState) {
		System.out.println("\n--- Final Battle Report Generated ---");
	}

	@Override
	public void display(TurnSummary turnSummary) {
		System.out.println("\nTurn Summary: " + turnSummary.toString());
	}

	@Override
	public void display(Wave wave) {
		System.out.println("\nWave Incoming!");
	}

	@Override
	public void display(BattleState gamestate) {
		System.out.println("\nRound updated in BattleState.");
	}
}