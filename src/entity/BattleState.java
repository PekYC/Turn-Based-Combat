package entity;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import entity.levels.Level;

public class BattleState {
    private Integer roundCount = 1;
    private Level level;
    private Queue<Wave> waveQueue;
    private Wave activeWave;
    private Combatant player;
    
    public BattleState(Level l, Combatant player) {
        this.level = l;
        this.waveQueue = new LinkedList<>(level.getWaves());
        this.activeWave = waveQueue.poll();
        this.player = player;
    }

    public void incrementRound() {
        roundCount++;
    }
    
    public BattleStatus getStatus() {
        if (!player.isAlive()) {
            return BattleStatus.DEFEATED;
        }
        
        if (activeWave == null || activeWave.isDefeated()) {
            if (waveQueue.isEmpty()) {
                return BattleStatus.VICTORY;
            } else {
                return BattleStatus.WAVE_CLEARED;
            }
        }
        
        return BattleStatus.CONTINUE;
    }
    
    public void spawnNextWave() {
        if (!waveQueue.isEmpty()) {
            this.activeWave = waveQueue.poll();
        }
    }

    public List<Combatant> getAllCombatants() {
        List<Combatant> all = new ArrayList<>();
        if (player.isAlive()) {
            all.add(player);
        }
        all.addAll(getActiveEnemies());
        return all;
    }
         
    public Combatant getPlayer() {
        return player;
    }
    
    public Wave getActiveWave() {
        return activeWave;
    }
    
    public List<Combatant> getActiveEnemies() {
        if (activeWave == null) {
            return new ArrayList<>();
        }
        return activeWave.getEnemies();
    }

    public int getRoundCount() {
        return roundCount;
    }
}
