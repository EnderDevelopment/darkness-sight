package com.enderdevelopment.plugin;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public final class Main extends JavaPlugin {
    private final Set<UUID> managedPlayers = new HashSet<>();

    @Override
    public void onEnable() {
        Bukkit.getScheduler().runTaskTimer(this, this::updatePlayers, 1L, 20L);
    }

    @Override
    public void onDisable() {
        for (UUID id : managedPlayers) {
            Player player = Bukkit.getPlayer(id);
            if (player != null) {
                player.removePotionEffect(PotionEffectType.NIGHT_VISION);
            }
        }
        managedPlayers.clear();
    }

    private void updatePlayers() {
        for (Player player : Bukkit.getOnlinePlayers()) {
            boolean dark = player.getLocation().getBlock().getLightLevel() <= 7;
            PotionEffect current = player.getPotionEffect(PotionEffectType.NIGHT_VISION);

            if (dark) {
                if (current == null || current.getDuration() <= 40 || managedPlayers.contains(player.getUniqueId())) {
                    player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 240, 0, true, false, true));
                    managedPlayers.add(player.getUniqueId());
                }
            } else if (managedPlayers.remove(player.getUniqueId())) {
                player.removePotionEffect(PotionEffectType.NIGHT_VISION);
            }
        }
    }
}
