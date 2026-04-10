package boundary;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import entity.Combatant;
import entity.Wave;
import entity.BattleState;
import entity.TurnSummary;
import entity.Warrior;
import entity.Wizard;
import entity.Item;
import entity.Player;
import entity.Potion;
import entity.PowerStone;
import entity.SmokeBomb;
import entity.actions.Action;
import entity.actions.BasicAttack;
import entity.actions.DefendSkill;
import entity.actions.ShieldBash;
import entity.actions.ArcaneBlastAction;
import entity.ActionType;

public class CLI_UI implements UserInterface {
	
	private Scanner scanner;
	
	public CLI_UI() {
		this.scanner = new Scanner(System.in);
	}
	
	@Override
	public void displayLoadingScreen() {
		System.out.println("=========================================");
		System.out.println("      TURN-BASED COMBAT ARENA            ");
		System.out.println("=========================================");
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
	public Player promptCharacterSelection() {
		System.out.println("\nSelect Character Class:");
		System.out.println("1. Warrior");
		System.out.println("2. Wizard");
		System.out.print("Enter choice (1-2): ");
		
		int choice = scanner.nextInt();
		
		if (choice == 1) {
			return new Warrior(); 
		} else {
			return new Wizard();
		}
	}

	@Override
	public List<Item> promptItemSelection() {
		// FIXED: Now holds Item objects instead of Strings
		List<Item> selectedItems = new ArrayList<>(); 
		System.out.println("\nSelect 2 Starting Items (Duplicates allowed):");
		System.out.println("1. Potion (Heals HP)");
		System.out.println("2. Power Stone (Boosts next attack)");
		System.out.println("3. Smoke Bomb (Dodges next attack)");
		
		for (int i = 1; i <= 2; i++) {
			System.out.print("Choose Item " + i + " (1-3): ");
			int choice = scanner.nextInt();
			
			// FIXED: Creating the actual objects now
			if (choice == 1) selectedItems.add(new Potion());
			else if (choice == 2) selectedItems.add(new PowerStone());
			else if (choice == 3) selectedItems.add(new SmokeBomb());
		}
		return selectedItems;
	}

	@Override
	public Action promptAction(Combatant player, BattleState state) {
		System.out.println("\n--- PLAYER TURN: " + player.getName() + " ---");
		System.out.println("HP: " + player.getHp() + "/" + player.getMaxHp() + " | CD: " + player.getSpecialCooldown());
		System.out.println("Choose Action:");
		System.out.println("1. Basic Attack");
		System.out.println("2. Defend");
		System.out.println("3. Special Skill");
		System.out.print("Enter choice (1-3): ");
		
		int choice = scanner.nextInt();
		return switch (choice) {
			case 2 -> new DefendSkill();
			case 3 -> (player instanceof Warrior) ? new ShieldBash() : new ArcaneBlastAction();
			default -> new BasicAttack();
		};
	}

	@Override
	public List<Combatant> promptTargets(Action action, Combatant player, BattleState state) {
		if (action instanceof DefendSkill) {
			return List.of(player);
		}

		List<Combatant> enemies = state.getActiveEnemies();
		System.out.println("\nSelect Target:");
		for (int i = 0; i < enemies.size(); i++) {
			Combatant e = enemies.get(i);
			if (e.isAlive()) {
				System.out.println((i + 1) + ". " + e.getName() + " (HP: " + e.getHp() + ")");
			}
		}
		System.out.print("Enter choice: ");
		int choice = scanner.nextInt();
		return List.of(enemies.get(choice - 1));
	}

	@Override
	public void displayMessage(String message) {
		System.out.println(message);
	}

	@Override
	public void endOfBattleReport(BattleState state) {
		System.out.println("\n[Battle Report] Ending game state recorded.");
		if (state.getPlayer().isAlive()) {
			System.out.println("Final Result: VICTORY");
		} else {
			System.out.println("Final Result: DEFEAT");
		}
	}

	@Override
	public void display(TurnSummary turnSummary) {
		if (turnSummary.getActionType() == ActionType.STUNNED_SKIP) {
			System.out.println("\n" + turnSummary.getAttackerName() + " is stunned and skips their turn!");
			return;
		}

		String output = String.format("%s → %s → %s: HP: %d → %d (dmg: %d-%d=%d)",
			turnSummary.getAttackerName(),
			turnSummary.getActionType(),
			turnSummary.getTargetName(),
			turnSummary.getInitialHP(),
			turnSummary.getFinalHP(),
			turnSummary.getRawDamage(),
			turnSummary.getMitigatedAmount(),
			turnSummary.getDamageDealt()
		);
		
		System.out.println("\nTurn Summary: " + output);
	}

	@Override
	public void display(Wave wave) {
		List<Combatant> waveEnemies = wave.getEnemies();
		StringBuilder enemyInfo = new StringBuilder();

		for (int i = 0; i < waveEnemies.size(); i++) {
			Combatant e = waveEnemies.get(i);
			enemyInfo.append(e.getName()).append(" (HP: ").append(e.getHp()).append(")");
			
			if (i < waveEnemies.size() - 1) {
				enemyInfo.append(" + ");
			}
		}

		System.out.println("\nAll initial enemies eliminated → Backup Spawn triggered! " 
				   + enemyInfo + " enter simultaneously"); 
	}

	@Override
	public void display(BattleState state) {
		System.out.println("\n--- ROUND " + state.getRoundCount() + " ---");
		System.out.println("Round state updated.");
	}
}