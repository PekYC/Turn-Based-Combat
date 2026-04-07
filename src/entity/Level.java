package entity;

import java.util.ArrayList;
import java.util.List;

public class Level {

    public enum Difficulty { EASY, MEDIUM, HARD }

    private final Difficulty difficulty;
    private final List<Combatants> initialWave;
    private final List<Combatants> backupWave;

    private Level(Difficulty difficulty, List<Combatants> initial, List<Combatants> backup) {
        this.difficulty = difficulty;
        this.initialWave = initial;
        this.backupWave = backup;
    }

    public static Level easy() {
        List<Combatants> initial = new ArrayList<>();
        initial.add(new entity.Goblin("A"));
        initial.add(new entity.Goblin("B"));
        initial.add(new entity.Goblin("C"));
        return new Level(Difficulty.EASY, initial, new ArrayList<>());
    }

    public static Level medium() {
        List<Combatants> initial = new ArrayList<>();
        initial.add(new entity.Goblin("A"));
        initial.add(new entity.Wolf("A"));
        List<Combatants> backup = new ArrayList<>();
        backup.add(new entity.Wolf("B"));
        backup.add(new entity.Wolf("C"));
        return new Level(Difficulty.MEDIUM, initial, backup);
    }

    public static Level hard() {
        List<Combatants> initial = new ArrayList<>();
        initial.add(new entity.Goblin("A"));
        initial.add(new entity.Goblin("B"));
        List<Combatants> backup = new ArrayList<>();
        backup.add(new entity.Goblin("C"));
        backup.add(new entity.Wolf("A"));
        backup.add(new entity.Wolf("B"));
        return new Level(Difficulty.HARD, initial, backup);
    }

    public static Level fromDifficulty(Difficulty d) {
        return switch (d) {
            case EASY   -> easy();
            case MEDIUM -> medium();
            case HARD   -> hard();
        };
    }

    public Difficulty getDifficulty()          { return difficulty; }
    public List<Combatants> getInitialWave()   { return initialWave; }
    public List<Combatants> getBackupWave()    { return backupWave; }
    public boolean hasBackupWave()             { return !backupWave.isEmpty(); }
}
